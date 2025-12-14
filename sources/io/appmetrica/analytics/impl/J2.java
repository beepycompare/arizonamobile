package io.appmetrica.analytics.impl;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import io.appmetrica.analytics.AdRevenue;
import io.appmetrica.analytics.ModuleEvent;
import io.appmetrica.analytics.Revenue;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.io.Base64Utils;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.plugins.IPluginReporter;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import io.appmetrica.analytics.profile.UserProfile;
import io.appmetrica.analytics.profile.UserProfileUpdate;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class J2 implements Ea {
    public static final HashSet n = new HashSet(Arrays.asList(1, 13));
    public static final H2 o = new H2();

    /* renamed from: a  reason: collision with root package name */
    protected final Context f630a;
    protected final Gh b;
    protected final PublicLogger c;
    protected final Sn d;
    protected final Fg e;
    protected final C0665w6 f;
    public final C0179d0 g;
    protected final C0702xi h;
    public C0496pb i;
    public final Df j;
    public final N9 k;
    public final Ke l;
    public final C0279gn m;

    public J2(Context context, C0702xi c0702xi, Gh gh, N9 n9, C0565s6 c0565s6, Sn sn, Fg fg, C0665w6 c0665w6, C0179d0 c0179d0, Ke ke) {
        Context applicationContext = context.getApplicationContext();
        this.f630a = applicationContext;
        this.h = c0702xi;
        this.b = gh;
        this.k = n9;
        this.d = sn;
        this.e = fg;
        this.f = c0665w6;
        this.g = c0179d0;
        this.l = ke;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(gh.b().getApiKey());
        this.c = orCreatePublicLogger;
        if (Z2.a(gh.b().isLogEnabled())) {
            orCreatePublicLogger.setEnabled(true);
        }
        this.j = c0565s6;
        this.m = new C0279gn(applicationContext);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            this.c.warning("Invalid Error Environment (key,value) pair: (%s,%s).", str, str2);
            return;
        }
        this.c.info("Put error environment pair <%s, %s>", str, str2);
        Gh gh = this.b;
        synchronized (gh) {
            E8 e8 = gh.c;
            e8.b.b(e8.f554a, str, str2);
        }
    }

    public final void b(Map<String, String> map) {
        if (mo.a((Map) map)) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            a(entry.getKey(), entry.getValue());
        }
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void clearAppEnvironment() {
        String str;
        this.c.info("Clear app environment", new Object[0]);
        C0702xi c0702xi = this.h;
        Gh gh = this.b;
        c0702xi.getClass();
        Q5 n2 = N3.n();
        Cf cf = new Cf(gh.f615a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(gh.b);
        E8 e8 = gh.c;
        synchronized (gh) {
            str = gh.f;
        }
        c0702xi.a(new C0676wh(n2, false, 1, null, new Gh(cf, counterConfiguration, e8, str)));
    }

    public final void d(String str) {
        if (this.b.f()) {
            return;
        }
        this.h.d.c();
        C0496pb c0496pb = this.i;
        c0496pb.f1162a.removeCallbacks(c0496pb.c, c0496pb.b.b.b.getApiKey());
        this.b.e = true;
        C0702xi c0702xi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0693x9.f1294a;
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        N3 n3 = new N3("", str, 3, 0, publicLogger);
        Gh gh = this.b;
        c0702xi.getClass();
        c0702xi.a(C0702xi.a(n3, gh), gh, 1, (Map) null);
    }

    public final void e(String str) {
        this.h.d.b();
        C0496pb c0496pb = this.i;
        C0496pb.a(c0496pb.f1162a, c0496pb.b, c0496pb.c);
        C0702xi c0702xi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0693x9.f1294a;
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        N3 n3 = new N3("", str, 6400, 0, publicLogger);
        Gh gh = this.b;
        c0702xi.getClass();
        c0702xi.a(C0702xi.a(n3, gh), gh, 1, (Map) null);
        this.b.e = false;
    }

    @Override // io.appmetrica.analytics.IReporter
    public final IPluginReporter getPluginExtension() {
        return this;
    }

    public String j() {
        return "[BaseReporter]";
    }

    public void k() {
        String str;
        C0549rf c0549rf;
        C0702xi c0702xi = this.h;
        Gh gh = this.b;
        c0702xi.getClass();
        C0649vf c0649vf = gh.d;
        synchronized (gh) {
            str = gh.f;
        }
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(gh.b.getApiKey());
        Set set = AbstractC0693x9.f1294a;
        JSONObject jSONObject = new JSONObject();
        if (c0649vf != null && (c0549rf = c0649vf.f1266a) != null) {
            try {
                jSONObject.put("preloadInfo", c0549rf.c());
            } catch (Throwable unused) {
            }
        }
        String jSONObject2 = jSONObject.toString();
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        N3 n3 = new N3(jSONObject2, "", 6144, 0, orCreatePublicLogger);
        n3.c(str);
        c0702xi.a(C0702xi.a(n3, gh), gh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void pauseSession() {
        this.c.info("Pause session", new Object[0]);
        d(null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void putAppEnvironmentValue(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            this.c.warning("Invalid App Environment (key,value) pair: (%s,%s).", str, str2);
            return;
        }
        this.c.info("Put app environment: <%s, %s>", str, str2);
        C0702xi c0702xi = this.h;
        Gh gh = this.b;
        c0702xi.getClass();
        Q5 b = N3.b(str, str2);
        Cf cf = new Cf(gh.f615a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(gh.b);
        E8 e8 = gh.c;
        synchronized (gh) {
            str3 = gh.f;
        }
        c0702xi.a(new C0676wh(b, false, 1, null, new Gh(cf, counterConfiguration, e8, str3)));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAdRevenue(AdRevenue adRevenue) {
        reportAdRevenue(adRevenue, false);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAnr(Map<Thread, StackTraceElement[]> map) {
        StackTraceElement[] stackTraceElementArr;
        C0204e0 c0204e0 = new C0204e0(new C0230f0(this, map));
        C0420ma c0420ma = new C0420ma();
        C0565s6 c0565s6 = C0157c4.l().f920a;
        Thread a2 = c0204e0.a();
        Map map2 = null;
        try {
            stackTraceElementArr = c0204e0.b();
            if (stackTraceElementArr == null) {
                try {
                    stackTraceElementArr = a2.getStackTrace();
                } catch (SecurityException unused) {
                }
            }
        } catch (SecurityException unused2) {
            stackTraceElementArr = null;
        }
        C0707xn c0707xn = (C0707xn) c0420ma.apply(a2, stackTraceElementArr);
        ArrayList arrayList = new ArrayList();
        TreeMap treeMap = new TreeMap(new Cn());
        try {
            map2 = c0204e0.c();
        } catch (SecurityException unused3) {
        }
        if (map2 != null) {
            treeMap.putAll(map2);
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            Thread thread = (Thread) entry.getKey();
            if (thread != a2 && thread != null) {
                arrayList.add((C0707xn) c0420ma.apply(thread, (StackTraceElement[]) entry.getValue()));
            }
        }
        a(new V(c0707xn, arrayList, c0565s6.a()));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportECommerce(ECommerceEvent eCommerceEvent) {
        String str;
        this.c.info("E-commerce event received: " + eCommerceEvent.getPublicDescription(), new Object[0]);
        C0702xi c0702xi = this.h;
        Gh gh = this.b;
        c0702xi.getClass();
        for (Ei ei : eCommerceEvent.toProto()) {
            N3 n3 = new N3(LoggerStorage.getOrCreatePublicLogger(gh.b.getApiKey()));
            EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
            n3.d = 41000;
            n3.b = n3.e(Base64Utils.compressBase64(MessageNano.toByteArray((MessageNano) ei.f560a)));
            n3.g = ei.b.getBytesTruncated();
            Cf cf = new Cf(gh.f615a);
            CounterConfiguration counterConfiguration = new CounterConfiguration(gh.b);
            E8 e8 = gh.c;
            synchronized (gh) {
                str = gh.f;
            }
            c0702xi.a(new C0676wh(n3, false, 1, null, new Gh(cf, counterConfiguration, e8, str)));
        }
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, Throwable th) {
        Eg eg = new Eg(str, a(th));
        C0702xi c0702xi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.e.fromModel(eg));
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0693x9.f1294a;
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        N3 n3 = new N3(byteArray, str, 5892, publicLogger);
        Gh gh = this.b;
        c0702xi.getClass();
        c0702xi.a(C0702xi.a(n3, gh), gh, 1, (Map) null);
        this.c.info("Error received: %s", WrapUtils.wrapToTag(str));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str) {
        this.c.info("Event received: " + WrapUtils.wrapToTag(str), new Object[0]);
        C0702xi c0702xi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0693x9.f1294a;
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        N3 n3 = new N3("", str, 1, 0, publicLogger);
        Gh gh = this.b;
        c0702xi.getClass();
        c0702xi.a(C0702xi.a(n3, gh), gh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportRevenue(Revenue revenue) {
        String str;
        Oi oi = I2.f614a;
        oi.getClass();
        ro a2 = oi.a(revenue);
        if (a2.f1204a) {
            C0702xi c0702xi = this.h;
            Pi pi = new Pi(revenue, this.c);
            Gh gh = this.b;
            c0702xi.getClass();
            N3 a3 = N3.a(LoggerStorage.getOrCreatePublicLogger(gh.b.getApiKey()), pi);
            Cf cf = new Cf(gh.f615a);
            CounterConfiguration counterConfiguration = new CounterConfiguration(gh.b);
            E8 e8 = gh.c;
            synchronized (gh) {
                str = gh.f;
            }
            c0702xi.a(new C0676wh(a3, false, 1, null, new Gh(cf, counterConfiguration, e8, str)));
            this.c.info("Revenue received for productID: " + WrapUtils.wrapToTag(revenue.productID) + " of quantity: " + WrapUtils.wrapToTag(revenue.quantity) + " with price (in micros): " + revenue.priceMicros + " " + revenue.currency, new Object[0]);
            return;
        }
        this.c.warning("Passed revenue is not valid. Reason: " + a2.b, new Object[0]);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUnhandledException(Throwable th) {
        Rn a2 = Un.a(th, new V(null, null, this.j.a()), null, (String) this.k.b.a(), (Boolean) this.k.c.a());
        C0702xi c0702xi = this.h;
        c0702xi.a(c0702xi.a(a2, this.b));
        this.c.info("Unhandled exception received: " + a2, new Object[0]);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUserProfile(UserProfile userProfile) {
        ro a2;
        String str;
        C0228eo c0228eo = new C0228eo(C0228eo.c);
        for (UserProfileUpdate<? extends InterfaceC0254fo> userProfileUpdate : userProfile.getUserProfileUpdates()) {
            InterfaceC0254fo userProfileUpdatePatcher = userProfileUpdate.getUserProfileUpdatePatcher();
            userProfileUpdatePatcher.a(this.c);
            userProfileUpdatePatcher.a(c0228eo);
        }
        C0357jo c0357jo = new C0357jo();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c0228eo.f974a.size(); i++) {
            SparseArray sparseArray = c0228eo.f974a;
            for (C0280go c0280go : ((HashMap) sparseArray.get(sparseArray.keyAt(i))).values()) {
                arrayList.add(c0280go);
            }
        }
        c0357jo.f1060a = (C0280go[]) arrayList.toArray(new C0280go[arrayList.size()]);
        if (o.a(c0357jo).f1204a) {
            C0702xi c0702xi = this.h;
            Gh gh = this.b;
            c0702xi.getClass();
            Q5 a3 = N3.a(c0357jo);
            Cf cf = new Cf(gh.f615a);
            CounterConfiguration counterConfiguration = new CounterConfiguration(gh.b);
            E8 e8 = gh.c;
            synchronized (gh) {
                str = gh.f;
            }
            c0702xi.a(new C0676wh(a3, false, 1, null, new Gh(cf, counterConfiguration, e8, str)));
            this.c.info("User profile received", new Object[0]);
            return;
        }
        this.c.warning("UserInfo wasn't sent because " + a2.b, new Object[0]);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void resumeSession() {
        e(null);
        this.c.info("Resume session", new Object[0]);
    }

    @Override // io.appmetrica.analytics.IReporter, io.appmetrica.analytics.IModuleReporter
    public final void sendEventsBuffer() {
        this.c.info("Send event buffer", new Object[0]);
        C0702xi c0702xi = this.h;
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0693x9.f1294a;
        N3 n3 = new N3("", "", 256, 0, publicLogger);
        Gh gh = this.b;
        c0702xi.getClass();
        c0702xi.a(C0702xi.a(n3, gh), gh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setDataSendingEnabled(boolean z) {
        this.b.b.setDataSendingEnabled(z);
        this.c.info("Updated data sending enabled: %s", Boolean.valueOf(z));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void setSessionExtra(String str, byte[] bArr) {
        C0702xi c0702xi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0693x9.f1294a;
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        N3 n3 = new N3("", null, 8193, 0, publicLogger);
        if (bArr == null) {
            bArr = new byte[0];
        }
        n3.p = Collections.singletonMap(str, bArr);
        Gh gh = this.b;
        c0702xi.getClass();
        c0702xi.a(C0702xi.a(n3, gh), gh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setUserProfileID(String str) {
        String str2;
        C0702xi c0702xi = this.h;
        Gh gh = this.b;
        c0702xi.getClass();
        N3 n3 = new N3(LoggerStorage.getOrCreatePublicLogger(gh.b.getApiKey()));
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        n3.d = 40962;
        n3.c(str);
        n3.b = n3.e(str);
        Cf cf = new Cf(gh.f615a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(gh.b);
        E8 e8 = gh.c;
        synchronized (gh) {
            str2 = gh.f;
        }
        c0702xi.a(new C0676wh(n3, false, 1, null, new Gh(cf, counterConfiguration, e8, str2)));
        this.c.info("Set user profile ID: " + WrapUtils.wrapToTag(str), new Object[0]);
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportAdRevenue(AdRevenue adRevenue, boolean z) {
        String str;
        C0702xi c0702xi = this.h;
        E e = new E(adRevenue, z, this.m, this.c);
        Gh gh = this.b;
        c0702xi.getClass();
        N3 a2 = N3.a(LoggerStorage.getOrCreatePublicLogger(gh.b.getApiKey()), e);
        Cf cf = new Cf(gh.f615a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(gh.b);
        E8 e8 = gh.c;
        synchronized (gh) {
            str = gh.f;
        }
        c0702xi.a(new C0676wh(a2, false, 1, null, new Gh(cf, counterConfiguration, e8, str)));
        this.c.info("AdRevenue Received: AdRevenue{adRevenue=" + adRevenue.adRevenue + ", currency='" + WrapUtils.wrapToTag(adRevenue.currency.getCurrencyCode()) + "', adType=" + WrapUtils.wrapToTag(adRevenue.adType) + ", adNetwork='" + WrapUtils.wrapToTag(adRevenue.adNetwork) + "', adUnitId='" + WrapUtils.wrapToTag(adRevenue.adUnitId) + "', adUnitName='" + WrapUtils.wrapToTag(adRevenue.adUnitName) + "', adPlacementId='" + WrapUtils.wrapToTag(adRevenue.adPlacementId) + "', adPlacementName='" + WrapUtils.wrapToTag(adRevenue.adPlacementName) + "', precision='" + WrapUtils.wrapToTag(adRevenue.precision) + "', payload=" + AbstractC0293hb.b(adRevenue.payload) + ", autoCollected=" + z + "}", new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.Ea
    public final void b(String str, String str2) {
        this.c.info("Event received: " + WrapUtils.wrapToTag(str) + ". With value: " + WrapUtils.wrapToTag(str2), new Object[0]);
        C0702xi c0702xi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0693x9.f1294a;
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        N3 n3 = new N3(str2, str, 1, 0, publicLogger);
        n3.l = EnumC0444n9.JS;
        Gh gh = this.b;
        c0702xi.getClass();
        c0702xi.a(C0702xi.a(n3, gh), gh, 1, (Map) null);
    }

    public final void a(Map<String, String> map) {
        if (mo.a((Map) map)) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            putAppEnvironmentValue(entry.getKey(), entry.getValue());
        }
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, String str2) {
        this.c.info("Event received: " + WrapUtils.wrapToTag(str) + ". With value: " + WrapUtils.wrapToTag(str2), new Object[0]);
        C0702xi c0702xi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0693x9.f1294a;
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        N3 n3 = new N3(str2, str, 1, 0, publicLogger);
        Gh gh = this.b;
        c0702xi.getClass();
        c0702xi.a(C0702xi.a(n3, gh), gh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2) {
        reportError(str, str2, (Throwable) null);
    }

    public final Rn a(Throwable th) {
        Throwable th2;
        StackTraceElement[] stackTraceElementArr;
        if (th == null) {
            stackTraceElementArr = null;
            th2 = null;
        } else if (th instanceof O1) {
            stackTraceElementArr = th.getStackTrace();
            th2 = null;
        } else {
            th2 = th;
            stackTraceElementArr = null;
        }
        return Un.a(th2, new V(null, null, this.j.a()), stackTraceElementArr != null ? Arrays.asList(stackTraceElementArr) : null, (String) this.k.b.a(), (Boolean) this.k.c.a());
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2, Throwable th) {
        C0640v6 c0640v6 = new C0640v6(new Eg(str2, a(th)), str);
        C0702xi c0702xi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.f.fromModel(c0640v6));
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0693x9.f1294a;
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        N3 n3 = new N3(byteArray, str2, 5896, publicLogger);
        Gh gh = this.b;
        c0702xi.getClass();
        c0702xi.a(C0702xi.a(n3, gh), gh, 1, (Map) null);
        this.c.info("Error received: id: %s, message: %s", WrapUtils.wrapToTag(str), WrapUtils.wrapToTag(str2));
    }

    @Override // io.appmetrica.analytics.impl.Ea
    public final void b(String str) {
        C0702xi c0702xi = this.h;
        Q5 a2 = Q5.a(str);
        Gh gh = this.b;
        c0702xi.getClass();
        c0702xi.a(C0702xi.a(a2, gh), gh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        Rn a2 = this.l.a(pluginErrorDetails);
        C0702xi c0702xi = this.h;
        Hn hn = a2.f763a;
        String str = hn != null ? (String) WrapUtils.getOrDefault(hn.f611a, "") : "";
        byte[] byteArray = MessageNano.toByteArray(this.d.fromModel(a2));
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0693x9.f1294a;
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        N3 n3 = new N3(byteArray, str, 5891, publicLogger);
        Gh gh = this.b;
        c0702xi.getClass();
        c0702xi.a(C0702xi.a(n3, gh), gh, 1, (Map) null);
        this.c.info("Crash from plugin received: %s", WrapUtils.wrapToTag(pluginErrorDetails.getMessage()));
    }

    @Override // io.appmetrica.analytics.impl.Ea
    public final boolean b() {
        return this.b.f();
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, Map<String, Object> map) {
        C0702xi c0702xi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0693x9.f1294a;
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        c0702xi.a(new N3("", str, 1, 0, publicLogger), this.b, 1, map);
        this.c.info("Event received: " + WrapUtils.wrapToTag(str) + ". With value: " + WrapUtils.wrapToTag(map == null ? null : map.toString()), new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.Sa, io.appmetrica.analytics.impl.Va
    public final void a(Rn rn) {
        C0702xi c0702xi = this.h;
        C0676wh a2 = c0702xi.a(rn, this.b);
        Gh gh = a2.e;
        Ql ql = c0702xi.e;
        if (ql != null) {
            gh.b.setUuid(((Pl) ql).g());
        } else {
            gh.getClass();
        }
        c0702xi.c.b(a2);
        this.c.info("Unhandled exception received: " + rn, new Object[0]);
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        Rn rn;
        Ke ke = this.l;
        if (pluginErrorDetails != null) {
            rn = ke.a(pluginErrorDetails);
        } else {
            ke.getClass();
            rn = null;
        }
        Eg eg = new Eg(str, rn);
        C0702xi c0702xi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.e.fromModel(eg));
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0693x9.f1294a;
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        N3 n3 = new N3(byteArray, str, 5896, publicLogger);
        Gh gh = this.b;
        c0702xi.getClass();
        c0702xi.a(C0702xi.a(n3, gh), gh, 1, (Map) null);
        this.c.info("Error from plugin received: %s", WrapUtils.wrapToTag(str));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportEvent(ModuleEvent moduleEvent) {
        EnumC0444n9 enumC0444n9;
        if (n.contains(Integer.valueOf(moduleEvent.getType()))) {
            return;
        }
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0693x9.f1294a;
        String value = moduleEvent.getValue();
        String name = moduleEvent.getName();
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        N3 n3 = new N3(value, name, 8192, moduleEvent.getType(), publicLogger);
        int i = F8.f573a[moduleEvent.getCategory().ordinal()];
        if (i == 1) {
            enumC0444n9 = EnumC0444n9.NATIVE;
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            enumC0444n9 = EnumC0444n9.SYSTEM;
        }
        n3.l = enumC0444n9;
        n3.c = AbstractC0293hb.b(moduleEvent.getEnvironment());
        if (moduleEvent.getExtras() != null) {
            n3.p = moduleEvent.getExtras();
        }
        this.h.a(n3, this.b, moduleEvent.getServiceDataReporterType(), moduleEvent.getAttributes());
    }

    @Override // io.appmetrica.analytics.impl.Sa, io.appmetrica.analytics.impl.InterfaceC0256g0
    public final void a(V v) {
        C0153c0 c0153c0 = new C0153c0(v, (String) this.k.b.a(), (Boolean) this.k.c.a());
        C0702xi c0702xi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.g.fromModel(c0153c0));
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0693x9.f1294a;
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        N3 n3 = new N3(byteArray, "", 5968, publicLogger);
        Gh gh = this.b;
        c0702xi.getClass();
        c0702xi.a(C0702xi.a(n3, gh), gh, 1, (Map) null);
        PublicLogger publicLogger2 = this.c;
        StringBuilder sb = new StringBuilder("ANR was reported ");
        C0707xn c0707xn = v.f813a;
        publicLogger2.info(sb.append(c0707xn != null ? "Thread[name=" + c0707xn.f1302a + ",tid={" + c0707xn.c + ", priority=" + c0707xn.b + ", group=" + c0707xn.d + "}] at " + CollectionsKt.joinToString$default(c0707xn.f, "\n", null, null, 0, null, null, 62, null) : null).toString(), new Object[0]);
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        Rn rn;
        Ke ke = this.l;
        if (pluginErrorDetails != null) {
            rn = ke.a(pluginErrorDetails);
        } else {
            ke.getClass();
            rn = null;
        }
        C0640v6 c0640v6 = new C0640v6(new Eg(str2, rn), str);
        C0702xi c0702xi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.f.fromModel(c0640v6));
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0693x9.f1294a;
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        N3 n3 = new N3(byteArray, str2, 5896, publicLogger);
        Gh gh = this.b;
        c0702xi.getClass();
        c0702xi.a(C0702xi.a(n3, gh), gh, 1, (Map) null);
        this.c.info("Error with identifier: %s from plugin received: %s", str, WrapUtils.wrapToTag(str2));
    }
}
