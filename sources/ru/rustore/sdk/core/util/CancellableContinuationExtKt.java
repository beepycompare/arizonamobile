package ru.rustore.sdk.core.util;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
/* compiled from: CancellableContinuationExt.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\u001a#\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0005\u001a\u001e\u0010\u0006\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"resumeIfActive", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CancellableContinuation;", "value", "(Lkotlinx/coroutines/CancellableContinuation;Ljava/lang/Object;)V", "resumeWithExceptionIfActive", "error", "", "sdk-public-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CancellableContinuationExtKt {
    public static final <T> void resumeIfActive(CancellableContinuation<? super T> cancellableContinuation, T t) {
        Intrinsics.checkNotNullParameter(cancellableContinuation, "<this>");
        if (cancellableContinuation.isActive()) {
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m8471constructorimpl(t));
        }
    }

    public static final <T> void resumeWithExceptionIfActive(CancellableContinuation<? super T> cancellableContinuation, Throwable error) {
        Intrinsics.checkNotNullParameter(cancellableContinuation, "<this>");
        Intrinsics.checkNotNullParameter(error, "error");
        if (cancellableContinuation.isActive()) {
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m8471constructorimpl(ResultKt.createFailure(error)));
        }
    }
}
