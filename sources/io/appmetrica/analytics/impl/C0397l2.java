package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
/* renamed from: io.appmetrica.analytics.impl.l2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0397l2 {
    public static final boolean a(Throwable th) {
        return true;
    }

    public final InterfaceC0127ab a(Context context, AppMetricaConfig appMetricaConfig, InterfaceC0481ob interfaceC0481ob) {
        return new Oh(new Ac(interfaceC0481ob, appMetricaConfig), new E6() { // from class: io.appmetrica.analytics.impl.l2$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.E6
            public final boolean a(Throwable th) {
                return C0397l2.a(th);
            }
        }, appMetricaConfig.crashTransformer, new C0306ha(context));
    }
}
