package io.appmetrica.analytics.impl;

import android.app.Service;
/* renamed from: io.appmetrica.analytics.impl.u0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0609u0 implements A1 {

    /* renamed from: a  reason: collision with root package name */
    public final Service f1223a;

    public C0609u0(Service service) {
        this.f1223a = service;
    }

    public final void a(int i) {
        this.f1223a.stopSelf(i);
    }
}
