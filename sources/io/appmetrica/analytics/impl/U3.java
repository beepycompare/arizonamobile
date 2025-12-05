package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsHolder;
import io.appmetrica.analytics.internal.IdentifiersResult;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class U3 {

    /* renamed from: a  reason: collision with root package name */
    public final Bm f787a;
    public final U b;

    public U3(Bm bm, U u) {
        this.f787a = bm;
        this.b = u;
    }

    public final T3 a(HashMap hashMap) {
        AdvertisingIdsHolder a2;
        C0278gm e = this.f787a.e();
        U u = this.b;
        synchronized (u) {
            a2 = u.a(new Yd());
        }
        return new T3(T3.a(e.d), T3.a(e.f994a), T3.a(e.b), T3.a(e.j), T3.a(e.i), T3.a(AbstractC0293hb.a(Gm.a(e.k))), T3.a(AbstractC0293hb.a(hashMap)), new IdentifiersResult(a2.getGoogle().mAdTrackingInfo == null ? null : a2.getGoogle().mAdTrackingInfo.advId, a2.getGoogle().mStatus, a2.getGoogle().mErrorExplanation), new IdentifiersResult(a2.getHuawei().mAdTrackingInfo == null ? null : a2.getHuawei().mAdTrackingInfo.advId, a2.getHuawei().mStatus, a2.getHuawei().mErrorExplanation), new IdentifiersResult(a2.getYandex().mAdTrackingInfo == null ? null : a2.getYandex().mAdTrackingInfo.advId, a2.getYandex().mStatus, a2.getYandex().mErrorExplanation), T3.a(AbstractC0293hb.a(e.h)), Jn.a(), e.o + e.z.f533a, T3.a(e.n.f), new Bundle());
    }
}
