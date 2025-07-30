package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessorsHolder;
/* renamed from: io.appmetrica.analytics.impl.g6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0277g6 implements InterfaceC0251f6 {

    /* renamed from: a  reason: collision with root package name */
    public final D5 f861a;

    public C0277g6(D5 d5) {
        this.f861a = d5;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0251f6, io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueContext
    public final D5 getAdRevenueProcessorsHolder() {
        return this.f861a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueContext
    public final ModuleAdRevenueProcessorsHolder getAdRevenueProcessorsHolder() {
        return this.f861a;
    }
}
