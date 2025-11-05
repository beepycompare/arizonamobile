package io.appmetrica.analytics.impl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* renamed from: io.appmetrica.analytics.impl.o0  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class ServiceConnectionC0461o0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0486p0 f1031a;

    public ServiceConnectionC0461o0(C0486p0 c0486p0) {
        this.f1031a = c0486p0;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f1031a) {
            this.f1031a.d = IAppMetricaService.Stub.asInterface(iBinder);
            this.f1031a.e.countDown();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f1031a) {
            this.f1031a.d = null;
        }
    }
}
