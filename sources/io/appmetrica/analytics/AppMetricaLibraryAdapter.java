package io.appmetrica.analytics;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.ApiKeyUtils;
import io.appmetrica.analytics.impl.C0102a0;
import io.appmetrica.analytics.impl.C0128b0;
import io.appmetrica.analytics.impl.C0338j4;
import io.appmetrica.analytics.impl.D0;
import io.appmetrica.analytics.impl.Ib;
import io.appmetrica.analytics.impl.Jb;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
/* loaded from: classes.dex */
public class AppMetricaLibraryAdapter {

    /* renamed from: a  reason: collision with root package name */
    private static D0 f179a = new D0();

    public static void activate(Context context) {
        D0 d0 = f179a;
        if (d0.f433a.f525a.a(context).f1120a) {
            Jb jb = d0.b;
            Context applicationContext = context.getApplicationContext();
            jb.getClass();
            C0338j4.l().g.a(applicationContext);
            C0338j4.l().b().a(applicationContext, AppMetricaLibraryAdapterConfig.newConfigBuilder().build());
            return;
        }
        ImportantLogger.INSTANCE.info("[AppMetricaLibraryAdapterProxy]", "Activation failed due to context is null", new Object[0]);
    }

    public static void reportEvent(String str, String str2, String str3) {
        f179a.a(str, str2, str3);
    }

    public static void setAdvIdentifiersTracking(boolean z) {
        D0 d0 = f179a;
        if (d0.f433a.c.a((Void) null).f1120a) {
            d0.b.getClass();
            ModulesFacade.setAdvIdentifiersTracking(z);
        }
    }

    public static void setProxy(D0 d0) {
        f179a = d0;
    }

    public static void subscribeForAutoCollectedData(Context context, String str) {
        D0 d0 = f179a;
        d0.getClass();
        ImportantLogger.INSTANCE.info("[AppMetricaLibraryAdapterProxy]", "Subscribe for auto-collected data with api key: " + ApiKeyUtils.createPartialApiKey(str), new Object[0]);
        Ib ib = d0.f433a;
        if (ib.g.a(str).f1120a && ib.f525a.a(context).f1120a) {
            d0.b.getClass();
            C0338j4.l().g.a(context);
            C0128b0 b = C0338j4.l().b();
            b.c.a().executeDelayed(new C0102a0(b, context), b.d);
            ModulesFacade.subscribeForAutoCollectedData(context, str);
        }
    }

    public static void activate(Context context, AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        D0 d0 = f179a;
        Ib ib = d0.f433a;
        if (ib.f525a.a(context).f1120a && ib.b.a(appMetricaLibraryAdapterConfig).f1120a) {
            Jb jb = d0.b;
            Context applicationContext = context.getApplicationContext();
            jb.getClass();
            C0338j4.l().g.a(applicationContext);
            C0338j4.l().b().a(applicationContext, appMetricaLibraryAdapterConfig);
            return;
        }
        ImportantLogger.INSTANCE.info("[AppMetricaLibraryAdapterProxy]", "Activation failed due to context is null or invalid config", new Object[0]);
    }
}
