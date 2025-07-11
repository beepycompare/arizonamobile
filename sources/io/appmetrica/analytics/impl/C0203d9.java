package io.appmetrica.analytics.impl;

import android.content.ContentValues;
/* renamed from: io.appmetrica.analytics.impl.d9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0203d9 {

    /* renamed from: a  reason: collision with root package name */
    public final String f802a;
    public String b;
    public final Long c;
    public final Long d;
    public final Long e;
    public final Long f;
    public final B7 g;
    public final EnumC0628ub h;
    public final Integer i;
    public final String j;
    public final Integer k;
    public final Integer l;
    public final String m;
    public final String n;
    public final Y8 o;
    public final EnumC0677wa p;
    public final E9 q;
    public final Boolean r;
    public final Integer s;
    public final byte[] t;

    public C0203d9(ContentValues contentValues) {
        C0699x7 model = new C0724y7(null, 1, null).toModel(contentValues);
        this.f802a = model.a().j();
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
        Y8 e = model.a().e();
        this.o = e == null ? Y8.a(null) : e;
        EnumC0677wa h = model.a().h();
        this.p = h == null ? EnumC0677wa.a(null) : h;
        this.q = model.a().n();
        this.r = model.a().a();
        this.s = model.a().l();
        this.t = model.a().g();
    }
}
