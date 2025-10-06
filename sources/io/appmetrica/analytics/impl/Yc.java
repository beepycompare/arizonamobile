package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
/* loaded from: classes4.dex */
public final class Yc extends Y2 {
    public Yc(Context context, Vf vf, ReporterConfig reporterConfig, Si si, C0430ma c0430ma) {
        this(context, si, new C0154bi(vf, new CounterConfiguration(reporterConfig), new C0145b9(new Al(LoggerStorage.getOrCreatePublicLogger(reporterConfig.apiKey), "Crash Environment")), reporterConfig.userProfileID), c0430ma, A4.l().n(), new Xn(), new C0127ah(), new U6(), new C0162c0(), new C0203df(c0430ma));
    }

    @Override // io.appmetrica.analytics.impl.Y2
    public final String j() {
        return "[ManualReporter]";
    }

    public Yc(Context context, Si si, C0154bi c0154bi, C0430ma c0430ma, Q6 q6, Xn xn, C0127ah c0127ah, U6 u6, C0162c0 c0162c0, C0203df c0203df) {
        super(context, si, c0154bi, c0430ma, q6, xn, c0127ah, u6, c0162c0, c0203df);
        A4.l().getClass();
    }
}
