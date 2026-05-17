package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.yd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0725yd extends Xe implements InterfaceC0633ul {
    public AbstractC0725yd(Ha ha, String str) {
        super(ha, str);
    }

    public final String c(String str, String str2) {
        return this.f858a.getString(f(str), str2);
    }

    public final InterfaceC0633ul d(String str, String str2) {
        return (InterfaceC0633ul) b(f(str), str2);
    }

    public final boolean e(String str) {
        return this.f858a.a(f(str));
    }

    public abstract String f(String str);

    public InterfaceC0633ul g(String str) {
        return (InterfaceC0633ul) d(f(str));
    }

    public AbstractC0725yd(Ha ha) {
        this(ha, null);
    }

    public final InterfaceC0633ul d(String str, int i) {
        return (InterfaceC0633ul) b(f(str), i);
    }

    public final int c(String str, int i) {
        return this.f858a.getInt(f(str), i);
    }

    public final InterfaceC0633ul d(String str, long j) {
        return (InterfaceC0633ul) b(f(str), j);
    }

    public final InterfaceC0633ul d(String str, boolean z) {
        return (InterfaceC0633ul) b(f(str), z);
    }

    public final long c(String str, long j) {
        return this.f858a.getLong(f(str), j);
    }

    public final boolean c(String str, boolean z) {
        return this.f858a.getBoolean(f(str), z);
    }
}
