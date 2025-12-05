package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* loaded from: classes5.dex */
public abstract class H4 extends AbstractC0490p5 {
    public H4(BaseRequestConfig.ComponentLoader<Object, Object, M5> componentLoader, C0278gm c0278gm, BaseRequestConfig.BaseRequestArguments<C0489p4, Object> baseRequestArguments) {
        super(componentLoader, c0278gm, baseRequestArguments);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0490p5
    public final void a(Object obj) {
        C0489p4 c0489p4 = (C0489p4) obj;
        synchronized (this) {
            super.a((Object) c0489p4);
        }
    }

    public final synchronized void a(C0489p4 c0489p4) {
        super.a((Object) c0489p4);
    }
}
