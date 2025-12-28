package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.system.SystemPropertiesHelper;
import java.io.File;
import kotlin.text.StringsKt;
/* renamed from: io.appmetrica.analytics.impl.c4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0157c4 {
    public static volatile C0157c4 w;

    /* renamed from: a  reason: collision with root package name */
    public final C0565s6 f921a;
    public final E7 b;
    public final S3 c;
    public final G1 d;
    public final C0459o e;
    public final Xk f;
    public final F5 g;
    public final C0409m h;
    public final C0458nn i;
    public C0672wd j;
    public final C0534r0 k;
    public volatile Z3 l;
    public final Tc m;
    public volatile We n;
    public C0172cj o;
    public final C0734z0 p;
    public final L1 q;
    public final C0189da r;
    public volatile C0127b0 s;
    public volatile N9 t;
    public volatile H7 u;
    public volatile C0183d4 v;

    public C0157c4(C0565s6 c0565s6, C0459o c0459o, S3 s3) {
        this(c0565s6, c0459o, s3, new C0409m(c0459o));
    }

    public static C0157c4 l() {
        if (w == null) {
            synchronized (C0157c4.class) {
                if (w == null) {
                    w = new C0157c4(new C0565s6(), new C0459o(), new S3());
                }
            }
        }
        return w;
    }

    public final C0459o a() {
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

    public final C0534r0 c() {
        return this.k;
    }

    public final C0734z0 d() {
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

    public final C0565s6 i() {
        return this.f921a;
    }

    public final E7 j() {
        return this.b;
    }

    public final C0189da k() {
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

    public final C0565s6 n() {
        return this.f921a;
    }

    public final Xk o() {
        return this.f;
    }

    public C0157c4(C0565s6 c0565s6, C0459o c0459o, S3 s3, C0409m c0409m) {
        this(c0565s6, new E7(), s3, c0409m, new G1(), c0459o, new Xk(c0459o, c0409m), new F5(c0459o), new C0458nn(), new C0534r0());
    }

    public final synchronized C0672wd a(Context context) {
        if (this.j == null) {
            this.j = new C0672wd(context, new no());
        }
        return this.j;
    }

    public final C0183d4 c(Context context) {
        C0183d4 c0183d4;
        File file;
        C0183d4 c0183d42 = this.v;
        if (c0183d42 == null) {
            synchronized (this) {
                c0183d4 = this.v;
                if (c0183d4 == null) {
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
                        c0183d4 = new C0183d4(file);
                        this.v = c0183d4;
                    }
                    file = null;
                    c0183d4 = new C0183d4(file);
                    this.v = c0183d4;
                }
            }
            return c0183d4;
        }
        return c0183d42;
    }

    public C0157c4(C0565s6 c0565s6, E7 e7, S3 s3, C0409m c0409m, G1 g1, C0459o c0459o, Xk xk, F5 f5, C0458nn c0458nn, C0534r0 c0534r0) {
        this.m = new Tc();
        this.p = new C0734z0();
        this.q = new L1();
        this.r = new C0189da();
        new D7();
        this.u = new H7();
        this.f921a = c0565s6;
        this.b = e7;
        this.c = s3;
        this.h = c0409m;
        this.d = g1;
        this.e = c0459o;
        this.f = xk;
        this.g = f5;
        this.i = c0458nn;
        this.k = c0534r0;
    }

    public final C0127b0 b() {
        C0127b0 c0127b0;
        C0127b0 c0127b02 = this.s;
        if (c0127b02 == null) {
            synchronized (this) {
                c0127b0 = this.s;
                if (c0127b0 == null) {
                    c0127b0 = new C0127b0(this.p, this.f, this.c);
                    this.s = c0127b0;
                }
            }
            return c0127b0;
        }
        return c0127b02;
    }
}
