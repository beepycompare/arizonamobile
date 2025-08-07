package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public abstract class Nd extends AbstractC0411lf implements InterfaceC0641ul {
    public Nd(InterfaceC0180cb interfaceC0180cb, String str) {
        super(interfaceC0180cb, str);
    }

    public final String c(String str, String str2) {
        return this.f938a.getString(f(str), str2);
    }

    public final InterfaceC0641ul d(String str, String str2) {
        return (InterfaceC0641ul) b(f(str), str2);
    }

    public final boolean e(String str) {
        return this.f938a.a(f(str));
    }

    public abstract String f(String str);

    public InterfaceC0641ul g(String str) {
        return (InterfaceC0641ul) d(f(str));
    }

    public Nd(InterfaceC0180cb interfaceC0180cb) {
        this(interfaceC0180cb, null);
    }

    public final InterfaceC0641ul d(String str, int i) {
        return (InterfaceC0641ul) b(f(str), i);
    }

    public final int c(String str, int i) {
        return this.f938a.getInt(f(str), i);
    }

    public final InterfaceC0641ul d(String str, long j) {
        return (InterfaceC0641ul) b(f(str), j);
    }

    public final InterfaceC0641ul d(String str, boolean z) {
        return (InterfaceC0641ul) b(f(str), z);
    }

    public final long c(String str, long j) {
        return this.f938a.getLong(f(str), j);
    }

    public final boolean c(String str, boolean z) {
        return this.f938a.getBoolean(f(str), z);
    }
}
