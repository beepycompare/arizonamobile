package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
/* renamed from: io.appmetrica.analytics.impl.ma  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0424ma implements InterfaceC0409lk {
    @Override // io.appmetrica.analytics.impl.InterfaceC0409lk
    public final void onCreate() {
        NetworkServiceLocator.getInstance().onCreate();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0409lk
    public final void onDestroy() {
        NetworkServiceLocator.getInstance().onDestroy();
    }
}
