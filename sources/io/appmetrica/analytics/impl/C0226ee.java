package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* renamed from: io.appmetrica.analytics.impl.ee  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C0226ee extends FunctionReferenceImpl implements Function1 {
    public C0226ee(Object obj) {
        super(1, obj, C0252fe.class, "markCrashCompletedAndDeleteCompletedCrashes", "markCrashCompletedAndDeleteCompletedCrashes(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        C0252fe c0252fe = (C0252fe) this.receiver;
        c0252fe.f856a.markCrashCompleted((String) obj);
        c0252fe.f856a.deleteCompletedCrashes();
        return Unit.INSTANCE;
    }
}
