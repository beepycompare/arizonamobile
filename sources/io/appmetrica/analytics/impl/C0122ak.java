package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.ak  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0122ak extends C0210e5 {
    public C0122ak(Context context, C0356jm c0356jm, X4 x4, C0639v4 c0639v4, InterfaceC0428mh interfaceC0428mh, AbstractC0159c5 abstractC0159c5, W4 w4) {
        this(context, x4, new C0360k0(), new TimePassedChecker(), new C0339j5(context, x4, c0639v4, abstractC0159c5, c0356jm, interfaceC0428mh, C0620ua.k().x().d(), PackageManagerUtils.getAppVersionCodeInt(context), C0620ua.k().l(), w4), c0639v4);
    }

    @Override // io.appmetrica.analytics.impl.C0210e5, io.appmetrica.analytics.impl.La
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.SELF_SDK;
    }

    public C0122ak(Context context, X4 x4, C0360k0 c0360k0, TimePassedChecker timePassedChecker, C0339j5 c0339j5, C0639v4 c0639v4) {
        super(context, x4, c0360k0, timePassedChecker, c0339j5, c0639v4);
    }
}
