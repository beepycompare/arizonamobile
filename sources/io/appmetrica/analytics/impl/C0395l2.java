package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
/* renamed from: io.appmetrica.analytics.impl.l2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0395l2 {
    public static final boolean a(Throwable th) {
        return true;
    }

    public final InterfaceC0172cb a(Context context, AppMetricaConfig appMetricaConfig, InterfaceC0529qb interfaceC0529qb) {
        return new Th(new Cc(interfaceC0529qb, appMetricaConfig), new E6() { // from class: io.appmetrica.analytics.impl.l2$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.E6
            public final boolean a(Throwable th) {
                return C0395l2.a(th);
            }
        }, appMetricaConfig.crashTransformer, new C0351ja(context));
    }
}
