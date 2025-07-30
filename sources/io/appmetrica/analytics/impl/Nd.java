package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public abstract class Nd extends AbstractC0410lf implements InterfaceC0640ul {
    public Nd(InterfaceC0179cb interfaceC0179cb, String str) {
        super(interfaceC0179cb, str);
    }

    public final String c(String str, String str2) {
        return this.f939a.getString(f(str), str2);
    }

    public final InterfaceC0640ul d(String str, String str2) {
        return (InterfaceC0640ul) b(f(str), str2);
    }

    public final boolean e(String str) {
        return this.f939a.a(f(str));
    }

    public abstract String f(String str);

    public InterfaceC0640ul g(String str) {
        return (InterfaceC0640ul) d(f(str));
    }

    public Nd(InterfaceC0179cb interfaceC0179cb) {
        this(interfaceC0179cb, null);
    }

    public final InterfaceC0640ul d(String str, int i) {
        return (InterfaceC0640ul) b(f(str), i);
    }

    public final int c(String str, int i) {
        return this.f939a.getInt(f(str), i);
    }

    public final InterfaceC0640ul d(String str, long j) {
        return (InterfaceC0640ul) b(f(str), j);
    }

    public final InterfaceC0640ul d(String str, boolean z) {
        return (InterfaceC0640ul) b(f(str), z);
    }

    public final long c(String str, long j) {
        return this.f939a.getLong(f(str), j);
    }

    public final boolean c(String str, boolean z) {
        return this.f939a.getBoolean(f(str), z);
    }
}
