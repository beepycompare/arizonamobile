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
/* loaded from: classes3.dex */
public final class A0 implements Ja {

    /* renamed from: a  reason: collision with root package name */
    public final Context f387a;
    public final Ia b;
    public final C0117af c;
    public final Sl d;
    public final C0477og e;
    public final Gf f;
    public final C0479oi g;
    public final Bi h;
    public final L7 i;
    public final C0149bl j;
    public volatile C0523qc k;
    public final C0411m0 l;
    public boolean m;

    public A0(Context context, Ia ia) {
        this.f387a = context;
        this.b = ia;
        C0117af b = C0338j4.l().b(context);
        this.c = b;
        ArrayList a2 = C0748zd.a();
        C0338j4 l = C0338j4.l();
        l.m().a(new S3(context));
        B0.a(context).a(a2);
        Gf a3 = B0.a(context, B0.a(ia.b(), this));
        this.f = a3;
        L7 j = l.j();
        this.i = j;
        Bi a4 = B0.a(a3, context, ia.getDefaultExecutor());
        this.h = a4;
        j.a(a4);
        Sl a5 = B0.a(context, a4, b, ia.b());
        this.d = a5;
        a4.a(a5);
        this.e = B0.a(a4, b, ia.b());
        this.g = B0.a(context, a3, a4, ia.b(), a5);
        this.j = l.o();
        this.l = new C0411m0(b);
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final Ya c(ReporterConfig reporterConfig) {
        return this.g.b(reporterConfig);
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Oc
    public final void clearAppEnvironment() {
        j().clearAppEnvironment();
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final C0215ea d() {
        return this.d.e();
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final String e() {
        return this.d.d();
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final Map<String, String> g() {
        return this.d.b();
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final AdvIdentifiersResult h() {
        return this.d.a();
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final C0523qc i() {
        return this.k;
    }

    public final Pa j() {
        C0523qc c0523qc = this.k;
        Intrinsics.checkNotNull(c0523qc);
        return c0523qc.f1072a;
    }

    public final C0479oi k() {
        return this.g;
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Oc
    public final void putAppEnvironmentValue(String str, String str2) {
        j().putAppEnvironmentValue(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Oc
    public final void setDataSendingEnabled(boolean z) {
        j().setDataSendingEnabled(z);
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Oc
    public final void setUserProfileID(String str) {
        j().setUserProfileID(str);
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        Boolean bool;
        C0411m0 c0411m0 = this.l;
        C0610u0 c0610u0 = c0411m0.b;
        c0610u0.getClass();
        AppMetricaConfig.Builder newConfigBuilder = AppMetricaConfig.newConfigBuilder("629a824d-c717-4ba5-bc0f-3f3968554d01");
        if (c0610u0.f1140a.b() && Intrinsics.areEqual(c0610u0.b.f950a, Boolean.TRUE)) {
            newConfigBuilder.handleFirstActivationAsUpdate(true);
        }
        Boolean bool2 = appMetricaLibraryAdapterConfig.advIdentifiersTracking;
        if (bool2 == null) {
            bool2 = Boolean.FALSE;
        }
        newConfigBuilder.withAdvIdentifiersTracking(bool2.booleanValue());
        AppMetricaConfig build = newConfigBuilder.build();
        AppMetricaConfig.Builder f = c0411m0.f999a.f();
        if (f != null) {
            if (f.build().advIdentifiersTracking == null && (bool = build.advIdentifiersTracking) != null) {
                f.withAdvIdentifiersTracking(bool.booleanValue());
            }
            build = f.build();
        }
        PublicLogger mainPublicOrAnonymousLogger = LoggerStorage.getMainPublicOrAnonymousLogger();
        if (a(mainPublicOrAnonymousLogger, build, new C0735z0(this, build, mainPublicOrAnonymousLogger), false)) {
            ImportantLogger.INSTANCE.info("AppMetrica", "Activate AppMetrica in anonymous mode", new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void b(AppMetricaConfig appMetricaConfig) {
        boolean z;
        PublicLogger orCreateMainPublicLogger = LoggerStorage.getOrCreateMainPublicLogger(appMetricaConfig.apiKey);
        boolean a2 = a(orCreateMainPublicLogger, appMetricaConfig, new C0710y0(this, appMetricaConfig, orCreateMainPublicLogger), true);
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

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.H6
    public final void a(int i, Bundle bundle) {
        this.d.b(bundle, null);
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        this.e.a(deferredDeeplinkParametersListener);
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        this.e.a(deferredDeeplinkListener);
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(ReporterConfig reporterConfig) {
        this.g.a(reporterConfig);
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(StartupParamsCallback startupParamsCallback, List<String> list) {
        this.d.a(startupParamsCallback, list, AbstractC0447nb.c(this.f.f492a.getAsString("PROCESS_CFG_CLIDS")));
    }

    public final boolean a(PublicLogger publicLogger, AppMetricaConfig appMetricaConfig, Dc dc, boolean z) {
        if (this.k == null) {
            a(publicLogger, appMetricaConfig, z);
            this.e.a();
            C0473oc a2 = dc.a();
            G7 g7 = new G7(a2);
            C0523qc c0523qc = new C0523qc(a2, g7);
            this.b.c().a(g7);
            this.k = c0523qc;
            C0590t5 c0590t5 = this.j.b;
            synchronized (c0590t5) {
                c0590t5.f1126a = a2;
                Iterator it = c0590t5.b.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0297he) it.next()).consume(a2);
                }
                c0590t5.b.clear();
            }
            return true;
        }
        dc.a();
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
            this.b.d().a(this.f387a, appMetricaConfig, this);
            this.b.d().b();
            publicLogger.info("Register application crash handler", new Object[0]);
        } else {
            this.b.d().a();
            publicLogger.info("Disable all crash handlers", new Object[0]);
        }
        if (((Boolean) WrapUtils.getOrDefault(appMetricaConfig.sessionsAutoTrackingEnabled, bool2)).booleanValue()) {
            this.j.a();
        } else {
            C0149bl c0149bl = this.j;
            synchronized (c0149bl) {
                if (c0149bl.g) {
                    c0149bl.f819a.unregisterListener(c0149bl.c, ActivityEvent.RESUMED);
                    c0149bl.f819a.unregisterListener(c0149bl.d, ActivityEvent.PAUSED);
                    c0149bl.g = false;
                }
            }
        }
        this.f.d(appMetricaConfig);
        Sl sl = this.d;
        sl.e = publicLogger;
        sl.b(appMetricaConfig.customHosts);
        Sl sl2 = this.d;
        Object obj = appMetricaConfig.additionalConfig.get("YMM_clids");
        sl2.a(obj instanceof Map ? (Map) obj : null);
        String str = (String) appMetricaConfig.additionalConfig.get("YMM_distributionReferrer");
        this.d.a(str);
        if (str != null) {
            this.d.b("api");
        }
        this.h.a(appMetricaConfig.locationTracking, appMetricaConfig.dataSendingEnabled, appMetricaConfig.advIdentifiersTracking, Boolean.valueOf(z));
        this.d.i();
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Oc
    public final void a(Location location) {
        j().a(location);
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Oc
    public final void a(boolean z) {
        j().a(z);
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Oc
    public final void a(boolean z, boolean z2) {
        j().a(z, z2);
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Oc
    public final void a(String str, String str2) {
        j().a(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Oc
    public final void a(String str) {
        j().a(str);
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.InterfaceC0113ab
    public final Za a() {
        return this.g;
    }
}
