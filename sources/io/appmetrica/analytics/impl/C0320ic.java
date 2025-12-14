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
/* renamed from: io.appmetrica.analytics.impl.ic  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0320ic extends J2 implements Ja {
    public static final Long s = Long.valueOf(TimeUnit.SECONDS.toMillis(1));
    public final Fn p;
    public final C0596tc q;
    public final C0345jc r;

    public C0320ic(C0596tc c0596tc) {
        super(c0596tc.b(), c0596tc.i(), c0596tc.h(), c0596tc.d(), c0596tc.f(), c0596tc.j(), c0596tc.g(), c0596tc.c(), c0596tc.a(), c0596tc.e());
        this.p = new Fn(new C0115ae("Referral url"));
        this.q = c0596tc;
        this.r = new C0345jc(this);
        l();
    }

    public final void a(AppMetricaConfig appMetricaConfig, C0385l0 c0385l0) {
        if (c0385l0.b) {
            clearAppEnvironment();
        }
        List<String> list = c0385l0.f1080a;
        if (!CollectionUtils.isNullOrEmpty(list)) {
            this.b.b.addAutoCollectedDataSubscribers(list);
        }
        a(appMetricaConfig.appEnvironment);
        b(appMetricaConfig.errorEnvironment);
        boolean booleanValue = ((Boolean) WrapUtils.getOrDefault(appMetricaConfig.nativeCrashReporting, Boolean.TRUE)).booleanValue();
        this.c.info("native crash reporting enabled: %b", Boolean.valueOf(booleanValue));
        if (booleanValue) {
            Cd cd = this.q.c;
            Context context = this.f630a;
            cd.d = new H0(this.b.b.getApiKey(), cd.f527a.f529a.getAsString("PROCESS_CFG_PACKAGE_NAME"), CounterConfigurationReporterType.MAIN, cd.f527a.f529a.getAsInteger("PROCESS_CFG_PROCESS_ID").intValue(), cd.f527a.f529a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID"), this.b.d());
            File nativeCrashDirectory = FileUtils.getNativeCrashDirectory(context);
            H0 h0 = null;
            String absolutePath = nativeCrashDirectory != null ? nativeCrashDirectory.getAbsolutePath() : null;
            if (absolutePath != null) {
                NativeCrashClientModule nativeCrashClientModule = cd.b;
                I0 i0 = cd.c;
                H0 h02 = cd.d;
                if (h02 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("nativeCrashMetadata");
                } else {
                    h0 = h02;
                }
                i0.getClass();
                nativeCrashClientModule.initHandling(context, new NativeCrashClientConfig(absolutePath, I0.a(h0)));
            }
        }
        C0345jc c0345jc = this.r;
        synchronized (c0345jc) {
            Integer num = appMetricaConfig.anrMonitoringTimeout;
            c0345jc.f1052a = num != null ? num.intValue() : 5;
            Boolean bool = appMetricaConfig.anrMonitoring;
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            if (bool.booleanValue()) {
                c0345jc.b.a(c0345jc.f1052a);
            } else {
                c0345jc.b.b();
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void b(Activity activity) {
        if (this.q.i.a(activity, EnumC0484p.PAUSED)) {
            this.c.info("Pause session", new Object[0]);
            d(activity != null ? activity.getClass().getSimpleName() : null);
            C0232f2 c0232f2 = this.q.g;
            synchronized (c0232f2) {
                c0232f2.getClass();
                for (C0206e2 c0206e2 : c0232f2.f978a) {
                    if (!c0206e2.d) {
                        c0206e2.d = true;
                        c0206e2.b.executeDelayed(c0206e2.e, c0206e2.c);
                    }
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void c() {
        C0345jc c0345jc = this.r;
        synchronized (c0345jc) {
            c0345jc.b.a(c0345jc.f1052a);
        }
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final List<String> f() {
        return this.b.f615a.b();
    }

    @Override // io.appmetrica.analytics.impl.J2
    public final String j() {
        return "[MainReporter]";
    }

    @Override // io.appmetrica.analytics.impl.J2
    public final void k() {
        super.k();
        C0157c4.l().m().c();
    }

    public final void l() {
        C0702xi c0702xi = this.h;
        c0702xi.c.a(this.b.f615a);
        C0232f2 c0232f2 = this.q.g;
        C0294hc c0294hc = new C0294hc(this);
        long longValue = s.longValue();
        synchronized (c0232f2) {
            c0232f2.a(c0294hc, longValue);
        }
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void c(String str) {
        this.p.a(str);
        C0702xi c0702xi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0693x9.f1294a;
        HashMap hashMap = new HashMap();
        hashMap.put("type", "referral");
        hashMap.put("link", str);
        hashMap.put("auto", Boolean.FALSE);
        String b = AbstractC0293hb.b(hashMap);
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        N3 n3 = new N3(b, "", 8208, 0, publicLogger);
        Gh gh = this.b;
        c0702xi.getClass();
        c0702xi.a(C0702xi.a(n3, gh), gh, 1, (Map) null);
        this.c.info("Referral URL received: " + WrapUtils.wrapToTag(str), new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(String str, boolean z) {
        this.c.info("App opened via deeplink: " + WrapUtils.wrapToTag(str), new Object[0]);
        C0702xi c0702xi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0693x9.f1294a;
        HashMap hashMap = new HashMap();
        hashMap.put("type", TtmlNode.TEXT_EMPHASIS_MARK_OPEN);
        hashMap.put("link", str);
        hashMap.put("auto", Boolean.valueOf(z));
        String b = AbstractC0293hb.b(hashMap);
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        N3 n3 = new N3(b, "", 8208, 0, publicLogger);
        Gh gh = this.b;
        c0702xi.getClass();
        c0702xi.a(C0702xi.a(n3, gh), gh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(EnumC0434n enumC0434n) {
        if (enumC0434n == EnumC0434n.b) {
            this.c.info("Enable activity auto tracking", new Object[0]);
        } else {
            this.c.warning("Could not enable activity auto tracking. " + enumC0434n.f1114a, new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(Activity activity) {
        if (this.q.i.a(activity, EnumC0484p.RESUMED)) {
            this.c.info("Resume session", new Object[0]);
            e(activity != null ? activity.getClass().getSimpleName() : null);
            C0232f2 c0232f2 = this.q.g;
            synchronized (c0232f2) {
                c0232f2.getClass();
                for (C0206e2 c0206e2 : c0232f2.f978a) {
                    if (c0206e2.d) {
                        c0206e2.d = false;
                        c0206e2.b.remove(c0206e2.e);
                        C0320ic c0320ic = c0206e2.f959a.f1019a;
                        c0320ic.h.c.b(c0320ic.b.f615a);
                    }
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Ic
    public final void a(Location location) {
        this.b.b.setManualLocation(location);
        this.c.info("Set location: %s", location);
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Ic
    public final void a(boolean z) {
        this.b.b.setLocationTracking(z);
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Ic
    public final void a(boolean z, boolean z2) {
        this.c.info("Set advIdentifiersTracking to %s", Boolean.valueOf(z));
        this.b.b.setAdvIdentifiersTracking(z, z2);
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(Io io2) {
        PublicLogger publicLogger = this.c;
        synchronized (io2) {
            io2.b = publicLogger;
        }
        Iterator it = io2.f627a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(publicLogger);
        }
        io2.f627a.clear();
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(AnrListener anrListener) {
        this.r.a(anrListener);
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(ExternalAttribution externalAttribution) {
        this.c.info("External attribution received: %s", externalAttribution);
        C0702xi c0702xi = this.h;
        byte[] bytes = externalAttribution.toBytes();
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0693x9.f1294a;
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        N3 n3 = new N3(bytes, "", 42, publicLogger);
        Gh gh = this.b;
        c0702xi.getClass();
        c0702xi.a(C0702xi.a(n3, gh), gh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.impl.J2, io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Ic
    public final void a(String str, String str2) {
        super.a(str, str2);
        Cd cd = this.q.c;
        String d = this.b.d();
        H0 h0 = cd.d;
        if (h0 != null) {
            H0 h02 = new H0(h0.f596a, h0.b, h0.c, h0.d, h0.e, d);
            cd.d = h02;
            NativeCrashClientModule nativeCrashClientModule = cd.b;
            cd.c.getClass();
            nativeCrashClientModule.updateAppMetricaMetadata(I0.a(h02));
        }
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Ic
    public final void a(String str) {
        this.c.info("Add auto collected data subscriber: %s", str);
        this.b.b.addAutoCollectedDataSubscriber(str);
    }
}
