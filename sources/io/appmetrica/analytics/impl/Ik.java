package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import io.appmetrica.analytics.internal.AppMetricaService;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Ik implements ServiceWakeLock {

    /* renamed from: a  reason: collision with root package name */
    public final Context f500a;
    public final Hk b;
    public final HashMap c = new HashMap();

    public Ik(Context context, Hk hk) {
        this.f500a = context;
        this.b = hk;
    }

    public final String a(String str) {
        return "io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK." + str;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock
    public final synchronized boolean acquireWakeLock(String str) {
        if (this.c.get(str) == null) {
            HashMap hashMap = this.c;
            Hk hk = this.b;
            Context context = this.f500a;
            String a2 = a(str);
            hk.f481a.getClass();
            Intent intent = new Intent(context, AppMetricaService.class);
            intent.setAction(a2);
            Gk gk = new Gk();
            try {
                context.bindService(intent, gk, 1);
            } catch (Throwable unused) {
                gk = null;
            }
            hashMap.put(str, gk);
        }
        return this.c.get(str) != null;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock
    public final synchronized void releaseWakeLock(String str) {
        ServiceConnection serviceConnection = (ServiceConnection) this.c.get(str);
        if (serviceConnection != null) {
            Hk hk = this.b;
            a(str);
            Context context = this.f500a;
            hk.getClass();
            try {
                context.unbindService(serviceConnection);
            } catch (Throwable unused) {
            }
            ServiceConnection serviceConnection2 = (ServiceConnection) this.c.remove(str);
        }
    }
}
