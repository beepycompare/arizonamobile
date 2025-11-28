package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* loaded from: classes5.dex */
public final /* synthetic */ class Ud extends FunctionReferenceImpl implements Function1 {
    public Ud(Object obj) {
        super(1, obj, Vd.class, "markCrashCompletedAndDeleteCompletedCrashes", "markCrashCompletedAndDeleteCompletedCrashes(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Vd vd = (Vd) this.receiver;
        vd.f732a.markCrashCompleted((String) obj);
        vd.f732a.deleteCompletedCrashes();
        return Unit.INSTANCE;
    }
}
