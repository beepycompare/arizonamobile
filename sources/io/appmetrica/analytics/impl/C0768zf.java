package io.appmetrica.analytics.impl;

import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.zf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0768zf extends Yd implements ep {
    public static final C0742yf d = new C0742yf("LOCATION_TRACKING_ENABLED", null);
    public static final C0742yf e = new C0742yf("PREF_KEY_OFFSET", null);
    public static final C0742yf f = new C0742yf("UNCHECKED_TIME", null);
    public static final C0742yf g = new C0742yf("STATISTICS_RESTRICTED_IN_MAIN", null);
    public static final C0742yf h = new C0742yf("NEXT_REPORT_SEND_ATTEMPT_NUMBER", null);
    public static final C0742yf i = new C0742yf("NEXT_LOCATION_SEND_ATTEMPT_NUMBER", null);
    public static final C0742yf j = new C0742yf("NEXT_STARTUP_SEND_ATTEMPT_NUMBER", null);
    public static final C0742yf k = new C0742yf("LAST_REPORT_SEND_ATTEMPT_TIME", null);
    public static final C0742yf l = new C0742yf("LAST_LOCATION_SEND_ATTEMPT_TIME", null);
    public static final C0742yf m = new C0742yf("LAST_STARTUP_SEND_ATTEMPT_TIME", null);
    public static final C0742yf n = new C0742yf("SATELLITE_PRELOAD_INFO_CHECKED", null);
    public static final C0742yf o = new C0742yf("SATELLITE_CLIDS_CHECKED", null);
    public static final C0742yf p = new C0742yf("VITAL_DATA", null);
    public static final C0742yf q = new C0742yf("LAST_KOTLIN_VERSION_SEND_TIME", null);
    public static final C0742yf r = new C0742yf("ADV_IDENTIFIERS_TRACKING_ENABLED", null);

    public C0768zf(InterfaceC0349jb interfaceC0349jb) {
        super(interfaceC0349jb);
    }

    public final long a(int i2) {
        return this.f1281a.getLong(e.b, i2);
    }

    public final C0768zf b(long j2) {
        return (C0768zf) d(e.b, j2);
    }

    public final void c(boolean z) {
        d(g.b, z).flushAsync();
    }

    public final C0768zf d(boolean z) {
        return (C0768zf) d(f.b, z);
    }

    public final boolean e() {
        return this.f1281a.getBoolean(d.b, false);
    }

    public final void f(boolean z) {
        d(d.b, z).flushAsync();
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0716xf, io.appmetrica.analytics.impl.Zl, io.appmetrica.analytics.impl.ep
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

    public final C0768zf a(long j2) {
        return (C0768zf) d(q.b, j2);
    }

    public final boolean b(boolean z) {
        return this.f1281a.getBoolean(f.b, z);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0716xf
    public final Set<String> c() {
        return this.f1281a.b();
    }

    public final Boolean d() {
        C0742yf c0742yf = g;
        if (this.f1281a.a(c0742yf.b)) {
            return Boolean.valueOf(this.f1281a.getBoolean(c0742yf.b, true));
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
        return new C0742yf(str, null).b;
    }

    @Override // io.appmetrica.analytics.impl.ep
    public final void a(String str) {
        d(p.b, str).flushAsync();
    }

    @Override // io.appmetrica.analytics.impl.ep
    public final String b() {
        return this.f1281a.getString(p.b, null);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0716xf, io.appmetrica.analytics.impl.ep
    public final void a() {
        super.a();
    }

    public final C0768zf b(EnumC0637ue enumC0637ue, int i2) {
        C0742yf c0742yf;
        int ordinal = enumC0637ue.ordinal();
        if (ordinal == 0) {
            c0742yf = h;
        } else if (ordinal != 1) {
            c0742yf = ordinal != 2 ? null : j;
        } else {
            c0742yf = i;
        }
        return c0742yf != null ? (C0768zf) d(c0742yf.b, i2) : this;
    }

    public final boolean a(boolean z) {
        return this.f1281a.getBoolean(r.b, z);
    }

    public final int a(EnumC0637ue enumC0637ue, int i2) {
        C0742yf c0742yf;
        int ordinal = enumC0637ue.ordinal();
        if (ordinal == 0) {
            c0742yf = h;
        } else if (ordinal != 1) {
            c0742yf = ordinal != 2 ? null : j;
        } else {
            c0742yf = i;
        }
        if (c0742yf == null) {
            return i2;
        }
        return this.f1281a.getInt(c0742yf.b, i2);
    }

    public final C0768zf b(EnumC0637ue enumC0637ue, long j2) {
        C0742yf c0742yf;
        int ordinal = enumC0637ue.ordinal();
        if (ordinal == 0) {
            c0742yf = k;
        } else if (ordinal != 1) {
            c0742yf = ordinal != 2 ? null : m;
        } else {
            c0742yf = l;
        }
        return c0742yf != null ? (C0768zf) d(c0742yf.b, j2) : this;
    }

    public final long a(EnumC0637ue enumC0637ue, long j2) {
        C0742yf c0742yf;
        int ordinal = enumC0637ue.ordinal();
        if (ordinal == 0) {
            c0742yf = k;
        } else if (ordinal != 1) {
            c0742yf = ordinal != 2 ? null : m;
        } else {
            c0742yf = l;
        }
        if (c0742yf == null) {
            return j2;
        }
        return this.f1281a.getLong(c0742yf.b, j2);
    }
}
