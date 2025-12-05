package io.appmetrica.analytics.impl;

import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.af  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0116af extends AbstractC0747zd implements Co {
    public static final Ze d = new Ze("LOCATION_TRACKING_ENABLED", null);
    public static final Ze e = new Ze("PREF_KEY_OFFSET", null);
    public static final Ze f = new Ze("UNCHECKED_TIME", null);
    public static final Ze g = new Ze("STATISTICS_RESTRICTED_IN_MAIN", null);
    public static final Ze h = new Ze("LAST_IDENTITY_LIGHT_SEND_TIME", null);
    public static final Ze i = new Ze("NEXT_REPORT_SEND_ATTEMPT_NUMBER", null);
    public static final Ze j = new Ze("NEXT_LOCATION_SEND_ATTEMPT_NUMBER", null);
    public static final Ze k = new Ze("NEXT_STARTUP_SEND_ATTEMPT_NUMBER", null);
    public static final Ze l = new Ze("LAST_REPORT_SEND_ATTEMPT_TIME", null);
    public static final Ze m = new Ze("LAST_LOCATION_SEND_ATTEMPT_TIME", null);
    public static final Ze n = new Ze("LAST_STARTUP_SEND_ATTEMPT_TIME", null);
    public static final Ze o = new Ze("SATELLITE_PRELOAD_INFO_CHECKED", null);
    public static final Ze p = new Ze("SATELLITE_CLIDS_CHECKED", null);
    public static final Ze q = new Ze("VITAL_DATA", null);
    public static final Ze r = new Ze("LAST_KOTLIN_VERSION_SEND_TIME", null);
    public static final Ze s = new Ze("ADV_IDENTIFIERS_TRACKING_ENABLED", null);

    public C0116af(Ia ia) {
        super(ia);
    }

    public final long a(int i2) {
        return this.f848a.getLong(e.b, i2);
    }

    public final boolean b(boolean z) {
        return this.f848a.getBoolean(f.b, z);
    }

    public final C0116af c(boolean z) {
        return (C0116af) b(g.b, z);
    }

    public final C0116af d(long j2) {
        return (C0116af) b(e.b, j2);
    }

    public final boolean e() {
        return this.f848a.getBoolean(d.b, false);
    }

    public final void f(boolean z) {
        b(d.b, z).b();
    }

    public final C0116af g() {
        return (C0116af) b(p.b, true);
    }

    public final C0116af h() {
        return (C0116af) b(o.b, true);
    }

    public final boolean i() {
        return this.f848a.getBoolean(o.b, false);
    }

    public final boolean j() {
        return this.f848a.getBoolean(p.b, false);
    }

    public final long a(long j2) {
        return this.f848a.getLong(h.b, j2);
    }

    public final C0116af b(long j2) {
        return (C0116af) b(h.b, j2);
    }

    public final C0116af c(long j2) {
        return (C0116af) b(r.b, j2);
    }

    public final C0116af d(boolean z) {
        return (C0116af) b(f.b, z);
    }

    public final void e(boolean z) {
        b(s.b, z).b();
    }

    public final long f() {
        return this.f848a.getLong(r.b, 0L);
    }

    @Override // io.appmetrica.analytics.impl.Co
    public final String a() {
        return this.f848a.getString(q.b, null);
    }

    public final C0116af b(Ud ud, int i2) {
        Ze ze;
        int ordinal = ud.ordinal();
        if (ordinal == 0) {
            ze = i;
        } else if (ordinal != 1) {
            ze = ordinal != 2 ? null : k;
        } else {
            ze = j;
        }
        return ze != null ? (C0116af) b(ze.b, i2) : this;
    }

    @Override // io.appmetrica.analytics.impl.Ye
    public final Set<String> c() {
        return this.f848a.a();
    }

    public final Boolean d() {
        Ze ze = g;
        if (this.f848a.a(ze.b)) {
            return Boolean.valueOf(this.f848a.getBoolean(ze.b, true));
        }
        return null;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0747zd
    public final String f(String str) {
        return new Ze(str, null).b;
    }

    @Override // io.appmetrica.analytics.impl.Co
    public final void a(String str) {
        b(q.b, str).b();
    }

    public final boolean a(boolean z) {
        return this.f848a.getBoolean(s.b, z);
    }

    public final int a(Ud ud, int i2) {
        Ze ze;
        int ordinal = ud.ordinal();
        if (ordinal == 0) {
            ze = i;
        } else if (ordinal != 1) {
            ze = ordinal != 2 ? null : k;
        } else {
            ze = j;
        }
        if (ze == null) {
            return i2;
        }
        return this.f848a.getInt(ze.b, i2);
    }

    public final C0116af b(Ud ud, long j2) {
        Ze ze;
        int ordinal = ud.ordinal();
        if (ordinal == 0) {
            ze = l;
        } else if (ordinal != 1) {
            ze = ordinal != 2 ? null : n;
        } else {
            ze = m;
        }
        return ze != null ? (C0116af) b(ze.b, j2) : this;
    }

    public final long a(Ud ud, long j2) {
        Ze ze;
        int ordinal = ud.ordinal();
        if (ordinal == 0) {
            ze = l;
        } else if (ordinal != 1) {
            ze = ordinal != 2 ? null : n;
        } else {
            ze = m;
        }
        if (ze == null) {
            return j2;
        }
        return this.f848a.getLong(ze.b, j2);
    }
}
