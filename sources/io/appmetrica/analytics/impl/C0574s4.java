package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.system.SystemPropertiesHelper;
import java.io.File;
import kotlin.text.StringsKt;
/* renamed from: io.appmetrica.analytics.impl.s4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0574s4 {
    public static volatile C0574s4 y;

    /* renamed from: a  reason: collision with root package name */
    public final J6 f1194a;
    public final V7 b;
    public final C0316i4 c;
    public final S1 d;
    public final C0466o e;
    public final Bl f;
    public final U5 g;
    public final C0414m h;
    public final Nn i;
    public Vd j;
    public final C0596t0 k;
    public volatile C0497p4 l;
    public final C0583sd m;
    public volatile C0663vf n;
    public volatile C0663vf o;
    public Cj p;
    public final B0 q;
    public final X1 r;
    public final C0762za s;
    public volatile C0183d0 t;
    public volatile C0296ha u;
    public volatile Y7 v;
    public volatile C0600t4 w;
    public volatile C0748ym x;

    public C0574s4(J6 j6, C0466o c0466o, C0316i4 c0316i4) {
        this(j6, c0466o, c0316i4, new C0414m(c0466o));
    }

    public static C0574s4 l() {
        if (y == null) {
            synchronized (C0574s4.class) {
                if (y == null) {
                    y = new C0574s4(new J6(), new C0466o(), new C0316i4());
                }
            }
        }
        return y;
    }

    public final C0466o a() {
        return this.e;
    }

    public final C0663vf b(Context context) {
        C0663vf c0663vf;
        C0663vf c0663vf2 = this.n;
        if (c0663vf2 == null) {
            synchronized (this) {
                c0663vf = this.n;
                if (c0663vf == null) {
                    C0600t4 e = e(context);
                    new C0419m4(c(context)).a(context);
                    C0663vf c0663vf3 = new C0663vf(e.a(context));
                    this.n = c0663vf3;
                    c0663vf = c0663vf3;
                }
            }
            return c0663vf;
        }
        return c0663vf2;
    }

    public final C0596t0 c() {
        return this.k;
    }

    public final C0748ym d(Context context) {
        C0748ym c0748ym;
        C0748ym c0748ym2 = this.x;
        if (c0748ym2 == null) {
            synchronized (this) {
                c0748ym = this.x;
                if (c0748ym == null) {
                    c0748ym = new C0748ym(context, b(context));
                    this.x = c0748ym;
                }
            }
            return c0748ym;
        }
        return c0748ym2;
    }

    public final S1 e() {
        return this.d;
    }

    public final X1 f() {
        return this.r;
    }

    public final C0316i4 g() {
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

    public final C0762za k() {
        return this.s;
    }

    public final C0497p4 m() {
        C0497p4 c0497p4;
        C0497p4 c0497p42 = this.l;
        if (c0497p42 == null) {
            synchronized (this) {
                c0497p4 = this.l;
                if (c0497p4 == null) {
                    c0497p4 = new C0497p4();
                    this.l = c0497p4;
                }
            }
            return c0497p4;
        }
        return c0497p42;
    }

    public final J6 n() {
        return this.f1194a;
    }

    public final Bl o() {
        return this.f;
    }

    public C0574s4(J6 j6, C0466o c0466o, C0316i4 c0316i4, C0414m c0414m) {
        this(j6, new V7(), c0316i4, c0414m, new S1(), c0466o, new Bl(c0466o, c0414m), new U5(c0466o), new Nn(), new C0596t0());
    }

    public final synchronized Vd a(Context context) {
        if (this.j == null) {
            this.j = new Vd(context, new Po());
        }
        return this.j;
    }

    public final C0663vf c(Context context) {
        C0663vf c0663vf;
        C0663vf c0663vf2 = this.o;
        if (c0663vf2 == null) {
            synchronized (this) {
                c0663vf = this.o;
                if (c0663vf == null) {
                    C0663vf c0663vf3 = new C0663vf(e(context).b(context));
                    this.o = c0663vf3;
                    c0663vf = c0663vf3;
                }
            }
            return c0663vf;
        }
        return c0663vf2;
    }

    public final C0600t4 e(Context context) {
        C0600t4 c0600t4;
        File file;
        C0600t4 c0600t42 = this.w;
        if (c0600t42 == null) {
            synchronized (this) {
                c0600t4 = this.w;
                if (c0600t4 == null) {
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
                        c0600t4 = new C0600t4(file);
                        this.w = c0600t4;
                    }
                    file = null;
                    c0600t4 = new C0600t4(file);
                    this.w = c0600t4;
                }
            }
            return c0600t4;
        }
        return c0600t42;
    }

    public C0574s4(J6 j6, V7 v7, C0316i4 c0316i4, C0414m c0414m, S1 s1, C0466o c0466o, Bl bl, U5 u5, Nn nn, C0596t0 c0596t0) {
        this.m = new C0583sd();
        this.q = new B0();
        this.r = new X1();
        this.s = new C0762za();
        new U7();
        this.v = new Y7();
        this.f1194a = j6;
        this.b = v7;
        this.c = c0316i4;
        this.h = c0414m;
        this.d = s1;
        this.e = c0466o;
        this.f = bl;
        this.g = u5;
        this.i = nn;
        this.k = c0596t0;
    }

    public final B0 d() {
        return this.q;
    }

    public final C0183d0 b() {
        C0183d0 c0183d0;
        C0183d0 c0183d02 = this.t;
        if (c0183d02 == null) {
            synchronized (this) {
                c0183d0 = this.t;
                if (c0183d0 == null) {
                    c0183d0 = new C0183d0(this.q, this.f, this.c);
                    this.t = c0183d0;
                }
            }
            return c0183d0;
        }
        return c0183d02;
    }
}
