package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
/* renamed from: io.appmetrica.analytics.impl.eh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0229eh implements Tl {

    /* renamed from: a  reason: collision with root package name */
    public final Km f863a;

    public C0229eh(Km km) {
        this.f863a = km;
    }

    @Override // io.appmetrica.analytics.impl.Tl
    public final void a() {
        NetworkTask c = this.f863a.c();
        if (c != null) {
            Na.F.getClass();
            NetworkServiceLocator.getInstance().getNetworkCore().startTask(c);
        }
    }
}
