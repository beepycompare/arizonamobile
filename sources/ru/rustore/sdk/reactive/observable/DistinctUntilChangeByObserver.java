package ru.rustore.sdk.reactive.observable;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.reactive.core.Disposable;
/* compiled from: ObservableDistinctUntilChangeBy.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0002\u0018\u0000 !*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001!BK\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u00126\u0010\u0005\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\u0002\u0010\fJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0015\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0003H\u0016R>\u0010\u0005\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lru/rustore/sdk/reactive/observable/DistinctUntilChangeByObserver;", ExifInterface.GPS_DIRECTION_TRUE, "Lru/rustore/sdk/reactive/observable/ObservableObserver;", "Lru/rustore/sdk/reactive/core/Disposable;", "downstream", "comparator", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "oldValue", "newValue", "", "(Lru/rustore/sdk/reactive/observable/ObservableObserver;Lkotlin/jvm/functions/Function2;)V", "disposed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "oldProceedValue", "", "getOldProceedValue$annotations", "()V", "upstreamDisposable", "Ljava/util/concurrent/atomic/AtomicReference;", "dispose", "", "isDisposed", "onComplete", "onError", "e", "", "onNext", "item", "(Ljava/lang/Object;)V", "onSubscribe", "d", "Companion", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
final class DistinctUntilChangeByObserver<T> implements ObservableObserver<T>, Disposable {
    private static final Companion Companion = new Companion(null);
    private static final Object NULL = new Object();
    private final Function2<T, T, Boolean> comparator;
    private final AtomicBoolean disposed;
    private final ObservableObserver<T> downstream;
    private volatile Object oldProceedValue;
    private final AtomicReference<Disposable> upstreamDisposable;

    private static /* synthetic */ void getOldProceedValue$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DistinctUntilChangeByObserver(ObservableObserver<T> downstream, Function2<? super T, ? super T, Boolean> comparator) {
        Intrinsics.checkNotNullParameter(downstream, "downstream");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        this.downstream = downstream;
        this.comparator = comparator;
        this.disposed = new AtomicBoolean();
        this.upstreamDisposable = new AtomicReference<>(null);
        this.oldProceedValue = NULL;
    }

    @Override // ru.rustore.sdk.reactive.observable.ObservableObserver
    public void onSubscribe(Disposable d) {
        Disposable andSet;
        Intrinsics.checkNotNullParameter(d, "d");
        MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.upstreamDisposable, null, d);
        if (isDisposed() && (andSet = this.upstreamDisposable.getAndSet(null)) != null) {
            andSet.dispose();
        }
        this.downstream.onSubscribe(this);
    }

    @Override // ru.rustore.sdk.reactive.observable.ObservableObserver
    public void onComplete() {
        if (this.disposed.compareAndSet(false, true)) {
            this.downstream.onComplete();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ru.rustore.sdk.reactive.observable.ObservableObserver
    public void onNext(T t) {
        Object m9920constructorimpl;
        boolean z;
        try {
            Result.Companion companion = Result.Companion;
            DistinctUntilChangeByObserver<T> distinctUntilChangeByObserver = this;
            Object obj = this.oldProceedValue;
            if (Intrinsics.areEqual(obj, NULL)) {
                this.oldProceedValue = t;
                z = true;
            } else {
                boolean booleanValue = ((Boolean) this.comparator.invoke(obj, t)).booleanValue();
                z = !booleanValue;
                if (!booleanValue) {
                    this.oldProceedValue = t;
                }
            }
            m9920constructorimpl = Result.m9920constructorimpl(Boolean.valueOf(z));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9920constructorimpl = Result.m9920constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9927isSuccessimpl(m9920constructorimpl) && ((Boolean) m9920constructorimpl).booleanValue() && !isDisposed()) {
            this.downstream.onNext(t);
        }
        Throwable m9923exceptionOrNullimpl = Result.m9923exceptionOrNullimpl(m9920constructorimpl);
        if (m9923exceptionOrNullimpl == null || !this.disposed.compareAndSet(false, true)) {
            return;
        }
        Disposable andSet = this.upstreamDisposable.getAndSet(null);
        if (andSet != null) {
            andSet.dispose();
        }
        this.downstream.onError(m9923exceptionOrNullimpl);
    }

    @Override // ru.rustore.sdk.reactive.observable.ObservableObserver
    public void onError(Throwable e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (this.disposed.compareAndSet(false, true)) {
            this.downstream.onError(e);
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

    /* compiled from: ObservableDistinctUntilChangeBy.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lru/rustore/sdk/reactive/observable/DistinctUntilChangeByObserver$Companion;", "", "()V", "NULL", "getNULL", "()Ljava/lang/Object;", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes6.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Object getNULL() {
            return DistinctUntilChangeByObserver.NULL;
        }
    }
}
