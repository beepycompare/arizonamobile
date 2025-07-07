package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* renamed from: io.appmetrica.analytics.impl.ae  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C0138ae extends FunctionReferenceImpl implements Function1 {
    public C0138ae(Object obj) {
        super(1, obj, C0164be.class, "markCrashCompletedAndDeleteCompletedCrashes", "markCrashCompletedAndDeleteCompletedCrashes(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        C0164be c0164be = (C0164be) this.receiver;
        c0164be.f769a.markCrashCompleted((String) obj);
        c0164be.f769a.deleteCompletedCrashes();
        return Unit.INSTANCE;
    }
}
