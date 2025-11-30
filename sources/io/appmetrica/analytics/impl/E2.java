package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences;
/* loaded from: classes5.dex */
public abstract class E2 implements ModulePreferences {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0656vl f452a;

    public E2(InterfaceC0656vl interfaceC0656vl) {
        this.f452a = interfaceC0656vl;
    }

    public abstract String a(String str);

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final boolean getBoolean(String str, boolean z) {
        return ((AbstractC0748zd) this.f452a).c(str, z);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final int getInt(String str, int i) {
        return ((AbstractC0748zd) this.f452a).c(str, i);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final long getLong(String str, long j) {
        return ((AbstractC0748zd) this.f452a).c(a(str), j);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final String getString(String str, String str2) {
        return ((AbstractC0748zd) this.f452a).c(a(str), str2);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putBoolean(String str, boolean z) {
        AbstractC0748zd abstractC0748zd = (AbstractC0748zd) this.f452a;
        ((Ye) ((InterfaceC0656vl) abstractC0748zd.b(abstractC0748zd.f(a(str)), z))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putInt(String str, int i) {
        AbstractC0748zd abstractC0748zd = (AbstractC0748zd) this.f452a;
        ((Ye) ((InterfaceC0656vl) abstractC0748zd.b(abstractC0748zd.f(str), i))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putLong(String str, long j) {
        AbstractC0748zd abstractC0748zd = (AbstractC0748zd) this.f452a;
        ((Ye) ((InterfaceC0656vl) abstractC0748zd.b(abstractC0748zd.f(a(str)), j))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putString(String str, String str2) {
        AbstractC0748zd abstractC0748zd = (AbstractC0748zd) this.f452a;
        ((Ye) ((InterfaceC0656vl) abstractC0748zd.b(abstractC0748zd.f(a(str)), str2))).b();
    }
}
