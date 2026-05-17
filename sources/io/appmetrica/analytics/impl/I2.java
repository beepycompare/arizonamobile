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
public abstract class I2 implements Da {
    public static final HashSet n = new HashSet(Arrays.asList(1, 13));
    public static final G2 o = new G2();

    /* renamed from: a  reason: collision with root package name */
    protected final Context f626a;
    protected final Fh b;
    protected final PublicLogger c;
    protected final Rn d;
    protected final Eg e;
    protected final C0643v6 f;
    public final C0183d0 g;
    protected final C0680wi h;
    public C0474ob i;
    public final Cf j;
    public final M9 k;
    public final Je l;
    public final C0257fn m;

    public I2(Context context, C0680wi c0680wi, Fh fh, M9 m9, C0543r6 c0543r6, Rn rn, Eg eg, C0643v6 c0643v6, C0183d0 c0183d0, Je je) {
        Context applicationContext = context.getApplicationContext();
        this.f626a = applicationContext;
        this.h = c0680wi;
        this.b = fh;
        this.k = m9;
        this.d = rn;
        this.e = eg;
        this.f = c0643v6;
        this.g = c0183d0;
        this.l = je;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(fh.b().getApiKey());
        this.c = orCreatePublicLogger;
        if (Y2.a(fh.b().isLogEnabled())) {
            orCreatePublicLogger.setEnabled(true);
        }
        this.j = c0543r6;
        this.m = new C0257fn(applicationContext);
    }

    public void a(String str, String str2) {
        boolean isEmpty = TextUtils.isEmpty(str);
        PublicLogger publicLogger = this.c;
        if (isEmpty) {
            publicLogger.warning("Invalid Error Environment (key,value) pair: (%s,%s).", str, str2);
            return;
        }
        publicLogger.info("Put error environment pair <%s, %s>", str, str2);
        Fh fh = this.b;
        synchronized (fh) {
            D8 d8 = fh.c;
            d8.b.b(d8.f551a, str, str2);
        }
    }

    public final void b(Map<String, String> map) {
        if (lo.a((Map) map)) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            a(entry.getKey(), entry.getValue());
        }
    }

    public final void c(String str) {
        if (this.b.f()) {
            return;
        }
        this.h.d.c();
        C0474ob c0474ob = this.i;
        c0474ob.f1157a.removeCallbacks(c0474ob.c, c0474ob.b.b.b.getApiKey());
        this.b.e = true;
        C0680wi c0680wi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0671w9.f1289a;
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        M3 m3 = new M3("", str, 3, 0, publicLogger);
        Fh fh = this.b;
        c0680wi.getClass();
        c0680wi.a(C0680wi.a(m3, fh), fh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void clearAppEnvironment() {
        String str;
        this.c.info("Clear app environment", new Object[0]);
        C0680wi c0680wi = this.h;
        Fh fh = this.b;
        c0680wi.getClass();
        P5 n2 = M3.n();
        Bf bf = new Bf(fh.f612a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(fh.b);
        D8 d8 = fh.c;
        synchronized (fh) {
            str = fh.f;
        }
        c0680wi.a(new C0654vh(n2, false, 1, null, new Fh(bf, counterConfiguration, d8, str)));
    }

    public final void d(String str) {
        this.h.d.b();
        C0474ob c0474ob = this.i;
        C0474ob.a(c0474ob.f1157a, c0474ob.b, c0474ob.c);
        C0680wi c0680wi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0671w9.f1289a;
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        M3 m3 = new M3("", str, 6400, 0, publicLogger);
        Fh fh = this.b;
        c0680wi.getClass();
        c0680wi.a(C0680wi.a(m3, fh), fh, 1, (Map) null);
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
        C0528qf c0528qf;
        C0680wi c0680wi = this.h;
        Fh fh = this.b;
        c0680wi.getClass();
        C0627uf c0627uf = fh.d;
        synchronized (fh) {
            str = fh.f;
        }
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(fh.b.getApiKey());
        Set set = AbstractC0671w9.f1289a;
        JSONObject jSONObject = new JSONObject();
        if (c0627uf != null && (c0528qf = c0627uf.f1261a) != null) {
            try {
                jSONObject.put("preloadInfo", c0528qf.c());
            } catch (Throwable unused) {
            }
        }
        String jSONObject2 = jSONObject.toString();
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        M3 m3 = new M3(jSONObject2, "", 6144, 0, orCreatePublicLogger);
        m3.c(str);
        c0680wi.a(C0680wi.a(m3, fh), fh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void pauseSession() {
        this.c.info("Pause session", new Object[0]);
        c(null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void putAppEnvironmentValue(String str, String str2) {
        String str3;
        boolean isEmpty = TextUtils.isEmpty(str);
        PublicLogger publicLogger = this.c;
        if (isEmpty) {
            publicLogger.warning("Invalid App Environment (key,value) pair: (%s,%s).", str, str2);
            return;
        }
        publicLogger.info("Put app environment: <%s, %s>", str, str2);
        C0680wi c0680wi = this.h;
        Fh fh = this.b;
        c0680wi.getClass();
        P5 b = M3.b(str, str2);
        Bf bf = new Bf(fh.f612a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(fh.b);
        D8 d8 = fh.c;
        synchronized (fh) {
            str3 = fh.f;
        }
        c0680wi.a(new C0654vh(b, false, 1, null, new Fh(bf, counterConfiguration, d8, str3)));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAdRevenue(AdRevenue adRevenue) {
        reportAdRevenue(adRevenue, false);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAnr(Map<Thread, StackTraceElement[]> map) {
        StackTraceElement[] stackTraceElementArr;
        C0208e0 c0208e0 = new C0208e0(new C0234f0(this, map));
        C0398la c0398la = new C0398la();
        C0543r6 c0543r6 = C0135b4.l().f916a;
        Thread a2 = c0208e0.a();
        Map map2 = null;
        try {
            stackTraceElementArr = c0208e0.b();
            if (stackTraceElementArr == null) {
                try {
                    stackTraceElementArr = a2.getStackTrace();
                } catch (SecurityException unused) {
                }
            }
        } catch (SecurityException unused2) {
            stackTraceElementArr = null;
        }
        C0685wn c0685wn = (C0685wn) c0398la.apply(a2, stackTraceElementArr);
        ArrayList arrayList = new ArrayList();
        TreeMap treeMap = new TreeMap(new Bn());
        try {
            map2 = c0208e0.c();
        } catch (SecurityException unused3) {
        }
        if (map2 != null) {
            treeMap.putAll(map2);
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            Thread thread = (Thread) entry.getKey();
            if (thread != a2 && thread != null) {
                arrayList.add((C0685wn) c0398la.apply(thread, (StackTraceElement[]) entry.getValue()));
            }
        }
        a(new V(c0685wn, arrayList, c0543r6.a()));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportECommerce(ECommerceEvent eCommerceEvent) {
        String str;
        this.c.info("E-commerce event received: " + eCommerceEvent.getPublicDescription(), new Object[0]);
        C0680wi c0680wi = this.h;
        Fh fh = this.b;
        c0680wi.getClass();
        for (Di di : eCommerceEvent.toProto()) {
            M3 m3 = new M3(LoggerStorage.getOrCreatePublicLogger(fh.b.getApiKey()));
            EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
            m3.d = 41000;
            m3.b = m3.e(Base64Utils.compressBase64(MessageNano.toByteArray((MessageNano) di.f557a)));
            m3.g = di.b.getBytesTruncated();
            Bf bf = new Bf(fh.f612a);
            CounterConfiguration counterConfiguration = new CounterConfiguration(fh.b);
            D8 d8 = fh.c;
            synchronized (fh) {
                str = fh.f;
            }
            c0680wi.a(new C0654vh(m3, false, 1, null, new Fh(bf, counterConfiguration, d8, str)));
        }
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, Throwable th) {
        Dg dg = new Dg(str, a(th));
        C0680wi c0680wi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.e.fromModel(dg));
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0671w9.f1289a;
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        M3 m3 = new M3(byteArray, str, 5892, publicLogger);
        Fh fh = this.b;
        c0680wi.getClass();
        c0680wi.a(C0680wi.a(m3, fh), fh, 1, (Map) null);
        this.c.info("Error received: %s", WrapUtils.wrapToTag(str));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str) {
        this.c.info("Event received: " + WrapUtils.wrapToTag(str), new Object[0]);
        C0680wi c0680wi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0671w9.f1289a;
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        M3 m3 = new M3("", str, 1, 0, publicLogger);
        Fh fh = this.b;
        c0680wi.getClass();
        c0680wi.a(C0680wi.a(m3, fh), fh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportRevenue(Revenue revenue) {
        String str;
        Ni ni = H2.f611a;
        ni.getClass();
        qo a2 = ni.a(revenue);
        if (a2.f1199a) {
            C0680wi c0680wi = this.h;
            Oi oi = new Oi(revenue, this.c);
            Fh fh = this.b;
            c0680wi.getClass();
            M3 a3 = M3.a(LoggerStorage.getOrCreatePublicLogger(fh.b.getApiKey()), oi);
            Bf bf = new Bf(fh.f612a);
            CounterConfiguration counterConfiguration = new CounterConfiguration(fh.b);
            D8 d8 = fh.c;
            synchronized (fh) {
                str = fh.f;
            }
            c0680wi.a(new C0654vh(a3, false, 1, null, new Fh(bf, counterConfiguration, d8, str)));
            this.c.info("Revenue received for productID: " + WrapUtils.wrapToTag(revenue.productID) + " of quantity: " + WrapUtils.wrapToTag(revenue.quantity) + " with price (in micros): " + revenue.priceMicros + " " + revenue.currency, new Object[0]);
            return;
        }
        this.c.warning("Passed revenue is not valid. Reason: " + a2.b, new Object[0]);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUnhandledException(Throwable th) {
        Qn a2 = Tn.a(th, new V(null, null, this.j.a()), null, (String) this.k.b.a(), (Boolean) this.k.c.a());
        C0680wi c0680wi = this.h;
        c0680wi.a(c0680wi.a(a2, this.b));
        this.c.info("Unhandled exception received: " + a2, new Object[0]);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUserProfile(UserProfile userProfile) {
        qo a2;
        String str;
        Cdo cdo = new Cdo(Cdo.c);
        for (UserProfileUpdate<? extends InterfaceC0232eo> userProfileUpdate : userProfile.getUserProfileUpdates()) {
            InterfaceC0232eo userProfileUpdatePatcher = userProfileUpdate.getUserProfileUpdatePatcher();
            userProfileUpdatePatcher.a(this.c);
            userProfileUpdatePatcher.a(cdo);
        }
        C0335io c0335io = new C0335io();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cdo.f969a.size(); i++) {
            SparseArray sparseArray = cdo.f969a;
            for (C0258fo c0258fo : ((HashMap) sparseArray.get(sparseArray.keyAt(i))).values()) {
                arrayList.add(c0258fo);
            }
        }
        c0335io.f1056a = (C0258fo[]) arrayList.toArray(new C0258fo[arrayList.size()]);
        if (o.a(c0335io).f1199a) {
            C0680wi c0680wi = this.h;
            Fh fh = this.b;
            c0680wi.getClass();
            P5 a3 = M3.a(c0335io);
            Bf bf = new Bf(fh.f612a);
            CounterConfiguration counterConfiguration = new CounterConfiguration(fh.b);
            D8 d8 = fh.c;
            synchronized (fh) {
                str = fh.f;
            }
            c0680wi.a(new C0654vh(a3, false, 1, null, new Fh(bf, counterConfiguration, d8, str)));
            this.c.info("User profile received", new Object[0]);
            return;
        }
        this.c.warning("UserInfo wasn't sent because " + a2.b, new Object[0]);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void resumeSession() {
        d(null);
        this.c.info("Resume session", new Object[0]);
    }

    @Override // io.appmetrica.analytics.IReporter, io.appmetrica.analytics.IModuleReporter
    public final void sendEventsBuffer() {
        this.c.info("Send event buffer", new Object[0]);
        C0680wi c0680wi = this.h;
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0671w9.f1289a;
        M3 m3 = new M3("", "", 256, 0, publicLogger);
        Fh fh = this.b;
        c0680wi.getClass();
        c0680wi.a(C0680wi.a(m3, fh), fh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setDataSendingEnabled(boolean z) {
        this.b.b.setDataSendingEnabled(z);
        this.c.info("Updated data sending enabled: %s", Boolean.valueOf(z));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void setSessionExtra(String str, byte[] bArr) {
        C0680wi c0680wi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0671w9.f1289a;
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        M3 m3 = new M3("", null, 8193, 0, publicLogger);
        if (bArr == null) {
            bArr = new byte[0];
        }
        m3.p = Collections.singletonMap(str, bArr);
        Fh fh = this.b;
        c0680wi.getClass();
        c0680wi.a(C0680wi.a(m3, fh), fh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setUserProfileID(String str) {
        String str2;
        C0680wi c0680wi = this.h;
        Fh fh = this.b;
        c0680wi.getClass();
        M3 m3 = new M3(LoggerStorage.getOrCreatePublicLogger(fh.b.getApiKey()));
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        m3.d = 40962;
        m3.c(str);
        m3.b = m3.e(str);
        Bf bf = new Bf(fh.f612a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(fh.b);
        D8 d8 = fh.c;
        synchronized (fh) {
            str2 = fh.f;
        }
        c0680wi.a(new C0654vh(m3, false, 1, null, new Fh(bf, counterConfiguration, d8, str2)));
        this.c.info("Set user profile ID: " + WrapUtils.wrapToTag(str), new Object[0]);
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportAdRevenue(AdRevenue adRevenue, boolean z) {
        String str;
        C0680wi c0680wi = this.h;
        E e = new E(adRevenue, z, this.m, this.c);
        Fh fh = this.b;
        c0680wi.getClass();
        M3 a2 = M3.a(LoggerStorage.getOrCreatePublicLogger(fh.b.getApiKey()), e);
        Bf bf = new Bf(fh.f612a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(fh.b);
        D8 d8 = fh.c;
        synchronized (fh) {
            str = fh.f;
        }
        c0680wi.a(new C0654vh(a2, false, 1, null, new Fh(bf, counterConfiguration, d8, str)));
        this.c.info("AdRevenue Received: AdRevenue{adRevenue=" + adRevenue.adRevenue + ", currency='" + WrapUtils.wrapToTag(adRevenue.currency.getCurrencyCode()) + "', adType=" + WrapUtils.wrapToTag(adRevenue.adType) + ", adNetwork='" + WrapUtils.wrapToTag(adRevenue.adNetwork) + "', adUnitId='" + WrapUtils.wrapToTag(adRevenue.adUnitId) + "', adUnitName='" + WrapUtils.wrapToTag(adRevenue.adUnitName) + "', adPlacementId='" + WrapUtils.wrapToTag(adRevenue.adPlacementId) + "', adPlacementName='" + WrapUtils.wrapToTag(adRevenue.adPlacementName) + "', precision='" + WrapUtils.wrapToTag(adRevenue.precision) + "', payload=" + AbstractC0271gb.b(adRevenue.payload) + ", autoCollected=" + z + "}", new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.Da
    public final void b(String str, String str2) {
        this.c.info("Event received: " + WrapUtils.wrapToTag(str) + ". With value: " + WrapUtils.wrapToTag(str2), new Object[0]);
        C0680wi c0680wi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0671w9.f1289a;
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        M3 m3 = new M3(str2, str, 1, 0, publicLogger);
        m3.l = EnumC0422m9.JS;
        Fh fh = this.b;
        c0680wi.getClass();
        c0680wi.a(C0680wi.a(m3, fh), fh, 1, (Map) null);
    }

    public final void a(Map<String, String> map) {
        if (lo.a((Map) map)) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            putAppEnvironmentValue(entry.getKey(), entry.getValue());
        }
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, String str2) {
        this.c.info("Event received: " + WrapUtils.wrapToTag(str) + ". With value: " + WrapUtils.wrapToTag(str2), new Object[0]);
        C0680wi c0680wi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0671w9.f1289a;
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        M3 m3 = new M3(str2, str, 1, 0, publicLogger);
        Fh fh = this.b;
        c0680wi.getClass();
        c0680wi.a(C0680wi.a(m3, fh), fh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2) {
        reportError(str, str2, (Throwable) null);
    }

    public final Qn a(Throwable th) {
        Throwable th2;
        StackTraceElement[] stackTraceElementArr;
        if (th == null) {
            stackTraceElementArr = null;
            th2 = null;
        } else if (th instanceof N1) {
            stackTraceElementArr = th.getStackTrace();
            th2 = null;
        } else {
            th2 = th;
            stackTraceElementArr = null;
        }
        return Tn.a(th2, new V(null, null, this.j.a()), stackTraceElementArr != null ? Arrays.asList(stackTraceElementArr) : null, (String) this.k.b.a(), (Boolean) this.k.c.a());
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2, Throwable th) {
        C0618u6 c0618u6 = new C0618u6(new Dg(str2, a(th)), str);
        C0680wi c0680wi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.f.fromModel(c0618u6));
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0671w9.f1289a;
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        M3 m3 = new M3(byteArray, str2, 5896, publicLogger);
        Fh fh = this.b;
        c0680wi.getClass();
        c0680wi.a(C0680wi.a(m3, fh), fh, 1, (Map) null);
        this.c.info("Error received: id: %s, message: %s", WrapUtils.wrapToTag(str), WrapUtils.wrapToTag(str2));
    }

    @Override // io.appmetrica.analytics.impl.Da
    public final void b(String str) {
        C0680wi c0680wi = this.h;
        P5 a2 = P5.a(str);
        Fh fh = this.b;
        c0680wi.getClass();
        c0680wi.a(C0680wi.a(a2, fh), fh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        Qn a2 = this.l.a(pluginErrorDetails);
        C0680wi c0680wi = this.h;
        Gn gn = a2.f760a;
        String str = gn != null ? (String) WrapUtils.getOrDefault(gn.f608a, "") : "";
        byte[] byteArray = MessageNano.toByteArray(this.d.fromModel(a2));
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0671w9.f1289a;
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        M3 m3 = new M3(byteArray, str, 5891, publicLogger);
        Fh fh = this.b;
        c0680wi.getClass();
        c0680wi.a(C0680wi.a(m3, fh), fh, 1, (Map) null);
        this.c.info("Crash from plugin received: %s", WrapUtils.wrapToTag(pluginErrorDetails.getMessage()));
    }

    @Override // io.appmetrica.analytics.impl.Da
    public final boolean b() {
        return this.b.f();
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, Map<String, Object> map) {
        C0680wi c0680wi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0671w9.f1289a;
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        c0680wi.a(new M3("", str, 1, 0, publicLogger), this.b, 1, map);
        this.c.info("Event received: " + WrapUtils.wrapToTag(str) + ". With value: " + WrapUtils.wrapToTag(map == null ? null : map.toString()), new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.Ra, io.appmetrica.analytics.impl.Ua
    public final void a(Qn qn) {
        C0680wi c0680wi = this.h;
        C0654vh a2 = c0680wi.a(qn, this.b);
        Fh fh = a2.e;
        Pl pl = c0680wi.e;
        if (pl != null) {
            fh.b.setUuid(((Ol) pl).g());
        } else {
            fh.getClass();
        }
        c0680wi.c.b(a2);
        this.c.info("Unhandled exception received: " + qn, new Object[0]);
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        Qn qn;
        Je je = this.l;
        if (pluginErrorDetails != null) {
            qn = je.a(pluginErrorDetails);
        } else {
            je.getClass();
            qn = null;
        }
        Dg dg = new Dg(str, qn);
        C0680wi c0680wi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.e.fromModel(dg));
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0671w9.f1289a;
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        M3 m3 = new M3(byteArray, str, 5896, publicLogger);
        Fh fh = this.b;
        c0680wi.getClass();
        c0680wi.a(C0680wi.a(m3, fh), fh, 1, (Map) null);
        this.c.info("Error from plugin received: %s", WrapUtils.wrapToTag(str));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportEvent(ModuleEvent moduleEvent) {
        EnumC0422m9 enumC0422m9;
        if (n.contains(Integer.valueOf(moduleEvent.getType()))) {
            return;
        }
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0671w9.f1289a;
        String value = moduleEvent.getValue();
        String name = moduleEvent.getName();
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        M3 m3 = new M3(value, name, 8192, moduleEvent.getType(), publicLogger);
        int i = E8.f569a[moduleEvent.getCategory().ordinal()];
        if (i == 1) {
            enumC0422m9 = EnumC0422m9.NATIVE;
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            enumC0422m9 = EnumC0422m9.SYSTEM;
        }
        m3.l = enumC0422m9;
        m3.c = AbstractC0271gb.b(moduleEvent.getEnvironment());
        if (moduleEvent.getExtras() != null) {
            m3.p = moduleEvent.getExtras();
        }
        this.h.a(m3, this.b, moduleEvent.getServiceDataReporterType(), moduleEvent.getAttributes());
    }

    @Override // io.appmetrica.analytics.impl.Ra, io.appmetrica.analytics.impl.InterfaceC0260g0
    public final void a(V v) {
        C0157c0 c0157c0 = new C0157c0(v, (String) this.k.b.a(), (Boolean) this.k.c.a());
        C0680wi c0680wi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.g.fromModel(c0157c0));
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0671w9.f1289a;
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        M3 m3 = new M3(byteArray, "", 5968, publicLogger);
        Fh fh = this.b;
        c0680wi.getClass();
        c0680wi.a(C0680wi.a(m3, fh), fh, 1, (Map) null);
        PublicLogger publicLogger2 = this.c;
        StringBuilder sb = new StringBuilder("ANR was reported ");
        C0685wn c0685wn = v.f822a;
        publicLogger2.info(sb.append(c0685wn != null ? "Thread[name=" + c0685wn.f1297a + ",tid={" + c0685wn.c + ", priority=" + c0685wn.b + ", group=" + c0685wn.d + "}] at " + CollectionsKt.joinToString$default(c0685wn.f, "\n", null, null, 0, null, null, 62, null) : null).toString(), new Object[0]);
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        Qn qn;
        Je je = this.l;
        if (pluginErrorDetails != null) {
            qn = je.a(pluginErrorDetails);
        } else {
            je.getClass();
            qn = null;
        }
        C0618u6 c0618u6 = new C0618u6(new Dg(str2, qn), str);
        C0680wi c0680wi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.f.fromModel(c0618u6));
        PublicLogger publicLogger = this.c;
        Set set = AbstractC0671w9.f1289a;
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        M3 m3 = new M3(byteArray, str2, 5896, publicLogger);
        Fh fh = this.b;
        c0680wi.getClass();
        c0680wi.a(C0680wi.a(m3, fh), fh, 1, (Map) null);
        this.c.info("Error with identifier: %s from plugin received: %s", str, WrapUtils.wrapToTag(str2));
    }
}
