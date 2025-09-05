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
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class Hc extends Y2 implements InterfaceC0327ib {
    public static final Long s = Long.valueOf(TimeUnit.SECONDS.toMillis(1));
    public final Kn p;
    public final Sc q;
    public final Ic r;

    public Hc(Sc sc) {
        super(sc.b(), sc.i(), sc.h(), sc.d(), sc.f(), sc.j(), sc.g(), sc.c(), sc.a(), sc.e());
        this.p = new Kn(new C0635ue("Referral url"));
        this.q = sc;
        this.r = new Ic(this);
        l();
    }

    public final void a(AppMetricaConfig appMetricaConfig, C0367k0 c0367k0) {
        if (c0367k0.b) {
            clearAppEnvironment();
        }
        List<String> list = c0367k0.f940a;
        if (!CollectionUtils.isNullOrEmpty(list)) {
            this.b.b.addAutoCollectedDataSubscribers(list);
        }
        a(appMetricaConfig.appEnvironment);
        b(appMetricaConfig.errorEnvironment);
        boolean booleanValue = ((Boolean) WrapUtils.getOrDefault(appMetricaConfig.nativeCrashReporting, Boolean.TRUE)).booleanValue();
        this.c.info("native crash reporting enabled: %b", Boolean.valueOf(booleanValue));
        if (booleanValue) {
            Wd wd = this.q.c;
            Context context = this.f747a;
            wd.d = new E0(this.b.b.getApiKey(), wd.f723a.f708a.getAsString("PROCESS_CFG_PACKAGE_NAME"), CounterConfigurationReporterType.MAIN, wd.f723a.f708a.getAsInteger("PROCESS_CFG_PROCESS_ID").intValue(), wd.f723a.f708a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID"), this.b.d());
            File nativeCrashDirectory = FileUtils.getNativeCrashDirectory(context);
            E0 e0 = null;
            String absolutePath = nativeCrashDirectory != null ? nativeCrashDirectory.getAbsolutePath() : null;
            if (absolutePath != null) {
                NativeCrashClientModule nativeCrashClientModule = wd.b;
                F0 f0 = wd.c;
                E0 e02 = wd.d;
                if (e02 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("nativeCrashMetadata");
                } else {
                    e0 = e02;
                }
                f0.getClass();
                nativeCrashClientModule.initHandling(context, new NativeCrashClientConfig(absolutePath, F0.a(e0)));
            }
        }
        Ic ic = this.r;
        synchronized (ic) {
            Integer num = appMetricaConfig.anrMonitoringTimeout;
            ic.f491a = num != null ? num.intValue() : 5;
            Boolean bool = appMetricaConfig.anrMonitoring;
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            if (bool.booleanValue()) {
                ic.b.a(ic.f491a);
            } else {
                ic.b.b();
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0327ib
    public final void b(Activity activity) {
        if (this.q.i.a(activity, EnumC0470o.PAUSED)) {
            this.c.info("Pause session", new Object[0]);
            d(activity != null ? activity.getClass().getSimpleName() : null);
            C0421m2 c0421m2 = this.q.g;
            synchronized (c0421m2) {
                c0421m2.getClass();
                for (C0395l2 c0395l2 : c0421m2.f980a) {
                    if (!c0395l2.d) {
                        c0395l2.d = true;
                        c0395l2.b.executeDelayed(c0395l2.e, c0395l2.c);
                    }
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0327ib
    public final void c() {
        Ic ic = this.r;
        synchronized (ic) {
            ic.b.a(ic.f491a);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0327ib
    public final List<String> f() {
        return this.b.f884a.b();
    }

    @Override // io.appmetrica.analytics.impl.Y2
    public final String j() {
        return "[MainReporter]";
    }

    @Override // io.appmetrica.analytics.impl.Y2
    public final void k() {
        super.k();
        A4.l().m().c();
    }

    public final void l() {
        Si si = this.h;
        si.c.a(this.b.f884a);
        C0421m2 c0421m2 = this.q.g;
        Gc gc = new Gc(this);
        long longValue = s.longValue();
        synchronized (c0421m2) {
            c0421m2.a(gc, longValue);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0327ib
    public final void c(String str) {
        this.p.a(str);
        Si si = this.h;
        PublicLogger publicLogger = this.c;
        Set set = W9.f721a;
        HashMap hashMap = new HashMap();
        hashMap.put("type", "referral");
        hashMap.put("link", str);
        hashMap.put("auto", Boolean.FALSE);
        String b = Gb.b(hashMap);
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        C0397l4 c0397l4 = new C0397l4(b, "", 8208, 0, publicLogger);
        C0153bi c0153bi = this.b;
        si.getClass();
        si.a(Si.a(c0397l4, c0153bi), c0153bi, 1, null);
        this.c.info("Referral URL received: " + WrapUtils.wrapToTag(str), new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0327ib, io.appmetrica.analytics.impl.InterfaceC0303hd
    public final void b(boolean z) {
        this.c.info("Set advIdentifiersTracking to %s", Boolean.valueOf(z));
        this.b.b.setAdvIdentifiersTracking(z);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0327ib
    public final void a(String str, boolean z) {
        this.c.info("App opened via deeplink: " + WrapUtils.wrapToTag(str), new Object[0]);
        Si si = this.h;
        PublicLogger publicLogger = this.c;
        Set set = W9.f721a;
        HashMap hashMap = new HashMap();
        hashMap.put("type", TtmlNode.TEXT_EMPHASIS_MARK_OPEN);
        hashMap.put("link", str);
        hashMap.put("auto", Boolean.valueOf(z));
        String b = Gb.b(hashMap);
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        C0397l4 c0397l4 = new C0397l4(b, "", 8208, 0, publicLogger);
        C0153bi c0153bi = this.b;
        si.getClass();
        si.a(Si.a(c0397l4, c0153bi), c0153bi, 1, null);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0327ib
    public final void a(EnumC0418m enumC0418m) {
        if (enumC0418m == EnumC0418m.b) {
            this.c.info("Enable activity auto tracking", new Object[0]);
        } else {
            this.c.warning("Could not enable activity auto tracking. " + enumC0418m.f977a, new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0327ib
    public final void a(Activity activity) {
        if (this.q.i.a(activity, EnumC0470o.RESUMED)) {
            this.c.info("Resume session", new Object[0]);
            e(activity != null ? activity.getClass().getSimpleName() : null);
            C0421m2 c0421m2 = this.q.g;
            synchronized (c0421m2) {
                c0421m2.getClass();
                for (C0395l2 c0395l2 : c0421m2.f980a) {
                    if (c0395l2.d) {
                        c0395l2.d = false;
                        c0395l2.b.remove(c0395l2.e);
                        Hc hc = c0395l2.f958a.f455a;
                        hc.h.c.b(hc.b.f884a);
                    }
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0327ib, io.appmetrica.analytics.impl.InterfaceC0303hd
    public final void a(Location location) {
        this.b.b.setManualLocation(location);
        this.c.info("Set location: %s", location);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0327ib, io.appmetrica.analytics.impl.InterfaceC0303hd
    public final void a(boolean z) {
        this.b.b.setLocationTracking(z);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0327ib
    public final void a(Mo mo) {
        PublicLogger publicLogger = this.c;
        synchronized (mo) {
            mo.b = publicLogger;
        }
        Iterator it = mo.f580a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(publicLogger);
        }
        mo.f580a.clear();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0327ib
    public final void a(AnrListener anrListener) {
        this.r.a(anrListener);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0327ib
    public final void a(ExternalAttribution externalAttribution) {
        this.c.info("External attribution received: %s", externalAttribution);
        Si si = this.h;
        byte[] bytes = externalAttribution.toBytes();
        PublicLogger publicLogger = this.c;
        Set set = W9.f721a;
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        C0397l4 c0397l4 = new C0397l4(bytes, "", 42, publicLogger);
        C0153bi c0153bi = this.b;
        si.getClass();
        si.a(Si.a(c0397l4, c0153bi), c0153bi, 1, null);
    }

    @Override // io.appmetrica.analytics.impl.Y2, io.appmetrica.analytics.impl.InterfaceC0327ib, io.appmetrica.analytics.impl.InterfaceC0303hd
    public final void a(String str, String str2) {
        super.a(str, str2);
        Wd wd = this.q.c;
        String d = this.b.d();
        E0 e0 = wd.d;
        if (e0 != null) {
            E0 e02 = new E0(e0.f415a, e0.b, e0.c, e0.d, e0.e, d);
            wd.d = e02;
            NativeCrashClientModule nativeCrashClientModule = wd.b;
            wd.c.getClass();
            nativeCrashClientModule.updateAppMetricaMetadata(F0.a(e02));
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0327ib, io.appmetrica.analytics.impl.InterfaceC0303hd
    public final void a(String str) {
        this.c.info("Add auto collected data subscriber: %s", str);
        this.b.b.addAutoCollectedDataSubscriber(str);
    }
}
