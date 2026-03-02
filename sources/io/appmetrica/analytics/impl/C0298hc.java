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
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashClientConfig;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashClientModule;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.hc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0298hc extends I2 implements Ia {
    public static final Long r = Long.valueOf(TimeUnit.SECONDS.toMillis(1));
    public final C0574sc p;
    public final C0324ic q;

    public C0298hc(C0574sc c0574sc) {
        super(c0574sc.b(), c0574sc.i(), c0574sc.h(), c0574sc.d(), c0574sc.f(), c0574sc.j(), c0574sc.g(), c0574sc.c(), c0574sc.a(), c0574sc.e());
        this.p = c0574sc;
        this.q = new C0324ic(this);
        l();
    }

    public final void a(AppMetricaConfig appMetricaConfig, C0388l0 c0388l0) {
        if (c0388l0.b) {
            clearAppEnvironment();
        }
        List<String> list = c0388l0.f1086a;
        if (!CollectionUtils.isNullOrEmpty(list)) {
            this.b.b.addAutoCollectedDataSubscribers(list);
        }
        a(appMetricaConfig.appEnvironment);
        b(appMetricaConfig.errorEnvironment);
        boolean booleanValue = ((Boolean) WrapUtils.getOrDefault(appMetricaConfig.nativeCrashReporting, Boolean.TRUE)).booleanValue();
        this.c.info("native crash reporting enabled: %b", Boolean.valueOf(booleanValue));
        if (booleanValue) {
            Bd bd = this.p.c;
            Context context = this.f621a;
            bd.d = new H0(this.b.b.getApiKey(), bd.f518a.f520a.getAsString("PROCESS_CFG_PACKAGE_NAME"), CounterConfigurationReporterType.MAIN, bd.f518a.f520a.getAsInteger("PROCESS_CFG_PROCESS_ID").intValue(), bd.f518a.f520a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID"), this.b.d());
            File nativeCrashDirectory = FileUtils.getNativeCrashDirectory(context);
            H0 h0 = null;
            String absolutePath = nativeCrashDirectory != null ? nativeCrashDirectory.getAbsolutePath() : null;
            if (absolutePath != null) {
                NativeCrashClientModule nativeCrashClientModule = bd.b;
                I0 i0 = bd.c;
                H0 h02 = bd.d;
                if (h02 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("nativeCrashMetadata");
                } else {
                    h0 = h02;
                }
                i0.getClass();
                nativeCrashClientModule.initHandling(context, new NativeCrashClientConfig(absolutePath, I0.a(h0)));
            }
        }
        C0324ic c0324ic = this.q;
        synchronized (c0324ic) {
            Integer num = appMetricaConfig.anrMonitoringTimeout;
            c0324ic.f1043a = num != null ? num.intValue() : 5;
            Boolean bool = appMetricaConfig.anrMonitoring;
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            if (bool.booleanValue()) {
                c0324ic.b.a(c0324ic.f1043a);
            } else {
                c0324ic.b.b();
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final void b(Activity activity) {
        if (this.p.i.a(activity, EnumC0487p.PAUSED)) {
            this.c.info("Pause session", new Object[0]);
            c(activity != null ? activity.getClass().getSimpleName() : null);
            C0210e2 c0210e2 = this.p.g;
            synchronized (c0210e2) {
                c0210e2.getClass();
                for (C0185d2 c0185d2 : c0210e2.f968a) {
                    if (!c0185d2.d) {
                        c0185d2.d = true;
                        c0185d2.b.executeDelayed(c0185d2.e, c0185d2.c);
                    }
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final void c() {
        C0324ic c0324ic = this.q;
        synchronized (c0324ic) {
            c0324ic.b.a(c0324ic.f1043a);
        }
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final List<String> f() {
        return this.b.f607a.b();
    }

    @Override // io.appmetrica.analytics.impl.I2
    public final String j() {
        return "[MainReporter]";
    }

    @Override // io.appmetrica.analytics.impl.I2
    public final void k() {
        super.k();
        C0135b4.l().m().c();
    }

    public final void l() {
        C0680wi c0680wi = this.h;
        c0680wi.c.a(this.b.f607a);
        C0210e2 c0210e2 = this.p.g;
        C0272gc c0272gc = new C0272gc(this);
        long longValue = r.longValue();
        synchronized (c0210e2) {
            c0210e2.a(c0272gc, longValue);
        }
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final void a(String str, boolean z) {
        this.c.info("App opened via deeplink: " + WrapUtils.wrapToTag(str), new Object[0]);
        C0680wi c0680wi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0671w9.f1284a;
        HashMap hashMap = new HashMap();
        hashMap.put("type", TtmlNode.TEXT_EMPHASIS_MARK_OPEN);
        hashMap.put("link", str);
        hashMap.put("auto", Boolean.valueOf(z));
        String b = AbstractC0271gb.b(hashMap);
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        M3 m3 = new M3(b, "", 8208, 0, publicLogger);
        Fh fh = this.b;
        c0680wi.getClass();
        c0680wi.a(C0680wi.a(m3, fh), fh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final void a(EnumC0437n enumC0437n) {
        if (enumC0437n == EnumC0437n.b) {
            this.c.info("Enable activity auto tracking", new Object[0]);
        } else {
            this.c.warning("Could not enable activity auto tracking. " + enumC0437n.f1125a, new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final void a(Activity activity) {
        if (this.p.i.a(activity, EnumC0487p.RESUMED)) {
            this.c.info("Resume session", new Object[0]);
            d(activity != null ? activity.getClass().getSimpleName() : null);
            C0210e2 c0210e2 = this.p.g;
            synchronized (c0210e2) {
                c0210e2.getClass();
                for (C0185d2 c0185d2 : c0210e2.f968a) {
                    if (c0185d2.d) {
                        c0185d2.d = false;
                        c0185d2.b.remove(c0185d2.e);
                        C0298hc c0298hc = c0185d2.f949a.f1011a;
                        c0298hc.h.c.b(c0298hc.b.f607a);
                    }
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Ia, io.appmetrica.analytics.impl.Hc
    public final void a(Location location) {
        this.b.b.setManualLocation(location);
        this.c.info("Set location: %s", location);
    }

    @Override // io.appmetrica.analytics.impl.Ia, io.appmetrica.analytics.impl.Hc
    public final void a(boolean z) {
        this.b.b.setLocationTracking(z);
    }

    @Override // io.appmetrica.analytics.impl.Ia, io.appmetrica.analytics.impl.Hc
    public final void a(boolean z, boolean z2) {
        this.c.info("Set advIdentifiersTracking to %s", Boolean.valueOf(z));
        this.b.b.setAdvIdentifiersTracking(z, z2);
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final void a(Ho ho) {
        PublicLogger publicLogger = this.c;
        synchronized (ho) {
            ho.b = publicLogger;
        }
        Iterator it = ho.f619a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(publicLogger);
        }
        ho.f619a.clear();
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final void a(AnrListener anrListener) {
        this.q.a(anrListener);
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final void a(ExternalAttribution externalAttribution) {
        this.c.info("External attribution received: %s", externalAttribution);
        C0680wi c0680wi = this.h;
        byte[] bytes = externalAttribution.toBytes();
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0671w9.f1284a;
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        M3 m3 = new M3(bytes, "", 42, publicLogger);
        Fh fh = this.b;
        c0680wi.getClass();
        c0680wi.a(C0680wi.a(m3, fh), fh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.impl.I2, io.appmetrica.analytics.impl.Ia, io.appmetrica.analytics.impl.Hc
    public final void a(String str, String str2) {
        super.a(str, str2);
        Bd bd = this.p.c;
        String d = this.b.d();
        H0 h0 = bd.d;
        if (h0 != null) {
            H0 h02 = new H0(h0.f605a, h0.b, h0.c, h0.d, h0.e, d);
            bd.d = h02;
            NativeCrashClientModule nativeCrashClientModule = bd.b;
            bd.c.getClass();
            nativeCrashClientModule.updateAppMetricaMetadata(I0.a(h02));
        }
    }

    @Override // io.appmetrica.analytics.impl.Ia, io.appmetrica.analytics.impl.Hc
    public final void a(String str) {
        this.c.info("Add auto collected data subscriber: %s", str);
        this.b.b.addAutoCollectedDataSubscriber(str);
    }
}
