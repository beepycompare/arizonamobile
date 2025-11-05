package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import io.appmetrica.analytics.internal.AppMetricaService;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class Hk implements ServiceWakeLock {

    /* renamed from: a  reason: collision with root package name */
    public final Context f511a;
    public final Gk b;
    public final HashMap c = new HashMap();

    public Hk(Context context, Gk gk) {
        this.f511a = context;
        this.b = gk;
    }

    public final String a(String str) {
        return "io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK." + str;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock
    public final synchronized boolean acquireWakeLock(String str) {
        if (this.c.get(str) == null) {
            HashMap hashMap = this.c;
            Gk gk = this.b;
            Context context = this.f511a;
            String a2 = a(str);
            gk.f495a.getClass();
            Intent intent = new Intent(context, AppMetricaService.class);
            intent.setAction(a2);
            Fk fk = new Fk();
            try {
                context.bindService(intent, fk, 1);
            } catch (Throwable unused) {
                fk = null;
            }
            hashMap.put(str, fk);
        }
        return this.c.get(str) != null;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock
    public final synchronized void releaseWakeLock(String str) {
        ServiceConnection serviceConnection = (ServiceConnection) this.c.get(str);
        if (serviceConnection != null) {
            Gk gk = this.b;
            a(str);
            Context context = this.f511a;
            gk.getClass();
            try {
                context.unbindService(serviceConnection);
            } catch (Throwable unused) {
            }
            ServiceConnection serviceConnection2 = (ServiceConnection) this.c.remove(str);
        }
    }
}
