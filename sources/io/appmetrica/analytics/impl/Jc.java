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
/* loaded from: classes5.dex */
public final class Jc extends V2 implements InterfaceC0376kb {
    public static final Long r = Long.valueOf(TimeUnit.SECONDS.toMillis(1));
    public final Tc p;
    public final Kc q;

    public Jc(Tc tc) {
        super(tc.b(), tc.i(), tc.h(), tc.d(), tc.f(), tc.j(), tc.g(), tc.c(), tc.a(), tc.e());
        this.p = tc;
        this.q = new Kc(this);
        l();
    }

    public final void a(AppMetricaConfig appMetricaConfig, C0443n0 c0443n0) {
        if (c0443n0.b) {
            clearAppEnvironment();
        }
        List<String> list = c0443n0.f1103a;
        if (!CollectionUtils.isNullOrEmpty(list)) {
            this.b.b.addAutoCollectedDataSubscribers(list);
        }
        a(appMetricaConfig.appEnvironment);
        b(appMetricaConfig.errorEnvironment);
        boolean booleanValue = ((Boolean) WrapUtils.getOrDefault(appMetricaConfig.nativeCrashReporting, Boolean.TRUE)).booleanValue();
        this.c.info("native crash reporting enabled: %b", Boolean.valueOf(booleanValue));
        if (booleanValue) {
            C0147be c0147be = this.p.c;
            Context context = this.f801a;
            c0147be.d = new J0(this.b.b.getApiKey(), c0147be.f906a.f927a.getAsString("PROCESS_CFG_PACKAGE_NAME"), CounterConfigurationReporterType.MAIN, c0147be.f906a.f927a.getAsInteger("PROCESS_CFG_PROCESS_ID").intValue(), c0147be.f906a.f927a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID"), this.b.d());
            File nativeCrashDirectory = FileUtils.getNativeCrashDirectory(context);
            J0 j0 = null;
            String absolutePath = nativeCrashDirectory != null ? nativeCrashDirectory.getAbsolutePath() : null;
            if (absolutePath != null) {
                NativeCrashClientModule nativeCrashClientModule = c0147be.b;
                K0 k0 = c0147be.c;
                J0 j02 = c0147be.d;
                if (j02 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("nativeCrashMetadata");
                } else {
                    j0 = j02;
                }
                k0.getClass();
                nativeCrashClientModule.initHandling(context, new NativeCrashClientConfig(absolutePath, K0.a(j0)));
            }
        }
        Kc kc = this.q;
        synchronized (kc) {
            Integer num = appMetricaConfig.anrMonitoringTimeout;
            kc.f626a = num != null ? num.intValue() : 5;
            Boolean bool = appMetricaConfig.anrMonitoring;
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            if (bool.booleanValue()) {
                kc.b.a(kc.f626a);
            } else {
                kc.b.b();
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0376kb
    public final void b(Activity activity) {
        if (this.p.i.a(activity, EnumC0494p.PAUSED)) {
            this.c.info("Pause session", new Object[0]);
            c(activity != null ? activity.getClass().getSimpleName() : null);
            C0548r2 c0548r2 = this.p.g;
            synchronized (c0548r2) {
                c0548r2.getClass();
                for (C0523q2 c0523q2 : c0548r2.f1174a) {
                    if (!c0523q2.d) {
                        c0523q2.d = true;
                        c0523q2.b.executeDelayed(c0523q2.e, c0523q2.c);
                    }
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0376kb
    public final void c() {
        Kc kc = this.q;
        synchronized (kc) {
            kc.b.a(kc.f626a);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0376kb
    public final List<String> f() {
        return this.b.f849a.b();
    }

    @Override // io.appmetrica.analytics.impl.V2
    public final String j() {
        return "[MainReporter]";
    }

    @Override // io.appmetrica.analytics.impl.V2
    public final void k() {
        super.k();
        C0576s4.l().m().c();
    }

    public final void l() {
        Qi qi = this.h;
        qi.c.a(this.b.f849a);
        C0548r2 c0548r2 = this.p.g;
        Ic ic = new Ic(this);
        long longValue = r.longValue();
        synchronized (c0548r2) {
            c0548r2.a(ic, longValue);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0376kb
    public final void a(String str, boolean z) {
        this.c.info("App opened via deeplink: " + WrapUtils.wrapToTag(str), new Object[0]);
        Qi qi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = Q9.f727a;
        HashMap hashMap = new HashMap();
        hashMap.put("type", TtmlNode.TEXT_EMPHASIS_MARK_OPEN);
        hashMap.put("link", str);
        hashMap.put("auto", Boolean.valueOf(z));
        String b = Ib.b(hashMap);
        Db db = Db.EVENT_TYPE_UNDEFINED;
        C0189d4 c0189d4 = new C0189d4(b, "", 8208, 0, publicLogger);
        Zh zh = this.b;
        qi.getClass();
        qi.a(Qi.a(c0189d4, zh), zh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0376kb
    public final void a(EnumC0442n enumC0442n) {
        if (enumC0442n == EnumC0442n.b) {
            this.c.info("Enable activity auto tracking", new Object[0]);
        } else {
            this.c.warning("Could not enable activity auto tracking. " + enumC0442n.f1102a, new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0376kb
    public final void a(Activity activity) {
        if (this.p.i.a(activity, EnumC0494p.RESUMED)) {
            this.c.info("Resume session", new Object[0]);
            d(activity != null ? activity.getClass().getSimpleName() : null);
            C0548r2 c0548r2 = this.p.g;
            synchronized (c0548r2) {
                c0548r2.getClass();
                for (C0523q2 c0523q2 : c0548r2.f1174a) {
                    if (c0523q2.d) {
                        c0523q2.d = false;
                        c0523q2.b.remove(c0523q2.e);
                        Jc jc = c0523q2.f1156a.f592a;
                        jc.h.c.b(jc.b.f849a);
                    }
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0376kb, io.appmetrica.analytics.impl.InterfaceC0327id
    public final void a(Location location) {
        this.b.b.setManualLocation(location);
        this.c.info("Set location: %s", location);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0376kb, io.appmetrica.analytics.impl.InterfaceC0327id
    public final void a(boolean z) {
        this.b.b.setLocationTracking(z);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0376kb, io.appmetrica.analytics.impl.InterfaceC0327id
    public final void a(boolean z, boolean z2) {
        this.c.info("Set advIdentifiersTracking to %s", Boolean.valueOf(z));
        this.b.b.setAdvIdentifiersTracking(z, z2);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0376kb
    public final void a(lp lpVar) {
        PublicLogger publicLogger = this.c;
        synchronized (lpVar) {
            lpVar.b = publicLogger;
        }
        Iterator it = lpVar.f1084a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(publicLogger);
        }
        lpVar.f1084a.clear();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0376kb
    public final void a(AnrListener anrListener) {
        this.q.a(anrListener);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0376kb
    public final void a(ExternalAttribution externalAttribution) {
        this.c.info("External attribution received: %s", externalAttribution);
        Qi qi = this.h;
        byte[] bytes = externalAttribution.toBytes();
        PublicLogger publicLogger = this.c;
        Set set = Q9.f727a;
        Db db = Db.EVENT_TYPE_UNDEFINED;
        C0189d4 c0189d4 = new C0189d4(bytes, "", 42, publicLogger);
        Zh zh = this.b;
        qi.getClass();
        qi.a(Qi.a(c0189d4, zh), zh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.impl.V2, io.appmetrica.analytics.impl.InterfaceC0376kb, io.appmetrica.analytics.impl.InterfaceC0327id
    public final void a(String str, String str2) {
        super.a(str, str2);
        C0147be c0147be = this.p.c;
        String d = this.b.d();
        J0 j0 = c0147be.d;
        if (j0 != null) {
            J0 j02 = new J0(j0.f601a, j0.b, j0.c, j0.d, j0.e, d);
            c0147be.d = j02;
            NativeCrashClientModule nativeCrashClientModule = c0147be.b;
            c0147be.c.getClass();
            nativeCrashClientModule.updateAppMetricaMetadata(K0.a(j02));
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0376kb, io.appmetrica.analytics.impl.InterfaceC0327id
    public final void a(String str) {
        this.c.info("Add auto collected data subscriber: %s", str);
        this.b.b.addAutoCollectedDataSubscriber(str);
    }
}
