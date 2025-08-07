package ru.rustore.sdk.reactive.observable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.reactive.backpressure.BackpressureStrategy;
import ru.rustore.sdk.reactive.backpressure.processor.BufferEmitProcessor;
import ru.rustore.sdk.reactive.backpressure.processor.BufferEmitProcessorFactoryKt;
import ru.rustore.sdk.reactive.core.Disposable;
/* compiled from: ObservableCombineLatest.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0002\u0018\u0000 $2\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u00012\u00020\u0005:\u0001$B+\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0014\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\b0\u0001\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u001e\u0010 \u001a\u00020\u00182\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0016J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0005H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\b0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\b0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lru/rustore/sdk/reactive/observable/CombineCollector;", "Lru/rustore/sdk/reactive/observable/ObservableObserver;", "Lkotlin/Pair;", "", "", "Lru/rustore/sdk/reactive/core/Disposable;", "collectorSize", "downstream", "", "backpressureStrategy", "Lru/rustore/sdk/reactive/backpressure/BackpressureStrategy;", "(ILru/rustore/sdk/reactive/observable/ObservableObserver;Lru/rustore/sdk/reactive/backpressure/BackpressureStrategy;)V", "completeCountLeft", "Ljava/util/concurrent/atomic/AtomicInteger;", "disposed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "emitProcessor", "Lru/rustore/sdk/reactive/backpressure/processor/BufferEmitProcessor;", "results", "[Ljava/lang/Object;", "upstreamDisposables", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/util/concurrent/atomic/AtomicReference;", "dispose", "", "disposeUpstreams", "isDisposed", "", "onComplete", "onError", "e", "", "onNext", "item", "onSubscribe", "d", "Companion", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes5.dex */
final class CombineCollector implements ObservableObserver<Pair<? extends Integer, ? extends Object>>, Disposable {
    private static final Companion Companion = new Companion(null);
    private static final Object NULL = new Object();
    private final AtomicInteger completeCountLeft;
    private final AtomicBoolean disposed;
    private final ObservableObserver<Object[]> downstream;
    private final BufferEmitProcessor<Object[]> emitProcessor;
    private final Object[] results;
    private final CopyOnWriteArraySet<AtomicReference<Disposable>> upstreamDisposables;

    public CombineCollector(int i, ObservableObserver<Object[]> downstream, BackpressureStrategy backpressureStrategy) {
        Intrinsics.checkNotNullParameter(downstream, "downstream");
        Intrinsics.checkNotNullParameter(backpressureStrategy, "backpressureStrategy");
        this.downstream = downstream;
        this.disposed = new AtomicBoolean();
        this.upstreamDisposables = new CopyOnWriteArraySet<>();
        this.completeCountLeft = new AtomicInteger(i);
        Object[] objArr = new Object[i];
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = NULL;
        }
        this.results = objArr;
        this.emitProcessor = BufferEmitProcessorFactoryKt.createBufferEmitProcessor$default(backpressureStrategy, this.downstream, null, 2, null);
    }

    @Override // ru.rustore.sdk.reactive.observable.ObservableObserver
    public /* bridge */ /* synthetic */ void onNext(Pair<? extends Integer, ? extends Object> pair) {
        onNext2((Pair<Integer, ? extends Object>) pair);
    }

    @Override // ru.rustore.sdk.reactive.observable.ObservableObserver
    public void onSubscribe(Disposable d) {
        Disposable andSet;
        Intrinsics.checkNotNullParameter(d, "d");
        AtomicReference<Disposable> atomicReference = new AtomicReference<>(d);
        this.upstreamDisposables.add(atomicReference);
        if (isDisposed() && (andSet = atomicReference.getAndSet(null)) != null) {
            andSet.dispose();
        }
        this.downstream.onSubscribe(this);
    }

    @Override // ru.rustore.sdk.reactive.observable.ObservableObserver
    public void onComplete() {
        if (this.completeCountLeft.decrementAndGet() == 0 && this.disposed.compareAndSet(false, true)) {
            synchronized (this) {
                this.emitProcessor.complete();
                Unit unit = Unit.INSTANCE;
            }
            this.emitProcessor.drain();
        }
    }

    @Override // ru.rustore.sdk.reactive.observable.ObservableObserver
    public void onError(Throwable e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (this.disposed.compareAndSet(false, true)) {
            this.emitProcessor.error(e);
            disposeUpstreams();
            this.emitProcessor.drain();
        }
    }

    /* renamed from: onNext  reason: avoid collision after fix types in other method */
    public void onNext2(Pair<Integer, ? extends Object> item) {
        Intrinsics.checkNotNullParameter(item, "item");
        synchronized (this) {
            int intValue = item.component1().intValue();
            Object component2 = item.component2();
            Object[] objArr = this.results;
            objArr[intValue] = component2;
            int length = objArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (Intrinsics.areEqual(objArr[i], NULL)) {
                        break;
                    }
                    i++;
                } else {
                    BufferEmitProcessor<Object[]> bufferEmitProcessor = this.emitProcessor;
                    Object[] objArr2 = this.results;
                    Object[] copyOf = Arrays.copyOf(objArr2, objArr2.length);
                    Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                    bufferEmitProcessor.emit(copyOf);
                    break;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        this.emitProcessor.drain();
    }

    @Override // ru.rustore.sdk.reactive.core.Disposable
    public boolean isDisposed() {
        return this.disposed.get();
    }

    @Override // ru.rustore.sdk.reactive.core.Disposable
    public void dispose() {
        if (this.disposed.compareAndSet(false, true)) {
            disposeUpstreams();
            this.emitProcessor.dispose();
        }
    }

    private final void disposeUpstreams() {
        Iterator<T> it = this.upstreamDisposables.iterator();
        while (it.hasNext()) {
            Disposable disposable = (Disposable) ((AtomicReference) it.next()).getAndSet(null);
            if (disposable != null) {
                disposable.dispose();
            }
        }
    }

    /* compiled from: ObservableCombineLatest.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lru/rustore/sdk/reactive/observable/CombineCollector$Companion;", "", "()V", "NULL", "getNULL", "()Ljava/lang/Object;", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Object getNULL() {
            return CombineCollector.NULL;
        }
    }
}
