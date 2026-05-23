package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* loaded from: classes5.dex */
public final class V4 extends Zh {
    public V4(C0175cg c0175cg) {
        super(c0175cg, new CounterConfiguration(), new W8(new Wl(LoggerStorage.getMainPublicOrAnonymousLogger(), "Crash Environment")));
        b().setReporterType(CounterConfigurationReporterType.COMMUTATION);
    }

    @Override // io.appmetrica.analytics.impl.Zh
    public final boolean f() {
        return true;
    }
}
