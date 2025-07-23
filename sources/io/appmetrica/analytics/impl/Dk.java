package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import io.appmetrica.analytics.internal.AppMetricaService;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Dk implements ServiceWakeLock {

    /* renamed from: a  reason: collision with root package name */
    public final Context f400a;
    public final Ck b;
    public final HashMap c = new HashMap();

    public Dk(Context context, Ck ck) {
        this.f400a = context;
        this.b = ck;
    }

    public final String a(String str) {
        return "io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK." + str;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock
    public final synchronized boolean acquireWakeLock(String str) {
        if (this.c.get(str) == null) {
            HashMap hashMap = this.c;
            Ck ck = this.b;
            Context context = this.f400a;
            String a2 = a(str);
            ck.f382a.getClass();
            Intent intent = new Intent(context, AppMetricaService.class);
            intent.setAction(a2);
            Bk bk = new Bk();
            try {
                context.bindService(intent, bk, 1);
            } catch (Throwable unused) {
                bk = null;
            }
            hashMap.put(str, bk);
        }
        return this.c.get(str) != null;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock
    public final synchronized void releaseWakeLock(String str) {
        ServiceConnection serviceConnection = (ServiceConnection) this.c.get(str);
        if (serviceConnection != null) {
            Ck ck = this.b;
            a(str);
            Context context = this.f400a;
            ck.getClass();
            try {
                context.unbindService(serviceConnection);
            } catch (Throwable unused) {
            }
            ServiceConnection serviceConnection2 = (ServiceConnection) this.c.remove(str);
        }
    }
}
