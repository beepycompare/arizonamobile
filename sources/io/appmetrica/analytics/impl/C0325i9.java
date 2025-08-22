package io.appmetrica.analytics.impl;

import android.content.ContentValues;
/* renamed from: io.appmetrica.analytics.impl.i9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0325i9 {

    /* renamed from: a  reason: collision with root package name */
    public final String f904a;
    public String b;
    public final Long c;
    public final Long d;
    public final Long e;
    public final Long f;
    public final F7 g;
    public final EnumC0728yb h;
    public final Integer i;
    public final String j;
    public final Integer k;
    public final Integer l;
    public final String m;
    public final String n;
    public final EnumC0196d9 o;
    public final Aa p;
    public final J9 q;
    public final Boolean r;
    public final Integer s;
    public final byte[] t;

    public C0325i9(ContentValues contentValues) {
        B7 model = new C7(null, 1, null).toModel(contentValues);
        this.f904a = model.a().j();
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
        EnumC0196d9 e = model.a().e();
        this.o = e == null ? EnumC0196d9.a(null) : e;
        Aa h = model.a().h();
        this.p = h == null ? Aa.a(null) : h;
        this.q = model.a().n();
        this.r = model.a().a();
        this.s = model.a().l();
        this.t = model.a().g();
    }
}
