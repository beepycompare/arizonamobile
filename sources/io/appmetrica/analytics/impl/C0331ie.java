package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* renamed from: io.appmetrica.analytics.impl.ie  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C0331ie extends FunctionReferenceImpl implements Function1 {
    public C0331ie(Object obj) {
        super(1, obj, C0356je.class, "markCrashCompletedAndDeleteCompletedCrashes", "markCrashCompletedAndDeleteCompletedCrashes(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        C0356je c0356je = (C0356je) this.receiver;
        c0356je.f940a.markCrashCompleted((String) obj);
        c0356je.f940a.deleteCompletedCrashes();
        return Unit.INSTANCE;
    }
}
