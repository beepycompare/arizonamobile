package io.reactivex.internal.operators.flowable;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes3.dex */
public final class FlowableFlatMap<T, U> extends AbstractFlowableWithUpstream<T, U> {
    final int bufferSize;
    final boolean delayErrors;
    final Function<? super T, ? extends Publisher<? extends U>> mapper;
    final int maxConcurrency;

    public FlowableFlatMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i, int i2) {
        super(flowable);
        this.mapper = function;
        this.delayErrors = z;
        this.maxConcurrency = i;
        this.bufferSize = i2;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super U> subscriber) {
        if (FlowableScalarXMap.tryScalarXMapSubscribe(this.source, subscriber, this.mapper)) {
            return;
        }
        this.source.subscribe((FlowableSubscriber) subscribe(subscriber, this.mapper, this.delayErrors, this.maxConcurrency, this.bufferSize));
    }

    public static <T, U> FlowableSubscriber<T> subscribe(Subscriber<? super U> subscriber, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i, int i2) {
        return new MergeSubscriber(subscriber, function, z, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class MergeSubscriber<T, U> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -2117620485640801370L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final Subscriber<? super U> downstream;
        final AtomicThrowable errs = new AtomicThrowable();
        long lastId;
        int lastIndex;
        final Function<? super T, ? extends Publisher<? extends U>> mapper;
        final int maxConcurrency;
        volatile SimplePlainQueue<U> queue;
        final AtomicLong requested;
        int scalarEmitted;
        final int scalarLimit;
        final AtomicReference<InnerSubscriber<?, ?>[]> subscribers;
        long uniqueId;
        Subscription upstream;
        static final InnerSubscriber<?, ?>[] EMPTY = new InnerSubscriber[0];
        static final InnerSubscriber<?, ?>[] CANCELLED = new InnerSubscriber[0];

        MergeSubscriber(Subscriber<? super U> subscriber, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i, int i2) {
            AtomicReference<InnerSubscriber<?, ?>[]> atomicReference = new AtomicReference<>();
            this.subscribers = atomicReference;
            this.requested = new AtomicLong();
            this.downstream = subscriber;
            this.mapper = function;
            this.delayErrors = z;
            this.maxConcurrency = i;
            this.bufferSize = i2;
            this.scalarLimit = Math.max(1, i >> 1);
            atomicReference.lazySet(EMPTY);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                if (this.cancelled) {
                    return;
                }
                int i = this.maxConcurrency;
                if (i == Integer.MAX_VALUE) {
                    subscription.request(Long.MAX_VALUE);
                } else {
                    subscription.request(i);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null Publisher");
                if (publisher instanceof Callable) {
                    try {
                        Object call = ((Callable) publisher).call();
                        if (call != null) {
                            tryEmitScalar(call);
                            return;
                        } else if (this.maxConcurrency == Integer.MAX_VALUE || this.cancelled) {
                            return;
                        } else {
                            int i = this.scalarEmitted + 1;
                            this.scalarEmitted = i;
                            int i2 = this.scalarLimit;
                            if (i == i2) {
                                this.scalarEmitted = 0;
                                this.upstream.request(i2);
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.errs.addThrowable(th);
                        drain();
                        return;
                    }
                }
                long j = this.uniqueId;
                this.uniqueId = 1 + j;
                InnerSubscriber innerSubscriber = new InnerSubscriber(this, j);
                if (addInner(innerSubscriber)) {
                    publisher.subscribe(innerSubscriber);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.upstream.cancel();
                onError(th2);
            }
        }

        boolean addInner(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber<?, ?>[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                if (innerSubscriberArr == CANCELLED) {
                    innerSubscriber.dispose();
                    return false;
                }
                int length = innerSubscriberArr.length;
                innerSubscriberArr2 = new InnerSubscriber[length + 1];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
            } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.subscribers, innerSubscriberArr, innerSubscriberArr2));
            return true;
        }

        void removeInner(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber<?, ?>[] innerSubscriberArr;
            InnerSubscriber<?, ?>[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                int length = innerSubscriberArr.length;
                if (length == 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (innerSubscriberArr[i] == innerSubscriber) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerSubscriberArr2 = EMPTY;
                } else {
                    InnerSubscriber<?, ?>[] innerSubscriberArr3 = new InnerSubscriber[length - 1];
                    System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr3, 0, i);
                    System.arraycopy(innerSubscriberArr, i + 1, innerSubscriberArr3, i, (length - i) - 1);
                    innerSubscriberArr2 = innerSubscriberArr3;
                }
            } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.subscribers, innerSubscriberArr, innerSubscriberArr2));
        }

        SimpleQueue<U> getMainQueue() {
            SimplePlainQueue<U> simplePlainQueue = this.queue;
            if (simplePlainQueue == null) {
                if (this.maxConcurrency == Integer.MAX_VALUE) {
                    simplePlainQueue = new SpscLinkedArrayQueue<>(this.bufferSize);
                } else {
                    simplePlainQueue = new SpscArrayQueue<>(this.maxConcurrency);
                }
                this.queue = simplePlainQueue;
            }
            return simplePlainQueue;
        }

        void tryEmitScalar(U u) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j = this.requested.get();
                SimpleQueue<U> simpleQueue = this.queue;
                if (j != 0 && (simpleQueue == null || simpleQueue.isEmpty())) {
                    this.downstream.onNext(u);
                    if (j != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
                        int i = this.scalarEmitted + 1;
                        this.scalarEmitted = i;
                        int i2 = this.scalarLimit;
                        if (i == i2) {
                            this.scalarEmitted = 0;
                            this.upstream.request(i2);
                        }
                    }
                } else {
                    if (simpleQueue == null) {
                        simpleQueue = getMainQueue();
                    }
                    if (!simpleQueue.offer(u)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!getMainQueue().offer(u)) {
                onError(new IllegalStateException("Scalar queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        SimpleQueue<U> getInnerQueue(InnerSubscriber<T, U> innerSubscriber) {
            SimpleQueue<U> simpleQueue = innerSubscriber.queue;
            if (simpleQueue == null) {
                SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.bufferSize);
                innerSubscriber.queue = spscArrayQueue;
                return spscArrayQueue;
            }
            return simpleQueue;
        }

        void tryEmit(U u, InnerSubscriber<T, U> innerSubscriber) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j = this.requested.get();
                SimpleQueue<U> simpleQueue = innerSubscriber.queue;
                if (j != 0 && (simpleQueue == null || simpleQueue.isEmpty())) {
                    this.downstream.onNext(u);
                    if (j != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    innerSubscriber.requestMore(1L);
                } else {
                    if (simpleQueue == null) {
                        simpleQueue = getInnerQueue(innerSubscriber);
                    }
                    if (!simpleQueue.offer(u)) {
                        onError(new MissingBackpressureException("Inner queue full?!"));
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SimpleQueue simpleQueue2 = innerSubscriber.queue;
                if (simpleQueue2 == null) {
                    simpleQueue2 = new SpscArrayQueue(this.bufferSize);
                    innerSubscriber.queue = simpleQueue2;
                }
                if (!simpleQueue2.offer(u)) {
                    onError(new MissingBackpressureException("Inner queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
            } else if (this.errs.addThrowable(th)) {
                this.done = true;
                if (!this.delayErrors) {
                    for (InnerSubscriber<?, ?> innerSubscriber : this.subscribers.getAndSet(CANCELLED)) {
                        innerSubscriber.dispose();
                    }
                }
                drain();
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
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
            SimplePlainQueue<U> simplePlainQueue;
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            disposeAll();
            if (getAndIncrement() != 0 || (simplePlainQueue = this.queue) == null) {
                return;
            }
            simplePlainQueue.clear();
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:49:0x00b2, code lost:
            if (r7[r0].id != r10) goto L138;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drainLoop() {
            boolean z;
            long j;
            long j2;
            boolean z2;
            long j3;
            InnerSubscriber<T, U>[] innerSubscriberArr;
            Subscriber<? super U> subscriber = this.downstream;
            int i = 1;
            while (!checkTerminate()) {
                SimplePlainQueue<U> simplePlainQueue = this.queue;
                long j4 = this.requested.get();
                boolean z3 = j4 == Long.MAX_VALUE;
                long j5 = 0;
                if (simplePlainQueue != null) {
                    j = 0;
                    while (true) {
                        long j6 = 0;
                        Object obj = null;
                        while (true) {
                            if (j4 == 0) {
                                z = true;
                                break;
                            }
                            z = true;
                            U poll = simplePlainQueue.poll();
                            if (checkTerminate()) {
                                return;
                            }
                            if (poll == null) {
                                obj = poll;
                                break;
                            }
                            subscriber.onNext(poll);
                            j++;
                            j6++;
                            j4--;
                            obj = poll;
                        }
                        if (j6 != 0) {
                            j4 = z3 ? Long.MAX_VALUE : this.requested.addAndGet(-j6);
                        }
                        if (j4 == 0 || obj == null) {
                            break;
                        }
                    }
                } else {
                    z = true;
                    j = 0;
                }
                boolean z4 = this.done;
                SimplePlainQueue<U> simplePlainQueue2 = this.queue;
                InnerSubscriber<?, ?>[] innerSubscriberArr2 = this.subscribers.get();
                int length = innerSubscriberArr2.length;
                if (z4 && ((simplePlainQueue2 == null || simplePlainQueue2.isEmpty()) && length == 0)) {
                    Throwable terminate = this.errs.terminate();
                    if (terminate != ExceptionHelper.TERMINATED) {
                        if (terminate == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(terminate);
                            return;
                        }
                    }
                    return;
                }
                if (length != 0) {
                    long j7 = this.lastId;
                    int i2 = this.lastIndex;
                    if (length > i2) {
                        j3 = 1;
                    } else {
                        j3 = 1;
                    }
                    if (length <= i2) {
                        i2 = 0;
                    }
                    for (int i3 = 0; i3 < length && innerSubscriberArr2[i2].id != j7; i3++) {
                        i2++;
                        if (i2 == length) {
                            i2 = 0;
                        }
                    }
                    this.lastIndex = i2;
                    this.lastId = innerSubscriberArr2[i2].id;
                    int i4 = i2;
                    boolean z5 = false;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length) {
                            innerSubscriberArr = innerSubscriberArr2;
                            j2 = j5;
                            break;
                        } else if (checkTerminate()) {
                            return;
                        } else {
                            InnerSubscriber<T, U> innerSubscriber = innerSubscriberArr2[i4];
                            U u = null;
                            while (!checkTerminate()) {
                                SimpleQueue<U> simpleQueue = innerSubscriber.queue;
                                if (simpleQueue == null) {
                                    innerSubscriberArr = innerSubscriberArr2;
                                    j2 = j5;
                                } else {
                                    j2 = j5;
                                    while (j4 != j2) {
                                        try {
                                            u = simpleQueue.poll();
                                            if (u == null) {
                                                break;
                                            }
                                            subscriber.onNext(u);
                                            if (checkTerminate()) {
                                                return;
                                            }
                                            j4 -= j3;
                                            j5 += j3;
                                        } catch (Throwable th) {
                                            Exceptions.throwIfFatal(th);
                                            innerSubscriber.dispose();
                                            this.errs.addThrowable(th);
                                            if (!this.delayErrors) {
                                                this.upstream.cancel();
                                            }
                                            if (checkTerminate()) {
                                                return;
                                            }
                                            removeInner(innerSubscriber);
                                            i5++;
                                            innerSubscriberArr = innerSubscriberArr2;
                                            z5 = z;
                                        }
                                    }
                                    if (j5 != j2) {
                                        if (z3) {
                                            innerSubscriberArr = innerSubscriberArr2;
                                            j4 = Long.MAX_VALUE;
                                        } else {
                                            innerSubscriberArr = innerSubscriberArr2;
                                            j4 = this.requested.addAndGet(-j5);
                                        }
                                        innerSubscriber.requestMore(j5);
                                    } else {
                                        innerSubscriberArr = innerSubscriberArr2;
                                    }
                                    if (j4 != j2 && u != null) {
                                        innerSubscriberArr2 = innerSubscriberArr;
                                        j5 = j2;
                                    }
                                }
                                boolean z6 = innerSubscriber.done;
                                SimpleQueue<U> simpleQueue2 = innerSubscriber.queue;
                                if (z6 && (simpleQueue2 == null || simpleQueue2.isEmpty())) {
                                    removeInner(innerSubscriber);
                                    if (checkTerminate()) {
                                        return;
                                    }
                                    j += j3;
                                    z5 = z;
                                }
                                if (j4 == j2) {
                                    break;
                                }
                                i4++;
                                if (i4 == length) {
                                    i4 = 0;
                                }
                                i5++;
                                innerSubscriberArr2 = innerSubscriberArr;
                                j5 = j2;
                            }
                            return;
                        }
                    }
                    z2 = z5;
                    this.lastIndex = i4;
                    this.lastId = innerSubscriberArr[i4].id;
                } else {
                    j2 = 0;
                    z2 = false;
                }
                long j8 = j;
                if (j8 != j2 && !this.cancelled) {
                    this.upstream.request(j8);
                }
                if (!z2 && (i = addAndGet(-i)) == 0) {
                    return;
                }
            }
        }

        boolean checkTerminate() {
            if (this.cancelled) {
                clearScalarQueue();
                return true;
            } else if (this.delayErrors || this.errs.get() == null) {
                return false;
            } else {
                clearScalarQueue();
                Throwable terminate = this.errs.terminate();
                if (terminate != ExceptionHelper.TERMINATED) {
                    this.downstream.onError(terminate);
                }
                return true;
            }
        }

        void clearScalarQueue() {
            SimplePlainQueue<U> simplePlainQueue = this.queue;
            if (simplePlainQueue != null) {
                simplePlainQueue.clear();
            }
        }

        void disposeAll() {
            InnerSubscriber<?, ?>[] andSet;
            InnerSubscriber<?, ?>[] innerSubscriberArr = this.subscribers.get();
            InnerSubscriber<?, ?>[] innerSubscriberArr2 = CANCELLED;
            if (innerSubscriberArr == innerSubscriberArr2 || (andSet = this.subscribers.getAndSet(innerSubscriberArr2)) == innerSubscriberArr2) {
                return;
            }
            for (InnerSubscriber<?, ?> innerSubscriber : andSet) {
                innerSubscriber.dispose();
            }
            Throwable terminate = this.errs.terminate();
            if (terminate == null || terminate == ExceptionHelper.TERMINATED) {
                return;
            }
            RxJavaPlugins.onError(terminate);
        }

        void innerError(InnerSubscriber<T, U> innerSubscriber, Throwable th) {
            if (this.errs.addThrowable(th)) {
                innerSubscriber.done = true;
                if (!this.delayErrors) {
                    this.upstream.cancel();
                    for (InnerSubscriber<?, ?> innerSubscriber2 : this.subscribers.getAndSet(CANCELLED)) {
                        innerSubscriber2.dispose();
                    }
                }
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class InnerSubscriber<T, U> extends AtomicReference<Subscription> implements FlowableSubscriber<U>, Disposable {
        private static final long serialVersionUID = -4606175640614850599L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;
        final long id;
        final int limit;
        final MergeSubscriber<T, U> parent;
        long produced;
        volatile SimpleQueue<U> queue;

        InnerSubscriber(MergeSubscriber<T, U> mergeSubscriber, long j) {
            this.id = j;
            this.parent = mergeSubscriber;
            int i = mergeSubscriber.bufferSize;
            this.bufferSize = i;
            this.limit = i >> 2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                    }
                }
                subscription.request(this.bufferSize);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(U u) {
            if (this.fusionMode != 2) {
                this.parent.tryEmit(u, this);
            } else {
                this.parent.drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.innerError(this, th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        void requestMore(long j) {
            if (this.fusionMode != 1) {
                long j2 = this.produced + j;
                if (j2 >= this.limit) {
                    this.produced = 0L;
                    get().request(j2);
                    return;
                }
                this.produced = j2;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }
    }
}
