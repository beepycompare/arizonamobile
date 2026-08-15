package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public abstract class Yd extends AbstractC0716xf {
    public Yd(InterfaceC0349jb interfaceC0349jb, String str) {
        super(interfaceC0349jb, str);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0716xf
    public final String a(String str, String str2) {
        return this.f1281a.getString(g(str), str2);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0716xf
    public final Zl b(String str, String str2) {
        return d(g(str), str2);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0716xf
    public Zl e(String str) {
        return f(g(str));
    }

    public abstract String g(String str);

    public Yd(InterfaceC0349jb interfaceC0349jb) {
        this(interfaceC0349jb, null);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0716xf
    public final Zl b(String str, int i) {
        return d(g(str), i);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0716xf
    public final int a(String str, int i) {
        return this.f1281a.getInt(g(str), i);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0716xf
    public final Zl b(String str, long j) {
        return d(g(str), j);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0716xf
    public final Zl b(String str, boolean z) {
        return d(g(str), z);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0716xf
    public final long a(String str, long j) {
        return this.f1281a.getLong(g(str), j);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0716xf
    public final boolean b(String str) {
        return this.f1281a.a(g(str));
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0716xf
    public final boolean a(String str, boolean z) {
        return this.f1281a.getBoolean(g(str), z);
    }
}
