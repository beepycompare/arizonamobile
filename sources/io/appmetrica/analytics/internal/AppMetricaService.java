package io.appmetrica.analytics.internal;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import io.appmetrica.analytics.impl.B1;
import io.appmetrica.analytics.impl.BinderC0711y1;
import io.appmetrica.analytics.impl.C0354jk;
import io.appmetrica.analytics.impl.C0365k5;
import io.appmetrica.analytics.impl.C0554rj;
import io.appmetrica.analytics.impl.C0579sj;
import io.appmetrica.analytics.impl.C0620ua;
import io.appmetrica.analytics.impl.C0686x1;
import io.appmetrica.analytics.impl.D1;
import io.appmetrica.analytics.impl.E1;
import io.appmetrica.analytics.impl.F1;
import io.appmetrica.analytics.impl.G1;
import io.appmetrica.analytics.impl.H1;
import io.appmetrica.analytics.impl.L1;
import io.appmetrica.analytics.impl.M1;
import io.appmetrica.analytics.impl.P1;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class AppMetricaService extends Service {
    private static L1 c;

    /* renamed from: a  reason: collision with root package name */
    private final C0686x1 f1239a = new C0686x1(this);
    private final a b = new a();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IBinder iBinder;
        String action = intent.getAction();
        if (action != null && action.startsWith("io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK")) {
            iBinder = new BinderC0711y1();
        } else {
            iBinder = this.b;
        }
        L1 l1 = c;
        l1.f567a.execute(new F1(l1, intent));
        return iBinder;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        L1 l1 = c;
        l1.f567a.execute(new B1(l1, configuration));
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        C0620ua.a(getApplicationContext());
        PublicLogger.init(getApplicationContext());
        L1 l1 = c;
        if (l1 == null) {
            Context applicationContext = getApplicationContext();
            M1 m1 = new M1(applicationContext, this.f1239a, new C0365k5(applicationContext));
            C0354jk c0354jk = C0620ua.H.v;
            P1 p1 = new P1(m1);
            LinkedHashMap linkedHashMap = c0354jk.f957a;
            Object obj = linkedHashMap.get(1);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(1, obj);
            }
            ((List) obj).add(p1);
            c = new L1(C0620ua.H.d.b(), m1);
        } else {
            l1.b.a(this.f1239a);
        }
        C0620ua c0620ua = C0620ua.H;
        C0579sj c0579sj = new C0579sj(c);
        synchronized (c0620ua) {
            c0620ua.f = new C0554rj(c0620ua.f1149a, c0579sj);
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
        L1 l1 = c;
        l1.f567a.execute(new G1(l1, intent));
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        L1 l1 = c;
        l1.f567a.execute(new D1(l1, intent, i));
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        L1 l1 = c;
        l1.f567a.execute(new E1(l1, intent, i, i2));
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        L1 l1 = c;
        l1.f567a.execute(new H1(l1, intent));
        String action = intent.getAction();
        return (action == null || !action.startsWith("io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK")) && intent.getData() != null;
    }
}
