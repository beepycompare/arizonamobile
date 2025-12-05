package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
/* renamed from: io.appmetrica.analytics.impl.zc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0746zc extends J2 {
    public C0746zc(Context context, Cf cf, ReporterConfig reporterConfig, C0702xi c0702xi, N9 n9) {
        this(context, c0702xi, new Gh(cf, new CounterConfiguration(reporterConfig), new E8(new C0580sl(LoggerStorage.getOrCreatePublicLogger(reporterConfig.apiKey), "Crash Environment")), reporterConfig.userProfileID), n9, C0157c4.l().n(), new Sn(), new Fg(), new C0665w6(), new C0179d0(), new Ke(n9));
    }

    @Override // io.appmetrica.analytics.impl.J2
    public final String j() {
        return "[ManualReporter]";
    }

    public C0746zc(Context context, C0702xi c0702xi, Gh gh, N9 n9, C0565s6 c0565s6, Sn sn, Fg fg, C0665w6 c0665w6, C0179d0 c0179d0, Ke ke) {
        super(context, c0702xi, gh, n9, c0565s6, sn, fg, c0665w6, c0179d0, ke);
        C0157c4.l().getClass();
    }
}
