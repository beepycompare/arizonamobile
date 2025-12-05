package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* loaded from: classes5.dex */
public final class Wj extends Y4 {
    public Wj(Context context, C0278gm c0278gm, R4 r4, C0489p4 c0489p4, InterfaceC0324ih interfaceC0324ih, W4 w4, Q4 q4) {
        this(context, r4, new C0359k0(), new TimePassedChecker(), new C0184d5(context, r4, c0489p4, w4, c0278gm, interfaceC0324ih, C0470oa.k().w().c(), PackageManagerUtils.getAppVersionCodeInt(context), C0470oa.k().l(), q4), c0489p4);
    }

    @Override // io.appmetrica.analytics.impl.Y4, io.appmetrica.analytics.impl.Fa
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.SELF_SDK;
    }

    public Wj(Context context, R4 r4, C0359k0 c0359k0, TimePassedChecker timePassedChecker, C0184d5 c0184d5, C0489p4 c0489p4) {
        super(context, r4, c0359k0, timePassedChecker, c0184d5, c0489p4);
    }
}
