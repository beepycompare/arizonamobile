package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessorsHolder;
/* loaded from: classes5.dex */
public final class K5 implements J5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0317i5 f658a;

    public K5(C0317i5 c0317i5) {
        this.f658a = c0317i5;
    }

    @Override // io.appmetrica.analytics.impl.J5, io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueContext
    public final C0317i5 getAdRevenueProcessorsHolder() {
        return this.f658a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueContext
    public final ModuleAdRevenueProcessorsHolder getAdRevenueProcessorsHolder() {
        return this.f658a;
    }
}
