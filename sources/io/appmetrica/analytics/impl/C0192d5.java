package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.d5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0192d5 extends C0153bi {
    public C0192d5(Vf vf) {
        super(vf, new CounterConfiguration(), new C0144b9(new Al(LoggerStorage.getMainPublicOrAnonymousLogger(), "Crash Environment")));
        b().setReporterType(CounterConfigurationReporterType.COMMUTATION);
    }

    @Override // io.appmetrica.analytics.impl.C0153bi
    public final boolean f() {
        return true;
    }
}
