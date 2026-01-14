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
public final class C0299hc extends I2 implements Ia {
    public static final Long r = Long.valueOf(TimeUnit.SECONDS.toMillis(1));
    public final C0575sc p;
    public final C0325ic q;

    public C0299hc(C0575sc c0575sc) {
        super(c0575sc.b(), c0575sc.i(), c0575sc.h(), c0575sc.d(), c0575sc.f(), c0575sc.j(), c0575sc.g(), c0575sc.c(), c0575sc.a(), c0575sc.e());
        this.p = c0575sc;
        this.q = new C0325ic(this);
        l();
    }

    public final void a(AppMetricaConfig appMetricaConfig, C0389l0 c0389l0) {
        if (c0389l0.b) {
            clearAppEnvironment();
        }
        List<String> list = c0389l0.f1087a;
        if (!CollectionUtils.isNullOrEmpty(list)) {
            this.b.b.addAutoCollectedDataSubscribers(list);
        }
        a(appMetricaConfig.appEnvironment);
        b(appMetricaConfig.errorEnvironment);
        boolean booleanValue = ((Boolean) WrapUtils.getOrDefault(appMetricaConfig.nativeCrashReporting, Boolean.TRUE)).booleanValue();
        this.c.info("native crash reporting enabled: %b", Boolean.valueOf(booleanValue));
        if (booleanValue) {
            Bd bd = this.p.c;
            Context context = this.f622a;
            bd.d = new H0(this.b.b.getApiKey(), bd.f519a.f521a.getAsString("PROCESS_CFG_PACKAGE_NAME"), CounterConfigurationReporterType.MAIN, bd.f519a.f521a.getAsInteger("PROCESS_CFG_PROCESS_ID").intValue(), bd.f519a.f521a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID"), this.b.d());
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
        C0325ic c0325ic = this.q;
        synchronized (c0325ic) {
            Integer num = appMetricaConfig.anrMonitoringTimeout;
            c0325ic.f1044a = num != null ? num.intValue() : 5;
            Boolean bool = appMetricaConfig.anrMonitoring;
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            if (bool.booleanValue()) {
                c0325ic.b.a(c0325ic.f1044a);
            } else {
                c0325ic.b.b();
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final void b(Activity activity) {
        if (this.p.i.a(activity, EnumC0488p.PAUSED)) {
            this.c.info("Pause session", new Object[0]);
            c(activity != null ? activity.getClass().getSimpleName() : null);
            C0211e2 c0211e2 = this.p.g;
            synchronized (c0211e2) {
                c0211e2.getClass();
                for (C0186d2 c0186d2 : c0211e2.f969a) {
                    if (!c0186d2.d) {
                        c0186d2.d = true;
                        c0186d2.b.executeDelayed(c0186d2.e, c0186d2.c);
                    }
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final void c() {
        C0325ic c0325ic = this.q;
        synchronized (c0325ic) {
            c0325ic.b.a(c0325ic.f1044a);
        }
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final List<String> f() {
        return this.b.f608a.b();
    }

    @Override // io.appmetrica.analytics.impl.I2
    public final String j() {
        return "[MainReporter]";
    }

    @Override // io.appmetrica.analytics.impl.I2
    public final void k() {
        super.k();
        C0136b4.l().m().c();
    }

    public final void l() {
        C0681wi c0681wi = this.h;
        c0681wi.c.a(this.b.f608a);
        C0211e2 c0211e2 = this.p.g;
        C0273gc c0273gc = new C0273gc(this);
        long longValue = r.longValue();
        synchronized (c0211e2) {
            c0211e2.a(c0273gc, longValue);
        }
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final void a(String str, boolean z) {
        this.c.info("App opened via deeplink: " + WrapUtils.wrapToTag(str), new Object[0]);
        C0681wi c0681wi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0672w9.f1285a;
        HashMap hashMap = new HashMap();
        hashMap.put("type", TtmlNode.TEXT_EMPHASIS_MARK_OPEN);
        hashMap.put("link", str);
        hashMap.put("auto", Boolean.valueOf(z));
        String b = AbstractC0272gb.b(hashMap);
        EnumC0143bb enumC0143bb = EnumC0143bb.EVENT_TYPE_UNDEFINED;
        M3 m3 = new M3(b, "", 8208, 0, publicLogger);
        Fh fh = this.b;
        c0681wi.getClass();
        c0681wi.a(C0681wi.a(m3, fh), fh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final void a(EnumC0438n enumC0438n) {
        if (enumC0438n == EnumC0438n.b) {
            this.c.info("Enable activity auto tracking", new Object[0]);
        } else {
            this.c.warning("Could not enable activity auto tracking. " + enumC0438n.f1126a, new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final void a(Activity activity) {
        if (this.p.i.a(activity, EnumC0488p.RESUMED)) {
            this.c.info("Resume session", new Object[0]);
            d(activity != null ? activity.getClass().getSimpleName() : null);
            C0211e2 c0211e2 = this.p.g;
            synchronized (c0211e2) {
                c0211e2.getClass();
                for (C0186d2 c0186d2 : c0211e2.f969a) {
                    if (c0186d2.d) {
                        c0186d2.d = false;
                        c0186d2.b.remove(c0186d2.e);
                        C0299hc c0299hc = c0186d2.f950a.f1012a;
                        c0299hc.h.c.b(c0299hc.b.f608a);
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
        Iterator it = ho.f620a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(publicLogger);
        }
        ho.f620a.clear();
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final void a(AnrListener anrListener) {
        this.q.a(anrListener);
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final void a(ExternalAttribution externalAttribution) {
        this.c.info("External attribution received: %s", externalAttribution);
        C0681wi c0681wi = this.h;
        byte[] bytes = externalAttribution.toBytes();
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0672w9.f1285a;
        EnumC0143bb enumC0143bb = EnumC0143bb.EVENT_TYPE_UNDEFINED;
        M3 m3 = new M3(bytes, "", 42, publicLogger);
        Fh fh = this.b;
        c0681wi.getClass();
        c0681wi.a(C0681wi.a(m3, fh), fh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.impl.I2, io.appmetrica.analytics.impl.Ia, io.appmetrica.analytics.impl.Hc
    public final void a(String str, String str2) {
        super.a(str, str2);
        Bd bd = this.p.c;
        String d = this.b.d();
        H0 h0 = bd.d;
        if (h0 != null) {
            H0 h02 = new H0(h0.f606a, h0.b, h0.c, h0.d, h0.e, d);
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
