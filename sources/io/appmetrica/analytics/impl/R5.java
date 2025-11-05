package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessorsHolder;
/* loaded from: classes3.dex */
public final class R5 implements Q5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0491p5 f660a;

    public R5(C0491p5 c0491p5) {
        this.f660a = c0491p5;
    }

    @Override // io.appmetrica.analytics.impl.Q5, io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueContext
    public final C0491p5 getAdRevenueProcessorsHolder() {
        return this.f660a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueContext
    public final ModuleAdRevenueProcessorsHolder getAdRevenueProcessorsHolder() {
        return this.f660a;
    }
}
