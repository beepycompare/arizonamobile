package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.x4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0699x4 {
    public static volatile C0699x4 u;

    /* renamed from: a  reason: collision with root package name */
    public final M6 f1129a;
    public final Z7 b;
    public final C0450n4 c;
    public final N1 d;
    public final C0445n e;
    public final Xk f;
    public final C0123a6 g;
    public final C0395l h;
    public final C0394kn i;
    public Kd j;
    public final C0471o0 k;
    public volatile C0624u4 l;
    public final C0459nd m;
    public volatile C0361jf n;
    public C0490oj o;
    public final C0620u0 p;
    public final R1 q;
    public final C0705xa r;
    public volatile Z s;
    public volatile C0307ha t;

    public C0699x4(M6 m6, C0445n c0445n, C0450n4 c0450n4) {
        this(m6, c0445n, c0450n4, new C0395l(c0445n));
    }

    public static C0699x4 l() {
        if (u == null) {
            synchronized (C0699x4.class) {
                if (u == null) {
                    u = new C0699x4(new M6(), new C0445n(), new C0450n4());
                }
            }
        }
        return u;
    }

    public final C0445n a() {
        return this.e;
    }

    public final C0361jf b(Context context) {
        C0361jf c0361jf;
        C0361jf c0361jf2 = this.n;
        if (c0361jf2 == null) {
            synchronized (this) {
                c0361jf = this.n;
                if (c0361jf == null) {
                    c0361jf = new C0361jf(C0627u7.a(context).a());
                    this.n = c0361jf;
                }
            }
            return c0361jf;
        }
        return c0361jf2;
    }

    public final C0471o0 c() {
        return this.k;
    }

    public final C0620u0 d() {
        return this.p;
    }

    public final N1 e() {
        return this.d;
    }

    public final R1 f() {
        return this.q;
    }

    public final C0450n4 g() {
        return this.c;
    }

    public final C0123a6 h() {
        return this.g;
    }

    public final M6 i() {
        return this.f1129a;
    }

    public final Z7 j() {
        return this.b;
    }

    public final C0705xa k() {
        return this.r;
    }

    public final C0624u4 m() {
        C0624u4 c0624u4;
        C0624u4 c0624u42 = this.l;
        if (c0624u42 == null) {
            synchronized (this) {
                c0624u4 = this.l;
                if (c0624u4 == null) {
                    c0624u4 = new C0624u4();
                    this.l = c0624u4;
                }
            }
            return c0624u4;
        }
        return c0624u42;
    }

    public final M6 n() {
        return this.f1129a;
    }

    public final Xk o() {
        return this.f;
    }

    public C0699x4(M6 m6, C0445n c0445n, C0450n4 c0450n4, C0395l c0395l) {
        this(m6, new Z7(), c0450n4, c0395l, new N1(), c0445n, new Xk(c0445n, c0395l), new C0123a6(c0445n), new C0394kn(), new C0471o0());
    }

    public final synchronized Kd a(Context context) {
        if (this.j == null) {
            this.j = new Kd(context, new jo());
        }
        return this.j;
    }

    public C0699x4(M6 m6, Z7 z7, C0450n4 c0450n4, C0395l c0395l, N1 n1, C0445n c0445n, Xk xk, C0123a6 c0123a6, C0394kn c0394kn, C0471o0 c0471o0) {
        this.m = new C0459nd();
        this.p = new C0620u0();
        this.q = new R1();
        this.r = new C0705xa();
        new Y7();
        this.f1129a = m6;
        this.b = z7;
        this.c = c0450n4;
        this.h = c0395l;
        this.d = n1;
        this.e = c0445n;
        this.f = xk;
        this.g = c0123a6;
        this.i = c0394kn;
        this.k = c0471o0;
    }

    public final Z b() {
        Z z;
        Z z2 = this.s;
        if (z2 == null) {
            synchronized (this) {
                z = this.s;
                if (z == null) {
                    z = new Z(this.p, this.f, this.c);
                    this.s = z;
                }
            }
            return z;
        }
        return z2;
    }
}
