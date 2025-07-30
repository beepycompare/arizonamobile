package io.appmetrica.analytics.impl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* renamed from: io.appmetrica.analytics.impl.l0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class ServiceConnectionC0395l0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0420m0 f932a;

    public ServiceConnectionC0395l0(C0420m0 c0420m0) {
        this.f932a = c0420m0;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f932a) {
            this.f932a.d = IAppMetricaService.Stub.asInterface(iBinder);
            this.f932a.e.countDown();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f932a) {
            this.f932a.d = null;
        }
    }
}
