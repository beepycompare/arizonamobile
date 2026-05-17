package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences;
/* loaded from: classes5.dex */
public abstract class D2 implements ModulePreferences {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0633ul f546a;

    public D2(InterfaceC0633ul interfaceC0633ul) {
        this.f546a = interfaceC0633ul;
    }

    public abstract String a(String str);

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final boolean getBoolean(String str, boolean z) {
        return ((AbstractC0725yd) this.f546a).c(str, z);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final int getInt(String str, int i) {
        return ((AbstractC0725yd) this.f546a).c(str, i);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final long getLong(String str, long j) {
        return ((AbstractC0725yd) this.f546a).c(a(str), j);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final String getString(String str, String str2) {
        return ((AbstractC0725yd) this.f546a).c(a(str), str2);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putBoolean(String str, boolean z) {
        AbstractC0725yd abstractC0725yd = (AbstractC0725yd) this.f546a;
        ((Xe) ((InterfaceC0633ul) abstractC0725yd.b(abstractC0725yd.f(a(str)), z))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putInt(String str, int i) {
        AbstractC0725yd abstractC0725yd = (AbstractC0725yd) this.f546a;
        ((Xe) ((InterfaceC0633ul) abstractC0725yd.b(abstractC0725yd.f(str), i))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putLong(String str, long j) {
        AbstractC0725yd abstractC0725yd = (AbstractC0725yd) this.f546a;
        ((Xe) ((InterfaceC0633ul) abstractC0725yd.b(abstractC0725yd.f(a(str)), j))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putString(String str, String str2) {
        AbstractC0725yd abstractC0725yd = (AbstractC0725yd) this.f546a;
        ((Xe) ((InterfaceC0633ul) abstractC0725yd.b(abstractC0725yd.f(a(str)), str2))).b();
    }
}
