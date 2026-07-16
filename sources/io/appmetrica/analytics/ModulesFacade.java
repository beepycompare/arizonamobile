package io.appmetrica.analytics;

import android.content.Context;
import io.appmetrica.analytics.impl.B0;
import io.appmetrica.analytics.impl.Fd;
import io.appmetrica.analytics.impl.Hd;
import io.appmetrica.analytics.impl.Hi;
import io.appmetrica.analytics.impl.Id;
import io.appmetrica.analytics.impl.Jd;
import io.appmetrica.analytics.impl.Kd;
import io.appmetrica.analytics.impl.Ld;
import io.appmetrica.analytics.impl.Md;
import io.appmetrica.analytics.impl.Nd;
/* loaded from: classes5.dex */
public final class ModulesFacade {
    public static final int EXTERNAL_ATTRIBUTION_ADJUST = 2;
    public static final int EXTERNAL_ATTRIBUTION_AIRBRIDGE = 5;
    public static final int EXTERNAL_ATTRIBUTION_APPSFLYER = 1;
    public static final int EXTERNAL_ATTRIBUTION_KOCHAVA = 3;
    public static final int EXTERNAL_ATTRIBUTION_SINGULAR = 6;
    public static final int EXTERNAL_ATTRIBUTION_TENJIN = 4;

    /* renamed from: a  reason: collision with root package name */
    private static Nd f218a = new Nd();

    public static IModuleReporter getModuleReporter(Context context, String str) {
        Nd nd = f218a;
        Fd fd = nd.b;
        fd.b.a(context);
        fd.d.a(str);
        nd.c.f793a.a(context.getApplicationContext().getApplicationContext());
        return Hi.f580a.a(context.getApplicationContext(), str);
    }

    public static boolean isActivatedForApp() {
        Nd nd = f218a;
        nd.b.getClass();
        nd.c.getClass();
        nd.f685a.getClass();
        return B0.a();
    }

    public static void reportAdRevenue(AdRevenue adRevenue) {
        reportAdRevenue(adRevenue, Boolean.TRUE);
    }

    public static void reportEvent(ModuleEvent moduleEvent) {
        Nd nd = f218a;
        nd.b.f547a.a(null);
        nd.c.getClass();
        nd.d.execute(new Id(nd, moduleEvent));
    }

    public static void reportExternalAttribution(int i, String str) {
        Nd nd = f218a;
        nd.b.getClass();
        nd.c.getClass();
        nd.d.execute(new Jd(nd, i, str));
    }

    public static void sendEventsBuffer() {
        Nd nd = f218a;
        nd.b.getClass();
        nd.c.getClass();
        AppMetrica.sendEventsBuffer();
    }

    public static void setAdvIdentifiersTracking(boolean z) {
        Nd nd = f218a;
        nd.b.getClass();
        nd.c.getClass();
        nd.d.execute(new Kd(nd, z));
    }

    public static void setProxy(Nd nd) {
        f218a = nd;
    }

    public static void setSessionExtra(String str, byte[] bArr) {
        Nd nd = f218a;
        nd.b.c.a(str);
        nd.c.getClass();
        nd.d.execute(new Ld(nd, str, bArr));
    }

    public static void subscribeForAutoCollectedData(Context context, String str) {
        Nd nd = f218a;
        Fd fd = nd.b;
        fd.b.a(context);
        fd.d.a(str);
        nd.c.f793a.a(context.getApplicationContext());
        nd.d.execute(new Md(str));
    }

    public static void reportAdRevenue(AdRevenue adRevenue, Boolean bool) {
        Nd nd = f218a;
        boolean booleanValue = bool.booleanValue();
        nd.b.getClass();
        nd.c.getClass();
        nd.d.execute(new Hd(nd, adRevenue, booleanValue));
    }
}
