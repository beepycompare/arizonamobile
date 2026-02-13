package io.appmetrica.analytics.impl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* renamed from: io.appmetrica.analytics.impl.o0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class ServiceConnectionC0464o0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0489p0 f1144a;

    public ServiceConnectionC0464o0(C0489p0 c0489p0) {
        this.f1144a = c0489p0;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f1144a) {
            this.f1144a.d = IAppMetricaService.Stub.asInterface(iBinder);
            this.f1144a.e.countDown();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f1144a) {
            this.f1144a.d = null;
        }
    }
}
