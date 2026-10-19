package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.vk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0663vk extends C0441n5 {
    public C0663vk(Context context, Hm hm, C0260g5 c0260g5, F4 f4, Bh bh, AbstractC0389l5 abstractC0389l5, C0234f5 c0234f5) {
        this(context, c0260g5, new C0410m0(), new TimePassedChecker(), new C0570s5(context, c0260g5, f4, abstractC0389l5, hm, bh, Na.k().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Na.k().l(), c0234f5), f4);
    }

    @Override // io.appmetrica.analytics.impl.C0441n5, io.appmetrica.analytics.impl.InterfaceC0266gb
    public final CounterConfigurationReporterType b() {
        return CounterConfigurationReporterType.SELF_SDK;
    }

    public C0663vk(Context context, C0260g5 c0260g5, C0410m0 c0410m0, TimePassedChecker timePassedChecker, C0570s5 c0570s5, F4 f4) {
        super(context, c0260g5, c0410m0, timePassedChecker, c0570s5, f4);
    }
}
