package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* renamed from: io.appmetrica.analytics.impl.b5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0140b5 extends J5 {
    public AbstractC0140b5(BaseRequestConfig.ComponentLoader<Object, Object, C0296h6> componentLoader, C0389km c0389km, BaseRequestConfig.BaseRequestArguments<J4, Object> baseRequestArguments) {
        super(componentLoader, c0389km, baseRequestArguments);
    }

    @Override // io.appmetrica.analytics.impl.J5
    public final void a(Object obj) {
        J4 j4 = (J4) obj;
        synchronized (this) {
            super.a((Object) j4);
        }
    }

    public final synchronized void a(J4 j4) {
        super.a((Object) j4);
    }
}
