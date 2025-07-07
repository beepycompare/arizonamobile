package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessorsHolder;
/* renamed from: io.appmetrica.analytics.impl.d6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0208d6 implements InterfaceC0182c6 {

    /* renamed from: a  reason: collision with root package name */
    public final B5 f798a;

    public C0208d6(B5 b5) {
        this.f798a = b5;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0182c6, io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueContext
    public final B5 getAdRevenueProcessorsHolder() {
        return this.f798a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueContext
    public final ModuleAdRevenueProcessorsHolder getAdRevenueProcessorsHolder() {
        return this.f798a;
    }
}
