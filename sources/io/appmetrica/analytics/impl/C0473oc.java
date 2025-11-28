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
/* renamed from: io.appmetrica.analytics.impl.oc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0473oc extends Q2 implements Pa {
    public static final Long s = Long.valueOf(TimeUnit.SECONDS.toMillis(1));
    public final Gn p;
    public final C0747zc q;
    public final C0498pc r;

    public C0473oc(C0747zc c0747zc) {
        super(c0747zc.b(), c0747zc.i(), c0747zc.h(), c0747zc.d(), c0747zc.f(), c0747zc.j(), c0747zc.g(), c0747zc.c(), c0747zc.a(), c0747zc.e());
        this.p = new Gn(new C0271ge("Referral url"));
        this.q = c0747zc;
        this.r = new C0498pc(this);
        l();
    }

    public final void a(AppMetricaConfig appMetricaConfig, C0386l0 c0386l0) {
        if (c0386l0.b) {
            clearAppEnvironment();
        }
        List<String> list = c0386l0.f980a;
        if (!CollectionUtils.isNullOrEmpty(list)) {
            this.b.b.addAutoCollectedDataSubscribers(list);
        }
        a(appMetricaConfig.appEnvironment);
        b(appMetricaConfig.errorEnvironment);
        boolean booleanValue = ((Boolean) WrapUtils.getOrDefault(appMetricaConfig.nativeCrashReporting, Boolean.TRUE)).booleanValue();
        this.c.info("native crash reporting enabled: %b", Boolean.valueOf(booleanValue));
        if (booleanValue) {
            Id id = this.q.c;
            Context context = this.f645a;
            id.d = new F0(this.b.b.getApiKey(), id.f527a.f492a.getAsString("PROCESS_CFG_PACKAGE_NAME"), CounterConfigurationReporterType.MAIN, id.f527a.f492a.getAsInteger("PROCESS_CFG_PROCESS_ID").intValue(), id.f527a.f492a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID"), this.b.d());
            File nativeCrashDirectory = FileUtils.getNativeCrashDirectory(context);
            F0 f0 = null;
            String absolutePath = nativeCrashDirectory != null ? nativeCrashDirectory.getAbsolutePath() : null;
            if (absolutePath != null) {
                NativeCrashClientModule nativeCrashClientModule = id.b;
                G0 g0 = id.c;
                F0 f02 = id.d;
                if (f02 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("nativeCrashMetadata");
                } else {
                    f0 = f02;
                }
                g0.getClass();
                nativeCrashClientModule.initHandling(context, new NativeCrashClientConfig(absolutePath, G0.a(f0)));
            }
        }
        C0498pc c0498pc = this.r;
        synchronized (c0498pc) {
            Integer num = appMetricaConfig.anrMonitoringTimeout;
            c0498pc.f1056a = num != null ? num.intValue() : 5;
            Boolean bool = appMetricaConfig.anrMonitoring;
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            if (bool.booleanValue()) {
                c0498pc.b.a(c0498pc.f1056a);
            } else {
                c0498pc.b.b();
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Pa
    public final void b(Activity activity) {
        if (this.q.i.a(activity, EnumC0485p.PAUSED)) {
            this.c.info("Pause session", new Object[0]);
            d(activity != null ? activity.getClass().getSimpleName() : null);
            C0438n2 c0438n2 = this.q.g;
            synchronized (c0438n2) {
                c0438n2.getClass();
                for (C0413m2 c0413m2 : c0438n2.f1018a) {
                    if (!c0413m2.d) {
                        c0413m2.d = true;
                        c0413m2.b.executeDelayed(c0413m2.e, c0413m2.c);
                    }
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Pa
    public final void c() {
        C0498pc c0498pc = this.r;
        synchronized (c0498pc) {
            c0498pc.b.a(c0498pc.f1056a);
        }
    }

    @Override // io.appmetrica.analytics.impl.Pa
    public final List<String> f() {
        return this.b.f629a.b();
    }

    @Override // io.appmetrica.analytics.impl.Q2
    public final String j() {
        return "[MainReporter]";
    }

    @Override // io.appmetrica.analytics.impl.Q2
    public final void k() {
        super.k();
        C0338j4.l().m().c();
    }

    public final void l() {
        Bi bi = this.h;
        bi.c.a(this.b.f629a);
        C0438n2 c0438n2 = this.q.g;
        C0448nc c0448nc = new C0448nc(this);
        long longValue = s.longValue();
        synchronized (c0438n2) {
            c0438n2.a(c0448nc, longValue);
        }
    }

    @Override // io.appmetrica.analytics.impl.Pa
    public final void c(String str) {
        this.p.a(str);
        Bi bi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = D9.f438a;
        HashMap hashMap = new HashMap();
        hashMap.put("type", "referral");
        hashMap.put("link", str);
        hashMap.put("auto", Boolean.FALSE);
        String b = AbstractC0447nb.b(hashMap);
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        U3 u3 = new U3(b, "", 8208, 0, publicLogger);
        Kh kh = this.b;
        bi.getClass();
        bi.a(Bi.a(u3, kh), kh, 1, (Map) null);
        this.c.info("Referral URL received: " + WrapUtils.wrapToTag(str), new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.Pa
    public final void a(String str, boolean z) {
        this.c.info("App opened via deeplink: " + WrapUtils.wrapToTag(str), new Object[0]);
        Bi bi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = D9.f438a;
        HashMap hashMap = new HashMap();
        hashMap.put("type", TtmlNode.TEXT_EMPHASIS_MARK_OPEN);
        hashMap.put("link", str);
        hashMap.put("auto", Boolean.valueOf(z));
        String b = AbstractC0447nb.b(hashMap);
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        U3 u3 = new U3(b, "", 8208, 0, publicLogger);
        Kh kh = this.b;
        bi.getClass();
        bi.a(Bi.a(u3, kh), kh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.impl.Pa
    public final void a(EnumC0435n enumC0435n) {
        if (enumC0435n == EnumC0435n.b) {
            this.c.info("Enable activity auto tracking", new Object[0]);
        } else {
            this.c.warning("Could not enable activity auto tracking. " + enumC0435n.f1015a, new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.Pa
    public final void a(Activity activity) {
        if (this.q.i.a(activity, EnumC0485p.RESUMED)) {
            this.c.info("Resume session", new Object[0]);
            e(activity != null ? activity.getClass().getSimpleName() : null);
            C0438n2 c0438n2 = this.q.g;
            synchronized (c0438n2) {
                c0438n2.getClass();
                for (C0413m2 c0413m2 : c0438n2.f1018a) {
                    if (c0413m2.d) {
                        c0413m2.d = false;
                        c0413m2.b.remove(c0413m2.e);
                        C0473oc c0473oc = c0413m2.f1001a.f1024a;
                        c0473oc.h.c.b(c0473oc.b.f629a);
                    }
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Pa, io.appmetrica.analytics.impl.Oc
    public final void a(Location location) {
        this.b.b.setManualLocation(location);
        this.c.info("Set location: %s", location);
    }

    @Override // io.appmetrica.analytics.impl.Pa, io.appmetrica.analytics.impl.Oc
    public final void a(boolean z) {
        this.b.b.setLocationTracking(z);
    }

    @Override // io.appmetrica.analytics.impl.Pa, io.appmetrica.analytics.impl.Oc
    public final void a(boolean z, boolean z2) {
        this.c.info("Set advIdentifiersTracking to %s", Boolean.valueOf(z));
        this.b.b.setAdvIdentifiersTracking(z, z2);
    }

    @Override // io.appmetrica.analytics.impl.Pa
    public final void a(Io io2) {
        PublicLogger publicLogger = this.c;
        synchronized (io2) {
            io2.b = publicLogger;
        }
        Iterator it = io2.f535a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(publicLogger);
        }
        io2.f535a.clear();
    }

    @Override // io.appmetrica.analytics.impl.Pa
    public final void a(AnrListener anrListener) {
        this.r.a(anrListener);
    }

    @Override // io.appmetrica.analytics.impl.Pa
    public final void a(ExternalAttribution externalAttribution) {
        this.c.info("External attribution received: %s", externalAttribution);
        Bi bi = this.h;
        byte[] bytes = externalAttribution.toBytes();
        PublicLogger publicLogger = this.c;
        Set set = D9.f438a;
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        U3 u3 = new U3(bytes, "", 42, publicLogger);
        Kh kh = this.b;
        bi.getClass();
        bi.a(Bi.a(u3, kh), kh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.impl.Q2, io.appmetrica.analytics.impl.Pa, io.appmetrica.analytics.impl.Oc
    public final void a(String str, String str2) {
        super.a(str, str2);
        Id id = this.q.c;
        String d = this.b.d();
        F0 f0 = id.d;
        if (f0 != null) {
            F0 f02 = new F0(f0.f468a, f0.b, f0.c, f0.d, f0.e, d);
            id.d = f02;
            NativeCrashClientModule nativeCrashClientModule = id.b;
            id.c.getClass();
            nativeCrashClientModule.updateAppMetricaMetadata(G0.a(f02));
        }
    }

    @Override // io.appmetrica.analytics.impl.Pa, io.appmetrica.analytics.impl.Oc
    public final void a(String str) {
        this.c.info("Add auto collected data subscriber: %s", str);
        this.b.b.addAutoCollectedDataSubscriber(str);
    }
}
