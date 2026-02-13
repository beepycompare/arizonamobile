package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* loaded from: classes5.dex */
public final /* synthetic */ class Nd extends FunctionReferenceImpl implements Function1 {
    public Nd(Object obj) {
        super(1, obj, Od.class, "markCrashCompletedAndDeleteCompletedCrashes", "markCrashCompletedAndDeleteCompletedCrashes(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Od od = (Od) this.receiver;
        od.f723a.markCrashCompleted((String) obj);
        od.f723a.deleteCompletedCrashes();
        return Unit.INSTANCE;
    }
}
