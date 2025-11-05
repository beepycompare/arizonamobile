package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.f  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0230f implements InterfaceC0415m4 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f867a;
    public final Gg b;

    public AbstractC0230f(Context context, Gg gg) {
        this.f867a = context.getApplicationContext();
        this.b = gg;
        gg.a(this);
        C0620ua.k().n().b(this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0415m4
    public final void a(W5 w5, C0664w4 c0664w4) {
        b(w5, c0664w4);
    }

    public final Gg b() {
        return this.b;
    }

    public abstract void b(W5 w5, C0664w4 c0664w4);

    public final Context c() {
        return this.f867a;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0415m4
    public final void a() {
        this.b.b(this);
        C0620ua.H.m().a(this);
    }
}
