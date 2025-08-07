package io.appmetrica.analytics.impl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* renamed from: io.appmetrica.analytics.impl.l0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class ServiceConnectionC0396l0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0421m0 f931a;

    public ServiceConnectionC0396l0(C0421m0 c0421m0) {
        this.f931a = c0421m0;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f931a) {
            this.f931a.d = IAppMetricaService.Stub.asInterface(iBinder);
            this.f931a.e.countDown();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f931a) {
            this.f931a.d = null;
        }
    }
}
