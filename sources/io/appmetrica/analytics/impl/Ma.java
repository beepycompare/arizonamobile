package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
/* loaded from: classes4.dex */
public final class Ma implements Bk {
    @Override // io.appmetrica.analytics.impl.Bk
    public final void onCreate() {
        NetworkServiceLocator.getInstance().onCreate();
    }

    @Override // io.appmetrica.analytics.impl.Bk
    public final void onDestroy() {
        NetworkServiceLocator.getInstance().onDestroy();
    }
}
