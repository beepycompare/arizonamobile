package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.f  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0229f implements InterfaceC0260g4 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f976a;
    public final Cg b;

    public AbstractC0229f(Context context, Cg cg) {
        this.f976a = context.getApplicationContext();
        this.b = cg;
        cg.a(this);
        C0470oa.k().n().b(this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0260g4
    public final void a(Q5 q5, C0514q4 c0514q4) {
        b(q5, c0514q4);
    }

    public final Cg b() {
        return this.b;
    }

    public abstract void b(Q5 q5, C0514q4 c0514q4);

    public final Context c() {
        return this.f976a;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0260g4
    public final void a() {
        this.b.b(this);
        C0470oa.I.m().a(this);
    }
}
