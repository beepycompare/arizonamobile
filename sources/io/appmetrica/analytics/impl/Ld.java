package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public abstract class Ld extends AbstractC0358jf implements InterfaceC0563rl {
    public Ld(InterfaceC0127ab interfaceC0127ab, String str) {
        super(interfaceC0127ab, str);
    }

    public final String c(String str, String str2) {
        return this.f892a.getString(f(str), str2);
    }

    public final InterfaceC0563rl d(String str, String str2) {
        return (InterfaceC0563rl) b(f(str), str2);
    }

    public final boolean e(String str) {
        return this.f892a.a(f(str));
    }

    public abstract String f(String str);

    public InterfaceC0563rl g(String str) {
        return (InterfaceC0563rl) d(f(str));
    }

    public Ld(InterfaceC0127ab interfaceC0127ab) {
        this(interfaceC0127ab, null);
    }

    public final InterfaceC0563rl d(String str, int i) {
        return (InterfaceC0563rl) b(f(str), i);
    }

    public final int c(String str, int i) {
        return this.f892a.getInt(f(str), i);
    }

    public final InterfaceC0563rl d(String str, long j) {
        return (InterfaceC0563rl) b(f(str), j);
    }

    public final InterfaceC0563rl d(String str, boolean z) {
        return (InterfaceC0563rl) b(f(str), z);
    }

    public final long c(String str, long j) {
        return this.f892a.getLong(f(str), j);
    }

    public final boolean c(String str, boolean z) {
        return this.f892a.getBoolean(f(str), z);
    }
}
