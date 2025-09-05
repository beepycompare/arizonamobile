package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
/* loaded from: classes4.dex */
public final class Yc extends Y2 {
    public Yc(Context context, Vf vf, ReporterConfig reporterConfig, Si si, C0429ma c0429ma) {
        this(context, si, new C0153bi(vf, new CounterConfiguration(reporterConfig), new C0144b9(new Al(LoggerStorage.getOrCreatePublicLogger(reporterConfig.apiKey), "Crash Environment")), reporterConfig.userProfileID), c0429ma, A4.l().n(), new Xn(), new C0126ah(), new U6(), new C0161c0(), new C0202df(c0429ma));
    }

    @Override // io.appmetrica.analytics.impl.Y2
    public final String j() {
        return "[ManualReporter]";
    }

    public Yc(Context context, Si si, C0153bi c0153bi, C0429ma c0429ma, Q6 q6, Xn xn, C0126ah c0126ah, U6 u6, C0161c0 c0161c0, C0202df c0202df) {
        super(context, si, c0153bi, c0429ma, q6, xn, c0126ah, u6, c0161c0, c0202df);
        A4.l().getClass();
    }
}
