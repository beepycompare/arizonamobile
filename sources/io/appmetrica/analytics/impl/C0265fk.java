package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.fk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0265fk extends C0574s5 {
    public C0265fk(Context context, C0267fm c0267fm, C0400l5 c0400l5, J4 j4, InterfaceC0636uh interfaceC0636uh, AbstractC0525q5 abstractC0525q5, C0375k5 c0375k5) {
        this(context, c0400l5, new C0321i0(), new TimePassedChecker(), new C0699x5(context, c0400l5, j4, abstractC0525q5, c0267fm, interfaceC0636uh, Ia.j().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Ia.j().k(), c0375k5), j4);
    }

    @Override // io.appmetrica.analytics.impl.C0574s5, io.appmetrica.analytics.impl.Za
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.SELF_SDK;
    }

    public C0265fk(Context context, C0400l5 c0400l5, C0321i0 c0321i0, TimePassedChecker timePassedChecker, C0699x5 c0699x5, J4 j4) {
        super(context, c0400l5, c0321i0, timePassedChecker, c0699x5, j4);
    }
}
