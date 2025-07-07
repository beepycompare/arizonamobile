package ru.rustore.sdk.core.util;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
/* compiled from: WithTimeoutOrThrow.kt */
@Metadata(d1 = {"\u00004\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ab\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00052'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\n¢\u0006\u0002\b\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"withTimeoutOrThrow", ExifInterface.GPS_DIRECTION_TRUE, "timeMillis", "", "exceptionFactory", "Lkotlin/Function1;", "Lkotlinx/coroutines/TimeoutCancellationException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sdk-public-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WithTimeoutOrThrowKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object withTimeoutOrThrow(long j, Function1<? super TimeoutCancellationException, ? extends Exception> function1, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        WithTimeoutOrThrowKt$withTimeoutOrThrow$1 withTimeoutOrThrowKt$withTimeoutOrThrow$1;
        int i;
        try {
            if (continuation instanceof WithTimeoutOrThrowKt$withTimeoutOrThrow$1) {
                withTimeoutOrThrowKt$withTimeoutOrThrow$1 = (WithTimeoutOrThrowKt$withTimeoutOrThrow$1) continuation;
                if ((withTimeoutOrThrowKt$withTimeoutOrThrow$1.label & Integer.MIN_VALUE) != 0) {
                    withTimeoutOrThrowKt$withTimeoutOrThrow$1.label -= Integer.MIN_VALUE;
                    Object obj = withTimeoutOrThrowKt$withTimeoutOrThrow$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = withTimeoutOrThrowKt$withTimeoutOrThrow$1.label;
                    if (i == 0) {
                        if (i == 1) {
                            Function1 function12 = (Function1) withTimeoutOrThrowKt$withTimeoutOrThrow$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    withTimeoutOrThrowKt$withTimeoutOrThrow$1.L$0 = function1;
                    withTimeoutOrThrowKt$withTimeoutOrThrow$1.label = 1;
                    Object withTimeout = TimeoutKt.withTimeout(j, function2, withTimeoutOrThrowKt$withTimeoutOrThrow$1);
                    return withTimeout == coroutine_suspended ? coroutine_suspended : withTimeout;
                }
            }
            if (i == 0) {
            }
        } catch (TimeoutCancellationException e) {
            throw function1.invoke(e);
        }
        withTimeoutOrThrowKt$withTimeoutOrThrow$1 = new WithTimeoutOrThrowKt$withTimeoutOrThrow$1(continuation);
        Object obj2 = withTimeoutOrThrowKt$withTimeoutOrThrow$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = withTimeoutOrThrowKt$withTimeoutOrThrow$1.label;
    }

    public static /* synthetic */ Object withTimeoutOrThrow$default(long j, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<TimeoutCancellationException, TimeoutCancellationException>() { // from class: ru.rustore.sdk.core.util.WithTimeoutOrThrowKt$withTimeoutOrThrow$2
                @Override // kotlin.jvm.functions.Function1
                public final TimeoutCancellationException invoke(TimeoutCancellationException it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it;
                }
            };
        }
        return withTimeoutOrThrow(j, function1, function2, continuation);
    }
}
