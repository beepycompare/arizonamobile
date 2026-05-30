package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessorsHolder;
/* renamed from: io.appmetrica.analytics.impl.a6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0113a6 implements Z5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0733y5 f882a;

    public C0113a6(C0733y5 c0733y5) {
        this.f882a = c0733y5;
    }

    @Override // io.appmetrica.analytics.impl.Z5, io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueContext
    public final C0733y5 getAdRevenueProcessorsHolder() {
        return this.f882a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueContext
    public final ModuleAdRevenueProcessorsHolder getAdRevenueProcessorsHolder() {
        return this.f882a;
    }
}
