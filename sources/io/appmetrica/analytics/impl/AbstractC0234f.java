package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.f  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0234f implements InterfaceC0679w4 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f972a;
    public final Rg b;

    public AbstractC0234f(Context context, Rg rg) {
        this.f972a = context.getApplicationContext();
        this.b = rg;
        rg.a(this);
        Na.k().n().b(this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0679w4
    public final void a(C0241f6 c0241f6, G4 g4) {
        b(c0241f6, g4);
    }

    public final Rg b() {
        return this.b;
    }

    public abstract void b(C0241f6 c0241f6, G4 g4);

    public final Context c() {
        return this.f972a;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0679w4
    public final void a() {
        this.b.b(this);
        Na.I.m().a(this);
    }
}
