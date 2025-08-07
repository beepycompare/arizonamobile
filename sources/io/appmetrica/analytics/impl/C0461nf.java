package io.appmetrica.analytics.impl;

import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.nf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0461nf extends Nd implements yo {
    public static final C0436mf d = new C0436mf("LOCATION_TRACKING_ENABLED", null);
    public static final C0436mf e = new C0436mf("PREF_KEY_OFFSET", null);
    public static final C0436mf f = new C0436mf("UNCHECKED_TIME", null);
    public static final C0436mf g = new C0436mf("STATISTICS_RESTRICTED_IN_MAIN", null);
    public static final C0436mf h = new C0436mf("LAST_IDENTITY_LIGHT_SEND_TIME", null);
    public static final C0436mf i = new C0436mf("NEXT_REPORT_SEND_ATTEMPT_NUMBER", null);
    public static final C0436mf j = new C0436mf("NEXT_LOCATION_SEND_ATTEMPT_NUMBER", null);
    public static final C0436mf k = new C0436mf("NEXT_STARTUP_SEND_ATTEMPT_NUMBER", null);
    public static final C0436mf l = new C0436mf("LAST_REPORT_SEND_ATTEMPT_TIME", null);
    public static final C0436mf m = new C0436mf("LAST_LOCATION_SEND_ATTEMPT_TIME", null);
    public static final C0436mf n = new C0436mf("LAST_STARTUP_SEND_ATTEMPT_TIME", null);
    public static final C0436mf o = new C0436mf("SATELLITE_PRELOAD_INFO_CHECKED", null);
    public static final C0436mf p = new C0436mf("SATELLITE_CLIDS_CHECKED", null);
    public static final C0436mf q = new C0436mf("VITAL_DATA", null);
    public static final C0436mf r = new C0436mf("LAST_KOTLIN_VERSION_SEND_TIME", null);
    public static final C0436mf s = new C0436mf("ADV_IDENTIFIERS_TRACKING_ENABLED", null);

    public C0461nf(InterfaceC0180cb interfaceC0180cb) {
        super(interfaceC0180cb);
    }

    public final long a(int i2) {
        return this.f938a.getLong(e.b, i2);
    }

    public final boolean b(boolean z) {
        return this.f938a.getBoolean(f.b, z);
    }

    public final C0461nf c(boolean z) {
        return (C0461nf) b(g.b, z);
    }

    public final C0461nf d(long j2) {
        return (C0461nf) b(e.b, j2);
    }

    public final boolean e() {
        return this.f938a.getBoolean(d.b, false);
    }

    public final void f(boolean z) {
        b(d.b, z).b();
    }

    public final C0461nf g() {
        return (C0461nf) b(p.b, true);
    }

    public final C0461nf h() {
        return (C0461nf) b(o.b, true);
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

    public final C0461nf b(long j2) {
        return (C0461nf) b(h.b, j2);
    }

    public final C0461nf c(long j2) {
        return (C0461nf) b(r.b, j2);
    }

    public final C0461nf d(boolean z) {
        return (C0461nf) b(f.b, z);
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

    public final C0461nf b(EnumC0336ie enumC0336ie, int i2) {
        C0436mf c0436mf;
        int ordinal = enumC0336ie.ordinal();
        if (ordinal == 0) {
            c0436mf = i;
        } else if (ordinal != 1) {
            c0436mf = ordinal != 2 ? null : k;
        } else {
            c0436mf = j;
        }
        return c0436mf != null ? (C0461nf) b(c0436mf.b, i2) : this;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0411lf
    public final Set<String> c() {
        return this.f938a.a();
    }

    public final Boolean d() {
        C0436mf c0436mf = g;
        if (this.f938a.a(c0436mf.b)) {
            return Boolean.valueOf(this.f938a.getBoolean(c0436mf.b, true));
        }
        return null;
    }

    @Override // io.appmetrica.analytics.impl.Nd
    public final String f(String str) {
        return new C0436mf(str, null).b;
    }

    @Override // io.appmetrica.analytics.impl.yo
    public final void a(String str) {
        b(q.b, str).b();
    }

    public final boolean a(boolean z) {
        return this.f938a.getBoolean(s.b, z);
    }

    public final int a(EnumC0336ie enumC0336ie, int i2) {
        C0436mf c0436mf;
        int ordinal = enumC0336ie.ordinal();
        if (ordinal == 0) {
            c0436mf = i;
        } else if (ordinal != 1) {
            c0436mf = ordinal != 2 ? null : k;
        } else {
            c0436mf = j;
        }
        if (c0436mf == null) {
            return i2;
        }
        return this.f938a.getInt(c0436mf.b, i2);
    }

    public final C0461nf b(EnumC0336ie enumC0336ie, long j2) {
        C0436mf c0436mf;
        int ordinal = enumC0336ie.ordinal();
        if (ordinal == 0) {
            c0436mf = l;
        } else if (ordinal != 1) {
            c0436mf = ordinal != 2 ? null : n;
        } else {
            c0436mf = m;
        }
        return c0436mf != null ? (C0461nf) b(c0436mf.b, j2) : this;
    }

    public final long a(EnumC0336ie enumC0336ie, long j2) {
        C0436mf c0436mf;
        int ordinal = enumC0336ie.ordinal();
        if (ordinal == 0) {
            c0436mf = l;
        } else if (ordinal != 1) {
            c0436mf = ordinal != 2 ? null : n;
        } else {
            c0436mf = m;
        }
        if (c0436mf == null) {
            return j2;
        }
        return this.f938a.getLong(c0436mf.b, j2);
    }
}
