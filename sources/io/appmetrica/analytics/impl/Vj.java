package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* loaded from: classes5.dex */
public final class Vj extends X4 {
    public Vj(Context context, C0256fm c0256fm, Q4 q4, C0467o4 c0467o4, InterfaceC0303hh interfaceC0303hh, V4 v4, P4 p4) {
        this(context, q4, new C0363k0(), new TimePassedChecker(), new C0162c5(context, q4, c0467o4, v4, c0256fm, interfaceC0303hh, C0448na.k().w().c(), PackageManagerUtils.getAppVersionCodeInt(context), C0448na.k().l(), p4), c0467o4);
    }

    @Override // io.appmetrica.analytics.impl.X4, io.appmetrica.analytics.impl.Ea
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.SELF_SDK;
    }

    public Vj(Context context, Q4 q4, C0363k0 c0363k0, TimePassedChecker timePassedChecker, C0162c5 c0162c5, C0467o4 c0467o4) {
        super(context, q4, c0363k0, timePassedChecker, c0162c5, c0467o4);
    }
}
