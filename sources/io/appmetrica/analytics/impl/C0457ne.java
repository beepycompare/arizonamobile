package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* renamed from: io.appmetrica.analytics.impl.ne  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final /* synthetic */ class C0457ne extends FunctionReferenceImpl implements Function1 {
    public C0457ne(Object obj) {
        super(1, obj, C0483oe.class, "markCrashCompletedAndDeleteCompletedCrashes", "markCrashCompletedAndDeleteCompletedCrashes(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        C0483oe c0483oe = (C0483oe) this.receiver;
        c0483oe.f1131a.markCrashCompleted((String) obj);
        c0483oe.f1131a.deleteCompletedCrashes();
        return Unit.INSTANCE;
    }
}
