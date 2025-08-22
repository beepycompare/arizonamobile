package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
/* renamed from: io.appmetrica.analytics.impl.ah  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0126ah implements Pl {

    /* renamed from: a  reason: collision with root package name */
    public final Gm f780a;

    public C0126ah(Gm gm) {
        this.f780a = gm;
    }

    @Override // io.appmetrica.analytics.impl.Pl
    public final void a() {
        NetworkTask c = this.f780a.c();
        if (c != null) {
            Ka.F.getClass();
            NetworkServiceLocator.getInstance().getNetworkCore().startTask(c);
        }
    }
}
