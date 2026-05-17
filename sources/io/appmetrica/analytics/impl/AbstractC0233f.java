package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.f  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0233f implements InterfaceC0238f4 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f990a;
    public final Bg b;

    public AbstractC0233f(Context context, Bg bg) {
        this.f990a = context.getApplicationContext();
        this.b = bg;
        bg.a(this);
        C0448na.k().n().b(this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0238f4
    public final void a(P5 p5, C0492p4 c0492p4) {
        b(p5, c0492p4);
    }

    public final Bg b() {
        return this.b;
    }

    public abstract void b(P5 p5, C0492p4 c0492p4);

    public final Context c() {
        return this.f990a;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0238f4
    public final void a() {
        this.b.b(this);
        C0448na.I.m().a(this);
    }
}
