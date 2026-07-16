package io.appmetrica.analytics.impl;

import android.content.ContentValues;
/* renamed from: io.appmetrica.analytics.impl.h9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0297h9 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1012a;
    public String b;
    public final Long c;
    public final Long d;
    public final Long e;
    public final Long f;
    public final C0761z7 g;
    public final Db h;
    public final Integer i;
    public final String j;
    public final Integer k;
    public final Integer l;
    public final String m;
    public final String n;
    public final EnumC0168c9 o;
    public final Aa p;
    public final G9 q;
    public final Boolean r;
    public final Integer s;
    public final byte[] t;
    public final String u;
    public final long v;

    public C0297h9(ContentValues contentValues) {
        C0657v7 model = new C0683w7(null, 1, null).toModel(contentValues);
        this.f1012a = model.a().l();
        this.b = model.a().r();
        this.c = model.c();
        this.d = model.b();
        this.e = model.a().m();
        this.f = model.d();
        this.g = model.a().k();
        this.h = model.e();
        this.i = model.a().f();
        this.j = model.a().h();
        this.k = model.a().q();
        this.l = model.a().e();
        this.m = model.a().d();
        this.n = model.a().o();
        EnumC0168c9 g = model.a().g();
        this.o = g == null ? EnumC0168c9.a(null) : g;
        Aa j = model.a().j();
        this.p = j == null ? Aa.a(null) : j;
        this.q = model.a().p();
        this.r = model.a().c();
        this.s = model.a().n();
        this.t = model.a().i();
        String a2 = model.a().a();
        this.u = a2 == null ? "" : a2;
        Long b = model.a().b();
        this.v = b != null ? b.longValue() : 0L;
    }
}
