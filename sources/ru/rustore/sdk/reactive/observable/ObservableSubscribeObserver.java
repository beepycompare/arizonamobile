package ru.rustore.sdk.reactive.observable;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.reactive.core.Disposable;
/* compiled from: ObservableSubscribe.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B;\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\u000bJ\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u0015\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0003H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lru/rustore/sdk/reactive/observable/ObservableSubscribeObserver;", ExifInterface.GPS_DIRECTION_TRUE, "Lru/rustore/sdk/reactive/observable/ObservableObserver;", "Lru/rustore/sdk/reactive/core/Disposable;", "onErrorCallback", "Lkotlin/Function1;", "", "", "onCompleteCallback", "Lkotlin/Function0;", "onNextCallback", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "disposed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "upstreamDisposable", "Ljava/util/concurrent/atomic/AtomicReference;", "dispose", "isDisposed", "", "onComplete", "onError", "e", "onNext", "item", "(Ljava/lang/Object;)V", "onSubscribe", "d", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes5.dex */
final class ObservableSubscribeObserver<T> implements ObservableObserver<T>, Disposable {
    private final AtomicBoolean disposed;
    private final Function0<Unit> onCompleteCallback;
    private final Function1<Throwable, Unit> onErrorCallback;
    private final Function1<T, Unit> onNextCallback;
    private final AtomicReference<Disposable> upstreamDisposable;

    /* JADX WARN: Multi-variable type inference failed */
    public ObservableSubscribeObserver(Function1<? super Throwable, Unit> onErrorCallback, Function0<Unit> onCompleteCallback, Function1<? super T, Unit> onNextCallback) {
        Intrinsics.checkNotNullParameter(onErrorCallback, "onErrorCallback");
        Intrinsics.checkNotNullParameter(onCompleteCallback, "onCompleteCallback");
        Intrinsics.checkNotNullParameter(onNextCallback, "onNextCallback");
        this.onErrorCallback = onErrorCallback;
        this.onCompleteCallback = onCompleteCallback;
        this.onNextCallback = onNextCallback;
        this.disposed = new AtomicBoolean();
        this.upstreamDisposable = new AtomicReference<>(null);
    }

    @Override // ru.rustore.sdk.reactive.observable.ObservableObserver
    public void onSubscribe(Disposable d) {
        Disposable andSet;
        Intrinsics.checkNotNullParameter(d, "d");
        MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.upstreamDisposable, null, d);
        if (!isDisposed() || (andSet = this.upstreamDisposable.getAndSet(null)) == null) {
            return;
        }
        andSet.dispose();
    }

    @Override // ru.rustore.sdk.reactive.observable.ObservableObserver
    public void onComplete() {
        if (this.disposed.compareAndSet(false, true)) {
            this.onCompleteCallback.invoke();
        }
    }

    @Override // ru.rustore.sdk.reactive.observable.ObservableObserver
    public void onError(Throwable e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (this.disposed.compareAndSet(false, true)) {
            this.onErrorCallback.invoke(e);
        }
    }

    @Override // ru.rustore.sdk.reactive.observable.ObservableObserver
    public void onNext(T t) {
        if (isDisposed()) {
            return;
        }
        this.onNextCallback.invoke(t);
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
