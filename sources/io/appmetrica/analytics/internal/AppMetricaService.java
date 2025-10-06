package io.appmetrica.analytics.internal;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import io.appmetrica.analytics.impl.A1;
import io.appmetrica.analytics.impl.B5;
import io.appmetrica.analytics.impl.BinderC0698x1;
import io.appmetrica.analytics.impl.C0667vk;
import io.appmetrica.analytics.impl.C0673w1;
import io.appmetrica.analytics.impl.C1;
import io.appmetrica.analytics.impl.D1;
import io.appmetrica.analytics.impl.E1;
import io.appmetrica.analytics.impl.F1;
import io.appmetrica.analytics.impl.G1;
import io.appmetrica.analytics.impl.Ij;
import io.appmetrica.analytics.impl.Jj;
import io.appmetrica.analytics.impl.K1;
import io.appmetrica.analytics.impl.L1;
import io.appmetrica.analytics.impl.Na;
import io.appmetrica.analytics.impl.O1;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class AppMetricaService extends Service {
    private static K1 c;

    /* renamed from: a  reason: collision with root package name */
    private final C0673w1 f1198a = new C0673w1(this);
    private final a b = new a();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IBinder iBinder;
        String action = intent.getAction();
        if (action != null && action.startsWith("io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK")) {
            iBinder = new BinderC0698x1();
        } else {
            iBinder = this.b;
        }
        K1 k1 = c;
        k1.f530a.execute(new E1(k1, intent));
        return iBinder;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        K1 k1 = c;
        k1.f530a.execute(new A1(k1, configuration));
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Na.a(getApplicationContext());
        PublicLogger.init(getApplicationContext());
        K1 k1 = c;
        if (k1 == null) {
            Context applicationContext = getApplicationContext();
            L1 l1 = new L1(applicationContext, this.f1198a, new B5(applicationContext));
            C0667vk c0667vk = Na.F.v;
            O1 o1 = new O1(l1);
            LinkedHashMap linkedHashMap = c0667vk.f1130a;
            Object obj = linkedHashMap.get(1);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(1, obj);
            }
            ((List) obj).add(o1);
            c = new K1(Na.F.d.b(), l1);
        } else {
            k1.b.a(this.f1198a);
        }
        Na na = Na.F;
        Jj jj = new Jj(c);
        synchronized (na) {
            na.f = new Ij(na.f594a, jj);
        }
        c.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        c.onDestroy();
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        K1 k1 = c;
        k1.f530a.execute(new F1(k1, intent));
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        K1 k1 = c;
        k1.f530a.execute(new C1(k1, intent, i));
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        K1 k1 = c;
        k1.f530a.execute(new D1(k1, intent, i, i2));
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        K1 k1 = c;
        k1.f530a.execute(new G1(k1, intent));
        String action = intent.getAction();
        return (action == null || !action.startsWith("io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK")) && intent.getData() != null;
    }
}
