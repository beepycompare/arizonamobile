package io.appmetrica.analytics.adrevenue.ironsource.v9.impl;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.unity3d.mediation.impression.LevelPlayImpressionData;
import com.unity3d.mediation.impression.LevelPlayImpressionDataListener;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenue;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdType;
import io.appmetrica.analytics.modulesapi.internal.common.InternalClientModuleFacade;
import java.math.BigDecimal;
import java.util.Currency;
/* loaded from: classes3.dex */
public final class c implements LevelPlayImpressionDataListener {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f300a;
    public final b b = new b();

    public c(ClientContext clientContext) {
        this.f300a = clientContext;
    }

    public final void onImpressionSuccess(LevelPlayImpressionData levelPlayImpressionData) {
        ModuleAdType moduleAdType;
        if (levelPlayImpressionData != null) {
            InternalClientModuleFacade internalClientModuleFacade = this.f300a.getInternalClientModuleFacade();
            this.b.getClass();
            String adFormat = levelPlayImpressionData.getAdFormat();
            BigDecimal valueOf = BigDecimal.valueOf(WrapUtils.getFiniteDoubleOrDefaultNullable(levelPlayImpressionData.getRevenue(), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
            Currency currency = Currency.getInstance("USD");
            if (adFormat != null) {
                adFormat.hashCode();
                char c = 65535;
                switch (adFormat.hashCode()) {
                    case -1396342996:
                        if (adFormat.equals("banner")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1364000502:
                        if (adFormat.equals("rewarded_video")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 604727084:
                        if (adFormat.equals("interstitial")) {
                            c = 2;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        moduleAdType = ModuleAdType.BANNER;
                        break;
                    case 1:
                        moduleAdType = ModuleAdType.REWARDED;
                        break;
                    case 2:
                        moduleAdType = ModuleAdType.INTERSTITIAL;
                        break;
                    default:
                        moduleAdType = ModuleAdType.OTHER;
                        break;
                }
            } else {
                moduleAdType = null;
            }
            internalClientModuleFacade.reportAdRevenue(new ModuleAdRevenue(valueOf, currency, moduleAdType, levelPlayImpressionData.getAdNetwork(), levelPlayImpressionData.getMediationAdUnitId(), levelPlayImpressionData.getMediationAdUnitName(), null, levelPlayImpressionData.getPlacement(), levelPlayImpressionData.getPrecision(), new a(adFormat), true));
        }
    }
}
