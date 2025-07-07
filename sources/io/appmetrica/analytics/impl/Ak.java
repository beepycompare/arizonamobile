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
    public final Context f339a;
    public final C0770zk b;
    public final HashMap c = new HashMap();

    public Ak(Context context, C0770zk c0770zk) {
        this.f339a = context;
        this.b = c0770zk;
    }

    public final String a(String str) {
        return "io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK." + str;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock
    public final synchronized boolean acquireWakeLock(String str) {
        if (this.c.get(str) == null) {
            HashMap hashMap = this.c;
            C0770zk c0770zk = this.b;
            Context context = this.f339a;
            String a2 = a(str);
            c0770zk.f1170a.getClass();
            Intent intent = new Intent(context, AppMetricaService.class);
            intent.setAction(a2);
            ServiceConnectionC0745yk serviceConnectionC0745yk = new ServiceConnectionC0745yk();
            try {
                context.bindService(intent, serviceConnectionC0745yk, 1);
            } catch (Throwable unused) {
                serviceConnectionC0745yk = null;
            }
            hashMap.put(str, serviceConnectionC0745yk);
        }
        return this.c.get(str) != null;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock
    public final synchronized void releaseWakeLock(String str) {
        ServiceConnection serviceConnection = (ServiceConnection) this.c.get(str);
        if (serviceConnection != null) {
            C0770zk c0770zk = this.b;
            a(str);
            Context context = this.f339a;
            c0770zk.getClass();
            try {
                context.unbindService(serviceConnection);
            } catch (Throwable unused) {
            }
            ServiceConnection serviceConnection2 = (ServiceConnection) this.c.remove(str);
        }
    }
}
