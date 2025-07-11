package io.appmetrica.analytics.impl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* renamed from: io.appmetrica.analytics.impl.l0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class ServiceConnectionC0393l0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0418m0 f915a;

    public ServiceConnectionC0393l0(C0418m0 c0418m0) {
        this.f915a = c0418m0;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f915a) {
            this.f915a.d = IAppMetricaService.Stub.asInterface(iBinder);
            this.f915a.e.countDown();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f915a) {
            this.f915a.d = null;
        }
    }
}
