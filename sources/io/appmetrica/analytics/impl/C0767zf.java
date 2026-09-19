package io.appmetrica.analytics.impl;

import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.zf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0767zf extends Yd implements ep {
    public static final C0741yf d = new C0741yf("LOCATION_TRACKING_ENABLED", null);
    public static final C0741yf e = new C0741yf("PREF_KEY_OFFSET", null);
    public static final C0741yf f = new C0741yf("UNCHECKED_TIME", null);
    public static final C0741yf g = new C0741yf("STATISTICS_RESTRICTED_IN_MAIN", null);
    public static final C0741yf h = new C0741yf("NEXT_REPORT_SEND_ATTEMPT_NUMBER", null);
    public static final C0741yf i = new C0741yf("NEXT_LOCATION_SEND_ATTEMPT_NUMBER", null);
    public static final C0741yf j = new C0741yf("NEXT_STARTUP_SEND_ATTEMPT_NUMBER", null);
    public static final C0741yf k = new C0741yf("LAST_REPORT_SEND_ATTEMPT_TIME", null);
    public static final C0741yf l = new C0741yf("LAST_LOCATION_SEND_ATTEMPT_TIME", null);
    public static final C0741yf m = new C0741yf("LAST_STARTUP_SEND_ATTEMPT_TIME", null);
    public static final C0741yf n = new C0741yf("SATELLITE_PRELOAD_INFO_CHECKED", null);
    public static final C0741yf o = new C0741yf("SATELLITE_CLIDS_CHECKED", null);
    public static final C0741yf p = new C0741yf("VITAL_DATA", null);
    public static final C0741yf q = new C0741yf("LAST_KOTLIN_VERSION_SEND_TIME", null);
    public static final C0741yf r = new C0741yf("ADV_IDENTIFIERS_TRACKING_ENABLED", null);

    public C0767zf(InterfaceC0348jb interfaceC0348jb) {
        super(interfaceC0348jb);
    }

    public final long a(int i2) {
        return this.f1281a.getLong(e.b, i2);
    }

    public final C0767zf b(long j2) {
        return (C0767zf) d(e.b, j2);
    }

    public final void c(boolean z) {
        d(g.b, z).flushAsync();
    }

    public final C0767zf d(boolean z) {
        return (C0767zf) d(f.b, z);
    }

    public final boolean e() {
        return this.f1281a.getBoolean(d.b, false);
    }

    public final void f(boolean z) {
        d(d.b, z).flushAsync();
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0715xf, io.appmetrica.analytics.impl.Zl, io.appmetrica.analytics.impl.ep
    public final void flushAsync() {
        this.f1281a.flushAsync();
    }

    public final void g() {
        d(o.b, true).flushAsync();
    }

    public final void h() {
        d(n.b, true).flushAsync();
    }

    public final boolean i() {
        return this.f1281a.getBoolean(n.b, false);
    }

    public final boolean j() {
        return this.f1281a.getBoolean(o.b, false);
    }

    public final C0767zf a(long j2) {
        return (C0767zf) d(q.b, j2);
    }

    public final boolean b(boolean z) {
        return this.f1281a.getBoolean(f.b, z);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0715xf
    public final Set<String> c() {
        return this.f1281a.b();
    }

    public final Boolean d() {
        C0741yf c0741yf = g;
        if (this.f1281a.a(c0741yf.b)) {
            return Boolean.valueOf(this.f1281a.getBoolean(c0741yf.b, true));
        }
        return null;
    }

    public final void e(boolean z) {
        d(r.b, z).flushAsync();
    }

    public final long f() {
        return this.f1281a.getLong(q.b, 0L);
    }

    @Override // io.appmetrica.analytics.impl.Yd
    public final String g(String str) {
        return new C0741yf(str, null).b;
    }

    @Override // io.appmetrica.analytics.impl.ep
    public final void a(String str) {
        d(p.b, str).flushAsync();
    }

    @Override // io.appmetrica.analytics.impl.ep
    public final String b() {
        return this.f1281a.getString(p.b, null);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0715xf, io.appmetrica.analytics.impl.ep
    public final void a() {
        super.a();
    }

    public final C0767zf b(EnumC0636ue enumC0636ue, int i2) {
        C0741yf c0741yf;
        int ordinal = enumC0636ue.ordinal();
        if (ordinal == 0) {
            c0741yf = h;
        } else if (ordinal != 1) {
            c0741yf = ordinal != 2 ? null : j;
        } else {
            c0741yf = i;
        }
        return c0741yf != null ? (C0767zf) d(c0741yf.b, i2) : this;
    }

    public final boolean a(boolean z) {
        return this.f1281a.getBoolean(r.b, z);
    }

    public final int a(EnumC0636ue enumC0636ue, int i2) {
        C0741yf c0741yf;
        int ordinal = enumC0636ue.ordinal();
        if (ordinal == 0) {
            c0741yf = h;
        } else if (ordinal != 1) {
            c0741yf = ordinal != 2 ? null : j;
        } else {
            c0741yf = i;
        }
        if (c0741yf == null) {
            return i2;
        }
        return this.f1281a.getInt(c0741yf.b, i2);
    }

    public final C0767zf b(EnumC0636ue enumC0636ue, long j2) {
        C0741yf c0741yf;
        int ordinal = enumC0636ue.ordinal();
        if (ordinal == 0) {
            c0741yf = k;
        } else if (ordinal != 1) {
            c0741yf = ordinal != 2 ? null : m;
        } else {
            c0741yf = l;
        }
        return c0741yf != null ? (C0767zf) d(c0741yf.b, j2) : this;
    }

    public final long a(EnumC0636ue enumC0636ue, long j2) {
        C0741yf c0741yf;
        int ordinal = enumC0636ue.ordinal();
        if (ordinal == 0) {
            c0741yf = k;
        } else if (ordinal != 1) {
            c0741yf = ordinal != 2 ? null : m;
        } else {
            c0741yf = l;
        }
        if (c0741yf == null) {
            return j2;
        }
        return this.f1281a.getLong(c0741yf.b, j2);
    }
}
