package io.appmetrica.analytics.impl;

import android.content.ContentValues;
/* loaded from: classes3.dex */
public final class S8 {

    /* renamed from: a  reason: collision with root package name */
    public final String f680a;
    public String b;
    public final Long c;
    public final Long d;
    public final Long e;
    public final Long f;
    public final C0518q7 g;
    public final EnumC0320ib h;
    public final Integer i;
    public final String j;
    public final Integer k;
    public final Integer l;
    public final String m;
    public final String n;
    public final N8 o;
    public final EnumC0370ka p;
    public final EnumC0594t9 q;
    public final Boolean r;
    public final Integer s;
    public final byte[] t;

    public S8(ContentValues contentValues) {
        C0418m7 model = new C0443n7(null, 1, null).toModel(contentValues);
        this.f680a = model.a().j();
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
        N8 e = model.a().e();
        this.o = e == null ? N8.a(null) : e;
        EnumC0370ka h = model.a().h();
        this.p = h == null ? EnumC0370ka.a(null) : h;
        this.q = model.a().n();
        this.r = model.a().a();
        this.s = model.a().l();
        this.t = model.a().g();
    }
}
