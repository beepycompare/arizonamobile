package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* loaded from: classes5.dex */
public final class Vj extends X4 {
    public Vj(Context context, C0257fm c0257fm, Q4 q4, C0468o4 c0468o4, InterfaceC0304hh interfaceC0304hh, V4 v4, P4 p4) {
        this(context, q4, new C0364k0(), new TimePassedChecker(), new C0163c5(context, q4, c0468o4, v4, c0257fm, interfaceC0304hh, C0449na.k().w().c(), PackageManagerUtils.getAppVersionCodeInt(context), C0449na.k().l(), p4), c0468o4);
    }

    @Override // io.appmetrica.analytics.impl.X4, io.appmetrica.analytics.impl.Ea
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.SELF_SDK;
    }

    public Vj(Context context, Q4 q4, C0364k0 c0364k0, TimePassedChecker timePassedChecker, C0163c5 c0163c5, C0468o4 c0468o4) {
        super(context, q4, c0364k0, timePassedChecker, c0163c5, c0468o4);
    }
}
