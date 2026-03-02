package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsHolder;
import io.appmetrica.analytics.internal.IdentifiersResult;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class T3 {

    /* renamed from: a  reason: collision with root package name */
    public final Am f792a;
    public final U b;

    public T3(Am am, U u) {
        this.f792a = am;
        this.b = u;
    }

    public final S3 a(HashMap hashMap) {
        AdvertisingIdsHolder a2;
        C0256fm e = this.f792a.e();
        U u = this.b;
        synchronized (u) {
            a2 = u.a(new Xd());
        }
        return new S3(S3.a(e.d), S3.a(e.f999a), S3.a(e.b), S3.a(e.j), S3.a(e.i), S3.a(AbstractC0271gb.a(Fm.a(e.k))), S3.a(AbstractC0271gb.a(hashMap)), new IdentifiersResult(a2.getGoogle().mAdTrackingInfo == null ? null : a2.getGoogle().mAdTrackingInfo.advId, a2.getGoogle().mStatus, a2.getGoogle().mErrorExplanation), new IdentifiersResult(a2.getHuawei().mAdTrackingInfo == null ? null : a2.getHuawei().mAdTrackingInfo.advId, a2.getHuawei().mStatus, a2.getHuawei().mErrorExplanation), new IdentifiersResult(a2.getYandex().mAdTrackingInfo == null ? null : a2.getYandex().mAdTrackingInfo.advId, a2.getYandex().mStatus, a2.getYandex().mErrorExplanation), S3.a(AbstractC0271gb.a(e.h)), In.a(), e.o + e.z.f539a, S3.a(e.n.f), new Bundle());
    }
}
