package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
/* renamed from: io.appmetrica.analytics.impl.l2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0403l2 {
    public static final boolean a(Throwable th) {
        return true;
    }

    public final Ya a(Context context, AppMetricaConfig appMetricaConfig, InterfaceC0437mb interfaceC0437mb) {
        return new Mh(new C0737yc(interfaceC0437mb, appMetricaConfig), new B6() { // from class: io.appmetrica.analytics.impl.l2$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.B6
            public final boolean a(Throwable th) {
                return C0403l2.a(th);
            }
        }, appMetricaConfig.crashTransformer, new C0262fa(context));
    }
}
