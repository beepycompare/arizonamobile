package io.appmetrica.analytics.impl;

import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.zf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0769zf extends Yd implements ep {
    public static final C0743yf d = new C0743yf("LOCATION_TRACKING_ENABLED", null);
    public static final C0743yf e = new C0743yf("PREF_KEY_OFFSET", null);
    public static final C0743yf f = new C0743yf("UNCHECKED_TIME", null);
    public static final C0743yf g = new C0743yf("STATISTICS_RESTRICTED_IN_MAIN", null);
    public static final C0743yf h = new C0743yf("NEXT_REPORT_SEND_ATTEMPT_NUMBER", null);
    public static final C0743yf i = new C0743yf("NEXT_LOCATION_SEND_ATTEMPT_NUMBER", null);
    public static final C0743yf j = new C0743yf("NEXT_STARTUP_SEND_ATTEMPT_NUMBER", null);
    public static final C0743yf k = new C0743yf("LAST_REPORT_SEND_ATTEMPT_TIME", null);
    public static final C0743yf l = new C0743yf("LAST_LOCATION_SEND_ATTEMPT_TIME", null);
    public static final C0743yf m = new C0743yf("LAST_STARTUP_SEND_ATTEMPT_TIME", null);
    public static final C0743yf n = new C0743yf("SATELLITE_PRELOAD_INFO_CHECKED", null);
    public static final C0743yf o = new C0743yf("SATELLITE_CLIDS_CHECKED", null);
    public static final C0743yf p = new C0743yf("VITAL_DATA", null);
    public static final C0743yf q = new C0743yf("LAST_KOTLIN_VERSION_SEND_TIME", null);
    public static final C0743yf r = new C0743yf("ADV_IDENTIFIERS_TRACKING_ENABLED", null);

    public C0769zf(InterfaceC0350jb interfaceC0350jb) {
        super(interfaceC0350jb);
    }

    public final long a(int i2) {
        return this.f1279a.getLong(e.b, i2);
    }

    public final C0769zf b(long j2) {
        return (C0769zf) d(e.b, j2);
    }

    public final void c(boolean z) {
        d(g.b, z).flushAsync();
    }

    public final C0769zf d(boolean z) {
        return (C0769zf) d(f.b, z);
    }

    public final boolean e() {
        return this.f1279a.getBoolean(d.b, false);
    }

    public final void f(boolean z) {
        d(d.b, z).flushAsync();
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0717xf, io.appmetrica.analytics.impl.Zl, io.appmetrica.analytics.impl.ep
    public final void flushAsync() {
        this.f1279a.flushAsync();
    }

    public final void g() {
        d(o.b, true).flushAsync();
    }

    public final void h() {
        d(n.b, true).flushAsync();
    }

    public final boolean i() {
        return this.f1279a.getBoolean(n.b, false);
    }

    public final boolean j() {
        return this.f1279a.getBoolean(o.b, false);
    }

    public final C0769zf a(long j2) {
        return (C0769zf) d(q.b, j2);
    }

    public final boolean b(boolean z) {
        return this.f1279a.getBoolean(f.b, z);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0717xf
    public final Set<String> c() {
        return this.f1279a.b();
    }

    public final Boolean d() {
        C0743yf c0743yf = g;
        if (this.f1279a.a(c0743yf.b)) {
            return Boolean.valueOf(this.f1279a.getBoolean(c0743yf.b, true));
        }
        return null;
    }

    public final void e(boolean z) {
        d(r.b, z).flushAsync();
    }

    public final long f() {
        return this.f1279a.getLong(q.b, 0L);
    }

    @Override // io.appmetrica.analytics.impl.Yd
    public final String g(String str) {
        return new C0743yf(str, null).b;
    }

    @Override // io.appmetrica.analytics.impl.ep
    public final void a(String str) {
        d(p.b, str).flushAsync();
    }

    @Override // io.appmetrica.analytics.impl.ep
    public final String b() {
        return this.f1279a.getString(p.b, null);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0717xf, io.appmetrica.analytics.impl.ep
    public final void a() {
        super.a();
    }

    public final C0769zf b(EnumC0638ue enumC0638ue, int i2) {
        C0743yf c0743yf;
        int ordinal = enumC0638ue.ordinal();
        if (ordinal == 0) {
            c0743yf = h;
        } else if (ordinal != 1) {
            c0743yf = ordinal != 2 ? null : j;
        } else {
            c0743yf = i;
        }
        return c0743yf != null ? (C0769zf) d(c0743yf.b, i2) : this;
    }

    public final boolean a(boolean z) {
        return this.f1279a.getBoolean(r.b, z);
    }

    public final int a(EnumC0638ue enumC0638ue, int i2) {
        C0743yf c0743yf;
        int ordinal = enumC0638ue.ordinal();
        if (ordinal == 0) {
            c0743yf = h;
        } else if (ordinal != 1) {
            c0743yf = ordinal != 2 ? null : j;
        } else {
            c0743yf = i;
        }
        if (c0743yf == null) {
            return i2;
        }
        return this.f1279a.getInt(c0743yf.b, i2);
    }

    public final C0769zf b(EnumC0638ue enumC0638ue, long j2) {
        C0743yf c0743yf;
        int ordinal = enumC0638ue.ordinal();
        if (ordinal == 0) {
            c0743yf = k;
        } else if (ordinal != 1) {
            c0743yf = ordinal != 2 ? null : m;
        } else {
            c0743yf = l;
        }
        return c0743yf != null ? (C0769zf) d(c0743yf.b, j2) : this;
    }

    public final long a(EnumC0638ue enumC0638ue, long j2) {
        C0743yf c0743yf;
        int ordinal = enumC0638ue.ordinal();
        if (ordinal == 0) {
            c0743yf = k;
        } else if (ordinal != 1) {
            c0743yf = ordinal != 2 ? null : m;
        } else {
            c0743yf = l;
        }
        if (c0743yf == null) {
            return j2;
        }
        return this.f1279a.getLong(c0743yf.b, j2);
    }
}
