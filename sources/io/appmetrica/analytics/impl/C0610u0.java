package io.appmetrica.analytics.impl;

import android.app.Service;
/* renamed from: io.appmetrica.analytics.impl.u0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0610u0 implements A1 {

    /* renamed from: a  reason: collision with root package name */
    public final Service f1140a;

    public C0610u0(Service service) {
        this.f1140a = service;
    }

    public final void a(int i) {
        this.f1140a.stopSelf(i);
    }
}
