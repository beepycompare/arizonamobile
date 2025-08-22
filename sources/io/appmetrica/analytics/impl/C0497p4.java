package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsHolder;
import io.appmetrica.analytics.internal.IdentifiersResult;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.p4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0497p4 {

    /* renamed from: a  reason: collision with root package name */
    public final Gm f1007a;
    public final T b;

    public C0497p4(Gm gm, T t) {
        this.f1007a = gm;
        this.b = t;
    }

    public final C0472o4 a(HashMap hashMap) {
        AdvertisingIdsHolder a2;
        C0389km e = this.f1007a.e();
        T t = this.b;
        synchronized (t) {
            a2 = t.a(new C0482oe());
        }
        return new C0472o4(C0472o4.a(e.d), C0472o4.a(e.f942a), C0472o4.a(e.b), C0472o4.a(e.j), C0472o4.a(e.i), C0472o4.a(Db.a(Lm.a(e.k))), C0472o4.a(Db.a(hashMap)), new IdentifiersResult(a2.getGoogle().mAdTrackingInfo == null ? null : a2.getGoogle().mAdTrackingInfo.advId, a2.getGoogle().mStatus, a2.getGoogle().mErrorExplanation), new IdentifiersResult(a2.getHuawei().mAdTrackingInfo == null ? null : a2.getHuawei().mAdTrackingInfo.advId, a2.getHuawei().mStatus, a2.getHuawei().mErrorExplanation), new IdentifiersResult(a2.getYandex().mAdTrackingInfo == null ? null : a2.getYandex().mAdTrackingInfo.advId, a2.getYandex().mStatus, a2.getYandex().mErrorExplanation), C0472o4.a(Db.a(e.h)), Kn.a(), e.o + e.A.f502a, C0472o4.a(e.n.f), new Bundle());
    }
}
