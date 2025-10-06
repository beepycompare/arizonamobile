package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.ok  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0492ok extends C0652v5 {
    public C0492ok(Context context, C0494om c0494om, C0477o5 c0477o5, M4 m4, Dh dh, AbstractC0602t5 abstractC0602t5, C0451n5 c0451n5) {
        this(context, c0477o5, new C0342j0(), new TimePassedChecker(), new A5(context, c0477o5, m4, abstractC0602t5, c0494om, dh, Na.j().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Na.j().k(), c0451n5), m4);
    }

    @Override // io.appmetrica.analytics.impl.C0652v5, io.appmetrica.analytics.impl.InterfaceC0224eb
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.SELF_SDK;
    }

    public C0492ok(Context context, C0477o5 c0477o5, C0342j0 c0342j0, TimePassedChecker timePassedChecker, A5 a5, M4 m4) {
        super(context, c0477o5, c0342j0, timePassedChecker, a5, m4);
    }
}
