package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsHolder;
import io.appmetrica.analytics.internal.IdentifiersResult;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.p4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0499p4 {

    /* renamed from: a  reason: collision with root package name */
    public final Bm f996a;
    public final T b;

    public C0499p4(Bm bm, T t) {
        this.f996a = bm;
        this.b = t;
    }

    public final C0474o4 a(HashMap hashMap) {
        AdvertisingIdsHolder a2;
        C0267fm e = this.f996a.e();
        T t = this.b;
        synchronized (t) {
            a2 = t.a(new C0434me());
        }
        return new C0474o4(C0474o4.a(e.d), C0474o4.a(e.f851a), C0474o4.a(e.b), C0474o4.a(e.j), C0474o4.a(e.i), C0474o4.a(Bb.a(Gm.a(e.k))), C0474o4.a(Bb.a(hashMap)), new IdentifiersResult(a2.getGoogle().mAdTrackingInfo == null ? null : a2.getGoogle().mAdTrackingInfo.advId, a2.getGoogle().mStatus, a2.getGoogle().mErrorExplanation), new IdentifiersResult(a2.getHuawei().mAdTrackingInfo == null ? null : a2.getHuawei().mAdTrackingInfo.advId, a2.getHuawei().mStatus, a2.getHuawei().mErrorExplanation), new IdentifiersResult(a2.getYandex().mAdTrackingInfo == null ? null : a2.getYandex().mAdTrackingInfo.advId, a2.getYandex().mStatus, a2.getYandex().mErrorExplanation), C0474o4.a(Bb.a(e.h)), Fn.a(), e.o + e.A.f402a, C0474o4.a(e.n.f), new Bundle());
    }
}
