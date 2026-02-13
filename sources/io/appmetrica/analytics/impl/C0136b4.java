package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.system.SystemPropertiesHelper;
import java.io.File;
import kotlin.text.StringsKt;
/* renamed from: io.appmetrica.analytics.impl.b4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0136b4 {
    public static volatile C0136b4 w;

    /* renamed from: a  reason: collision with root package name */
    public final C0544r6 f911a;
    public final D7 b;
    public final R3 c;
    public final F1 d;
    public final C0463o e;
    public final Wk f;
    public final E5 g;
    public final C0413m h;
    public final C0437mn i;
    public C0651vd j;
    public final C0538r0 k;
    public volatile Y3 l;
    public final Sc m;
    public volatile Ve n;
    public C0151bj o;
    public final C0738z0 p;
    public final K1 q;
    public final C0168ca r;
    public volatile C0132b0 s;
    public volatile M9 t;
    public volatile G7 u;
    public volatile C0162c4 v;

    public C0136b4(C0544r6 c0544r6, C0463o c0463o, R3 r3) {
        this(c0544r6, c0463o, r3, new C0413m(c0463o));
    }

    public static C0136b4 l() {
        if (w == null) {
            synchronized (C0136b4.class) {
                if (w == null) {
                    w = new C0136b4(new C0544r6(), new C0463o(), new R3());
                }
            }
        }
        return w;
    }

    public final C0463o a() {
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

    public final C0538r0 c() {
        return this.k;
    }

    public final C0738z0 d() {
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

    public final C0544r6 i() {
        return this.f911a;
    }

    public final D7 j() {
        return this.b;
    }

    public final C0168ca k() {
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

    public final C0544r6 n() {
        return this.f911a;
    }

    public final Wk o() {
        return this.f;
    }

    public C0136b4(C0544r6 c0544r6, C0463o c0463o, R3 r3, C0413m c0413m) {
        this(c0544r6, new D7(), r3, c0413m, new F1(), c0463o, new Wk(c0463o, c0413m), new E5(c0463o), new C0437mn(), new C0538r0());
    }

    public final synchronized C0651vd a(Context context) {
        if (this.j == null) {
            this.j = new C0651vd(context, new mo());
        }
        return this.j;
    }

    public final C0162c4 c(Context context) {
        C0162c4 c0162c4;
        File file;
        C0162c4 c0162c42 = this.v;
        if (c0162c42 == null) {
            synchronized (this) {
                c0162c4 = this.v;
                if (c0162c4 == null) {
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
                        c0162c4 = new C0162c4(file);
                        this.v = c0162c4;
                    }
                    file = null;
                    c0162c4 = new C0162c4(file);
                    this.v = c0162c4;
                }
            }
            return c0162c4;
        }
        return c0162c42;
    }

    public C0136b4(C0544r6 c0544r6, D7 d7, R3 r3, C0413m c0413m, F1 f1, C0463o c0463o, Wk wk, E5 e5, C0437mn c0437mn, C0538r0 c0538r0) {
        this.m = new Sc();
        this.p = new C0738z0();
        this.q = new K1();
        this.r = new C0168ca();
        new C7();
        this.u = new G7();
        this.f911a = c0544r6;
        this.b = d7;
        this.c = r3;
        this.h = c0413m;
        this.d = f1;
        this.e = c0463o;
        this.f = wk;
        this.g = e5;
        this.i = c0437mn;
        this.k = c0538r0;
    }

    public final C0132b0 b() {
        C0132b0 c0132b0;
        C0132b0 c0132b02 = this.s;
        if (c0132b02 == null) {
            synchronized (this) {
                c0132b0 = this.s;
                if (c0132b0 == null) {
                    c0132b0 = new C0132b0(this.p, this.f, this.c);
                    this.s = c0132b0;
                }
            }
            return c0132b0;
        }
        return c0132b02;
    }
}
