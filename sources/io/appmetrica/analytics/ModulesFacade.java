package io.appmetrica.analytics;

import android.content.Context;
import io.appmetrica.analytics.impl.AbstractC0735yi;
import io.appmetrica.analytics.impl.Ad;
import io.appmetrica.analytics.impl.Bd;
import io.appmetrica.analytics.impl.C0592t0;
import io.appmetrica.analytics.impl.C0630ud;
import io.appmetrica.analytics.impl.C0680wd;
import io.appmetrica.analytics.impl.C0705xd;
import io.appmetrica.analytics.impl.C0730yd;
import io.appmetrica.analytics.impl.C0755zd;
/* loaded from: classes4.dex */
public final class ModulesFacade {
    public static final int EXTERNAL_ATTRIBUTION_ADJUST = 2;
    public static final int EXTERNAL_ATTRIBUTION_AIRBRIDGE = 5;
    public static final int EXTERNAL_ATTRIBUTION_APPSFLYER = 1;
    public static final int EXTERNAL_ATTRIBUTION_KOCHAVA = 3;
    public static final int EXTERNAL_ATTRIBUTION_SINGULAR = 6;
    public static final int EXTERNAL_ATTRIBUTION_TENJIN = 4;

    /* renamed from: a  reason: collision with root package name */
    private static Bd f201a = new Bd();

    public static IModuleReporter getModuleReporter(Context context, String str) {
        Bd bd = f201a;
        C0630ud c0630ud = bd.b;
        c0630ud.b.a(context);
        c0630ud.d.a(str);
        bd.c.f462a.a(context.getApplicationContext().getApplicationContext());
        return AbstractC0735yi.f1148a.a(context.getApplicationContext(), str);
    }

    public static boolean isActivatedForApp() {
        boolean z;
        Bd bd = f201a;
        bd.b.getClass();
        bd.c.getClass();
        bd.f355a.getClass();
        synchronized (C0592t0.class) {
            z = C0592t0.f;
        }
        return z;
    }

    public static void reportAdRevenue(AdRevenue adRevenue) {
        reportAdRevenue(adRevenue, Boolean.TRUE);
    }

    public static void reportEvent(ModuleEvent moduleEvent) {
        Bd bd = f201a;
        bd.b.f1076a.a(null);
        bd.c.getClass();
        bd.d.execute(new C0705xd(bd, moduleEvent));
    }

    public static void reportExternalAttribution(int i, String str) {
        Bd bd = f201a;
        bd.b.getClass();
        bd.c.getClass();
        bd.d.execute(new C0730yd(bd, i, str));
    }

    public static void sendEventsBuffer() {
        Bd bd = f201a;
        bd.b.getClass();
        bd.c.getClass();
        AppMetrica.sendEventsBuffer();
    }

    public static void setAdvIdentifiersTracking(boolean z) {
        Bd bd = f201a;
        bd.b.getClass();
        bd.c.getClass();
        bd.d.execute(new C0755zd(bd, z));
    }

    public static void setProxy(Bd bd) {
        f201a = bd;
    }

    public static void setSessionExtra(String str, byte[] bArr) {
        Bd bd = f201a;
        bd.b.c.a(str);
        bd.c.getClass();
        bd.d.execute(new Ad(bd, str, bArr));
    }

    public static void reportAdRevenue(AdRevenue adRevenue, Boolean bool) {
        Bd bd = f201a;
        boolean booleanValue = bool.booleanValue();
        bd.b.getClass();
        bd.c.getClass();
        bd.d.execute(new C0680wd(bd, adRevenue, booleanValue));
    }
}
