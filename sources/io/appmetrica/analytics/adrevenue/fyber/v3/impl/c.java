package io.appmetrica.analytics.adrevenue.fyber.v3.impl;

import com.fyber.fairbid.ads.ImpressionData;
import com.fyber.fairbid.ads.PlacementType;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueConstants;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenue;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdType;
import io.appmetrica.analytics.modulesapi.internal.common.InternalClientModuleFacade;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class c implements ModuleAdRevenueProcessor {

    /* renamed from: a  reason: collision with root package name */
    public final b f214a;
    public final ClientContext b;

    public c(b bVar, ClientContext clientContext) {
        this.f214a = bVar;
        this.b = clientContext;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor
    public final String getDescription() {
        return "Fyber";
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor
    public final boolean process(Object... objArr) {
        ModuleAdType moduleAdType;
        if (ReflectionUtils.isArgumentsOfClasses(objArr, ImpressionData.class)) {
            ImpressionData impressionData = (ImpressionData) objArr[0];
            InternalClientModuleFacade internalClientModuleFacade = this.b.getInternalClientModuleFacade();
            this.f214a.getClass();
            PlacementType placementType = impressionData.getPlacementType();
            BigDecimal valueOf = BigDecimal.valueOf(WrapUtils.getFiniteDoubleOrDefault(impressionData.getNetPayout(), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
            Currency currency = Currency.getInstance(impressionData.getCurrency());
            if (placementType == null) {
                moduleAdType = null;
            } else {
                int i = a.f213a[placementType.ordinal()];
                if (i == 1) {
                    moduleAdType = ModuleAdType.BANNER;
                } else if (i == 2) {
                    moduleAdType = ModuleAdType.REWARDED;
                } else if (i != 3) {
                    moduleAdType = ModuleAdType.OTHER;
                } else {
                    moduleAdType = ModuleAdType.INTERSTITIAL;
                }
            }
            String demandSource = impressionData.getDemandSource();
            String creativeId = impressionData.getCreativeId();
            String obj = impressionData.getPriceAccuracy().toString();
            HashMap hashMap = new HashMap();
            hashMap.put("source", "fyber");
            hashMap.put(AdRevenueConstants.ORIGINAL_SOURCE_KEY, "ad-revenue-fyber-v3");
            hashMap.put(AdRevenueConstants.ORIGINAL_AD_TYPE_KEY, placementType == null ? AbstractJsonLexerKt.NULL : placementType.name());
            internalClientModuleFacade.reportAdRevenue(new ModuleAdRevenue(valueOf, currency, moduleAdType, demandSource, creativeId, null, null, null, obj, hashMap, false));
            LoggerStorage.getMainPublicOrAnonymousLogger().info("Ad Revenue from Fyber was reported", new Object[0]);
            return true;
        }
        return false;
    }
}
