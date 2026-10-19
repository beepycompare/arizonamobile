package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
/* loaded from: classes5.dex */
public final class Yg implements InterfaceC0432mm {

    /* renamed from: a  reason: collision with root package name */
    public final C0175cn f863a;

    public Yg(C0175cn c0175cn) {
        this.f863a = c0175cn;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0432mm
    public final void a() {
        NetworkTask c = this.f863a.c();
        if (c != null) {
            Na.I.getClass();
            NetworkServiceLocator.getInstance().getNetworkCore().startTask(c);
        }
    }
}
