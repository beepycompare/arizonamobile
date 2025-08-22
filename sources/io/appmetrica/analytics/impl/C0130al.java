package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* renamed from: io.appmetrica.analytics.impl.al  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0130al {
    public static final String d = "SESSION_SLEEP_START";
    public static final String e = "SESSION_LAST_EVENT_OFFSET";
    public static final String f = "SESSION_ID";
    public static final String g = "SESSION_COUNTER_ID";
    public static final String h = "SESSION_INIT_TIME";
    public static final String i = "SESSION_IS_ALIVE_REPORT_NEEDED";

    /* renamed from: a  reason: collision with root package name */
    public final String f784a;
    protected final C0433mf b;
    public Cb c;

    public C0130al(C0433mf c0433mf, String str) {
        this.b = c0433mf;
        this.f784a = str;
        Cb cb = new Cb();
        try {
            String h2 = c0433mf.h(str);
            if (!TextUtils.isEmpty(h2)) {
                cb = new Cb(h2);
            }
        } catch (Throwable unused) {
        }
        this.c = cb;
    }

    public final C0130al a(long j) {
        a(h, Long.valueOf(j));
        return this;
    }

    public final C0130al b(long j) {
        a(e, Long.valueOf(j));
        return this;
    }

    public final Long c() {
        return this.c.a(h);
    }

    public final C0130al d(long j) {
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
        Cb cb = this.c;
        cb.getClass();
        try {
            return Boolean.valueOf(cb.getBoolean(i));
        } catch (Throwable unused) {
            return null;
        }
    }

    public final C0130al a(boolean z) {
        a(i, Boolean.valueOf(z));
        return this;
    }

    public final void b() {
        this.b.e(this.f784a, this.c.toString());
        this.b.b();
    }

    public final C0130al c(long j) {
        a(g, Long.valueOf(j));
        return this;
    }

    public final Long d() {
        return this.c.a(e);
    }

    public final C0130al e(long j) {
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
        this.c = new Cb();
        b();
    }
}
