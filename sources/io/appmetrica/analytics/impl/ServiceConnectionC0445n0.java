package io.appmetrica.analytics.impl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* renamed from: io.appmetrica.analytics.impl.n0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class ServiceConnectionC0445n0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0471o0 f999a;

    public ServiceConnectionC0445n0(C0471o0 c0471o0) {
        this.f999a = c0471o0;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f999a) {
            this.f999a.d = IAppMetricaService.Stub.asInterface(iBinder);
            this.f999a.e.countDown();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f999a) {
            this.f999a.d = null;
        }
    }
}
