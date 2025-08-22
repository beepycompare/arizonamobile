package io.appmetrica.analytics;

import android.content.Context;
import io.appmetrica.analytics.impl.Ad;
import io.appmetrica.analytics.impl.Bd;
import io.appmetrica.analytics.impl.C0592t0;
import io.appmetrica.analytics.impl.C0730yd;
import io.appmetrica.analytics.impl.Cd;
import io.appmetrica.analytics.impl.Dd;
import io.appmetrica.analytics.impl.Ed;
import io.appmetrica.analytics.impl.Fd;
import io.appmetrica.analytics.impl.Fi;
/* loaded from: classes4.dex */
public final class ModulesFacade {
    public static final int EXTERNAL_ATTRIBUTION_ADJUST = 2;
    public static final int EXTERNAL_ATTRIBUTION_AIRBRIDGE = 5;
    public static final int EXTERNAL_ATTRIBUTION_APPSFLYER = 1;
    public static final int EXTERNAL_ATTRIBUTION_KOCHAVA = 3;
    public static final int EXTERNAL_ATTRIBUTION_SINGULAR = 6;
    public static final int EXTERNAL_ATTRIBUTION_TENJIN = 4;

    /* renamed from: a  reason: collision with root package name */
    private static Fd f195a = new Fd();

    public static IModuleReporter getModuleReporter(Context context, String str) {
        Fd fd = f195a;
        C0730yd c0730yd = fd.b;
        c0730yd.b.a(context);
        c0730yd.d.a(str);
        fd.c.f544a.a(context.getApplicationContext().getApplicationContext());
        return Fi.f437a.a(context.getApplicationContext(), str);
    }

    public static boolean isActivatedForApp() {
        boolean z;
        Fd fd = f195a;
        fd.b.getClass();
        fd.c.getClass();
        fd.f434a.getClass();
        synchronized (C0592t0.class) {
            z = C0592t0.f;
        }
        return z;
    }

    public static void reportAdRevenue(AdRevenue adRevenue) {
        reportAdRevenue(adRevenue, Boolean.TRUE);
    }

    public static void reportEvent(ModuleEvent moduleEvent) {
        Fd fd = f195a;
        fd.b.f1159a.a(null);
        fd.c.getClass();
        fd.d.execute(new Bd(fd, moduleEvent));
    }

    public static void reportExternalAttribution(int i, String str) {
        Fd fd = f195a;
        fd.b.getClass();
        fd.c.getClass();
        fd.d.execute(new Cd(fd, i, str));
    }

    public static void sendEventsBuffer() {
        Fd fd = f195a;
        fd.b.getClass();
        fd.c.getClass();
        AppMetrica.sendEventsBuffer();
    }

    public static void setAdvIdentifiersTracking(boolean z) {
        Fd fd = f195a;
        fd.b.getClass();
        fd.c.getClass();
        fd.d.execute(new Dd(fd, z));
    }

    public static void setProxy(Fd fd) {
        f195a = fd;
    }

    public static void setSessionExtra(String str, byte[] bArr) {
        Fd fd = f195a;
        fd.b.c.a(str);
        fd.c.getClass();
        fd.d.execute(new Ed(fd, str, bArr));
    }

    public static void reportAdRevenue(AdRevenue adRevenue, Boolean bool) {
        Fd fd = f195a;
        boolean booleanValue = bool.booleanValue();
        fd.b.getClass();
        fd.c.getClass();
        fd.d.execute(new Ad(fd, adRevenue, booleanValue));
    }
}
