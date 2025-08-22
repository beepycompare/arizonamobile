package io.appmetrica.analytics.internal;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import io.appmetrica.analytics.impl.A1;
import io.appmetrica.analytics.impl.B1;
import io.appmetrica.analytics.impl.BinderC0643v1;
import io.appmetrica.analytics.impl.C0562rk;
import io.appmetrica.analytics.impl.C0618u1;
import io.appmetrica.analytics.impl.C0718y1;
import io.appmetrica.analytics.impl.C0722y5;
import io.appmetrica.analytics.impl.C1;
import io.appmetrica.analytics.impl.D1;
import io.appmetrica.analytics.impl.E1;
import io.appmetrica.analytics.impl.Ej;
import io.appmetrica.analytics.impl.Fj;
import io.appmetrica.analytics.impl.I1;
import io.appmetrica.analytics.impl.J1;
import io.appmetrica.analytics.impl.Ka;
import io.appmetrica.analytics.impl.M1;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class AppMetricaService extends Service {
    private static I1 c;

    /* renamed from: a  reason: collision with root package name */
    private final C0618u1 f1188a = new C0618u1(this);
    private final a b = new a();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IBinder iBinder;
        String action = intent.getAction();
        if (action != null && action.startsWith("io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK")) {
            iBinder = new BinderC0643v1();
        } else {
            iBinder = this.b;
        }
        I1 i1 = c;
        i1.f487a.execute(new C1(i1, intent));
        return iBinder;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        I1 i1 = c;
        i1.f487a.execute(new C0718y1(i1, configuration));
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Ka.a(getApplicationContext());
        PublicLogger.init(getApplicationContext());
        I1 i1 = c;
        if (i1 == null) {
            Context applicationContext = getApplicationContext();
            J1 j1 = new J1(applicationContext, this.f1188a, new C0722y5(applicationContext));
            C0562rk c0562rk = Ka.F.v;
            M1 m1 = new M1(j1);
            LinkedHashMap linkedHashMap = c0562rk.f1048a;
            Object obj = linkedHashMap.get(1);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(1, obj);
            }
            ((List) obj).add(m1);
            c = new I1(Ka.F.d.b(), j1);
        } else {
            i1.b.a(this.f1188a);
        }
        Ka ka = Ka.F;
        Fj fj = new Fj(c);
        synchronized (ka) {
            ka.f = new Ej(ka.f529a, fj);
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
        I1 i1 = c;
        i1.f487a.execute(new D1(i1, intent));
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        I1 i1 = c;
        i1.f487a.execute(new A1(i1, intent, i));
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        I1 i1 = c;
        i1.f487a.execute(new B1(i1, intent, i, i2));
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        I1 i1 = c;
        i1.f487a.execute(new E1(i1, intent));
        String action = intent.getAction();
        return (action == null || !action.startsWith("io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK")) && intent.getData() != null;
    }
}
