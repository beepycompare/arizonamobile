package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessorsHolder;
/* renamed from: io.appmetrica.analytics.impl.g6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0270g6 implements InterfaceC0244f6 {

    /* renamed from: a  reason: collision with root package name */
    public final D5 f867a;

    public C0270g6(D5 d5) {
        this.f867a = d5;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0244f6, io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueContext
    public final D5 getAdRevenueProcessorsHolder() {
        return this.f867a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueContext
    public final ModuleAdRevenueProcessorsHolder getAdRevenueProcessorsHolder() {
        return this.f867a;
    }
}
