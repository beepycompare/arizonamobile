package io.appmetrica.analytics.adrevenue.admob.v23.impl;

import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdType;
/* loaded from: classes4.dex */
public final class i extends e {
    public i(b bVar, ClientContext clientContext) {
        super(bVar, clientContext);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor
    public final boolean process(Object... objArr) {
        if (ReflectionUtils.isArgumentsOfClasses(objArr, AdValue.class, RewardedInterstitialAd.class)) {
            RewardedInterstitialAd rewardedInterstitialAd = (RewardedInterstitialAd) objArr[1];
            this.f210a.getClass();
            a(b.a((AdValue) objArr[0], ModuleAdType.OTHER, "rewardedInterstitialAd", rewardedInterstitialAd.getResponseInfo(), rewardedInterstitialAd.getAdUnitId()));
            return true;
        }
        return false;
    }
}
