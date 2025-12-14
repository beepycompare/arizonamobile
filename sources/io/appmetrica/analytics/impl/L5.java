package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessorsHolder;
/* loaded from: classes5.dex */
public final class L5 implements K5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0338j5 f662a;

    public L5(C0338j5 c0338j5) {
        this.f662a = c0338j5;
    }

    @Override // io.appmetrica.analytics.impl.K5, io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueContext
    public final C0338j5 getAdRevenueProcessorsHolder() {
        return this.f662a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueContext
    public final ModuleAdRevenueProcessorsHolder getAdRevenueProcessorsHolder() {
        return this.f662a;
    }
}
