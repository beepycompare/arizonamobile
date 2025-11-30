package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public final class Vk {
    public static final String d = "SESSION_SLEEP_START";
    public static final String e = "SESSION_LAST_EVENT_OFFSET";
    public static final String f = "SESSION_ID";
    public static final String g = "SESSION_COUNTER_ID";
    public static final String h = "SESSION_INIT_TIME";
    public static final String i = "SESSION_IS_ALIVE_REPORT_NEEDED";

    /* renamed from: a  reason: collision with root package name */
    public final String f727a;
    protected final Xe b;
    public C0268gb c;

    public Vk(Xe xe, String str) {
        this.b = xe;
        this.f727a = str;
        C0268gb c0268gb = new C0268gb();
        try {
            String h2 = xe.h(str);
            if (!TextUtils.isEmpty(h2)) {
                c0268gb = new C0268gb(h2);
            }
        } catch (Throwable unused) {
        }
        this.c = c0268gb;
    }

    public final Vk a(long j) {
        a(h, Long.valueOf(j));
        return this;
    }

    public final Vk b(long j) {
        a(e, Long.valueOf(j));
        return this;
    }

    public final Long c() {
        return this.c.a(h);
    }

    public final Vk d(long j) {
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
        C0268gb c0268gb = this.c;
        c0268gb.getClass();
        try {
            return Boolean.valueOf(c0268gb.getBoolean(i));
        } catch (Throwable unused) {
            return null;
        }
    }

    public final Vk a(boolean z) {
        a(i, Boolean.valueOf(z));
        return this;
    }

    public final void b() {
        this.b.e(this.f727a, this.c.toString());
        this.b.b();
    }

    public final Vk c(long j) {
        a(g, Long.valueOf(j));
        return this;
    }

    public final Long d() {
        return this.c.a(e);
    }

    public final Vk e(long j) {
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
        this.c = new C0268gb();
        b();
    }
}
