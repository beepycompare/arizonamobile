package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences;
/* loaded from: classes4.dex */
public abstract class S2 implements ModulePreferences {

    /* renamed from: a  reason: collision with root package name */
    public final Dl f664a;

    public S2(Dl dl) {
        this.f664a = dl;
    }

    public abstract String a(String str);

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final boolean getBoolean(String str, boolean z) {
        return ((Td) this.f664a).c(str, z);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final int getInt(String str, int i) {
        return ((Td) this.f664a).c(str, i);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final long getLong(String str, long j) {
        return ((Td) this.f664a).c(a(str), j);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final String getString(String str, String str2) {
        return ((Td) this.f664a).c(a(str), str2);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putBoolean(String str, boolean z) {
        Td td = (Td) this.f664a;
        ((AbstractC0562rf) ((Dl) td.b(td.f(a(str)), z))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putInt(String str, int i) {
        Td td = (Td) this.f664a;
        ((AbstractC0562rf) ((Dl) td.b(td.f(str), i))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putLong(String str, long j) {
        Td td = (Td) this.f664a;
        ((AbstractC0562rf) ((Dl) td.b(td.f(a(str)), j))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putString(String str, String str2) {
        Td td = (Td) this.f664a;
        ((AbstractC0562rf) ((Dl) td.b(td.f(a(str)), str2))).b();
    }
}
