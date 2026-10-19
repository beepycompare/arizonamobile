package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsHolder;
import io.appmetrica.analytics.internal.IdentifiersResult;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.k4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0362k4 {

    /* renamed from: a  reason: collision with root package name */
    public final C0175cn f1067a;
    public final W b;

    public C0362k4(C0175cn c0175cn, W w) {
        this.f1067a = c0175cn;
        this.b = w;
    }

    public final C0336j4 a(HashMap hashMap) {
        Hm e = this.f1067a.e();
        AdvertisingIdsHolder identifiers = this.b.getIdentifiers();
        return new C0336j4(C0336j4.a(e.d), C0336j4.a(e.f587a), C0336j4.a(e.b), C0336j4.a(e.j), C0336j4.a(e.i), C0336j4.a(Ib.a(AbstractC0304hn.a(e.k))), C0336j4.a(Ib.a(hashMap)), new IdentifiersResult(identifiers.getGoogle().mAdTrackingInfo == null ? null : identifiers.getGoogle().mAdTrackingInfo.advId, identifiers.getGoogle().mStatus, identifiers.getGoogle().mErrorExplanation), new IdentifiersResult(identifiers.getHuawei().mAdTrackingInfo == null ? null : identifiers.getHuawei().mAdTrackingInfo.advId, identifiers.getHuawei().mStatus, identifiers.getHuawei().mErrorExplanation), new IdentifiersResult(identifiers.getYandex().mAdTrackingInfo != null ? identifiers.getYandex().mAdTrackingInfo.advId : null, identifiers.getYandex().mStatus, identifiers.getYandex().mErrorExplanation), C0336j4.a(Ib.a(e.h)), AbstractC0408lo.a(), e.o + e.z.f974a, C0336j4.a(e.n.f), new Bundle());
    }
}
