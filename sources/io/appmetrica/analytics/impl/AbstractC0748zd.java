package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.zd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0748zd extends Ye implements InterfaceC0656vl {
    public AbstractC0748zd(Ia ia, String str) {
        super(ia, str);
    }

    public final String c(String str, String str2) {
        return this.f765a.getString(f(str), str2);
    }

    public final InterfaceC0656vl d(String str, String str2) {
        return (InterfaceC0656vl) b(f(str), str2);
    }

    public final boolean e(String str) {
        return this.f765a.a(f(str));
    }

    public abstract String f(String str);

    public InterfaceC0656vl g(String str) {
        return (InterfaceC0656vl) d(f(str));
    }

    public AbstractC0748zd(Ia ia) {
        this(ia, null);
    }

    public final InterfaceC0656vl d(String str, int i) {
        return (InterfaceC0656vl) b(f(str), i);
    }

    public final int c(String str, int i) {
        return this.f765a.getInt(f(str), i);
    }

    public final InterfaceC0656vl d(String str, long j) {
        return (InterfaceC0656vl) b(f(str), j);
    }

    public final InterfaceC0656vl d(String str, boolean z) {
        return (InterfaceC0656vl) b(f(str), z);
    }

    public final long c(String str, long j) {
        return this.f765a.getLong(f(str), j);
    }

    public final boolean c(String str, boolean z) {
        return this.f765a.getBoolean(f(str), z);
    }
}
