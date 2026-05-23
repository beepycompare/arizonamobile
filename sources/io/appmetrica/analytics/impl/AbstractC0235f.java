package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.f  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0235f implements InterfaceC0680w4 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f969a;
    public final Rg b;

    public AbstractC0235f(Context context, Rg rg) {
        this.f969a = context.getApplicationContext();
        this.b = rg;
        rg.a(this);
        Na.k().n().b(this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0680w4
    public final void a(C0242f6 c0242f6, G4 g4) {
        b(c0242f6, g4);
    }

    public final Rg b() {
        return this.b;
    }

    public abstract void b(C0242f6 c0242f6, G4 g4);

    public final Context c() {
        return this.f969a;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0680w4
    public final void a() {
        this.b.b(this);
        Na.I.m().a(this);
    }
}
