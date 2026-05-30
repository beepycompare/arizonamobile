package io.appmetrica.analytics.impl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* renamed from: io.appmetrica.analytics.impl.q0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class ServiceConnectionC0521q0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0546r0 f1155a;

    public ServiceConnectionC0521q0(C0546r0 c0546r0) {
        this.f1155a = c0546r0;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f1155a) {
            this.f1155a.d = IAppMetricaService.Stub.asInterface(iBinder);
            this.f1155a.e.countDown();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f1155a) {
            this.f1155a.d = null;
        }
    }
}
