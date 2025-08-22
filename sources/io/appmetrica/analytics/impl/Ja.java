package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
/* loaded from: classes4.dex */
public final class Ja implements InterfaceC0712xk {
    @Override // io.appmetrica.analytics.impl.InterfaceC0712xk
    public final void onCreate() {
        NetworkServiceLocator.getInstance().onCreate();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0712xk
    public final void onDestroy() {
        NetworkServiceLocator.getInstance().onDestroy();
    }
}
