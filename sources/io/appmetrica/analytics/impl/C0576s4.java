package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.system.SystemPropertiesHelper;
import java.io.File;
import kotlin.text.StringsKt;
/* renamed from: io.appmetrica.analytics.impl.s4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0576s4 {
    public static volatile C0576s4 y;

    /* renamed from: a  reason: collision with root package name */
    public final J6 f1191a;
    public final V7 b;
    public final C0318i4 c;
    public final S1 d;
    public final C0468o e;
    public final Bl f;
    public final U5 g;
    public final C0416m h;
    public final Nn i;
    public Vd j;
    public final C0598t0 k;
    public volatile C0499p4 l;
    public final C0585sd m;
    public volatile C0665vf n;
    public volatile C0665vf o;
    public Cj p;
    public final B0 q;
    public final X1 r;
    public final C0764za s;
    public volatile C0185d0 t;
    public volatile C0298ha u;
    public volatile Y7 v;
    public volatile C0602t4 w;
    public volatile C0750ym x;

    public C0576s4(J6 j6, C0468o c0468o, C0318i4 c0318i4) {
        this(j6, c0468o, c0318i4, new C0416m(c0468o));
    }

    public static C0576s4 l() {
        if (y == null) {
            synchronized (C0576s4.class) {
                if (y == null) {
                    y = new C0576s4(new J6(), new C0468o(), new C0318i4());
                }
            }
        }
        return y;
    }

    public final C0468o a() {
        return this.e;
    }

    public final C0665vf b(Context context) {
        C0665vf c0665vf;
        C0665vf c0665vf2 = this.n;
        if (c0665vf2 == null) {
            synchronized (this) {
                c0665vf = this.n;
                if (c0665vf == null) {
                    C0602t4 e = e(context);
                    new C0421m4(c(context)).a(context);
                    C0665vf c0665vf3 = new C0665vf(e.a(context));
                    this.n = c0665vf3;
                    c0665vf = c0665vf3;
                }
            }
            return c0665vf;
        }
        return c0665vf2;
    }

    public final C0598t0 c() {
        return this.k;
    }

    public final C0750ym d(Context context) {
        C0750ym c0750ym;
        C0750ym c0750ym2 = this.x;
        if (c0750ym2 == null) {
            synchronized (this) {
                c0750ym = this.x;
                if (c0750ym == null) {
                    c0750ym = new C0750ym(context, b(context));
                    this.x = c0750ym;
                }
            }
            return c0750ym;
        }
        return c0750ym2;
    }

    public final S1 e() {
        return this.d;
    }

    public final X1 f() {
        return this.r;
    }

    public final C0318i4 g() {
        return this.c;
    }

    public final U5 h() {
        return this.g;
    }

    public final J6 i() {
        return this.f1191a;
    }

    public final V7 j() {
        return this.b;
    }

    public final C0764za k() {
        return this.s;
    }

    public final C0499p4 m() {
        C0499p4 c0499p4;
        C0499p4 c0499p42 = this.l;
        if (c0499p42 == null) {
            synchronized (this) {
                c0499p4 = this.l;
                if (c0499p4 == null) {
                    c0499p4 = new C0499p4();
                    this.l = c0499p4;
                }
            }
            return c0499p4;
        }
        return c0499p42;
    }

    public final J6 n() {
        return this.f1191a;
    }

    public final Bl o() {
        return this.f;
    }

    public C0576s4(J6 j6, C0468o c0468o, C0318i4 c0318i4, C0416m c0416m) {
        this(j6, new V7(), c0318i4, c0416m, new S1(), c0468o, new Bl(c0468o, c0416m), new U5(c0468o), new Nn(), new C0598t0());
    }

    public final synchronized Vd a(Context context) {
        if (this.j == null) {
            this.j = new Vd(context, new Po());
        }
        return this.j;
    }

    public final C0665vf c(Context context) {
        C0665vf c0665vf;
        C0665vf c0665vf2 = this.o;
        if (c0665vf2 == null) {
            synchronized (this) {
                c0665vf = this.o;
                if (c0665vf == null) {
                    C0665vf c0665vf3 = new C0665vf(e(context).b(context));
                    this.o = c0665vf3;
                    c0665vf = c0665vf3;
                }
            }
            return c0665vf;
        }
        return c0665vf2;
    }

    public final C0602t4 e(Context context) {
        C0602t4 c0602t4;
        File file;
        C0602t4 c0602t42 = this.w;
        if (c0602t42 == null) {
            synchronized (this) {
                c0602t4 = this.w;
                if (c0602t4 == null) {
                    String readSystemProperty = SystemPropertiesHelper.readSystemProperty("ro.yndx.metrica.db.dir");
                    String readSystemProperty2 = SystemPropertiesHelper.readSystemProperty("debug.yndx.iaa.db.dir");
                    if (StringsKt.isBlank(readSystemProperty)) {
                        readSystemProperty = readSystemProperty2;
                    }
                    if (!StringsKt.isBlank(readSystemProperty)) {
                        file = new File(readSystemProperty, context.getPackageName());
                        try {
                            file.mkdirs();
                        } catch (Exception unused) {
                        }
                        c0602t4 = new C0602t4(file);
                        this.w = c0602t4;
                    }
                    file = null;
                    c0602t4 = new C0602t4(file);
                    this.w = c0602t4;
                }
            }
            return c0602t4;
        }
        return c0602t42;
    }

    public C0576s4(J6 j6, V7 v7, C0318i4 c0318i4, C0416m c0416m, S1 s1, C0468o c0468o, Bl bl, U5 u5, Nn nn, C0598t0 c0598t0) {
        this.m = new C0585sd();
        this.q = new B0();
        this.r = new X1();
        this.s = new C0764za();
        new U7();
        this.v = new Y7();
        this.f1191a = j6;
        this.b = v7;
        this.c = c0318i4;
        this.h = c0416m;
        this.d = s1;
        this.e = c0468o;
        this.f = bl;
        this.g = u5;
        this.i = nn;
        this.k = c0598t0;
    }

    public final B0 d() {
        return this.q;
    }

    public final C0185d0 b() {
        C0185d0 c0185d0;
        C0185d0 c0185d02 = this.t;
        if (c0185d02 == null) {
            synchronized (this) {
                c0185d0 = this.t;
                if (c0185d0 == null) {
                    c0185d0 = new C0185d0(this.q, this.f, this.c);
                    this.t = c0185d0;
                }
            }
            return c0185d0;
        }
        return c0185d02;
    }
}
