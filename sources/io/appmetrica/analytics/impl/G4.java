package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* loaded from: classes5.dex */
public abstract class G4 extends AbstractC0469o5 {
    public G4(BaseRequestConfig.ComponentLoader<Object, Object, L5> componentLoader, C0257fm c0257fm, BaseRequestConfig.BaseRequestArguments<C0468o4, Object> baseRequestArguments) {
        super(componentLoader, c0257fm, baseRequestArguments);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0469o5
    public final void a(Object obj) {
        C0468o4 c0468o4 = (C0468o4) obj;
        synchronized (this) {
            super.a((Object) c0468o4);
        }
    }

    public final synchronized void a(C0468o4 c0468o4) {
        super.a((Object) c0468o4);
    }
}
