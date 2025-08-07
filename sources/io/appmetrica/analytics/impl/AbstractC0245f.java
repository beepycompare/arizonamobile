package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.f  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0245f implements A4 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f837a;
    public final Og b;

    public AbstractC0245f(Context context, Og og) {
        this.f837a = context.getApplicationContext();
        this.b = og;
        og.a(this);
        Ia.j().m().b(this);
    }

    @Override // io.appmetrica.analytics.impl.A4
    public final void a(C0402l6 c0402l6, K4 k4) {
        b(c0402l6, k4);
    }

    public final Og b() {
        return this.b;
    }

    public abstract void b(C0402l6 c0402l6, K4 k4);

    public final Context c() {
        return this.f837a;
    }

    @Override // io.appmetrica.analytics.impl.A4
    public final void a() {
        this.b.b(this);
        Ia.F.l().a(this);
    }
}
