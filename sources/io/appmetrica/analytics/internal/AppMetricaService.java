package io.appmetrica.analytics.internal;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import io.appmetrica.analytics.impl.A1;
import io.appmetrica.analytics.impl.B1;
import io.appmetrica.analytics.impl.BinderC0651v1;
import io.appmetrica.analytics.impl.C0371jk;
import io.appmetrica.analytics.impl.C0626u1;
import io.appmetrica.analytics.impl.C0694wj;
import io.appmetrica.analytics.impl.C0719xj;
import io.appmetrica.analytics.impl.C0726y1;
import io.appmetrica.analytics.impl.C0730y5;
import io.appmetrica.analytics.impl.C1;
import io.appmetrica.analytics.impl.D1;
import io.appmetrica.analytics.impl.E1;
import io.appmetrica.analytics.impl.Ga;
import io.appmetrica.analytics.impl.I1;
import io.appmetrica.analytics.impl.J1;
import io.appmetrica.analytics.impl.M1;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class AppMetricaService extends Service {
    private static I1 c;

    /* renamed from: a  reason: collision with root package name */
    private final C0626u1 f1174a = new C0626u1(this);
    private final a b = new a();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IBinder iBinder;
        String action = intent.getAction();
        if (action != null && action.startsWith("io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK")) {
            iBinder = new BinderC0651v1();
        } else {
            iBinder = this.b;
        }
        I1 i1 = c;
        i1.f467a.execute(new C1(i1, intent));
        return iBinder;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        I1 i1 = c;
        i1.f467a.execute(new C0726y1(i1, configuration));
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Ga.a(getApplicationContext());
        PublicLogger.init(getApplicationContext());
        I1 i1 = c;
        if (i1 == null) {
            Context applicationContext = getApplicationContext();
            J1 j1 = new J1(applicationContext, this.f1174a, new C0730y5(applicationContext));
            C0371jk c0371jk = Ga.F.v;
            M1 m1 = new M1(j1);
            LinkedHashMap linkedHashMap = c0371jk.f894a;
            Object obj = linkedHashMap.get(1);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(1, obj);
            }
            ((List) obj).add(m1);
            c = new I1(Ga.F.d.b(), j1);
        } else {
            i1.b.a(this.f1174a);
        }
        Ga ga = Ga.F;
        C0719xj c0719xj = new C0719xj(c);
        synchronized (ga) {
            ga.f = new C0694wj(ga.f443a, c0719xj);
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
        i1.f467a.execute(new D1(i1, intent));
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        I1 i1 = c;
        i1.f467a.execute(new A1(i1, intent, i));
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        I1 i1 = c;
        i1.f467a.execute(new B1(i1, intent, i, i2));
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        I1 i1 = c;
        i1.f467a.execute(new E1(i1, intent));
        String action = intent.getAction();
        return (action == null || !action.startsWith("io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK")) && intent.getData() != null;
    }
}
