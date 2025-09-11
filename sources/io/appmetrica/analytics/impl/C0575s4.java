package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsHolder;
import io.appmetrica.analytics.internal.IdentifiersResult;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.s4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0575s4 {

    /* renamed from: a  reason: collision with root package name */
    public final Km f1077a;
    public final T b;

    public C0575s4(Km km, T t) {
        this.f1077a = km;
        this.b = t;
    }

    public final C0550r4 a(HashMap hashMap) {
        AdvertisingIdsHolder a2;
        C0493om e = this.f1077a.e();
        T t = this.b;
        synchronized (t) {
            a2 = t.a(new C0585se());
        }
        return new C0550r4(C0550r4.a(e.d), C0550r4.a(e.f1024a), C0550r4.a(e.b), C0550r4.a(e.j), C0550r4.a(e.i), C0550r4.a(Gb.a(Pm.a(e.k))), C0550r4.a(Gb.a(hashMap)), new IdentifiersResult(a2.getGoogle().mAdTrackingInfo == null ? null : a2.getGoogle().mAdTrackingInfo.advId, a2.getGoogle().mStatus, a2.getGoogle().mErrorExplanation), new IdentifiersResult(a2.getHuawei().mAdTrackingInfo == null ? null : a2.getHuawei().mAdTrackingInfo.advId, a2.getHuawei().mStatus, a2.getHuawei().mErrorExplanation), new IdentifiersResult(a2.getYandex().mAdTrackingInfo == null ? null : a2.getYandex().mAdTrackingInfo.advId, a2.getYandex().mStatus, a2.getYandex().mErrorExplanation), C0550r4.a(Gb.a(e.h)), On.a(), e.o + e.A.f582a, C0550r4.a(e.n.f), new Bundle());
    }
}
