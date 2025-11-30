package io.appmetrica.analytics;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.ApiKeyUtils;
import io.appmetrica.analytics.impl.C0102a0;
import io.appmetrica.analytics.impl.C0128b0;
import io.appmetrica.analytics.impl.C0158c4;
import io.appmetrica.analytics.impl.Cb;
import io.appmetrica.analytics.impl.Db;
import io.appmetrica.analytics.impl.F0;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
/* loaded from: classes2.dex */
public class AppMetricaLibraryAdapter {

    /* renamed from: a  reason: collision with root package name */
    private static F0 f179a = new F0();

    public static void activate(Context context) {
        F0 f0 = f179a;
        if (f0.f470a.f428a.a(context).f1107a) {
            Db db = f0.b;
            Context applicationContext = context.getApplicationContext();
            db.getClass();
            C0158c4.l().g.a(applicationContext);
            C0158c4.l().b().a(applicationContext, AppMetricaLibraryAdapterConfig.newConfigBuilder().build());
            return;
        }
        ImportantLogger.INSTANCE.info("[AppMetricaLibraryAdapterProxy]", "Activation failed due to context is null", new Object[0]);
    }

    public static void reportEvent(String str, String str2, String str3) {
        f179a.a(str, str2, str3);
    }

    public static void setAdvIdentifiersTracking(boolean z) {
        F0 f0 = f179a;
        if (f0.f470a.c.a((Void) null).f1107a) {
            f0.b.getClass();
            ModulesFacade.setAdvIdentifiersTracking(z);
        }
    }

    public static void setProxy(F0 f0) {
        f179a = f0;
    }

    public static void subscribeForAutoCollectedData(Context context, String str) {
        F0 f0 = f179a;
        f0.getClass();
        ImportantLogger.INSTANCE.info("[AppMetricaLibraryAdapterProxy]", "Subscribe for auto-collected data with api key: " + ApiKeyUtils.createPartialApiKey(str), new Object[0]);
        Cb cb = f0.f470a;
        if (cb.g.a(str).f1107a && cb.f428a.a(context).f1107a) {
            f0.b.getClass();
            C0158c4.l().g.a(context);
            C0128b0 b = C0158c4.l().b();
            b.c.a().executeDelayed(new C0102a0(b, context), b.d);
            ModulesFacade.subscribeForAutoCollectedData(context, str);
        }
    }

    public static void activate(Context context, AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        F0 f0 = f179a;
        Cb cb = f0.f470a;
        if (cb.f428a.a(context).f1107a && cb.b.a(appMetricaLibraryAdapterConfig).f1107a) {
            Db db = f0.b;
            Context applicationContext = context.getApplicationContext();
            db.getClass();
            C0158c4.l().g.a(applicationContext);
            C0158c4.l().b().a(applicationContext, appMetricaLibraryAdapterConfig);
            return;
        }
        ImportantLogger.INSTANCE.info("[AppMetricaLibraryAdapterProxy]", "Activation failed due to context is null or invalid config", new Object[0]);
    }
}
