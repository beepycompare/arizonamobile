package ru.rustore.sdk.reactive.single;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.reactive.core.Disposable;
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SingleOnErrorReturn.kt */
@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0015\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"ru/rustore/sdk/reactive/single/SingleOnErrorReturn$subscribe$wrappedObserver$1", "Lru/rustore/sdk/reactive/single/SingleObserver;", "Lru/rustore/sdk/reactive/core/Disposable;", "disposed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "upstreamDisposable", "Ljava/util/concurrent/atomic/AtomicReference;", "dispose", "", "isDisposed", "", "onError", "e", "", "onSubscribe", "d", "onSuccess", "item", "(Ljava/lang/Object;)V", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SingleOnErrorReturn$subscribe$wrappedObserver$1<T> implements SingleObserver<T>, Disposable {
    final /* synthetic */ SingleObserver<T> $downstream;
    final /* synthetic */ SingleOnErrorReturn<T> this$0;
    private final AtomicBoolean disposed = new AtomicBoolean();
    private final AtomicReference<Disposable> upstreamDisposable = new AtomicReference<>(null);

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingleOnErrorReturn$subscribe$wrappedObserver$1(SingleObserver<T> singleObserver, SingleOnErrorReturn<T> singleOnErrorReturn) {
        this.$downstream = singleObserver;
        this.this$0 = singleOnErrorReturn;
    }

    @Override // ru.rustore.sdk.reactive.single.SingleObserver
    public void onSubscribe(Disposable d) {
        Intrinsics.checkNotNullParameter(d, "d");
        this.$downstream.onSubscribe(d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ru.rustore.sdk.reactive.single.SingleObserver
    public void onError(Throwable e) {
        Object m9919constructorimpl;
        Function1 function1;
        Intrinsics.checkNotNullParameter(e, "e");
        if (this.disposed.compareAndSet(false, true)) {
            try {
                Result.Companion companion = Result.Companion;
                function1 = ((SingleOnErrorReturn) this.this$0).mapper;
                m9919constructorimpl = Result.m9919constructorimpl(function1.invoke(e));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m9919constructorimpl = Result.m9919constructorimpl(ResultKt.createFailure(th));
            }
            SingleObserver<T> singleObserver = this.$downstream;
            if (Result.m9926isSuccessimpl(m9919constructorimpl)) {
                singleObserver.onSuccess(m9919constructorimpl);
            }
            SingleObserver<T> singleObserver2 = this.$downstream;
            Throwable m9922exceptionOrNullimpl = Result.m9922exceptionOrNullimpl(m9919constructorimpl);
            if (m9922exceptionOrNullimpl != null) {
                singleObserver2.onError(m9922exceptionOrNullimpl);
            }
        }
    }

    @Override // ru.rustore.sdk.reactive.single.SingleObserver
    public void onSuccess(T t) {
        if (this.disposed.compareAndSet(false, true)) {
            this.$downstream.onSuccess(t);
        }
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
