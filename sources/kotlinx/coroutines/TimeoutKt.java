package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
/* compiled from: Timeout.kt */
@Metadata(d1 = {"\u0000D\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001aR\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tH\u0086@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\n\u001aT\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u000b\u001a\u00020\f2'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tH\u0086@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\r\u0010\n\u001aG\u0010\u000e\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tH\u0086@¢\u0006\u0002\u0010\n\u001aI\u0010\u000e\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u000b\u001a\u00020\f2'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tH\u0086@¢\u0006\u0004\b\u000f\u0010\n\u001a\\\u0010\u0010\u001a\u0004\u0018\u00010\b\"\u0004\b\u0000\u0010\u0011\"\b\b\u0001\u0010\u0001*\u0002H\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00010\u00132'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tH\u0002¢\u0006\u0002\u0010\u0014\u001a \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u001aH\u0000¨\u0006\u001b"}, d2 = {"withTimeout", ExifInterface.GPS_DIRECTION_TRUE, "timeMillis", "", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "timeout", "Lkotlin/time/Duration;", "withTimeout-KLykuaI", "withTimeoutOrNull", "withTimeoutOrNull-KLykuaI", "setupTimeout", "U", "coroutine", "Lkotlinx/coroutines/TimeoutCoroutine;", "(Lkotlinx/coroutines/TimeoutCoroutine;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "TimeoutCancellationException", "Lkotlinx/coroutines/TimeoutCancellationException;", "time", "delay", "Lkotlinx/coroutines/Delay;", "Lkotlinx/coroutines/Job;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TimeoutKt {
    public static final <T> Object withTimeout(long j, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        if (j <= 0) {
            throw new TimeoutCancellationException("Timed out immediately");
        }
        Object obj = setupTimeout(new TimeoutCoroutine(j, continuation), function2);
        if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return obj;
    }

    /* renamed from: withTimeout-KLykuaI  reason: not valid java name */
    public static final <T> Object m9980withTimeoutKLykuaI(long j, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return withTimeout(DelayKt.m9971toDelayMillisLRDsOJo(j), function2, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007c  */
    /* JADX WARN: Type inference failed for: r4v1, types: [kotlinx.coroutines.TimeoutCoroutine, T] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object withTimeoutOrNull(long j, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        TimeoutKt$withTimeoutOrNull$1 timeoutKt$withTimeoutOrNull$1;
        int i;
        Ref.ObjectRef objectRef;
        if (continuation instanceof TimeoutKt$withTimeoutOrNull$1) {
            timeoutKt$withTimeoutOrNull$1 = (TimeoutKt$withTimeoutOrNull$1) continuation;
            if ((timeoutKt$withTimeoutOrNull$1.label & Integer.MIN_VALUE) != 0) {
                timeoutKt$withTimeoutOrNull$1.label -= Integer.MIN_VALUE;
                Object obj = timeoutKt$withTimeoutOrNull$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = timeoutKt$withTimeoutOrNull$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (j <= 0) {
                        return null;
                    }
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    try {
                        timeoutKt$withTimeoutOrNull$1.L$0 = function2;
                        timeoutKt$withTimeoutOrNull$1.L$1 = objectRef2;
                        timeoutKt$withTimeoutOrNull$1.J$0 = j;
                        timeoutKt$withTimeoutOrNull$1.label = 1;
                        ?? r4 = (T) new TimeoutCoroutine(j, timeoutKt$withTimeoutOrNull$1);
                        objectRef2.element = r4;
                        Object obj2 = setupTimeout(r4, function2);
                        if (obj2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended(timeoutKt$withTimeoutOrNull$1);
                        }
                        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
                    } catch (TimeoutCancellationException e) {
                        e = e;
                        objectRef = objectRef2;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    long j2 = timeoutKt$withTimeoutOrNull$1.J$0;
                    objectRef = (Ref.ObjectRef) timeoutKt$withTimeoutOrNull$1.L$1;
                    Function2 function22 = (Function2) timeoutKt$withTimeoutOrNull$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    } catch (TimeoutCancellationException e2) {
                        e = e2;
                    }
                }
                if (e.coroutine != objectRef.element) {
                    return null;
                }
                throw e;
            }
        }
        timeoutKt$withTimeoutOrNull$1 = new TimeoutKt$withTimeoutOrNull$1(continuation);
        Object obj3 = timeoutKt$withTimeoutOrNull$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = timeoutKt$withTimeoutOrNull$1.label;
        if (i != 0) {
        }
        if (e.coroutine != objectRef.element) {
        }
    }

    /* renamed from: withTimeoutOrNull-KLykuaI  reason: not valid java name */
    public static final <T> Object m9981withTimeoutOrNullKLykuaI(long j, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return withTimeoutOrNull(DelayKt.m9971toDelayMillisLRDsOJo(j), function2, continuation);
    }

    private static final <U, T extends U> Object setupTimeout(TimeoutCoroutine<U, ? super T> timeoutCoroutine, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        JobKt.disposeOnCompletion(timeoutCoroutine, DelayKt.getDelay(timeoutCoroutine.uCont.getContext()).invokeOnTimeout(timeoutCoroutine.time, timeoutCoroutine, timeoutCoroutine.getContext()));
        return UndispatchedKt.startUndispatchedOrReturnIgnoreTimeout(timeoutCoroutine, timeoutCoroutine, function2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0016, code lost:
        if (r4 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final TimeoutCancellationException TimeoutCancellationException(long j, Delay delay, Job job) {
        String str;
        DelayWithTimeoutDiagnostics delayWithTimeoutDiagnostics = delay instanceof DelayWithTimeoutDiagnostics ? (DelayWithTimeoutDiagnostics) delay : null;
        if (delayWithTimeoutDiagnostics != null) {
            Duration.Companion companion = Duration.Companion;
            str = delayWithTimeoutDiagnostics.m9972timeoutMessageLRDsOJo(DurationKt.toDuration(j, DurationUnit.MILLISECONDS));
        }
        str = "Timed out waiting for " + j + " ms";
        return new TimeoutCancellationException(str, job);
    }
}
