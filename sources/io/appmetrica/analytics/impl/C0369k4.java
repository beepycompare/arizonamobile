package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsHolder;
import io.appmetrica.analytics.internal.IdentifiersResult;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.k4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0369k4 {

    /* renamed from: a  reason: collision with root package name */
    public final C0182cn f1064a;
    public final W b;

    public C0369k4(C0182cn c0182cn, W w) {
        this.f1064a = c0182cn;
        this.b = w;
    }

    public final C0343j4 a(HashMap hashMap) {
        Hm e = this.f1064a.e();
        AdvertisingIdsHolder identifiers = this.b.getIdentifiers();
        return new C0343j4(C0343j4.a(e.d), C0343j4.a(e.f584a), C0343j4.a(e.b), C0343j4.a(e.j), C0343j4.a(e.i), C0343j4.a(Ib.a(AbstractC0311hn.a(e.k))), C0343j4.a(Ib.a(hashMap)), new IdentifiersResult(identifiers.getGoogle().mAdTrackingInfo == null ? null : identifiers.getGoogle().mAdTrackingInfo.advId, identifiers.getGoogle().mStatus, identifiers.getGoogle().mErrorExplanation), new IdentifiersResult(identifiers.getHuawei().mAdTrackingInfo == null ? null : identifiers.getHuawei().mAdTrackingInfo.advId, identifiers.getHuawei().mStatus, identifiers.getHuawei().mErrorExplanation), new IdentifiersResult(identifiers.getYandex().mAdTrackingInfo != null ? identifiers.getYandex().mAdTrackingInfo.advId : null, identifiers.getYandex().mStatus, identifiers.getYandex().mErrorExplanation), C0343j4.a(Ib.a(e.h)), AbstractC0415lo.a(), e.o + e.z.f971a, C0343j4.a(e.n.f), new Bundle());
    }
}
