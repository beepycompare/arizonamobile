package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.a5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0121a5 extends Qh {
    public C0121a5(Nf nf) {
        super(nf, new CounterConfiguration(), new T8(new C0489ol(LoggerStorage.getMainPublicOrAnonymousLogger(), "Crash Environment")));
        b().setReporterType(CounterConfigurationReporterType.COMMUTATION);
    }

    @Override // io.appmetrica.analytics.impl.Qh
    public final boolean f() {
        return true;
    }
}
