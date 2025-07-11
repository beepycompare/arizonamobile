package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
/* loaded from: classes4.dex */
public final class Tg implements Hl {

    /* renamed from: a  reason: collision with root package name */
    public final C0739ym f643a;

    public Tg(C0739ym c0739ym) {
        this.f643a = c0739ym;
    }

    @Override // io.appmetrica.analytics.impl.Hl
    public final void a() {
        NetworkTask c = this.f643a.c();
        if (c != null) {
            Ga.F.getClass();
            NetworkServiceLocator.getInstance().getNetworkCore().startTask(c);
        }
    }
}
