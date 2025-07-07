package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.x4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0704x4 {
    public static volatile C0704x4 u;

    /* renamed from: a  reason: collision with root package name */
    public final J6 f1116a;
    public final W7 b;
    public final C0455n4 c;
    public final N1 d;
    public final C0450n e;
    public final Uk f;
    public final X5 g;
    public final C0400l h;
    public final C0325hn i;
    public Id j;
    public final C0476o0 k;
    public volatile C0629u4 l;
    public final C0414ld m;
    public volatile C0317hf n;
    public C0420lj o;
    public final C0625u0 p;
    public final R1 q;
    public final C0660va r;
    public volatile Z s;
    public volatile C0262fa t;

    public C0704x4(J6 j6, C0450n c0450n, C0455n4 c0455n4) {
        this(j6, c0450n, c0455n4, new C0400l(c0450n));
    }

    public static C0704x4 l() {
        if (u == null) {
            synchronized (C0704x4.class) {
                if (u == null) {
                    u = new C0704x4(new J6(), new C0450n(), new C0455n4());
                }
            }
        }
        return u;
    }

    public final C0450n a() {
        return this.e;
    }

    public final C0317hf b(Context context) {
        C0317hf c0317hf;
        C0317hf c0317hf2 = this.n;
        if (c0317hf2 == null) {
            synchronized (this) {
                c0317hf = this.n;
                if (c0317hf == null) {
                    c0317hf = new C0317hf(C0557r7.a(context).a());
                    this.n = c0317hf;
                }
            }
            return c0317hf;
        }
        return c0317hf2;
    }

    public final C0476o0 c() {
        return this.k;
    }

    public final C0625u0 d() {
        return this.p;
    }

    public final N1 e() {
        return this.d;
    }

    public final R1 f() {
        return this.q;
    }

    public final C0455n4 g() {
        return this.c;
    }

    public final X5 h() {
        return this.g;
    }

    public final J6 i() {
        return this.f1116a;
    }

    public final W7 j() {
        return this.b;
    }

    public final C0660va k() {
        return this.r;
    }

    public final C0629u4 m() {
        C0629u4 c0629u4;
        C0629u4 c0629u42 = this.l;
        if (c0629u42 == null) {
            synchronized (this) {
                c0629u4 = this.l;
                if (c0629u4 == null) {
                    c0629u4 = new C0629u4();
                    this.l = c0629u4;
                }
            }
            return c0629u4;
        }
        return c0629u42;
    }

    public final J6 n() {
        return this.f1116a;
    }

    public final Uk o() {
        return this.f;
    }

    public C0704x4(J6 j6, C0450n c0450n, C0455n4 c0455n4, C0400l c0400l) {
        this(j6, new W7(), c0455n4, c0400l, new N1(), c0450n, new Uk(c0450n, c0400l), new X5(c0450n), new C0325hn(), new C0476o0());
    }

    public final synchronized Id a(Context context) {
        if (this.j == null) {
            this.j = new Id(context, new go());
        }
        return this.j;
    }

    public C0704x4(J6 j6, W7 w7, C0455n4 c0455n4, C0400l c0400l, N1 n1, C0450n c0450n, Uk uk, X5 x5, C0325hn c0325hn, C0476o0 c0476o0) {
        this.m = new C0414ld();
        this.p = new C0625u0();
        this.q = new R1();
        this.r = new C0660va();
        new V7();
        this.f1116a = j6;
        this.b = w7;
        this.c = c0455n4;
        this.h = c0400l;
        this.d = n1;
        this.e = c0450n;
        this.f = uk;
        this.g = x5;
        this.i = c0325hn;
        this.k = c0476o0;
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
