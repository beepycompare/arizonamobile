package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
/* renamed from: io.appmetrica.analytics.impl.yc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0725yc extends I2 {
    public C0725yc(Context context, Bf bf, ReporterConfig reporterConfig, C0681wi c0681wi, M9 m9) {
        this(context, c0681wi, new Fh(bf, new CounterConfiguration(reporterConfig), new D8(new C0559rl(LoggerStorage.getOrCreatePublicLogger(reporterConfig.apiKey), "Crash Environment")), reporterConfig.userProfileID), m9, C0136b4.l().n(), new Rn(), new Eg(), new C0644v6(), new C0184d0(), new Je(m9));
    }

    @Override // io.appmetrica.analytics.impl.I2
    public final String j() {
        return "[ManualReporter]";
    }

    public C0725yc(Context context, C0681wi c0681wi, Fh fh, M9 m9, C0544r6 c0544r6, Rn rn, Eg eg, C0644v6 c0644v6, C0184d0 c0184d0, Je je) {
        super(context, c0681wi, fh, m9, c0544r6, rn, eg, c0644v6, c0184d0, je);
        C0136b4.l().getClass();
    }
}
