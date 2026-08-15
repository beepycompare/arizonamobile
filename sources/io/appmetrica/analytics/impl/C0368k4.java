package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsHolder;
import io.appmetrica.analytics.internal.IdentifiersResult;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.k4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0368k4 {

    /* renamed from: a  reason: collision with root package name */
    public final C0181cn f1064a;
    public final W b;

    public C0368k4(C0181cn c0181cn, W w) {
        this.f1064a = c0181cn;
        this.b = w;
    }

    public final C0342j4 a(HashMap hashMap) {
        Hm e = this.f1064a.e();
        AdvertisingIdsHolder identifiers = this.b.getIdentifiers();
        return new C0342j4(C0342j4.a(e.d), C0342j4.a(e.f584a), C0342j4.a(e.b), C0342j4.a(e.j), C0342j4.a(e.i), C0342j4.a(Ib.a(AbstractC0310hn.a(e.k))), C0342j4.a(Ib.a(hashMap)), new IdentifiersResult(identifiers.getGoogle().mAdTrackingInfo == null ? null : identifiers.getGoogle().mAdTrackingInfo.advId, identifiers.getGoogle().mStatus, identifiers.getGoogle().mErrorExplanation), new IdentifiersResult(identifiers.getHuawei().mAdTrackingInfo == null ? null : identifiers.getHuawei().mAdTrackingInfo.advId, identifiers.getHuawei().mStatus, identifiers.getHuawei().mErrorExplanation), new IdentifiersResult(identifiers.getYandex().mAdTrackingInfo != null ? identifiers.getYandex().mAdTrackingInfo.advId : null, identifiers.getYandex().mStatus, identifiers.getYandex().mErrorExplanation), C0342j4.a(Ib.a(e.h)), AbstractC0414lo.a(), e.o + e.z.f971a, C0342j4.a(e.n.f), new Bundle());
    }
}
