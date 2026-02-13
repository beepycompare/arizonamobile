package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences;
/* loaded from: classes5.dex */
public abstract class D2 implements ModulePreferences {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0634ul f541a;

    public D2(InterfaceC0634ul interfaceC0634ul) {
        this.f541a = interfaceC0634ul;
    }

    public abstract String a(String str);

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final boolean getBoolean(String str, boolean z) {
        return ((AbstractC0726yd) this.f541a).c(str, z);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final int getInt(String str, int i) {
        return ((AbstractC0726yd) this.f541a).c(str, i);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final long getLong(String str, long j) {
        return ((AbstractC0726yd) this.f541a).c(a(str), j);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final String getString(String str, String str2) {
        return ((AbstractC0726yd) this.f541a).c(a(str), str2);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putBoolean(String str, boolean z) {
        AbstractC0726yd abstractC0726yd = (AbstractC0726yd) this.f541a;
        ((Xe) ((InterfaceC0634ul) abstractC0726yd.b(abstractC0726yd.f(a(str)), z))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putInt(String str, int i) {
        AbstractC0726yd abstractC0726yd = (AbstractC0726yd) this.f541a;
        ((Xe) ((InterfaceC0634ul) abstractC0726yd.b(abstractC0726yd.f(str), i))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putLong(String str, long j) {
        AbstractC0726yd abstractC0726yd = (AbstractC0726yd) this.f541a;
        ((Xe) ((InterfaceC0634ul) abstractC0726yd.b(abstractC0726yd.f(a(str)), j))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putString(String str, String str2) {
        AbstractC0726yd abstractC0726yd = (AbstractC0726yd) this.f541a;
        ((Xe) ((InterfaceC0634ul) abstractC0726yd.b(abstractC0726yd.f(a(str)), str2))).b();
    }
}
