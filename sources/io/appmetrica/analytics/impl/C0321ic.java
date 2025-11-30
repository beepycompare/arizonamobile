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
public final class C0321ic extends J2 implements Ja {
    public static final Long s = Long.valueOf(TimeUnit.SECONDS.toMillis(1));
    public final Fn p;
    public final C0597tc q;
    public final C0346jc r;

    public C0321ic(C0597tc c0597tc) {
        super(c0597tc.b(), c0597tc.i(), c0597tc.h(), c0597tc.d(), c0597tc.f(), c0597tc.j(), c0597tc.g(), c0597tc.c(), c0597tc.a(), c0597tc.e());
        this.p = new Fn(new C0116ae("Referral url"));
        this.q = c0597tc;
        this.r = new C0346jc(this);
        l();
    }

    public final void a(AppMetricaConfig appMetricaConfig, C0386l0 c0386l0) {
        if (c0386l0.b) {
            clearAppEnvironment();
        }
        List<String> list = c0386l0.f983a;
        if (!CollectionUtils.isNullOrEmpty(list)) {
            this.b.b.addAutoCollectedDataSubscribers(list);
        }
        a(appMetricaConfig.appEnvironment);
        b(appMetricaConfig.errorEnvironment);
        boolean booleanValue = ((Boolean) WrapUtils.getOrDefault(appMetricaConfig.nativeCrashReporting, Boolean.TRUE)).booleanValue();
        this.c.info("native crash reporting enabled: %b", Boolean.valueOf(booleanValue));
        if (booleanValue) {
            Cd cd = this.q.c;
            Context context = this.f533a;
            cd.d = new H0(this.b.b.getApiKey(), cd.f430a.f432a.getAsString("PROCESS_CFG_PACKAGE_NAME"), CounterConfigurationReporterType.MAIN, cd.f430a.f432a.getAsInteger("PROCESS_CFG_PROCESS_ID").intValue(), cd.f430a.f432a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID"), this.b.d());
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
        C0346jc c0346jc = this.r;
        synchronized (c0346jc) {
            Integer num = appMetricaConfig.anrMonitoringTimeout;
            c0346jc.f955a = num != null ? num.intValue() : 5;
            Boolean bool = appMetricaConfig.anrMonitoring;
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            if (bool.booleanValue()) {
                c0346jc.b.a(c0346jc.f955a);
            } else {
                c0346jc.b.b();
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void b(Activity activity) {
        if (this.q.i.a(activity, EnumC0485p.PAUSED)) {
            this.c.info("Pause session", new Object[0]);
            d(activity != null ? activity.getClass().getSimpleName() : null);
            C0233f2 c0233f2 = this.q.g;
            synchronized (c0233f2) {
                c0233f2.getClass();
                for (C0207e2 c0207e2 : c0233f2.f881a) {
                    if (!c0207e2.d) {
                        c0207e2.d = true;
                        c0207e2.b.executeDelayed(c0207e2.e, c0207e2.c);
                    }
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void c() {
        C0346jc c0346jc = this.r;
        synchronized (c0346jc) {
            c0346jc.b.a(c0346jc.f955a);
        }
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final List<String> f() {
        return this.b.f518a.b();
    }

    @Override // io.appmetrica.analytics.impl.J2
    public final String j() {
        return "[MainReporter]";
    }

    @Override // io.appmetrica.analytics.impl.J2
    public final void k() {
        super.k();
        C0158c4.l().m().c();
    }

    public final void l() {
        C0703xi c0703xi = this.h;
        c0703xi.c.a(this.b.f518a);
        C0233f2 c0233f2 = this.q.g;
        C0295hc c0295hc = new C0295hc(this);
        long longValue = s.longValue();
        synchronized (c0233f2) {
            c0233f2.a(c0295hc, longValue);
        }
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void c(String str) {
        this.p.a(str);
        C0703xi c0703xi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0694x9.f1197a;
        HashMap hashMap = new HashMap();
        hashMap.put("type", "referral");
        hashMap.put("link", str);
        hashMap.put("auto", Boolean.FALSE);
        String b = AbstractC0294hb.b(hashMap);
        EnumC0165cb enumC0165cb = EnumC0165cb.EVENT_TYPE_UNDEFINED;
        N3 n3 = new N3(b, "", 8208, 0, publicLogger);
        Gh gh = this.b;
        c0703xi.getClass();
        c0703xi.a(C0703xi.a(n3, gh), gh, 1, (Map) null);
        this.c.info("Referral URL received: " + WrapUtils.wrapToTag(str), new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(String str, boolean z) {
        this.c.info("App opened via deeplink: " + WrapUtils.wrapToTag(str), new Object[0]);
        C0703xi c0703xi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0694x9.f1197a;
        HashMap hashMap = new HashMap();
        hashMap.put("type", TtmlNode.TEXT_EMPHASIS_MARK_OPEN);
        hashMap.put("link", str);
        hashMap.put("auto", Boolean.valueOf(z));
        String b = AbstractC0294hb.b(hashMap);
        EnumC0165cb enumC0165cb = EnumC0165cb.EVENT_TYPE_UNDEFINED;
        N3 n3 = new N3(b, "", 8208, 0, publicLogger);
        Gh gh = this.b;
        c0703xi.getClass();
        c0703xi.a(C0703xi.a(n3, gh), gh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(EnumC0435n enumC0435n) {
        if (enumC0435n == EnumC0435n.b) {
            this.c.info("Enable activity auto tracking", new Object[0]);
        } else {
            this.c.warning("Could not enable activity auto tracking. " + enumC0435n.f1017a, new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(Activity activity) {
        if (this.q.i.a(activity, EnumC0485p.RESUMED)) {
            this.c.info("Resume session", new Object[0]);
            e(activity != null ? activity.getClass().getSimpleName() : null);
            C0233f2 c0233f2 = this.q.g;
            synchronized (c0233f2) {
                c0233f2.getClass();
                for (C0207e2 c0207e2 : c0233f2.f881a) {
                    if (c0207e2.d) {
                        c0207e2.d = false;
                        c0207e2.b.remove(c0207e2.e);
                        C0321ic c0321ic = c0207e2.f862a.f922a;
                        c0321ic.h.c.b(c0321ic.b.f518a);
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
        Iterator it = io2.f530a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(publicLogger);
        }
        io2.f530a.clear();
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(AnrListener anrListener) {
        this.r.a(anrListener);
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(ExternalAttribution externalAttribution) {
        this.c.info("External attribution received: %s", externalAttribution);
        C0703xi c0703xi = this.h;
        byte[] bytes = externalAttribution.toBytes();
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0694x9.f1197a;
        EnumC0165cb enumC0165cb = EnumC0165cb.EVENT_TYPE_UNDEFINED;
        N3 n3 = new N3(bytes, "", 42, publicLogger);
        Gh gh = this.b;
        c0703xi.getClass();
        c0703xi.a(C0703xi.a(n3, gh), gh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.impl.J2, io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Ic
    public final void a(String str, String str2) {
        super.a(str, str2);
        Cd cd = this.q.c;
        String d = this.b.d();
        H0 h0 = cd.d;
        if (h0 != null) {
            H0 h02 = new H0(h0.f499a, h0.b, h0.c, h0.d, h0.e, d);
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
