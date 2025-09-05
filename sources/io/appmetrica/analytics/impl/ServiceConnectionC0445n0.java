package io.appmetrica.analytics.impl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* renamed from: io.appmetrica.analytics.impl.n0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class ServiceConnectionC0445n0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0471o0 f995a;

    public ServiceConnectionC0445n0(C0471o0 c0471o0) {
        this.f995a = c0471o0;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f995a) {
            this.f995a.d = IAppMetricaService.Stub.asInterface(iBinder);
            this.f995a.e.countDown();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f995a) {
            this.f995a.d = null;
        }
    }
}
