package io.appmetrica.analytics.impl;

import android.app.Service;
/* renamed from: io.appmetrica.analytics.impl.w0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0676w0 implements B1 {

    /* renamed from: a  reason: collision with root package name */
    public final Service f1254a;

    public C0676w0(Service service) {
        this.f1254a = service;
    }

    public final void a(int i) {
        this.f1254a.stopSelf(i);
    }
}
