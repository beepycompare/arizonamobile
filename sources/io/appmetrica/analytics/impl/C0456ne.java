package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* renamed from: io.appmetrica.analytics.impl.ne  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final /* synthetic */ class C0456ne extends FunctionReferenceImpl implements Function1 {
    public C0456ne(Object obj) {
        super(1, obj, C0482oe.class, "markCrashCompletedAndDeleteCompletedCrashes", "markCrashCompletedAndDeleteCompletedCrashes(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        C0482oe c0482oe = (C0482oe) this.receiver;
        c0482oe.f1133a.markCrashCompleted((String) obj);
        c0482oe.f1133a.deleteCompletedCrashes();
        return Unit.INSTANCE;
    }
}
