package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.x4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0698x4 {
    public static volatile C0698x4 u;

    /* renamed from: a  reason: collision with root package name */
    public final M6 f1129a;
    public final Z7 b;
    public final C0449n4 c;
    public final N1 d;
    public final C0444n e;
    public final Xk f;
    public final C0122a6 g;
    public final C0394l h;
    public final C0393kn i;
    public Kd j;
    public final C0470o0 k;
    public volatile C0623u4 l;
    public final C0458nd m;
    public volatile C0360jf n;
    public C0489oj o;
    public final C0619u0 p;
    public final R1 q;
    public final C0704xa r;
    public volatile Z s;
    public volatile C0306ha t;

    public C0698x4(M6 m6, C0444n c0444n, C0449n4 c0449n4) {
        this(m6, c0444n, c0449n4, new C0394l(c0444n));
    }

    public static C0698x4 l() {
        if (u == null) {
            synchronized (C0698x4.class) {
                if (u == null) {
                    u = new C0698x4(new M6(), new C0444n(), new C0449n4());
                }
            }
        }
        return u;
    }

    public final C0444n a() {
        return this.e;
    }

    public final C0360jf b(Context context) {
        C0360jf c0360jf;
        C0360jf c0360jf2 = this.n;
        if (c0360jf2 == null) {
            synchronized (this) {
                c0360jf = this.n;
                if (c0360jf == null) {
                    c0360jf = new C0360jf(C0626u7.a(context).a());
                    this.n = c0360jf;
                }
            }
            return c0360jf;
        }
        return c0360jf2;
    }

    public final C0470o0 c() {
        return this.k;
    }

    public final C0619u0 d() {
        return this.p;
    }

    public final N1 e() {
        return this.d;
    }

    public final R1 f() {
        return this.q;
    }

    public final C0449n4 g() {
        return this.c;
    }

    public final C0122a6 h() {
        return this.g;
    }

    public final M6 i() {
        return this.f1129a;
    }

    public final Z7 j() {
        return this.b;
    }

    public final C0704xa k() {
        return this.r;
    }

    public final C0623u4 m() {
        C0623u4 c0623u4;
        C0623u4 c0623u42 = this.l;
        if (c0623u42 == null) {
            synchronized (this) {
                c0623u4 = this.l;
                if (c0623u4 == null) {
                    c0623u4 = new C0623u4();
                    this.l = c0623u4;
                }
            }
            return c0623u4;
        }
        return c0623u42;
    }

    public final M6 n() {
        return this.f1129a;
    }

    public final Xk o() {
        return this.f;
    }

    public C0698x4(M6 m6, C0444n c0444n, C0449n4 c0449n4, C0394l c0394l) {
        this(m6, new Z7(), c0449n4, c0394l, new N1(), c0444n, new Xk(c0444n, c0394l), new C0122a6(c0444n), new C0393kn(), new C0470o0());
    }

    public final synchronized Kd a(Context context) {
        if (this.j == null) {
            this.j = new Kd(context, new jo());
        }
        return this.j;
    }

    public C0698x4(M6 m6, Z7 z7, C0449n4 c0449n4, C0394l c0394l, N1 n1, C0444n c0444n, Xk xk, C0122a6 c0122a6, C0393kn c0393kn, C0470o0 c0470o0) {
        this.m = new C0458nd();
        this.p = new C0619u0();
        this.q = new R1();
        this.r = new C0704xa();
        new Y7();
        this.f1129a = m6;
        this.b = z7;
        this.c = c0449n4;
        this.h = c0394l;
        this.d = n1;
        this.e = c0444n;
        this.f = xk;
        this.g = c0122a6;
        this.i = c0393kn;
        this.k = c0470o0;
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
