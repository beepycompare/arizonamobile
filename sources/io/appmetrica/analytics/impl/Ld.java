package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public abstract class Ld extends AbstractC0366jf implements InterfaceC0571rl {
    public Ld(InterfaceC0135ab interfaceC0135ab, String str) {
        super(interfaceC0135ab, str);
    }

    public final String c(String str, String str2) {
        return this.f891a.getString(f(str), str2);
    }

    public final InterfaceC0571rl d(String str, String str2) {
        return (InterfaceC0571rl) b(f(str), str2);
    }

    public final boolean e(String str) {
        return this.f891a.a(f(str));
    }

    public abstract String f(String str);

    public InterfaceC0571rl g(String str) {
        return (InterfaceC0571rl) d(f(str));
    }

    public Ld(InterfaceC0135ab interfaceC0135ab) {
        this(interfaceC0135ab, null);
    }

    public final InterfaceC0571rl d(String str, int i) {
        return (InterfaceC0571rl) b(f(str), i);
    }

    public final int c(String str, int i) {
        return this.f891a.getInt(f(str), i);
    }

    public final InterfaceC0571rl d(String str, long j) {
        return (InterfaceC0571rl) b(f(str), j);
    }

    public final InterfaceC0571rl d(String str, boolean z) {
        return (InterfaceC0571rl) b(f(str), z);
    }

    public final long c(String str, long j) {
        return this.f891a.getLong(f(str), j);
    }

    public final boolean c(String str, boolean z) {
        return this.f891a.getBoolean(f(str), z);
    }
}
