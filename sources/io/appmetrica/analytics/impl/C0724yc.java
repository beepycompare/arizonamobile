package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
/* renamed from: io.appmetrica.analytics.impl.yc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0724yc extends I2 {
    public C0724yc(Context context, Bf bf, ReporterConfig reporterConfig, C0680wi c0680wi, M9 m9) {
        this(context, c0680wi, new Fh(bf, new CounterConfiguration(reporterConfig), new D8(new C0558rl(LoggerStorage.getOrCreatePublicLogger(reporterConfig.apiKey), "Crash Environment")), reporterConfig.userProfileID), m9, C0135b4.l().n(), new Rn(), new Eg(), new C0643v6(), new C0183d0(), new Je(m9));
    }

    @Override // io.appmetrica.analytics.impl.I2
    public final String j() {
        return "[ManualReporter]";
    }

    public C0724yc(Context context, C0680wi c0680wi, Fh fh, M9 m9, C0543r6 c0543r6, Rn rn, Eg eg, C0643v6 c0643v6, C0183d0 c0183d0, Je je) {
        super(context, c0680wi, fh, m9, c0543r6, rn, eg, c0643v6, c0183d0, je);
        C0135b4.l().getClass();
    }
}
