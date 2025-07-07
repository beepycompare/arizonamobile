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
public final class C0700x0 implements Va {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1114a;
    public final Ua b;
    public final C0317hf c;
    public final Ll d;
    public final C0641ug e;
    public final Nf f;
    public final C0643ui g;
    public final Gi h;
    public final W7 i;
    public final Uk j;
    public volatile Cc k;
    public final C0351j0 l;
    public boolean m;

    public C0700x0(Context context, Ua ua) {
        this.f1114a = context;
        this.b = ua;
        C0317hf b = C0704x4.l().b(context);
        this.c = b;
        Gd.a();
        C0704x4 l = C0704x4.l();
        l.m().a(new C0281g4(context));
        Nf a2 = AbstractC0725y0.a(context, AbstractC0725y0.a(ua.b(), this));
        this.f = a2;
        W7 j = l.j();
        this.i = j;
        Gi a3 = AbstractC0725y0.a(a2, context, ua.getDefaultExecutor());
        this.h = a3;
        j.a(a3);
        Ll a4 = AbstractC0725y0.a(context, a3, b, ua.b());
        this.d = a4;
        a3.a(a4);
        this.e = AbstractC0725y0.a(a3, b, ua.b());
        this.g = AbstractC0725y0.a(context, a2, a3, ua.b(), a4);
        this.j = l.o();
        this.l = new C0351j0(b);
    }

    @Override // io.appmetrica.analytics.impl.Va
    public final InterfaceC0387kb c(ReporterConfig reporterConfig) {
        return this.g.b(reporterConfig);
    }

    @Override // io.appmetrica.analytics.impl.Va, io.appmetrica.analytics.impl.InterfaceC0137ad
    public final void clearAppEnvironment() {
        j().clearAppEnvironment();
    }

    @Override // io.appmetrica.analytics.impl.Va
    public final C0536qa d() {
        return this.d.e();
    }

    @Override // io.appmetrica.analytics.impl.Va
    public final String e() {
        return this.d.d();
    }

    @Override // io.appmetrica.analytics.impl.Va
    public final Map<String, String> g() {
        return this.d.b();
    }

    @Override // io.appmetrica.analytics.impl.Va
    public final AdvIdentifiersResult h() {
        return this.d.a();
    }

    @Override // io.appmetrica.analytics.impl.Va
    public final Cc i() {
        return this.k;
    }

    public final InterfaceC0161bb j() {
        Cc cc = this.k;
        Intrinsics.checkNotNull(cc);
        return cc.f372a;
    }

    public final C0643ui k() {
        return this.g;
    }

    @Override // io.appmetrica.analytics.impl.Va, io.appmetrica.analytics.impl.InterfaceC0137ad
    public final void putAppEnvironmentValue(String str, String str2) {
        j().putAppEnvironmentValue(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.Va, io.appmetrica.analytics.impl.InterfaceC0137ad
    public final void setDataSendingEnabled(boolean z) {
        j().setDataSendingEnabled(z);
    }

    @Override // io.appmetrica.analytics.impl.Va, io.appmetrica.analytics.impl.InterfaceC0137ad
    public final void setUserProfileID(String str) {
        j().setUserProfileID(str);
    }

    @Override // io.appmetrica.analytics.impl.Va
    public final void a(AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        C0351j0 c0351j0 = this.l;
        AppMetricaConfig f = c0351j0.f883a.f();
        if (f == null) {
            C0550r0 c0550r0 = c0351j0.b;
            c0550r0.getClass();
            AppMetricaConfig.Builder newConfigBuilder = AppMetricaConfig.newConfigBuilder("629a824d-c717-4ba5-bc0f-3f3968554d01");
            if (c0550r0.f1014a.c() && Intrinsics.areEqual(c0550r0.b.f1089a, Boolean.TRUE)) {
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
        if (a(mainPublicOrAnonymousLogger, f, new C0675w0(this, f, mainPublicOrAnonymousLogger))) {
            ImportantLogger.INSTANCE.info("AppMetrica", "Activate AppMetrica in anonymous mode", new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.Va
    public final void b(AppMetricaConfig appMetricaConfig) {
        boolean z;
        PublicLogger orCreateMainPublicLogger = LoggerStorage.getOrCreateMainPublicLogger(appMetricaConfig.apiKey);
        boolean a2 = a(orCreateMainPublicLogger, appMetricaConfig, new C0650v0(this, appMetricaConfig, orCreateMainPublicLogger));
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

    @Override // io.appmetrica.analytics.impl.Va, io.appmetrica.analytics.impl.S6
    public final void a(int i, Bundle bundle) {
        this.d.b(bundle, null);
    }

    @Override // io.appmetrica.analytics.impl.Va
    public final void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        this.e.a(deferredDeeplinkParametersListener);
    }

    @Override // io.appmetrica.analytics.impl.Va
    public final void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        this.e.a(deferredDeeplinkListener);
    }

    @Override // io.appmetrica.analytics.impl.Va, io.appmetrica.analytics.impl.InterfaceC0137ad
    public final void b(boolean z) {
        j().b(z);
    }

    @Override // io.appmetrica.analytics.impl.Va
    public final void a(ReporterConfig reporterConfig) {
        this.g.a(reporterConfig);
    }

    @Override // io.appmetrica.analytics.impl.Va
    public final void a(StartupParamsCallback startupParamsCallback, List<String> list) {
        this.d.a(startupParamsCallback, list, AbstractC0761zb.c(this.f.f553a.getAsString("PROCESS_CFG_CLIDS")));
    }

    public final boolean a(PublicLogger publicLogger, AppMetricaConfig appMetricaConfig, Pc pc) {
        if (this.k == null) {
            a(appMetricaConfig, publicLogger);
            this.e.a();
            Ac a2 = pc.a();
            R7 r7 = new R7(a2);
            Cc cc = new Cc(a2, r7);
            this.b.c().a(r7);
            this.k = cc;
            F5 f5 = this.j.b;
            synchronized (f5) {
                f5.f423a = a2;
                Iterator it = f5.b.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0465ne) it.next()).consume(a2);
                }
                f5.b.clear();
            }
            return true;
        }
        pc.a();
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
            this.b.d().a(this.f1114a, appMetricaConfig, this);
            this.b.d().b();
            publicLogger.info("Register application crash handler", new Object[0]);
        } else {
            this.b.d().a();
            publicLogger.info("Disable all crash handlers", new Object[0]);
        }
        if (((Boolean) WrapUtils.getOrDefault(appMetricaConfig.sessionsAutoTrackingEnabled, bool2)).booleanValue()) {
            this.j.a();
        } else {
            Uk uk = this.j;
            synchronized (uk) {
                if (uk.g) {
                    uk.f662a.unregisterListener(uk.c, ActivityEvent.RESUMED);
                    uk.f662a.unregisterListener(uk.d, ActivityEvent.PAUSED);
                    uk.g = false;
                }
            }
        }
        this.f.d(appMetricaConfig);
        Ll ll = this.d;
        ll.e = publicLogger;
        ll.b(appMetricaConfig.customHosts);
        Ll ll2 = this.d;
        Object obj = appMetricaConfig.additionalConfig.get("YMM_clids");
        ll2.a(obj instanceof Map ? (Map) obj : null);
        String str = (String) appMetricaConfig.additionalConfig.get("YMM_distributionReferrer");
        this.d.a(str);
        if (str != null) {
            this.d.b("api");
        }
        this.h.a(appMetricaConfig.locationTracking, appMetricaConfig.dataSendingEnabled, appMetricaConfig.advIdentifiersTracking);
        this.d.i();
    }

    @Override // io.appmetrica.analytics.impl.Va, io.appmetrica.analytics.impl.InterfaceC0137ad
    public final void a(Location location) {
        j().a(location);
    }

    @Override // io.appmetrica.analytics.impl.Va, io.appmetrica.analytics.impl.InterfaceC0137ad
    public final void a(boolean z) {
        j().a(z);
    }

    @Override // io.appmetrica.analytics.impl.Va, io.appmetrica.analytics.impl.InterfaceC0137ad
    public final void a(String str, String str2) {
        j().a(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.Va, io.appmetrica.analytics.impl.InterfaceC0437mb
    public final InterfaceC0412lb a() {
        return this.g;
    }
}
