package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.d2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0185d2 {

    /* renamed from: a  reason: collision with root package name */
    public final C0272gc f949a;
    public final ICommonExecutor b;
    public final long c;
    public boolean d = true;
    public final Runnable e = new Runnable() { // from class: io.appmetrica.analytics.impl.d2$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            C0185d2.a(C0185d2.this);
        }
    };

    public C0185d2(C0272gc c0272gc, IHandlerExecutor iHandlerExecutor, long j) {
        this.f949a = c0272gc;
        this.b = iHandlerExecutor;
        this.c = j;
    }

    public static final void a(C0185d2 c0185d2) {
        C0298hc c0298hc = c0185d2.f949a.f1011a;
        C0680wi c0680wi = c0298hc.h;
        c0680wi.c.a(c0298hc.b.f607a);
    }
}
