package io.appmetrica.analytics.impl;

import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.ef  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0220ef extends Fd implements Do {
    public static final C0195df d = new C0195df("LOCATION_TRACKING_ENABLED", null);
    public static final C0195df e = new C0195df("PREF_KEY_OFFSET", null);
    public static final C0195df f = new C0195df("UNCHECKED_TIME", null);
    public static final C0195df g = new C0195df("STATISTICS_RESTRICTED_IN_MAIN", null);
    public static final C0195df h = new C0195df("LAST_IDENTITY_LIGHT_SEND_TIME", null);
    public static final C0195df i = new C0195df("NEXT_REPORT_SEND_ATTEMPT_NUMBER", null);
    public static final C0195df j = new C0195df("NEXT_LOCATION_SEND_ATTEMPT_NUMBER", null);
    public static final C0195df k = new C0195df("NEXT_STARTUP_SEND_ATTEMPT_NUMBER", null);
    public static final C0195df l = new C0195df("LAST_REPORT_SEND_ATTEMPT_TIME", null);
    public static final C0195df m = new C0195df("LAST_LOCATION_SEND_ATTEMPT_TIME", null);
    public static final C0195df n = new C0195df("LAST_STARTUP_SEND_ATTEMPT_TIME", null);
    public static final C0195df o = new C0195df("SATELLITE_PRELOAD_INFO_CHECKED", null);
    public static final C0195df p = new C0195df("SATELLITE_CLIDS_CHECKED", null);
    public static final C0195df q = new C0195df("VITAL_DATA", null);
    public static final C0195df r = new C0195df("LAST_KOTLIN_VERSION_SEND_TIME", null);
    public static final C0195df s = new C0195df("ADV_IDENTIFIERS_TRACKING_ENABLED", null);

    public C0220ef(Oa oa) {
        super(oa);
    }

    public final long a(int i2) {
        return this.f830a.getLong(e.b, i2);
    }

    public final boolean b(boolean z) {
        return this.f830a.getBoolean(f.b, z);
    }

    public final C0220ef c(boolean z) {
        return (C0220ef) b(g.b, z);
    }

    public final C0220ef d(long j2) {
        return (C0220ef) b(e.b, j2);
    }

    public final boolean e() {
        return this.f830a.getBoolean(d.b, false);
    }

    public final void f(boolean z) {
        b(d.b, z).b();
    }

    public final C0220ef g() {
        return (C0220ef) b(p.b, true);
    }

    public final C0220ef h() {
        return (C0220ef) b(o.b, true);
    }

    public final boolean i() {
        return this.f830a.getBoolean(o.b, false);
    }

    public final boolean j() {
        return this.f830a.getBoolean(p.b, false);
    }

    public final long a(long j2) {
        return this.f830a.getLong(h.b, j2);
    }

    public final C0220ef b(long j2) {
        return (C0220ef) b(h.b, j2);
    }

    public final C0220ef c(long j2) {
        return (C0220ef) b(r.b, j2);
    }

    public final C0220ef d(boolean z) {
        return (C0220ef) b(f.b, z);
    }

    public final void e(boolean z) {
        b(s.b, z).b();
    }

    public final long f() {
        return this.f830a.getLong(r.b, 0L);
    }

    @Override // io.appmetrica.analytics.impl.Do
    public final String a() {
        return this.f830a.getString(q.b, null);
    }

    public final C0220ef b(EnumC0116ae enumC0116ae, int i2) {
        C0195df c0195df;
        int ordinal = enumC0116ae.ordinal();
        if (ordinal == 0) {
            c0195df = i;
        } else if (ordinal != 1) {
            c0195df = ordinal != 2 ? null : k;
        } else {
            c0195df = j;
        }
        return c0195df != null ? (C0220ef) b(c0195df.b, i2) : this;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0169cf
    public final Set<String> c() {
        return this.f830a.a();
    }

    public final Boolean d() {
        C0195df c0195df = g;
        if (this.f830a.a(c0195df.b)) {
            return Boolean.valueOf(this.f830a.getBoolean(c0195df.b, true));
        }
        return null;
    }

    @Override // io.appmetrica.analytics.impl.Fd
    public final String f(String str) {
        return new C0195df(str, null).b;
    }

    @Override // io.appmetrica.analytics.impl.Do
    public final void a(String str) {
        b(q.b, str).b();
    }

    public final boolean a(boolean z) {
        return this.f830a.getBoolean(s.b, z);
    }

    public final int a(EnumC0116ae enumC0116ae, int i2) {
        C0195df c0195df;
        int ordinal = enumC0116ae.ordinal();
        if (ordinal == 0) {
            c0195df = i;
        } else if (ordinal != 1) {
            c0195df = ordinal != 2 ? null : k;
        } else {
            c0195df = j;
        }
        if (c0195df == null) {
            return i2;
        }
        return this.f830a.getInt(c0195df.b, i2);
    }

    public final C0220ef b(EnumC0116ae enumC0116ae, long j2) {
        C0195df c0195df;
        int ordinal = enumC0116ae.ordinal();
        if (ordinal == 0) {
            c0195df = l;
        } else if (ordinal != 1) {
            c0195df = ordinal != 2 ? null : n;
        } else {
            c0195df = m;
        }
        return c0195df != null ? (C0220ef) b(c0195df.b, j2) : this;
    }

    public final long a(EnumC0116ae enumC0116ae, long j2) {
        C0195df c0195df;
        int ordinal = enumC0116ae.ordinal();
        if (ordinal == 0) {
            c0195df = l;
        } else if (ordinal != 1) {
            c0195df = ordinal != 2 ? null : n;
        } else {
            c0195df = m;
        }
        if (c0195df == null) {
            return j2;
        }
        return this.f830a.getLong(c0195df.b, j2);
    }
}
