package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* renamed from: io.appmetrica.analytics.impl.e5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0217e5 extends M5 {
    public AbstractC0217e5(BaseRequestConfig.ComponentLoader<Object, Object, C0373k6> componentLoader, C0493om c0493om, BaseRequestConfig.BaseRequestArguments<M4, Object> baseRequestArguments) {
        super(componentLoader, c0493om, baseRequestArguments);
    }

    @Override // io.appmetrica.analytics.impl.M5
    public final void a(Object obj) {
        M4 m4 = (M4) obj;
        synchronized (this) {
            super.a((Object) m4);
        }
    }

    public final synchronized void a(M4 m4) {
        super.a((Object) m4);
    }
}
