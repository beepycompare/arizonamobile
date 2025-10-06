package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class A4 {
    public static volatile A4 u;

    /* renamed from: a  reason: collision with root package name */
    public final Q6 f344a;
    public final C0196d8 b;
    public final C0527q4 c;
    public final P1 d;
    public final C0445n e;
    public final C0286gl f;
    public final C0194d6 g;
    public final C0393l h;
    public final C0620tn i;
    public Qd j;
    public final C0523q0 k;
    public volatile C0701x4 l;
    public final C0585sd m;
    public volatile C0513pf n;
    public C0716xj o;
    public final C0672w0 p;
    public final T1 q;
    public final Ca r;
    public volatile C0110a0 s;
    public volatile C0430ma t;

    public A4(Q6 q6, C0445n c0445n, C0527q4 c0527q4) {
        this(q6, c0445n, c0527q4, new C0393l(c0445n));
    }

    public static A4 l() {
        if (u == null) {
            synchronized (A4.class) {
                if (u == null) {
                    u = new A4(new Q6(), new C0445n(), new C0527q4());
                }
            }
        }
        return u;
    }

    public final C0445n a() {
        return this.e;
    }

    public final C0513pf b(Context context) {
        C0513pf c0513pf;
        C0513pf c0513pf2 = this.n;
        if (c0513pf2 == null) {
            synchronized (this) {
                c0513pf = this.n;
                if (c0513pf == null) {
                    c0513pf = new C0513pf(C0729y7.a(context).a());
                    this.n = c0513pf;
                }
            }
            return c0513pf;
        }
        return c0513pf2;
    }

    public final C0523q0 c() {
        return this.k;
    }

    public final C0672w0 d() {
        return this.p;
    }

    public final P1 e() {
        return this.d;
    }

    public final T1 f() {
        return this.q;
    }

    public final C0527q4 g() {
        return this.c;
    }

    public final C0194d6 h() {
        return this.g;
    }

    public final Q6 i() {
        return this.f344a;
    }

    public final C0196d8 j() {
        return this.b;
    }

    public final Ca k() {
        return this.r;
    }

    public final C0701x4 m() {
        C0701x4 c0701x4;
        C0701x4 c0701x42 = this.l;
        if (c0701x42 == null) {
            synchronized (this) {
                c0701x4 = this.l;
                if (c0701x4 == null) {
                    c0701x4 = new C0701x4();
                    this.l = c0701x4;
                }
            }
            return c0701x4;
        }
        return c0701x42;
    }

    public final Q6 n() {
        return this.f344a;
    }

    public final C0286gl o() {
        return this.f;
    }

    public A4(Q6 q6, C0445n c0445n, C0527q4 c0527q4, C0393l c0393l) {
        this(q6, new C0196d8(), c0527q4, c0393l, new P1(), c0445n, new C0286gl(c0445n, c0393l), new C0194d6(c0445n), new C0620tn(), new C0523q0());
    }

    public final synchronized Qd a(Context context) {
        if (this.j == null) {
            this.j = new Qd(context, new so());
        }
        return this.j;
    }

    public A4(Q6 q6, C0196d8 c0196d8, C0527q4 c0527q4, C0393l c0393l, P1 p1, C0445n c0445n, C0286gl c0286gl, C0194d6 c0194d6, C0620tn c0620tn, C0523q0 c0523q0) {
        this.m = new C0585sd();
        this.p = new C0672w0();
        this.q = new T1();
        this.r = new Ca();
        new C0170c8();
        this.f344a = q6;
        this.b = c0196d8;
        this.c = c0527q4;
        this.h = c0393l;
        this.d = p1;
        this.e = c0445n;
        this.f = c0286gl;
        this.g = c0194d6;
        this.i = c0620tn;
        this.k = c0523q0;
    }

    public final C0110a0 b() {
        C0110a0 c0110a0;
        C0110a0 c0110a02 = this.s;
        if (c0110a02 == null) {
            synchronized (this) {
                c0110a0 = this.s;
                if (c0110a0 == null) {
                    c0110a0 = new C0110a0(this.p, this.f, this.c);
                    this.s = c0110a0;
                }
            }
            return c0110a0;
        }
        return c0110a02;
    }
}
