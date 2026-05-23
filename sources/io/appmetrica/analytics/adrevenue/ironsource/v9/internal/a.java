package io.appmetrica.analytics.adrevenue.ironsource.v9.internal;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueCollector;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public final class a implements AdRevenueCollector {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IronSourceV9ClientModuleEntryPoint f234a;

    public a(IronSourceV9ClientModuleEntryPoint ironSourceV9ClientModuleEntryPoint) {
        this.f234a = ironSourceV9ClientModuleEntryPoint;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueCollector
    public final boolean getEnabled() {
        AtomicBoolean atomicBoolean;
        atomicBoolean = this.f234a.b;
        return atomicBoolean.get();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueCollector
    public final String getSourceIdentifier() {
        return "ironsource";
    }
}
