package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessorsHolder;
/* renamed from: io.appmetrica.analytics.impl.a6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0112a6 implements Z5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0732y5 f884a;

    public C0112a6(C0732y5 c0732y5) {
        this.f884a = c0732y5;
    }

    @Override // io.appmetrica.analytics.impl.Z5, io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueContext
    public final C0732y5 getAdRevenueProcessorsHolder() {
        return this.f884a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueContext
    public final ModuleAdRevenueProcessorsHolder getAdRevenueProcessorsHolder() {
        return this.f884a;
    }
}
