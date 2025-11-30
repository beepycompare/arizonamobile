package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.system.SystemPropertiesHelper;
import java.io.File;
import kotlin.text.StringsKt;
/* renamed from: io.appmetrica.analytics.impl.c4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0158c4 {
    public static volatile C0158c4 w;

    /* renamed from: a  reason: collision with root package name */
    public final C0566s6 f823a;
    public final E7 b;
    public final S3 c;
    public final G1 d;
    public final C0460o e;
    public final Xk f;
    public final F5 g;
    public final C0410m h;
    public final C0459nn i;
    public C0673wd j;
    public final C0535r0 k;
    public volatile Z3 l;
    public final Tc m;
    public volatile We n;
    public C0173cj o;
    public final C0735z0 p;
    public final L1 q;
    public final C0190da r;
    public volatile C0128b0 s;
    public volatile N9 t;
    public volatile H7 u;
    public volatile C0184d4 v;

    public C0158c4(C0566s6 c0566s6, C0460o c0460o, S3 s3) {
        this(c0566s6, c0460o, s3, new C0410m(c0460o));
    }

    public static C0158c4 l() {
        if (w == null) {
            synchronized (C0158c4.class) {
                if (w == null) {
                    w = new C0158c4(new C0566s6(), new C0460o(), new S3());
                }
            }
        }
        return w;
    }

    public final C0460o a() {
        return this.e;
    }

    public final We b(Context context) {
        We we;
        We we2 = this.n;
        if (we2 == null) {
            synchronized (this) {
                we = this.n;
                if (we == null) {
                    we = new We(c(context).a(context));
                    this.n = we;
                }
            }
            return we;
        }
        return we2;
    }

    public final C0535r0 c() {
        return this.k;
    }

    public final C0735z0 d() {
        return this.p;
    }

    public final G1 e() {
        return this.d;
    }

    public final L1 f() {
        return this.q;
    }

    public final S3 g() {
        return this.c;
    }

    public final F5 h() {
        return this.g;
    }

    public final C0566s6 i() {
        return this.f823a;
    }

    public final E7 j() {
        return this.b;
    }

    public final C0190da k() {
        return this.r;
    }

    public final Z3 m() {
        Z3 z3;
        Z3 z32 = this.l;
        if (z32 == null) {
            synchronized (this) {
                z3 = this.l;
                if (z3 == null) {
                    z3 = new Z3();
                    this.l = z3;
                }
            }
            return z3;
        }
        return z32;
    }

    public final C0566s6 n() {
        return this.f823a;
    }

    public final Xk o() {
        return this.f;
    }

    public C0158c4(C0566s6 c0566s6, C0460o c0460o, S3 s3, C0410m c0410m) {
        this(c0566s6, new E7(), s3, c0410m, new G1(), c0460o, new Xk(c0460o, c0410m), new F5(c0460o), new C0459nn(), new C0535r0());
    }

    public final synchronized C0673wd a(Context context) {
        if (this.j == null) {
            this.j = new C0673wd(context, new no());
        }
        return this.j;
    }

    public final C0184d4 c(Context context) {
        C0184d4 c0184d4;
        File file;
        C0184d4 c0184d42 = this.v;
        if (c0184d42 == null) {
            synchronized (this) {
                c0184d4 = this.v;
                if (c0184d4 == null) {
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
                        c0184d4 = new C0184d4(file);
                        this.v = c0184d4;
                    }
                    file = null;
                    c0184d4 = new C0184d4(file);
                    this.v = c0184d4;
                }
            }
            return c0184d4;
        }
        return c0184d42;
    }

    public C0158c4(C0566s6 c0566s6, E7 e7, S3 s3, C0410m c0410m, G1 g1, C0460o c0460o, Xk xk, F5 f5, C0459nn c0459nn, C0535r0 c0535r0) {
        this.m = new Tc();
        this.p = new C0735z0();
        this.q = new L1();
        this.r = new C0190da();
        new D7();
        this.u = new H7();
        this.f823a = c0566s6;
        this.b = e7;
        this.c = s3;
        this.h = c0410m;
        this.d = g1;
        this.e = c0460o;
        this.f = xk;
        this.g = f5;
        this.i = c0459nn;
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
