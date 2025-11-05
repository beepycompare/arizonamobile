package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* loaded from: classes3.dex */
public abstract class N4 extends AbstractC0640v5 {
    public N4(BaseRequestConfig.ComponentLoader<Object, Object, S5> componentLoader, C0356jm c0356jm, BaseRequestConfig.BaseRequestArguments<C0639v4, Object> baseRequestArguments) {
        super(componentLoader, c0356jm, baseRequestArguments);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0640v5
    public final void a(Object obj) {
        C0639v4 c0639v4 = (C0639v4) obj;
        synchronized (this) {
            super.a((Object) c0639v4);
        }
    }

    public final synchronized void a(C0639v4 c0639v4) {
        super.a((Object) c0639v4);
    }
}
