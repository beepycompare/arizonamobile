package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.system.SystemPropertiesHelper;
import java.io.File;
import kotlin.text.StringsKt;
/* renamed from: io.appmetrica.analytics.impl.s4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0569s4 {
    public static volatile C0569s4 y;

    /* renamed from: a  reason: collision with root package name */
    public final J6 f1197a;
    public final V7 b;
    public final C0311i4 c;
    public final S1 d;
    public final C0461o e;
    public final Bl f;
    public final U5 g;
    public final C0409m h;
    public final Nn i;
    public Vd j;
    public final C0591t0 k;
    public volatile C0492p4 l;
    public final C0578sd m;
    public volatile C0658vf n;
    public volatile C0658vf o;
    public Cj p;
    public final B0 q;
    public final X1 r;
    public final C0757za s;
    public volatile C0178d0 t;
    public volatile C0291ha u;
    public volatile Y7 v;
    public volatile C0595t4 w;
    public volatile C0743ym x;

    public C0569s4(J6 j6, C0461o c0461o, C0311i4 c0311i4) {
        this(j6, c0461o, c0311i4, new C0409m(c0461o));
    }

    public static C0569s4 l() {
        if (y == null) {
            synchronized (C0569s4.class) {
                if (y == null) {
                    y = new C0569s4(new J6(), new C0461o(), new C0311i4());
                }
            }
        }
        return y;
    }

    public final C0461o a() {
        return this.e;
    }

    public final C0658vf b(Context context) {
        C0658vf c0658vf;
        C0658vf c0658vf2 = this.n;
        if (c0658vf2 == null) {
            synchronized (this) {
                c0658vf = this.n;
                if (c0658vf == null) {
                    C0595t4 e = e(context);
                    new C0414m4(c(context)).a(context);
                    C0658vf c0658vf3 = new C0658vf(e.a(context));
                    this.n = c0658vf3;
                    c0658vf = c0658vf3;
                }
            }
            return c0658vf;
        }
        return c0658vf2;
    }

    public final C0591t0 c() {
        return this.k;
    }

    public final C0743ym d(Context context) {
        C0743ym c0743ym;
        C0743ym c0743ym2 = this.x;
        if (c0743ym2 == null) {
            synchronized (this) {
                c0743ym = this.x;
                if (c0743ym == null) {
                    c0743ym = new C0743ym(context, b(context));
                    this.x = c0743ym;
                }
            }
            return c0743ym;
        }
        return c0743ym2;
    }

    public final S1 e() {
        return this.d;
    }

    public final X1 f() {
        return this.r;
    }

    public final C0311i4 g() {
        return this.c;
    }

    public final U5 h() {
        return this.g;
    }

    public final J6 i() {
        return this.f1197a;
    }

    public final V7 j() {
        return this.b;
    }

    public final C0757za k() {
        return this.s;
    }

    public final C0492p4 m() {
        C0492p4 c0492p4;
        C0492p4 c0492p42 = this.l;
        if (c0492p42 == null) {
            synchronized (this) {
                c0492p4 = this.l;
                if (c0492p4 == null) {
                    c0492p4 = new C0492p4();
                    this.l = c0492p4;
                }
            }
            return c0492p4;
        }
        return c0492p42;
    }

    public final J6 n() {
        return this.f1197a;
    }

    public final Bl o() {
        return this.f;
    }

    public C0569s4(J6 j6, C0461o c0461o, C0311i4 c0311i4, C0409m c0409m) {
        this(j6, new V7(), c0311i4, c0409m, new S1(), c0461o, new Bl(c0461o, c0409m), new U5(c0461o), new Nn(), new C0591t0());
    }

    public final synchronized Vd a(Context context) {
        if (this.j == null) {
            this.j = new Vd(context, new Po());
        }
        return this.j;
    }

    public final C0658vf c(Context context) {
        C0658vf c0658vf;
        C0658vf c0658vf2 = this.o;
        if (c0658vf2 == null) {
            synchronized (this) {
                c0658vf = this.o;
                if (c0658vf == null) {
                    C0658vf c0658vf3 = new C0658vf(e(context).b(context));
                    this.o = c0658vf3;
                    c0658vf = c0658vf3;
                }
            }
            return c0658vf;
        }
        return c0658vf2;
    }

    public final C0595t4 e(Context context) {
        C0595t4 c0595t4;
        File file;
        C0595t4 c0595t42 = this.w;
        if (c0595t42 == null) {
            synchronized (this) {
                c0595t4 = this.w;
                if (c0595t4 == null) {
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
                        c0595t4 = new C0595t4(file);
                        this.w = c0595t4;
                    }
                    file = null;
                    c0595t4 = new C0595t4(file);
                    this.w = c0595t4;
                }
            }
            return c0595t4;
        }
        return c0595t42;
    }

    public C0569s4(J6 j6, V7 v7, C0311i4 c0311i4, C0409m c0409m, S1 s1, C0461o c0461o, Bl bl, U5 u5, Nn nn, C0591t0 c0591t0) {
        this.m = new C0578sd();
        this.q = new B0();
        this.r = new X1();
        this.s = new C0757za();
        new U7();
        this.v = new Y7();
        this.f1197a = j6;
        this.b = v7;
        this.c = c0311i4;
        this.h = c0409m;
        this.d = s1;
        this.e = c0461o;
        this.f = bl;
        this.g = u5;
        this.i = nn;
        this.k = c0591t0;
    }

    public final B0 d() {
        return this.q;
    }

    public final C0178d0 b() {
        C0178d0 c0178d0;
        C0178d0 c0178d02 = this.t;
        if (c0178d02 == null) {
            synchronized (this) {
                c0178d0 = this.t;
                if (c0178d0 == null) {
                    c0178d0 = new C0178d0(this.q, this.f, this.c);
                    this.t = c0178d0;
                }
            }
            return c0178d0;
        }
        return c0178d02;
    }
}
