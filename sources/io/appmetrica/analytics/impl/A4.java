package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class A4 {
    public static volatile A4 u;

    /* renamed from: a  reason: collision with root package name */
    public final Q6 f344a;
    public final C0195d8 b;
    public final C0526q4 c;
    public final P1 d;
    public final C0444n e;
    public final C0285gl f;
    public final C0193d6 g;
    public final C0392l h;
    public final C0619tn i;
    public Qd j;
    public final C0522q0 k;
    public volatile C0700x4 l;
    public final C0584sd m;
    public volatile C0512pf n;
    public C0715xj o;
    public final C0671w0 p;
    public final T1 q;
    public final Ca r;
    public volatile C0109a0 s;
    public volatile C0429ma t;

    public A4(Q6 q6, C0444n c0444n, C0526q4 c0526q4) {
        this(q6, c0444n, c0526q4, new C0392l(c0444n));
    }

    public static A4 l() {
        if (u == null) {
            synchronized (A4.class) {
                if (u == null) {
                    u = new A4(new Q6(), new C0444n(), new C0526q4());
                }
            }
        }
        return u;
    }

    public final C0444n a() {
        return this.e;
    }

    public final C0512pf b(Context context) {
        C0512pf c0512pf;
        C0512pf c0512pf2 = this.n;
        if (c0512pf2 == null) {
            synchronized (this) {
                c0512pf = this.n;
                if (c0512pf == null) {
                    c0512pf = new C0512pf(C0728y7.a(context).a());
                    this.n = c0512pf;
                }
            }
            return c0512pf;
        }
        return c0512pf2;
    }

    public final C0522q0 c() {
        return this.k;
    }

    public final C0671w0 d() {
        return this.p;
    }

    public final P1 e() {
        return this.d;
    }

    public final T1 f() {
        return this.q;
    }

    public final C0526q4 g() {
        return this.c;
    }

    public final C0193d6 h() {
        return this.g;
    }

    public final Q6 i() {
        return this.f344a;
    }

    public final C0195d8 j() {
        return this.b;
    }

    public final Ca k() {
        return this.r;
    }

    public final C0700x4 m() {
        C0700x4 c0700x4;
        C0700x4 c0700x42 = this.l;
        if (c0700x42 == null) {
            synchronized (this) {
                c0700x4 = this.l;
                if (c0700x4 == null) {
                    c0700x4 = new C0700x4();
                    this.l = c0700x4;
                }
            }
            return c0700x4;
        }
        return c0700x42;
    }

    public final Q6 n() {
        return this.f344a;
    }

    public final C0285gl o() {
        return this.f;
    }

    public A4(Q6 q6, C0444n c0444n, C0526q4 c0526q4, C0392l c0392l) {
        this(q6, new C0195d8(), c0526q4, c0392l, new P1(), c0444n, new C0285gl(c0444n, c0392l), new C0193d6(c0444n), new C0619tn(), new C0522q0());
    }

    public final synchronized Qd a(Context context) {
        if (this.j == null) {
            this.j = new Qd(context, new so());
        }
        return this.j;
    }

    public A4(Q6 q6, C0195d8 c0195d8, C0526q4 c0526q4, C0392l c0392l, P1 p1, C0444n c0444n, C0285gl c0285gl, C0193d6 c0193d6, C0619tn c0619tn, C0522q0 c0522q0) {
        this.m = new C0584sd();
        this.p = new C0671w0();
        this.q = new T1();
        this.r = new Ca();
        new C0169c8();
        this.f344a = q6;
        this.b = c0195d8;
        this.c = c0526q4;
        this.h = c0392l;
        this.d = p1;
        this.e = c0444n;
        this.f = c0285gl;
        this.g = c0193d6;
        this.i = c0619tn;
        this.k = c0522q0;
    }

    public final C0109a0 b() {
        C0109a0 c0109a0;
        C0109a0 c0109a02 = this.s;
        if (c0109a02 == null) {
            synchronized (this) {
                c0109a0 = this.s;
                if (c0109a0 == null) {
                    c0109a0 = new C0109a0(this.p, this.f, this.c);
                    this.s = c0109a0;
                }
            }
            return c0109a0;
        }
        return c0109a02;
    }
}
