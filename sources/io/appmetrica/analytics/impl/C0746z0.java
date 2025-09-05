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
/* renamed from: io.appmetrica.analytics.impl.z0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0746z0 implements InterfaceC0172cb {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1175a;
    public final InterfaceC0146bb b;
    public final C0512pf c;
    public final Xl d;
    public final Fg e;
    public final Vf f;
    public final Fi g;
    public final Si h;
    public final C0195d8 i;
    public final C0285gl j;
    public volatile Jc k;
    public final C0393l0 l;
    public boolean m;

    public C0746z0(Context context, InterfaceC0146bb interfaceC0146bb) {
        this.f1175a = context;
        this.b = interfaceC0146bb;
        C0512pf b = A4.l().b(context);
        this.c = b;
        Od.a();
        A4 l = A4.l();
        l.m().a(new C0345j4(context));
        Vf a2 = A0.a(context, A0.a(interfaceC0146bb.b(), this));
        this.f = a2;
        C0195d8 j = l.j();
        this.i = j;
        Si a3 = A0.a(a2, context, interfaceC0146bb.getDefaultExecutor());
        this.h = a3;
        j.a(a3);
        Xl a4 = A0.a(context, a3, b, interfaceC0146bb.b());
        this.d = a4;
        a3.a(a4);
        this.e = A0.a(a3, b, interfaceC0146bb.b());
        this.g = A0.a(context, a2, a3, interfaceC0146bb.b(), a4);
        this.j = l.o();
        this.l = new C0393l0(b);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0172cb
    public final InterfaceC0557rb c(ReporterConfig reporterConfig) {
        return this.g.b(reporterConfig);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0172cb, io.appmetrica.analytics.impl.InterfaceC0303hd
    public final void clearAppEnvironment() {
        j().clearAppEnvironment();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0172cb
    public final C0706xa d() {
        return this.d.e();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0172cb
    public final String e() {
        return this.d.d();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0172cb
    public final Map<String, String> g() {
        return this.d.b();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0172cb
    public final AdvIdentifiersResult h() {
        return this.d.a();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0172cb
    public final Jc i() {
        return this.k;
    }

    public final InterfaceC0327ib j() {
        Jc jc = this.k;
        Intrinsics.checkNotNull(jc);
        return jc.f512a;
    }

    public final Fi k() {
        return this.g;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0172cb, io.appmetrica.analytics.impl.InterfaceC0303hd
    public final void putAppEnvironmentValue(String str, String str2) {
        j().putAppEnvironmentValue(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0172cb, io.appmetrica.analytics.impl.InterfaceC0303hd
    public final void setDataSendingEnabled(boolean z) {
        j().setDataSendingEnabled(z);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0172cb, io.appmetrica.analytics.impl.InterfaceC0303hd
    public final void setUserProfileID(String str) {
        j().setUserProfileID(str);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0172cb
    public final void a(AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        C0393l0 c0393l0 = this.l;
        AppMetricaConfig f = c0393l0.f956a.f();
        if (f == null) {
            C0596t0 c0596t0 = c0393l0.b;
            c0596t0.getClass();
            AppMetricaConfig.Builder newConfigBuilder = AppMetricaConfig.newConfigBuilder("629a824d-c717-4ba5-bc0f-3f3968554d01");
            if (c0596t0.f1083a.b() && Intrinsics.areEqual(c0596t0.b.f383a, Boolean.TRUE)) {
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
        if (a(mainPublicOrAnonymousLogger, f, new C0721y0(this, f, mainPublicOrAnonymousLogger))) {
            ImportantLogger.INSTANCE.info("AppMetrica", "Activate AppMetrica in anonymous mode", new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0172cb
    public final void b(AppMetricaConfig appMetricaConfig) {
        boolean z;
        PublicLogger orCreateMainPublicLogger = LoggerStorage.getOrCreateMainPublicLogger(appMetricaConfig.apiKey);
        boolean a2 = a(orCreateMainPublicLogger, appMetricaConfig, new C0696x0(this, appMetricaConfig, orCreateMainPublicLogger));
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

    @Override // io.appmetrica.analytics.impl.InterfaceC0172cb, io.appmetrica.analytics.impl.Z6
    public final void a(int i, Bundle bundle) {
        this.d.b(bundle, null);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0172cb
    public final void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        this.e.a(deferredDeeplinkParametersListener);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0172cb
    public final void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        this.e.a(deferredDeeplinkListener);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0172cb, io.appmetrica.analytics.impl.InterfaceC0303hd
    public final void b(boolean z) {
        j().b(z);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0172cb
    public final void a(ReporterConfig reporterConfig) {
        this.g.a(reporterConfig);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0172cb
    public final void a(StartupParamsCallback startupParamsCallback, List<String> list) {
        this.d.a(startupParamsCallback, list, Gb.c(this.f.f708a.getAsString("PROCESS_CFG_CLIDS")));
    }

    public final boolean a(PublicLogger publicLogger, AppMetricaConfig appMetricaConfig, Wc wc) {
        if (this.k == null) {
            a(appMetricaConfig, publicLogger);
            this.e.a();
            Hc a2 = wc.a();
            Y7 y7 = new Y7(a2);
            Jc jc = new Jc(a2, y7);
            this.b.c().a(y7);
            this.k = jc;
            K5 k5 = this.j.b;
            synchronized (k5) {
                k5.f528a = a2;
                Iterator it = k5.b.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0660ve) it.next()).consume(a2);
                }
                k5.b.clear();
            }
            return true;
        }
        wc.a();
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
            this.b.d().a(this.f1175a, appMetricaConfig, this);
            this.b.d().b();
            publicLogger.info("Register application crash handler", new Object[0]);
        } else {
            this.b.d().a();
            publicLogger.info("Disable all crash handlers", new Object[0]);
        }
        if (((Boolean) WrapUtils.getOrDefault(appMetricaConfig.sessionsAutoTrackingEnabled, bool2)).booleanValue()) {
            this.j.a();
        } else {
            C0285gl c0285gl = this.j;
            synchronized (c0285gl) {
                if (c0285gl.g) {
                    c0285gl.f896a.unregisterListener(c0285gl.c, ActivityEvent.RESUMED);
                    c0285gl.f896a.unregisterListener(c0285gl.d, ActivityEvent.PAUSED);
                    c0285gl.g = false;
                }
            }
        }
        this.f.d(appMetricaConfig);
        Xl xl = this.d;
        xl.e = publicLogger;
        xl.b(appMetricaConfig.customHosts);
        Xl xl2 = this.d;
        Object obj = appMetricaConfig.additionalConfig.get("YMM_clids");
        xl2.a(obj instanceof Map ? (Map) obj : null);
        String str = (String) appMetricaConfig.additionalConfig.get("YMM_distributionReferrer");
        this.d.a(str);
        if (str != null) {
            this.d.b("api");
        }
        this.h.a(appMetricaConfig.locationTracking, appMetricaConfig.dataSendingEnabled, appMetricaConfig.advIdentifiersTracking);
        this.d.i();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0172cb, io.appmetrica.analytics.impl.InterfaceC0303hd
    public final void a(Location location) {
        j().a(location);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0172cb, io.appmetrica.analytics.impl.InterfaceC0303hd
    public final void a(boolean z) {
        j().a(z);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0172cb, io.appmetrica.analytics.impl.InterfaceC0303hd
    public final void a(String str, String str2) {
        j().a(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0172cb, io.appmetrica.analytics.impl.InterfaceC0303hd
    public final void a(String str) {
        j().a(str);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0172cb, io.appmetrica.analytics.impl.InterfaceC0607tb
    public final InterfaceC0582sb a() {
        return this.g;
    }
}
