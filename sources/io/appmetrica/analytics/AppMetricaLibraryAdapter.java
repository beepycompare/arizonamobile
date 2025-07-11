package io.appmetrica.analytics;

import android.content.Context;
import io.appmetrica.analytics.impl.A0;
import io.appmetrica.analytics.impl.C0696x4;
import io.appmetrica.analytics.impl.Ub;
import io.appmetrica.analytics.impl.Vb;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
/* loaded from: classes4.dex */
public class AppMetricaLibraryAdapter {

    /* renamed from: a  reason: collision with root package name */
    private static A0 f194a = new A0();

    public static void activate(Context context) {
        A0 a0 = f194a;
        if (a0.f328a.f658a.a(context).f913a) {
            Vb vb = a0.b;
            Context applicationContext = context.getApplicationContext();
            vb.getClass();
            C0696x4.l().g.a(applicationContext);
            C0696x4.l().b().a(applicationContext, AppMetricaLibraryAdapterConfig.newConfigBuilder().build());
            return;
        }
        ImportantLogger.INSTANCE.info("[AppMetricaLibraryAdapterProxy]", "Activation failed due to context is null", new Object[0]);
    }

    public static void reportEvent(String str, String str2, String str3) {
        f194a.a(str, str2, str3);
    }

    public static void setAdvIdentifiersTracking(boolean z) {
        A0 a0 = f194a;
        if (a0.f328a.c.a((Void) null).f913a) {
            a0.b.getClass();
            ModulesFacade.setAdvIdentifiersTracking(z);
        }
    }

    public static void setProxy(A0 a0) {
        f194a = a0;
    }

    public static void activate(Context context, AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        A0 a0 = f194a;
        Ub ub = a0.f328a;
        if (ub.f658a.a(context).f913a && ub.b.a(appMetricaLibraryAdapterConfig).f913a) {
            Vb vb = a0.b;
            Context applicationContext = context.getApplicationContext();
            vb.getClass();
            C0696x4.l().g.a(applicationContext);
            C0696x4.l().b().a(applicationContext, appMetricaLibraryAdapterConfig);
            return;
        }
        ImportantLogger.INSTANCE.info("[AppMetricaLibraryAdapterProxy]", "Activation failed due to context is null or invalid config", new Object[0]);
    }
}
