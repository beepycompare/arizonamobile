package io.appmetrica.analytics.impl;

import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.tf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0612tf extends Td implements Ho {
    public static final C0587sf d = new C0587sf("LOCATION_TRACKING_ENABLED", null);
    public static final C0587sf e = new C0587sf("PREF_KEY_OFFSET", null);
    public static final C0587sf f = new C0587sf("UNCHECKED_TIME", null);
    public static final C0587sf g = new C0587sf("STATISTICS_RESTRICTED_IN_MAIN", null);
    public static final C0587sf h = new C0587sf("LAST_IDENTITY_LIGHT_SEND_TIME", null);
    public static final C0587sf i = new C0587sf("NEXT_REPORT_SEND_ATTEMPT_NUMBER", null);
    public static final C0587sf j = new C0587sf("NEXT_LOCATION_SEND_ATTEMPT_NUMBER", null);
    public static final C0587sf k = new C0587sf("NEXT_STARTUP_SEND_ATTEMPT_NUMBER", null);
    public static final C0587sf l = new C0587sf("LAST_REPORT_SEND_ATTEMPT_TIME", null);
    public static final C0587sf m = new C0587sf("LAST_LOCATION_SEND_ATTEMPT_TIME", null);
    public static final C0587sf n = new C0587sf("LAST_STARTUP_SEND_ATTEMPT_TIME", null);
    public static final C0587sf o = new C0587sf("SATELLITE_PRELOAD_INFO_CHECKED", null);
    public static final C0587sf p = new C0587sf("SATELLITE_CLIDS_CHECKED", null);
    public static final C0587sf q = new C0587sf("VITAL_DATA", null);
    public static final C0587sf r = new C0587sf("LAST_KOTLIN_VERSION_SEND_TIME", null);
    public static final C0587sf s = new C0587sf("ADV_IDENTIFIERS_TRACKING_ENABLED", null);

    public C0612tf(InterfaceC0302hb interfaceC0302hb) {
        super(interfaceC0302hb);
    }

    public final long a(int i2) {
        return this.f1067a.getLong(e.b, i2);
    }

    public final boolean b(boolean z) {
        return this.f1067a.getBoolean(f.b, z);
    }

    public final C0612tf c(boolean z) {
        return (C0612tf) b(g.b, z);
    }

    public final C0612tf d(long j2) {
        return (C0612tf) b(e.b, j2);
    }

    public final boolean e() {
        return this.f1067a.getBoolean(d.b, false);
    }

    public final void f(boolean z) {
        b(d.b, z).b();
    }

    public final C0612tf g() {
        return (C0612tf) b(p.b, true);
    }

    public final C0612tf h() {
        return (C0612tf) b(o.b, true);
    }

    public final boolean i() {
        return this.f1067a.getBoolean(o.b, false);
    }

    public final boolean j() {
        return this.f1067a.getBoolean(p.b, false);
    }

    public final long a(long j2) {
        return this.f1067a.getLong(h.b, j2);
    }

    public final C0612tf b(long j2) {
        return (C0612tf) b(h.b, j2);
    }

    public final C0612tf c(long j2) {
        return (C0612tf) b(r.b, j2);
    }

    public final C0612tf d(boolean z) {
        return (C0612tf) b(f.b, z);
    }

    public final void e(boolean z) {
        b(s.b, z).b();
    }

    public final long f() {
        return this.f1067a.getLong(r.b, 0L);
    }

    @Override // io.appmetrica.analytics.impl.Ho
    public final String a() {
        return this.f1067a.getString(q.b, null);
    }

    public final C0612tf b(EnumC0486oe enumC0486oe, int i2) {
        C0587sf c0587sf;
        int ordinal = enumC0486oe.ordinal();
        if (ordinal == 0) {
            c0587sf = i;
        } else if (ordinal != 1) {
            c0587sf = ordinal != 2 ? null : k;
        } else {
            c0587sf = j;
        }
        return c0587sf != null ? (C0612tf) b(c0587sf.b, i2) : this;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0562rf
    public final Set<String> c() {
        return this.f1067a.a();
    }

    public final Boolean d() {
        C0587sf c0587sf = g;
        if (this.f1067a.a(c0587sf.b)) {
            return Boolean.valueOf(this.f1067a.getBoolean(c0587sf.b, true));
        }
        return null;
    }

    @Override // io.appmetrica.analytics.impl.Td
    public final String f(String str) {
        return new C0587sf(str, null).b;
    }

    @Override // io.appmetrica.analytics.impl.Ho
    public final void a(String str) {
        b(q.b, str).b();
    }

    public final boolean a(boolean z) {
        return this.f1067a.getBoolean(s.b, z);
    }

    public final int a(EnumC0486oe enumC0486oe, int i2) {
        C0587sf c0587sf;
        int ordinal = enumC0486oe.ordinal();
        if (ordinal == 0) {
            c0587sf = i;
        } else if (ordinal != 1) {
            c0587sf = ordinal != 2 ? null : k;
        } else {
            c0587sf = j;
        }
        if (c0587sf == null) {
            return i2;
        }
        return this.f1067a.getInt(c0587sf.b, i2);
    }

    public final C0612tf b(EnumC0486oe enumC0486oe, long j2) {
        C0587sf c0587sf;
        int ordinal = enumC0486oe.ordinal();
        if (ordinal == 0) {
            c0587sf = l;
        } else if (ordinal != 1) {
            c0587sf = ordinal != 2 ? null : n;
        } else {
            c0587sf = m;
        }
        return c0587sf != null ? (C0612tf) b(c0587sf.b, j2) : this;
    }

    public final long a(EnumC0486oe enumC0486oe, long j2) {
        C0587sf c0587sf;
        int ordinal = enumC0486oe.ordinal();
        if (ordinal == 0) {
            c0587sf = l;
        } else if (ordinal != 1) {
            c0587sf = ordinal != 2 ? null : n;
        } else {
            c0587sf = m;
        }
        if (c0587sf == null) {
            return j2;
        }
        return this.f1067a.getLong(c0587sf.b, j2);
    }
}
