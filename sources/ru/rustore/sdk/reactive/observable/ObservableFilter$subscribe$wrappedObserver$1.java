package ru.rustore.sdk.reactive.observable;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.reactive.core.Disposable;
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ObservableFilter.kt */
@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0015\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"ru/rustore/sdk/reactive/observable/ObservableFilter$subscribe$wrappedObserver$1", "Lru/rustore/sdk/reactive/observable/ObservableObserver;", "Lru/rustore/sdk/reactive/core/Disposable;", "disposed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "upstreamDisposable", "Ljava/util/concurrent/atomic/AtomicReference;", "dispose", "", "isDisposed", "", "onComplete", "onError", "e", "", "onNext", "item", "(Ljava/lang/Object;)V", "onSubscribe", "d", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ObservableFilter$subscribe$wrappedObserver$1<T> implements ObservableObserver<T>, Disposable {
    final /* synthetic */ ObservableObserver<T> $downstream;
    final /* synthetic */ ObservableFilter<T> this$0;
    private final AtomicBoolean disposed = new AtomicBoolean();
    private final AtomicReference<Disposable> upstreamDisposable = new AtomicReference<>(null);

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObservableFilter$subscribe$wrappedObserver$1(ObservableObserver<T> observableObserver, ObservableFilter<T> observableFilter) {
        this.$downstream = observableObserver;
        this.this$0 = observableFilter;
    }

    @Override // ru.rustore.sdk.reactive.observable.ObservableObserver
    public void onSubscribe(Disposable d) {
        Disposable andSet;
        Intrinsics.checkNotNullParameter(d, "d");
        MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.upstreamDisposable, null, d);
        if (isDisposed() && (andSet = this.upstreamDisposable.getAndSet(null)) != null) {
            andSet.dispose();
        }
        this.$downstream.onSubscribe(this);
    }

    @Override // ru.rustore.sdk.reactive.observable.ObservableObserver
    public void onComplete() {
        if (this.disposed.compareAndSet(false, true)) {
            this.$downstream.onComplete();
        }
    }

    @Override // ru.rustore.sdk.reactive.observable.ObservableObserver
    public void onNext(T t) {
        Object m9920constructorimpl;
        Function1 function1;
        ObservableFilter<T> observableFilter = this.this$0;
        try {
            Result.Companion companion = Result.Companion;
            ObservableFilter$subscribe$wrappedObserver$1<T> observableFilter$subscribe$wrappedObserver$1 = this;
            function1 = ((ObservableFilter) observableFilter).predicate;
            m9920constructorimpl = Result.m9920constructorimpl(Boolean.valueOf(((Boolean) function1.invoke(t)).booleanValue()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9920constructorimpl = Result.m9920constructorimpl(ResultKt.createFailure(th));
        }
        ObservableObserver<T> observableObserver = this.$downstream;
        if (Result.m9927isSuccessimpl(m9920constructorimpl)) {
            boolean booleanValue = ((Boolean) m9920constructorimpl).booleanValue();
            if (!isDisposed() && booleanValue) {
                observableObserver.onNext(t);
            }
        }
        ObservableObserver<T> observableObserver2 = this.$downstream;
        Throwable m9923exceptionOrNullimpl = Result.m9923exceptionOrNullimpl(m9920constructorimpl);
        if (m9923exceptionOrNullimpl == null || !this.disposed.compareAndSet(false, true)) {
            return;
        }
        Disposable andSet = this.upstreamDisposable.getAndSet(null);
        if (andSet != null) {
            andSet.dispose();
        }
        observableObserver2.onError(m9923exceptionOrNullimpl);
    }

    @Override // ru.rustore.sdk.reactive.observable.ObservableObserver
    public void onError(Throwable e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (this.disposed.compareAndSet(false, true)) {
            this.$downstream.onError(e);
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
