package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
/* loaded from: classes5.dex */
public final class Yg implements InterfaceC0438mm {

    /* renamed from: a  reason: collision with root package name */
    public final C0181cn f860a;

    public Yg(C0181cn c0181cn) {
        this.f860a = c0181cn;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0438mm
    public final void a() {
        NetworkTask c = this.f860a.c();
        if (c != null) {
            Na.I.getClass();
            NetworkServiceLocator.getInstance().getNetworkCore().startTask(c);
        }
    }
}
