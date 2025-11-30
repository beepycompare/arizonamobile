package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
/* renamed from: io.appmetrica.analytics.impl.na  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0446na implements InterfaceC0431mk {
    @Override // io.appmetrica.analytics.impl.InterfaceC0431mk
    public final void onCreate() {
        NetworkServiceLocator.getInstance().onCreate();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0431mk
    public final void onDestroy() {
        NetworkServiceLocator.getInstance().onDestroy();
    }
}
