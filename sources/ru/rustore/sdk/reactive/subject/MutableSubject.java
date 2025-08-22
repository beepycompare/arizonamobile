package ru.rustore.sdk.reactive.subject;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.reactive.backpressure.BackpressureStrategy;
import ru.rustore.sdk.reactive.backpressure.processor.BufferDropOldestEmitProcessor;
import ru.rustore.sdk.reactive.backpressure.processor.BufferEmitProcessor;
import ru.rustore.sdk.reactive.backpressure.processor.BufferEmitProcessorFactoryKt;
import ru.rustore.sdk.reactive.core.Disposable;
import ru.rustore.sdk.reactive.observable.Observable;
import ru.rustore.sdk.reactive.observable.ObservableObserver;
/* compiled from: MutableSubject.kt */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u001cB\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lru/rustore/sdk/reactive/subject/MutableSubject;", ExifInterface.GPS_DIRECTION_TRUE, "Lru/rustore/sdk/reactive/subject/Subject;", "replayCount", "", "bufferSize", "(II)V", "downstream", "ru/rustore/sdk/reactive/subject/MutableSubject$downstream$1", "Lru/rustore/sdk/reactive/subject/MutableSubject$downstream$1;", "observers", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lru/rustore/sdk/reactive/backpressure/processor/BufferEmitProcessor;", "processor", "Lru/rustore/sdk/reactive/backpressure/processor/BufferDropOldestEmitProcessor;", "replayBuffer", "Lkotlin/collections/ArrayDeque;", "replayBufferMonitor", "", "emit", "", "item", "(Ljava/lang/Object;)V", "fillBuffer", "observe", "Lru/rustore/sdk/reactive/observable/Observable;", "backpressureStrategy", "Lru/rustore/sdk/reactive/backpressure/BackpressureStrategy;", "SubjectObservable", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MutableSubject<T> implements Subject<T> {
    private final MutableSubject$downstream$1 downstream;
    private final CopyOnWriteArraySet<BufferEmitProcessor<T>> observers;
    private final BufferDropOldestEmitProcessor<T> processor;
    private final ArrayDeque<T> replayBuffer;
    private final Object replayBufferMonitor;
    private final int replayCount;

    public MutableSubject() {
        this(0, 0, 3, null);
    }

    /* JADX WARN: Type inference failed for: r7v4, types: [ru.rustore.sdk.reactive.subject.MutableSubject$downstream$1] */
    public MutableSubject(int i, int i2) {
        this.replayCount = i;
        this.replayBufferMonitor = new Object();
        this.replayBuffer = new ArrayDeque<>();
        this.observers = new CopyOnWriteArraySet<>();
        ObservableObserver<T> observableObserver = new ObservableObserver<T>(this) { // from class: ru.rustore.sdk.reactive.subject.MutableSubject$downstream$1
            final /* synthetic */ MutableSubject<T> this$0;

            @Override // ru.rustore.sdk.reactive.observable.ObservableObserver
            public void onComplete() {
            }

            @Override // ru.rustore.sdk.reactive.observable.ObservableObserver
            public void onError(Throwable e) {
                Intrinsics.checkNotNullParameter(e, "e");
            }

            @Override // ru.rustore.sdk.reactive.observable.ObservableObserver
            public void onSubscribe(Disposable d) {
                Intrinsics.checkNotNullParameter(d, "d");
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // ru.rustore.sdk.reactive.observable.ObservableObserver
            public void onNext(T t) {
                for (BufferEmitProcessor bufferEmitProcessor : ((MutableSubject) this.this$0).observers) {
                    bufferEmitProcessor.emit(t);
                    bufferEmitProcessor.drain();
                }
            }
        };
        this.downstream = observableObserver;
        this.processor = new BufferDropOldestEmitProcessor<>(observableObserver, i2, null, 4, null);
    }

    public /* synthetic */ MutableSubject(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 128 : i2);
    }

    public final void emit(T t) {
        fillBuffer(t);
        this.processor.emit(t);
        this.processor.drain();
    }

    @Override // ru.rustore.sdk.reactive.subject.Subject
    public Observable<T> observe(BackpressureStrategy backpressureStrategy) {
        Intrinsics.checkNotNullParameter(backpressureStrategy, "backpressureStrategy");
        return new SubjectObservable(this, backpressureStrategy);
    }

    private final void fillBuffer(T t) {
        if (this.replayCount == 0) {
            return;
        }
        synchronized (this.replayBufferMonitor) {
            if (this.replayBuffer.size() >= this.replayCount) {
                this.replayBuffer.removeFirstOrNull();
            }
            this.replayBuffer.addLast(t);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MutableSubject.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lru/rustore/sdk/reactive/subject/MutableSubject$SubjectObservable;", "Lru/rustore/sdk/reactive/observable/Observable;", "backpressureStrategy", "Lru/rustore/sdk/reactive/backpressure/BackpressureStrategy;", "(Lru/rustore/sdk/reactive/subject/MutableSubject;Lru/rustore/sdk/reactive/backpressure/BackpressureStrategy;)V", "subscribe", "", "downstream", "Lru/rustore/sdk/reactive/observable/ObservableObserver;", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class SubjectObservable extends Observable<T> {
        private final BackpressureStrategy backpressureStrategy;
        final /* synthetic */ MutableSubject<T> this$0;

        public SubjectObservable(MutableSubject mutableSubject, BackpressureStrategy backpressureStrategy) {
            Intrinsics.checkNotNullParameter(backpressureStrategy, "backpressureStrategy");
            this.this$0 = mutableSubject;
            this.backpressureStrategy = backpressureStrategy;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [ru.rustore.sdk.reactive.subject.MutableSubject$SubjectObservable$subscribe$subjectObservableDisposable$1] */
        @Override // ru.rustore.sdk.reactive.observable.Observable
        public void subscribe(ObservableObserver<T> downstream) {
            BufferEmitProcessor createBufferEmitProcessor$default;
            Intrinsics.checkNotNullParameter(downstream, "downstream");
            final MutableSubject<T> mutableSubject = this.this$0;
            ?? r0 = new Disposable() { // from class: ru.rustore.sdk.reactive.subject.MutableSubject$SubjectObservable$subscribe$subjectObservableDisposable$1
                private final AtomicBoolean disposed = new AtomicBoolean();
                private final AtomicReference<BufferEmitProcessor<T>> emitProcessorRef = new AtomicReference<>(null);

                public final void attach(BufferEmitProcessor<T> emitProcessor) {
                    Intrinsics.checkNotNullParameter(emitProcessor, "emitProcessor");
                    MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.emitProcessorRef, null, emitProcessor);
                    if (this.disposed.get()) {
                        disposeInternal();
                    }
                }

                @Override // ru.rustore.sdk.reactive.core.Disposable
                public boolean isDisposed() {
                    return this.disposed.get();
                }

                @Override // ru.rustore.sdk.reactive.core.Disposable
                public void dispose() {
                    if (this.disposed.compareAndSet(false, true)) {
                        disposeInternal();
                    }
                }

                private final void disposeInternal() {
                    BufferEmitProcessor bufferEmitProcessor = (BufferEmitProcessor) this.emitProcessorRef.getAndSet(null);
                    if (bufferEmitProcessor != null) {
                        bufferEmitProcessor.dispose();
                        ((MutableSubject) mutableSubject).observers.remove(bufferEmitProcessor);
                    }
                }
            };
            downstream.onSubscribe((Disposable) r0);
            if (((MutableSubject) this.this$0).replayCount != 0) {
                Object obj = ((MutableSubject) this.this$0).replayBufferMonitor;
                MutableSubject<T> mutableSubject2 = this.this$0;
                synchronized (obj) {
                    createBufferEmitProcessor$default = BufferEmitProcessorFactoryKt.createBufferEmitProcessor$default(this.backpressureStrategy, downstream, null, 2, null);
                    createBufferEmitProcessor$default.emitAll(CollectionsKt.toList(((MutableSubject) mutableSubject2).replayBuffer));
                    ((MutableSubject) mutableSubject2).observers.add(createBufferEmitProcessor$default);
                }
            } else {
                createBufferEmitProcessor$default = BufferEmitProcessorFactoryKt.createBufferEmitProcessor$default(this.backpressureStrategy, downstream, null, 2, null);
                ((MutableSubject) this.this$0).observers.add(createBufferEmitProcessor$default);
            }
            r0.attach(createBufferEmitProcessor$default);
            createBufferEmitProcessor$default.drain();
        }
    }
}
