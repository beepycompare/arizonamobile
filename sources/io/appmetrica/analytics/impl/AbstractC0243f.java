package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.f  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0243f implements A4 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f828a;
    public final Mg b;

    public AbstractC0243f(Context context, Mg mg) {
        this.f828a = context.getApplicationContext();
        this.b = mg;
        mg.a(this);
        Ga.j().m().b(this);
    }

    @Override // io.appmetrica.analytics.impl.A4
    public final void a(C0325i6 c0325i6, K4 k4) {
        b(c0325i6, k4);
    }

    public final Mg b() {
        return this.b;
    }

    public abstract void b(C0325i6 c0325i6, K4 k4);

    public final Context c() {
        return this.f828a;
    }

    @Override // io.appmetrica.analytics.impl.A4
    public final void a() {
        this.b.b(this);
        Ga.F.l().a(this);
    }
}
