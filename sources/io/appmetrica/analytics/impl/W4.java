package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* loaded from: classes5.dex */
public abstract class W4 extends E5 {
    public W4(BaseRequestConfig.ComponentLoader<Object, Object, C0138b6> componentLoader, Hm hm, BaseRequestConfig.BaseRequestArguments<F4, Object> baseRequestArguments) {
        super(componentLoader, hm, baseRequestArguments);
    }

    @Override // io.appmetrica.analytics.impl.E5
    public final void a(Object obj) {
        F4 f4 = (F4) obj;
        synchronized (this) {
            super.a((Object) f4);
        }
    }

    public final synchronized void a(F4 f4) {
        super.a((Object) f4);
    }
}
