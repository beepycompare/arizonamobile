package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import io.appmetrica.analytics.internal.AppMetricaService;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Ak implements ServiceWakeLock {

    /* renamed from: a  reason: collision with root package name */
    public final Context f340a;
    public final C0762zk b;
    public final HashMap c = new HashMap();

    public Ak(Context context, C0762zk c0762zk) {
        this.f340a = context;
        this.b = c0762zk;
    }

    public final String a(String str) {
        return "io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK." + str;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock
    public final synchronized boolean acquireWakeLock(String str) {
        if (this.c.get(str) == null) {
            HashMap hashMap = this.c;
            C0762zk c0762zk = this.b;
            Context context = this.f340a;
            String a2 = a(str);
            c0762zk.f1171a.getClass();
            Intent intent = new Intent(context, AppMetricaService.class);
            intent.setAction(a2);
            ServiceConnectionC0737yk serviceConnectionC0737yk = new ServiceConnectionC0737yk();
            try {
                context.bindService(intent, serviceConnectionC0737yk, 1);
            } catch (Throwable unused) {
                serviceConnectionC0737yk = null;
            }
            hashMap.put(str, serviceConnectionC0737yk);
        }
        return this.c.get(str) != null;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock
    public final synchronized void releaseWakeLock(String str) {
        ServiceConnection serviceConnection = (ServiceConnection) this.c.get(str);
        if (serviceConnection != null) {
            C0762zk c0762zk = this.b;
            a(str);
            Context context = this.f340a;
            c0762zk.getClass();
            try {
                context.unbindService(serviceConnection);
            } catch (Throwable unused) {
            }
            ServiceConnection serviceConnection2 = (ServiceConnection) this.c.remove(str);
        }
    }
}
