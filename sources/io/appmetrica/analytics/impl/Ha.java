package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
/* loaded from: classes4.dex */
public final class Ha implements InterfaceC0590sk {
    @Override // io.appmetrica.analytics.impl.InterfaceC0590sk
    public final void onCreate() {
        NetworkServiceLocator.getInstance().onCreate();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0590sk
    public final void onDestroy() {
        NetworkServiceLocator.getInstance().onDestroy();
    }
}
