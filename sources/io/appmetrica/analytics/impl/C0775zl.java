package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.zl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0775zl {
    public static final String d = "SESSION_SLEEP_START";
    public static final String e = "SESSION_LAST_EVENT_OFFSET";
    public static final String f = "SESSION_ID";
    public static final String g = "SESSION_COUNTER_ID";
    public static final String h = "SESSION_INIT_TIME";
    public static final String i = "SESSION_CREATION_CURRENT_TIME";
    public static final String j = "SESSION_IS_ALIVE_REPORT_NEEDED";
    public static final String k = "SESSION_CRASHED";

    /* renamed from: a  reason: collision with root package name */
    public final String f1323a;
    protected final C0691wf b;
    public Hb c;

    public C0775zl(C0691wf c0691wf, String str) {
        this.b = c0691wf;
        this.f1323a = str;
        Hb hb = new Hb();
        try {
            String h2 = c0691wf.h(str);
            if (!StringUtils.isNullOrEmpty(h2)) {
                hb = new Hb(h2);
            }
        } catch (Throwable unused) {
        }
        this.c = hb;
    }

    public final C0775zl a(long j2) {
        a(i, Long.valueOf(j2));
        return this;
    }

    public final C0775zl b(long j2) {
        a(h, Long.valueOf(j2));
        return this;
    }

    public final Long c() {
        return this.c.b(i);
    }

    public final Long d() {
        return this.c.b(h);
    }

    public final C0775zl e(long j2) {
        a(f, Long.valueOf(j2));
        return this;
    }

    public final Long f() {
        return this.c.b(g);
    }

    public final Long g() {
        return this.c.b(f);
    }

    public final Long h() {
        return this.c.b(d);
    }

    public final boolean i() {
        return this.c.length() > 0;
    }

    public final Boolean j() {
        return this.c.a(j);
    }

    public final Boolean k() {
        return this.c.a(k);
    }

    public final C0775zl a(boolean z) {
        a(j, Boolean.valueOf(z));
        return this;
    }

    public final C0775zl b(boolean z) {
        a(k, Boolean.valueOf(z));
        return this;
    }

    public final C0775zl c(long j2) {
        a(e, Long.valueOf(j2));
        return this;
    }

    public final C0775zl d(long j2) {
        a(g, Long.valueOf(j2));
        return this;
    }

    public final Long e() {
        return this.c.b(e);
    }

    public final C0775zl f(long j2) {
        a(d, Long.valueOf(j2));
        return this;
    }

    public final void a() {
        this.b.e(this.f1323a, this.c.toString());
    }

    public final void b() {
        this.c = new Hb();
        a();
    }

    public final void a(String str, Object obj) {
        try {
            this.c.put(str, obj);
        } catch (Throwable unused) {
        }
    }
}
