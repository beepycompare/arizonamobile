package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* loaded from: classes5.dex */
public abstract class G4 extends AbstractC0468o5 {
    public G4(BaseRequestConfig.ComponentLoader<Object, Object, L5> componentLoader, C0256fm c0256fm, BaseRequestConfig.BaseRequestArguments<C0467o4, Object> baseRequestArguments) {
        super(componentLoader, c0256fm, baseRequestArguments);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0468o5
    public final void a(Object obj) {
        C0467o4 c0467o4 = (C0467o4) obj;
        synchronized (this) {
            super.a((Object) c0467o4);
        }
    }

    public final synchronized void a(C0467o4 c0467o4) {
        super.a((Object) c0467o4);
    }
}
