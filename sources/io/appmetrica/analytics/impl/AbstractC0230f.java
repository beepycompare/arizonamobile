package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.f  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0230f implements InterfaceC0261g4 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f878a;
    public final Cg b;

    public AbstractC0230f(Context context, Cg cg) {
        this.f878a = context.getApplicationContext();
        this.b = cg;
        cg.a(this);
        C0471oa.k().n().b(this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0261g4
    public final void a(Q5 q5, C0515q4 c0515q4) {
        b(q5, c0515q4);
    }

    public final Cg b() {
        return this.b;
    }

    public abstract void b(Q5 q5, C0515q4 c0515q4);

    public final Context c() {
        return this.f878a;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0261g4
    public final void a() {
        this.b.b(this);
        C0471oa.I.m().a(this);
    }
}
