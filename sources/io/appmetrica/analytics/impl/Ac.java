package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import androidx.media3.extractor.text.ttml.TtmlNode;
import io.appmetrica.analytics.AnrListener;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ExternalAttribution;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashClientConfig;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashClientModule;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class Ac extends V2 implements InterfaceC0161bb {
    public static final Long s = Long.valueOf(TimeUnit.SECONDS.toMillis(1));
    public final C0748yn p;
    public final Lc q;
    public final Bc r;

    public Ac(Lc lc) {
        super(lc.b(), lc.i(), lc.h(), lc.d(), lc.f(), lc.j(), lc.g(), lc.c(), lc.a(), lc.e());
        this.p = new C0748yn(new C0440me("Referral url"));
        this.q = lc;
        this.r = new Bc(this);
        l();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0161bb
    public final void a(String str, boolean z) {
        this.c.info("App opened via deeplink: " + WrapUtils.wrapToTag(str), new Object[0]);
        Gi gi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = O9.f564a;
        HashMap hashMap = new HashMap();
        hashMap.put("type", TtmlNode.TEXT_EMPHASIS_MARK_OPEN);
        hashMap.put("link", str);
        hashMap.put("auto", Boolean.valueOf(z));
        String b = AbstractC0761zb.b(hashMap);
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        C0331i4 c0331i4 = new C0331i4(b, "", 8208, 0, publicLogger);
        Qh qh = this.b;
        gi.getClass();
        gi.a(Gi.a(c0331i4, qh), qh, 1, null);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0161bb
    public final void b(String str) {
        this.p.a(str);
        Gi gi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = O9.f564a;
        HashMap hashMap = new HashMap();
        hashMap.put("type", "referral");
        hashMap.put("link", str);
        hashMap.put("auto", Boolean.FALSE);
        String b = AbstractC0761zb.b(hashMap);
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        C0331i4 c0331i4 = new C0331i4(b, "", 8208, 0, publicLogger);
        Qh qh = this.b;
        gi.getClass();
        gi.a(Gi.a(c0331i4, qh), qh, 1, null);
        this.c.info("Referral URL received: " + WrapUtils.wrapToTag(str), new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0161bb
    public final void c() {
        Bc bc = this.r;
        synchronized (bc) {
            bc.b.a(bc.f353a);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0161bb
    public final List<String> f() {
        return this.b.f796a.b();
    }

    @Override // io.appmetrica.analytics.impl.V2
    public final String j() {
        return "[MainReporter]";
    }

    @Override // io.appmetrica.analytics.impl.V2
    public final void k() {
        super.k();
        C0704x4.l().m().c();
    }

    public final void l() {
        Gi gi = this.h;
        gi.c.a(this.b.f796a);
        C0378k2 c0378k2 = this.q.g;
        C0762zc c0762zc = new C0762zc(this);
        long longValue = s.longValue();
        synchronized (c0378k2) {
            c0378k2.a(c0762zc, longValue);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0161bb
    public final void a(EnumC0425m enumC0425m) {
        if (enumC0425m == EnumC0425m.b) {
            this.c.info("Enable activity auto tracking", new Object[0]);
        } else {
            this.c.warning("Could not enable activity auto tracking. " + enumC0425m.f928a, new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0161bb
    public final void b(Activity activity) {
        if (this.q.i.a(activity, EnumC0475o.PAUSED)) {
            this.c.info("Pause session", new Object[0]);
            c(activity != null ? activity.getClass().getSimpleName() : null);
            C0378k2 c0378k2 = this.q.g;
            synchronized (c0378k2) {
                c0378k2.getClass();
                for (C0353j2 c0353j2 : c0378k2.f899a) {
                    if (!c0353j2.d) {
                        c0353j2.d = true;
                        c0353j2.b.executeDelayed(c0353j2.e, c0353j2.c);
                    }
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0161bb
    public final void a(Activity activity) {
        if (this.q.i.a(activity, EnumC0475o.RESUMED)) {
            this.c.info("Resume session", new Object[0]);
            d(activity != null ? activity.getClass().getSimpleName() : null);
            C0378k2 c0378k2 = this.q.g;
            synchronized (c0378k2) {
                c0378k2.getClass();
                for (C0353j2 c0353j2 : c0378k2.f899a) {
                    if (c0353j2.d) {
                        c0353j2.d = false;
                        c0353j2.b.remove(c0353j2.e);
                        Ac ac = c0353j2.f885a.f1163a;
                        ac.h.c.b(ac.b.f796a);
                    }
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0161bb, io.appmetrica.analytics.impl.InterfaceC0137ad
    public final void b(boolean z) {
        this.c.info("Set advIdentifiersTracking to %s", Boolean.valueOf(z));
        this.b.b.setAdvIdentifiersTracking(z);
    }

    public final void a(AppMetricaConfig appMetricaConfig, boolean z) {
        if (z) {
            clearAppEnvironment();
        }
        a(appMetricaConfig.appEnvironment);
        b(appMetricaConfig.errorEnvironment);
        boolean booleanValue = ((Boolean) WrapUtils.getOrDefault(appMetricaConfig.nativeCrashReporting, Boolean.TRUE)).booleanValue();
        this.c.info("native crash reporting enabled: %b", Boolean.valueOf(booleanValue));
        if (booleanValue) {
            Od od = this.q.c;
            Context context = this.f667a;
            od.d = new C0(this.b.b.getApiKey(), od.f565a.f553a.getAsString("PROCESS_CFG_PACKAGE_NAME"), CounterConfigurationReporterType.MAIN, od.f565a.f553a.getAsInteger("PROCESS_CFG_PROCESS_ID").intValue(), od.f565a.f553a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID"), this.b.d());
            File nativeCrashDirectory = FileUtils.getNativeCrashDirectory(context);
            C0 c0 = null;
            String absolutePath = nativeCrashDirectory != null ? nativeCrashDirectory.getAbsolutePath() : null;
            if (absolutePath != null) {
                NativeCrashClientModule nativeCrashClientModule = od.b;
                D0 d0 = od.c;
                C0 c02 = od.d;
                if (c02 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("nativeCrashMetadata");
                } else {
                    c0 = c02;
                }
                d0.getClass();
                nativeCrashClientModule.initHandling(context, new NativeCrashClientConfig(absolutePath, D0.a(c0)));
            }
        }
        Bc bc = this.r;
        synchronized (bc) {
            Integer num = appMetricaConfig.anrMonitoringTimeout;
            bc.f353a = num != null ? num.intValue() : 5;
            Boolean bool = appMetricaConfig.anrMonitoring;
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            if (bool.booleanValue()) {
                bc.b.a(bc.f353a);
            } else {
                bc.b.b();
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0161bb, io.appmetrica.analytics.impl.InterfaceC0137ad
    public final void a(Location location) {
        this.b.b.setManualLocation(location);
        this.c.info("Set location: %s", location);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0161bb, io.appmetrica.analytics.impl.InterfaceC0137ad
    public final void a(boolean z) {
        this.b.b.setLocationTracking(z);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0161bb
    public final void a(Ao ao) {
        PublicLogger publicLogger = this.c;
        synchronized (ao) {
            ao.b = publicLogger;
        }
        Iterator it = ao.f343a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(publicLogger);
        }
        ao.f343a.clear();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0161bb
    public final void a(AnrListener anrListener) {
        this.r.a(anrListener);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0161bb
    public final void a(ExternalAttribution externalAttribution) {
        this.c.info("External attribution received: %s", externalAttribution);
        Gi gi = this.h;
        byte[] bytes = externalAttribution.toBytes();
        PublicLogger publicLogger = this.c;
        Set set = O9.f564a;
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        C0331i4 c0331i4 = new C0331i4(bytes, "", 42, publicLogger);
        Qh qh = this.b;
        gi.getClass();
        gi.a(Gi.a(c0331i4, qh), qh, 1, null);
    }

    @Override // io.appmetrica.analytics.impl.V2, io.appmetrica.analytics.impl.InterfaceC0161bb, io.appmetrica.analytics.impl.InterfaceC0137ad
    public final void a(String str, String str2) {
        super.a(str, str2);
        Od od = this.q.c;
        String d = this.b.d();
        C0 c0 = od.d;
        if (c0 != null) {
            C0 c02 = new C0(c0.f362a, c0.b, c0.c, c0.d, c0.e, d);
            od.d = c02;
            NativeCrashClientModule nativeCrashClientModule = od.b;
            od.c.getClass();
            nativeCrashClientModule.updateAppMetricaMetadata(D0.a(c02));
        }
    }
}
