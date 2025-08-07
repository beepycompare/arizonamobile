package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
/* loaded from: classes4.dex */
public final class Vg implements Kl {

    /* renamed from: a  reason: collision with root package name */
    public final Bm f687a;

    public Vg(Bm bm) {
        this.f687a = bm;
    }

    @Override // io.appmetrica.analytics.impl.Kl
    public final void a() {
        NetworkTask c = this.f687a.c();
        if (c != null) {
            Ia.F.getClass();
            NetworkServiceLocator.getInstance().getNetworkCore().startTask(c);
        }
    }
}
