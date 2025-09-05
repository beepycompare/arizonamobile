package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.l2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0395l2 {

    /* renamed from: a  reason: collision with root package name */
    public final Gc f958a;
    public final ICommonExecutor b;
    public final long c;
    public boolean d = true;
    public final Runnable e = new Runnable() { // from class: io.appmetrica.analytics.impl.l2$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            C0395l2.a(C0395l2.this);
        }
    };

    public C0395l2(Gc gc, IHandlerExecutor iHandlerExecutor, long j) {
        this.f958a = gc;
        this.b = iHandlerExecutor;
        this.c = j;
    }

    public static final void a(C0395l2 c0395l2) {
        Hc hc = c0395l2.f958a.f455a;
        Si si = hc.h;
        si.c.a(hc.b.f884a);
    }
}
