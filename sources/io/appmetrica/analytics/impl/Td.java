package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public abstract class Td extends AbstractC0562rf implements Dl {
    public Td(InterfaceC0302hb interfaceC0302hb, String str) {
        super(interfaceC0302hb, str);
    }

    public final String c(String str, String str2) {
        return this.f1067a.getString(f(str), str2);
    }

    public final Dl d(String str, String str2) {
        return (Dl) b(f(str), str2);
    }

    public final boolean e(String str) {
        return this.f1067a.a(f(str));
    }

    public abstract String f(String str);

    public Dl g(String str) {
        return (Dl) d(f(str));
    }

    public Td(InterfaceC0302hb interfaceC0302hb) {
        this(interfaceC0302hb, null);
    }

    public final Dl d(String str, int i) {
        return (Dl) b(f(str), i);
    }

    public final int c(String str, int i) {
        return this.f1067a.getInt(f(str), i);
    }

    public final Dl d(String str, long j) {
        return (Dl) b(f(str), j);
    }

    public final Dl d(String str, boolean z) {
        return (Dl) b(f(str), z);
    }

    public final long c(String str, long j) {
        return this.f1067a.getLong(f(str), j);
    }

    public final boolean c(String str, boolean z) {
        return this.f1067a.getBoolean(f(str), z);
    }
}
