package ru.rustore.sdk.reactive.single;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.reactive.core.Dispatcher;
import ru.rustore.sdk.reactive.core.Disposable;
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SingleObserveOn.kt */
@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0015\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"ru/rustore/sdk/reactive/single/SingleObserveOn$subscribe$wrappedObserver$1", "Lru/rustore/sdk/reactive/single/SingleObserver;", "Lru/rustore/sdk/reactive/core/Disposable;", "disposed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "upstreamDisposable", "Ljava/util/concurrent/atomic/AtomicReference;", "dispose", "", "isDisposed", "", "onError", "e", "", "onSubscribe", "d", "onSuccess", "item", "(Ljava/lang/Object;)V", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SingleObserveOn$subscribe$wrappedObserver$1<T> implements SingleObserver<T>, Disposable {
    final /* synthetic */ SingleObserver<T> $downstream;
    final /* synthetic */ SingleObserveOn<T> this$0;
    private final AtomicBoolean disposed = new AtomicBoolean();
    private final AtomicReference<Disposable> upstreamDisposable = new AtomicReference<>(null);

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingleObserveOn$subscribe$wrappedObserver$1(SingleObserveOn<T> singleObserveOn, SingleObserver<T> singleObserver) {
        this.this$0 = singleObserveOn;
        this.$downstream = singleObserver;
    }

    @Override // ru.rustore.sdk.reactive.single.SingleObserver
    public void onSubscribe(Disposable d) {
        Dispatcher dispatcher;
        Disposable andSet;
        Intrinsics.checkNotNullParameter(d, "d");
        MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.upstreamDisposable, null, d);
        if (isDisposed() && (andSet = this.upstreamDisposable.getAndSet(null)) != null) {
            andSet.dispose();
        }
        dispatcher = ((SingleObserveOn) this.this$0).dispatcher;
        final SingleObserver<T> singleObserver = this.$downstream;
        dispatcher.execute(new Function0<Unit>() { // from class: ru.rustore.sdk.reactive.single.SingleObserveOn$subscribe$wrappedObserver$1$onSubscribe$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (SingleObserveOn$subscribe$wrappedObserver$1.this.isDisposed()) {
                    return;
                }
                singleObserver.onSubscribe(SingleObserveOn$subscribe$wrappedObserver$1.this);
            }
        });
    }

    @Override // ru.rustore.sdk.reactive.single.SingleObserver
    public void onError(final Throwable e) {
        Dispatcher dispatcher;
        Intrinsics.checkNotNullParameter(e, "e");
        dispatcher = ((SingleObserveOn) this.this$0).dispatcher;
        final SingleObserver<T> singleObserver = this.$downstream;
        dispatcher.execute(new Function0<Unit>() { // from class: ru.rustore.sdk.reactive.single.SingleObserveOn$subscribe$wrappedObserver$1$onError$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AtomicBoolean atomicBoolean;
                atomicBoolean = SingleObserveOn$subscribe$wrappedObserver$1.this.disposed;
                if (atomicBoolean.compareAndSet(false, true)) {
                    singleObserver.onError(e);
                }
            }
        });
    }

    @Override // ru.rustore.sdk.reactive.single.SingleObserver
    public void onSuccess(final T t) {
        Dispatcher dispatcher;
        dispatcher = ((SingleObserveOn) this.this$0).dispatcher;
        final SingleObserver<T> singleObserver = this.$downstream;
        dispatcher.execute(new Function0<Unit>(this) { // from class: ru.rustore.sdk.reactive.single.SingleObserveOn$subscribe$wrappedObserver$1$onSuccess$1
            final /* synthetic */ SingleObserveOn$subscribe$wrappedObserver$1 this$0;

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
                atomicBoolean = this.this$0.disposed;
                if (atomicBoolean.compareAndSet(false, true)) {
                    singleObserver.onSuccess(t);
                }
            }
        });
    }

    @Override // ru.rustore.sdk.reactive.core.Disposable
    public boolean isDisposed() {
        return this.disposed.get();
    }

    @Override // ru.rustore.sdk.reactive.core.Disposable
    public void dispose() {
        Disposable andSet;
        if (!this.disposed.compareAndSet(false, true) || (andSet = this.upstreamDisposable.getAndSet(null)) == null) {
            return;
        }
        andSet.dispose();
    }
}
