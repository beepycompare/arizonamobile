package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.arizona.launcher.UpdateActivity;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;
/* compiled from: DispatchedTask.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u001a \u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f2\u0006\u0010\u0010\u001a\u00020\u0001H\u0000\u001a.\u0010\u0011\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0000\u001a\u0010\u0010\u0015\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000fH\u0002\u001a'\u0010\u0016\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u001aH\u0080\b\u001a\u0019\u0010\u001b\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u001c\u001a\u00020\u001dH\u0080\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0018\u0010\b\u001a\u00020\t*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\n\"\u0018\u0010\u000b\u001a\u00020\t*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\n¨\u0006\u001e"}, d2 = {"MODE_ATOMIC", "", "MODE_CANCELLABLE", "getMODE_CANCELLABLE$annotations", "()V", "MODE_CANCELLABLE_REUSABLE", "MODE_UNDISPATCHED", "MODE_UNINITIALIZED", "isCancellableMode", "", "(I)Z", "isReusableMode", "dispatch", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/DispatchedTask;", UpdateActivity.UPDATE_MODE, "resume", "delegate", "Lkotlin/coroutines/Continuation;", "undispatched", "resumeUnconfined", "runUnconfinedEventLoop", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "block", "Lkotlin/Function0;", "resumeWithStackTrace", "exception", "", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DispatchedTaskKt {
    public static final int MODE_ATOMIC = 0;
    public static final int MODE_CANCELLABLE = 1;
    public static final int MODE_CANCELLABLE_REUSABLE = 2;
    public static final int MODE_UNDISPATCHED = 4;
    public static final int MODE_UNINITIALIZED = -1;

    public static /* synthetic */ void getMODE_CANCELLABLE$annotations() {
    }

    public static final boolean isCancellableMode(int i) {
        return i == 1 || i == 2;
    }

    public static final boolean isReusableMode(int i) {
        return i == 2;
    }

    public static final <T> void dispatch(DispatchedTask<? super T> dispatchedTask, int i) {
        if (DebugKt.getASSERTIONS_ENABLED() && i == -1) {
            throw new AssertionError();
        }
        Continuation<? super T> delegate$kotlinx_coroutines_core = dispatchedTask.getDelegate$kotlinx_coroutines_core();
        boolean z = i == 4;
        if (!z && (delegate$kotlinx_coroutines_core instanceof DispatchedContinuation) && isCancellableMode(i) == isCancellableMode(dispatchedTask.resumeMode)) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) delegate$kotlinx_coroutines_core;
            CoroutineDispatcher coroutineDispatcher = dispatchedContinuation.dispatcher;
            CoroutineContext context = dispatchedContinuation.getContext();
            if (DispatchedContinuationKt.safeIsDispatchNeeded(coroutineDispatcher, context)) {
                DispatchedContinuationKt.safeDispatch(coroutineDispatcher, context, dispatchedTask);
                return;
            } else {
                resumeUnconfined(dispatchedTask);
                return;
            }
        }
        resume(dispatchedTask, delegate$kotlinx_coroutines_core, z);
    }

    public static final <T> void resume(DispatchedTask<? super T> dispatchedTask, Continuation<? super T> continuation, boolean z) {
        Object successfulResult$kotlinx_coroutines_core;
        Object takeState$kotlinx_coroutines_core = dispatchedTask.takeState$kotlinx_coroutines_core();
        Throwable exceptionalResult$kotlinx_coroutines_core = dispatchedTask.getExceptionalResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
        if (exceptionalResult$kotlinx_coroutines_core != null) {
            Result.Companion companion = Result.Companion;
            successfulResult$kotlinx_coroutines_core = ResultKt.createFailure(exceptionalResult$kotlinx_coroutines_core);
        } else {
            Result.Companion companion2 = Result.Companion;
            successfulResult$kotlinx_coroutines_core = dispatchedTask.getSuccessfulResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
        }
        Object m8471constructorimpl = Result.m8471constructorimpl(successfulResult$kotlinx_coroutines_core);
        if (z) {
            Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            Continuation<T> continuation2 = dispatchedContinuation.continuation;
            Object obj = dispatchedContinuation.countOrElement;
            CoroutineContext context = continuation2.getContext();
            Object updateThreadContext = ThreadContextKt.updateThreadContext(context, obj);
            UndispatchedCoroutine<?> updateUndispatchedCompletion = updateThreadContext != ThreadContextKt.NO_THREAD_ELEMENTS ? CoroutineContextKt.updateUndispatchedCompletion(continuation2, context, updateThreadContext) : null;
            try {
                dispatchedContinuation.continuation.resumeWith(m8471constructorimpl);
                Unit unit = Unit.INSTANCE;
                if (updateUndispatchedCompletion == null || updateUndispatchedCompletion.clearThreadContext()) {
                    ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                    return;
                }
                return;
            } catch (Throwable th) {
                if (updateUndispatchedCompletion == null || updateUndispatchedCompletion.clearThreadContext()) {
                    ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                }
                throw th;
            }
        }
        continuation.resumeWith(m8471constructorimpl);
    }

    private static final void resumeUnconfined(DispatchedTask<?> dispatchedTask) {
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedTask);
            return;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            resume(dispatchedTask, dispatchedTask.getDelegate$kotlinx_coroutines_core(), true);
            do {
            } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
        } finally {
            try {
            } finally {
            }
        }
    }

    public static final void runUnconfinedEventLoop(DispatchedTask<?> dispatchedTask, EventLoop eventLoop, Function0<Unit> function0) {
        eventLoop.incrementUseCount(true);
        try {
            function0.invoke();
            do {
            } while (eventLoop.processUnconfinedEvent());
        } catch (Throwable th) {
            try {
                dispatchedTask.handleFatalException$kotlinx_coroutines_core(th);
            } finally {
                eventLoop.decrementUseCount(true);
            }
        }
    }

    public static final void resumeWithStackTrace(Continuation<?> continuation, Throwable th) {
        Result.Companion companion = Result.Companion;
        if (DebugKt.getRECOVER_STACK_TRACES() && (continuation instanceof CoroutineStackFrame)) {
            th = StackTraceRecoveryKt.recoverFromStackFrame(th, (CoroutineStackFrame) continuation);
        }
        continuation.resumeWith(Result.m8471constructorimpl(ResultKt.createFailure(th)));
    }
}
