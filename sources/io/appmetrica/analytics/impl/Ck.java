package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import io.appmetrica.analytics.internal.AppMetricaService;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class Ck implements ServiceWakeLock {

    /* renamed from: a  reason: collision with root package name */
    public final Context f539a;
    public final Bk b;
    public final HashMap c = new HashMap();

    public Ck(Context context, Bk bk) {
        this.f539a = context;
        this.b = bk;
    }

    public final String a(String str) {
        return "io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK." + str;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock
    public final synchronized boolean acquireWakeLock(String str) {
        if (this.c.get(str) == null) {
            HashMap hashMap = this.c;
            Bk bk = this.b;
            Context context = this.f539a;
            String a2 = a(str);
            bk.f524a.getClass();
            Intent intent = new Intent(context, AppMetricaService.class);
            intent.setAction(a2);
            Ak ak = new Ak();
            try {
                context.bindService(intent, ak, 1);
            } catch (Throwable unused) {
                ak = null;
            }
            hashMap.put(str, ak);
        }
        return this.c.get(str) != null;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock
    public final synchronized void releaseWakeLock(String str) {
        ServiceConnection serviceConnection = (ServiceConnection) this.c.get(str);
        if (serviceConnection != null) {
            Bk bk = this.b;
            a(str);
            Context context = this.f539a;
            bk.getClass();
            try {
                context.unbindService(serviceConnection);
            } catch (Throwable unused) {
            }
            ServiceConnection serviceConnection2 = (ServiceConnection) this.c.remove(str);
        }
    }
}
