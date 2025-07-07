package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
/* loaded from: classes4.dex */
public final class Rc extends V2 {
    public Rc(Context context, Nf nf, ReporterConfig reporterConfig, Gi gi, C0262fa c0262fa) {
        this(context, gi, new Qh(nf, new CounterConfiguration(reporterConfig), new T8(new C0497ol(LoggerStorage.getOrCreatePublicLogger(reporterConfig.apiKey), "Crash Environment")), reporterConfig.userProfileID), c0262fa, C0704x4.l().n(), new Ln(), new Pg(), new N6(), new C0150b0(), new Ve(c0262fa));
    }

    @Override // io.appmetrica.analytics.impl.V2
    public final String j() {
        return "[ManualReporter]";
    }

    public Rc(Context context, Gi gi, Qh qh, C0262fa c0262fa, J6 j6, Ln ln, Pg pg, N6 n6, C0150b0 c0150b0, Ve ve) {
        super(context, gi, qh, c0262fa, j6, ln, pg, n6, c0150b0, ve);
        C0704x4.l().getClass();
    }
}
