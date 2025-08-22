package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.kk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0387kk extends C0572s5 {
    public C0387kk(Context context, C0389km c0389km, C0398l5 c0398l5, J4 j4, InterfaceC0759zh interfaceC0759zh, AbstractC0523q5 abstractC0523q5, C0372k5 c0372k5) {
        this(context, c0398l5, new C0316i0(), new TimePassedChecker(), new C0697x5(context, c0398l5, j4, abstractC0523q5, c0389km, interfaceC0759zh, Ka.j().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Ka.j().k(), c0372k5), j4);
    }

    @Override // io.appmetrica.analytics.impl.C0572s5, io.appmetrica.analytics.impl.InterfaceC0146bb
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.SELF_SDK;
    }

    public C0387kk(Context context, C0398l5 c0398l5, C0316i0 c0316i0, TimePassedChecker timePassedChecker, C0697x5 c0697x5, J4 j4) {
        super(context, c0398l5, c0316i0, timePassedChecker, c0697x5, j4);
    }
}
