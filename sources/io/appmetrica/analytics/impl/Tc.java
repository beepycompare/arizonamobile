package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
/* loaded from: classes4.dex */
public final class Tc extends V2 {
    public Tc(Context context, Pf pf, ReporterConfig reporterConfig, Ji ji, C0307ha c0307ha) {
        this(context, ji, new Sh(pf, new CounterConfiguration(reporterConfig), new W8(new C0566rl(LoggerStorage.getOrCreatePublicLogger(reporterConfig.apiKey), "Crash Environment")), reporterConfig.userProfileID), c0307ha, C0699x4.l().n(), new On(), new Rg(), new Q6(), new C0143b0(), new Xe(c0307ha));
    }

    @Override // io.appmetrica.analytics.impl.V2
    public final String j() {
        return "[ManualReporter]";
    }

    public Tc(Context context, Ji ji, Sh sh, C0307ha c0307ha, M6 m6, On on, Rg rg, Q6 q6, C0143b0 c0143b0, Xe xe) {
        super(context, ji, sh, c0307ha, m6, on, rg, q6, c0143b0, xe);
        C0699x4.l().getClass();
    }
}
