package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.ok  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0491ok extends C0651v5 {
    public C0491ok(Context context, C0493om c0493om, C0476o5 c0476o5, M4 m4, Dh dh, AbstractC0601t5 abstractC0601t5, C0450n5 c0450n5) {
        this(context, c0476o5, new C0341j0(), new TimePassedChecker(), new A5(context, c0476o5, m4, abstractC0601t5, c0493om, dh, Na.j().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Na.j().k(), c0450n5), m4);
    }

    @Override // io.appmetrica.analytics.impl.C0651v5, io.appmetrica.analytics.impl.InterfaceC0223eb
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.SELF_SDK;
    }

    public C0491ok(Context context, C0476o5 c0476o5, C0341j0 c0341j0, TimePassedChecker timePassedChecker, A5 a5, M4 m4) {
        super(context, c0476o5, c0341j0, timePassedChecker, a5, m4);
    }
}
