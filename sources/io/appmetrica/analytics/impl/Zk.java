package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public final class Zk {
    public static final String d = "SESSION_SLEEP_START";
    public static final String e = "SESSION_LAST_EVENT_OFFSET";
    public static final String f = "SESSION_ID";
    public static final String g = "SESSION_COUNTER_ID";
    public static final String h = "SESSION_INIT_TIME";
    public static final String i = "SESSION_IS_ALIVE_REPORT_NEEDED";

    /* renamed from: a  reason: collision with root package name */
    public final String f790a;
    protected final C0143bf b;
    public C0422mb c;

    public Zk(C0143bf c0143bf, String str) {
        this.b = c0143bf;
        this.f790a = str;
        C0422mb c0422mb = new C0422mb();
        try {
            String h2 = c0143bf.h(str);
            if (!TextUtils.isEmpty(h2)) {
                c0422mb = new C0422mb(h2);
            }
        } catch (Throwable unused) {
        }
        this.c = c0422mb;
    }

    public final Zk a(long j) {
        a(h, Long.valueOf(j));
        return this;
    }

    public final Zk b(long j) {
        a(e, Long.valueOf(j));
        return this;
    }

    public final Long c() {
        return this.c.a(h);
    }

    public final Zk d(long j) {
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
        C0422mb c0422mb = this.c;
        c0422mb.getClass();
        try {
            return Boolean.valueOf(c0422mb.getBoolean(i));
        } catch (Throwable unused) {
            return null;
        }
    }

    public final Zk a(boolean z) {
        a(i, Boolean.valueOf(z));
        return this;
    }

    public final void b() {
        this.b.e(this.f790a, this.c.toString());
        this.b.b();
    }

    public final Zk c(long j) {
        a(g, Long.valueOf(j));
        return this;
    }

    public final Long d() {
        return this.c.a(e);
    }

    public final Zk e(long j) {
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
        this.c = new C0422mb();
        b();
    }
}
