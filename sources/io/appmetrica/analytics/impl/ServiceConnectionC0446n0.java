package io.appmetrica.analytics.impl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* renamed from: io.appmetrica.analytics.impl.n0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class ServiceConnectionC0446n0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0472o0 f1000a;

    public ServiceConnectionC0446n0(C0472o0 c0472o0) {
        this.f1000a = c0472o0;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f1000a) {
            this.f1000a.d = IAppMetricaService.Stub.asInterface(iBinder);
            this.f1000a.e.countDown();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f1000a) {
            this.f1000a.d = null;
        }
    }
}
