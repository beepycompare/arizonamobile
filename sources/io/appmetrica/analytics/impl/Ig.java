package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
/* loaded from: classes5.dex */
public final class Ig implements Kl {

    /* renamed from: a  reason: collision with root package name */
    public final Am f630a;

    public Ig(Am am) {
        this.f630a = am;
    }

    @Override // io.appmetrica.analytics.impl.Kl
    public final void a() {
        NetworkTask c = this.f630a.c();
        if (c != null) {
            C0449na.I.getClass();
            NetworkServiceLocator.getInstance().getNetworkCore().startTask(c);
        }
    }
}
