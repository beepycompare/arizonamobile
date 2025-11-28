package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences;
/* loaded from: classes5.dex */
public abstract class L2 implements ModulePreferences {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0731yl f568a;

    public L2(InterfaceC0731yl interfaceC0731yl) {
        this.f568a = interfaceC0731yl;
    }

    public abstract String a(String str);

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final boolean getBoolean(String str, boolean z) {
        return ((Fd) this.f568a).c(str, z);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final int getInt(String str, int i) {
        return ((Fd) this.f568a).c(str, i);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final long getLong(String str, long j) {
        return ((Fd) this.f568a).c(a(str), j);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final String getString(String str, String str2) {
        return ((Fd) this.f568a).c(a(str), str2);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putBoolean(String str, boolean z) {
        Fd fd = (Fd) this.f568a;
        ((AbstractC0169cf) ((InterfaceC0731yl) fd.b(fd.f(a(str)), z))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putInt(String str, int i) {
        Fd fd = (Fd) this.f568a;
        ((AbstractC0169cf) ((InterfaceC0731yl) fd.b(fd.f(str), i))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putLong(String str, long j) {
        Fd fd = (Fd) this.f568a;
        ((AbstractC0169cf) ((InterfaceC0731yl) fd.b(fd.f(a(str)), j))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putString(String str, String str2) {
        Fd fd = (Fd) this.f568a;
        ((AbstractC0169cf) ((InterfaceC0731yl) fd.b(fd.f(a(str)), str2))).b();
    }
}
