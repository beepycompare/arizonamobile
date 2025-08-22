package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public abstract class Pd extends AbstractC0458nf implements InterfaceC0763zl {
    public Pd(InterfaceC0223eb interfaceC0223eb, String str) {
        super(interfaceC0223eb, str);
    }

    public final String c(String str, String str2) {
        return this.f983a.getString(f(str), str2);
    }

    public final InterfaceC0763zl d(String str, String str2) {
        return (InterfaceC0763zl) b(f(str), str2);
    }

    public final boolean e(String str) {
        return this.f983a.a(f(str));
    }

    public abstract String f(String str);

    public InterfaceC0763zl g(String str) {
        return (InterfaceC0763zl) d(f(str));
    }

    public Pd(InterfaceC0223eb interfaceC0223eb) {
        this(interfaceC0223eb, null);
    }

    public final InterfaceC0763zl d(String str, int i) {
        return (InterfaceC0763zl) b(f(str), i);
    }

    public final int c(String str, int i) {
        return this.f983a.getInt(f(str), i);
    }

    public final InterfaceC0763zl d(String str, long j) {
        return (InterfaceC0763zl) b(f(str), j);
    }

    public final InterfaceC0763zl d(String str, boolean z) {
        return (InterfaceC0763zl) b(f(str), z);
    }

    public final long c(String str, long j) {
        return this.f983a.getLong(f(str), j);
    }

    public final boolean c(String str, boolean z) {
        return this.f983a.getBoolean(f(str), z);
    }
}
