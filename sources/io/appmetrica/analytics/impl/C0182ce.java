package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* renamed from: io.appmetrica.analytics.impl.ce  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C0182ce extends FunctionReferenceImpl implements Function1 {
    public C0182ce(Object obj) {
        super(1, obj, C0208de.class, "markCrashCompletedAndDeleteCompletedCrashes", "markCrashCompletedAndDeleteCompletedCrashes(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        C0208de c0208de = (C0208de) this.receiver;
        c0208de.f817a.markCrashCompleted((String) obj);
        c0208de.f817a.deleteCompletedCrashes();
        return Unit.INSTANCE;
    }
}
