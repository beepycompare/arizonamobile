package io.appmetrica.analytics.impl;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import io.appmetrica.analytics.AdvIdentifiersResult;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.AppMetricaLibraryAdapterConfig;
import io.appmetrica.analytics.DeferredDeeplinkListener;
import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.StartupParamsCallback;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreutils.internal.ApiKeyUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class C0 implements Ca {

    /* renamed from: a  reason: collision with root package name */
    public final Context f527a;
    public final Ba b;
    public final Ve c;
    public final Ol d;
    public final C0353jg e;
    public final Bf f;
    public final C0355ji g;
    public final C0680wi h;
    public final D7 i;
    public final Wk j;
    public volatile C0349jc k;
    public final C0413m0 l;
    public boolean m;

    public C0(Context context, Ba ba) {
        this.f527a = context;
        this.b = ba;
        Ve b = C0135b4.l().b(context);
        this.c = b;
        ArrayList a2 = C0575sd.a();
        C0135b4 l = C0135b4.l();
        l.m().a(new K3(context));
        D0.a(context).a(a2);
        Bf a3 = D0.a(context, D0.a(ba.b(), this));
        this.f = a3;
        D7 j = l.j();
        this.i = j;
        C0680wi a4 = D0.a(a3, context, ba.getDefaultExecutor());
        this.h = a4;
        j.a(a4);
        Ol a5 = D0.a(context, a4, b, ba.b());
        this.d = a5;
        a4.a(a5);
        this.e = D0.a(a4, b, ba.b());
        this.g = D0.a(context, a3, a4, ba.b(), a5);
        this.j = l.o();
        this.l = new C0413m0(b);
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final Ra c(ReporterConfig reporterConfig) {
        return this.g.b(reporterConfig);
    }

    @Override // io.appmetrica.analytics.impl.Ca, io.appmetrica.analytics.impl.Hc
    public final void clearAppEnvironment() {
        j().clearAppEnvironment();
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final X9 d() {
        return this.d.e();
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final String e() {
        return this.d.d();
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final Map<String, String> g() {
        return this.d.b();
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final AdvIdentifiersResult h() {
        return this.d.a();
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final C0349jc i() {
        return this.k;
    }

    public final Ia j() {
        C0349jc c0349jc = this.k;
        Intrinsics.checkNotNull(c0349jc);
        return c0349jc.f1062a;
    }

    public final C0355ji k() {
        return this.g;
    }

    @Override // io.appmetrica.analytics.impl.Ca, io.appmetrica.analytics.impl.Hc
    public final void putAppEnvironmentValue(String str, String str2) {
        j().putAppEnvironmentValue(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.Ca, io.appmetrica.analytics.impl.Hc
    public final void setDataSendingEnabled(boolean z) {
        j().setDataSendingEnabled(z);
    }

    @Override // io.appmetrica.analytics.impl.Ca, io.appmetrica.analytics.impl.Hc
    public final void setUserProfileID(String str) {
        j().setUserProfileID(str);
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final void a(AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        Boolean bool;
        C0413m0 c0413m0 = this.l;
        C0662w0 c0662w0 = c0413m0.b;
        c0662w0.getClass();
        AppMetricaConfig.Builder newConfigBuilder = AppMetricaConfig.newConfigBuilder("629a824d-c717-4ba5-bc0f-3f3968554d01");
        if (c0662w0.f1277a.b() && Intrinsics.areEqual(c0662w0.b.f934a, Boolean.TRUE)) {
            newConfigBuilder.handleFirstActivationAsUpdate(true);
        }
        Boolean bool2 = appMetricaLibraryAdapterConfig.advIdentifiersTracking;
        if (bool2 == null) {
            bool2 = Boolean.FALSE;
        }
        newConfigBuilder.withAdvIdentifiersTracking(bool2.booleanValue());
        AppMetricaConfig build = newConfigBuilder.build();
        AppMetricaConfig.Builder f = c0413m0.f1105a.f();
        if (f != null) {
            if (f.build().advIdentifiersTracking == null && (bool = build.advIdentifiersTracking) != null) {
                f.withAdvIdentifiersTracking(bool.booleanValue());
            }
            build = f.build();
        }
        PublicLogger mainPublicOrAnonymousLogger = LoggerStorage.getMainPublicOrAnonymousLogger();
        if (a(mainPublicOrAnonymousLogger, build, new B0(this, build, mainPublicOrAnonymousLogger), false)) {
            ImportantLogger.INSTANCE.info("AppMetrica", "Activate AppMetrica in anonymous mode", new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final void b(AppMetricaConfig appMetricaConfig) {
        boolean z;
        PublicLogger orCreateMainPublicLogger = LoggerStorage.getOrCreateMainPublicLogger(appMetricaConfig.apiKey);
        boolean a2 = a(orCreateMainPublicLogger, appMetricaConfig, new A0(this, appMetricaConfig, orCreateMainPublicLogger), true);
        if (a2 || this.m) {
            z = false;
        } else {
            a(orCreateMainPublicLogger, appMetricaConfig, true);
            z = true;
        }
        if (!a2 && !z) {
            orCreateMainPublicLogger.warning("AppMetrica SDK already has been activated", new Object[0]);
        } else {
            this.c.a(appMetricaConfig);
        }
        if (a2) {
            ImportantLogger.INSTANCE.info("AppMetrica", "Activate AppMetrica with APIKey " + ApiKeyUtils.createPartialApiKey(appMetricaConfig.apiKey), new Object[0]);
        }
        if (z) {
            ImportantLogger.INSTANCE.info("AppMetrica", "Upgrade AppMetrica anonymous mode to normal with APIKey " + ApiKeyUtils.createPartialApiKey(appMetricaConfig.apiKey), new Object[0]);
        }
        this.m = true;
    }

    @Override // io.appmetrica.analytics.impl.Ca, io.appmetrica.analytics.impl.A6
    public final void a(int i, Bundle bundle) {
        this.d.b(bundle, null);
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        this.e.a(deferredDeeplinkParametersListener);
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        this.e.a(deferredDeeplinkListener);
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final void a(ReporterConfig reporterConfig) {
        this.g.a(reporterConfig);
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final void a(StartupParamsCallback startupParamsCallback, List<String> list) {
        this.d.a(startupParamsCallback, list, AbstractC0271gb.c(this.f.f520a.getAsString("PROCESS_CFG_CLIDS")));
    }

    public final boolean a(PublicLogger publicLogger, AppMetricaConfig appMetricaConfig, InterfaceC0674wc interfaceC0674wc, boolean z) {
        if (this.k == null) {
            a(publicLogger, appMetricaConfig, z);
            this.e.a();
            C0298hc a2 = interfaceC0674wc.a();
            C0719y7 c0719y7 = new C0719y7(a2);
            C0349jc c0349jc = new C0349jc(a2, c0719y7);
            this.b.c().a(c0719y7);
            this.k = c0349jc;
            C0418m5 c0418m5 = this.j.b;
            synchronized (c0418m5) {
                c0418m5.f1110a = a2;
                Iterator it = c0418m5.b.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0119ae) it.next()).consume(a2);
                }
                c0418m5.b.clear();
            }
            return true;
        }
        interfaceC0674wc.a();
        return false;
    }

    public final void a(PublicLogger publicLogger, AppMetricaConfig appMetricaConfig, boolean z) {
        Boolean bool = appMetricaConfig.logs;
        Boolean bool2 = Boolean.TRUE;
        if (bool2.equals(bool)) {
            publicLogger.setEnabled(true);
            PublicLogger.Companion.getAnonymousInstance().setEnabled(true);
        } else {
            publicLogger.setEnabled(false);
            PublicLogger.Companion.getAnonymousInstance().setEnabled(false);
        }
        boolean booleanValue = ((Boolean) WrapUtils.getOrDefault(appMetricaConfig.crashReporting, bool2)).booleanValue();
        Ba ba = this.b;
        if (booleanValue) {
            ba.d().a(this.f527a, appMetricaConfig, this);
            this.b.d().b();
            publicLogger.info("Register application crash handler", new Object[0]);
        } else {
            ba.d().a();
            publicLogger.info("Disable all crash handlers", new Object[0]);
        }
        boolean booleanValue2 = ((Boolean) WrapUtils.getOrDefault(appMetricaConfig.sessionsAutoTrackingEnabled, bool2)).booleanValue();
        Wk wk = this.j;
        if (booleanValue2) {
            wk.a();
        } else {
            synchronized (wk) {
                if (wk.g) {
                    wk.f842a.unregisterListener(wk.c, ActivityEvent.RESUMED);
                    wk.f842a.unregisterListener(wk.d, ActivityEvent.PAUSED);
                    wk.g = false;
                }
            }
        }
        this.f.d(appMetricaConfig);
        Ol ol = this.d;
        ol.e = publicLogger;
        ol.b(appMetricaConfig.customHosts);
        Ol ol2 = this.d;
        Object obj = appMetricaConfig.additionalConfig.get("YMM_clids");
        ol2.a(obj instanceof Map ? (Map) obj : null);
        String str = (String) appMetricaConfig.additionalConfig.get("YMM_distributionReferrer");
        this.d.a(str);
        if (str != null) {
            this.d.b("api");
        }
        this.h.a(appMetricaConfig.locationTracking, appMetricaConfig.dataSendingEnabled, appMetricaConfig.advIdentifiersTracking, Boolean.valueOf(z));
        this.d.i();
    }

    @Override // io.appmetrica.analytics.impl.Ca, io.appmetrica.analytics.impl.Hc
    public final void a(Location location) {
        j().a(location);
    }

    @Override // io.appmetrica.analytics.impl.Ca, io.appmetrica.analytics.impl.Hc
    public final void a(boolean z) {
        j().a(z);
    }

    @Override // io.appmetrica.analytics.impl.Ca, io.appmetrica.analytics.impl.Hc
    public final void a(boolean z, boolean z2) {
        j().a(z, z2);
    }

    @Override // io.appmetrica.analytics.impl.Ca, io.appmetrica.analytics.impl.Hc
    public final void a(String str, String str2) {
        j().a(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.Ca, io.appmetrica.analytics.impl.Hc
    public final void a(String str) {
        j().a(str);
    }

    @Override // io.appmetrica.analytics.impl.Ca, io.appmetrica.analytics.impl.Ta
    public final Sa a() {
        return this.g;
    }
}
