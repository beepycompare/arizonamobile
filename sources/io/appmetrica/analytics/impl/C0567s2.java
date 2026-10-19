package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
/* renamed from: io.appmetrica.analytics.impl.s2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0567s2 {
    public static final boolean a(Throwable th) {
        return true;
    }

    public final InterfaceC0292hb a(Context context, AppMetricaConfig appMetricaConfig, InterfaceC0550rb interfaceC0550rb) {
        return new Vh(new Hc(interfaceC0550rb, appMetricaConfig), new InterfaceC0727y6() { // from class: io.appmetrica.analytics.impl.s2$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0727y6
            public final boolean a(Throwable th) {
                return C0567s2.a(th);
            }
        }, appMetricaConfig.crashTransformer, new C0291ha(context));
    }
}
