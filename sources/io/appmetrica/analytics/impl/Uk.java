package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public final class Uk {
    public static final String d = "SESSION_SLEEP_START";
    public static final String e = "SESSION_LAST_EVENT_OFFSET";
    public static final String f = "SESSION_ID";
    public static final String g = "SESSION_COUNTER_ID";
    public static final String h = "SESSION_INIT_TIME";
    public static final String i = "SESSION_IS_ALIVE_REPORT_NEEDED";

    /* renamed from: a  reason: collision with root package name */
    public final String f815a;
    protected final We b;
    public C0246fb c;

    public Uk(We we, String str) {
        this.b = we;
        this.f815a = str;
        C0246fb c0246fb = new C0246fb();
        try {
            String h2 = we.h(str);
            if (!TextUtils.isEmpty(h2)) {
                c0246fb = new C0246fb(h2);
            }
        } catch (Throwable unused) {
        }
        this.c = c0246fb;
    }

    public final Uk a(long j) {
        a(h, Long.valueOf(j));
        return this;
    }

    public final Uk b(long j) {
        a(e, Long.valueOf(j));
        return this;
    }

    public final Long c() {
        return this.c.a(h);
    }

    public final Uk d(long j) {
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
        C0246fb c0246fb = this.c;
        c0246fb.getClass();
        try {
            return Boolean.valueOf(c0246fb.getBoolean(i));
        } catch (Throwable unused) {
            return null;
        }
    }

    public final Uk a(boolean z) {
        a(i, Boolean.valueOf(z));
        return this;
    }

    public final void b() {
        this.b.e(this.f815a, this.c.toString());
        this.b.b();
    }

    public final Uk c(long j) {
        a(g, Long.valueOf(j));
        return this;
    }

    public final Long d() {
        return this.c.a(e);
    }

    public final Uk e(long j) {
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
        this.c = new C0246fb();
        b();
    }
}
