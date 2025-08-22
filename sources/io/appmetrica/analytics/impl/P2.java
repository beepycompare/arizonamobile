package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences;
/* loaded from: classes4.dex */
public abstract class P2 implements ModulePreferences {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0763zl f597a;

    public P2(InterfaceC0763zl interfaceC0763zl) {
        this.f597a = interfaceC0763zl;
    }

    public abstract String a(String str);

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final boolean getBoolean(String str, boolean z) {
        return ((Pd) this.f597a).c(str, z);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final int getInt(String str, int i) {
        return ((Pd) this.f597a).c(str, i);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final long getLong(String str, long j) {
        return ((Pd) this.f597a).c(a(str), j);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final String getString(String str, String str2) {
        return ((Pd) this.f597a).c(a(str), str2);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putBoolean(String str, boolean z) {
        Pd pd = (Pd) this.f597a;
        ((AbstractC0458nf) ((InterfaceC0763zl) pd.b(pd.f(a(str)), z))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putInt(String str, int i) {
        Pd pd = (Pd) this.f597a;
        ((AbstractC0458nf) ((InterfaceC0763zl) pd.b(pd.f(str), i))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putLong(String str, long j) {
        Pd pd = (Pd) this.f597a;
        ((AbstractC0458nf) ((InterfaceC0763zl) pd.b(pd.f(a(str)), j))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putString(String str, String str2) {
        Pd pd = (Pd) this.f597a;
        ((AbstractC0458nf) ((InterfaceC0763zl) pd.b(pd.f(a(str)), str2))).b();
    }
}
