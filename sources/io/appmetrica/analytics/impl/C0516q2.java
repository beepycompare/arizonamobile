package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.q2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0516q2 {

    /* renamed from: a  reason: collision with root package name */
    public final Ic f1162a;
    public final ICommonExecutor b;
    public final long c;
    public boolean d = true;
    public final Runnable e = new Runnable() { // from class: io.appmetrica.analytics.impl.q2$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            C0516q2.a(C0516q2.this);
        }
    };

    public C0516q2(Ic ic, IHandlerExecutor iHandlerExecutor, long j) {
        this.f1162a = ic;
        this.b = iHandlerExecutor;
        this.c = j;
    }

    public static final void a(C0516q2 c0516q2) {
        Jc jc = c0516q2.f1162a.f598a;
        Qi qi = jc.h;
        qi.c.a(jc.b.f855a);
    }
}
