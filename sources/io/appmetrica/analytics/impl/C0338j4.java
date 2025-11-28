package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.j4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0338j4 {
    public static volatile C0338j4 u;

    /* renamed from: a  reason: collision with root package name */
    public final C0716y6 f945a;
    public final L7 b;
    public final Z3 c;
    public final Q1 d;
    public final C0460o e;
    public final C0149bl f;
    public final L5 g;
    public final C0410m h;
    public final C0509pn i;
    public Cd j;
    public final C0535r0 k;
    public volatile C0261g4 l;
    public final Zc m;
    public volatile C0117af n;
    public C0276gj o;
    public final C0685x0 p;
    public final U1 q;
    public final C0344ja r;
    public volatile C0128b0 s;
    public volatile T9 t;

    public C0338j4(C0716y6 c0716y6, C0460o c0460o, Z3 z3) {
        this(c0716y6, c0460o, z3, new C0410m(c0460o));
    }

    public static C0338j4 l() {
        if (u == null) {
            synchronized (C0338j4.class) {
                if (u == null) {
                    u = new C0338j4(new C0716y6(), new C0460o(), new Z3());
                }
            }
        }
        return u;
    }

    public final C0460o a() {
        return this.e;
    }

    public final C0117af b(Context context) {
        C0117af c0117af;
        C0117af c0117af2 = this.n;
        if (c0117af2 == null) {
            synchronized (this) {
                c0117af = this.n;
                if (c0117af == null) {
                    c0117af = new C0117af(C0264g7.a(context).a());
                    this.n = c0117af;
                }
            }
            return c0117af;
        }
        return c0117af2;
    }

    public final C0535r0 c() {
        return this.k;
    }

    public final C0685x0 d() {
        return this.p;
    }

    public final Q1 e() {
        return this.d;
    }

    public final U1 f() {
        return this.q;
    }

    public final Z3 g() {
        return this.c;
    }

    public final L5 h() {
        return this.g;
    }

    public final C0716y6 i() {
        return this.f945a;
    }

    public final L7 j() {
        return this.b;
    }

    public final C0344ja k() {
        return this.r;
    }

    public final C0261g4 m() {
        C0261g4 c0261g4;
        C0261g4 c0261g42 = this.l;
        if (c0261g42 == null) {
            synchronized (this) {
                c0261g4 = this.l;
                if (c0261g4 == null) {
                    c0261g4 = new C0261g4();
                    this.l = c0261g4;
                }
            }
            return c0261g4;
        }
        return c0261g42;
    }

    public final C0716y6 n() {
        return this.f945a;
    }

    public final C0149bl o() {
        return this.f;
    }

    public C0338j4(C0716y6 c0716y6, C0460o c0460o, Z3 z3, C0410m c0410m) {
        this(c0716y6, new L7(), z3, c0410m, new Q1(), c0460o, new C0149bl(c0460o, c0410m), new L5(c0460o), new C0509pn(), new C0535r0());
    }

    public final synchronized Cd a(Context context) {
        if (this.j == null) {
            this.j = new Cd(context, new oo());
        }
        return this.j;
    }

    public C0338j4(C0716y6 c0716y6, L7 l7, Z3 z3, C0410m c0410m, Q1 q1, C0460o c0460o, C0149bl c0149bl, L5 l5, C0509pn c0509pn, C0535r0 c0535r0) {
        this.m = new Zc();
        this.p = new C0685x0();
        this.q = new U1();
        this.r = new C0344ja();
        new K7();
        this.f945a = c0716y6;
        this.b = l7;
        this.c = z3;
        this.h = c0410m;
        this.d = q1;
        this.e = c0460o;
        this.f = c0149bl;
        this.g = l5;
        this.i = c0509pn;
        this.k = c0535r0;
    }

    public final C0128b0 b() {
        C0128b0 c0128b0;
        C0128b0 c0128b02 = this.s;
        if (c0128b02 == null) {
            synchronized (this) {
                c0128b0 = this.s;
                if (c0128b0 == null) {
                    c0128b0 = new C0128b0(this.p, this.f, this.c);
                    this.s = c0128b0;
                }
            }
            return c0128b0;
        }
        return c0128b02;
    }
}
