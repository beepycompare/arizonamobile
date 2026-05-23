package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.vk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0670vk extends C0448n5 {
    public C0670vk(Context context, Hm hm, C0267g5 c0267g5, F4 f4, Bh bh, AbstractC0396l5 abstractC0396l5, C0241f5 c0241f5) {
        this(context, c0267g5, new C0417m0(), new TimePassedChecker(), new C0577s5(context, c0267g5, f4, abstractC0396l5, hm, bh, Na.k().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Na.k().l(), c0241f5), f4);
    }

    @Override // io.appmetrica.analytics.impl.C0448n5, io.appmetrica.analytics.impl.InterfaceC0273gb
    public final CounterConfigurationReporterType b() {
        return CounterConfigurationReporterType.SELF_SDK;
    }

    public C0670vk(Context context, C0267g5 c0267g5, C0417m0 c0417m0, TimePassedChecker timePassedChecker, C0577s5 c0577s5, F4 f4) {
        super(context, c0267g5, c0417m0, timePassedChecker, c0577s5, f4);
    }
}
