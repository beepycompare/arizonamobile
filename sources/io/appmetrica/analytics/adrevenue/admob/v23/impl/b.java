package io.appmetrica.analytics.adrevenue.admob.v23.impl;

import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.AdapterResponseInfo;
import com.google.android.gms.ads.ResponseInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueConstants;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenue;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdType;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class b {
    public static ModuleAdRevenue a(AdValue adValue, ModuleAdType moduleAdType, String str, ResponseInfo responseInfo, String str2) {
        AdapterResponseInfo loadedAdapterResponseInfo;
        double finiteDoubleOrDefault = WrapUtils.getFiniteDoubleOrDefault(adValue.getValueMicros() / 1000000.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        String str3 = "PRECISE";
        if (responseInfo != null && (loadedAdapterResponseInfo = responseInfo.getLoadedAdapterResponseInfo()) != null) {
            BigDecimal valueOf = BigDecimal.valueOf(finiteDoubleOrDefault);
            Currency currency = Currency.getInstance(adValue.getCurrencyCode());
            String adapterClassName = loadedAdapterResponseInfo.getAdapterClassName();
            String adSourceInstanceId = loadedAdapterResponseInfo.getAdSourceInstanceId();
            String adSourceInstanceName = loadedAdapterResponseInfo.getAdSourceInstanceName();
            int precisionType = adValue.getPrecisionType();
            String str4 = precisionType == 0 ? "UNKNOWN" : precisionType == 1 ? "ESTIMATED" : precisionType == 2 ? "PUBLISHER_PROVIDED" : precisionType == 3 ? "PRECISE" : "";
            HashMap hashMap = new HashMap();
            hashMap.put(AdRevenueConstants.ORIGINAL_AD_TYPE_KEY, str);
            hashMap.put(AdRevenueConstants.ORIGINAL_SOURCE_KEY, "ad-revenue-admob-v23");
            hashMap.put("source", "admob");
            return new ModuleAdRevenue(valueOf, currency, moduleAdType, adapterClassName, str2, null, adSourceInstanceId, adSourceInstanceName, str4, hashMap, false);
        }
        BigDecimal valueOf2 = BigDecimal.valueOf(finiteDoubleOrDefault);
        Currency currency2 = Currency.getInstance(adValue.getCurrencyCode());
        int precisionType2 = adValue.getPrecisionType();
        if (precisionType2 == 0) {
            str3 = "UNKNOWN";
        } else if (precisionType2 == 1) {
            str3 = "ESTIMATED";
        } else if (precisionType2 == 2) {
            str3 = "PUBLISHER_PROVIDED";
        } else if (precisionType2 != 3) {
            str3 = "";
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put(AdRevenueConstants.ORIGINAL_AD_TYPE_KEY, str);
        hashMap2.put(AdRevenueConstants.ORIGINAL_SOURCE_KEY, "ad-revenue-admob-v23");
        hashMap2.put("source", "admob");
        return new ModuleAdRevenue(valueOf2, currency2, moduleAdType, null, str2, null, null, null, str3, hashMap2, false);
    }
}
