package io.appmetrica.analytics;

import android.content.Context;
import io.appmetrica.analytics.impl.AbstractC0743yi;
import io.appmetrica.analytics.impl.Ad;
import io.appmetrica.analytics.impl.Bd;
import io.appmetrica.analytics.impl.C0600t0;
import io.appmetrica.analytics.impl.C0638ud;
import io.appmetrica.analytics.impl.C0688wd;
import io.appmetrica.analytics.impl.C0713xd;
import io.appmetrica.analytics.impl.C0738yd;
import io.appmetrica.analytics.impl.C0763zd;
/* loaded from: classes4.dex */
public final class ModulesFacade {
    public static final int EXTERNAL_ATTRIBUTION_ADJUST = 2;
    public static final int EXTERNAL_ATTRIBUTION_AIRBRIDGE = 5;
    public static final int EXTERNAL_ATTRIBUTION_APPSFLYER = 1;
    public static final int EXTERNAL_ATTRIBUTION_KOCHAVA = 3;
    public static final int EXTERNAL_ATTRIBUTION_SINGULAR = 6;
    public static final int EXTERNAL_ATTRIBUTION_TENJIN = 4;

    /* renamed from: a  reason: collision with root package name */
    private static Bd f200a = new Bd();

    public static IModuleReporter getModuleReporter(Context context, String str) {
        Bd bd = f200a;
        C0638ud c0638ud = bd.b;
        c0638ud.b.a(context);
        c0638ud.d.a(str);
        bd.c.f461a.a(context.getApplicationContext().getApplicationContext());
        return AbstractC0743yi.f1147a.a(context.getApplicationContext(), str);
    }

    public static boolean isActivatedForApp() {
        boolean z;
        Bd bd = f200a;
        bd.b.getClass();
        bd.c.getClass();
        bd.f354a.getClass();
        synchronized (C0600t0.class) {
            z = C0600t0.f;
        }
        return z;
    }

    public static void reportAdRevenue(AdRevenue adRevenue) {
        reportAdRevenue(adRevenue, Boolean.TRUE);
    }

    public static void reportEvent(ModuleEvent moduleEvent) {
        Bd bd = f200a;
        bd.b.f1075a.a(null);
        bd.c.getClass();
        bd.d.execute(new C0713xd(bd, moduleEvent));
    }

    public static void reportExternalAttribution(int i, String str) {
        Bd bd = f200a;
        bd.b.getClass();
        bd.c.getClass();
        bd.d.execute(new C0738yd(bd, i, str));
    }

    public static void sendEventsBuffer() {
        Bd bd = f200a;
        bd.b.getClass();
        bd.c.getClass();
        AppMetrica.sendEventsBuffer();
    }

    public static void setAdvIdentifiersTracking(boolean z) {
        Bd bd = f200a;
        bd.b.getClass();
        bd.c.getClass();
        bd.d.execute(new C0763zd(bd, z));
    }

    public static void setProxy(Bd bd) {
        f200a = bd;
    }

    public static void setSessionExtra(String str, byte[] bArr) {
        Bd bd = f200a;
        bd.b.c.a(str);
        bd.c.getClass();
        bd.d.execute(new Ad(bd, str, bArr));
    }

    public static void reportAdRevenue(AdRevenue adRevenue, Boolean bool) {
        Bd bd = f200a;
        boolean booleanValue = bool.booleanValue();
        bd.b.getClass();
        bd.c.getClass();
        bd.d.execute(new C0688wd(bd, adRevenue, booleanValue));
    }
}
