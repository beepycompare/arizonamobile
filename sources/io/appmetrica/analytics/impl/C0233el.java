package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* renamed from: io.appmetrica.analytics.impl.el  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0233el {
    public static final String d = "SESSION_SLEEP_START";
    public static final String e = "SESSION_LAST_EVENT_OFFSET";
    public static final String f = "SESSION_ID";
    public static final String g = "SESSION_COUNTER_ID";
    public static final String h = "SESSION_INIT_TIME";
    public static final String i = "SESSION_IS_ALIVE_REPORT_NEEDED";

    /* renamed from: a  reason: collision with root package name */
    public final String f867a;
    protected final C0537qf b;
    public Fb c;

    public C0233el(C0537qf c0537qf, String str) {
        this.b = c0537qf;
        this.f867a = str;
        Fb fb = new Fb();
        try {
            String h2 = c0537qf.h(str);
            if (!TextUtils.isEmpty(h2)) {
                fb = new Fb(h2);
            }
        } catch (Throwable unused) {
        }
        this.c = fb;
    }

    public final C0233el a(long j) {
        a(h, Long.valueOf(j));
        return this;
    }

    public final C0233el b(long j) {
        a(e, Long.valueOf(j));
        return this;
    }

    public final Long c() {
        return this.c.a(h);
    }

    public final C0233el d(long j) {
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
        Fb fb = this.c;
        fb.getClass();
        try {
            return Boolean.valueOf(fb.getBoolean(i));
        } catch (Throwable unused) {
            return null;
        }
    }

    public final C0233el a(boolean z) {
        a(i, Boolean.valueOf(z));
        return this;
    }

    public final void b() {
        this.b.e(this.f867a, this.c.toString());
        this.b.b();
    }

    public final C0233el c(long j) {
        a(g, Long.valueOf(j));
        return this;
    }

    public final Long d() {
        return this.c.a(e);
    }

    public final C0233el e(long j) {
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
        this.c = new Fb();
        b();
    }
}
