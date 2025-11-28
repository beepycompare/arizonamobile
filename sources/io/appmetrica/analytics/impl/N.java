package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdTrackingInfo;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdTrackingInfoResult;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
/* loaded from: classes5.dex */
public final class N implements K {

    /* renamed from: a  reason: collision with root package name */
    public final K f598a;

    public N(K k) {
        this.f598a = k;
    }

    @Override // io.appmetrica.analytics.impl.K
    public final AdTrackingInfoResult a(Context context) {
        return a(new L(this, context));
    }

    @Override // io.appmetrica.analytics.impl.K
    public final AdTrackingInfoResult a(Context context, Li li) {
        return a(new M(this, context, li));
    }

    public static AdTrackingInfoResult a(Provider provider) {
        AdTrackingInfoResult adTrackingInfoResult = (AdTrackingInfoResult) provider.get();
        AdTrackingInfo adTrackingInfo = adTrackingInfoResult.mAdTrackingInfo;
        return (adTrackingInfo == null || !"00000000-0000-0000-0000-000000000000".equals(adTrackingInfo.advId)) ? adTrackingInfoResult : new AdTrackingInfoResult(null, IdentifierStatus.INVALID_ADV_ID, "AdvId is invalid: 00000000-0000-0000-0000-000000000000");
    }
}
