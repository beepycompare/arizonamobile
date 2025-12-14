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
public final class C0 implements Da {

    /* renamed from: a  reason: collision with root package name */
    public final Context f515a;
    public final Ca b;
    public final We c;
    public final Pl d;
    public final C0375kg e;
    public final Cf f;
    public final C0377ki g;
    public final C0702xi h;
    public final E7 i;
    public final Xk j;
    public volatile C0371kc k;
    public final C0410m0 l;
    public boolean m;

    public C0(Context context, Ca ca) {
        this.f515a = context;
        this.b = ca;
        We b = C0157c4.l().b(context);
        this.c = b;
        ArrayList a2 = C0597td.a();
        C0157c4 l = C0157c4.l();
        l.m().a(new L3(context));
        D0.a(context).a(a2);
        Cf a3 = D0.a(context, D0.a(ca.b(), this));
        this.f = a3;
        E7 j = l.j();
        this.i = j;
        C0702xi a4 = D0.a(a3, context, ca.getDefaultExecutor());
        this.h = a4;
        j.a(a4);
        Pl a5 = D0.a(context, a4, b, ca.b());
        this.d = a5;
        a4.a(a5);
        this.e = D0.a(a4, b, ca.b());
        this.g = D0.a(context, a3, a4, ca.b(), a5);
        this.j = l.o();
        this.l = new C0410m0(b);
    }

    @Override // io.appmetrica.analytics.impl.Da
    public final Sa c(ReporterConfig reporterConfig) {
        return this.g.b(reporterConfig);
    }

    @Override // io.appmetrica.analytics.impl.Da, io.appmetrica.analytics.impl.Ic
    public final void clearAppEnvironment() {
        j().clearAppEnvironment();
    }

    @Override // io.appmetrica.analytics.impl.Da
    public final Y9 d() {
        return this.d.e();
    }

    @Override // io.appmetrica.analytics.impl.Da
    public final String e() {
        return this.d.d();
    }

    @Override // io.appmetrica.analytics.impl.Da
    public final Map<String, String> g() {
        return this.d.b();
    }

    @Override // io.appmetrica.analytics.impl.Da
    public final AdvIdentifiersResult h() {
        return this.d.a();
    }

    @Override // io.appmetrica.analytics.impl.Da
    public final C0371kc i() {
        return this.k;
    }

    public final Ja j() {
        C0371kc c0371kc = this.k;
        Intrinsics.checkNotNull(c0371kc);
        return c0371kc.f1072a;
    }

    public final C0377ki k() {
        return this.g;
    }

    @Override // io.appmetrica.analytics.impl.Da, io.appmetrica.analytics.impl.Ic
    public final void putAppEnvironmentValue(String str, String str2) {
        j().putAppEnvironmentValue(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.Da, io.appmetrica.analytics.impl.Ic
    public final void setDataSendingEnabled(boolean z) {
        j().setDataSendingEnabled(z);
    }

    @Override // io.appmetrica.analytics.impl.Da, io.appmetrica.analytics.impl.Ic
    public final void setUserProfileID(String str) {
        j().setUserProfileID(str);
    }

    @Override // io.appmetrica.analytics.impl.Da
    public final void a(AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        Boolean bool;
        C0410m0 c0410m0 = this.l;
        C0659w0 c0659w0 = c0410m0.b;
        c0659w0.getClass();
        AppMetricaConfig.Builder newConfigBuilder = AppMetricaConfig.newConfigBuilder("629a824d-c717-4ba5-bc0f-3f3968554d01");
        if (c0659w0.f1274a.b() && Intrinsics.areEqual(c0659w0.b.f944a, Boolean.TRUE)) {
            newConfigBuilder.handleFirstActivationAsUpdate(true);
        }
        Boolean bool2 = appMetricaLibraryAdapterConfig.advIdentifiersTracking;
        if (bool2 == null) {
            bool2 = Boolean.FALSE;
        }
        newConfigBuilder.withAdvIdentifiersTracking(bool2.booleanValue());
        AppMetricaConfig build = newConfigBuilder.build();
        AppMetricaConfig.Builder f = c0410m0.f1096a.f();
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

    @Override // io.appmetrica.analytics.impl.Da
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

    @Override // io.appmetrica.analytics.impl.Da, io.appmetrica.analytics.impl.B6
    public final void a(int i, Bundle bundle) {
        this.d.b(bundle, null);
    }

    @Override // io.appmetrica.analytics.impl.Da
    public final void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        this.e.a(deferredDeeplinkParametersListener);
    }

    @Override // io.appmetrica.analytics.impl.Da
    public final void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        this.e.a(deferredDeeplinkListener);
    }

    @Override // io.appmetrica.analytics.impl.Da
    public final void a(ReporterConfig reporterConfig) {
        this.g.a(reporterConfig);
    }

    @Override // io.appmetrica.analytics.impl.Da
    public final void a(StartupParamsCallback startupParamsCallback, List<String> list) {
        this.d.a(startupParamsCallback, list, AbstractC0293hb.c(this.f.f529a.getAsString("PROCESS_CFG_CLIDS")));
    }

    public final boolean a(PublicLogger publicLogger, AppMetricaConfig appMetricaConfig, InterfaceC0696xc interfaceC0696xc, boolean z) {
        if (this.k == null) {
            a(publicLogger, appMetricaConfig, z);
            this.e.a();
            C0320ic a2 = interfaceC0696xc.a();
            C0741z7 c0741z7 = new C0741z7(a2);
            C0371kc c0371kc = new C0371kc(a2, c0741z7);
            this.b.c().a(c0741z7);
            this.k = c0371kc;
            C0440n5 c0440n5 = this.j.b;
            synchronized (c0440n5) {
                c0440n5.f1120a = a2;
                Iterator it = c0440n5.b.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0141be) it.next()).consume(a2);
                }
                c0440n5.b.clear();
            }
            return true;
        }
        interfaceC0696xc.a();
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
        if (((Boolean) WrapUtils.getOrDefault(appMetricaConfig.crashReporting, bool2)).booleanValue()) {
            this.b.d().a(this.f515a, appMetricaConfig, this);
            this.b.d().b();
            publicLogger.info("Register application crash handler", new Object[0]);
        } else {
            this.b.d().a();
            publicLogger.info("Disable all crash handlers", new Object[0]);
        }
        if (((Boolean) WrapUtils.getOrDefault(appMetricaConfig.sessionsAutoTrackingEnabled, bool2)).booleanValue()) {
            this.j.a();
        } else {
            Xk xk = this.j;
            synchronized (xk) {
                if (xk.g) {
                    xk.f850a.unregisterListener(xk.c, ActivityEvent.RESUMED);
                    xk.f850a.unregisterListener(xk.d, ActivityEvent.PAUSED);
                    xk.g = false;
                }
            }
        }
        this.f.d(appMetricaConfig);
        Pl pl = this.d;
        pl.e = publicLogger;
        pl.b(appMetricaConfig.customHosts);
        Pl pl2 = this.d;
        Object obj = appMetricaConfig.additionalConfig.get("YMM_clids");
        pl2.a(obj instanceof Map ? (Map) obj : null);
        String str = (String) appMetricaConfig.additionalConfig.get("YMM_distributionReferrer");
        this.d.a(str);
        if (str != null) {
            this.d.b("api");
        }
        this.h.a(appMetricaConfig.locationTracking, appMetricaConfig.dataSendingEnabled, appMetricaConfig.advIdentifiersTracking, Boolean.valueOf(z));
        this.d.i();
    }

    @Override // io.appmetrica.analytics.impl.Da, io.appmetrica.analytics.impl.Ic
    public final void a(Location location) {
        j().a(location);
    }

    @Override // io.appmetrica.analytics.impl.Da, io.appmetrica.analytics.impl.Ic
    public final void a(boolean z) {
        j().a(z);
    }

    @Override // io.appmetrica.analytics.impl.Da, io.appmetrica.analytics.impl.Ic
    public final void a(boolean z, boolean z2) {
        j().a(z, z2);
    }

    @Override // io.appmetrica.analytics.impl.Da, io.appmetrica.analytics.impl.Ic
    public final void a(String str, String str2) {
        j().a(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.Da, io.appmetrica.analytics.impl.Ic
    public final void a(String str) {
        j().a(str);
    }

    @Override // io.appmetrica.analytics.impl.Da, io.appmetrica.analytics.impl.Ua
    public final Ta a() {
        return this.g;
    }
}
