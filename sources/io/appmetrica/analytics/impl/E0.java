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
public final class E0 implements InterfaceC0221eb {

    /* renamed from: a  reason: collision with root package name */
    public final Context f520a;
    public final InterfaceC0196db b;
    public final C0665vf c;
    public final C0543qm d;
    public final C0770zg e;
    public final C0175cg f;
    public final Di g;
    public final Qi h;
    public final V7 i;
    public final Bl j;
    public volatile Lc k;
    public final C0469o0 l;
    public boolean m;

    public E0(Context context, InterfaceC0196db interfaceC0196db) {
        this.f520a = context;
        this.b = interfaceC0196db;
        C0665vf b = C0576s4.l().b(context);
        this.c = b;
        ArrayList a2 = Sd.a();
        C0576s4 l = C0576s4.l();
        l.m().a(new C0137b4(context));
        F0.a(context).a(a2);
        C0175cg a3 = F0.a(context, F0.a(interfaceC0196db.b(), this));
        this.f = a3;
        V7 j = l.j();
        this.i = j;
        Qi a4 = F0.a(a3, context, interfaceC0196db.getDefaultExecutor());
        this.h = a4;
        j.a(a4);
        C0543qm a5 = F0.a(context, a4, interfaceC0196db.b());
        this.d = a5;
        a4.a(a5);
        this.e = F0.a(a4, b, interfaceC0196db.b());
        this.g = F0.a(context, a3, a4, interfaceC0196db.b(), a5);
        this.j = l.o();
        this.l = new C0469o0(b);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0221eb
    public final InterfaceC0506pb c(ReporterConfig reporterConfig) {
        return this.g.b(reporterConfig);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0221eb, io.appmetrica.analytics.impl.InterfaceC0327id
    public final void clearAppEnvironment() {
        j().clearAppEnvironment();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0221eb
    public final C0582sa d() {
        return this.d.e();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0221eb
    public final String e() {
        return this.d.d();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0221eb
    public final Map<String, String> g() {
        return this.d.b();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0221eb
    public final AdvIdentifiersResult h() {
        return this.d.a();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0221eb
    public final Lc i() {
        return this.k;
    }

    public final InterfaceC0376kb j() {
        Lc lc = this.k;
        Intrinsics.checkNotNull(lc);
        return lc.f647a;
    }

    public final Di k() {
        return this.g;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0221eb, io.appmetrica.analytics.impl.InterfaceC0327id
    public final void putAppEnvironmentValue(String str, String str2) {
        j().putAppEnvironmentValue(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0221eb, io.appmetrica.analytics.impl.InterfaceC0327id
    public final void setDataSendingEnabled(boolean z) {
        j().setDataSendingEnabled(z);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0221eb, io.appmetrica.analytics.impl.InterfaceC0327id
    public final void setUserProfileID(String str) {
        j().setUserProfileID(str);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0221eb
    public final void a(AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        Boolean bool;
        V7 v7 = this.i;
        C0469o0 c0469o0 = this.l;
        C0728y0 c0728y0 = c0469o0.b;
        c0728y0.getClass();
        AppMetricaConfig.Builder newConfigBuilder = AppMetricaConfig.newConfigBuilder("629a824d-c717-4ba5-bc0f-3f3968554d01");
        if (c0728y0.f1285a.b() && Intrinsics.areEqual(c0728y0.b.f1314a, Boolean.TRUE)) {
            newConfigBuilder.handleFirstActivationAsUpdate(true);
        }
        Boolean bool2 = appMetricaLibraryAdapterConfig.advIdentifiersTracking;
        if (bool2 == null) {
            bool2 = Boolean.FALSE;
        }
        newConfigBuilder.withAdvIdentifiersTracking(bool2.booleanValue());
        AppMetricaConfig build = newConfigBuilder.build();
        AppMetricaConfig.Builder f = c0469o0.f1125a.f();
        if (f != null) {
            if (f.build().advIdentifiersTracking == null && (bool = build.advIdentifiersTracking) != null) {
                f.withAdvIdentifiersTracking(bool.booleanValue());
            }
            build = f.build();
        }
        AppMetricaConfig.Builder a2 = v7.a(build);
        v7.a(a2, build);
        AppMetricaConfig build2 = a2.build();
        PublicLogger mainPublicOrAnonymousLogger = LoggerStorage.getMainPublicOrAnonymousLogger();
        if (a(mainPublicOrAnonymousLogger, build2, new D0(this, build2, mainPublicOrAnonymousLogger), false)) {
            ImportantLogger.INSTANCE.info("AppMetrica", "Activate AppMetrica in anonymous mode", new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0221eb
    public final void b(AppMetricaConfig appMetricaConfig) {
        boolean z;
        PublicLogger orCreateMainPublicLogger = LoggerStorage.getOrCreateMainPublicLogger(appMetricaConfig.apiKey);
        boolean a2 = a(orCreateMainPublicLogger, appMetricaConfig, new C0(this, appMetricaConfig, orCreateMainPublicLogger), true);
        if (a2 || this.m) {
            z = false;
        } else {
            a(orCreateMainPublicLogger, appMetricaConfig, true);
            if (appMetricaConfig.userProfileID != null) {
                j().setUserProfileID(appMetricaConfig.userProfileID);
            }
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

    @Override // io.appmetrica.analytics.impl.InterfaceC0221eb, io.appmetrica.analytics.impl.S6
    public final void a(int i, Bundle bundle) {
        this.d.b(bundle, null);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0221eb
    public final void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        this.e.a(deferredDeeplinkParametersListener);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0221eb
    public final void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        this.e.a(deferredDeeplinkListener);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0221eb
    public final void a(ReporterConfig reporterConfig) {
        this.g.a(reporterConfig);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0221eb
    public final void a(StartupParamsCallback startupParamsCallback, List<String> list) {
        this.d.a(startupParamsCallback, list, Ib.c(this.f.f930a.getAsString("PROCESS_CFG_CLIDS")));
    }

    public final boolean a(PublicLogger publicLogger, AppMetricaConfig appMetricaConfig, Xc xc, boolean z) {
        if (this.k == null) {
            a(publicLogger, appMetricaConfig, z);
            this.e.a();
            Jc a2 = xc.a();
            Q7 q7 = new Q7(a2);
            Lc lc = new Lc(a2, q7);
            this.b.c().a(q7);
            this.k = lc;
            C5 c5 = this.j.b;
            synchronized (c5) {
                c5.f490a = a2;
                Iterator it = c5.b.iterator();
                while (it.hasNext()) {
                    ((Be) it.next()).consume(a2);
                }
                c5.b.clear();
            }
            return true;
        }
        xc.a();
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
        InterfaceC0196db interfaceC0196db = this.b;
        if (booleanValue) {
            interfaceC0196db.d().a(this.f520a, appMetricaConfig, this);
            this.b.d().b();
            publicLogger.info("Register application crash handler", new Object[0]);
        } else {
            interfaceC0196db.d().a();
            publicLogger.info("Disable all crash handlers", new Object[0]);
        }
        boolean booleanValue2 = ((Boolean) WrapUtils.getOrDefault(appMetricaConfig.sessionsAutoTrackingEnabled, bool2)).booleanValue();
        Bl bl = this.j;
        if (booleanValue2) {
            bl.a();
        } else {
            synchronized (bl) {
                if (bl.g) {
                    bl.f483a.unregisterListener(bl.c, ActivityEvent.RESUMED);
                    bl.f483a.unregisterListener(bl.d, ActivityEvent.PAUSED);
                    bl.g = false;
                }
            }
        }
        this.f.d(appMetricaConfig);
        C0543qm c0543qm = this.d;
        c0543qm.e = publicLogger;
        c0543qm.b(appMetricaConfig.customHosts);
        C0543qm c0543qm2 = this.d;
        Object obj = appMetricaConfig.additionalConfig.get("YMM_clids");
        c0543qm2.a(obj instanceof Map ? (Map) obj : null);
        String str = (String) appMetricaConfig.additionalConfig.get("YMM_distributionReferrer");
        this.d.a(str);
        if (str != null) {
            this.d.b("api");
        }
        this.h.a(appMetricaConfig.locationTracking, appMetricaConfig.dataSendingEnabled, appMetricaConfig.advIdentifiersTracking, Boolean.valueOf(z));
        this.d.i();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0221eb, io.appmetrica.analytics.impl.InterfaceC0327id
    public final void a(Location location) {
        j().a(location);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0221eb, io.appmetrica.analytics.impl.InterfaceC0327id
    public final void a(boolean z) {
        j().a(z);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0221eb, io.appmetrica.analytics.impl.InterfaceC0327id
    public final void a(boolean z, boolean z2) {
        j().a(z, z2);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0221eb, io.appmetrica.analytics.impl.InterfaceC0327id
    public final void a(String str, String str2) {
        j().a(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0221eb, io.appmetrica.analytics.impl.InterfaceC0327id
    public final void a(String str) {
        j().a(str);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0221eb, io.appmetrica.analytics.impl.InterfaceC0557rb
    public final InterfaceC0532qb a() {
        return this.g;
    }
}
