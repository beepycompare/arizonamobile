package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import io.appmetrica.analytics.internal.AppMetricaService;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.el  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0224el implements ServiceWakeLock {

    /* renamed from: a  reason: collision with root package name */
    public final Context f973a;
    public final C0199dl b;
    public final HashMap c = new HashMap();

    public C0224el(Context context, C0199dl c0199dl) {
        this.f973a = context;
        this.b = c0199dl;
    }

    public final String a(String str) {
        return "io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK." + str;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock
    public final synchronized boolean acquireWakeLock(String str) {
        if (this.c.get(str) == null) {
            HashMap hashMap = this.c;
            C0199dl c0199dl = this.b;
            Context context = this.f973a;
            String a2 = a(str);
            c0199dl.f953a.getClass();
            Intent intent = new Intent(context, AppMetricaService.class);
            intent.setAction(a2);
            ServiceConnectionC0173cl serviceConnectionC0173cl = new ServiceConnectionC0173cl();
            try {
                context.bindService(intent, serviceConnectionC0173cl, 1);
            } catch (Throwable unused) {
                serviceConnectionC0173cl = null;
            }
            hashMap.put(str, serviceConnectionC0173cl);
        }
        return this.c.get(str) != null;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock
    public final synchronized void releaseWakeLock(String str) {
        ServiceConnection serviceConnection = (ServiceConnection) this.c.get(str);
        if (serviceConnection != null) {
            C0199dl c0199dl = this.b;
            a(str);
            Context context = this.f973a;
            c0199dl.getClass();
            try {
                context.unbindService(serviceConnection);
            } catch (Throwable unused) {
            }
            ServiceConnection serviceConnection2 = (ServiceConnection) this.c.remove(str);
        }
    }
}
