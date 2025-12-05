package io.appmetrica.analytics.impl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* renamed from: io.appmetrica.analytics.impl.o0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class ServiceConnectionC0460o0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0485p0 f1122a;

    public ServiceConnectionC0460o0(C0485p0 c0485p0) {
        this.f1122a = c0485p0;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f1122a) {
            this.f1122a.d = IAppMetricaService.Stub.asInterface(iBinder);
            this.f1122a.e.countDown();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f1122a) {
            this.f1122a.d = null;
        }
    }
}
