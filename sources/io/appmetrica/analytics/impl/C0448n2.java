package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
/* renamed from: io.appmetrica.analytics.impl.n2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0448n2 {
    public static final boolean a(Throwable th) {
        return true;
    }

    public final InterfaceC0250fb a(Context context, AppMetricaConfig appMetricaConfig, InterfaceC0608tb interfaceC0608tb) {
        return new Xh(new Fc(interfaceC0608tb, appMetricaConfig), new H6() { // from class: io.appmetrica.analytics.impl.n2$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.H6
            public final boolean a(Throwable th) {
                return C0448n2.a(th);
            }
        }, appMetricaConfig.crashTransformer, new C0430ma(context));
    }
}
