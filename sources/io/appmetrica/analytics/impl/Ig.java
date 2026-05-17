package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
/* loaded from: classes5.dex */
public final class Ig implements Kl {

    /* renamed from: a  reason: collision with root package name */
    public final Am f634a;

    public Ig(Am am) {
        this.f634a = am;
    }

    @Override // io.appmetrica.analytics.impl.Kl
    public final void a() {
        NetworkTask c = this.f634a.c();
        if (c != null) {
            C0448na.I.getClass();
            NetworkServiceLocator.getInstance().getNetworkCore().startTask(c);
        }
    }
}
