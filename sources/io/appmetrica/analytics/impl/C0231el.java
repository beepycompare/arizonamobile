package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import io.appmetrica.analytics.internal.AppMetricaService;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.el  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0231el implements ServiceWakeLock {

    /* renamed from: a  reason: collision with root package name */
    public final Context f967a;
    public final C0206dl b;
    public final HashMap c = new HashMap();

    public C0231el(Context context, C0206dl c0206dl) {
        this.f967a = context;
        this.b = c0206dl;
    }

    public final String a(String str) {
        return "io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK." + str;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock
    public final synchronized boolean acquireWakeLock(String str) {
        if (this.c.get(str) == null) {
            HashMap hashMap = this.c;
            C0206dl c0206dl = this.b;
            Context context = this.f967a;
            String a2 = a(str);
            c0206dl.f947a.getClass();
            Intent intent = new Intent(context, AppMetricaService.class);
            intent.setAction(a2);
            ServiceConnectionC0180cl serviceConnectionC0180cl = new ServiceConnectionC0180cl();
            try {
                context.bindService(intent, serviceConnectionC0180cl, 1);
            } catch (Throwable unused) {
                serviceConnectionC0180cl = null;
            }
            hashMap.put(str, serviceConnectionC0180cl);
        }
        return this.c.get(str) != null;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock
    public final synchronized void releaseWakeLock(String str) {
        ServiceConnection serviceConnection = (ServiceConnection) this.c.get(str);
        if (serviceConnection != null) {
            C0206dl c0206dl = this.b;
            a(str);
            Context context = this.f967a;
            c0206dl.getClass();
            try {
                context.unbindService(serviceConnection);
            } catch (Throwable unused) {
            }
            ServiceConnection serviceConnection2 = (ServiceConnection) this.c.remove(str);
        }
    }
}
