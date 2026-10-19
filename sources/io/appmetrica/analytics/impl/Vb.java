package io.appmetrica.analytics.impl;

import java.util.Set;
/* loaded from: classes5.dex */
public final class Vb implements InterfaceC0343jb {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0343jb f813a;

    public Vb(InterfaceC0343jb interfaceC0343jb) {
        this.f813a = interfaceC0343jb;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0343jb
    public final InterfaceC0343jb a(String str, String str2) {
        this.f813a.a(str, str2);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0343jb
    public final Set b() {
        return this.f813a.b();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0343jb
    public final void flushAsync() {
        this.f813a.flushAsync();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0343jb
    public final boolean getBoolean(String str, boolean z) {
        return this.f813a.getBoolean(str, z);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0343jb
    public final int getInt(String str, int i) {
        return this.f813a.getInt(str, i);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0343jb
    public final long getLong(String str, long j) {
        return this.f813a.getLong(str, j);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0343jb
    public final String getString(String str, String str2) {
        return this.f813a.getString(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0343jb
    public final InterfaceC0343jb remove(String str) {
        this.f813a.remove(str);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0343jb
    public final InterfaceC0343jb a(String str, long j) {
        this.f813a.a(str, j);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0343jb
    public final InterfaceC0343jb a(String str, int i) {
        this.f813a.a(str, i);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0343jb
    public final InterfaceC0343jb a(String str, boolean z) {
        this.f813a.a(str, z);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0343jb
    public final InterfaceC0343jb a(String str, float f) {
        this.f813a.a(str, f);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0343jb
    public final boolean a(String str) {
        return this.f813a.a(str);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0343jb
    public final void a() {
        this.f813a.a();
    }
}
