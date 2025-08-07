package io.appmetrica.analytics.adrevenue.applovin.v12.impl;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinSdk;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueConstants;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenue;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdType;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Currency;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class b implements ModuleAdRevenueProcessor {

    /* renamed from: a  reason: collision with root package name */
    public final a f211a;
    public final ClientContext b;

    public b(a aVar, ClientContext clientContext) {
        this.f211a = aVar;
        this.b = clientContext;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor
    public final String getDescription() {
        return "AppLovin";
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor
    public final boolean process(Object... objArr) {
        ModuleAdType moduleAdType;
        String str;
        if (ReflectionUtils.isArgumentsOfClasses(objArr, MaxAd.class, AppLovinSdk.class)) {
            Object orNull = ArraysKt.getOrNull(objArr, 0);
            if (orNull != null) {
                MaxAd maxAd = (MaxAd) orNull;
                Object orNull2 = ArraysKt.getOrNull(objArr, 1);
                if (orNull2 != null) {
                    AppLovinSdk appLovinSdk = (AppLovinSdk) orNull2;
                    this.f211a.getClass();
                    MaxAdFormat format = maxAd.getFormat();
                    if (format == null) {
                        moduleAdType = null;
                    } else if (Intrinsics.areEqual(format, MaxAdFormat.NATIVE)) {
                        moduleAdType = ModuleAdType.NATIVE;
                    } else if (Intrinsics.areEqual(format, MaxAdFormat.BANNER)) {
                        moduleAdType = ModuleAdType.BANNER;
                    } else if (Intrinsics.areEqual(format, MaxAdFormat.REWARDED)) {
                        moduleAdType = ModuleAdType.REWARDED;
                    } else if (Intrinsics.areEqual(format, MaxAdFormat.INTERSTITIAL)) {
                        moduleAdType = ModuleAdType.INTERSTITIAL;
                    } else {
                        moduleAdType = Intrinsics.areEqual(format, MaxAdFormat.MREC) ? ModuleAdType.MREC : ModuleAdType.OTHER;
                    }
                    ModuleAdType moduleAdType2 = moduleAdType;
                    Pair[] pairArr = new Pair[4];
                    pairArr[0] = TuplesKt.to(RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE, appLovinSdk.getConfiguration().getCountryCode());
                    pairArr[1] = TuplesKt.to(AdRevenueConstants.ORIGINAL_SOURCE_KEY, "ad-revenue-applovin-v12");
                    MaxAdFormat format2 = maxAd.getFormat();
                    if (format2 == null || (str = format2.getLabel()) == null) {
                        str = AbstractJsonLexerKt.NULL;
                    }
                    pairArr[2] = TuplesKt.to(AdRevenueConstants.ORIGINAL_AD_TYPE_KEY, str);
                    pairArr[3] = TuplesKt.to("source", "applovin");
                    this.b.getInternalClientModuleFacade().reportAdRevenue(new ModuleAdRevenue(BigDecimal.valueOf(WrapUtils.getFiniteDoubleOrDefault(maxAd.getRevenue(), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)), Currency.getInstance("USD"), moduleAdType2, maxAd.getNetworkName(), maxAd.getAdUnitId(), null, maxAd.getNetworkPlacement(), maxAd.getPlacement(), maxAd.getRevenuePrecision(), MapsKt.mapOf(pairArr), false, 32, null));
                    LoggerStorage.getMainPublicOrAnonymousLogger().info("Ad Revenue from AppLovin with values " + Arrays.toString(objArr) + " was reported", new Object[0]);
                    return true;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.applovin.sdk.AppLovinSdk");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.applovin.mediation.MaxAd");
        }
        return false;
    }
}
