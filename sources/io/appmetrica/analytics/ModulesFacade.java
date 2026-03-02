package io.appmetrica.analytics;

import android.content.Context;
import io.appmetrica.analytics.impl.AbstractC0456ni;
import io.appmetrica.analytics.impl.C0247fd;
import io.appmetrica.analytics.impl.C0299hd;
import io.appmetrica.analytics.impl.C0325id;
import io.appmetrica.analytics.impl.C0350jd;
import io.appmetrica.analytics.impl.C0376kd;
import io.appmetrica.analytics.impl.C0401ld;
import io.appmetrica.analytics.impl.C0426md;
import io.appmetrica.analytics.impl.C0451nd;
import io.appmetrica.analytics.impl.C0737z0;
/* loaded from: classes3.dex */
public final class ModulesFacade {
    public static final int EXTERNAL_ATTRIBUTION_ADJUST = 2;
    public static final int EXTERNAL_ATTRIBUTION_AIRBRIDGE = 5;
    public static final int EXTERNAL_ATTRIBUTION_APPSFLYER = 1;
    public static final int EXTERNAL_ATTRIBUTION_KOCHAVA = 3;
    public static final int EXTERNAL_ATTRIBUTION_SINGULAR = 6;
    public static final int EXTERNAL_ATTRIBUTION_TENJIN = 4;

    /* renamed from: a  reason: collision with root package name */
    private static C0451nd f283a = new C0451nd();

    public static IModuleReporter getModuleReporter(Context context, String str) {
        C0451nd c0451nd = f283a;
        C0247fd c0247fd = c0451nd.b;
        c0247fd.b.a(context);
        c0247fd.d.a(str);
        c0451nd.c.f1255a.a(context.getApplicationContext().getApplicationContext());
        return AbstractC0456ni.f1138a.a(context.getApplicationContext(), str);
    }

    public static boolean isActivatedForApp() {
        C0451nd c0451nd = f283a;
        c0451nd.b.getClass();
        c0451nd.c.getClass();
        c0451nd.f1134a.getClass();
        return C0737z0.a();
    }

    public static void reportAdRevenue(AdRevenue adRevenue) {
        reportAdRevenue(adRevenue, Boolean.TRUE);
    }

    public static void reportEvent(ModuleEvent moduleEvent) {
        C0451nd c0451nd = f283a;
        c0451nd.b.f993a.a(null);
        c0451nd.c.getClass();
        c0451nd.d.execute(new C0325id(c0451nd, moduleEvent));
    }

    public static void reportExternalAttribution(int i, String str) {
        C0451nd c0451nd = f283a;
        c0451nd.b.getClass();
        c0451nd.c.getClass();
        c0451nd.d.execute(new C0350jd(c0451nd, i, str));
    }

    public static void sendEventsBuffer() {
        C0451nd c0451nd = f283a;
        c0451nd.b.getClass();
        c0451nd.c.getClass();
        AppMetrica.sendEventsBuffer();
    }

    public static void setAdvIdentifiersTracking(boolean z) {
        C0451nd c0451nd = f283a;
        c0451nd.b.getClass();
        c0451nd.c.getClass();
        c0451nd.d.execute(new C0376kd(c0451nd, z));
    }

    public static void setProxy(C0451nd c0451nd) {
        f283a = c0451nd;
    }

    public static void setSessionExtra(String str, byte[] bArr) {
        C0451nd c0451nd = f283a;
        c0451nd.b.c.a(str);
        c0451nd.c.getClass();
        c0451nd.d.execute(new C0401ld(c0451nd, str, bArr));
    }

    public static void subscribeForAutoCollectedData(Context context, String str) {
        C0451nd c0451nd = f283a;
        C0247fd c0247fd = c0451nd.b;
        c0247fd.b.a(context);
        c0247fd.d.a(str);
        c0451nd.c.f1255a.a(context.getApplicationContext());
        c0451nd.d.execute(new C0426md(str));
    }

    public static void reportAdRevenue(AdRevenue adRevenue, Boolean bool) {
        C0451nd c0451nd = f283a;
        boolean booleanValue = bool.booleanValue();
        c0451nd.b.getClass();
        c0451nd.c.getClass();
        c0451nd.d.execute(new C0299hd(c0451nd, adRevenue, booleanValue));
    }
}
