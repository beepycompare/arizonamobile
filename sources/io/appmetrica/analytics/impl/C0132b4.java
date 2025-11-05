package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsHolder;
import io.appmetrica.analytics.internal.IdentifiersResult;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.b4  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0132b4 {

    /* renamed from: a  reason: collision with root package name */
    public final Em f812a;
    public final U b;

    public C0132b4(Em em, U u) {
        this.f812a = em;
        this.b = u;
    }

    public final C0106a4 a(HashMap hashMap) {
        AdvertisingIdsHolder a2;
        C0356jm e = this.f812a.e();
        U u = this.b;
        synchronized (u) {
            a2 = u.a(new C0219ee());
        }
        return new C0106a4(C0106a4.a(e.d), C0106a4.a(e.f959a), C0106a4.a(e.b), C0106a4.a(e.j), C0106a4.a(e.i), C0106a4.a(AbstractC0447nb.a(Jm.a(e.k))), C0106a4.a(AbstractC0447nb.a(hashMap)), new IdentifiersResult(a2.getGoogle().mAdTrackingInfo == null ? null : a2.getGoogle().mAdTrackingInfo.advId, a2.getGoogle().mStatus, a2.getGoogle().mErrorExplanation), new IdentifiersResult(a2.getHuawei().mAdTrackingInfo == null ? null : a2.getHuawei().mAdTrackingInfo.advId, a2.getHuawei().mStatus, a2.getHuawei().mErrorExplanation), new IdentifiersResult(a2.getYandex().mAdTrackingInfo == null ? null : a2.getYandex().mAdTrackingInfo.advId, a2.getYandex().mStatus, a2.getYandex().mErrorExplanation), C0106a4.a(AbstractC0447nb.a(e.h)), Kn.a(), e.o + e.z.f496a, C0106a4.a(e.n.f), new Bundle());
    }
}
