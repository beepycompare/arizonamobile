package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.ck  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0188ck extends C0572s5 {
    public C0188ck(Context context, C0190cm c0190cm, C0398l5 c0398l5, J4 j4, InterfaceC0584sh interfaceC0584sh, AbstractC0523q5 abstractC0523q5, C0373k5 c0373k5) {
        this(context, c0398l5, new C0319i0(), new TimePassedChecker(), new C0697x5(context, c0398l5, j4, abstractC0523q5, c0190cm, interfaceC0584sh, Ga.j().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Ga.j().k(), c0373k5), j4);
    }

    @Override // io.appmetrica.analytics.impl.C0572s5, io.appmetrica.analytics.impl.Xa
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.SELF_SDK;
    }

    public C0188ck(Context context, C0398l5 c0398l5, C0319i0 c0319i0, TimePassedChecker timePassedChecker, C0697x5 c0697x5, J4 j4) {
        super(context, c0398l5, c0319i0, timePassedChecker, c0697x5, j4);
    }
}
