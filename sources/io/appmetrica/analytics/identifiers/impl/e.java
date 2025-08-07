package io.appmetrica.analytics.identifiers.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
/* loaded from: classes4.dex */
public final class e implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final Intent f316a;
    public IBinder b;
    public final Object c = new Object();

    public e(Intent intent, String str) {
        this.f316a = intent;
        String.format("[AdvServiceConnection-%s]", str);
    }

    public final void a(Context context) {
        synchronized (this.c) {
            this.b = null;
            this.c.notifyAll();
        }
        context.unbindService(this);
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        synchronized (this.c) {
            this.b = null;
            this.c.notifyAll();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onNullBinding(ComponentName componentName) {
        synchronized (this.c) {
            this.c.notifyAll();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.c) {
            this.b = iBinder;
            this.c.notifyAll();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.c) {
            this.b = null;
            this.c.notifyAll();
        }
    }
}
