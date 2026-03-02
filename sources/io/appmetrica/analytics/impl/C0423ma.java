package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
/* renamed from: io.appmetrica.analytics.impl.ma  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0423ma implements InterfaceC0408lk {
    @Override // io.appmetrica.analytics.impl.InterfaceC0408lk
    public final void onCreate() {
        NetworkServiceLocator.getInstance().onCreate();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0408lk
    public final void onDestroy() {
        NetworkServiceLocator.getInstance().onDestroy();
    }
}
