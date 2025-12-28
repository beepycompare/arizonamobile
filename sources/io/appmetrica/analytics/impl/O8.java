package io.appmetrica.analytics.impl;

import android.content.ContentValues;
/* loaded from: classes5.dex */
public final class O8 {

    /* renamed from: a  reason: collision with root package name */
    public final String f717a;
    public String b;
    public final Long c;
    public final Long d;
    public final Long e;
    public final Long f;
    public final C0340j7 g;
    public final EnumC0164cb h;
    public final Integer i;
    public final String j;
    public final Integer k;
    public final Integer l;
    public final String m;
    public final String n;
    public final J8 o;
    public final EnumC0214ea p;
    public final EnumC0444n9 q;
    public final Boolean r;
    public final Integer s;
    public final byte[] t;

    public O8(ContentValues contentValues) {
        C0237f7 model = new C0263g7(null, 1, null).toModel(contentValues);
        this.f717a = model.a().j();
        this.b = model.a().p();
        this.c = model.c();
        this.d = model.b();
        this.e = model.a().k();
        this.f = model.d();
        this.g = model.a().i();
        this.h = model.e();
        this.i = model.a().d();
        this.j = model.a().f();
        this.k = model.a().o();
        this.l = model.a().c();
        this.m = model.a().b();
        this.n = model.a().m();
        J8 e = model.a().e();
        this.o = e == null ? J8.a(null) : e;
        EnumC0214ea h = model.a().h();
        this.p = h == null ? EnumC0214ea.a(null) : h;
        this.q = model.a().n();
        this.r = model.a().a();
        this.s = model.a().l();
        this.t = model.a().g();
    }
}
