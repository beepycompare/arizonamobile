package io.appmetrica.analytics;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.ApiKeyUtils;
import io.appmetrica.analytics.impl.A4;
import io.appmetrica.analytics.impl.C0;
import io.appmetrica.analytics.impl.C0109a0;
import io.appmetrica.analytics.impl.C0147bc;
import io.appmetrica.analytics.impl.C0173cc;
import io.appmetrica.analytics.impl.Z;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
/* loaded from: classes4.dex */
public class AppMetricaLibraryAdapter {

    /* renamed from: a  reason: collision with root package name */
    private static C0 f189a = new C0();

    public static void activate(Context context) {
        C0 c0 = f189a;
        if (c0.f374a.f805a.a(context).f1141a) {
            C0173cc c0173cc = c0.b;
            Context applicationContext = context.getApplicationContext();
            c0173cc.getClass();
            A4.l().g.a(applicationContext);
            A4.l().b().a(applicationContext, AppMetricaLibraryAdapterConfig.newConfigBuilder().build());
            return;
        }
        ImportantLogger.INSTANCE.info("[AppMetricaLibraryAdapterProxy]", "Activation failed due to context is null", new Object[0]);
    }

    public static void reportEvent(String str, String str2, String str3) {
        f189a.a(str, str2, str3);
    }

    public static void setAdvIdentifiersTracking(boolean z) {
        C0 c0 = f189a;
        if (c0.f374a.c.a((Void) null).f1141a) {
            c0.b.getClass();
            ModulesFacade.setAdvIdentifiersTracking(z);
        }
    }

    public static void setProxy(C0 c0) {
        f189a = c0;
    }

    public static void subscribeForAutoCollectedData(Context context, String str) {
        C0 c0 = f189a;
        c0.getClass();
        ImportantLogger.INSTANCE.info("[AppMetricaLibraryAdapterProxy]", "Subscribe for auto-collected data with api key: " + ApiKeyUtils.createPartialApiKey(str), new Object[0]);
        C0147bc c0147bc = c0.f374a;
        if (c0147bc.g.a(str).f1141a && c0147bc.f805a.a(context).f1141a) {
            c0.b.getClass();
            A4.l().g.a(context);
            C0109a0 b = A4.l().b();
            b.c.a().executeDelayed(new Z(b, context), b.d);
            ModulesFacade.subscribeForAutoCollectedData(context, str);
        }
    }

    public static void activate(Context context, AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        C0 c0 = f189a;
        C0147bc c0147bc = c0.f374a;
        if (c0147bc.f805a.a(context).f1141a && c0147bc.b.a(appMetricaLibraryAdapterConfig).f1141a) {
            C0173cc c0173cc = c0.b;
            Context applicationContext = context.getApplicationContext();
            c0173cc.getClass();
            A4.l().g.a(applicationContext);
            A4.l().b().a(applicationContext, appMetricaLibraryAdapterConfig);
            return;
        }
        ImportantLogger.INSTANCE.info("[AppMetricaLibraryAdapterProxy]", "Activation failed due to context is null or invalid config", new Object[0]);
    }
}
