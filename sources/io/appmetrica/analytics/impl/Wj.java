package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* loaded from: classes5.dex */
public final class Wj extends Y4 {
    public Wj(Context context, C0279gm c0279gm, R4 r4, C0490p4 c0490p4, InterfaceC0325ih interfaceC0325ih, W4 w4, Q4 q4) {
        this(context, r4, new C0360k0(), new TimePassedChecker(), new C0185d5(context, r4, c0490p4, w4, c0279gm, interfaceC0325ih, C0471oa.k().w().c(), PackageManagerUtils.getAppVersionCodeInt(context), C0471oa.k().l(), q4), c0490p4);
    }

    @Override // io.appmetrica.analytics.impl.Y4, io.appmetrica.analytics.impl.Fa
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.SELF_SDK;
    }

    public Wj(Context context, R4 r4, C0360k0 c0360k0, TimePassedChecker timePassedChecker, C0185d5 c0185d5, C0490p4 c0490p4) {
        super(context, r4, c0360k0, timePassedChecker, c0185d5, c0490p4);
    }
}
