package io.appmetrica.analytics.adrevenue.ironsource.v7.impl;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenue;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdType;
import io.appmetrica.analytics.modulesapi.internal.common.InternalClientModuleFacade;
import java.math.BigDecimal;
import java.util.Currency;
/* loaded from: classes4.dex */
public final class c implements ImpressionDataListener {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f214a;
    public final b b = new b();

    public c(ClientContext clientContext) {
        this.f214a = clientContext;
    }

    public final void onImpressionSuccess(ImpressionData impressionData) {
        ModuleAdType moduleAdType;
        if (impressionData != null) {
            InternalClientModuleFacade internalClientModuleFacade = this.f214a.getInternalClientModuleFacade();
            this.b.getClass();
            String adUnit = impressionData.getAdUnit();
            BigDecimal valueOf = BigDecimal.valueOf(WrapUtils.getFiniteDoubleOrDefault(impressionData.getRevenue().doubleValue(), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
            Currency currency = Currency.getInstance("USD");
            if (adUnit != null) {
                adUnit.hashCode();
                char c = 65535;
                switch (adUnit.hashCode()) {
                    case 95784425:
                        if (adUnit.equals("Rewarded Video")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 769047372:
                        if (adUnit.equals("Interstitial")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 1982491468:
                        if (adUnit.equals("Banner")) {
                            c = 2;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        moduleAdType = ModuleAdType.REWARDED;
                        break;
                    case 1:
                        moduleAdType = ModuleAdType.INTERSTITIAL;
                        break;
                    case 2:
                        moduleAdType = ModuleAdType.BANNER;
                        break;
                    default:
                        moduleAdType = ModuleAdType.OTHER;
                        break;
                }
            } else {
                moduleAdType = null;
            }
            internalClientModuleFacade.reportAdRevenue(new ModuleAdRevenue(valueOf, currency, moduleAdType, impressionData.getAdNetwork(), null, null, null, impressionData.getPlacement(), impressionData.getPrecision(), new a(adUnit), true));
        }
    }
}
