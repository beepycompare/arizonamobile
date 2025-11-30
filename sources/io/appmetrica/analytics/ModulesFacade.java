package io.appmetrica.analytics;

import android.content.Context;
import io.appmetrica.analytics.impl.AbstractC0479oi;
import io.appmetrica.analytics.impl.C0270gd;
import io.appmetrica.analytics.impl.C0322id;
import io.appmetrica.analytics.impl.C0347jd;
import io.appmetrica.analytics.impl.C0373kd;
import io.appmetrica.analytics.impl.C0399ld;
import io.appmetrica.analytics.impl.C0424md;
import io.appmetrica.analytics.impl.C0449nd;
import io.appmetrica.analytics.impl.C0474od;
import io.appmetrica.analytics.impl.C0735z0;
/* loaded from: classes2.dex */
public final class ModulesFacade {
    public static final int EXTERNAL_ATTRIBUTION_ADJUST = 2;
    public static final int EXTERNAL_ATTRIBUTION_AIRBRIDGE = 5;
    public static final int EXTERNAL_ATTRIBUTION_APPSFLYER = 1;
    public static final int EXTERNAL_ATTRIBUTION_KOCHAVA = 3;
    public static final int EXTERNAL_ATTRIBUTION_SINGULAR = 6;
    public static final int EXTERNAL_ATTRIBUTION_TENJIN = 4;

    /* renamed from: a  reason: collision with root package name */
    private static C0474od f186a = new C0474od();

    public static IModuleReporter getModuleReporter(Context context, String str) {
        C0474od c0474od = f186a;
        C0270gd c0270gd = c0474od.b;
        c0270gd.b.a(context);
        c0270gd.d.a(str);
        c0474od.c.f1168a.a(context.getApplicationContext().getApplicationContext());
        return AbstractC0479oi.f1051a.a(context.getApplicationContext(), str);
    }

    public static boolean isActivatedForApp() {
        C0474od c0474od = f186a;
        c0474od.b.getClass();
        c0474od.c.getClass();
        c0474od.f1047a.getClass();
        return C0735z0.a();
    }

    public static void reportAdRevenue(AdRevenue adRevenue) {
        reportAdRevenue(adRevenue, Boolean.TRUE);
    }

    public static void reportEvent(ModuleEvent moduleEvent) {
        C0474od c0474od = f186a;
        c0474od.b.f905a.a(null);
        c0474od.c.getClass();
        c0474od.d.execute(new C0347jd(c0474od, moduleEvent));
    }

    public static void reportExternalAttribution(int i, String str) {
        C0474od c0474od = f186a;
        c0474od.b.getClass();
        c0474od.c.getClass();
        c0474od.d.execute(new C0373kd(c0474od, i, str));
    }

    public static void sendEventsBuffer() {
        C0474od c0474od = f186a;
        c0474od.b.getClass();
        c0474od.c.getClass();
        AppMetrica.sendEventsBuffer();
    }

    public static void setAdvIdentifiersTracking(boolean z) {
        C0474od c0474od = f186a;
        c0474od.b.getClass();
        c0474od.c.getClass();
        c0474od.d.execute(new C0399ld(c0474od, z));
    }

    public static void setProxy(C0474od c0474od) {
        f186a = c0474od;
    }

    public static void setSessionExtra(String str, byte[] bArr) {
        C0474od c0474od = f186a;
        c0474od.b.c.a(str);
        c0474od.c.getClass();
        c0474od.d.execute(new C0424md(c0474od, str, bArr));
    }

    public static void subscribeForAutoCollectedData(Context context, String str) {
        C0474od c0474od = f186a;
        C0270gd c0270gd = c0474od.b;
        c0270gd.b.a(context);
        c0270gd.d.a(str);
        c0474od.c.f1168a.a(context.getApplicationContext());
        c0474od.d.execute(new C0449nd(str));
    }

    public static void reportAdRevenue(AdRevenue adRevenue, Boolean bool) {
        C0474od c0474od = f186a;
        boolean booleanValue = bool.booleanValue();
        c0474od.b.getClass();
        c0474od.c.getClass();
        c0474od.d.execute(new C0322id(c0474od, adRevenue, booleanValue));
    }
}
