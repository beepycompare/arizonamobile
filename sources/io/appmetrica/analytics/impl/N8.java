package io.appmetrica.analytics.impl;

import android.content.ContentValues;
/* loaded from: classes5.dex */
public final class N8 {

    /* renamed from: a  reason: collision with root package name */
    public final String f712a;
    public String b;
    public final Long c;
    public final Long d;
    public final Long e;
    public final Long f;
    public final C0319i7 g;
    public final EnumC0142bb h;
    public final Integer i;
    public final String j;
    public final Integer k;
    public final Integer l;
    public final String m;
    public final String n;
    public final I8 o;
    public final EnumC0193da p;
    public final EnumC0422m9 q;
    public final Boolean r;
    public final Integer s;
    public final byte[] t;

    public N8(ContentValues contentValues) {
        C0215e7 model = new C0241f7(null, 1, null).toModel(contentValues);
        this.f712a = model.a().j();
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
        I8 e = model.a().e();
        this.o = e == null ? I8.a(null) : e;
        EnumC0193da h = model.a().h();
        this.p = h == null ? EnumC0193da.a(null) : h;
        this.q = model.a().n();
        this.r = model.a().a();
        this.s = model.a().l();
        this.t = model.a().g();
    }
}
