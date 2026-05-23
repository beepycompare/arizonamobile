package io.appmetrica.analytics.impl;

import java.util.Set;
/* loaded from: classes5.dex */
public final class Vb implements InterfaceC0350jb {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0350jb f807a;

    public Vb(InterfaceC0350jb interfaceC0350jb) {
        this.f807a = interfaceC0350jb;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0350jb
    public final InterfaceC0350jb a(String str, String str2) {
        this.f807a.a(str, str2);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0350jb
    public final Set b() {
        return this.f807a.b();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0350jb
    public final void flushAsync() {
        this.f807a.flushAsync();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0350jb
    public final boolean getBoolean(String str, boolean z) {
        return this.f807a.getBoolean(str, z);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0350jb
    public final int getInt(String str, int i) {
        return this.f807a.getInt(str, i);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0350jb
    public final long getLong(String str, long j) {
        return this.f807a.getLong(str, j);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0350jb
    public final String getString(String str, String str2) {
        return this.f807a.getString(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0350jb
    public final InterfaceC0350jb remove(String str) {
        this.f807a.remove(str);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0350jb
    public final InterfaceC0350jb a(String str, long j) {
        this.f807a.a(str, j);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0350jb
    public final InterfaceC0350jb a(String str, int i) {
        this.f807a.a(str, i);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0350jb
    public final InterfaceC0350jb a(String str, boolean z) {
        this.f807a.a(str, z);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0350jb
    public final InterfaceC0350jb a(String str, float f) {
        this.f807a.a(str, f);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0350jb
    public final boolean a(String str) {
        return this.f807a.a(str);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0350jb
    public final void a() {
        this.f807a.a();
    }
}
