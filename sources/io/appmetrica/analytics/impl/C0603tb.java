package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
import io.appmetrica.analytics.AdType;
import io.appmetrica.analytics.ModuleEvent;
import io.appmetrica.analytics.ModulesFacade;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueConstants;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenue;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdType;
import io.appmetrica.analytics.modulesapi.internal.common.InternalClientModuleFacade;
import io.appmetrica.analytics.modulesapi.internal.common.InternalModuleEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
/* renamed from: io.appmetrica.analytics.impl.tb  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0603tb implements InternalClientModuleFacade {

    /* renamed from: a  reason: collision with root package name */
    public final C0307hd f1058a = new C0307hd();

    @Override // io.appmetrica.analytics.modulesapi.internal.common.InternalClientModuleFacade
    public final void reportAdRevenue(ModuleAdRevenue moduleAdRevenue) {
        AdType adType;
        Map<String, String> linkedHashMap;
        C0307hd c0307hd = this.f1058a;
        c0307hd.getClass();
        AdRevenue.Builder newBuilder = AdRevenue.newBuilder(moduleAdRevenue.getAdRevenue(), moduleAdRevenue.getCurrency());
        ModuleAdType adType2 = moduleAdRevenue.getAdType();
        ModuleAdType.values();
        switch (adType2 == null ? -1 : AbstractC0282gd.f853a[adType2.ordinal()]) {
            case -1:
                adType = null;
                break;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                adType = AdType.NATIVE;
                break;
            case 2:
                adType = AdType.BANNER;
                break;
            case 3:
                adType = AdType.REWARDED;
                break;
            case 4:
                adType = AdType.INTERSTITIAL;
                break;
            case 5:
                adType = AdType.MREC;
                break;
            case 6:
                adType = AdType.APP_OPEN;
                break;
            case 7:
                adType = AdType.OTHER;
                break;
        }
        AdRevenue.Builder withPrecision = newBuilder.withAdType(adType).withAdNetwork(moduleAdRevenue.getAdNetwork()).withAdUnitId(moduleAdRevenue.getAdUnitId()).withAdUnitName(moduleAdRevenue.getAdUnitName()).withAdPlacementId(moduleAdRevenue.getAdPlacementId()).withAdPlacementName(moduleAdRevenue.getAdPlacementName()).withPrecision(moduleAdRevenue.getPrecision());
        Map<String, String> payload = moduleAdRevenue.getPayload();
        if (payload == null || (linkedHashMap = MapsKt.toMutableMap(payload)) == null) {
            linkedHashMap = new LinkedHashMap<>();
        }
        c0307hd.f867a.getClass();
        linkedHashMap.put(AdRevenueConstants.LAYER_KEY, "native");
        ModulesFacade.reportAdRevenue(withPrecision.withPayload(linkedHashMap).build(), Boolean.valueOf(moduleAdRevenue.getAutoCollected()));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.InternalClientModuleFacade
    public final void reportEvent(InternalModuleEvent internalModuleEvent) {
        ModuleEvent.Category category;
        ModuleEvent.Builder withValue = ModuleEvent.newBuilder(internalModuleEvent.getType()).withName(internalModuleEvent.getName()).withValue(internalModuleEvent.getValue());
        Integer serviceDataReporterType = internalModuleEvent.getServiceDataReporterType();
        if (serviceDataReporterType != null) {
            withValue.withServiceDataReporterType(serviceDataReporterType.intValue());
        }
        InternalModuleEvent.Category category2 = internalModuleEvent.getCategory();
        if (category2 != null) {
            int i = AbstractC0578sb.f1043a[category2.ordinal()];
            if (i != 1) {
                category = i != 2 ? null : ModuleEvent.Category.GENERAL;
            } else {
                category = ModuleEvent.Category.SYSTEM;
            }
            if (category != null) {
                withValue.withCategory(category);
            }
        }
        ModulesFacade.reportEvent(withValue.withExtras(internalModuleEvent.getExtras()).withAttributes(internalModuleEvent.getAttributes()).withEnvironment(internalModuleEvent.getEnvironment()).build());
    }
}
