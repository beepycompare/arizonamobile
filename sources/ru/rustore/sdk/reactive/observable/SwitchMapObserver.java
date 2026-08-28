package ru.rustore.sdk.reactive.observable;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.reactive.backpressure.BackpressureStrategy;
import ru.rustore.sdk.reactive.backpressure.processor.BufferEmitProcessor;
import ru.rustore.sdk.reactive.backpressure.processor.BufferEmitProcessorFactoryKt;
import ru.rustore.sdk.reactive.core.Disposable;
import ru.rustore.sdk.reactive.observable.SwitchMapObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ObservableSwitchMap.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004:\u0001#B5\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0015\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0004H\u0016R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lru/rustore/sdk/reactive/observable/SwitchMapObserver;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lru/rustore/sdk/reactive/observable/ObservableObserver;", "Lru/rustore/sdk/reactive/core/Disposable;", "downstream", "mapper", "Lkotlin/Function1;", "Lru/rustore/sdk/reactive/observable/Observable;", "backpressureStrategy", "Lru/rustore/sdk/reactive/backpressure/BackpressureStrategy;", "(Lru/rustore/sdk/reactive/observable/ObservableObserver;Lkotlin/jvm/functions/Function1;Lru/rustore/sdk/reactive/backpressure/BackpressureStrategy;)V", "actualSubstream", "Ljava/util/concurrent/atomic/AtomicReference;", "completionsLeftCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "emitProcessor", "Lru/rustore/sdk/reactive/backpressure/processor/BufferEmitProcessor;", "switchMapDisposed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "upstreamDisposable", "dispose", "", "innerOnComplete", "isDisposed", "", "onComplete", "onError", "e", "", "onNext", "item", "(Ljava/lang/Object;)V", "onSubscribe", "d", "SubstreamSubscriber", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SwitchMapObserver<T, R> implements ObservableObserver<T>, Disposable {
    private final AtomicReference<Disposable> actualSubstream;
    private final AtomicInteger completionsLeftCount;
    private final ObservableObserver<R> downstream;
    private final BufferEmitProcessor<R> emitProcessor;
    private final Function1<T, Observable<R>> mapper;
    private final AtomicBoolean switchMapDisposed;
    private final AtomicReference<Disposable> upstreamDisposable;

    /* JADX WARN: Multi-variable type inference failed */
    public SwitchMapObserver(ObservableObserver<R> downstream, Function1<? super T, ? extends Observable<R>> mapper, BackpressureStrategy backpressureStrategy) {
        Intrinsics.checkNotNullParameter(downstream, "downstream");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        Intrinsics.checkNotNullParameter(backpressureStrategy, "backpressureStrategy");
        this.downstream = downstream;
        this.mapper = mapper;
        this.switchMapDisposed = new AtomicBoolean();
        this.actualSubstream = new AtomicReference<>(null);
        this.upstreamDisposable = new AtomicReference<>(null);
        this.emitProcessor = BufferEmitProcessorFactoryKt.createBufferEmitProcessor$default(backpressureStrategy, downstream, null, 2, null);
        this.completionsLeftCount = new AtomicInteger(1);
    }

    @Override // ru.rustore.sdk.reactive.observable.ObservableObserver
    public void onSubscribe(Disposable d) {
        Disposable andSet;
        Intrinsics.checkNotNullParameter(d, "d");
        MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.upstreamDisposable, null, d);
        if (this.switchMapDisposed.get() && (andSet = this.upstreamDisposable.getAndSet(null)) != null) {
            andSet.dispose();
        }
        this.downstream.onSubscribe(this);
    }

    @Override // ru.rustore.sdk.reactive.observable.ObservableObserver
    public void onComplete() {
        this.completionsLeftCount.decrementAndGet();
        innerOnComplete();
    }

    @Override // ru.rustore.sdk.reactive.observable.ObservableObserver
    public void onError(Throwable e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (this.switchMapDisposed.compareAndSet(false, true)) {
            Disposable andSet = this.actualSubstream.getAndSet(null);
            if (andSet != null) {
                andSet.dispose();
            }
            this.emitProcessor.error(e);
            this.emitProcessor.drain();
        }
    }

    @Override // ru.rustore.sdk.reactive.observable.ObservableObserver
    public void onNext(T t) {
        if (isDisposed()) {
            return;
        }
        this.completionsLeftCount.incrementAndGet();
        SubstreamSubscriber substreamSubscriber = new SubstreamSubscriber();
        Disposable andSet = this.actualSubstream.getAndSet(substreamSubscriber);
        if (andSet != null) {
            andSet.dispose();
        }
        if (isDisposed()) {
            return;
        }
        substreamSubscriber.subscribe(t);
    }

    @Override // ru.rustore.sdk.reactive.core.Disposable
    public void dispose() {
        if (this.switchMapDisposed.compareAndSet(false, true)) {
            Disposable andSet = this.upstreamDisposable.getAndSet(null);
            if (andSet != null) {
                andSet.dispose();
            }
            Disposable andSet2 = this.actualSubstream.getAndSet(null);
            if (andSet2 != null) {
                andSet2.dispose();
            }
        }
    }

    @Override // ru.rustore.sdk.reactive.core.Disposable
    public boolean isDisposed() {
        return this.switchMapDisposed.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void innerOnComplete() {
        if (this.completionsLeftCount.get() == 0 && this.switchMapDisposed.compareAndSet(false, true)) {
            this.emitProcessor.complete();
            this.emitProcessor.drain();
        }
    }

    /* compiled from: ObservableSwitchMap.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001H\u0002J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0013\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lru/rustore/sdk/reactive/observable/SwitchMapObserver$SubstreamSubscriber;", "Lru/rustore/sdk/reactive/core/Disposable;", "(Lru/rustore/sdk/reactive/observable/SwitchMapObserver;)V", "substreamDisposable", "Ljava/util/concurrent/atomic/AtomicReference;", "substreamDisposed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "attachSubstream", "", "d", "dispose", "isDisposed", "", "sendError", "error", "", "subscribe", "item", "(Ljava/lang/Object;)V", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes6.dex */
    private final class SubstreamSubscriber implements Disposable {
        private final AtomicReference<Disposable> substreamDisposable = new AtomicReference<>(null);
        private final AtomicBoolean substreamDisposed = new AtomicBoolean();

        public SubstreamSubscriber() {
        }

        public final void subscribe(T t) {
            Object m9920constructorimpl;
            if (isDisposed()) {
                return;
            }
            SwitchMapObserver<T, R> switchMapObserver = SwitchMapObserver.this;
            try {
                Result.Companion companion = Result.Companion;
                SubstreamSubscriber substreamSubscriber = this;
                m9920constructorimpl = Result.m9920constructorimpl((Observable) ((SwitchMapObserver) switchMapObserver).mapper.invoke(t));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m9920constructorimpl = Result.m9920constructorimpl(ResultKt.createFailure(th));
            }
            final SwitchMapObserver<T, R> switchMapObserver2 = SwitchMapObserver.this;
            if (Result.m9927isSuccessimpl(m9920constructorimpl)) {
                attachSubstream(ObservableSubscribeKt.subscribe((Observable) m9920constructorimpl, new Function1<Throwable, Unit>(this) { // from class: ru.rustore.sdk.reactive.observable.SwitchMapObserver$SubstreamSubscriber$subscribe$2$subDisposable$1
                    final /* synthetic */ SwitchMapObserver<T, R>.SubstreamSubscriber this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                        invoke2(th2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable error) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        this.this$0.sendError(error);
                    }
                }, new Function0<Unit>(this) { // from class: ru.rustore.sdk.reactive.observable.SwitchMapObserver$SubstreamSubscriber$subscribe$2$subDisposable$2
                    final /* synthetic */ SwitchMapObserver<T, R>.SubstreamSubscriber this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        AtomicBoolean atomicBoolean;
                        atomicBoolean = ((SwitchMapObserver.SubstreamSubscriber) this.this$0).substreamDisposed;
                        if (atomicBoolean.compareAndSet(false, true)) {
                            ((SwitchMapObserver) switchMapObserver2).completionsLeftCount.decrementAndGet();
                            switchMapObserver2.innerOnComplete();
                        }
                    }
                }, new Function1<R, Unit>(this) { // from class: ru.rustore.sdk.reactive.observable.SwitchMapObserver$SubstreamSubscriber$subscribe$2$subDisposable$3
                    final /* synthetic */ SwitchMapObserver<T, R>.SubstreamSubscriber this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.this$0 = this;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                        invoke2((SwitchMapObserver$SubstreamSubscriber$subscribe$2$subDisposable$3<R>) obj);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(R r) {
                        if (this.this$0.isDisposed()) {
                            return;
                        }
                        ((SwitchMapObserver) switchMapObserver2).emitProcessor.emit(r);
                        ((SwitchMapObserver) switchMapObserver2).emitProcessor.drain();
                    }
                }));
            }
            Throwable m9923exceptionOrNullimpl = Result.m9923exceptionOrNullimpl(m9920constructorimpl);
            if (m9923exceptionOrNullimpl != null) {
                sendError(m9923exceptionOrNullimpl);
            }
        }

        @Override // ru.rustore.sdk.reactive.core.Disposable
        public boolean isDisposed() {
            return this.substreamDisposed.get();
        }

        @Override // ru.rustore.sdk.reactive.core.Disposable
        public void dispose() {
            if (this.substreamDisposed.compareAndSet(false, true)) {
                ((SwitchMapObserver) SwitchMapObserver.this).completionsLeftCount.decrementAndGet();
                Disposable andSet = this.substreamDisposable.getAndSet(null);
                if (andSet != null) {
                    andSet.dispose();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void sendError(Throwable th) {
            if (this.substreamDisposed.compareAndSet(false, true) && ((SwitchMapObserver) SwitchMapObserver.this).switchMapDisposed.compareAndSet(false, true)) {
                Disposable andSet = this.substreamDisposable.getAndSet(null);
                if (andSet != null) {
                    andSet.dispose();
                }
                ((SwitchMapObserver) SwitchMapObserver.this).emitProcessor.error(th);
                ((SwitchMapObserver) SwitchMapObserver.this).emitProcessor.drain();
            }
        }

        private final void attachSubstream(Disposable disposable) {
            Disposable andSet;
            MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.substreamDisposable, null, disposable);
            if (!isDisposed() || (andSet = this.substreamDisposable.getAndSet(null)) == null) {
                return;
            }
            andSet.dispose();
        }
    }
}
