package io.appmetrica.analytics.impl;
/* loaded from: classes3.dex */
public abstract class Fd extends AbstractC0169cf implements InterfaceC0731yl {
    public Fd(Oa oa, String str) {
        super(oa, str);
    }

    public final String c(String str, String str2) {
        return this.f830a.getString(f(str), str2);
    }

    public final InterfaceC0731yl d(String str, String str2) {
        return (InterfaceC0731yl) b(f(str), str2);
    }

    public final boolean e(String str) {
        return this.f830a.a(f(str));
    }

    public abstract String f(String str);

    public InterfaceC0731yl g(String str) {
        return (InterfaceC0731yl) d(f(str));
    }

    public Fd(Oa oa) {
        this(oa, null);
    }

    public final InterfaceC0731yl d(String str, int i) {
        return (InterfaceC0731yl) b(f(str), i);
    }

    public final int c(String str, int i) {
        return this.f830a.getInt(f(str), i);
    }

    public final InterfaceC0731yl d(String str, long j) {
        return (InterfaceC0731yl) b(f(str), j);
    }

    public final InterfaceC0731yl d(String str, boolean z) {
        return (InterfaceC0731yl) b(f(str), z);
    }

    public final long c(String str, long j) {
        return this.f830a.getLong(f(str), j);
    }

    public final boolean c(String str, boolean z) {
        return this.f830a.getBoolean(f(str), z);
    }
}
