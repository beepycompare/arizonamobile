package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
/* loaded from: classes4.dex */
public final class Vc extends V2 {
    public Vc(Context context, Rf rf, ReporterConfig reporterConfig, Oi oi, C0351ja c0351ja) {
        this(context, oi, new Xh(rf, new CounterConfiguration(reporterConfig), new Y8(new C0688wl(LoggerStorage.getOrCreatePublicLogger(reporterConfig.apiKey), "Crash Environment")), reporterConfig.userProfileID), c0351ja, C0696x4.l().n(), new Tn(), new Wg(), new R6(), new C0135b0(), new Ze(c0351ja));
    }

    @Override // io.appmetrica.analytics.impl.V2
    public final String j() {
        return "[ManualReporter]";
    }

    public Vc(Context context, Oi oi, Xh xh, C0351ja c0351ja, N6 n6, Tn tn, Wg wg, R6 r6, C0135b0 c0135b0, Ze ze) {
        super(context, oi, xh, c0351ja, n6, tn, wg, r6, c0135b0, ze);
        C0696x4.l().getClass();
    }
}
