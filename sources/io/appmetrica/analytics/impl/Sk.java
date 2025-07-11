package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public final class Sk {
    public static final String d = "SESSION_SLEEP_START";
    public static final String e = "SESSION_LAST_EVENT_OFFSET";
    public static final String f = "SESSION_ID";
    public static final String g = "SESSION_COUNTER_ID";
    public static final String h = "SESSION_INIT_TIME";
    public static final String i = "SESSION_IS_ALIVE_REPORT_NEEDED";

    /* renamed from: a  reason: collision with root package name */
    public final String f631a;
    protected final Cif b;
    public C0728yb c;

    public Sk(Cif cif, String str) {
        this.b = cif;
        this.f631a = str;
        C0728yb c0728yb = new C0728yb();
        try {
            String h2 = cif.h(str);
            if (!TextUtils.isEmpty(h2)) {
                c0728yb = new C0728yb(h2);
            }
        } catch (Throwable unused) {
        }
        this.c = c0728yb;
    }

    public final Sk a(long j) {
        a(h, Long.valueOf(j));
        return this;
    }

    public final Sk b(long j) {
        a(e, Long.valueOf(j));
        return this;
    }

    public final Long c() {
        return this.c.a(h);
    }

    public final Sk d(long j) {
        a(f, Long.valueOf(j));
        return this;
    }

    public final Long e() {
        return this.c.a(g);
    }

    public final Long f() {
        return this.c.a(f);
    }

    public final Long g() {
        return this.c.a(d);
    }

    public final boolean h() {
        return this.c.length() > 0;
    }

    public final Boolean i() {
        C0728yb c0728yb = this.c;
        c0728yb.getClass();
        try {
            return Boolean.valueOf(c0728yb.getBoolean(i));
        } catch (Throwable unused) {
            return null;
        }
    }

    public final Sk a(boolean z) {
        a(i, Boolean.valueOf(z));
        return this;
    }

    public final void b() {
        this.b.e(this.f631a, this.c.toString());
        this.b.b();
    }

    public final Sk c(long j) {
        a(g, Long.valueOf(j));
        return this;
    }

    public final Long d() {
        return this.c.a(e);
    }

    public final Sk e(long j) {
        a(d, Long.valueOf(j));
        return this;
    }

    public final void a(String str, Object obj) {
        try {
            this.c.put(str, obj);
        } catch (Throwable unused) {
        }
    }

    public final void a() {
        this.c = new C0728yb();
        b();
    }
}
