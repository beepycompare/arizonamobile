package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.system.SystemPropertiesHelper;
import java.io.File;
import kotlin.text.StringsKt;
/* renamed from: io.appmetrica.analytics.impl.s4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0575s4 {
    public static volatile C0575s4 y;

    /* renamed from: a  reason: collision with root package name */
    public final J6 f1194a;
    public final V7 b;
    public final C0317i4 c;
    public final S1 d;
    public final C0467o e;
    public final Bl f;
    public final U5 g;
    public final C0415m h;
    public final Nn i;
    public Vd j;
    public final C0597t0 k;
    public volatile C0498p4 l;
    public final C0584sd m;
    public volatile C0664vf n;
    public volatile C0664vf o;
    public Cj p;
    public final B0 q;
    public final X1 r;
    public final C0763za s;
    public volatile C0184d0 t;
    public volatile C0297ha u;
    public volatile Y7 v;
    public volatile C0601t4 w;
    public volatile C0749ym x;

    public C0575s4(J6 j6, C0467o c0467o, C0317i4 c0317i4) {
        this(j6, c0467o, c0317i4, new C0415m(c0467o));
    }

    public static C0575s4 l() {
        if (y == null) {
            synchronized (C0575s4.class) {
                if (y == null) {
                    y = new C0575s4(new J6(), new C0467o(), new C0317i4());
                }
            }
        }
        return y;
    }

    public final C0467o a() {
        return this.e;
    }

    public final C0664vf b(Context context) {
        C0664vf c0664vf;
        C0664vf c0664vf2 = this.n;
        if (c0664vf2 == null) {
            synchronized (this) {
                c0664vf = this.n;
                if (c0664vf == null) {
                    C0601t4 e = e(context);
                    new C0420m4(c(context)).a(context);
                    C0664vf c0664vf3 = new C0664vf(e.a(context));
                    this.n = c0664vf3;
                    c0664vf = c0664vf3;
                }
            }
            return c0664vf;
        }
        return c0664vf2;
    }

    public final C0597t0 c() {
        return this.k;
    }

    public final C0749ym d(Context context) {
        C0749ym c0749ym;
        C0749ym c0749ym2 = this.x;
        if (c0749ym2 == null) {
            synchronized (this) {
                c0749ym = this.x;
                if (c0749ym == null) {
                    c0749ym = new C0749ym(context, b(context));
                    this.x = c0749ym;
                }
            }
            return c0749ym;
        }
        return c0749ym2;
    }

    public final S1 e() {
        return this.d;
    }

    public final X1 f() {
        return this.r;
    }

    public final C0317i4 g() {
        return this.c;
    }

    public final U5 h() {
        return this.g;
    }

    public final J6 i() {
        return this.f1194a;
    }

    public final V7 j() {
        return this.b;
    }

    public final C0763za k() {
        return this.s;
    }

    public final C0498p4 m() {
        C0498p4 c0498p4;
        C0498p4 c0498p42 = this.l;
        if (c0498p42 == null) {
            synchronized (this) {
                c0498p4 = this.l;
                if (c0498p4 == null) {
                    c0498p4 = new C0498p4();
                    this.l = c0498p4;
                }
            }
            return c0498p4;
        }
        return c0498p42;
    }

    public final J6 n() {
        return this.f1194a;
    }

    public final Bl o() {
        return this.f;
    }

    public C0575s4(J6 j6, C0467o c0467o, C0317i4 c0317i4, C0415m c0415m) {
        this(j6, new V7(), c0317i4, c0415m, new S1(), c0467o, new Bl(c0467o, c0415m), new U5(c0467o), new Nn(), new C0597t0());
    }

    public final synchronized Vd a(Context context) {
        if (this.j == null) {
            this.j = new Vd(context, new Po());
        }
        return this.j;
    }

    public final C0664vf c(Context context) {
        C0664vf c0664vf;
        C0664vf c0664vf2 = this.o;
        if (c0664vf2 == null) {
            synchronized (this) {
                c0664vf = this.o;
                if (c0664vf == null) {
                    C0664vf c0664vf3 = new C0664vf(e(context).b(context));
                    this.o = c0664vf3;
                    c0664vf = c0664vf3;
                }
            }
            return c0664vf;
        }
        return c0664vf2;
    }

    public final C0601t4 e(Context context) {
        C0601t4 c0601t4;
        File file;
        C0601t4 c0601t42 = this.w;
        if (c0601t42 == null) {
            synchronized (this) {
                c0601t4 = this.w;
                if (c0601t4 == null) {
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
                        c0601t4 = new C0601t4(file);
                        this.w = c0601t4;
                    }
                    file = null;
                    c0601t4 = new C0601t4(file);
                    this.w = c0601t4;
                }
            }
            return c0601t4;
        }
        return c0601t42;
    }

    public C0575s4(J6 j6, V7 v7, C0317i4 c0317i4, C0415m c0415m, S1 s1, C0467o c0467o, Bl bl, U5 u5, Nn nn, C0597t0 c0597t0) {
        this.m = new C0584sd();
        this.q = new B0();
        this.r = new X1();
        this.s = new C0763za();
        new U7();
        this.v = new Y7();
        this.f1194a = j6;
        this.b = v7;
        this.c = c0317i4;
        this.h = c0415m;
        this.d = s1;
        this.e = c0467o;
        this.f = bl;
        this.g = u5;
        this.i = nn;
        this.k = c0597t0;
    }

    public final B0 d() {
        return this.q;
    }

    public final C0184d0 b() {
        C0184d0 c0184d0;
        C0184d0 c0184d02 = this.t;
        if (c0184d02 == null) {
            synchronized (this) {
                c0184d0 = this.t;
                if (c0184d0 == null) {
                    c0184d0 = new C0184d0(this.q, this.f, this.c);
                    this.t = c0184d0;
                }
            }
            return c0184d0;
        }
        return c0184d02;
    }
}
