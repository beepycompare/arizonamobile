package io.appmetrica.analytics.impl;

import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.lf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0408lf extends Ld implements vo {
    public static final C0383kf d = new C0383kf("LOCATION_TRACKING_ENABLED", null);
    public static final C0383kf e = new C0383kf("PREF_KEY_OFFSET", null);
    public static final C0383kf f = new C0383kf("UNCHECKED_TIME", null);
    public static final C0383kf g = new C0383kf("STATISTICS_RESTRICTED_IN_MAIN", null);
    public static final C0383kf h = new C0383kf("LAST_IDENTITY_LIGHT_SEND_TIME", null);
    public static final C0383kf i = new C0383kf("NEXT_REPORT_SEND_ATTEMPT_NUMBER", null);
    public static final C0383kf j = new C0383kf("NEXT_LOCATION_SEND_ATTEMPT_NUMBER", null);
    public static final C0383kf k = new C0383kf("NEXT_STARTUP_SEND_ATTEMPT_NUMBER", null);
    public static final C0383kf l = new C0383kf("LAST_REPORT_SEND_ATTEMPT_TIME", null);
    public static final C0383kf m = new C0383kf("LAST_LOCATION_SEND_ATTEMPT_TIME", null);
    public static final C0383kf n = new C0383kf("LAST_STARTUP_SEND_ATTEMPT_TIME", null);
    public static final C0383kf o = new C0383kf("SATELLITE_PRELOAD_INFO_CHECKED", null);
    public static final C0383kf p = new C0383kf("SATELLITE_CLIDS_CHECKED", null);
    public static final C0383kf q = new C0383kf("VITAL_DATA", null);
    public static final C0383kf r = new C0383kf("LAST_KOTLIN_VERSION_SEND_TIME", null);
    public static final C0383kf s = new C0383kf("ADV_IDENTIFIERS_TRACKING_ENABLED", null);

    public C0408lf(InterfaceC0127ab interfaceC0127ab) {
        super(interfaceC0127ab);
    }

    public final long a(int i2) {
        return this.f892a.getLong(e.b, i2);
    }

    public final boolean b(boolean z) {
        return this.f892a.getBoolean(f.b, z);
    }

    public final C0408lf c(boolean z) {
        return (C0408lf) b(g.b, z);
    }

    public final C0408lf d(long j2) {
        return (C0408lf) b(e.b, j2);
    }

    public final boolean e() {
        return this.f892a.getBoolean(d.b, false);
    }

    public final void f(boolean z) {
        b(d.b, z).b();
    }

    public final C0408lf g() {
        return (C0408lf) b(p.b, true);
    }

    public final C0408lf h() {
        return (C0408lf) b(o.b, true);
    }

    public final boolean i() {
        return this.f892a.getBoolean(o.b, false);
    }

    public final boolean j() {
        return this.f892a.getBoolean(p.b, false);
    }

    public final long a(long j2) {
        return this.f892a.getLong(h.b, j2);
    }

    public final C0408lf b(long j2) {
        return (C0408lf) b(h.b, j2);
    }

    public final C0408lf c(long j2) {
        return (C0408lf) b(r.b, j2);
    }

    public final C0408lf d(boolean z) {
        return (C0408lf) b(f.b, z);
    }

    public final void e(boolean z) {
        b(s.b, z).b();
    }

    public final long f() {
        return this.f892a.getLong(r.b, 0L);
    }

    @Override // io.appmetrica.analytics.impl.vo
    public final String a() {
        return this.f892a.getString(q.b, null);
    }

    public final C0408lf b(EnumC0283ge enumC0283ge, int i2) {
        C0383kf c0383kf;
        int ordinal = enumC0283ge.ordinal();
        if (ordinal == 0) {
            c0383kf = i;
        } else if (ordinal != 1) {
            c0383kf = ordinal != 2 ? null : k;
        } else {
            c0383kf = j;
        }
        return c0383kf != null ? (C0408lf) b(c0383kf.b, i2) : this;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0358jf
    public final Set<String> c() {
        return this.f892a.a();
    }

    public final Boolean d() {
        C0383kf c0383kf = g;
        if (this.f892a.a(c0383kf.b)) {
            return Boolean.valueOf(this.f892a.getBoolean(c0383kf.b, true));
        }
        return null;
    }

    @Override // io.appmetrica.analytics.impl.Ld
    public final String f(String str) {
        return new C0383kf(str, null).b;
    }

    @Override // io.appmetrica.analytics.impl.vo
    public final void a(String str) {
        b(q.b, str).b();
    }

    public final boolean a(boolean z) {
        return this.f892a.getBoolean(s.b, z);
    }

    public final int a(EnumC0283ge enumC0283ge, int i2) {
        C0383kf c0383kf;
        int ordinal = enumC0283ge.ordinal();
        if (ordinal == 0) {
            c0383kf = i;
        } else if (ordinal != 1) {
            c0383kf = ordinal != 2 ? null : k;
        } else {
            c0383kf = j;
        }
        if (c0383kf == null) {
            return i2;
        }
        return this.f892a.getInt(c0383kf.b, i2);
    }

    public final C0408lf b(EnumC0283ge enumC0283ge, long j2) {
        C0383kf c0383kf;
        int ordinal = enumC0283ge.ordinal();
        if (ordinal == 0) {
            c0383kf = l;
        } else if (ordinal != 1) {
            c0383kf = ordinal != 2 ? null : n;
        } else {
            c0383kf = m;
        }
        return c0383kf != null ? (C0408lf) b(c0383kf.b, j2) : this;
    }

    public final long a(EnumC0283ge enumC0283ge, long j2) {
        C0383kf c0383kf;
        int ordinal = enumC0283ge.ordinal();
        if (ordinal == 0) {
            c0383kf = l;
        } else if (ordinal != 1) {
            c0383kf = ordinal != 2 ? null : n;
        } else {
            c0383kf = m;
        }
        if (c0383kf == null) {
            return j2;
        }
        return this.f892a.getLong(c0383kf.b, j2);
    }
}
