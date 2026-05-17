package io.appmetrica.analytics;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.ApiKeyUtils;
import io.appmetrica.analytics.impl.Bb;
import io.appmetrica.analytics.impl.C0105a0;
import io.appmetrica.analytics.impl.C0131b0;
import io.appmetrica.analytics.impl.C0135b4;
import io.appmetrica.analytics.impl.Cb;
import io.appmetrica.analytics.impl.F0;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
/* loaded from: classes5.dex */
public class AppMetricaLibraryAdapter {

    /* renamed from: a  reason: collision with root package name */
    private static F0 f281a = new F0();

    public static void activate(Context context) {
        F0 f0 = f281a;
        if (f0.f580a.f521a.a(context).f1199a) {
            Cb cb = f0.b;
            Context applicationContext = context.getApplicationContext();
            cb.getClass();
            C0135b4.l().g.a(applicationContext);
            C0135b4.l().b().a(applicationContext, AppMetricaLibraryAdapterConfig.newConfigBuilder().build());
            return;
        }
        ImportantLogger.INSTANCE.info("[AppMetricaLibraryAdapterProxy]", "Activation failed due to context is null", new Object[0]);
    }

    public static void reportEvent(String str, String str2, String str3) {
        f281a.a(str, str2, str3);
    }

    public static void setAdvIdentifiersTracking(boolean z) {
        F0 f0 = f281a;
        if (f0.f580a.c.a((Void) null).f1199a) {
            f0.b.getClass();
            ModulesFacade.setAdvIdentifiersTracking(z);
        }
    }

    public static void setProxy(F0 f0) {
        f281a = f0;
    }

    public static void subscribeForAutoCollectedData(Context context, String str) {
        F0 f0 = f281a;
        f0.getClass();
        ImportantLogger.INSTANCE.info("[AppMetricaLibraryAdapterProxy]", "Subscribe for auto-collected data with api key: " + ApiKeyUtils.createPartialApiKey(str), new Object[0]);
        Bb bb = f0.f580a;
        if (bb.g.a(str).f1199a && bb.f521a.a(context).f1199a) {
            f0.b.getClass();
            C0135b4.l().g.a(context);
            C0131b0 b = C0135b4.l().b();
            b.c.a().executeDelayed(new C0105a0(b, context), b.d);
            ModulesFacade.subscribeForAutoCollectedData(context, str);
        }
    }

    public static void activate(Context context, AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        F0 f0 = f281a;
        Bb bb = f0.f580a;
        if (bb.f521a.a(context).f1199a && bb.b.a(appMetricaLibraryAdapterConfig).f1199a) {
            Cb cb = f0.b;
            Context applicationContext = context.getApplicationContext();
            cb.getClass();
            C0135b4.l().g.a(applicationContext);
            C0135b4.l().b().a(applicationContext, appMetricaLibraryAdapterConfig);
            return;
        }
        ImportantLogger.INSTANCE.info("[AppMetricaLibraryAdapterProxy]", "Activation failed due to context is null or invalid config", new Object[0]);
    }
}
