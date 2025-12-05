package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
/* renamed from: io.appmetrica.analytics.impl.na  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0445na implements InterfaceC0430mk {
    @Override // io.appmetrica.analytics.impl.InterfaceC0430mk
    public final void onCreate() {
        NetworkServiceLocator.getInstance().onCreate();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0430mk
    public final void onDestroy() {
        NetworkServiceLocator.getInstance().onDestroy();
    }
}
