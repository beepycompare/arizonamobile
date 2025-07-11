package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* renamed from: io.appmetrica.analytics.impl.ae  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C0130ae extends FunctionReferenceImpl implements Function1 {
    public C0130ae(Object obj) {
        super(1, obj, C0156be.class, "markCrashCompletedAndDeleteCompletedCrashes", "markCrashCompletedAndDeleteCompletedCrashes(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        C0156be c0156be = (C0156be) this.receiver;
        c0156be.f770a.markCrashCompleted((String) obj);
        c0156be.f770a.deleteCompletedCrashes();
        return Unit.INSTANCE;
    }
}
