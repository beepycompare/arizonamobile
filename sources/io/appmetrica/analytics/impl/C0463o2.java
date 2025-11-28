package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
/* renamed from: io.appmetrica.analytics.impl.o2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0463o2 {
    public static final boolean a(Throwable th) {
        return true;
    }

    public final Ma a(Context context, AppMetricaConfig appMetricaConfig, InterfaceC0113ab interfaceC0113ab) {
        return new Gh(new C0423mc(interfaceC0113ab, appMetricaConfig), new InterfaceC0492p6() { // from class: io.appmetrica.analytics.impl.o2$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0492p6
            public final boolean a(Throwable th) {
                return C0463o2.a(th);
            }
        }, appMetricaConfig.crashTransformer, new T9(context));
    }
}
