package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Continuation.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a9\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\t¢\u0006\u0002\u0010\u0005\u001a4\u0010\n\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\t\u001aO\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u001a\b\u0004\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011H\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\tø\u0001\u0000\u001aQ\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\u0016\u001aj\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u0002*#\b\u0001\u0012\u0004\u0012\u0002H\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0018¢\u0006\u0002\b\u00192\u0006\u0010\u001a\u001a\u0002H\u00172\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\u001b\u001aK\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\u001d\u001ad\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u0002*#\b\u0001\u0012\u0004\u0012\u0002H\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0018¢\u0006\u0002\b\u00192\u0006\u0010\u001a\u001a\u0002H\u00172\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\u001e\u001aP\u0010\u001f\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010 \u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0011H\u0087È\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\t\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010!\".\u0010\"\u001a\u00020\u000f8Æ\u0002X\u0087\u0084\br\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\br\u0002\b\t¢\u0006\f\u0012\u0004\b#\u0010$\u001a\u0004\b%\u0010&\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006'"}, d2 = {"resume", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/Continuation;", "value", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.3", "Lkotlin/internal/InlineOnly;", "resumeWithException", "exception", "", "Continuation", "context", "Lkotlin/coroutines/CoroutineContext;", "resumeWith", "Lkotlin/Function1;", "Lkotlin/Result;", "createCoroutine", "", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "startCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "suspendCoroutine", "block", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coroutineContext", "getCoroutineContext$annotations", "()V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContinuationKt {
    public static /* synthetic */ void getCoroutineContext$annotations() {
    }

    private static final <T> void resume(Continuation<? super T> continuation, T t) {
        Intrinsics.checkNotNullParameter(continuation, "<this>");
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m9919constructorimpl(t));
    }

    private static final <T> void resumeWithException(Continuation<? super T> continuation, Throwable exception) {
        Intrinsics.checkNotNullParameter(continuation, "<this>");
        Intrinsics.checkNotNullParameter(exception, "exception");
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m9919constructorimpl(ResultKt.createFailure(exception)));
    }

    private static final <T> Continuation<T> Continuation(final CoroutineContext context, final Function1<? super Result<? extends T>, Unit> resumeWith) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(resumeWith, "resumeWith");
        return new Continuation<T>() { // from class: kotlin.coroutines.ContinuationKt$Continuation$1
            @Override // kotlin.coroutines.Continuation
            public CoroutineContext getContext() {
                return CoroutineContext.this;
            }

            @Override // kotlin.coroutines.Continuation
            public void resumeWith(Object obj) {
                resumeWith.invoke(Result.m9918boximpl(obj));
            }
        };
    }

    public static final <T> Continuation<Unit> createCoroutine(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new SafeContinuation(IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(function1, completion)), IntrinsicsKt.getCOROUTINE_SUSPENDED());
    }

    public static final <R, T> Continuation<Unit> createCoroutine(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter(function2, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new SafeContinuation(IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(function2, r, completion)), IntrinsicsKt.getCOROUTINE_SUSPENDED());
    }

    public static final <T> void startCoroutine(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        Continuation intercepted = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(function1, completion));
        Unit unit = Unit.INSTANCE;
        Result.Companion companion = Result.Companion;
        intercepted.resumeWith(Result.m9919constructorimpl(unit));
    }

    public static final <R, T> void startCoroutine(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter(function2, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        Continuation intercepted = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(function2, r, completion));
        Unit unit = Unit.INSTANCE;
        Result.Companion companion = Result.Companion;
        intercepted.resumeWith(Result.m9919constructorimpl(unit));
    }

    private static final <T> Object suspendCoroutine(Function1<? super Continuation<? super T>, Unit> function1, Continuation<? super T> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        function1.invoke(safeContinuation);
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private static final CoroutineContext getCoroutineContext() {
        throw new NotImplementedError("Implemented as intrinsic");
    }
}
