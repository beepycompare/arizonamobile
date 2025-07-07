package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
/* loaded from: classes4.dex */
public final class Fa implements InterfaceC0521pk {
    @Override // io.appmetrica.analytics.impl.InterfaceC0521pk
    public final void onCreate() {
        NetworkServiceLocator.getInstance().onCreate();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0521pk
    public final void onDestroy() {
        NetworkServiceLocator.getInstance().onDestroy();
    }
}
