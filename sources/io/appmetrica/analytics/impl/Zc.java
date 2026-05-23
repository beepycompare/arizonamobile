package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
/* loaded from: classes5.dex */
public final class Zc extends V2 {
    public Zc(Context context, C0175cg c0175cg, ReporterConfig reporterConfig, Qi qi, C0298ha c0298ha) {
        this(context, qi, new Zh(c0175cg, new CounterConfiguration(reporterConfig), new W8(new Wl(LoggerStorage.getOrCreatePublicLogger(reporterConfig.apiKey), "Crash Environment")), reporterConfig.userProfileID), c0298ha, C0576s4.l().n(), new C0648uo(), new Ug(), new N6(), new C0236f0(), new C0380kf(c0298ha));
    }

    @Override // io.appmetrica.analytics.impl.V2
    public final String j() {
        return "[ManualReporter]";
    }

    public Zc(Context context, Qi qi, Zh zh, C0298ha c0298ha, J6 j6, C0648uo c0648uo, Ug ug, N6 n6, C0236f0 c0236f0, C0380kf c0380kf) {
        super(context, qi, zh, c0298ha, j6, c0648uo, ug, n6, c0236f0, c0380kf);
        C0576s4.l().getClass();
    }
}
