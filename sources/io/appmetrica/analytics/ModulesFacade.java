package io.appmetrica.analytics;

import android.content.Context;
import io.appmetrica.analytics.impl.AbstractC0478oi;
import io.appmetrica.analytics.impl.C0269gd;
import io.appmetrica.analytics.impl.C0321id;
import io.appmetrica.analytics.impl.C0346jd;
import io.appmetrica.analytics.impl.C0372kd;
import io.appmetrica.analytics.impl.C0398ld;
import io.appmetrica.analytics.impl.C0423md;
import io.appmetrica.analytics.impl.C0448nd;
import io.appmetrica.analytics.impl.C0473od;
import io.appmetrica.analytics.impl.C0734z0;
/* loaded from: classes3.dex */
public final class ModulesFacade {
    public static final int EXTERNAL_ATTRIBUTION_ADJUST = 2;
    public static final int EXTERNAL_ATTRIBUTION_AIRBRIDGE = 5;
    public static final int EXTERNAL_ATTRIBUTION_APPSFLYER = 1;
    public static final int EXTERNAL_ATTRIBUTION_KOCHAVA = 3;
    public static final int EXTERNAL_ATTRIBUTION_SINGULAR = 6;
    public static final int EXTERNAL_ATTRIBUTION_TENJIN = 4;

    /* renamed from: a  reason: collision with root package name */
    private static C0473od f283a = new C0473od();

    public static IModuleReporter getModuleReporter(Context context, String str) {
        C0473od c0473od = f283a;
        C0269gd c0269gd = c0473od.b;
        c0269gd.b.a(context);
        c0269gd.d.a(str);
        c0473od.c.f1265a.a(context.getApplicationContext().getApplicationContext());
        return AbstractC0478oi.f1148a.a(context.getApplicationContext(), str);
    }

    public static boolean isActivatedForApp() {
        C0473od c0473od = f283a;
        c0473od.b.getClass();
        c0473od.c.getClass();
        c0473od.f1144a.getClass();
        return C0734z0.a();
    }

    public static void reportAdRevenue(AdRevenue adRevenue) {
        reportAdRevenue(adRevenue, Boolean.TRUE);
    }

    public static void reportEvent(ModuleEvent moduleEvent) {
        C0473od c0473od = f283a;
        c0473od.b.f1002a.a(null);
        c0473od.c.getClass();
        c0473od.d.execute(new C0346jd(c0473od, moduleEvent));
    }

    public static void reportExternalAttribution(int i, String str) {
        C0473od c0473od = f283a;
        c0473od.b.getClass();
        c0473od.c.getClass();
        c0473od.d.execute(new C0372kd(c0473od, i, str));
    }

    public static void sendEventsBuffer() {
        C0473od c0473od = f283a;
        c0473od.b.getClass();
        c0473od.c.getClass();
        AppMetrica.sendEventsBuffer();
    }

    public static void setAdvIdentifiersTracking(boolean z) {
        C0473od c0473od = f283a;
        c0473od.b.getClass();
        c0473od.c.getClass();
        c0473od.d.execute(new C0398ld(c0473od, z));
    }

    public static void setProxy(C0473od c0473od) {
        f283a = c0473od;
    }

    public static void setSessionExtra(String str, byte[] bArr) {
        C0473od c0473od = f283a;
        c0473od.b.c.a(str);
        c0473od.c.getClass();
        c0473od.d.execute(new C0423md(c0473od, str, bArr));
    }

    public static void subscribeForAutoCollectedData(Context context, String str) {
        C0473od c0473od = f283a;
        C0269gd c0269gd = c0473od.b;
        c0269gd.b.a(context);
        c0269gd.d.a(str);
        c0473od.c.f1265a.a(context.getApplicationContext());
        c0473od.d.execute(new C0448nd(str));
    }

    public static void reportAdRevenue(AdRevenue adRevenue, Boolean bool) {
        C0473od c0473od = f283a;
        boolean booleanValue = bool.booleanValue();
        c0473od.b.getClass();
        c0473od.c.getClass();
        c0473od.d.execute(new C0321id(c0473od, adRevenue, booleanValue));
    }
}
