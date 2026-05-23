package io.appmetrica.analytics;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.ApiKeyUtils;
import io.appmetrica.analytics.impl.C0159c0;
import io.appmetrica.analytics.impl.C0185d0;
import io.appmetrica.analytics.impl.C0197dc;
import io.appmetrica.analytics.impl.C0222ec;
import io.appmetrica.analytics.impl.C0576s4;
import io.appmetrica.analytics.impl.H0;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
/* loaded from: classes5.dex */
public class AppMetricaLibraryAdapter {

    /* renamed from: a  reason: collision with root package name */
    private static H0 f208a = new H0();

    public static void activate(Context context) {
        H0 h0 = f208a;
        if (h0.f568a.f942a.a(context).f781a) {
            C0222ec c0222ec = h0.b;
            Context applicationContext = context.getApplicationContext();
            c0222ec.getClass();
            C0576s4.l().g.a(applicationContext);
            C0576s4.l().b().a(applicationContext, AppMetricaLibraryAdapterConfig.newConfigBuilder().build());
            return;
        }
        ImportantLogger.INSTANCE.info("[AppMetricaLibraryAdapterProxy]", "Activation failed due to context is null", new Object[0]);
    }

    public static void reportEvent(String str, String str2, String str3) {
        f208a.a(str, str2, str3);
    }

    public static void setAdvIdentifiersTracking(boolean z) {
        H0 h0 = f208a;
        if (h0.f568a.c.a((Void) null).f781a) {
            h0.b.getClass();
            ModulesFacade.setAdvIdentifiersTracking(z);
        }
    }

    public static void setProxy(H0 h0) {
        f208a = h0;
    }

    public static void subscribeForAutoCollectedData(Context context, String str) {
        H0 h0 = f208a;
        h0.getClass();
        ImportantLogger.INSTANCE.info("[AppMetricaLibraryAdapterProxy]", "Subscribe for auto-collected data with api key: " + ApiKeyUtils.createPartialApiKey(str), new Object[0]);
        C0197dc c0197dc = h0.f568a;
        if (c0197dc.g.a(str).f781a && c0197dc.f942a.a(context).f781a) {
            h0.b.getClass();
            C0576s4.l().g.a(context);
            C0185d0 b = C0576s4.l().b();
            b.c.a().executeDelayed(new C0159c0(b, context), b.d);
            ModulesFacade.subscribeForAutoCollectedData(context, str);
        }
    }

    public static void activate(Context context, AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        H0 h0 = f208a;
        C0197dc c0197dc = h0.f568a;
        if (c0197dc.f942a.a(context).f781a && c0197dc.b.a(appMetricaLibraryAdapterConfig).f781a) {
            C0222ec c0222ec = h0.b;
            Context applicationContext = context.getApplicationContext();
            c0222ec.getClass();
            C0576s4.l().g.a(applicationContext);
            C0576s4.l().b().a(applicationContext, appMetricaLibraryAdapterConfig);
            return;
        }
        ImportantLogger.INSTANCE.info("[AppMetricaLibraryAdapterProxy]", "Activation failed due to context is null or invalid config", new Object[0]);
    }
}
