package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.x4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0696x4 {
    public static volatile C0696x4 u;

    /* renamed from: a  reason: collision with root package name */
    public final J6 f1117a;
    public final W7 b;
    public final C0447n4 c;
    public final N1 d;
    public final C0442n e;
    public final Uk f;
    public final X5 g;
    public final C0392l h;
    public final C0317hn i;
    public Id j;
    public final C0468o0 k;
    public volatile C0621u4 l;
    public final C0406ld m;
    public volatile C0309hf n;
    public C0412lj o;
    public final C0617u0 p;
    public final R1 q;
    public final C0652va r;
    public volatile Z s;
    public volatile C0254fa t;

    public C0696x4(J6 j6, C0442n c0442n, C0447n4 c0447n4) {
        this(j6, c0442n, c0447n4, new C0392l(c0442n));
    }

    public static C0696x4 l() {
        if (u == null) {
            synchronized (C0696x4.class) {
                if (u == null) {
                    u = new C0696x4(new J6(), new C0442n(), new C0447n4());
                }
            }
        }
        return u;
    }

    public final C0442n a() {
        return this.e;
    }

    public final C0309hf b(Context context) {
        C0309hf c0309hf;
        C0309hf c0309hf2 = this.n;
        if (c0309hf2 == null) {
            synchronized (this) {
                c0309hf = this.n;
                if (c0309hf == null) {
                    c0309hf = new C0309hf(C0549r7.a(context).a());
                    this.n = c0309hf;
                }
            }
            return c0309hf;
        }
        return c0309hf2;
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

    public final X5 h() {
        return this.g;
    }

    public final J6 i() {
        return this.f1117a;
    }

    public final W7 j() {
        return this.b;
    }

    public final C0652va k() {
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

    public final J6 n() {
        return this.f1117a;
    }

    public final Uk o() {
        return this.f;
    }

    public C0696x4(J6 j6, C0442n c0442n, C0447n4 c0447n4, C0392l c0392l) {
        this(j6, new W7(), c0447n4, c0392l, new N1(), c0442n, new Uk(c0442n, c0392l), new X5(c0442n), new C0317hn(), new C0468o0());
    }

    public final synchronized Id a(Context context) {
        if (this.j == null) {
            this.j = new Id(context, new go());
        }
        return this.j;
    }

    public C0696x4(J6 j6, W7 w7, C0447n4 c0447n4, C0392l c0392l, N1 n1, C0442n c0442n, Uk uk, X5 x5, C0317hn c0317hn, C0468o0 c0468o0) {
        this.m = new C0406ld();
        this.p = new C0617u0();
        this.q = new R1();
        this.r = new C0652va();
        new V7();
        this.f1117a = j6;
        this.b = w7;
        this.c = c0447n4;
        this.h = c0392l;
        this.d = n1;
        this.e = c0442n;
        this.f = uk;
        this.g = x5;
        this.i = c0317hn;
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
