package io.appmetrica.analytics.adrevenue.admob.v23.impl;

import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.rewarded.RewardedAd;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdType;
/* loaded from: classes4.dex */
public final class h extends e {
    public h(b bVar, ClientContext clientContext) {
        super(bVar, clientContext);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor
    public final boolean process(Object... objArr) {
        if (ReflectionUtils.isArgumentsOfClasses(objArr, AdValue.class, RewardedAd.class)) {
            RewardedAd rewardedAd = (RewardedAd) objArr[1];
            this.f209a.getClass();
            a(b.a((AdValue) objArr[0], ModuleAdType.REWARDED, "rewardedAd", rewardedAd.getResponseInfo(), rewardedAd.getAdUnitId()));
            return true;
        }
        return false;
    }
}
