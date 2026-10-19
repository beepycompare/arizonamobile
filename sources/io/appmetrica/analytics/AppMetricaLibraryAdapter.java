package io.appmetrica.analytics;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.ApiKeyUtils;
import io.appmetrica.analytics.impl.C0152c0;
import io.appmetrica.analytics.impl.C0178d0;
import io.appmetrica.analytics.impl.C0190dc;
import io.appmetrica.analytics.impl.C0215ec;
import io.appmetrica.analytics.impl.C0569s4;
import io.appmetrica.analytics.impl.H0;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
/* loaded from: classes5.dex */
public class AppMetricaLibraryAdapter {

    /* renamed from: a  reason: collision with root package name */
    private static H0 f214a = new H0();

    public static void activate(Context context) {
        H0 h0 = f214a;
        if (h0.f574a.f948a.a(context).f787a) {
            C0215ec c0215ec = h0.b;
            Context applicationContext = context.getApplicationContext();
            c0215ec.getClass();
            C0569s4.l().g.a(applicationContext);
            C0569s4.l().b().a(applicationContext, AppMetricaLibraryAdapterConfig.newConfigBuilder().build());
            return;
        }
        ImportantLogger.INSTANCE.info("[AppMetricaLibraryAdapterProxy]", "Activation failed due to context is null", new Object[0]);
    }

    public static void reportEvent(String str, String str2, String str3) {
        f214a.a(str, str2, str3);
    }

    public static void setAdvIdentifiersTracking(boolean z) {
        H0 h0 = f214a;
        if (h0.f574a.c.a((Void) null).f787a) {
            h0.b.getClass();
            ModulesFacade.setAdvIdentifiersTracking(z);
        }
    }

    public static void setProxy(H0 h0) {
        f214a = h0;
    }

    public static void subscribeForAutoCollectedData(Context context, String str) {
        H0 h0 = f214a;
        h0.getClass();
        ImportantLogger.INSTANCE.info("[AppMetricaLibraryAdapterProxy]", "Subscribe for auto-collected data with api key: " + ApiKeyUtils.createPartialApiKey(str), new Object[0]);
        C0190dc c0190dc = h0.f574a;
        if (c0190dc.g.a(str).f787a && c0190dc.f948a.a(context).f787a) {
            h0.b.getClass();
            C0569s4.l().g.a(context);
            C0178d0 b = C0569s4.l().b();
            b.c.a().executeDelayed(new C0152c0(b, context), b.d);
            ModulesFacade.subscribeForAutoCollectedData(context, str);
        }
    }

    public static void activate(Context context, AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        H0 h0 = f214a;
        C0190dc c0190dc = h0.f574a;
        if (c0190dc.f948a.a(context).f787a && c0190dc.b.a(appMetricaLibraryAdapterConfig).f787a) {
            C0215ec c0215ec = h0.b;
            Context applicationContext = context.getApplicationContext();
            c0215ec.getClass();
            C0569s4.l().g.a(applicationContext);
            C0569s4.l().b().a(applicationContext, appMetricaLibraryAdapterConfig);
            return;
        }
        ImportantLogger.INSTANCE.info("[AppMetricaLibraryAdapterProxy]", "Activation failed due to context is null or invalid config", new Object[0]);
    }
}
