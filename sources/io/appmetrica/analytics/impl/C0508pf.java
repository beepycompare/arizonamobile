package io.appmetrica.analytics.impl;

import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.pf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0508pf extends Pd implements Do {
    public static final C0483of d = new C0483of("LOCATION_TRACKING_ENABLED", null);
    public static final C0483of e = new C0483of("PREF_KEY_OFFSET", null);
    public static final C0483of f = new C0483of("UNCHECKED_TIME", null);
    public static final C0483of g = new C0483of("STATISTICS_RESTRICTED_IN_MAIN", null);
    public static final C0483of h = new C0483of("LAST_IDENTITY_LIGHT_SEND_TIME", null);
    public static final C0483of i = new C0483of("NEXT_REPORT_SEND_ATTEMPT_NUMBER", null);
    public static final C0483of j = new C0483of("NEXT_LOCATION_SEND_ATTEMPT_NUMBER", null);
    public static final C0483of k = new C0483of("NEXT_STARTUP_SEND_ATTEMPT_NUMBER", null);
    public static final C0483of l = new C0483of("LAST_REPORT_SEND_ATTEMPT_TIME", null);
    public static final C0483of m = new C0483of("LAST_LOCATION_SEND_ATTEMPT_TIME", null);
    public static final C0483of n = new C0483of("LAST_STARTUP_SEND_ATTEMPT_TIME", null);
    public static final C0483of o = new C0483of("SATELLITE_PRELOAD_INFO_CHECKED", null);
    public static final C0483of p = new C0483of("SATELLITE_CLIDS_CHECKED", null);
    public static final C0483of q = new C0483of("VITAL_DATA", null);
    public static final C0483of r = new C0483of("LAST_KOTLIN_VERSION_SEND_TIME", null);
    public static final C0483of s = new C0483of("ADV_IDENTIFIERS_TRACKING_ENABLED", null);

    public C0508pf(InterfaceC0223eb interfaceC0223eb) {
        super(interfaceC0223eb);
    }

    public final long a(int i2) {
        return this.f983a.getLong(e.b, i2);
    }

    public final boolean b(boolean z) {
        return this.f983a.getBoolean(f.b, z);
    }

    public final C0508pf c(boolean z) {
        return (C0508pf) b(g.b, z);
    }

    public final C0508pf d(long j2) {
        return (C0508pf) b(e.b, j2);
    }

    public final boolean e() {
        return this.f983a.getBoolean(d.b, false);
    }

    public final void f(boolean z) {
        b(d.b, z).b();
    }

    public final C0508pf g() {
        return (C0508pf) b(p.b, true);
    }

    public final C0508pf h() {
        return (C0508pf) b(o.b, true);
    }

    public final boolean i() {
        return this.f983a.getBoolean(o.b, false);
    }

    public final boolean j() {
        return this.f983a.getBoolean(p.b, false);
    }

    public final long a(long j2) {
        return this.f983a.getLong(h.b, j2);
    }

    public final C0508pf b(long j2) {
        return (C0508pf) b(h.b, j2);
    }

    public final C0508pf c(long j2) {
        return (C0508pf) b(r.b, j2);
    }

    public final C0508pf d(boolean z) {
        return (C0508pf) b(f.b, z);
    }

    public final void e(boolean z) {
        b(s.b, z).b();
    }

    public final long f() {
        return this.f983a.getLong(r.b, 0L);
    }

    @Override // io.appmetrica.analytics.impl.Do
    public final String a() {
        return this.f983a.getString(q.b, null);
    }

    public final C0508pf b(EnumC0381ke enumC0381ke, int i2) {
        C0483of c0483of;
        int ordinal = enumC0381ke.ordinal();
        if (ordinal == 0) {
            c0483of = i;
        } else if (ordinal != 1) {
            c0483of = ordinal != 2 ? null : k;
        } else {
            c0483of = j;
        }
        return c0483of != null ? (C0508pf) b(c0483of.b, i2) : this;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0458nf
    public final Set<String> c() {
        return this.f983a.a();
    }

    public final Boolean d() {
        C0483of c0483of = g;
        if (this.f983a.a(c0483of.b)) {
            return Boolean.valueOf(this.f983a.getBoolean(c0483of.b, true));
        }
        return null;
    }

    @Override // io.appmetrica.analytics.impl.Pd
    public final String f(String str) {
        return new C0483of(str, null).b;
    }

    @Override // io.appmetrica.analytics.impl.Do
    public final void a(String str) {
        b(q.b, str).b();
    }

    public final boolean a(boolean z) {
        return this.f983a.getBoolean(s.b, z);
    }

    public final int a(EnumC0381ke enumC0381ke, int i2) {
        C0483of c0483of;
        int ordinal = enumC0381ke.ordinal();
        if (ordinal == 0) {
            c0483of = i;
        } else if (ordinal != 1) {
            c0483of = ordinal != 2 ? null : k;
        } else {
            c0483of = j;
        }
        if (c0483of == null) {
            return i2;
        }
        return this.f983a.getInt(c0483of.b, i2);
    }

    public final C0508pf b(EnumC0381ke enumC0381ke, long j2) {
        C0483of c0483of;
        int ordinal = enumC0381ke.ordinal();
        if (ordinal == 0) {
            c0483of = l;
        } else if (ordinal != 1) {
            c0483of = ordinal != 2 ? null : n;
        } else {
            c0483of = m;
        }
        return c0483of != null ? (C0508pf) b(c0483of.b, j2) : this;
    }

    public final long a(EnumC0381ke enumC0381ke, long j2) {
        C0483of c0483of;
        int ordinal = enumC0381ke.ordinal();
        if (ordinal == 0) {
            c0483of = l;
        } else if (ordinal != 1) {
            c0483of = ordinal != 2 ? null : n;
        } else {
            c0483of = m;
        }
        if (c0483of == null) {
            return j2;
        }
        return this.f983a.getLong(c0483of.b, j2);
    }
}
