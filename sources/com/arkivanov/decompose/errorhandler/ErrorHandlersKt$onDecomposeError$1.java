package com.arkivanov.decompose.errorhandler;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ErrorHandlers.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class ErrorHandlersKt$onDecomposeError$1 extends FunctionReferenceImpl implements Function1<Exception, Unit> {
    public static final ErrorHandlersKt$onDecomposeError$1 INSTANCE = new ErrorHandlersKt$onDecomposeError$1();

    ErrorHandlersKt$onDecomposeError$1() {
        super(1, PrintErrorKt.class, "printError", "printError(Ljava/lang/Exception;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
        invoke2(exc);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Exception p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        PrintErrorKt.printError(p0);
    }
}
