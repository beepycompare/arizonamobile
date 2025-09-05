package io.appmetrica.analytics.impl;

import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.tf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0611tf extends Td implements Ho {
    public static final C0586sf d = new C0586sf("LOCATION_TRACKING_ENABLED", null);
    public static final C0586sf e = new C0586sf("PREF_KEY_OFFSET", null);
    public static final C0586sf f = new C0586sf("UNCHECKED_TIME", null);
    public static final C0586sf g = new C0586sf("STATISTICS_RESTRICTED_IN_MAIN", null);
    public static final C0586sf h = new C0586sf("LAST_IDENTITY_LIGHT_SEND_TIME", null);
    public static final C0586sf i = new C0586sf("NEXT_REPORT_SEND_ATTEMPT_NUMBER", null);
    public static final C0586sf j = new C0586sf("NEXT_LOCATION_SEND_ATTEMPT_NUMBER", null);
    public static final C0586sf k = new C0586sf("NEXT_STARTUP_SEND_ATTEMPT_NUMBER", null);
    public static final C0586sf l = new C0586sf("LAST_REPORT_SEND_ATTEMPT_TIME", null);
    public static final C0586sf m = new C0586sf("LAST_LOCATION_SEND_ATTEMPT_TIME", null);
    public static final C0586sf n = new C0586sf("LAST_STARTUP_SEND_ATTEMPT_TIME", null);
    public static final C0586sf o = new C0586sf("SATELLITE_PRELOAD_INFO_CHECKED", null);
    public static final C0586sf p = new C0586sf("SATELLITE_CLIDS_CHECKED", null);
    public static final C0586sf q = new C0586sf("VITAL_DATA", null);
    public static final C0586sf r = new C0586sf("LAST_KOTLIN_VERSION_SEND_TIME", null);
    public static final C0586sf s = new C0586sf("ADV_IDENTIFIERS_TRACKING_ENABLED", null);

    public C0611tf(InterfaceC0301hb interfaceC0301hb) {
        super(interfaceC0301hb);
    }

    public final long a(int i2) {
        return this.f1062a.getLong(e.b, i2);
    }

    public final boolean b(boolean z) {
        return this.f1062a.getBoolean(f.b, z);
    }

    public final C0611tf c(boolean z) {
        return (C0611tf) b(g.b, z);
    }

    public final C0611tf d(long j2) {
        return (C0611tf) b(e.b, j2);
    }

    public final boolean e() {
        return this.f1062a.getBoolean(d.b, false);
    }

    public final void f(boolean z) {
        b(d.b, z).b();
    }

    public final C0611tf g() {
        return (C0611tf) b(p.b, true);
    }

    public final C0611tf h() {
        return (C0611tf) b(o.b, true);
    }

    public final boolean i() {
        return this.f1062a.getBoolean(o.b, false);
    }

    public final boolean j() {
        return this.f1062a.getBoolean(p.b, false);
    }

    public final long a(long j2) {
        return this.f1062a.getLong(h.b, j2);
    }

    public final C0611tf b(long j2) {
        return (C0611tf) b(h.b, j2);
    }

    public final C0611tf c(long j2) {
        return (C0611tf) b(r.b, j2);
    }

    public final C0611tf d(boolean z) {
        return (C0611tf) b(f.b, z);
    }

    public final void e(boolean z) {
        b(s.b, z).b();
    }

    public final long f() {
        return this.f1062a.getLong(r.b, 0L);
    }

    @Override // io.appmetrica.analytics.impl.Ho
    public final String a() {
        return this.f1062a.getString(q.b, null);
    }

    public final C0611tf b(EnumC0485oe enumC0485oe, int i2) {
        C0586sf c0586sf;
        int ordinal = enumC0485oe.ordinal();
        if (ordinal == 0) {
            c0586sf = i;
        } else if (ordinal != 1) {
            c0586sf = ordinal != 2 ? null : k;
        } else {
            c0586sf = j;
        }
        return c0586sf != null ? (C0611tf) b(c0586sf.b, i2) : this;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0561rf
    public final Set<String> c() {
        return this.f1062a.a();
    }

    public final Boolean d() {
        C0586sf c0586sf = g;
        if (this.f1062a.a(c0586sf.b)) {
            return Boolean.valueOf(this.f1062a.getBoolean(c0586sf.b, true));
        }
        return null;
    }

    @Override // io.appmetrica.analytics.impl.Td
    public final String f(String str) {
        return new C0586sf(str, null).b;
    }

    @Override // io.appmetrica.analytics.impl.Ho
    public final void a(String str) {
        b(q.b, str).b();
    }

    public final boolean a(boolean z) {
        return this.f1062a.getBoolean(s.b, z);
    }

    public final int a(EnumC0485oe enumC0485oe, int i2) {
        C0586sf c0586sf;
        int ordinal = enumC0485oe.ordinal();
        if (ordinal == 0) {
            c0586sf = i;
        } else if (ordinal != 1) {
            c0586sf = ordinal != 2 ? null : k;
        } else {
            c0586sf = j;
        }
        if (c0586sf == null) {
            return i2;
        }
        return this.f1062a.getInt(c0586sf.b, i2);
    }

    public final C0611tf b(EnumC0485oe enumC0485oe, long j2) {
        C0586sf c0586sf;
        int ordinal = enumC0485oe.ordinal();
        if (ordinal == 0) {
            c0586sf = l;
        } else if (ordinal != 1) {
            c0586sf = ordinal != 2 ? null : n;
        } else {
            c0586sf = m;
        }
        return c0586sf != null ? (C0611tf) b(c0586sf.b, j2) : this;
    }

    public final long a(EnumC0485oe enumC0485oe, long j2) {
        C0586sf c0586sf;
        int ordinal = enumC0485oe.ordinal();
        if (ordinal == 0) {
            c0586sf = l;
        } else if (ordinal != 1) {
            c0586sf = ordinal != 2 ? null : n;
        } else {
            c0586sf = m;
        }
        if (c0586sf == null) {
            return j2;
        }
        return this.f1062a.getLong(c0586sf.b, j2);
    }
}
