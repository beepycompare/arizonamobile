package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
/* renamed from: io.appmetrica.analytics.impl.ta  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0595ta implements InterfaceC0506pk {
    @Override // io.appmetrica.analytics.impl.InterfaceC0506pk
    public final void onCreate() {
        NetworkServiceLocator.getInstance().onCreate();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0506pk
    public final void onDestroy() {
        NetworkServiceLocator.getInstance().onDestroy();
    }
}
