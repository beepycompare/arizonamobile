package io.appmetrica.analytics.impl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* renamed from: io.appmetrica.analytics.impl.q0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class ServiceConnectionC0514q0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0539r0 f1160a;

    public ServiceConnectionC0514q0(C0539r0 c0539r0) {
        this.f1160a = c0539r0;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f1160a) {
            this.f1160a.d = IAppMetricaService.Stub.asInterface(iBinder);
            this.f1160a.e.countDown();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f1160a) {
            this.f1160a.d = null;
        }
    }
}
