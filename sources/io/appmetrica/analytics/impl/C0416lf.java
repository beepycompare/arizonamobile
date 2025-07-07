package io.appmetrica.analytics.impl;

import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.lf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0416lf extends Ld implements vo {
    public static final C0391kf d = new C0391kf("LOCATION_TRACKING_ENABLED", null);
    public static final C0391kf e = new C0391kf("PREF_KEY_OFFSET", null);
    public static final C0391kf f = new C0391kf("UNCHECKED_TIME", null);
    public static final C0391kf g = new C0391kf("STATISTICS_RESTRICTED_IN_MAIN", null);
    public static final C0391kf h = new C0391kf("LAST_IDENTITY_LIGHT_SEND_TIME", null);
    public static final C0391kf i = new C0391kf("NEXT_REPORT_SEND_ATTEMPT_NUMBER", null);
    public static final C0391kf j = new C0391kf("NEXT_LOCATION_SEND_ATTEMPT_NUMBER", null);
    public static final C0391kf k = new C0391kf("NEXT_STARTUP_SEND_ATTEMPT_NUMBER", null);
    public static final C0391kf l = new C0391kf("LAST_REPORT_SEND_ATTEMPT_TIME", null);
    public static final C0391kf m = new C0391kf("LAST_LOCATION_SEND_ATTEMPT_TIME", null);
    public static final C0391kf n = new C0391kf("LAST_STARTUP_SEND_ATTEMPT_TIME", null);
    public static final C0391kf o = new C0391kf("SATELLITE_PRELOAD_INFO_CHECKED", null);
    public static final C0391kf p = new C0391kf("SATELLITE_CLIDS_CHECKED", null);
    public static final C0391kf q = new C0391kf("VITAL_DATA", null);
    public static final C0391kf r = new C0391kf("LAST_KOTLIN_VERSION_SEND_TIME", null);
    public static final C0391kf s = new C0391kf("ADV_IDENTIFIERS_TRACKING_ENABLED", null);

    public C0416lf(InterfaceC0135ab interfaceC0135ab) {
        super(interfaceC0135ab);
    }

    public final long a(int i2) {
        return this.f891a.getLong(e.b, i2);
    }

    public final boolean b(boolean z) {
        return this.f891a.getBoolean(f.b, z);
    }

    public final C0416lf c(boolean z) {
        return (C0416lf) b(g.b, z);
    }

    public final C0416lf d(long j2) {
        return (C0416lf) b(e.b, j2);
    }

    public final boolean e() {
        return this.f891a.getBoolean(d.b, false);
    }

    public final void f(boolean z) {
        b(d.b, z).b();
    }

    public final C0416lf g() {
        return (C0416lf) b(p.b, true);
    }

    public final C0416lf h() {
        return (C0416lf) b(o.b, true);
    }

    public final boolean i() {
        return this.f891a.getBoolean(o.b, false);
    }

    public final boolean j() {
        return this.f891a.getBoolean(p.b, false);
    }

    public final long a(long j2) {
        return this.f891a.getLong(h.b, j2);
    }

    public final C0416lf b(long j2) {
        return (C0416lf) b(h.b, j2);
    }

    public final C0416lf c(long j2) {
        return (C0416lf) b(r.b, j2);
    }

    public final C0416lf d(boolean z) {
        return (C0416lf) b(f.b, z);
    }

    public final void e(boolean z) {
        b(s.b, z).b();
    }

    public final long f() {
        return this.f891a.getLong(r.b, 0L);
    }

    @Override // io.appmetrica.analytics.impl.vo
    public final String a() {
        return this.f891a.getString(q.b, null);
    }

    public final C0416lf b(EnumC0291ge enumC0291ge, int i2) {
        C0391kf c0391kf;
        int ordinal = enumC0291ge.ordinal();
        if (ordinal == 0) {
            c0391kf = i;
        } else if (ordinal != 1) {
            c0391kf = ordinal != 2 ? null : k;
        } else {
            c0391kf = j;
        }
        return c0391kf != null ? (C0416lf) b(c0391kf.b, i2) : this;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0366jf
    public final Set<String> c() {
        return this.f891a.a();
    }

    public final Boolean d() {
        C0391kf c0391kf = g;
        if (this.f891a.a(c0391kf.b)) {
            return Boolean.valueOf(this.f891a.getBoolean(c0391kf.b, true));
        }
        return null;
    }

    @Override // io.appmetrica.analytics.impl.Ld
    public final String f(String str) {
        return new C0391kf(str, null).b;
    }

    @Override // io.appmetrica.analytics.impl.vo
    public final void a(String str) {
        b(q.b, str).b();
    }

    public final boolean a(boolean z) {
        return this.f891a.getBoolean(s.b, z);
    }

    public final int a(EnumC0291ge enumC0291ge, int i2) {
        C0391kf c0391kf;
        int ordinal = enumC0291ge.ordinal();
        if (ordinal == 0) {
            c0391kf = i;
        } else if (ordinal != 1) {
            c0391kf = ordinal != 2 ? null : k;
        } else {
            c0391kf = j;
        }
        if (c0391kf == null) {
            return i2;
        }
        return this.f891a.getInt(c0391kf.b, i2);
    }

    public final C0416lf b(EnumC0291ge enumC0291ge, long j2) {
        C0391kf c0391kf;
        int ordinal = enumC0291ge.ordinal();
        if (ordinal == 0) {
            c0391kf = l;
        } else if (ordinal != 1) {
            c0391kf = ordinal != 2 ? null : n;
        } else {
            c0391kf = m;
        }
        return c0391kf != null ? (C0416lf) b(c0391kf.b, j2) : this;
    }

    public final long a(EnumC0291ge enumC0291ge, long j2) {
        C0391kf c0391kf;
        int ordinal = enumC0291ge.ordinal();
        if (ordinal == 0) {
            c0391kf = l;
        } else if (ordinal != 1) {
            c0391kf = ordinal != 2 ? null : n;
        } else {
            c0391kf = m;
        }
        if (c0391kf == null) {
            return j2;
        }
        return this.f891a.getLong(c0391kf.b, j2);
    }
}
