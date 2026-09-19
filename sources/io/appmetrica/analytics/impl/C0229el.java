package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import io.appmetrica.analytics.internal.AppMetricaService;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.el  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0229el implements ServiceWakeLock {

    /* renamed from: a  reason: collision with root package name */
    public final Context f970a;
    public final C0204dl b;
    public final HashMap c = new HashMap();

    public C0229el(Context context, C0204dl c0204dl) {
        this.f970a = context;
        this.b = c0204dl;
    }

    public final String a(String str) {
        return "io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK." + str;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock
    public final synchronized boolean acquireWakeLock(String str) {
        if (this.c.get(str) == null) {
            HashMap hashMap = this.c;
            C0204dl c0204dl = this.b;
            Context context = this.f970a;
            String a2 = a(str);
            c0204dl.f950a.getClass();
            Intent intent = new Intent(context, AppMetricaService.class);
            intent.setAction(a2);
            ServiceConnectionC0178cl serviceConnectionC0178cl = new ServiceConnectionC0178cl();
            try {
                context.bindService(intent, serviceConnectionC0178cl, 1);
            } catch (Throwable unused) {
                serviceConnectionC0178cl = null;
            }
            hashMap.put(str, serviceConnectionC0178cl);
        }
        return this.c.get(str) != null;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock
    public final synchronized void releaseWakeLock(String str) {
        ServiceConnection serviceConnection = (ServiceConnection) this.c.get(str);
        if (serviceConnection != null) {
            C0204dl c0204dl = this.b;
            a(str);
            Context context = this.f970a;
            c0204dl.getClass();
            try {
                context.unbindService(serviceConnection);
            } catch (Throwable unused) {
            }
            ServiceConnection serviceConnection2 = (ServiceConnection) this.c.remove(str);
        }
    }
}
