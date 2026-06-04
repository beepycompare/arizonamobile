package kotlin.coroutines;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.NativeProtocol;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SafeContinuationJvm.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u001c*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001\u001cB!\b@\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB\u001b\bQ\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u001a\u0002\b\n¢\u0006\u0004\b\u0007\u0010\tJ\u001d\u0010\u0010\u001a\u00020\u00112\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0081\u0080\u0004b\u0002\b\nJ\f\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0080\u0004J\n\u0010\u001a\u001a\u00020\u001bH\u0096\u0080\u0004R\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u000b\u001a\u00020\f8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017Ê\u0001\u0002\b\nÊ\u0001\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( ¨\u0006\u001d"}, d2 = {"Lkotlin/coroutines/SafeContinuation;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "initialResult", "", "<init>", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "(Lkotlin/coroutines/Continuation;)V", "Lkotlin/PublishedApi;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "result", "resumeWith", "", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "getOrThrow", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "toString", "", "Companion", "kotlin-stdlib", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.3"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SafeContinuation<T> implements Continuation<T>, CoroutineStackFrame {
    private static final Companion Companion = new Companion(null);
    private static final AtomicReferenceFieldUpdater<SafeContinuation<?>, Object> RESULT = AtomicReferenceFieldUpdater.newUpdater(SafeContinuation.class, Object.class, "result");
    private final Continuation<T> delegate;
    private volatile Object result;

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SafeContinuation(Continuation<? super T> delegate, Object obj) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.result = obj;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SafeContinuation(Continuation<? super T> delegate) {
        this(delegate, CoroutineSingletons.UNDECIDED);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.delegate.getContext();
    }

    /* compiled from: SafeContinuationJvm.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003RY\u0010\u0004\u001aF\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0007*\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001 \u0007*\"\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0007*\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00050\u0005X\u0082\u0084\b¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003¨\u0006\t"}, d2 = {"Lkotlin/coroutines/SafeContinuation$Companion;", "", "<init>", "()V", "RESULT", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/coroutines/SafeContinuation;", "kotlin.jvm.PlatformType", "getRESULT$annotations", "kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private static /* synthetic */ void getRESULT$annotations() {
        }

        private Companion() {
        }
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        while (true) {
            Object obj2 = this.result;
            if (obj2 == CoroutineSingletons.UNDECIDED) {
                if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(RESULT, this, CoroutineSingletons.UNDECIDED, obj)) {
                    return;
                }
            } else if (obj2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                throw new IllegalStateException("Already resumed");
            } else {
                if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(RESULT, this, IntrinsicsKt.getCOROUTINE_SUSPENDED(), CoroutineSingletons.RESUMED)) {
                    this.delegate.resumeWith(obj);
                    return;
                }
            }
        }
    }

    public final Object getOrThrow() {
        Object obj = this.result;
        if (obj == CoroutineSingletons.UNDECIDED) {
            if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(RESULT, this, CoroutineSingletons.UNDECIDED, IntrinsicsKt.getCOROUTINE_SUSPENDED())) {
                return IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            obj = this.result;
        }
        if (obj == CoroutineSingletons.RESUMED) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
        return obj;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.delegate;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    public String toString() {
        return "SafeContinuation for " + this.delegate;
    }
}
