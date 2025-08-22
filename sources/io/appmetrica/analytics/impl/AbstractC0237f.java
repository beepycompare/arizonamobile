package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.f  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0237f implements A4 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f848a;
    public final Tg b;

    public AbstractC0237f(Context context, Tg tg) {
        this.f848a = context.getApplicationContext();
        this.b = tg;
        tg.a(this);
        Ka.j().m().b(this);
    }

    @Override // io.appmetrica.analytics.impl.A4
    public final void a(C0399l6 c0399l6, K4 k4) {
        b(c0399l6, k4);
    }

    public final Tg b() {
        return this.b;
    }

    public abstract void b(C0399l6 c0399l6, K4 k4);

    public final Context c() {
        return this.f848a;
    }

    @Override // io.appmetrica.analytics.impl.A4
    public final void a() {
        this.b.b(this);
        Ka.F.l().a(this);
    }
}
