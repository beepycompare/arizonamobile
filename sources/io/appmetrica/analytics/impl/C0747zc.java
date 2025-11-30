package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
/* renamed from: io.appmetrica.analytics.impl.zc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0747zc extends J2 {
    public C0747zc(Context context, Cf cf, ReporterConfig reporterConfig, C0703xi c0703xi, N9 n9) {
        this(context, c0703xi, new Gh(cf, new CounterConfiguration(reporterConfig), new E8(new C0581sl(LoggerStorage.getOrCreatePublicLogger(reporterConfig.apiKey), "Crash Environment")), reporterConfig.userProfileID), n9, C0158c4.l().n(), new Sn(), new Fg(), new C0666w6(), new C0180d0(), new Ke(n9));
    }

    @Override // io.appmetrica.analytics.impl.J2
    public final String j() {
        return "[ManualReporter]";
    }

    public C0747zc(Context context, C0703xi c0703xi, Gh gh, N9 n9, C0566s6 c0566s6, Sn sn, Fg fg, C0666w6 c0666w6, C0180d0 c0180d0, Ke ke) {
        super(context, c0703xi, gh, n9, c0566s6, sn, fg, c0666w6, c0180d0, ke);
        C0158c4.l().getClass();
    }
}
