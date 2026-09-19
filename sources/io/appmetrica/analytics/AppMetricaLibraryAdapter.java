package io.appmetrica.analytics;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.ApiKeyUtils;
import io.appmetrica.analytics.impl.C0157c0;
import io.appmetrica.analytics.impl.C0183d0;
import io.appmetrica.analytics.impl.C0195dc;
import io.appmetrica.analytics.impl.C0220ec;
import io.appmetrica.analytics.impl.C0574s4;
import io.appmetrica.analytics.impl.H0;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
/* loaded from: classes5.dex */
public class AppMetricaLibraryAdapter {

    /* renamed from: a  reason: collision with root package name */
    private static H0 f211a = new H0();

    public static void activate(Context context) {
        H0 h0 = f211a;
        if (h0.f571a.f945a.a(context).f784a) {
            C0220ec c0220ec = h0.b;
            Context applicationContext = context.getApplicationContext();
            c0220ec.getClass();
            C0574s4.l().g.a(applicationContext);
            C0574s4.l().b().a(applicationContext, AppMetricaLibraryAdapterConfig.newConfigBuilder().build());
            return;
        }
        ImportantLogger.INSTANCE.info("[AppMetricaLibraryAdapterProxy]", "Activation failed due to context is null", new Object[0]);
    }

    public static void reportEvent(String str, String str2, String str3) {
        f211a.a(str, str2, str3);
    }

    public static void setAdvIdentifiersTracking(boolean z) {
        H0 h0 = f211a;
        if (h0.f571a.c.a((Void) null).f784a) {
            h0.b.getClass();
            ModulesFacade.setAdvIdentifiersTracking(z);
        }
    }

    public static void setProxy(H0 h0) {
        f211a = h0;
    }

    public static void subscribeForAutoCollectedData(Context context, String str) {
        H0 h0 = f211a;
        h0.getClass();
        ImportantLogger.INSTANCE.info("[AppMetricaLibraryAdapterProxy]", "Subscribe for auto-collected data with api key: " + ApiKeyUtils.createPartialApiKey(str), new Object[0]);
        C0195dc c0195dc = h0.f571a;
        if (c0195dc.g.a(str).f784a && c0195dc.f945a.a(context).f784a) {
            h0.b.getClass();
            C0574s4.l().g.a(context);
            C0183d0 b = C0574s4.l().b();
            b.c.a().executeDelayed(new C0157c0(b, context), b.d);
            ModulesFacade.subscribeForAutoCollectedData(context, str);
        }
    }

    public static void activate(Context context, AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        H0 h0 = f211a;
        C0195dc c0195dc = h0.f571a;
        if (c0195dc.f945a.a(context).f784a && c0195dc.b.a(appMetricaLibraryAdapterConfig).f784a) {
            C0220ec c0220ec = h0.b;
            Context applicationContext = context.getApplicationContext();
            c0220ec.getClass();
            C0574s4.l().g.a(applicationContext);
            C0574s4.l().b().a(applicationContext, appMetricaLibraryAdapterConfig);
            return;
        }
        ImportantLogger.INSTANCE.info("[AppMetricaLibraryAdapterProxy]", "Activation failed due to context is null or invalid config", new Object[0]);
    }
}
