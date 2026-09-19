package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
/* loaded from: classes5.dex */
public final class Zc extends V2 {
    public Zc(Context context, C0173cg c0173cg, ReporterConfig reporterConfig, Qi qi, C0296ha c0296ha) {
        this(context, qi, new Zh(c0173cg, new CounterConfiguration(reporterConfig), new W8(new Wl(LoggerStorage.getOrCreatePublicLogger(reporterConfig.apiKey), "Crash Environment")), reporterConfig.userProfileID), c0296ha, C0574s4.l().n(), new C0646uo(), new Ug(), new N6(), new C0234f0(), new C0378kf(c0296ha));
    }

    @Override // io.appmetrica.analytics.impl.V2
    public final String j() {
        return "[ManualReporter]";
    }

    public Zc(Context context, Qi qi, Zh zh, C0296ha c0296ha, J6 j6, C0646uo c0646uo, Ug ug, N6 n6, C0234f0 c0234f0, C0378kf c0378kf) {
        super(context, qi, zh, c0296ha, j6, c0646uo, ug, n6, c0234f0, c0378kf);
        C0574s4.l().getClass();
    }
}
