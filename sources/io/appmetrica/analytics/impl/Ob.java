package io.appmetrica.analytics.impl;

import java.util.Set;
/* loaded from: classes4.dex */
public final class Ob implements InterfaceC0180cb {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0180cb f576a;

    public Ob(InterfaceC0180cb interfaceC0180cb) {
        this.f576a = interfaceC0180cb;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0180cb
    public final InterfaceC0180cb a(String str, String str2) {
        this.f576a.a(str, str2);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0180cb
    public final void b() {
        this.f576a.b();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0180cb
    public final boolean getBoolean(String str, boolean z) {
        return this.f576a.getBoolean(str, z);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0180cb
    public final int getInt(String str, int i) {
        return this.f576a.getInt(str, i);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0180cb
    public final long getLong(String str, long j) {
        return this.f576a.getLong(str, j);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0180cb
    public final String getString(String str, String str2) {
        return this.f576a.getString(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0180cb
    public final InterfaceC0180cb remove(String str) {
        this.f576a.remove(str);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0180cb
    public final InterfaceC0180cb a(String str, long j) {
        this.f576a.a(str, j);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0180cb
    public final InterfaceC0180cb a(int i, String str) {
        this.f576a.a(i, str);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0180cb
    public final InterfaceC0180cb a(String str, boolean z) {
        this.f576a.a(str, z);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0180cb
    public final InterfaceC0180cb a(String str, float f) {
        this.f576a.a(str, f);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0180cb
    public final boolean a(String str) {
        return this.f576a.a(str);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0180cb
    public final Set a() {
        return this.f576a.a();
    }
}
