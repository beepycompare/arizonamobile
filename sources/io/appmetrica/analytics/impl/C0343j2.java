package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.j2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0343j2 {

    /* renamed from: a  reason: collision with root package name */
    public final Dc f915a;
    public final ICommonExecutor b;
    public final long c;
    public boolean d = true;
    public final Runnable e = new Runnable() { // from class: io.appmetrica.analytics.impl.j2$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            C0343j2.a(C0343j2.this);
        }
    };

    public C0343j2(Dc dc, IHandlerExecutor iHandlerExecutor, long j) {
        this.f915a = dc;
        this.b = iHandlerExecutor;
        this.c = j;
    }

    public static final void a(C0343j2 c0343j2) {
        Ec ec = c0343j2.f915a.f394a;
        Oi oi = ec.h;
        oi.c.a(ec.b.f823a);
    }
}
