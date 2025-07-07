package io.appmetrica.analytics.impl;

import android.content.ContentValues;
/* renamed from: io.appmetrica.analytics.impl.d9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0211d9 {

    /* renamed from: a  reason: collision with root package name */
    public final String f801a;
    public String b;
    public final Long c;
    public final Long d;
    public final Long e;
    public final Long f;
    public final B7 g;
    public final EnumC0636ub h;
    public final Integer i;
    public final String j;
    public final Integer k;
    public final Integer l;
    public final String m;
    public final String n;
    public final Y8 o;
    public final EnumC0685wa p;
    public final E9 q;
    public final Boolean r;
    public final Integer s;
    public final byte[] t;

    public C0211d9(ContentValues contentValues) {
        C0707x7 model = new C0732y7(null, 1, null).toModel(contentValues);
        this.f801a = model.a().j();
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
        EnumC0685wa h = model.a().h();
        this.p = h == null ? EnumC0685wa.a(null) : h;
        this.q = model.a().n();
        this.r = model.a().a();
        this.s = model.a().l();
        this.t = model.a().g();
    }
}
