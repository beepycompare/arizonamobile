package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.vk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0668vk extends C0446n5 {
    public C0668vk(Context context, Hm hm, C0265g5 c0265g5, F4 f4, Bh bh, AbstractC0394l5 abstractC0394l5, C0239f5 c0239f5) {
        this(context, c0265g5, new C0415m0(), new TimePassedChecker(), new C0575s5(context, c0265g5, f4, abstractC0394l5, hm, bh, Na.k().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Na.k().l(), c0239f5), f4);
    }

    @Override // io.appmetrica.analytics.impl.C0446n5, io.appmetrica.analytics.impl.InterfaceC0271gb
    public final CounterConfigurationReporterType b() {
        return CounterConfigurationReporterType.SELF_SDK;
    }

    public C0668vk(Context context, C0265g5 c0265g5, C0415m0 c0415m0, TimePassedChecker timePassedChecker, C0575s5 c0575s5, F4 f4) {
        super(context, c0265g5, c0415m0, timePassedChecker, c0575s5, f4);
    }
}
