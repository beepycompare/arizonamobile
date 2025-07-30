package io.appmetrica.analytics;

import android.content.Context;
import io.appmetrica.analytics.impl.A0;
import io.appmetrica.analytics.impl.C0698x4;
import io.appmetrica.analytics.impl.Wb;
import io.appmetrica.analytics.impl.Xb;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
/* loaded from: classes4.dex */
public class AppMetricaLibraryAdapter {

    /* renamed from: a  reason: collision with root package name */
    private static A0 f195a = new A0();

    public static void activate(Context context) {
        A0 a0 = f195a;
        if (a0.f329a.f701a.a(context).f976a) {
            Xb xb = a0.b;
            Context applicationContext = context.getApplicationContext();
            xb.getClass();
            C0698x4.l().g.a(applicationContext);
            C0698x4.l().b().a(applicationContext, AppMetricaLibraryAdapterConfig.newConfigBuilder().build());
            return;
        }
        ImportantLogger.INSTANCE.info("[AppMetricaLibraryAdapterProxy]", "Activation failed due to context is null", new Object[0]);
    }

    public static void reportEvent(String str, String str2, String str3) {
        f195a.a(str, str2, str3);
    }

    public static void setAdvIdentifiersTracking(boolean z) {
        A0 a0 = f195a;
        if (a0.f329a.c.a((Void) null).f976a) {
            a0.b.getClass();
            ModulesFacade.setAdvIdentifiersTracking(z);
        }
    }

    public static void setProxy(A0 a0) {
        f195a = a0;
    }

    public static void activate(Context context, AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        A0 a0 = f195a;
        Wb wb = a0.f329a;
        if (wb.f701a.a(context).f976a && wb.b.a(appMetricaLibraryAdapterConfig).f976a) {
            Xb xb = a0.b;
            Context applicationContext = context.getApplicationContext();
            xb.getClass();
            C0698x4.l().g.a(applicationContext);
            C0698x4.l().b().a(applicationContext, appMetricaLibraryAdapterConfig);
            return;
        }
        ImportantLogger.INSTANCE.info("[AppMetricaLibraryAdapterProxy]", "Activation failed due to context is null or invalid config", new Object[0]);
    }
}
