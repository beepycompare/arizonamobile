package io.reactivex.internal.operators.flowable;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes3.dex */
public final class FlowableBufferTimed<T, U extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, U> {
    final Callable<U> bufferSupplier;
    final int maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;

    public FlowableBufferTimed(Flowable<T> flowable, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable, int i, boolean z) {
        super(flowable);
        this.timespan = j;
        this.timeskip = j2;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.bufferSupplier = callable;
        this.maxSize = i;
        this.restartTimerOnMaxSize = z;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super U> subscriber) {
        if (this.timespan == this.timeskip && this.maxSize == Integer.MAX_VALUE) {
            this.source.subscribe((FlowableSubscriber) new BufferExactUnboundedSubscriber(new SerializedSubscriber(subscriber), this.bufferSupplier, this.timespan, this.unit, this.scheduler));
            return;
        }
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        if (this.timespan == this.timeskip) {
            this.source.subscribe((FlowableSubscriber) new BufferExactBoundedSubscriber(new SerializedSubscriber(subscriber), this.bufferSupplier, this.timespan, this.unit, this.maxSize, this.restartTimerOnMaxSize, createWorker));
        } else {
            this.source.subscribe((FlowableSubscriber) new BufferSkipBoundedSubscriber(new SerializedSubscriber(subscriber), this.bufferSupplier, this.timespan, this.timeskip, this.unit, createWorker));
        }
    }

    /* loaded from: classes3.dex */
    static final class BufferExactUnboundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {
        U buffer;
        final Callable<U> bufferSupplier;
        final Scheduler scheduler;
        final AtomicReference<Disposable> timer;
        final long timespan;
        final TimeUnit unit;
        Subscription upstream;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        public /* bridge */ /* synthetic */ boolean accept(Subscriber subscriber, Object obj) {
            return accept((Subscriber<? super Subscriber>) subscriber, (Subscriber) ((Collection) obj));
        }

        BufferExactUnboundedSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(subscriber, new MpscLinkedQueue());
            this.timer = new AtomicReference<>();
            this.bufferSupplier = callable;
            this.timespan = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                try {
                    this.buffer = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");
                    this.downstream.onSubscribe(this);
                    if (!this.cancelled) {
                        subscription.request(Long.MAX_VALUE);
                        Scheduler scheduler = this.scheduler;
                        long j = this.timespan;
                        Disposable schedulePeriodicallyDirect = scheduler.schedulePeriodicallyDirect(this, j, j, this.unit);
                        if (MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.timer, null, schedulePeriodicallyDirect)) {
                            return;
                        }
                        schedulePeriodicallyDirect.dispose();
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    EmptySubscription.error(th, this.downstream);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            synchronized (this) {
                U u = this.buffer;
                if (u != null) {
                    u.add(t);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.timer);
            synchronized (this) {
                this.buffer = null;
            }
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            DisposableHelper.dispose(this.timer);
            synchronized (this) {
                U u = this.buffer;
                if (u == null) {
                    return;
                }
                this.buffer = null;
                this.queue.offer(u);
                this.done = true;
                if (enter()) {
                    QueueDrainHelper.drainMaxLoop(this.queue, this.downstream, false, null, this);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            DisposableHelper.dispose(this.timer);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");
                synchronized (this) {
                    U u2 = this.buffer;
                    if (u2 == null) {
                        return;
                    }
                    this.buffer = u;
                    fastPathEmitMax(u2, false, this);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                this.downstream.onError(th);
            }
        }

        public boolean accept(Subscriber<? super U> subscriber, U u) {
            this.downstream.onNext(u);
            return true;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.timer.get() == DisposableHelper.DISPOSED;
        }
    }

    /* loaded from: classes3.dex */
    static final class BufferSkipBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable {
        final Callable<U> bufferSupplier;
        final List<U> buffers;
        final long timeskip;
        final long timespan;
        final TimeUnit unit;
        Subscription upstream;
        final Scheduler.Worker w;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        public /* bridge */ /* synthetic */ boolean accept(Subscriber subscriber, Object obj) {
            return accept((Subscriber<? super Subscriber>) subscriber, (Subscriber) ((Collection) obj));
        }

        BufferSkipBoundedSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker) {
            super(subscriber, new MpscLinkedQueue());
            this.bufferSupplier = callable;
            this.timespan = j;
            this.timeskip = j2;
            this.unit = timeUnit;
            this.w = worker;
            this.buffers = new LinkedList();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                try {
                    Collection collection = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");
                    this.buffers.add(collection);
                    this.downstream.onSubscribe(this);
                    subscription.request(Long.MAX_VALUE);
                    Scheduler.Worker worker = this.w;
                    long j = this.timeskip;
                    worker.schedulePeriodically(this, j, j, this.unit);
                    this.w.schedule(new RemoveFromBuffer(collection), this.timespan, this.unit);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.w.dispose();
                    subscription.cancel();
                    EmptySubscription.error(th, this.downstream);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            synchronized (this) {
                for (U u : this.buffers) {
                    u.add(t);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.done = true;
            this.w.dispose();
            clear();
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            ArrayList<Collection> arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.buffers);
                this.buffers.clear();
            }
            for (Collection collection : arrayList) {
                this.queue.offer(collection);
            }
            this.done = true;
            if (enter()) {
                QueueDrainHelper.drainMaxLoop(this.queue, this.downstream, false, this.w, this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.w.dispose();
            clear();
        }

        void clear() {
            synchronized (this) {
                this.buffers.clear();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled) {
                return;
            }
            try {
                Collection collection = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");
                synchronized (this) {
                    if (this.cancelled) {
                        return;
                    }
                    this.buffers.add(collection);
                    this.w.schedule(new RemoveFromBuffer(collection), this.timespan, this.unit);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                this.downstream.onError(th);
            }
        }

        public boolean accept(Subscriber<? super U> subscriber, U u) {
            subscriber.onNext(u);
            return true;
        }

        /* loaded from: classes3.dex */
        final class RemoveFromBuffer implements Runnable {
            private final U buffer;

            RemoveFromBuffer(U u) {
                this.buffer = u;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (BufferSkipBoundedSubscriber.this) {
                    BufferSkipBoundedSubscriber.this.buffers.remove(this.buffer);
                }
                BufferSkipBoundedSubscriber bufferSkipBoundedSubscriber = BufferSkipBoundedSubscriber.this;
                bufferSkipBoundedSubscriber.fastPathOrderedEmitMax(this.buffer, false, bufferSkipBoundedSubscriber.w);
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class BufferExactBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {
        U buffer;
        final Callable<U> bufferSupplier;
        long consumerIndex;
        final int maxSize;
        long producerIndex;
        final boolean restartTimerOnMaxSize;
        Disposable timer;
        final long timespan;
        final TimeUnit unit;
        Subscription upstream;
        final Scheduler.Worker w;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        public /* bridge */ /* synthetic */ boolean accept(Subscriber subscriber, Object obj) {
            return accept((Subscriber<? super Subscriber>) subscriber, (Subscriber) ((Collection) obj));
        }

        BufferExactBoundedSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, long j, TimeUnit timeUnit, int i, boolean z, Scheduler.Worker worker) {
            super(subscriber, new MpscLinkedQueue());
            this.bufferSupplier = callable;
            this.timespan = j;
            this.unit = timeUnit;
            this.maxSize = i;
            this.restartTimerOnMaxSize = z;
            this.w = worker;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                try {
                    this.buffer = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");
                    this.downstream.onSubscribe(this);
                    Scheduler.Worker worker = this.w;
                    long j = this.timespan;
                    this.timer = worker.schedulePeriodically(this, j, j, this.unit);
                    subscription.request(Long.MAX_VALUE);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.w.dispose();
                    subscription.cancel();
                    EmptySubscription.error(th, this.downstream);
                }
            }
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0078 -> B:42:0x0075). Please submit an issue!!! */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            Throwable th;
            U u;
            synchronized (this) {
                try {
                    u = this.buffer;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                    } catch (Throwable th3) {
                        th = th3;
                        throw r8;
                    }
                    throw r8;
                }
                try {
                    if (u == null) {
                        return;
                    }
                    u.add(t);
                    if (u.size() < this.maxSize) {
                        return;
                    }
                    this.buffer = null;
                    this.producerIndex++;
                    if (this.restartTimerOnMaxSize) {
                        this.timer.dispose();
                    }
                    fastPathOrderedEmitMax(u, false, this);
                    try {
                        U u2 = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");
                        synchronized (this) {
                            try {
                                this.buffer = u2;
                                this.consumerIndex++;
                            } finally {
                                th = th;
                                while (true) {
                                    th = th;
                                    try {
                                        break;
                                    } catch (Throwable th4) {
                                        th = th4;
                                    }
                                }
                            }
                        }
                        if (this.restartTimerOnMaxSize) {
                            Scheduler.Worker worker = this.w;
                            long j = this.timespan;
                            this.timer = worker.schedulePeriodically(this, j, j, this.unit);
                        }
                    } catch (Throwable th5) {
                        Exceptions.throwIfFatal(th5);
                        cancel();
                        this.downstream.onError(th5);
                    }
                } catch (Throwable th6) {
                    Throwable th7 = th6;
                    throw th7;
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            synchronized (this) {
                this.buffer = null;
            }
            this.downstream.onError(th);
            this.w.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            U u;
            synchronized (this) {
                u = this.buffer;
                this.buffer = null;
            }
            if (u != null) {
                this.queue.offer(u);
                this.done = true;
                if (enter()) {
                    QueueDrainHelper.drainMaxLoop(this.queue, this.downstream, false, this, this);
                }
                this.w.dispose();
            }
        }

        public boolean accept(Subscriber<? super U> subscriber, U u) {
            subscriber.onNext(u);
            return true;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            synchronized (this) {
                this.buffer = null;
            }
            this.upstream.cancel();
            this.w.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.w.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");
                synchronized (this) {
                    U u2 = this.buffer;
                    if (u2 != null && this.producerIndex == this.consumerIndex) {
                        this.buffer = u;
                        fastPathOrderedEmitMax(u2, false, this);
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                this.downstream.onError(th);
            }
        }
    }
}
