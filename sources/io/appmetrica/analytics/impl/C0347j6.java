package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessorsHolder;
/* renamed from: io.appmetrica.analytics.impl.j6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0347j6 implements InterfaceC0322i6 {

    /* renamed from: a  reason: collision with root package name */
    public final G5 f930a;

    public C0347j6(G5 g5) {
        this.f930a = g5;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0322i6, io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueContext
    public final G5 getAdRevenueProcessorsHolder() {
        return this.f930a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueContext
    public final ModuleAdRevenueProcessorsHolder getAdRevenueProcessorsHolder() {
        return this.f930a;
    }
}
