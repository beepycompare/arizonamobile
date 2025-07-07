package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.ck  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0196ck extends C0580s5 {
    public C0196ck(Context context, C0198cm c0198cm, C0406l5 c0406l5, J4 j4, InterfaceC0592sh interfaceC0592sh, AbstractC0531q5 abstractC0531q5, C0381k5 c0381k5) {
        this(context, c0406l5, new C0327i0(), new TimePassedChecker(), new C0705x5(context, c0406l5, j4, abstractC0531q5, c0198cm, interfaceC0592sh, Ga.j().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Ga.j().k(), c0381k5), j4);
    }

    @Override // io.appmetrica.analytics.impl.C0580s5, io.appmetrica.analytics.impl.Xa
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.SELF_SDK;
    }

    public C0196ck(Context context, C0406l5 c0406l5, C0327i0 c0327i0, TimePassedChecker timePassedChecker, C0705x5 c0705x5, J4 j4) {
        super(context, c0406l5, c0327i0, timePassedChecker, c0705x5, j4);
    }
}
