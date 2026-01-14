package io.appmetrica.analytics.impl;

import java.util.Set;
/* loaded from: classes5.dex */
public final class Ze extends AbstractC0726yd implements Bo {
    public static final Ye d = new Ye("LOCATION_TRACKING_ENABLED", null);
    public static final Ye e = new Ye("PREF_KEY_OFFSET", null);
    public static final Ye f = new Ye("UNCHECKED_TIME", null);
    public static final Ye g = new Ye("STATISTICS_RESTRICTED_IN_MAIN", null);
    public static final Ye h = new Ye("LAST_IDENTITY_LIGHT_SEND_TIME", null);
    public static final Ye i = new Ye("NEXT_REPORT_SEND_ATTEMPT_NUMBER", null);
    public static final Ye j = new Ye("NEXT_LOCATION_SEND_ATTEMPT_NUMBER", null);
    public static final Ye k = new Ye("NEXT_STARTUP_SEND_ATTEMPT_NUMBER", null);
    public static final Ye l = new Ye("LAST_REPORT_SEND_ATTEMPT_TIME", null);
    public static final Ye m = new Ye("LAST_LOCATION_SEND_ATTEMPT_TIME", null);
    public static final Ye n = new Ye("LAST_STARTUP_SEND_ATTEMPT_TIME", null);
    public static final Ye o = new Ye("SATELLITE_PRELOAD_INFO_CHECKED", null);
    public static final Ye p = new Ye("SATELLITE_CLIDS_CHECKED", null);
    public static final Ye q = new Ye("VITAL_DATA", null);
    public static final Ye r = new Ye("LAST_KOTLIN_VERSION_SEND_TIME", null);
    public static final Ye s = new Ye("ADV_IDENTIFIERS_TRACKING_ENABLED", null);

    public Ze(Ha ha) {
        super(ha);
    }

    public final long a(int i2) {
        return this.f854a.getLong(e.b, i2);
    }

    public final boolean b(boolean z) {
        return this.f854a.getBoolean(f.b, z);
    }

    public final Ze c(boolean z) {
        return (Ze) b(g.b, z);
    }

    public final Ze d(long j2) {
        return (Ze) b(e.b, j2);
    }

    public final boolean e() {
        return this.f854a.getBoolean(d.b, false);
    }

    public final void f(boolean z) {
        b(d.b, z).b();
    }

    public final Ze g() {
        return (Ze) b(p.b, true);
    }

    public final Ze h() {
        return (Ze) b(o.b, true);
    }

    public final boolean i() {
        return this.f854a.getBoolean(o.b, false);
    }

    public final boolean j() {
        return this.f854a.getBoolean(p.b, false);
    }

    public final long a(long j2) {
        return this.f854a.getLong(h.b, j2);
    }

    public final Ze b(long j2) {
        return (Ze) b(h.b, j2);
    }

    public final Ze c(long j2) {
        return (Ze) b(r.b, j2);
    }

    public final Ze d(boolean z) {
        return (Ze) b(f.b, z);
    }

    public final void e(boolean z) {
        b(s.b, z).b();
    }

    public final long f() {
        return this.f854a.getLong(r.b, 0L);
    }

    @Override // io.appmetrica.analytics.impl.Bo
    public final String a() {
        return this.f854a.getString(q.b, null);
    }

    public final Ze b(Td td, int i2) {
        Ye ye;
        int ordinal = td.ordinal();
        if (ordinal == 0) {
            ye = i;
        } else if (ordinal != 1) {
            ye = ordinal != 2 ? null : k;
        } else {
            ye = j;
        }
        return ye != null ? (Ze) b(ye.b, i2) : this;
    }

    @Override // io.appmetrica.analytics.impl.Xe
    public final Set<String> c() {
        return this.f854a.a();
    }

    public final Boolean d() {
        Ye ye = g;
        if (this.f854a.a(ye.b)) {
            return Boolean.valueOf(this.f854a.getBoolean(ye.b, true));
        }
        return null;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0726yd
    public final String f(String str) {
        return new Ye(str, null).b;
    }

    @Override // io.appmetrica.analytics.impl.Bo
    public final void a(String str) {
        b(q.b, str).b();
    }

    public final boolean a(boolean z) {
        return this.f854a.getBoolean(s.b, z);
    }

    public final int a(Td td, int i2) {
        Ye ye;
        int ordinal = td.ordinal();
        if (ordinal == 0) {
            ye = i;
        } else if (ordinal != 1) {
            ye = ordinal != 2 ? null : k;
        } else {
            ye = j;
        }
        if (ye == null) {
            return i2;
        }
        return this.f854a.getInt(ye.b, i2);
    }

    public final Ze b(Td td, long j2) {
        Ye ye;
        int ordinal = td.ordinal();
        if (ordinal == 0) {
            ye = l;
        } else if (ordinal != 1) {
            ye = ordinal != 2 ? null : n;
        } else {
            ye = m;
        }
        return ye != null ? (Ze) b(ye.b, j2) : this;
    }

    public final long a(Td td, long j2) {
        Ye ye;
        int ordinal = td.ordinal();
        if (ordinal == 0) {
            ye = l;
        } else if (ordinal != 1) {
            ye = ordinal != 2 ? null : n;
        } else {
            ye = m;
        }
        if (ye == null) {
            return j2;
        }
        return this.f854a.getLong(ye.b, j2);
    }
}
