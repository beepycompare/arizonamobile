package io.appmetrica.analytics.impl;

import android.app.Service;
/* renamed from: io.appmetrica.analytics.impl.u0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0613u0 implements InterfaceC0739z1 {

    /* renamed from: a  reason: collision with root package name */
    public final Service f1245a;

    public C0613u0(Service service) {
        this.f1245a = service;
    }

    public final void a(int i) {
        this.f1245a.stopSelf(i);
    }
}
