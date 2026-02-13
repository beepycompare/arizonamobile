package io.appmetrica.analytics;

import android.content.Context;
import io.appmetrica.analytics.impl.AbstractC0457ni;
import io.appmetrica.analytics.impl.C0248fd;
import io.appmetrica.analytics.impl.C0300hd;
import io.appmetrica.analytics.impl.C0326id;
import io.appmetrica.analytics.impl.C0351jd;
import io.appmetrica.analytics.impl.C0377kd;
import io.appmetrica.analytics.impl.C0402ld;
import io.appmetrica.analytics.impl.C0427md;
import io.appmetrica.analytics.impl.C0452nd;
import io.appmetrica.analytics.impl.C0738z0;
/* loaded from: classes2.dex */
public final class ModulesFacade {
    public static final int EXTERNAL_ATTRIBUTION_ADJUST = 2;
    public static final int EXTERNAL_ATTRIBUTION_AIRBRIDGE = 5;
    public static final int EXTERNAL_ATTRIBUTION_APPSFLYER = 1;
    public static final int EXTERNAL_ATTRIBUTION_KOCHAVA = 3;
    public static final int EXTERNAL_ATTRIBUTION_SINGULAR = 6;
    public static final int EXTERNAL_ATTRIBUTION_TENJIN = 4;

    /* renamed from: a  reason: collision with root package name */
    private static C0452nd f283a = new C0452nd();

    public static IModuleReporter getModuleReporter(Context context, String str) {
        C0452nd c0452nd = f283a;
        C0248fd c0248fd = c0452nd.b;
        c0248fd.b.a(context);
        c0248fd.d.a(str);
        c0452nd.c.f1255a.a(context.getApplicationContext().getApplicationContext());
        return AbstractC0457ni.f1138a.a(context.getApplicationContext(), str);
    }

    public static boolean isActivatedForApp() {
        C0452nd c0452nd = f283a;
        c0452nd.b.getClass();
        c0452nd.c.getClass();
        c0452nd.f1134a.getClass();
        return C0738z0.a();
    }

    public static void reportAdRevenue(AdRevenue adRevenue) {
        reportAdRevenue(adRevenue, Boolean.TRUE);
    }

    public static void reportEvent(ModuleEvent moduleEvent) {
        C0452nd c0452nd = f283a;
        c0452nd.b.f993a.a(null);
        c0452nd.c.getClass();
        c0452nd.d.execute(new C0326id(c0452nd, moduleEvent));
    }

    public static void reportExternalAttribution(int i, String str) {
        C0452nd c0452nd = f283a;
        c0452nd.b.getClass();
        c0452nd.c.getClass();
        c0452nd.d.execute(new C0351jd(c0452nd, i, str));
    }

    public static void sendEventsBuffer() {
        C0452nd c0452nd = f283a;
        c0452nd.b.getClass();
        c0452nd.c.getClass();
        AppMetrica.sendEventsBuffer();
    }

    public static void setAdvIdentifiersTracking(boolean z) {
        C0452nd c0452nd = f283a;
        c0452nd.b.getClass();
        c0452nd.c.getClass();
        c0452nd.d.execute(new C0377kd(c0452nd, z));
    }

    public static void setProxy(C0452nd c0452nd) {
        f283a = c0452nd;
    }

    public static void setSessionExtra(String str, byte[] bArr) {
        C0452nd c0452nd = f283a;
        c0452nd.b.c.a(str);
        c0452nd.c.getClass();
        c0452nd.d.execute(new C0402ld(c0452nd, str, bArr));
    }

    public static void subscribeForAutoCollectedData(Context context, String str) {
        C0452nd c0452nd = f283a;
        C0248fd c0248fd = c0452nd.b;
        c0248fd.b.a(context);
        c0248fd.d.a(str);
        c0452nd.c.f1255a.a(context.getApplicationContext());
        c0452nd.d.execute(new C0427md(str));
    }

    public static void reportAdRevenue(AdRevenue adRevenue, Boolean bool) {
        C0452nd c0452nd = f283a;
        boolean booleanValue = bool.booleanValue();
        c0452nd.b.getClass();
        c0452nd.c.getClass();
        c0452nd.d.execute(new C0300hd(c0452nd, adRevenue, booleanValue));
    }
}
