package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
/* loaded from: classes5.dex */
public final class Zc extends V2 {
    public Zc(Context context, C0174cg c0174cg, ReporterConfig reporterConfig, Qi qi, C0297ha c0297ha) {
        this(context, qi, new Zh(c0174cg, new CounterConfiguration(reporterConfig), new W8(new Wl(LoggerStorage.getOrCreatePublicLogger(reporterConfig.apiKey), "Crash Environment")), reporterConfig.userProfileID), c0297ha, C0575s4.l().n(), new C0647uo(), new Ug(), new N6(), new C0235f0(), new C0379kf(c0297ha));
    }

    @Override // io.appmetrica.analytics.impl.V2
    public final String j() {
        return "[ManualReporter]";
    }

    public Zc(Context context, Qi qi, Zh zh, C0297ha c0297ha, J6 j6, C0647uo c0647uo, Ug ug, N6 n6, C0235f0 c0235f0, C0379kf c0379kf) {
        super(context, qi, zh, c0297ha, j6, c0647uo, ug, n6, c0235f0, c0379kf);
        C0575s4.l().getClass();
    }
}
