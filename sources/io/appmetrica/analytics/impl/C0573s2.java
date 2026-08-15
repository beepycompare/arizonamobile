package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
/* renamed from: io.appmetrica.analytics.impl.s2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0573s2 {
    public static final boolean a(Throwable th) {
        return true;
    }

    public final InterfaceC0298hb a(Context context, AppMetricaConfig appMetricaConfig, InterfaceC0556rb interfaceC0556rb) {
        return new Vh(new Hc(interfaceC0556rb, appMetricaConfig), new InterfaceC0733y6() { // from class: io.appmetrica.analytics.impl.s2$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0733y6
            public final boolean a(Throwable th) {
                return C0573s2.a(th);
            }
        }, appMetricaConfig.crashTransformer, new C0297ha(context));
    }
}
