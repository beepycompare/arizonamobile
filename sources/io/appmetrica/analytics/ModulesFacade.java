package io.appmetrica.analytics;

import android.content.Context;
import io.appmetrica.analytics.impl.AbstractC0578si;
import io.appmetrica.analytics.impl.C0424md;
import io.appmetrica.analytics.impl.C0474od;
import io.appmetrica.analytics.impl.C0499pd;
import io.appmetrica.analytics.impl.C0524qd;
import io.appmetrica.analytics.impl.C0548rd;
import io.appmetrica.analytics.impl.C0573sd;
import io.appmetrica.analytics.impl.C0598td;
import io.appmetrica.analytics.impl.C0623ud;
import io.appmetrica.analytics.impl.C0685x0;
/* loaded from: classes.dex */
public final class ModulesFacade {
    public static final int EXTERNAL_ATTRIBUTION_ADJUST = 2;
    public static final int EXTERNAL_ATTRIBUTION_AIRBRIDGE = 5;
    public static final int EXTERNAL_ATTRIBUTION_APPSFLYER = 1;
    public static final int EXTERNAL_ATTRIBUTION_KOCHAVA = 3;
    public static final int EXTERNAL_ATTRIBUTION_SINGULAR = 6;
    public static final int EXTERNAL_ATTRIBUTION_TENJIN = 4;

    /* renamed from: a  reason: collision with root package name */
    private static C0623ud f186a = new C0623ud();

    public static IModuleReporter getModuleReporter(Context context, String str) {
        C0623ud c0623ud = f186a;
        C0424md c0424md = c0623ud.b;
        c0424md.b.a(context);
        c0424md.d.a(str);
        c0623ud.c.f412a.a(context.getApplicationContext().getApplicationContext());
        return AbstractC0578si.f1115a.a(context.getApplicationContext(), str);
    }

    public static boolean isActivatedForApp() {
        C0623ud c0623ud = f186a;
        c0623ud.b.getClass();
        c0623ud.c.getClass();
        c0623ud.f1150a.getClass();
        return C0685x0.a();
    }

    public static void reportAdRevenue(AdRevenue adRevenue) {
        reportAdRevenue(adRevenue, Boolean.TRUE);
    }

    public static void reportEvent(ModuleEvent moduleEvent) {
        C0623ud c0623ud = f186a;
        c0623ud.b.f1008a.a(null);
        c0623ud.c.getClass();
        c0623ud.d.execute(new C0499pd(c0623ud, moduleEvent));
    }

    public static void reportExternalAttribution(int i, String str) {
        C0623ud c0623ud = f186a;
        c0623ud.b.getClass();
        c0623ud.c.getClass();
        c0623ud.d.execute(new C0524qd(c0623ud, i, str));
    }

    public static void sendEventsBuffer() {
        C0623ud c0623ud = f186a;
        c0623ud.b.getClass();
        c0623ud.c.getClass();
        AppMetrica.sendEventsBuffer();
    }

    public static void setAdvIdentifiersTracking(boolean z) {
        C0623ud c0623ud = f186a;
        c0623ud.b.getClass();
        c0623ud.c.getClass();
        c0623ud.d.execute(new C0548rd(c0623ud, z));
    }

    public static void setProxy(C0623ud c0623ud) {
        f186a = c0623ud;
    }

    public static void setSessionExtra(String str, byte[] bArr) {
        C0623ud c0623ud = f186a;
        c0623ud.b.c.a(str);
        c0623ud.c.getClass();
        c0623ud.d.execute(new C0573sd(c0623ud, str, bArr));
    }

    public static void subscribeForAutoCollectedData(Context context, String str) {
        C0623ud c0623ud = f186a;
        C0424md c0424md = c0623ud.b;
        c0424md.b.a(context);
        c0424md.d.a(str);
        c0623ud.c.f412a.a(context.getApplicationContext());
        c0623ud.d.execute(new C0598td(str));
    }

    public static void reportAdRevenue(AdRevenue adRevenue, Boolean bool) {
        C0623ud c0623ud = f186a;
        boolean booleanValue = bool.booleanValue();
        c0623ud.b.getClass();
        c0623ud.c.getClass();
        c0623ud.d.execute(new C0474od(c0623ud, adRevenue, booleanValue));
    }
}
