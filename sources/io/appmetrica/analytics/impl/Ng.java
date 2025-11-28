package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
/* loaded from: classes5.dex */
public final class Ng implements Ol {

    /* renamed from: a  reason: collision with root package name */
    public final Em f608a;

    public Ng(Em em) {
        this.f608a = em;
    }

    @Override // io.appmetrica.analytics.impl.Ol
    public final void a() {
        NetworkTask c = this.f608a.c();
        if (c != null) {
            C0620ua.H.getClass();
            NetworkServiceLocator.getInstance().getNetworkCore().startTask(c);
        }
    }
}
