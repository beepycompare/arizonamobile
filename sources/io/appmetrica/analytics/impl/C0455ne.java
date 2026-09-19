package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* renamed from: io.appmetrica.analytics.impl.ne  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final /* synthetic */ class C0455ne extends FunctionReferenceImpl implements Function1 {
    public C0455ne(Object obj) {
        super(1, obj, C0481oe.class, "markCrashCompletedAndDeleteCompletedCrashes", "markCrashCompletedAndDeleteCompletedCrashes(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        C0481oe c0481oe = (C0481oe) this.receiver;
        c0481oe.f1133a.markCrashCompleted((String) obj);
        c0481oe.f1133a.deleteCompletedCrashes();
        return Unit.INSTANCE;
    }
}
