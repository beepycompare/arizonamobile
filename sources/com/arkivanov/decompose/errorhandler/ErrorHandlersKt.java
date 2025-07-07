package com.arkivanov.decompose.errorhandler;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ErrorHandlers.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\"*\u0010\u0000\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00040\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"onDecomposeError", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "getOnDecomposeError", "()Lkotlin/jvm/functions/Function1;", "setOnDecomposeError", "(Lkotlin/jvm/functions/Function1;)V", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ErrorHandlersKt {
    private static Function1<? super Exception, Unit> onDecomposeError = ErrorHandlersKt$onDecomposeError$1.INSTANCE;

    public static final Function1<Exception, Unit> getOnDecomposeError() {
        return onDecomposeError;
    }

    public static final void setOnDecomposeError(Function1<? super Exception, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        onDecomposeError = function1;
    }
}
