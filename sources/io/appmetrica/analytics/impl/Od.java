package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* loaded from: classes5.dex */
public final /* synthetic */ class Od extends FunctionReferenceImpl implements Function1 {
    public Od(Object obj) {
        super(1, obj, Pd.class, "markCrashCompletedAndDeleteCompletedCrashes", "markCrashCompletedAndDeleteCompletedCrashes(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Pd pd = (Pd) this.receiver;
        pd.f634a.markCrashCompleted((String) obj);
        pd.f634a.deleteCompletedCrashes();
        return Unit.INSTANCE;
    }
}
