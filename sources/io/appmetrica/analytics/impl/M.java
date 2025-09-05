package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdTrackingInfo;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdTrackingInfoResult;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
/* loaded from: classes4.dex */
public final class M implements J {

    /* renamed from: a  reason: collision with root package name */
    public final J f563a;

    public M(J j) {
        this.f563a = j;
    }

    @Override // io.appmetrica.analytics.impl.J
    public final AdTrackingInfoResult a(Context context) {
        return a(new K(this, context));
    }

    @Override // io.appmetrica.analytics.impl.J
    public final AdTrackingInfoResult a(Context context, InterfaceC0180cj interfaceC0180cj) {
        return a(new L(this, context, interfaceC0180cj));
    }

    public static AdTrackingInfoResult a(Provider provider) {
        AdTrackingInfoResult adTrackingInfoResult = (AdTrackingInfoResult) provider.get();
        AdTrackingInfo adTrackingInfo = adTrackingInfoResult.mAdTrackingInfo;
        return (adTrackingInfo == null || !"00000000-0000-0000-0000-000000000000".equals(adTrackingInfo.advId)) ? adTrackingInfoResult : new AdTrackingInfoResult(null, IdentifierStatus.INVALID_ADV_ID, "AdvId is invalid: 00000000-0000-0000-0000-000000000000");
    }
}
