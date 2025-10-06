package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.l2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0396l2 {

    /* renamed from: a  reason: collision with root package name */
    public final Gc f963a;
    public final ICommonExecutor b;
    public final long c;
    public boolean d = true;
    public final Runnable e = new Runnable() { // from class: io.appmetrica.analytics.impl.l2$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            C0396l2.a(C0396l2.this);
        }
    };

    public C0396l2(Gc gc, IHandlerExecutor iHandlerExecutor, long j) {
        this.f963a = gc;
        this.b = iHandlerExecutor;
        this.c = j;
    }

    public static final void a(C0396l2 c0396l2) {
        Hc hc = c0396l2.f963a.f460a;
        Si si = hc.h;
        si.c.a(hc.b.f889a);
    }
}
