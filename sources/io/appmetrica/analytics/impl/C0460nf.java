package io.appmetrica.analytics.impl;

import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.nf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0460nf extends Nd implements yo {
    public static final C0435mf d = new C0435mf("LOCATION_TRACKING_ENABLED", null);
    public static final C0435mf e = new C0435mf("PREF_KEY_OFFSET", null);
    public static final C0435mf f = new C0435mf("UNCHECKED_TIME", null);
    public static final C0435mf g = new C0435mf("STATISTICS_RESTRICTED_IN_MAIN", null);
    public static final C0435mf h = new C0435mf("LAST_IDENTITY_LIGHT_SEND_TIME", null);
    public static final C0435mf i = new C0435mf("NEXT_REPORT_SEND_ATTEMPT_NUMBER", null);
    public static final C0435mf j = new C0435mf("NEXT_LOCATION_SEND_ATTEMPT_NUMBER", null);
    public static final C0435mf k = new C0435mf("NEXT_STARTUP_SEND_ATTEMPT_NUMBER", null);
    public static final C0435mf l = new C0435mf("LAST_REPORT_SEND_ATTEMPT_TIME", null);
    public static final C0435mf m = new C0435mf("LAST_LOCATION_SEND_ATTEMPT_TIME", null);
    public static final C0435mf n = new C0435mf("LAST_STARTUP_SEND_ATTEMPT_TIME", null);
    public static final C0435mf o = new C0435mf("SATELLITE_PRELOAD_INFO_CHECKED", null);
    public static final C0435mf p = new C0435mf("SATELLITE_CLIDS_CHECKED", null);
    public static final C0435mf q = new C0435mf("VITAL_DATA", null);
    public static final C0435mf r = new C0435mf("LAST_KOTLIN_VERSION_SEND_TIME", null);
    public static final C0435mf s = new C0435mf("ADV_IDENTIFIERS_TRACKING_ENABLED", null);

    public C0460nf(InterfaceC0179cb interfaceC0179cb) {
        super(interfaceC0179cb);
    }

    public final long a(int i2) {
        return this.f938a.getLong(e.b, i2);
    }

    public final boolean b(boolean z) {
        return this.f938a.getBoolean(f.b, z);
    }

    public final C0460nf c(boolean z) {
        return (C0460nf) b(g.b, z);
    }

    public final C0460nf d(long j2) {
        return (C0460nf) b(e.b, j2);
    }

    public final boolean e() {
        return this.f938a.getBoolean(d.b, false);
    }

    public final void f(boolean z) {
        b(d.b, z).b();
    }

    public final C0460nf g() {
        return (C0460nf) b(p.b, true);
    }

    public final C0460nf h() {
        return (C0460nf) b(o.b, true);
    }

    public final boolean i() {
        return this.f938a.getBoolean(o.b, false);
    }

    public final boolean j() {
        return this.f938a.getBoolean(p.b, false);
    }

    public final long a(long j2) {
        return this.f938a.getLong(h.b, j2);
    }

    public final C0460nf b(long j2) {
        return (C0460nf) b(h.b, j2);
    }

    public final C0460nf c(long j2) {
        return (C0460nf) b(r.b, j2);
    }

    public final C0460nf d(boolean z) {
        return (C0460nf) b(f.b, z);
    }

    public final void e(boolean z) {
        b(s.b, z).b();
    }

    public final long f() {
        return this.f938a.getLong(r.b, 0L);
    }

    @Override // io.appmetrica.analytics.impl.yo
    public final String a() {
        return this.f938a.getString(q.b, null);
    }

    public final C0460nf b(EnumC0335ie enumC0335ie, int i2) {
        C0435mf c0435mf;
        int ordinal = enumC0335ie.ordinal();
        if (ordinal == 0) {
            c0435mf = i;
        } else if (ordinal != 1) {
            c0435mf = ordinal != 2 ? null : k;
        } else {
            c0435mf = j;
        }
        return c0435mf != null ? (C0460nf) b(c0435mf.b, i2) : this;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0410lf
    public final Set<String> c() {
        return this.f938a.a();
    }

    public final Boolean d() {
        C0435mf c0435mf = g;
        if (this.f938a.a(c0435mf.b)) {
            return Boolean.valueOf(this.f938a.getBoolean(c0435mf.b, true));
        }
        return null;
    }

    @Override // io.appmetrica.analytics.impl.Nd
    public final String f(String str) {
        return new C0435mf(str, null).b;
    }

    @Override // io.appmetrica.analytics.impl.yo
    public final void a(String str) {
        b(q.b, str).b();
    }

    public final boolean a(boolean z) {
        return this.f938a.getBoolean(s.b, z);
    }

    public final int a(EnumC0335ie enumC0335ie, int i2) {
        C0435mf c0435mf;
        int ordinal = enumC0335ie.ordinal();
        if (ordinal == 0) {
            c0435mf = i;
        } else if (ordinal != 1) {
            c0435mf = ordinal != 2 ? null : k;
        } else {
            c0435mf = j;
        }
        if (c0435mf == null) {
            return i2;
        }
        return this.f938a.getInt(c0435mf.b, i2);
    }

    public final C0460nf b(EnumC0335ie enumC0335ie, long j2) {
        C0435mf c0435mf;
        int ordinal = enumC0335ie.ordinal();
        if (ordinal == 0) {
            c0435mf = l;
        } else if (ordinal != 1) {
            c0435mf = ordinal != 2 ? null : n;
        } else {
            c0435mf = m;
        }
        return c0435mf != null ? (C0460nf) b(c0435mf.b, j2) : this;
    }

    public final long a(EnumC0335ie enumC0335ie, long j2) {
        C0435mf c0435mf;
        int ordinal = enumC0335ie.ordinal();
        if (ordinal == 0) {
            c0435mf = l;
        } else if (ordinal != 1) {
            c0435mf = ordinal != 2 ? null : n;
        } else {
            c0435mf = m;
        }
        if (c0435mf == null) {
            return j2;
        }
        return this.f938a.getLong(c0435mf.b, j2);
    }
}
