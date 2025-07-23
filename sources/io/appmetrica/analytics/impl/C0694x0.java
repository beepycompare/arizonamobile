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
public final class C0694x0 implements Xa {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1127a;
    public final Wa b;
    public final C0360jf c;
    public final Ol d;
    public final C0685wg e;
    public final Pf f;
    public final C0687wi g;
    public final Ji h;
    public final Z7 i;
    public final Xk j;
    public volatile Ec k;
    public final C0345j0 l;
    public boolean m;

    public C0694x0(Context context, Wa wa) {
        this.f1127a = context;
        this.b = wa;
        C0360jf b = C0698x4.l().b(context);
        this.c = b;
        Id.a();
        C0698x4 l = C0698x4.l();
        l.m().a(new C0275g4(context));
        Pf a2 = AbstractC0719y0.a(context, AbstractC0719y0.a(wa.b(), this));
        this.f = a2;
        Z7 j = l.j();
        this.i = j;
        Ji a3 = AbstractC0719y0.a(a2, context, wa.getDefaultExecutor());
        this.h = a3;
        j.a(a3);
        Ol a4 = AbstractC0719y0.a(context, a3, b, wa.b());
        this.d = a4;
        a3.a(a4);
        this.e = AbstractC0719y0.a(a3, b, wa.b());
        this.g = AbstractC0719y0.a(context, a2, a3, wa.b(), a4);
        this.j = l.o();
        this.l = new C0345j0(b);
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final InterfaceC0431mb c(ReporterConfig reporterConfig) {
        return this.g.b(reporterConfig);
    }

    @Override // io.appmetrica.analytics.impl.Xa, io.appmetrica.analytics.impl.InterfaceC0181cd
    public final void clearAppEnvironment() {
        j().clearAppEnvironment();
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final C0579sa d() {
        return this.d.e();
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final String e() {
        return this.d.d();
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final Map<String, String> g() {
        return this.d.b();
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final AdvIdentifiersResult h() {
        return this.d.a();
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final Ec i() {
        return this.k;
    }

    public final InterfaceC0205db j() {
        Ec ec = this.k;
        Intrinsics.checkNotNull(ec);
        return ec.f416a;
    }

    public final C0687wi k() {
        return this.g;
    }

    @Override // io.appmetrica.analytics.impl.Xa, io.appmetrica.analytics.impl.InterfaceC0181cd
    public final void putAppEnvironmentValue(String str, String str2) {
        j().putAppEnvironmentValue(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.Xa, io.appmetrica.analytics.impl.InterfaceC0181cd
    public final void setDataSendingEnabled(boolean z) {
        j().setDataSendingEnabled(z);
    }

    @Override // io.appmetrica.analytics.impl.Xa, io.appmetrica.analytics.impl.InterfaceC0181cd
    public final void setUserProfileID(String str) {
        j().setUserProfileID(str);
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        C0345j0 c0345j0 = this.l;
        AppMetricaConfig f = c0345j0.f908a.f();
        if (f == null) {
            C0544r0 c0544r0 = c0345j0.b;
            c0544r0.getClass();
            AppMetricaConfig.Builder newConfigBuilder = AppMetricaConfig.newConfigBuilder("629a824d-c717-4ba5-bc0f-3f3968554d01");
            if (c0544r0.f1026a.c() && Intrinsics.areEqual(c0544r0.b.f1135a, Boolean.TRUE)) {
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
        if (a(mainPublicOrAnonymousLogger, f, new C0669w0(this, f, mainPublicOrAnonymousLogger))) {
            ImportantLogger.INSTANCE.info("AppMetrica", "Activate AppMetrica in anonymous mode", new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void b(AppMetricaConfig appMetricaConfig) {
        boolean z;
        PublicLogger orCreateMainPublicLogger = LoggerStorage.getOrCreateMainPublicLogger(appMetricaConfig.apiKey);
        boolean a2 = a(orCreateMainPublicLogger, appMetricaConfig, new C0644v0(this, appMetricaConfig, orCreateMainPublicLogger));
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

    @Override // io.appmetrica.analytics.impl.Xa, io.appmetrica.analytics.impl.V6
    public final void a(int i, Bundle bundle) {
        this.d.b(bundle, null);
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        this.e.a(deferredDeeplinkParametersListener);
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        this.e.a(deferredDeeplinkListener);
    }

    @Override // io.appmetrica.analytics.impl.Xa, io.appmetrica.analytics.impl.InterfaceC0181cd
    public final void b(boolean z) {
        j().b(z);
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(ReporterConfig reporterConfig) {
        this.g.a(reporterConfig);
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(StartupParamsCallback startupParamsCallback, List<String> list) {
        this.d.a(startupParamsCallback, list, Bb.c(this.f.f595a.getAsString("PROCESS_CFG_CLIDS")));
    }

    public final boolean a(PublicLogger publicLogger, AppMetricaConfig appMetricaConfig, Rc rc) {
        if (this.k == null) {
            a(appMetricaConfig, publicLogger);
            this.e.a();
            Cc a2 = rc.a();
            U7 u7 = new U7(a2);
            Ec ec = new Ec(a2, u7);
            this.b.c().a(u7);
            this.k = ec;
            H5 h5 = this.j.b;
            synchronized (h5) {
                h5.f465a = a2;
                Iterator it = h5.b.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0509pe) it.next()).consume(a2);
                }
                h5.b.clear();
            }
            return true;
        }
        rc.a();
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
            this.b.d().a(this.f1127a, appMetricaConfig, this);
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
                    xk.f722a.unregisterListener(xk.c, ActivityEvent.RESUMED);
                    xk.f722a.unregisterListener(xk.d, ActivityEvent.PAUSED);
                    xk.g = false;
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
        this.h.a(appMetricaConfig.locationTracking, appMetricaConfig.dataSendingEnabled, appMetricaConfig.advIdentifiersTracking);
        this.d.i();
    }

    @Override // io.appmetrica.analytics.impl.Xa, io.appmetrica.analytics.impl.InterfaceC0181cd
    public final void a(Location location) {
        j().a(location);
    }

    @Override // io.appmetrica.analytics.impl.Xa, io.appmetrica.analytics.impl.InterfaceC0181cd
    public final void a(boolean z) {
        j().a(z);
    }

    @Override // io.appmetrica.analytics.impl.Xa, io.appmetrica.analytics.impl.InterfaceC0181cd
    public final void a(String str, String str2) {
        j().a(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.Xa, io.appmetrica.analytics.impl.InterfaceC0481ob
    public final InterfaceC0456nb a() {
        return this.g;
    }
}
