package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* renamed from: io.appmetrica.analytics.impl.ie  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C0330ie extends FunctionReferenceImpl implements Function1 {
    public C0330ie(Object obj) {
        super(1, obj, C0355je.class, "markCrashCompletedAndDeleteCompletedCrashes", "markCrashCompletedAndDeleteCompletedCrashes(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        C0355je c0355je = (C0355je) this.receiver;
        c0355je.f935a.markCrashCompleted((String) obj);
        c0355je.f935a.deleteCompletedCrashes();
        return Unit.INSTANCE;
    }
}
