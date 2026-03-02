package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.system.SystemPropertiesHelper;
import java.io.File;
import kotlin.text.StringsKt;
/* renamed from: io.appmetrica.analytics.impl.b4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0135b4 {
    public static volatile C0135b4 w;

    /* renamed from: a  reason: collision with root package name */
    public final C0543r6 f911a;
    public final D7 b;
    public final R3 c;
    public final F1 d;
    public final C0462o e;
    public final Wk f;
    public final E5 g;
    public final C0412m h;
    public final C0436mn i;
    public C0650vd j;
    public final C0537r0 k;
    public volatile Y3 l;
    public final Sc m;
    public volatile Ve n;
    public C0150bj o;
    public final C0737z0 p;
    public final K1 q;
    public final C0167ca r;
    public volatile C0131b0 s;
    public volatile M9 t;
    public volatile G7 u;
    public volatile C0161c4 v;

    public C0135b4(C0543r6 c0543r6, C0462o c0462o, R3 r3) {
        this(c0543r6, c0462o, r3, new C0412m(c0462o));
    }

    public static C0135b4 l() {
        if (w == null) {
            synchronized (C0135b4.class) {
                if (w == null) {
                    w = new C0135b4(new C0543r6(), new C0462o(), new R3());
                }
            }
        }
        return w;
    }

    public final C0462o a() {
        return this.e;
    }

    public final Ve b(Context context) {
        Ve ve;
        Ve ve2 = this.n;
        if (ve2 == null) {
            synchronized (this) {
                ve = this.n;
                if (ve == null) {
                    ve = new Ve(c(context).a(context));
                    this.n = ve;
                }
            }
            return ve;
        }
        return ve2;
    }

    public final C0537r0 c() {
        return this.k;
    }

    public final C0737z0 d() {
        return this.p;
    }

    public final F1 e() {
        return this.d;
    }

    public final K1 f() {
        return this.q;
    }

    public final R3 g() {
        return this.c;
    }

    public final E5 h() {
        return this.g;
    }

    public final C0543r6 i() {
        return this.f911a;
    }

    public final D7 j() {
        return this.b;
    }

    public final C0167ca k() {
        return this.r;
    }

    public final Y3 m() {
        Y3 y3;
        Y3 y32 = this.l;
        if (y32 == null) {
            synchronized (this) {
                y3 = this.l;
                if (y3 == null) {
                    y3 = new Y3();
                    this.l = y3;
                }
            }
            return y3;
        }
        return y32;
    }

    public final C0543r6 n() {
        return this.f911a;
    }

    public final Wk o() {
        return this.f;
    }

    public C0135b4(C0543r6 c0543r6, C0462o c0462o, R3 r3, C0412m c0412m) {
        this(c0543r6, new D7(), r3, c0412m, new F1(), c0462o, new Wk(c0462o, c0412m), new E5(c0462o), new C0436mn(), new C0537r0());
    }

    public final synchronized C0650vd a(Context context) {
        if (this.j == null) {
            this.j = new C0650vd(context, new mo());
        }
        return this.j;
    }

    public final C0161c4 c(Context context) {
        C0161c4 c0161c4;
        File file;
        C0161c4 c0161c42 = this.v;
        if (c0161c42 == null) {
            synchronized (this) {
                c0161c4 = this.v;
                if (c0161c4 == null) {
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
                        c0161c4 = new C0161c4(file);
                        this.v = c0161c4;
                    }
                    file = null;
                    c0161c4 = new C0161c4(file);
                    this.v = c0161c4;
                }
            }
            return c0161c4;
        }
        return c0161c42;
    }

    public C0135b4(C0543r6 c0543r6, D7 d7, R3 r3, C0412m c0412m, F1 f1, C0462o c0462o, Wk wk, E5 e5, C0436mn c0436mn, C0537r0 c0537r0) {
        this.m = new Sc();
        this.p = new C0737z0();
        this.q = new K1();
        this.r = new C0167ca();
        new C7();
        this.u = new G7();
        this.f911a = c0543r6;
        this.b = d7;
        this.c = r3;
        this.h = c0412m;
        this.d = f1;
        this.e = c0462o;
        this.f = wk;
        this.g = e5;
        this.i = c0436mn;
        this.k = c0537r0;
    }

    public final C0131b0 b() {
        C0131b0 c0131b0;
        C0131b0 c0131b02 = this.s;
        if (c0131b02 == null) {
            synchronized (this) {
                c0131b0 = this.s;
                if (c0131b0 == null) {
                    c0131b0 = new C0131b0(this.p, this.f, this.c);
                    this.s = c0131b0;
                }
            }
            return c0131b0;
        }
        return c0131b02;
    }
}
