package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdTrackingInfo;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdTrackingInfoResult;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
/* loaded from: classes5.dex */
public final class K implements H {

    /* renamed from: a  reason: collision with root package name */
    public final H f623a;

    public K(H h) {
        this.f623a = h;
    }

    @Override // io.appmetrica.analytics.impl.H
    public final AdTrackingInfoResult a(Context context) {
        return a(new I(this, context));
    }

    @Override // io.appmetrica.analytics.impl.H
    public final AdTrackingInfoResult a(Context context, InterfaceC0151bj interfaceC0151bj) {
        return a(new J(this, context, interfaceC0151bj));
    }

    public static AdTrackingInfoResult a(Provider provider) {
        AdTrackingInfoResult adTrackingInfoResult = (AdTrackingInfoResult) provider.get();
        AdTrackingInfo adTrackingInfo = adTrackingInfoResult.mAdTrackingInfo;
        return (adTrackingInfo == null || !"00000000-0000-0000-0000-000000000000".equals(adTrackingInfo.advId)) ? adTrackingInfoResult : new AdTrackingInfoResult(null, IdentifierStatus.INVALID_ADV_ID, "AdvId is invalid: 00000000-0000-0000-0000-000000000000");
    }
}
