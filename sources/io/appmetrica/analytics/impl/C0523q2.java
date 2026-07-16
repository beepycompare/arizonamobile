package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.q2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0523q2 {

    /* renamed from: a  reason: collision with root package name */
    public final Ic f1159a;
    public final ICommonExecutor b;
    public final long c;
    public boolean d = true;
    public final Runnable e = new Runnable() { // from class: io.appmetrica.analytics.impl.q2$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            C0523q2.a(C0523q2.this);
        }
    };

    public C0523q2(Ic ic, IHandlerExecutor iHandlerExecutor, long j) {
        this.f1159a = ic;
        this.b = iHandlerExecutor;
        this.c = j;
    }

    public static final void a(C0523q2 c0523q2) {
        Jc jc = c0523q2.f1159a.f595a;
        Qi qi = jc.h;
        qi.c.a(jc.b.f852a);
    }
}
