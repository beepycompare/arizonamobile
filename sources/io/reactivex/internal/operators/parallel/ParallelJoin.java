package io.reactivex.internal.operators.parallel;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes3.dex */
public final class ParallelJoin<T> extends Flowable<T> {
    final boolean delayErrors;
    final int prefetch;
    final ParallelFlowable<? extends T> source;

    public ParallelJoin(ParallelFlowable<? extends T> parallelFlowable, int i, boolean z) {
        this.source = parallelFlowable;
        this.prefetch = i;
        this.delayErrors = z;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        JoinSubscriptionBase joinSubscription;
        if (this.delayErrors) {
            joinSubscription = new JoinSubscriptionDelayError(subscriber, this.source.parallelism(), this.prefetch);
        } else {
            joinSubscription = new JoinSubscription(subscriber, this.source.parallelism(), this.prefetch);
        }
        subscriber.onSubscribe(joinSubscription);
        this.source.subscribe(joinSubscription.subscribers);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static abstract class JoinSubscriptionBase<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 3100232009247827843L;
        volatile boolean cancelled;
        final Subscriber<? super T> downstream;
        final JoinInnerSubscriber<T>[] subscribers;
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicLong requested = new AtomicLong();
        final AtomicInteger done = new AtomicInteger();

        abstract void drain();

        abstract void onComplete();

        abstract void onError(Throwable th);

        abstract void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t);

        JoinSubscriptionBase(Subscriber<? super T> subscriber, int i, int i2) {
            this.downstream = subscriber;
            JoinInnerSubscriber<T>[] joinInnerSubscriberArr = new JoinInnerSubscriber[i];
            for (int i3 = 0; i3 < i; i3++) {
                joinInnerSubscriberArr[i3] = new JoinInnerSubscriber<>(this, i2);
            }
            this.subscribers = joinInnerSubscriberArr;
            this.done.lazySet(i);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                cleanup();
            }
        }

        void cancelAll() {
            for (JoinInnerSubscriber<T> joinInnerSubscriber : this.subscribers) {
                joinInnerSubscriber.cancel();
            }
        }

        void cleanup() {
            for (JoinInnerSubscriber<T> joinInnerSubscriber : this.subscribers) {
                joinInnerSubscriber.queue = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class JoinSubscription<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = 6312374661811000451L;

        JoinSubscription(Subscriber<? super T> subscriber, int i, int i2) {
            super(subscriber, i, i2);
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.requested.get() != 0) {
                    this.downstream.onNext(t);
                    if (this.requested.get() != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    joinInnerSubscriber.request(1L);
                } else if (!joinInnerSubscriber.getQueue().offer(t)) {
                    cancelAll();
                    MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Queue full?!");
                    if (this.errors.compareAndSet(null, missingBackpressureException)) {
                        this.downstream.onError(missingBackpressureException);
                        return;
                    } else {
                        RxJavaPlugins.onError(missingBackpressureException);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!joinInnerSubscriber.getQueue().offer(t)) {
                cancelAll();
                onError(new MissingBackpressureException("Queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onError(Throwable th) {
            if (this.errors.compareAndSet(null, th)) {
                cancelAll();
                drain();
            } else if (th != this.errors.get()) {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x005e, code lost:
            r16 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0060, code lost:
            if (r12 == false) goto L85;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0062, code lost:
            if (r15 == false) goto L82;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0064, code lost:
            r3.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0067, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drainLoop() {
            boolean z;
            long j;
            boolean z2;
            Object obj;
            JoinInnerSubscriber<T>[] joinInnerSubscriberArr = this.subscribers;
            int length = joinInnerSubscriberArr.length;
            Subscriber<? super T> subscriber = this.downstream;
            int i = 1;
            while (true) {
                long j2 = this.requested.get();
                long j3 = 0;
                while (true) {
                    z = false;
                    if (j3 == j2) {
                        j = 0;
                        break;
                    } else if (this.cancelled) {
                        cleanup();
                        return;
                    } else {
                        Throwable th = this.errors.get();
                        if (th != null) {
                            cleanup();
                            subscriber.onError(th);
                            return;
                        }
                        boolean z3 = this.done.get() == 0;
                        int i2 = 0;
                        z2 = true;
                        while (true) {
                            if (i2 >= joinInnerSubscriberArr.length) {
                                break;
                            }
                            JoinInnerSubscriber<T> joinInnerSubscriber = joinInnerSubscriberArr[i2];
                            j = 0;
                            SimplePlainQueue<T> simplePlainQueue = joinInnerSubscriber.queue;
                            if (simplePlainQueue != null && (obj = (T) simplePlainQueue.poll()) != null) {
                                subscriber.onNext(obj);
                                joinInnerSubscriber.requestOne();
                                j3++;
                                if (j3 == j2) {
                                    break;
                                }
                                z2 = false;
                            }
                            i2++;
                        }
                    }
                    

                    /* loaded from: classes3.dex */
                    static final class JoinSubscriptionDelayError<T> extends JoinSubscriptionBase<T> {
                        private static final long serialVersionUID = -5737965195918321883L;

                        JoinSubscriptionDelayError(Subscriber<? super T> subscriber, int i, int i2) {
                            super(subscriber, i, i2);
                        }

                        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
                        void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t) {
                            if (get() == 0 && compareAndSet(0, 1)) {
                                if (this.requested.get() != 0) {
                                    this.downstream.onNext(t);
                                    if (this.requested.get() != Long.MAX_VALUE) {
                                        this.requested.decrementAndGet();
                                    }
                                    joinInnerSubscriber.request(1L);
                                } else if (!joinInnerSubscriber.getQueue().offer(t)) {
                                    joinInnerSubscriber.cancel();
                                    this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
                                    this.done.decrementAndGet();
                                    drainLoop();
                                    return;
                                }
                                if (decrementAndGet() == 0) {
                                    return;
                                }
                            } else {
                                if (!joinInnerSubscriber.getQueue().offer(t) && joinInnerSubscriber.cancel()) {
                                    this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
                                    this.done.decrementAndGet();
                                }
                                if (getAndIncrement() != 0) {
                                    return;
                                }
                            }
                            drainLoop();
                        }

                        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
                        void onError(Throwable th) {
                            this.errors.addThrowable(th);
                            this.done.decrementAndGet();
                            drain();
                        }

                        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
                        void onComplete() {
                            this.done.decrementAndGet();
                            drain();
                        }

                        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
                        void drain() {
                            if (getAndIncrement() != 0) {
                                return;
                            }
                            drainLoop();
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:25:0x004c, code lost:
                            r16 = 0;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:26:0x004e, code lost:
                            if (r12 == false) goto L85;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:27:0x0050, code lost:
                            if (r15 == false) goto L82;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
                            if (r18.errors.get() == null) goto L80;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:30:0x005c, code lost:
                            r3.onError(r18.errors.terminate());
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:31:0x0065, code lost:
                            return;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:32:0x0066, code lost:
                            r3.onComplete();
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:33:0x0069, code lost:
                            return;
                         */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        void drainLoop() {
                            boolean z;
                            long j;
                            boolean z2;
                            Object obj;
                            JoinInnerSubscriber<T>[] joinInnerSubscriberArr = this.subscribers;
                            int length = joinInnerSubscriberArr.length;
                            Subscriber<? super T> subscriber = this.downstream;
                            int i = 1;
                            while (true) {
                                long j2 = this.requested.get();
                                long j3 = 0;
                                while (true) {
                                    z = false;
                                    if (j3 == j2) {
                                        j = 0;
                                        break;
                                    } else if (this.cancelled) {
                                        cleanup();
                                        return;
                                    } else {
                                        boolean z3 = this.done.get() == 0;
                                        int i2 = 0;
                                        z2 = true;
                                        while (true) {
                                            if (i2 >= length) {
                                                break;
                                            }
                                            JoinInnerSubscriber<T> joinInnerSubscriber = joinInnerSubscriberArr[i2];
                                            j = 0;
                                            SimplePlainQueue<T> simplePlainQueue = joinInnerSubscriber.queue;
                                            if (simplePlainQueue != null && (obj = (T) simplePlainQueue.poll()) != null) {
                                                subscriber.onNext(obj);
                                                joinInnerSubscriber.requestOne();
                                                j3++;
                                                if (j3 == j2) {
                                                    break;
                                                }
                                                z2 = false;
                                            }
                                            i2++;
                                        }
                                    }
                                    

                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* loaded from: classes3.dex */
                                    public static final class JoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
                                        private static final long serialVersionUID = 8410034718427740355L;
                                        final int limit;
                                        final JoinSubscriptionBase<T> parent;
                                        final int prefetch;
                                        long produced;
                                        volatile SimplePlainQueue<T> queue;

                                        JoinInnerSubscriber(JoinSubscriptionBase<T> joinSubscriptionBase, int i) {
                                            this.parent = joinSubscriptionBase;
                                            this.prefetch = i;
                                            this.limit = i - (i >> 2);
                                        }

                                        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
                                        public void onSubscribe(Subscription subscription) {
                                            SubscriptionHelper.setOnce(this, subscription, this.prefetch);
                                        }

                                        @Override // org.reactivestreams.Subscriber
                                        public void onNext(T t) {
                                            this.parent.onNext(this, t);
                                        }

                                        @Override // org.reactivestreams.Subscriber
                                        public void onError(Throwable th) {
                                            this.parent.onError(th);
                                        }

                                        @Override // org.reactivestreams.Subscriber
                                        public void onComplete() {
                                            this.parent.onComplete();
                                        }

                                        public void requestOne() {
                                            long j = this.produced + 1;
                                            if (j == this.limit) {
                                                this.produced = 0L;
                                                get().request(j);
                                                return;
                                            }
                                            this.produced = j;
                                        }

                                        public void request(long j) {
                                            long j2 = this.produced + j;
                                            if (j2 >= this.limit) {
                                                this.produced = 0L;
                                                get().request(j2);
                                                return;
                                            }
                                            this.produced = j2;
                                        }

                                        public boolean cancel() {
                                            return SubscriptionHelper.cancel(this);
                                        }

                                        SimplePlainQueue<T> getQueue() {
                                            SimplePlainQueue<T> simplePlainQueue = this.queue;
                                            if (simplePlainQueue == null) {
                                                SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.prefetch);
                                                this.queue = spscArrayQueue;
                                                return spscArrayQueue;
                                            }
                                            return simplePlainQueue;
                                        }
                                    }
                                }
