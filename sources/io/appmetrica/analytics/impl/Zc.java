package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
/* loaded from: classes5.dex */
public final class Zc extends V2 {
    public Zc(Context context, C0168cg c0168cg, ReporterConfig reporterConfig, Qi qi, C0291ha c0291ha) {
        this(context, qi, new Zh(c0168cg, new CounterConfiguration(reporterConfig), new W8(new Wl(LoggerStorage.getOrCreatePublicLogger(reporterConfig.apiKey), "Crash Environment")), reporterConfig.userProfileID), c0291ha, C0569s4.l().n(), new C0641uo(), new Ug(), new N6(), new C0229f0(), new C0373kf(c0291ha));
    }

    @Override // io.appmetrica.analytics.impl.V2
    public final String j() {
        return "[ManualReporter]";
    }

    public Zc(Context context, Qi qi, Zh zh, C0291ha c0291ha, J6 j6, C0641uo c0641uo, Ug ug, N6 n6, C0229f0 c0229f0, C0373kf c0373kf) {
        super(context, qi, zh, c0291ha, j6, c0641uo, ug, n6, c0229f0, c0373kf);
        C0569s4.l().getClass();
    }
}
