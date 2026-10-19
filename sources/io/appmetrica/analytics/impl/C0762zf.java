package io.appmetrica.analytics.impl;

import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.zf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0762zf extends Yd implements ep {
    public static final C0736yf d = new C0736yf("LOCATION_TRACKING_ENABLED", null);
    public static final C0736yf e = new C0736yf("PREF_KEY_OFFSET", null);
    public static final C0736yf f = new C0736yf("UNCHECKED_TIME", null);
    public static final C0736yf g = new C0736yf("STATISTICS_RESTRICTED_IN_MAIN", null);
    public static final C0736yf h = new C0736yf("NEXT_REPORT_SEND_ATTEMPT_NUMBER", null);
    public static final C0736yf i = new C0736yf("NEXT_LOCATION_SEND_ATTEMPT_NUMBER", null);
    public static final C0736yf j = new C0736yf("NEXT_STARTUP_SEND_ATTEMPT_NUMBER", null);
    public static final C0736yf k = new C0736yf("LAST_REPORT_SEND_ATTEMPT_TIME", null);
    public static final C0736yf l = new C0736yf("LAST_LOCATION_SEND_ATTEMPT_TIME", null);
    public static final C0736yf m = new C0736yf("LAST_STARTUP_SEND_ATTEMPT_TIME", null);
    public static final C0736yf n = new C0736yf("SATELLITE_PRELOAD_INFO_CHECKED", null);
    public static final C0736yf o = new C0736yf("SATELLITE_CLIDS_CHECKED", null);
    public static final C0736yf p = new C0736yf("VITAL_DATA", null);
    public static final C0736yf q = new C0736yf("LAST_KOTLIN_VERSION_SEND_TIME", null);
    public static final C0736yf r = new C0736yf("ADV_IDENTIFIERS_TRACKING_ENABLED", null);

    public C0762zf(InterfaceC0343jb interfaceC0343jb) {
        super(interfaceC0343jb);
    }

    public final long a(int i2) {
        return this.f1284a.getLong(e.b, i2);
    }

    public final C0762zf b(long j2) {
        return (C0762zf) d(e.b, j2);
    }

    public final void c(boolean z) {
        d(g.b, z).flushAsync();
    }

    public final C0762zf d(boolean z) {
        return (C0762zf) d(f.b, z);
    }

    public final boolean e() {
        return this.f1284a.getBoolean(d.b, false);
    }

    public final void f(boolean z) {
        d(d.b, z).flushAsync();
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0710xf, io.appmetrica.analytics.impl.Zl, io.appmetrica.analytics.impl.ep
    public final void flushAsync() {
        this.f1284a.flushAsync();
    }

    public final void g() {
        d(o.b, true).flushAsync();
    }

    public final void h() {
        d(n.b, true).flushAsync();
    }

    public final boolean i() {
        return this.f1284a.getBoolean(n.b, false);
    }

    public final boolean j() {
        return this.f1284a.getBoolean(o.b, false);
    }

    public final C0762zf a(long j2) {
        return (C0762zf) d(q.b, j2);
    }

    public final boolean b(boolean z) {
        return this.f1284a.getBoolean(f.b, z);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0710xf
    public final Set<String> c() {
        return this.f1284a.b();
    }

    public final Boolean d() {
        C0736yf c0736yf = g;
        if (this.f1284a.a(c0736yf.b)) {
            return Boolean.valueOf(this.f1284a.getBoolean(c0736yf.b, true));
        }
        return null;
    }

    public final void e(boolean z) {
        d(r.b, z).flushAsync();
    }

    public final long f() {
        return this.f1284a.getLong(q.b, 0L);
    }

    @Override // io.appmetrica.analytics.impl.Yd
    public final String g(String str) {
        return new C0736yf(str, null).b;
    }

    @Override // io.appmetrica.analytics.impl.ep
    public final void a(String str) {
        d(p.b, str).flushAsync();
    }

    @Override // io.appmetrica.analytics.impl.ep
    public final String b() {
        return this.f1284a.getString(p.b, null);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0710xf, io.appmetrica.analytics.impl.ep
    public final void a() {
        super.a();
    }

    public final C0762zf b(EnumC0631ue enumC0631ue, int i2) {
        C0736yf c0736yf;
        int ordinal = enumC0631ue.ordinal();
        if (ordinal == 0) {
            c0736yf = h;
        } else if (ordinal != 1) {
            c0736yf = ordinal != 2 ? null : j;
        } else {
            c0736yf = i;
        }
        return c0736yf != null ? (C0762zf) d(c0736yf.b, i2) : this;
    }

    public final boolean a(boolean z) {
        return this.f1284a.getBoolean(r.b, z);
    }

    public final int a(EnumC0631ue enumC0631ue, int i2) {
        C0736yf c0736yf;
        int ordinal = enumC0631ue.ordinal();
        if (ordinal == 0) {
            c0736yf = h;
        } else if (ordinal != 1) {
            c0736yf = ordinal != 2 ? null : j;
        } else {
            c0736yf = i;
        }
        if (c0736yf == null) {
            return i2;
        }
        return this.f1284a.getInt(c0736yf.b, i2);
    }

    public final C0762zf b(EnumC0631ue enumC0631ue, long j2) {
        C0736yf c0736yf;
        int ordinal = enumC0631ue.ordinal();
        if (ordinal == 0) {
            c0736yf = k;
        } else if (ordinal != 1) {
            c0736yf = ordinal != 2 ? null : m;
        } else {
            c0736yf = l;
        }
        return c0736yf != null ? (C0762zf) d(c0736yf.b, j2) : this;
    }

    public final long a(EnumC0631ue enumC0631ue, long j2) {
        C0736yf c0736yf;
        int ordinal = enumC0631ue.ordinal();
        if (ordinal == 0) {
            c0736yf = k;
        } else if (ordinal != 1) {
            c0736yf = ordinal != 2 ? null : m;
        } else {
            c0736yf = l;
        }
        if (c0736yf == null) {
            return j2;
        }
        return this.f1284a.getLong(c0736yf.b, j2);
    }
}
