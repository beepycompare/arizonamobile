package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessorsHolder;
/* renamed from: io.appmetrica.analytics.impl.a6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0111a6 implements Z5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0731y5 f884a;

    public C0111a6(C0731y5 c0731y5) {
        this.f884a = c0731y5;
    }

    @Override // io.appmetrica.analytics.impl.Z5, io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueContext
    public final C0731y5 getAdRevenueProcessorsHolder() {
        return this.f884a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueContext
    public final ModuleAdRevenueProcessorsHolder getAdRevenueProcessorsHolder() {
        return this.f884a;
    }
}
