package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* renamed from: io.appmetrica.analytics.impl.ne  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final /* synthetic */ class C0450ne extends FunctionReferenceImpl implements Function1 {
    public C0450ne(Object obj) {
        super(1, obj, C0476oe.class, "markCrashCompletedAndDeleteCompletedCrashes", "markCrashCompletedAndDeleteCompletedCrashes(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        C0476oe c0476oe = (C0476oe) this.receiver;
        c0476oe.f1136a.markCrashCompleted((String) obj);
        c0476oe.f1136a.deleteCompletedCrashes();
        return Unit.INSTANCE;
    }
}
