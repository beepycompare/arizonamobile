package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
/* renamed from: io.appmetrica.analytics.impl.eh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0230eh implements Tl {

    /* renamed from: a  reason: collision with root package name */
    public final Km f864a;

    public C0230eh(Km km) {
        this.f864a = km;
    }

    @Override // io.appmetrica.analytics.impl.Tl
    public final void a() {
        NetworkTask c = this.f864a.c();
        if (c != null) {
            Na.F.getClass();
            NetworkServiceLocator.getInstance().getNetworkCore().startTask(c);
        }
    }
}
