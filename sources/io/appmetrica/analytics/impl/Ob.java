package io.appmetrica.analytics.impl;

import java.util.Set;
/* loaded from: classes4.dex */
public final class Ob implements InterfaceC0179cb {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0179cb f577a;

    public Ob(InterfaceC0179cb interfaceC0179cb) {
        this.f577a = interfaceC0179cb;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0179cb
    public final InterfaceC0179cb a(String str, String str2) {
        this.f577a.a(str, str2);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0179cb
    public final void b() {
        this.f577a.b();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0179cb
    public final boolean getBoolean(String str, boolean z) {
        return this.f577a.getBoolean(str, z);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0179cb
    public final int getInt(String str, int i) {
        return this.f577a.getInt(str, i);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0179cb
    public final long getLong(String str, long j) {
        return this.f577a.getLong(str, j);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0179cb
    public final String getString(String str, String str2) {
        return this.f577a.getString(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0179cb
    public final InterfaceC0179cb remove(String str) {
        this.f577a.remove(str);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0179cb
    public final InterfaceC0179cb a(String str, long j) {
        this.f577a.a(str, j);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0179cb
    public final InterfaceC0179cb a(int i, String str) {
        this.f577a.a(i, str);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0179cb
    public final InterfaceC0179cb a(String str, boolean z) {
        this.f577a.a(str, z);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0179cb
    public final InterfaceC0179cb a(String str, float f) {
        this.f577a.a(str, f);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0179cb
    public final boolean a(String str) {
        return this.f577a.a(str);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0179cb
    public final Set a() {
        return this.f577a.a();
    }
}
