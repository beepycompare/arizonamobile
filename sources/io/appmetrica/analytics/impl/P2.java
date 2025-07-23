package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences;
/* loaded from: classes4.dex */
public abstract class P2 implements ModulePreferences {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0640ul f587a;

    public P2(InterfaceC0640ul interfaceC0640ul) {
        this.f587a = interfaceC0640ul;
    }

    public abstract String a(String str);

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final boolean getBoolean(String str, boolean z) {
        return ((Nd) this.f587a).c(str, z);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final int getInt(String str, int i) {
        return ((Nd) this.f587a).c(str, i);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final long getLong(String str, long j) {
        return ((Nd) this.f587a).c(a(str), j);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final String getString(String str, String str2) {
        return ((Nd) this.f587a).c(a(str), str2);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putBoolean(String str, boolean z) {
        Nd nd = (Nd) this.f587a;
        ((AbstractC0410lf) ((InterfaceC0640ul) nd.b(nd.f(a(str)), z))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putInt(String str, int i) {
        Nd nd = (Nd) this.f587a;
        ((AbstractC0410lf) ((InterfaceC0640ul) nd.b(nd.f(str), i))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putLong(String str, long j) {
        Nd nd = (Nd) this.f587a;
        ((AbstractC0410lf) ((InterfaceC0640ul) nd.b(nd.f(a(str)), j))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putString(String str, String str2) {
        Nd nd = (Nd) this.f587a;
        ((AbstractC0410lf) ((InterfaceC0640ul) nd.b(nd.f(a(str)), str2))).b();
    }
}
