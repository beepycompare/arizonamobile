package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences;
/* loaded from: classes4.dex */
public abstract class P2 implements ModulePreferences {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0571rl f572a;

    public P2(InterfaceC0571rl interfaceC0571rl) {
        this.f572a = interfaceC0571rl;
    }

    public abstract String a(String str);

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final boolean getBoolean(String str, boolean z) {
        return ((Ld) this.f572a).c(str, z);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final int getInt(String str, int i) {
        return ((Ld) this.f572a).c(str, i);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final long getLong(String str, long j) {
        return ((Ld) this.f572a).c(a(str), j);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final String getString(String str, String str2) {
        return ((Ld) this.f572a).c(a(str), str2);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putBoolean(String str, boolean z) {
        Ld ld = (Ld) this.f572a;
        ((AbstractC0366jf) ((InterfaceC0571rl) ld.b(ld.f(a(str)), z))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putInt(String str, int i) {
        Ld ld = (Ld) this.f572a;
        ((AbstractC0366jf) ((InterfaceC0571rl) ld.b(ld.f(str), i))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putLong(String str, long j) {
        Ld ld = (Ld) this.f572a;
        ((AbstractC0366jf) ((InterfaceC0571rl) ld.b(ld.f(a(str)), j))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putString(String str, String str2) {
        Ld ld = (Ld) this.f572a;
        ((AbstractC0366jf) ((InterfaceC0571rl) ld.b(ld.f(a(str)), str2))).b();
    }
}
