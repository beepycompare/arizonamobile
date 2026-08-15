package io.appmetrica.analytics.impl;

import java.util.Set;
/* loaded from: classes5.dex */
public final class Vb implements InterfaceC0349jb {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0349jb f810a;

    public Vb(InterfaceC0349jb interfaceC0349jb) {
        this.f810a = interfaceC0349jb;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0349jb
    public final InterfaceC0349jb a(String str, String str2) {
        this.f810a.a(str, str2);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0349jb
    public final Set b() {
        return this.f810a.b();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0349jb
    public final void flushAsync() {
        this.f810a.flushAsync();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0349jb
    public final boolean getBoolean(String str, boolean z) {
        return this.f810a.getBoolean(str, z);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0349jb
    public final int getInt(String str, int i) {
        return this.f810a.getInt(str, i);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0349jb
    public final long getLong(String str, long j) {
        return this.f810a.getLong(str, j);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0349jb
    public final String getString(String str, String str2) {
        return this.f810a.getString(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0349jb
    public final InterfaceC0349jb remove(String str) {
        this.f810a.remove(str);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0349jb
    public final InterfaceC0349jb a(String str, long j) {
        this.f810a.a(str, j);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0349jb
    public final InterfaceC0349jb a(String str, int i) {
        this.f810a.a(str, i);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0349jb
    public final InterfaceC0349jb a(String str, boolean z) {
        this.f810a.a(str, z);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0349jb
    public final InterfaceC0349jb a(String str, float f) {
        this.f810a.a(str, f);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0349jb
    public final boolean a(String str) {
        return this.f810a.a(str);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0349jb
    public final void a() {
        this.f810a.a();
    }
}
