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
public final class Cc extends V2 implements InterfaceC0206db {
    public static final Long s = Long.valueOf(TimeUnit.SECONDS.toMillis(1));
    public final Bn p;
    public final Nc q;
    public final Dc r;

    public Cc(Nc nc) {
        super(nc.b(), nc.i(), nc.h(), nc.d(), nc.f(), nc.j(), nc.g(), nc.c(), nc.a(), nc.e());
        this.p = new Bn(new C0485oe("Referral url"));
        this.q = nc;
        this.r = new Dc(this);
        l();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0206db
    public final void a(String str, boolean z) {
        this.c.info("App opened via deeplink: " + WrapUtils.wrapToTag(str), new Object[0]);
        Ji ji = this.h;
        PublicLogger publicLogger = this.c;
        Set set = R9.f620a;
        HashMap hashMap = new HashMap();
        hashMap.put("type", TtmlNode.TEXT_EMPHASIS_MARK_OPEN);
        hashMap.put("link", str);
        hashMap.put("auto", Boolean.valueOf(z));
        String b = Bb.b(hashMap);
        EnumC0681wb enumC0681wb = EnumC0681wb.EVENT_TYPE_UNDEFINED;
        C0326i4 c0326i4 = new C0326i4(b, "", 8208, 0, publicLogger);
        Sh sh = this.b;
        ji.getClass();
        ji.a(Ji.a(c0326i4, sh), sh, 1, null);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0206db
    public final void b(String str) {
        this.p.a(str);
        Ji ji = this.h;
        PublicLogger publicLogger = this.c;
        Set set = R9.f620a;
        HashMap hashMap = new HashMap();
        hashMap.put("type", "referral");
        hashMap.put("link", str);
        hashMap.put("auto", Boolean.FALSE);
        String b = Bb.b(hashMap);
        EnumC0681wb enumC0681wb = EnumC0681wb.EVENT_TYPE_UNDEFINED;
        C0326i4 c0326i4 = new C0326i4(b, "", 8208, 0, publicLogger);
        Sh sh = this.b;
        ji.getClass();
        ji.a(Ji.a(c0326i4, sh), sh, 1, null);
        this.c.info("Referral URL received: " + WrapUtils.wrapToTag(str), new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0206db
    public final void c() {
        Dc dc = this.r;
        synchronized (dc) {
            dc.b.a(dc.f395a);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0206db
    public final List<String> f() {
        return this.b.f811a.b();
    }

    @Override // io.appmetrica.analytics.impl.V2
    public final String j() {
        return "[MainReporter]";
    }

    @Override // io.appmetrica.analytics.impl.V2
    public final void k() {
        super.k();
        C0699x4.l().m().c();
    }

    public final void l() {
        Ji ji = this.h;
        ji.c.a(this.b.f811a);
        C0373k2 c0373k2 = this.q.g;
        Bc bc = new Bc(this);
        long longValue = s.longValue();
        synchronized (c0373k2) {
            c0373k2.a(bc, longValue);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0206db
    public final void a(EnumC0420m enumC0420m) {
        if (enumC0420m == EnumC0420m.b) {
            this.c.info("Enable activity auto tracking", new Object[0]);
        } else {
            this.c.warning("Could not enable activity auto tracking. " + enumC0420m.f944a, new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0206db
    public final void b(Activity activity) {
        if (this.q.i.a(activity, EnumC0470o.PAUSED)) {
            this.c.info("Pause session", new Object[0]);
            c(activity != null ? activity.getClass().getSimpleName() : null);
            C0373k2 c0373k2 = this.q.g;
            synchronized (c0373k2) {
                c0373k2.getClass();
                for (C0348j2 c0348j2 : c0373k2.f921a) {
                    if (!c0348j2.d) {
                        c0348j2.d = true;
                        c0348j2.b.executeDelayed(c0348j2.e, c0348j2.c);
                    }
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0206db
    public final void a(Activity activity) {
        if (this.q.i.a(activity, EnumC0470o.RESUMED)) {
            this.c.info("Resume session", new Object[0]);
            d(activity != null ? activity.getClass().getSimpleName() : null);
            C0373k2 c0373k2 = this.q.g;
            synchronized (c0373k2) {
                c0373k2.getClass();
                for (C0348j2 c0348j2 : c0373k2.f921a) {
                    if (c0348j2.d) {
                        c0348j2.d = false;
                        c0348j2.b.remove(c0348j2.e);
                        Cc cc = c0348j2.f910a.f355a;
                        cc.h.c.b(cc.b.f811a);
                    }
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0206db, io.appmetrica.analytics.impl.InterfaceC0182cd
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
            Qd qd = this.q.c;
            Context context = this.f680a;
            qd.d = new C0(this.b.b.getApiKey(), qd.f610a.f595a.getAsString("PROCESS_CFG_PACKAGE_NAME"), CounterConfigurationReporterType.MAIN, qd.f610a.f595a.getAsInteger("PROCESS_CFG_PROCESS_ID").intValue(), qd.f610a.f595a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID"), this.b.d());
            File nativeCrashDirectory = FileUtils.getNativeCrashDirectory(context);
            C0 c0 = null;
            String absolutePath = nativeCrashDirectory != null ? nativeCrashDirectory.getAbsolutePath() : null;
            if (absolutePath != null) {
                NativeCrashClientModule nativeCrashClientModule = qd.b;
                D0 d0 = qd.c;
                C0 c02 = qd.d;
                if (c02 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("nativeCrashMetadata");
                } else {
                    c0 = c02;
                }
                d0.getClass();
                nativeCrashClientModule.initHandling(context, new NativeCrashClientConfig(absolutePath, D0.a(c0)));
            }
        }
        Dc dc = this.r;
        synchronized (dc) {
            Integer num = appMetricaConfig.anrMonitoringTimeout;
            dc.f395a = num != null ? num.intValue() : 5;
            Boolean bool = appMetricaConfig.anrMonitoring;
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            if (bool.booleanValue()) {
                dc.b.a(dc.f395a);
            } else {
                dc.b.b();
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0206db, io.appmetrica.analytics.impl.InterfaceC0182cd
    public final void a(Location location) {
        this.b.b.setManualLocation(location);
        this.c.info("Set location: %s", location);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0206db, io.appmetrica.analytics.impl.InterfaceC0182cd
    public final void a(boolean z) {
        this.b.b.setLocationTracking(z);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0206db
    public final void a(Do r4) {
        PublicLogger publicLogger = this.c;
        synchronized (r4) {
            r4.b = publicLogger;
        }
        Iterator it = r4.f404a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(publicLogger);
        }
        r4.f404a.clear();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0206db
    public final void a(AnrListener anrListener) {
        this.r.a(anrListener);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0206db
    public final void a(ExternalAttribution externalAttribution) {
        this.c.info("External attribution received: %s", externalAttribution);
        Ji ji = this.h;
        byte[] bytes = externalAttribution.toBytes();
        PublicLogger publicLogger = this.c;
        Set set = R9.f620a;
        EnumC0681wb enumC0681wb = EnumC0681wb.EVENT_TYPE_UNDEFINED;
        C0326i4 c0326i4 = new C0326i4(bytes, "", 42, publicLogger);
        Sh sh = this.b;
        ji.getClass();
        ji.a(Ji.a(c0326i4, sh), sh, 1, null);
    }

    @Override // io.appmetrica.analytics.impl.V2, io.appmetrica.analytics.impl.InterfaceC0206db, io.appmetrica.analytics.impl.InterfaceC0182cd
    public final void a(String str, String str2) {
        super.a(str, str2);
        Qd qd = this.q.c;
        String d = this.b.d();
        C0 c0 = qd.d;
        if (c0 != null) {
            C0 c02 = new C0(c0.f367a, c0.b, c0.c, c0.d, c0.e, d);
            qd.d = c02;
            NativeCrashClientModule nativeCrashClientModule = qd.b;
            qd.c.getClass();
            nativeCrashClientModule.updateAppMetricaMetadata(D0.a(c02));
        }
    }
}
