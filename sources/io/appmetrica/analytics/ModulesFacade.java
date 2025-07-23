package io.appmetrica.analytics;

import android.content.Context;
import io.appmetrica.analytics.impl.Ad;
import io.appmetrica.analytics.impl.Ai;
import io.appmetrica.analytics.impl.Bd;
import io.appmetrica.analytics.impl.C0594t0;
import io.appmetrica.analytics.impl.C0682wd;
import io.appmetrica.analytics.impl.C0732yd;
import io.appmetrica.analytics.impl.C0757zd;
import io.appmetrica.analytics.impl.Cd;
import io.appmetrica.analytics.impl.Dd;
/* loaded from: classes4.dex */
public final class ModulesFacade {
    public static final int EXTERNAL_ATTRIBUTION_ADJUST = 2;
    public static final int EXTERNAL_ATTRIBUTION_AIRBRIDGE = 5;
    public static final int EXTERNAL_ATTRIBUTION_APPSFLYER = 1;
    public static final int EXTERNAL_ATTRIBUTION_KOCHAVA = 3;
    public static final int EXTERNAL_ATTRIBUTION_SINGULAR = 6;
    public static final int EXTERNAL_ATTRIBUTION_TENJIN = 4;

    /* renamed from: a  reason: collision with root package name */
    private static Dd f201a = new Dd();

    public static IModuleReporter getModuleReporter(Context context, String str) {
        Dd dd = f201a;
        C0682wd c0682wd = dd.b;
        c0682wd.b.a(context);
        c0682wd.d.a(str);
        dd.c.f506a.a(context.getApplicationContext().getApplicationContext());
        return Ai.f340a.a(context.getApplicationContext(), str);
    }

    public static boolean isActivatedForApp() {
        boolean z;
        Dd dd = f201a;
        dd.b.getClass();
        dd.c.getClass();
        dd.f396a.getClass();
        synchronized (C0594t0.class) {
            z = C0594t0.f;
        }
        return z;
    }

    public static void reportAdRevenue(AdRevenue adRevenue) {
        reportAdRevenue(adRevenue, Boolean.TRUE);
    }

    public static void reportEvent(ModuleEvent moduleEvent) {
        Dd dd = f201a;
        dd.b.f1121a.a(null);
        dd.c.getClass();
        dd.d.execute(new C0757zd(dd, moduleEvent));
    }

    public static void reportExternalAttribution(int i, String str) {
        Dd dd = f201a;
        dd.b.getClass();
        dd.c.getClass();
        dd.d.execute(new Ad(dd, i, str));
    }

    public static void sendEventsBuffer() {
        Dd dd = f201a;
        dd.b.getClass();
        dd.c.getClass();
        AppMetrica.sendEventsBuffer();
    }

    public static void setAdvIdentifiersTracking(boolean z) {
        Dd dd = f201a;
        dd.b.getClass();
        dd.c.getClass();
        dd.d.execute(new Bd(dd, z));
    }

    public static void setProxy(Dd dd) {
        f201a = dd;
    }

    public static void setSessionExtra(String str, byte[] bArr) {
        Dd dd = f201a;
        dd.b.c.a(str);
        dd.c.getClass();
        dd.d.execute(new Cd(dd, str, bArr));
    }

    public static void reportAdRevenue(AdRevenue adRevenue, Boolean bool) {
        Dd dd = f201a;
        boolean booleanValue = bool.booleanValue();
        dd.b.getClass();
        dd.c.getClass();
        dd.d.execute(new C0732yd(dd, adRevenue, booleanValue));
    }
}
