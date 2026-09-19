package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
/* loaded from: classes5.dex */
public final class Yg implements InterfaceC0437mm {

    /* renamed from: a  reason: collision with root package name */
    public final C0180cn f860a;

    public Yg(C0180cn c0180cn) {
        this.f860a = c0180cn;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0437mm
    public final void a() {
        NetworkTask c = this.f860a.c();
        if (c != null) {
            Na.I.getClass();
            NetworkServiceLocator.getInstance().getNetworkCore().startTask(c);
        }
    }
}
