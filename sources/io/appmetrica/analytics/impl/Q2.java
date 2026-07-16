package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences;
/* loaded from: classes5.dex */
public abstract class Q2 implements ModulePreferences {

    /* renamed from: a  reason: collision with root package name */
    public final Zl f726a;

    public Q2(Zl zl) {
        this.f726a = zl;
    }

    public abstract String a(String str);

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void flushAsync() {
        this.f726a.flushAsync();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final boolean getBoolean(String str, boolean z) {
        return ((Yd) this.f726a).a(str, z);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final int getInt(String str, int i) {
        return ((Yd) this.f726a).a(str, i);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final long getLong(String str, long j) {
        return ((Yd) this.f726a).a(a(str), j);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final String getString(String str, String str2) {
        return ((Yd) this.f726a).a(a(str), str2);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putBoolean(String str, boolean z) {
        Yd yd = (Yd) this.f726a;
        yd.d(yd.g(a(str)), z);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putInt(String str, int i) {
        Yd yd = (Yd) this.f726a;
        yd.d(yd.g(str), i);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putLong(String str, long j) {
        Yd yd = (Yd) this.f726a;
        yd.d(yd.g(a(str)), j);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putString(String str, String str2) {
        Yd yd = (Yd) this.f726a;
        yd.d(yd.g(a(str)), str2);
    }
}
