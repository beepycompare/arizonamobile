package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
/* loaded from: classes5.dex */
public final class Yg implements InterfaceC0439mm {

    /* renamed from: a  reason: collision with root package name */
    public final C0182cn f858a;

    public Yg(C0182cn c0182cn) {
        this.f858a = c0182cn;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0439mm
    public final void a() {
        NetworkTask c = this.f858a.c();
        if (c != null) {
            Na.I.getClass();
            NetworkServiceLocator.getInstance().getNetworkCore().startTask(c);
        }
    }
}
