package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* renamed from: io.appmetrica.analytics.impl.b5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0155b5 extends H5 {
    public AbstractC0155b5(BaseRequestConfig.ComponentLoader<Object, Object, C0233e6> componentLoader, C0198cm c0198cm, BaseRequestConfig.BaseRequestArguments<J4, Object> baseRequestArguments) {
        super(componentLoader, c0198cm, baseRequestArguments);
    }

    @Override // io.appmetrica.analytics.impl.H5
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
