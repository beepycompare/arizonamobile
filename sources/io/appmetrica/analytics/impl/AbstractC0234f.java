package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.f  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0234f implements InterfaceC0239f4 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f986a;
    public final Bg b;

    public AbstractC0234f(Context context, Bg bg) {
        this.f986a = context.getApplicationContext();
        this.b = bg;
        bg.a(this);
        C0449na.k().n().b(this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0239f4
    public final void a(P5 p5, C0493p4 c0493p4) {
        b(p5, c0493p4);
    }

    public final Bg b() {
        return this.b;
    }

    public abstract void b(P5 p5, C0493p4 c0493p4);

    public final Context c() {
        return this.f986a;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0239f4
    public final void a() {
        this.b.b(this);
        C0449na.I.m().a(this);
    }
}
