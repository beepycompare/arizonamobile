package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.x4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0696x4 {
    public static volatile C0696x4 u;

    /* renamed from: a  reason: collision with root package name */
    public final N6 f1134a;
    public final C0117a8 b;
    public final C0447n4 c;
    public final N1 d;
    public final C0442n e;
    public final C0182cl f;
    public final C0115a6 g;
    public final C0392l h;
    public final C0516pn i;
    public Md j;
    public final C0468o0 k;
    public volatile C0621u4 l;
    public final C0506pd m;
    public volatile C0408lf n;
    public C0611tj o;
    public final C0617u0 p;
    public final R1 q;
    public final C0752za r;
    public volatile Z s;
    public volatile C0351ja t;

    public C0696x4(N6 n6, C0442n c0442n, C0447n4 c0447n4) {
        this(n6, c0442n, c0447n4, new C0392l(c0442n));
    }

    public static C0696x4 l() {
        if (u == null) {
            synchronized (C0696x4.class) {
                if (u == null) {
                    u = new C0696x4(new N6(), new C0442n(), new C0447n4());
                }
            }
        }
        return u;
    }

    public final C0442n a() {
        return this.e;
    }

    public final C0408lf b(Context context) {
        C0408lf c0408lf;
        C0408lf c0408lf2 = this.n;
        if (c0408lf2 == null) {
            synchronized (this) {
                c0408lf = this.n;
                if (c0408lf == null) {
                    c0408lf = new C0408lf(C0649v7.a(context).a());
                    this.n = c0408lf;
                }
            }
            return c0408lf;
        }
        return c0408lf2;
    }

    public final C0468o0 c() {
        return this.k;
    }

    public final C0617u0 d() {
        return this.p;
    }

    public final N1 e() {
        return this.d;
    }

    public final R1 f() {
        return this.q;
    }

    public final C0447n4 g() {
        return this.c;
    }

    public final C0115a6 h() {
        return this.g;
    }

    public final N6 i() {
        return this.f1134a;
    }

    public final C0117a8 j() {
        return this.b;
    }

    public final C0752za k() {
        return this.r;
    }

    public final C0621u4 m() {
        C0621u4 c0621u4;
        C0621u4 c0621u42 = this.l;
        if (c0621u42 == null) {
            synchronized (this) {
                c0621u4 = this.l;
                if (c0621u4 == null) {
                    c0621u4 = new C0621u4();
                    this.l = c0621u4;
                }
            }
            return c0621u4;
        }
        return c0621u42;
    }

    public final N6 n() {
        return this.f1134a;
    }

    public final C0182cl o() {
        return this.f;
    }

    public C0696x4(N6 n6, C0442n c0442n, C0447n4 c0447n4, C0392l c0392l) {
        this(n6, new C0117a8(), c0447n4, c0392l, new N1(), c0442n, new C0182cl(c0442n, c0392l), new C0115a6(c0442n), new C0516pn(), new C0468o0());
    }

    public final synchronized Md a(Context context) {
        if (this.j == null) {
            this.j = new Md(context, new oo());
        }
        return this.j;
    }

    public C0696x4(N6 n6, C0117a8 c0117a8, C0447n4 c0447n4, C0392l c0392l, N1 n1, C0442n c0442n, C0182cl c0182cl, C0115a6 c0115a6, C0516pn c0516pn, C0468o0 c0468o0) {
        this.m = new C0506pd();
        this.p = new C0617u0();
        this.q = new R1();
        this.r = new C0752za();
        new Z7();
        this.f1134a = n6;
        this.b = c0117a8;
        this.c = c0447n4;
        this.h = c0392l;
        this.d = n1;
        this.e = c0442n;
        this.f = c0182cl;
        this.g = c0115a6;
        this.i = c0516pn;
        this.k = c0468o0;
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
