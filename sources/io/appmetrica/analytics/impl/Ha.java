package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
/* loaded from: classes4.dex */
public final class Ha implements InterfaceC0589sk {
    @Override // io.appmetrica.analytics.impl.InterfaceC0589sk
    public final void onCreate() {
        NetworkServiceLocator.getInstance().onCreate();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0589sk
    public final void onDestroy() {
        NetworkServiceLocator.getInstance().onDestroy();
    }
}
