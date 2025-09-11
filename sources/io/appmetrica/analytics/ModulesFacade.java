package io.appmetrica.analytics;

import android.content.Context;
import io.appmetrica.analytics.impl.Bd;
import io.appmetrica.analytics.impl.C0646v0;
import io.appmetrica.analytics.impl.Dd;
import io.appmetrica.analytics.impl.Ed;
import io.appmetrica.analytics.impl.Fd;
import io.appmetrica.analytics.impl.Gd;
import io.appmetrica.analytics.impl.Hd;
import io.appmetrica.analytics.impl.Id;
import io.appmetrica.analytics.impl.Jd;
import io.appmetrica.analytics.impl.Ji;
/* loaded from: classes4.dex */
public final class ModulesFacade {
    public static final int EXTERNAL_ATTRIBUTION_ADJUST = 2;
    public static final int EXTERNAL_ATTRIBUTION_AIRBRIDGE = 5;
    public static final int EXTERNAL_ATTRIBUTION_APPSFLYER = 1;
    public static final int EXTERNAL_ATTRIBUTION_KOCHAVA = 3;
    public static final int EXTERNAL_ATTRIBUTION_SINGULAR = 6;
    public static final int EXTERNAL_ATTRIBUTION_TENJIN = 4;

    /* renamed from: a  reason: collision with root package name */
    private static Jd f200a = new Jd();

    public static IModuleReporter getModuleReporter(Context context, String str) {
        Jd jd = f200a;
        Bd bd = jd.b;
        bd.b.a(context);
        bd.d.a(str);
        jd.c.f625a.a(context.getApplicationContext().getApplicationContext());
        return Ji.f520a.a(context.getApplicationContext(), str);
    }

    public static boolean isActivatedForApp() {
        boolean z;
        Jd jd = f200a;
        jd.b.getClass();
        jd.c.getClass();
        jd.f517a.getClass();
        synchronized (C0646v0.class) {
            z = C0646v0.f;
        }
        return z;
    }

    public static void reportAdRevenue(AdRevenue adRevenue) {
        reportAdRevenue(adRevenue, Boolean.TRUE);
    }

    public static void reportEvent(ModuleEvent moduleEvent) {
        Jd jd = f200a;
        jd.b.f370a.a(null);
        jd.c.getClass();
        jd.d.execute(new Ed(jd, moduleEvent));
    }

    public static void reportExternalAttribution(int i, String str) {
        Jd jd = f200a;
        jd.b.getClass();
        jd.c.getClass();
        jd.d.execute(new Fd(jd, i, str));
    }

    public static void sendEventsBuffer() {
        Jd jd = f200a;
        jd.b.getClass();
        jd.c.getClass();
        AppMetrica.sendEventsBuffer();
    }

    public static void setAdvIdentifiersTracking(boolean z) {
        Jd jd = f200a;
        jd.b.getClass();
        jd.c.getClass();
        jd.d.execute(new Gd(jd, z));
    }

    public static void setProxy(Jd jd) {
        f200a = jd;
    }

    public static void setSessionExtra(String str, byte[] bArr) {
        Jd jd = f200a;
        jd.b.c.a(str);
        jd.c.getClass();
        jd.d.execute(new Hd(jd, str, bArr));
    }

    public static void subscribeForAutoCollectedData(Context context, String str) {
        Jd jd = f200a;
        Bd bd = jd.b;
        bd.b.a(context);
        bd.d.a(str);
        jd.c.f625a.a(context.getApplicationContext());
        jd.d.execute(new Id(str));
    }

    public static void reportAdRevenue(AdRevenue adRevenue, Boolean bool) {
        Jd jd = f200a;
        boolean booleanValue = bool.booleanValue();
        jd.b.getClass();
        jd.c.getClass();
        jd.d.execute(new Dd(jd, adRevenue, booleanValue));
    }
}
