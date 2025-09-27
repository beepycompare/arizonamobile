package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import io.appmetrica.analytics.internal.AppMetricaService;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Mk implements ServiceWakeLock {

    /* renamed from: a  reason: collision with root package name */
    public final Context f581a;
    public final Lk b;
    public final HashMap c = new HashMap();

    public Mk(Context context, Lk lk) {
        this.f581a = context;
        this.b = lk;
    }

    public final String a(String str) {
        return "io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK." + str;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock
    public final synchronized boolean acquireWakeLock(String str) {
        if (this.c.get(str) == null) {
            HashMap hashMap = this.c;
            Lk lk = this.b;
            Context context = this.f581a;
            String a2 = a(str);
            lk.f564a.getClass();
            Intent intent = new Intent(context, AppMetricaService.class);
            intent.setAction(a2);
            Kk kk = new Kk();
            try {
                context.bindService(intent, kk, 1);
            } catch (Throwable unused) {
                kk = null;
            }
            hashMap.put(str, kk);
        }
        return this.c.get(str) != null;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock
    public final synchronized void releaseWakeLock(String str) {
        ServiceConnection serviceConnection = (ServiceConnection) this.c.get(str);
        if (serviceConnection != null) {
            Lk lk = this.b;
            a(str);
            Context context = this.f581a;
            lk.getClass();
            try {
                context.unbindService(serviceConnection);
            } catch (Throwable unused) {
            }
            ServiceConnection serviceConnection2 = (ServiceConnection) this.c.remove(str);
        }
    }
}
