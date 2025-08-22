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
public final class Ec extends V2 implements InterfaceC0249fb {
    public static final Long s = Long.valueOf(TimeUnit.SECONDS.toMillis(1));
    public final Gn p;
    public final Pc q;
    public final Fc r;

    public Ec(Pc pc) {
        super(pc.b(), pc.i(), pc.h(), pc.d(), pc.f(), pc.j(), pc.g(), pc.c(), pc.a(), pc.e());
        this.p = new Gn(new C0532qe("Referral url"));
        this.q = pc;
        this.r = new Fc(this);
        l();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb
    public final void a(String str, boolean z) {
        this.c.info("App opened via deeplink: " + WrapUtils.wrapToTag(str), new Object[0]);
        Oi oi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = T9.f659a;
        HashMap hashMap = new HashMap();
        hashMap.put("type", TtmlNode.TEXT_EMPHASIS_MARK_OPEN);
        hashMap.put("link", str);
        hashMap.put("auto", Boolean.valueOf(z));
        String b = Db.b(hashMap);
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        C0320i4 c0320i4 = new C0320i4(b, "", 8208, 0, publicLogger);
        Xh xh = this.b;
        oi.getClass();
        oi.a(Oi.a(c0320i4, xh), xh, 1, null);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb
    public final void b(String str) {
        this.p.a(str);
        Oi oi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = T9.f659a;
        HashMap hashMap = new HashMap();
        hashMap.put("type", "referral");
        hashMap.put("link", str);
        hashMap.put("auto", Boolean.FALSE);
        String b = Db.b(hashMap);
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        C0320i4 c0320i4 = new C0320i4(b, "", 8208, 0, publicLogger);
        Xh xh = this.b;
        oi.getClass();
        oi.a(Oi.a(c0320i4, xh), xh, 1, null);
        this.c.info("Referral URL received: " + WrapUtils.wrapToTag(str), new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb
    public final void c() {
        Fc fc = this.r;
        synchronized (fc) {
            fc.b.a(fc.f433a);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb
    public final List<String> f() {
        return this.b.f823a.b();
    }

    @Override // io.appmetrica.analytics.impl.V2
    public final String j() {
        return "[MainReporter]";
    }

    @Override // io.appmetrica.analytics.impl.V2
    public final void k() {
        super.k();
        C0696x4.l().m().c();
    }

    public final void l() {
        Oi oi = this.h;
        oi.c.a(this.b.f823a);
        C0369k2 c0369k2 = this.q.g;
        Dc dc = new Dc(this);
        long longValue = s.longValue();
        synchronized (c0369k2) {
            c0369k2.a(dc, longValue);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb
    public final void a(EnumC0417m enumC0417m) {
        if (enumC0417m == EnumC0417m.b) {
            this.c.info("Enable activity auto tracking", new Object[0]);
        } else {
            this.c.warning("Could not enable activity auto tracking. " + enumC0417m.f959a, new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb
    public final void b(Activity activity) {
        if (this.q.i.a(activity, EnumC0467o.PAUSED)) {
            this.c.info("Pause session", new Object[0]);
            c(activity != null ? activity.getClass().getSimpleName() : null);
            C0369k2 c0369k2 = this.q.g;
            synchronized (c0369k2) {
                c0369k2.getClass();
                for (C0343j2 c0343j2 : c0369k2.f933a) {
                    if (!c0343j2.d) {
                        c0343j2.d = true;
                        c0343j2.b.executeDelayed(c0343j2.e, c0343j2.c);
                    }
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb
    public final void a(Activity activity) {
        if (this.q.i.a(activity, EnumC0467o.RESUMED)) {
            this.c.info("Resume session", new Object[0]);
            d(activity != null ? activity.getClass().getSimpleName() : null);
            C0369k2 c0369k2 = this.q.g;
            synchronized (c0369k2) {
                c0369k2.getClass();
                for (C0343j2 c0343j2 : c0369k2.f933a) {
                    if (c0343j2.d) {
                        c0343j2.d = false;
                        c0343j2.b.remove(c0343j2.e);
                        Ec ec = c0343j2.f915a.f394a;
                        ec.h.c.b(ec.b.f823a);
                    }
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb, io.appmetrica.analytics.impl.InterfaceC0225ed
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
            Sd sd = this.q.c;
            Context context = this.f688a;
            sd.d = new C0(this.b.b.getApiKey(), sd.f648a.f635a.getAsString("PROCESS_CFG_PACKAGE_NAME"), CounterConfigurationReporterType.MAIN, sd.f648a.f635a.getAsInteger("PROCESS_CFG_PROCESS_ID").intValue(), sd.f648a.f635a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID"), this.b.d());
            File nativeCrashDirectory = FileUtils.getNativeCrashDirectory(context);
            C0 c0 = null;
            String absolutePath = nativeCrashDirectory != null ? nativeCrashDirectory.getAbsolutePath() : null;
            if (absolutePath != null) {
                NativeCrashClientModule nativeCrashClientModule = sd.b;
                D0 d0 = sd.c;
                C0 c02 = sd.d;
                if (c02 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("nativeCrashMetadata");
                } else {
                    c0 = c02;
                }
                d0.getClass();
                nativeCrashClientModule.initHandling(context, new NativeCrashClientConfig(absolutePath, D0.a(c0)));
            }
        }
        Fc fc = this.r;
        synchronized (fc) {
            Integer num = appMetricaConfig.anrMonitoringTimeout;
            fc.f433a = num != null ? num.intValue() : 5;
            Boolean bool = appMetricaConfig.anrMonitoring;
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            if (bool.booleanValue()) {
                fc.b.a(fc.f433a);
            } else {
                fc.b.b();
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb, io.appmetrica.analytics.impl.InterfaceC0225ed
    public final void a(Location location) {
        this.b.b.setManualLocation(location);
        this.c.info("Set location: %s", location);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb, io.appmetrica.analytics.impl.InterfaceC0225ed
    public final void a(boolean z) {
        this.b.b.setLocationTracking(z);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb
    public final void a(Io io2) {
        PublicLogger publicLogger = this.c;
        synchronized (io2) {
            io2.b = publicLogger;
        }
        Iterator it = io2.f504a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(publicLogger);
        }
        io2.f504a.clear();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb
    public final void a(AnrListener anrListener) {
        this.r.a(anrListener);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb
    public final void a(ExternalAttribution externalAttribution) {
        this.c.info("External attribution received: %s", externalAttribution);
        Oi oi = this.h;
        byte[] bytes = externalAttribution.toBytes();
        PublicLogger publicLogger = this.c;
        Set set = T9.f659a;
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        C0320i4 c0320i4 = new C0320i4(bytes, "", 42, publicLogger);
        Xh xh = this.b;
        oi.getClass();
        oi.a(Oi.a(c0320i4, xh), xh, 1, null);
    }

    @Override // io.appmetrica.analytics.impl.V2, io.appmetrica.analytics.impl.InterfaceC0249fb, io.appmetrica.analytics.impl.InterfaceC0225ed
    public final void a(String str, String str2) {
        super.a(str, str2);
        Sd sd = this.q.c;
        String d = this.b.d();
        C0 c0 = sd.d;
        if (c0 != null) {
            C0 c02 = new C0(c0.f370a, c0.b, c0.c, c0.d, c0.e, d);
            sd.d = c02;
            NativeCrashClientModule nativeCrashClientModule = sd.b;
            sd.c.getClass();
            nativeCrashClientModule.updateAppMetricaMetadata(D0.a(c02));
        }
    }
}
