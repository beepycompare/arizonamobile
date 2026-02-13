package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.yd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0726yd extends Xe implements InterfaceC0634ul {
    public AbstractC0726yd(Ha ha, String str) {
        super(ha, str);
    }

    public final String c(String str, String str2) {
        return this.f853a.getString(f(str), str2);
    }

    public final InterfaceC0634ul d(String str, String str2) {
        return (InterfaceC0634ul) b(f(str), str2);
    }

    public final boolean e(String str) {
        return this.f853a.a(f(str));
    }

    public abstract String f(String str);

    public InterfaceC0634ul g(String str) {
        return (InterfaceC0634ul) d(f(str));
    }

    public AbstractC0726yd(Ha ha) {
        this(ha, null);
    }

    public final InterfaceC0634ul d(String str, int i) {
        return (InterfaceC0634ul) b(f(str), i);
    }

    public final int c(String str, int i) {
        return this.f853a.getInt(f(str), i);
    }

    public final InterfaceC0634ul d(String str, long j) {
        return (InterfaceC0634ul) b(f(str), j);
    }

    public final InterfaceC0634ul d(String str, boolean z) {
        return (InterfaceC0634ul) b(f(str), z);
    }

    public final long c(String str, long j) {
        return this.f853a.getLong(f(str), j);
    }

    public final boolean c(String str, boolean z) {
        return this.f853a.getBoolean(f(str), z);
    }
}
