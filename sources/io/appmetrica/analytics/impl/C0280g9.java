package io.appmetrica.analytics.impl;

import android.content.ContentValues;
/* renamed from: io.appmetrica.analytics.impl.g9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0280g9 {

    /* renamed from: a  reason: collision with root package name */
    public final String f863a;
    public String b;
    public final Long c;
    public final Long d;
    public final Long e;
    public final Long f;
    public final E7 g;
    public final EnumC0680wb h;
    public final Integer i;
    public final String j;
    public final Integer k;
    public final Integer l;
    public final String m;
    public final String n;
    public final EnumC0151b9 o;
    public final EnumC0729ya p;
    public final H9 q;
    public final Boolean r;
    public final Integer s;
    public final byte[] t;

    public C0280g9(ContentValues contentValues) {
        A7 model = new B7(null, 1, null).toModel(contentValues);
        this.f863a = model.a().j();
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
        EnumC0151b9 e = model.a().e();
        this.o = e == null ? EnumC0151b9.a(null) : e;
        EnumC0729ya h = model.a().h();
        this.p = h == null ? EnumC0729ya.a(null) : h;
        this.q = model.a().n();
        this.r = model.a().a();
        this.s = model.a().l();
        this.t = model.a().g();
    }
}
