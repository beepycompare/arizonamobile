package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* renamed from: io.appmetrica.analytics.impl.ce  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C0183ce extends FunctionReferenceImpl implements Function1 {
    public C0183ce(Object obj) {
        super(1, obj, C0209de.class, "markCrashCompletedAndDeleteCompletedCrashes", "markCrashCompletedAndDeleteCompletedCrashes(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        C0209de c0209de = (C0209de) this.receiver;
        c0209de.f816a.markCrashCompleted((String) obj);
        c0209de.f816a.deleteCompletedCrashes();
        return Unit.INSTANCE;
    }
}
