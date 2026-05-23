package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
/* loaded from: classes5.dex */
public final class Ma implements Nk {
    @Override // io.appmetrica.analytics.impl.Nk
    public final void onCreate() {
        NetworkServiceLocator.getInstance().onCreate();
    }

    @Override // io.appmetrica.analytics.impl.Nk
    public final void onDestroy() {
        NetworkServiceLocator.getInstance().onDestroy();
    }
}
