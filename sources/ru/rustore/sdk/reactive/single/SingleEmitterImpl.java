package ru.rustore.sdk.reactive.single;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.reactive.core.Disposable;
/* compiled from: SingleEmitterImpl.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0015\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lru/rustore/sdk/reactive/single/SingleEmitterImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Lru/rustore/sdk/reactive/single/SingleEmitter;", "Lru/rustore/sdk/reactive/core/Disposable;", "downstream", "Lru/rustore/sdk/reactive/single/SingleObserver;", "(Lru/rustore/sdk/reactive/single/SingleObserver;)V", "disposed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onFinishReference", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlin/Function0;", "", "dispose", "error", "", "isDisposed", "", "onFinish", "block", FirebaseAnalytics.Param.SUCCESS, "value", "(Ljava/lang/Object;)V", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SingleEmitterImpl<T> implements SingleEmitter<T>, Disposable {
    private final AtomicBoolean disposed;
    private final SingleObserver<T> downstream;
    private final AtomicReference<Function0<Unit>> onFinishReference;

    public SingleEmitterImpl(SingleObserver<T> downstream) {
        Intrinsics.checkNotNullParameter(downstream, "downstream");
        this.downstream = downstream;
        this.disposed = new AtomicBoolean();
        this.onFinishReference = new AtomicReference<>(null);
    }

    @Override // ru.rustore.sdk.reactive.single.SingleEmitter
    public void success(T t) {
        if (this.disposed.compareAndSet(false, true)) {
            Function0<Unit> function0 = this.onFinishReference.get();
            if (function0 != null) {
                function0.invoke();
            }
            this.downstream.onSuccess(t);
        }
    }

    @Override // ru.rustore.sdk.reactive.single.SingleEmitter
    public void error(Throwable error) {
        Intrinsics.checkNotNullParameter(error, "error");
        if (this.disposed.compareAndSet(false, true)) {
            Function0<Unit> function0 = this.onFinishReference.get();
            if (function0 != null) {
                function0.invoke();
            }
            this.downstream.onError(error);
        }
    }

    @Override // ru.rustore.sdk.reactive.single.SingleEmitter
    public void onFinish(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (!isDisposed()) {
            this.onFinishReference.set(block);
        } else {
            block.invoke();
        }
    }

    @Override // ru.rustore.sdk.reactive.single.SingleEmitter, ru.rustore.sdk.reactive.core.Disposable
    public boolean isDisposed() {
        return this.disposed.get();
    }

    @Override // ru.rustore.sdk.reactive.core.Disposable
    public void dispose() {
        Function0<Unit> function0;
        if (!this.disposed.compareAndSet(false, true) || (function0 = this.onFinishReference.get()) == null) {
            return;
        }
        function0.invoke();
    }
}
