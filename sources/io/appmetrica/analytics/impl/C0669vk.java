package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.vk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0669vk extends C0447n5 {
    public C0669vk(Context context, Hm hm, C0266g5 c0266g5, F4 f4, Bh bh, AbstractC0395l5 abstractC0395l5, C0240f5 c0240f5) {
        this(context, c0266g5, new C0416m0(), new TimePassedChecker(), new C0576s5(context, c0266g5, f4, abstractC0395l5, hm, bh, Na.k().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Na.k().l(), c0240f5), f4);
    }

    @Override // io.appmetrica.analytics.impl.C0447n5, io.appmetrica.analytics.impl.InterfaceC0272gb
    public final CounterConfigurationReporterType b() {
        return CounterConfigurationReporterType.SELF_SDK;
    }

    public C0669vk(Context context, C0266g5 c0266g5, C0416m0 c0416m0, TimePassedChecker timePassedChecker, C0576s5 c0576s5, F4 f4) {
        super(context, c0266g5, c0416m0, timePassedChecker, c0576s5, f4);
    }
}
