package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.f  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0244f implements A4 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f838a;
    public final Og b;

    public AbstractC0244f(Context context, Og og) {
        this.f838a = context.getApplicationContext();
        this.b = og;
        og.a(this);
        Ia.j().m().b(this);
    }

    @Override // io.appmetrica.analytics.impl.A4
    public final void a(C0401l6 c0401l6, K4 k4) {
        b(c0401l6, k4);
    }

    public final Og b() {
        return this.b;
    }

    public abstract void b(C0401l6 c0401l6, K4 k4);

    public final Context c() {
        return this.f838a;
    }

    @Override // io.appmetrica.analytics.impl.A4
    public final void a() {
        this.b.b(this);
        Ia.F.l().a(this);
    }
}
