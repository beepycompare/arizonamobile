package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.f  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0238f implements D4 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f869a;
    public final Xg b;

    public AbstractC0238f(Context context, Xg xg) {
        this.f869a = context.getApplicationContext();
        this.b = xg;
        xg.a(this);
        Na.j().m().b(this);
    }

    @Override // io.appmetrica.analytics.impl.D4
    public final void a(C0478o6 c0478o6, N4 n4) {
        b(c0478o6, n4);
    }

    public final Xg b() {
        return this.b;
    }

    public abstract void b(C0478o6 c0478o6, N4 n4);

    public final Context c() {
        return this.f869a;
    }

    @Override // io.appmetrica.analytics.impl.D4
    public final void a() {
        this.b.b(this);
        Na.F.l().a(this);
    }
}
