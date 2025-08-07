package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.fk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0266fk extends C0575s5 {
    public C0266fk(Context context, C0268fm c0268fm, C0401l5 c0401l5, J4 j4, InterfaceC0637uh interfaceC0637uh, AbstractC0526q5 abstractC0526q5, C0376k5 c0376k5) {
        this(context, c0401l5, new C0322i0(), new TimePassedChecker(), new C0700x5(context, c0401l5, j4, abstractC0526q5, c0268fm, interfaceC0637uh, Ia.j().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Ia.j().k(), c0376k5), j4);
    }

    @Override // io.appmetrica.analytics.impl.C0575s5, io.appmetrica.analytics.impl.Za
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.SELF_SDK;
    }

    public C0266fk(Context context, C0401l5 c0401l5, C0322i0 c0322i0, TimePassedChecker timePassedChecker, C0700x5 c0700x5, J4 j4) {
        super(context, c0401l5, c0322i0, timePassedChecker, c0700x5, j4);
    }
}
