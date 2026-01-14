package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
/* renamed from: io.appmetrica.analytics.impl.f2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0237f2 {
    public static final boolean a(Throwable th) {
        return true;
    }

    public final Fa a(Context context, AppMetricaConfig appMetricaConfig, Ta ta) {
        return new Bh(new C0247fc(ta, appMetricaConfig), new InterfaceC0319i6() { // from class: io.appmetrica.analytics.impl.f2$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0319i6
            public final boolean a(Throwable th) {
                return C0237f2.a(th);
            }
        }, appMetricaConfig.crashTransformer, new M9(context));
    }
}
