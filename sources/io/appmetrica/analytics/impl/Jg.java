package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
/* loaded from: classes5.dex */
public final class Jg implements Ll {

    /* renamed from: a  reason: collision with root package name */
    public final Bm f624a;

    public Jg(Bm bm) {
        this.f624a = bm;
    }

    @Override // io.appmetrica.analytics.impl.Ll
    public final void a() {
        NetworkTask c = this.f624a.c();
        if (c != null) {
            C0470oa.I.getClass();
            NetworkServiceLocator.getInstance().getNetworkCore().startTask(c);
        }
    }
}
