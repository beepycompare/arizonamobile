package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
/* loaded from: classes4.dex */
public final class Tg implements Hl {

    /* renamed from: a  reason: collision with root package name */
    public final C0747ym f642a;

    public Tg(C0747ym c0747ym) {
        this.f642a = c0747ym;
    }

    @Override // io.appmetrica.analytics.impl.Hl
    public final void a() {
        NetworkTask c = this.f642a.c();
        if (c != null) {
            Ga.F.getClass();
            NetworkServiceLocator.getInstance().getNetworkCore().startTask(c);
        }
    }
}
