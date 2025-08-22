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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.x0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0692x0 implements Za {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1132a;
    public final Ya b;
    public final C0408lf c;
    public final Tl d;
    public final Bg e;
    public final Rf f;
    public final Bi g;
    public final Oi h;
    public final C0117a8 i;
    public final C0182cl j;
    public volatile Gc k;
    public final C0341j0 l;
    public boolean m;

    public C0692x0(Context context, Ya ya) {
        this.f1132a = context;
        this.b = ya;
        C0408lf b = C0696x4.l().b(context);
        this.c = b;
        Kd.a();
        C0696x4 l = C0696x4.l();
        l.m().a(new C0268g4(context));
        Rf a2 = AbstractC0717y0.a(context, AbstractC0717y0.a(ya.b(), this));
        this.f = a2;
        C0117a8 j = l.j();
        this.i = j;
        Oi a3 = AbstractC0717y0.a(a2, context, ya.getDefaultExecutor());
        this.h = a3;
        j.a(a3);
        Tl a4 = AbstractC0717y0.a(context, a3, b, ya.b());
        this.d = a4;
        a3.a(a4);
        this.e = AbstractC0717y0.a(a3, b, ya.b());
        this.g = AbstractC0717y0.a(context, a2, a3, ya.b(), a4);
        this.j = l.o();
        this.l = new C0341j0(b);
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final InterfaceC0479ob c(ReporterConfig reporterConfig) {
        return this.g.b(reporterConfig);
    }

    @Override // io.appmetrica.analytics.impl.Za, io.appmetrica.analytics.impl.InterfaceC0225ed
    public final void clearAppEnvironment() {
        j().clearAppEnvironment();
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final C0627ua d() {
        return this.d.e();
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final String e() {
        return this.d.d();
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final Map<String, String> g() {
        return this.d.b();
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final AdvIdentifiersResult h() {
        return this.d.a();
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final Gc i() {
        return this.k;
    }

    public final InterfaceC0249fb j() {
        Gc gc = this.k;
        Intrinsics.checkNotNull(gc);
        return gc.f455a;
    }

    public final Bi k() {
        return this.g;
    }

    @Override // io.appmetrica.analytics.impl.Za, io.appmetrica.analytics.impl.InterfaceC0225ed
    public final void putAppEnvironmentValue(String str, String str2) {
        j().putAppEnvironmentValue(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.Za, io.appmetrica.analytics.impl.InterfaceC0225ed
    public final void setDataSendingEnabled(boolean z) {
        j().setDataSendingEnabled(z);
    }

    @Override // io.appmetrica.analytics.impl.Za, io.appmetrica.analytics.impl.InterfaceC0225ed
    public final void setUserProfileID(String str) {
        j().setUserProfileID(str);
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final void a(AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        C0341j0 c0341j0 = this.l;
        AppMetricaConfig f = c0341j0.f913a.f();
        if (f == null) {
            C0542r0 c0542r0 = c0341j0.b;
            c0542r0.getClass();
            AppMetricaConfig.Builder newConfigBuilder = AppMetricaConfig.newConfigBuilder("629a824d-c717-4ba5-bc0f-3f3968554d01");
            if (c0542r0.f1034a.b() && Intrinsics.areEqual(c0542r0.b.f1177a, Boolean.TRUE)) {
                newConfigBuilder.handleFirstActivationAsUpdate(true);
            }
            Boolean bool = appMetricaLibraryAdapterConfig.advIdentifiersTracking;
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            newConfigBuilder.withAdvIdentifiersTracking(bool.booleanValue());
            f = newConfigBuilder.build();
        }
        PublicLogger mainPublicOrAnonymousLogger = LoggerStorage.getMainPublicOrAnonymousLogger();
        if (a(mainPublicOrAnonymousLogger, f, new C0667w0(this, f, mainPublicOrAnonymousLogger))) {
            ImportantLogger.INSTANCE.info("AppMetrica", "Activate AppMetrica in anonymous mode", new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final void b(AppMetricaConfig appMetricaConfig) {
        boolean z;
        PublicLogger orCreateMainPublicLogger = LoggerStorage.getOrCreateMainPublicLogger(appMetricaConfig.apiKey);
        boolean a2 = a(orCreateMainPublicLogger, appMetricaConfig, new C0642v0(this, appMetricaConfig, orCreateMainPublicLogger));
        if (a2 || this.m) {
            z = false;
        } else {
            a(appMetricaConfig, orCreateMainPublicLogger);
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

    @Override // io.appmetrica.analytics.impl.Za, io.appmetrica.analytics.impl.W6
    public final void a(int i, Bundle bundle) {
        this.d.b(bundle, null);
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        this.e.a(deferredDeeplinkParametersListener);
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        this.e.a(deferredDeeplinkListener);
    }

    @Override // io.appmetrica.analytics.impl.Za, io.appmetrica.analytics.impl.InterfaceC0225ed
    public final void b(boolean z) {
        j().b(z);
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final void a(ReporterConfig reporterConfig) {
        this.g.a(reporterConfig);
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final void a(StartupParamsCallback startupParamsCallback, List<String> list) {
        this.d.a(startupParamsCallback, list, Db.c(this.f.f635a.getAsString("PROCESS_CFG_CLIDS")));
    }

    public final boolean a(PublicLogger publicLogger, AppMetricaConfig appMetricaConfig, Tc tc) {
        if (this.k == null) {
            a(appMetricaConfig, publicLogger);
            this.e.a();
            Ec a2 = tc.a();
            V7 v7 = new V7(a2);
            Gc gc = new Gc(a2, v7);
            this.b.c().a(v7);
            this.k = gc;
            H5 h5 = this.j.b;
            synchronized (h5) {
                h5.f470a = a2;
                Iterator it = h5.b.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0556re) it.next()).consume(a2);
                }
                h5.b.clear();
            }
            return true;
        }
        tc.a();
        return false;
    }

    public final void a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
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
            this.b.d().a(this.f1132a, appMetricaConfig, this);
            this.b.d().b();
            publicLogger.info("Register application crash handler", new Object[0]);
        } else {
            this.b.d().a();
            publicLogger.info("Disable all crash handlers", new Object[0]);
        }
        if (((Boolean) WrapUtils.getOrDefault(appMetricaConfig.sessionsAutoTrackingEnabled, bool2)).booleanValue()) {
            this.j.a();
        } else {
            C0182cl c0182cl = this.j;
            synchronized (c0182cl) {
                if (c0182cl.g) {
                    c0182cl.f816a.unregisterListener(c0182cl.c, ActivityEvent.RESUMED);
                    c0182cl.f816a.unregisterListener(c0182cl.d, ActivityEvent.PAUSED);
                    c0182cl.g = false;
                }
            }
        }
        this.f.d(appMetricaConfig);
        Tl tl = this.d;
        tl.e = publicLogger;
        tl.b(appMetricaConfig.customHosts);
        Tl tl2 = this.d;
        Object obj = appMetricaConfig.additionalConfig.get("YMM_clids");
        tl2.a(obj instanceof Map ? (Map) obj : null);
        String str = (String) appMetricaConfig.additionalConfig.get("YMM_distributionReferrer");
        this.d.a(str);
        if (str != null) {
            this.d.b("api");
        }
        this.h.a(appMetricaConfig.locationTracking, appMetricaConfig.dataSendingEnabled, appMetricaConfig.advIdentifiersTracking);
        this.d.i();
    }

    @Override // io.appmetrica.analytics.impl.Za, io.appmetrica.analytics.impl.InterfaceC0225ed
    public final void a(Location location) {
        j().a(location);
    }

    @Override // io.appmetrica.analytics.impl.Za, io.appmetrica.analytics.impl.InterfaceC0225ed
    public final void a(boolean z) {
        j().a(z);
    }

    @Override // io.appmetrica.analytics.impl.Za, io.appmetrica.analytics.impl.InterfaceC0225ed
    public final void a(String str, String str2) {
        j().a(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.Za, io.appmetrica.analytics.impl.InterfaceC0529qb
    public final InterfaceC0504pb a() {
        return this.g;
    }
}
