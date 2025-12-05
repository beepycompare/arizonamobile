package io.appmetrica.analytics;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.ApiKeyUtils;
import io.appmetrica.analytics.impl.C0101a0;
import io.appmetrica.analytics.impl.C0127b0;
import io.appmetrica.analytics.impl.C0157c4;
import io.appmetrica.analytics.impl.Cb;
import io.appmetrica.analytics.impl.Db;
import io.appmetrica.analytics.impl.F0;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
/* loaded from: classes3.dex */
public class AppMetricaLibraryAdapter {

    /* renamed from: a  reason: collision with root package name */
    private static F0 f262a = new F0();

    public static void activate(Context context) {
        F0 f0 = f262a;
        if (f0.f553a.f511a.a(context).f1190a) {
            Db db = f0.b;
            Context applicationContext = context.getApplicationContext();
            db.getClass();
            C0157c4.l().g.a(applicationContext);
            C0157c4.l().b().a(applicationContext, AppMetricaLibraryAdapterConfig.newConfigBuilder().build());
            return;
        }
        ImportantLogger.INSTANCE.info("[AppMetricaLibraryAdapterProxy]", "Activation failed due to context is null", new Object[0]);
    }

    public static void reportEvent(String str, String str2, String str3) {
        f262a.a(str, str2, str3);
    }

    public static void setAdvIdentifiersTracking(boolean z) {
        F0 f0 = f262a;
        if (f0.f553a.c.a((Void) null).f1190a) {
            f0.b.getClass();
            ModulesFacade.setAdvIdentifiersTracking(z);
        }
    }

    public static void setProxy(F0 f0) {
        f262a = f0;
    }

    public static void subscribeForAutoCollectedData(Context context, String str) {
        F0 f0 = f262a;
        f0.getClass();
        ImportantLogger.INSTANCE.info("[AppMetricaLibraryAdapterProxy]", "Subscribe for auto-collected data with api key: " + ApiKeyUtils.createPartialApiKey(str), new Object[0]);
        Cb cb = f0.f553a;
        if (cb.g.a(str).f1190a && cb.f511a.a(context).f1190a) {
            f0.b.getClass();
            C0157c4.l().g.a(context);
            C0127b0 b = C0157c4.l().b();
            b.c.a().executeDelayed(new C0101a0(b, context), b.d);
            ModulesFacade.subscribeForAutoCollectedData(context, str);
        }
    }

    public static void activate(Context context, AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        F0 f0 = f262a;
        Cb cb = f0.f553a;
        if (cb.f511a.a(context).f1190a && cb.b.a(appMetricaLibraryAdapterConfig).f1190a) {
            Db db = f0.b;
            Context applicationContext = context.getApplicationContext();
            db.getClass();
            C0157c4.l().g.a(applicationContext);
            C0157c4.l().b().a(applicationContext, appMetricaLibraryAdapterConfig);
            return;
        }
        ImportantLogger.INSTANCE.info("[AppMetricaLibraryAdapterProxy]", "Activation failed due to context is null or invalid config", new Object[0]);
    }
}
