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
public abstract class V2 implements InterfaceC0246fb {
    public static final HashSet n = new HashSet(Arrays.asList(1, 13));
    public static final T2 o = new T2();

    /* renamed from: a  reason: collision with root package name */
    protected final Context f804a;
    protected final Zh b;
    protected final PublicLogger c;
    protected final C0647uo d;
    protected final Ug e;
    protected final N6 f;
    public final C0235f0 g;
    protected final Qi h;
    public Qb i;
    public final InterfaceC0200dg j;
    public final C0297ha k;
    public final C0379kf l;
    public final Gn m;

    public V2(Context context, Qi qi, Zh zh, C0297ha c0297ha, J6 j6, C0647uo c0647uo, Ug ug, N6 n6, C0235f0 c0235f0, C0379kf c0379kf) {
        Context applicationContext = context.getApplicationContext();
        this.f804a = applicationContext;
        this.h = qi;
        this.b = zh;
        this.k = c0297ha;
        this.d = c0647uo;
        this.e = ug;
        this.f = n6;
        this.g = c0235f0;
        this.l = c0379kf;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(zh.b().getApiKey());
        this.c = orCreatePublicLogger;
        if (AbstractC0393l3.a(zh.b().isLogEnabled())) {
            orCreatePublicLogger.setEnabled(true);
        }
        this.j = j6;
        this.m = new Gn(applicationContext);
    }

    public void a(String str, String str2) {
        boolean isEmpty = TextUtils.isEmpty(str);
        PublicLogger publicLogger = this.c;
        if (isEmpty) {
            publicLogger.warning("Invalid Error Environment (key,value) pair: (%s,%s).", str, str2);
            return;
        }
        publicLogger.info("Put error environment pair <%s, %s>", str, str2);
        Zh zh = this.b;
        synchronized (zh) {
            W8 w8 = zh.c;
            w8.b.b(w8.f824a, str, str2);
        }
    }

    public final void b(Map<String, String> map) {
        if (Oo.a((Map) map)) {
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
        Qb qb = this.i;
        qb.f732a.removeCallbacks(qb.c, qb.b.b.b.getApiKey());
        this.b.e = true;
        Qi qi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = Q9.f730a;
        Db db = Db.EVENT_TYPE_UNDEFINED;
        C0188d4 c0188d4 = new C0188d4("", str, 3, 0, publicLogger);
        Zh zh = this.b;
        qi.getClass();
        qi.a(Qi.a(c0188d4, zh), zh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void clearAppEnvironment() {
        String str;
        this.c.info("Clear app environment", new Object[0]);
        Qi qi = this.h;
        Zh zh = this.b;
        qi.getClass();
        C0241f6 n2 = C0188d4.n();
        C0174cg c0174cg = new C0174cg(zh.f852a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(zh.b);
        W8 w8 = zh.c;
        synchronized (zh) {
            str = zh.f;
        }
        qi.a(new Ph(n2, false, 1, null, new Zh(c0174cg, counterConfiguration, w8, str)));
    }

    public final void d(String str) {
        this.h.d.b();
        Qb qb = this.i;
        Qb.a(qb.f732a, qb.b, qb.c);
        Qi qi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = Q9.f730a;
        Db db = Db.EVENT_TYPE_UNDEFINED;
        C0188d4 c0188d4 = new C0188d4("", str, 6400, 0, publicLogger);
        Zh zh = this.b;
        qi.getClass();
        qi.a(Qi.a(c0188d4, zh), zh, 1, (Map) null);
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
        Qf qf;
        Qi qi = this.h;
        Zh zh = this.b;
        qi.getClass();
        Uf uf = zh.d;
        synchronized (zh) {
            str = zh.f;
        }
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(zh.b.getApiKey());
        Set set = Q9.f730a;
        JSONObject jSONObject = new JSONObject();
        if (uf != null && (qf = uf.f795a) != null) {
            try {
                jSONObject.put("preloadInfo", qf.c());
            } catch (Throwable unused) {
            }
        }
        String jSONObject2 = jSONObject.toString();
        Db db = Db.EVENT_TYPE_UNDEFINED;
        C0188d4 c0188d4 = new C0188d4(jSONObject2, "", 6144, 0, orCreatePublicLogger);
        c0188d4.c(str);
        qi.a(Qi.a(c0188d4, zh), zh, 1, (Map) null);
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
        Qi qi = this.h;
        Zh zh = this.b;
        qi.getClass();
        C0241f6 b = C0188d4.b(str, str2);
        C0174cg c0174cg = new C0174cg(zh.f852a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(zh.b);
        W8 w8 = zh.c;
        synchronized (zh) {
            str3 = zh.f;
        }
        qi.a(new Ph(b, false, 1, null, new Zh(c0174cg, counterConfiguration, w8, str3)));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAdRevenue(AdRevenue adRevenue) {
        reportAdRevenue(adRevenue, false);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAnr(Map<Thread, StackTraceElement[]> map) {
        StackTraceElement[] stackTraceElementArr;
        C0261g0 c0261g0 = new C0261g0(new C0287h0(this, map));
        Ia ia = new Ia();
        J6 j6 = C0575s4.l().f1194a;
        Thread a2 = c0261g0.a();
        Map map2 = null;
        try {
            stackTraceElementArr = c0261g0.b();
            if (stackTraceElementArr == null) {
                try {
                    stackTraceElementArr = a2.getStackTrace();
                } catch (SecurityException unused) {
                }
            }
        } catch (SecurityException unused2) {
            stackTraceElementArr = null;
        }
        Zn zn = (Zn) ia.apply(a2, stackTraceElementArr);
        ArrayList arrayList = new ArrayList();
        TreeMap treeMap = new TreeMap(new C0233eo());
        try {
            map2 = c0261g0.c();
        } catch (SecurityException unused3) {
        }
        if (map2 != null) {
            treeMap.putAll(map2);
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            Thread thread = (Thread) entry.getKey();
            if (thread != a2 && thread != null) {
                arrayList.add((Zn) ia.apply(thread, (StackTraceElement[]) entry.getValue()));
            }
        }
        a(new X(zn, arrayList, j6.a()));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportECommerce(ECommerceEvent eCommerceEvent) {
        String str;
        this.c.info("E-commerce event received: " + eCommerceEvent.getPublicDescription(), new Object[0]);
        Qi qi = this.h;
        Zh zh = this.b;
        qi.getClass();
        for (Xi xi : eCommerceEvent.toProto()) {
            C0188d4 c0188d4 = new C0188d4(LoggerStorage.getOrCreatePublicLogger(zh.b.getApiKey()));
            Db db = Db.EVENT_TYPE_UNDEFINED;
            c0188d4.d = 41000;
            c0188d4.b = c0188d4.e(Base64Utils.compressBase64(MessageNano.toByteArray((MessageNano) xi.f841a)));
            c0188d4.g = xi.b.getBytesTruncated();
            C0174cg c0174cg = new C0174cg(zh.f852a);
            CounterConfiguration counterConfiguration = new CounterConfiguration(zh.b);
            W8 w8 = zh.c;
            synchronized (zh) {
                str = zh.f;
            }
            qi.a(new Ph(c0188d4, false, 1, null, new Zh(c0174cg, counterConfiguration, w8, str)));
        }
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, Throwable th) {
        Tg tg = new Tg(str, a(th));
        Qi qi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.e.fromModel(tg));
        PublicLogger publicLogger = this.c;
        Set set = Q9.f730a;
        Db db = Db.EVENT_TYPE_UNDEFINED;
        C0188d4 c0188d4 = new C0188d4(byteArray, str, 5892, publicLogger);
        Zh zh = this.b;
        qi.getClass();
        qi.a(Qi.a(c0188d4, zh), zh, 1, (Map) null);
        this.c.info("Error received: %s", WrapUtils.wrapToTag(str));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str) {
        this.c.info("Event received: " + WrapUtils.wrapToTag(str), new Object[0]);
        Qi qi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = Q9.f730a;
        Db db = Db.EVENT_TYPE_UNDEFINED;
        C0188d4 c0188d4 = new C0188d4("", str, 1, 0, publicLogger);
        Zh zh = this.b;
        qi.getClass();
        qi.a(Qi.a(c0188d4, zh), zh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportRevenue(Revenue revenue) {
        String str;
        C0331ij c0331ij = U2.f787a;
        c0331ij.getClass();
        To a2 = c0331ij.a(revenue);
        if (a2.f784a) {
            Qi qi = this.h;
            C0357jj c0357jj = new C0357jj(revenue, this.c);
            Zh zh = this.b;
            qi.getClass();
            C0188d4 a3 = C0188d4.a(LoggerStorage.getOrCreatePublicLogger(zh.b.getApiKey()), c0357jj);
            C0174cg c0174cg = new C0174cg(zh.f852a);
            CounterConfiguration counterConfiguration = new CounterConfiguration(zh.b);
            W8 w8 = zh.c;
            synchronized (zh) {
                str = zh.f;
            }
            qi.a(new Ph(a3, false, 1, null, new Zh(c0174cg, counterConfiguration, w8, str)));
            this.c.info("Revenue received for productID: " + WrapUtils.wrapToTag(revenue.productID) + " of quantity: " + WrapUtils.wrapToTag(revenue.quantity) + " with price (in micros): " + revenue.priceMicros + " " + revenue.currency, new Object[0]);
            return;
        }
        this.c.warning("Passed revenue is not valid. Reason: " + a2.b, new Object[0]);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUnhandledException(Throwable th) {
        C0621to a2 = AbstractC0699wo.a(th, new X(null, null, this.j.a()), null, (String) this.k.b.a(), (Boolean) this.k.c.a());
        Qi qi = this.h;
        qi.a(qi.a(a2, this.b));
        this.c.info("Unhandled exception received: " + a2, new Object[0]);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUserProfile(UserProfile userProfile) {
        To a2;
        String str;
        Go go = new Go(Go.c);
        for (UserProfileUpdate<? extends Ho> userProfileUpdate : userProfile.getUserProfileUpdates()) {
            Ho userProfileUpdatePatcher = userProfileUpdate.getUserProfileUpdatePatcher();
            userProfileUpdatePatcher.a(this.c);
            userProfileUpdatePatcher.a(go);
        }
        Lo lo = new Lo();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < go.f570a.size(); i++) {
            SparseArray sparseArray = go.f570a;
            for (Io io2 : ((HashMap) sparseArray.get(sparseArray.keyAt(i))).values()) {
                arrayList.add(io2);
            }
        }
        lo.f655a = (Io[]) arrayList.toArray(new Io[arrayList.size()]);
        if (o.a(lo).f784a) {
            Qi qi = this.h;
            Zh zh = this.b;
            qi.getClass();
            C0241f6 a3 = C0188d4.a(lo);
            C0174cg c0174cg = new C0174cg(zh.f852a);
            CounterConfiguration counterConfiguration = new CounterConfiguration(zh.b);
            W8 w8 = zh.c;
            synchronized (zh) {
                str = zh.f;
            }
            qi.a(new Ph(a3, false, 1, null, new Zh(c0174cg, counterConfiguration, w8, str)));
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
        Qi qi = this.h;
        Db db = Db.EVENT_TYPE_UNDEFINED;
        PublicLogger publicLogger = this.c;
        Set set = Q9.f730a;
        C0188d4 c0188d4 = new C0188d4("", "", 256, 0, publicLogger);
        Zh zh = this.b;
        qi.getClass();
        qi.a(Qi.a(c0188d4, zh), zh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setDataSendingEnabled(boolean z) {
        this.b.b.setDataSendingEnabled(z);
        this.c.info("Updated data sending enabled: %s", Boolean.valueOf(z));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void setSessionExtra(String str, byte[] bArr) {
        Qi qi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = Q9.f730a;
        Db db = Db.EVENT_TYPE_UNDEFINED;
        C0188d4 c0188d4 = new C0188d4("", (String) null, 8193, 0, publicLogger);
        if (bArr == null) {
            bArr = new byte[0];
        }
        c0188d4.p = Collections.singletonMap(str, bArr);
        Zh zh = this.b;
        qi.getClass();
        qi.a(Qi.a(c0188d4, zh), zh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setUserProfileID(String str) {
        String str2;
        Qi qi = this.h;
        Zh zh = this.b;
        qi.getClass();
        C0188d4 c0188d4 = new C0188d4(LoggerStorage.getOrCreatePublicLogger(zh.b.getApiKey()));
        Db db = Db.EVENT_TYPE_UNDEFINED;
        c0188d4.d = 40962;
        c0188d4.c(str);
        c0188d4.b = c0188d4.e(str);
        C0174cg c0174cg = new C0174cg(zh.f852a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(zh.b);
        W8 w8 = zh.c;
        synchronized (zh) {
            str2 = zh.f;
        }
        qi.a(new Ph(c0188d4, false, 1, null, new Zh(c0174cg, counterConfiguration, w8, str2)));
        this.c.info("Set user profile ID: " + WrapUtils.wrapToTag(str), new Object[0]);
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportAdRevenue(AdRevenue adRevenue, boolean z) {
        String str;
        Qi qi = this.h;
        F f = new F(adRevenue, z, this.m, this.c);
        Zh zh = this.b;
        qi.getClass();
        C0188d4 a2 = C0188d4.a(LoggerStorage.getOrCreatePublicLogger(zh.b.getApiKey()), f);
        C0174cg c0174cg = new C0174cg(zh.f852a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(zh.b);
        W8 w8 = zh.c;
        synchronized (zh) {
            str = zh.f;
        }
        qi.a(new Ph(a2, false, 1, null, new Zh(c0174cg, counterConfiguration, w8, str)));
        this.c.info("AdRevenue Received: AdRevenue{adRevenue=" + adRevenue.adRevenue + ", currency='" + WrapUtils.wrapToTag(adRevenue.currency.getCurrencyCode()) + "', adType=" + WrapUtils.wrapToTag(adRevenue.adType) + ", adNetwork='" + WrapUtils.wrapToTag(adRevenue.adNetwork) + "', adUnitId='" + WrapUtils.wrapToTag(adRevenue.adUnitId) + "', adUnitName='" + WrapUtils.wrapToTag(adRevenue.adUnitName) + "', adPlacementId='" + WrapUtils.wrapToTag(adRevenue.adPlacementId) + "', adPlacementName='" + WrapUtils.wrapToTag(adRevenue.adPlacementName) + "', precision='" + WrapUtils.wrapToTag(adRevenue.precision) + "', payload=" + Ib.b(adRevenue.payload) + ", autoCollected=" + z + "}", new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0246fb
    public final void b(String str, String str2) {
        this.c.info("Event received: " + WrapUtils.wrapToTag(str) + ". With value: " + WrapUtils.wrapToTag(str2), new Object[0]);
        Qi qi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = Q9.f730a;
        Db db = Db.EVENT_TYPE_UNDEFINED;
        C0188d4 c0188d4 = new C0188d4(str2, str, 1, 0, publicLogger);
        c0188d4.l = G9.JS;
        Zh zh = this.b;
        qi.getClass();
        qi.a(Qi.a(c0188d4, zh), zh, 1, (Map) null);
    }

    public final void a(Map<String, String> map) {
        if (Oo.a((Map) map)) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            putAppEnvironmentValue(entry.getKey(), entry.getValue());
        }
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, String str2) {
        this.c.info("Event received: " + WrapUtils.wrapToTag(str) + ". With value: " + WrapUtils.wrapToTag(str2), new Object[0]);
        Qi qi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = Q9.f730a;
        Db db = Db.EVENT_TYPE_UNDEFINED;
        C0188d4 c0188d4 = new C0188d4(str2, str, 1, 0, publicLogger);
        Zh zh = this.b;
        qi.getClass();
        qi.a(Qi.a(c0188d4, zh), zh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2) {
        reportError(str, str2, (Throwable) null);
    }

    public final C0621to a(Throwable th) {
        Throwable th2;
        StackTraceElement[] stackTraceElementArr;
        if (th == null) {
            stackTraceElementArr = null;
            th2 = null;
        } else if (th instanceof C0108a2) {
            stackTraceElementArr = th.getStackTrace();
            th2 = null;
        } else {
            th2 = th;
            stackTraceElementArr = null;
        }
        return AbstractC0699wo.a(th2, new X(null, null, this.j.a()), stackTraceElementArr != null ? Arrays.asList(stackTraceElementArr) : null, (String) this.k.b.a(), (Boolean) this.k.c.a());
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2, Throwable th) {
        M6 m6 = new M6(new Tg(str2, a(th)), str);
        Qi qi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.f.fromModel(m6));
        PublicLogger publicLogger = this.c;
        Set set = Q9.f730a;
        Db db = Db.EVENT_TYPE_UNDEFINED;
        C0188d4 c0188d4 = new C0188d4(byteArray, str2, 5896, publicLogger);
        Zh zh = this.b;
        qi.getClass();
        qi.a(Qi.a(c0188d4, zh), zh, 1, (Map) null);
        this.c.info("Error received: id: %s, message: %s", WrapUtils.wrapToTag(str), WrapUtils.wrapToTag(str2));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0246fb
    public final void b(String str) {
        Qi qi = this.h;
        C0241f6 a2 = C0241f6.a(str);
        Zh zh = this.b;
        qi.getClass();
        qi.a(Qi.a(a2, zh), zh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        C0621to a2 = this.l.a(pluginErrorDetails);
        Qi qi = this.h;
        C0362jo c0362jo = a2.f1223a;
        String str = c0362jo != null ? (String) WrapUtils.getOrDefault(c0362jo.f1058a, "") : "";
        byte[] byteArray = MessageNano.toByteArray(this.d.fromModel(a2));
        PublicLogger publicLogger = this.c;
        Set set = Q9.f730a;
        Db db = Db.EVENT_TYPE_UNDEFINED;
        C0188d4 c0188d4 = new C0188d4(byteArray, str, 5891, publicLogger);
        Zh zh = this.b;
        qi.getClass();
        qi.a(Qi.a(c0188d4, zh), zh, 1, (Map) null);
        this.c.info("Crash from plugin received: %s", WrapUtils.wrapToTag(pluginErrorDetails.getMessage()));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0246fb
    public final boolean b() {
        return this.b.f();
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, Map<String, Object> map) {
        Qi qi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = Q9.f730a;
        Db db = Db.EVENT_TYPE_UNDEFINED;
        qi.a(new C0188d4("", str, 1, 0, publicLogger), this.b, 1, map);
        this.c.info("Event received: " + WrapUtils.wrapToTag(str) + ". With value: " + WrapUtils.wrapToTag(map == null ? null : map.toString()), new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0505pb, io.appmetrica.analytics.impl.InterfaceC0608tb
    public final void a(C0621to c0621to) {
        pauseSession();
        Qi qi = this.h;
        Ph a2 = qi.a(c0621to, this.b);
        Zh zh = a2.e;
        InterfaceC0567rm interfaceC0567rm = qi.e;
        if (interfaceC0567rm != null) {
            zh.b.setUuid(((C0542qm) interfaceC0567rm).g());
        } else {
            zh.getClass();
        }
        qi.c.b(a2);
        this.c.info("Unhandled exception received: " + c0621to, new Object[0]);
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        C0621to c0621to;
        C0379kf c0379kf = this.l;
        if (pluginErrorDetails != null) {
            c0621to = c0379kf.a(pluginErrorDetails);
        } else {
            c0379kf.getClass();
            c0621to = null;
        }
        Tg tg = new Tg(str, c0621to);
        Qi qi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.e.fromModel(tg));
        PublicLogger publicLogger = this.c;
        Set set = Q9.f730a;
        Db db = Db.EVENT_TYPE_UNDEFINED;
        C0188d4 c0188d4 = new C0188d4(byteArray, str, 5896, publicLogger);
        Zh zh = this.b;
        qi.getClass();
        qi.a(Qi.a(c0188d4, zh), zh, 1, (Map) null);
        this.c.info("Error from plugin received: %s", WrapUtils.wrapToTag(str));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportEvent(ModuleEvent moduleEvent) {
        G9 g9;
        if (n.contains(Integer.valueOf(moduleEvent.getType()))) {
            return;
        }
        PublicLogger publicLogger = this.c;
        Set set = Q9.f730a;
        String value = moduleEvent.getValue();
        String name = moduleEvent.getName();
        Db db = Db.EVENT_TYPE_UNDEFINED;
        C0188d4 c0188d4 = new C0188d4(value, name, 8192, moduleEvent.getType(), publicLogger);
        int i = Y8.f856a[moduleEvent.getCategory().ordinal()];
        if (i == 1) {
            g9 = G9.NATIVE;
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            g9 = G9.SYSTEM;
        }
        c0188d4.l = g9;
        c0188d4.c = Ib.b(moduleEvent.getEnvironment());
        if (moduleEvent.getExtras() != null) {
            c0188d4.p = moduleEvent.getExtras();
        }
        this.h.a(c0188d4, this.b, moduleEvent.getServiceDataReporterType(), moduleEvent.getAttributes());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0505pb, io.appmetrica.analytics.impl.InterfaceC0313i0
    public final void a(X x) {
        C0209e0 c0209e0 = new C0209e0(x, (String) this.k.b.a(), (Boolean) this.k.c.a());
        Qi qi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.g.fromModel(c0209e0));
        PublicLogger publicLogger = this.c;
        Set set = Q9.f730a;
        Db db = Db.EVENT_TYPE_UNDEFINED;
        C0188d4 c0188d4 = new C0188d4(byteArray, "", 5968, publicLogger);
        Zh zh = this.b;
        qi.getClass();
        qi.a(Qi.a(c0188d4, zh), zh, 1, (Map) null);
        PublicLogger publicLogger2 = this.c;
        StringBuilder sb = new StringBuilder("ANR was reported ");
        Zn zn = x.f835a;
        publicLogger2.info(sb.append(zn != null ? "Thread[name=" + zn.f877a + ",tid={" + zn.c + ", priority=" + zn.b + ", group=" + zn.d + "}] at " + CollectionsKt.joinToString$default(zn.f, "\n", null, null, 0, null, null, 62, null) : null).toString(), new Object[0]);
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        C0621to c0621to;
        C0379kf c0379kf = this.l;
        if (pluginErrorDetails != null) {
            c0621to = c0379kf.a(pluginErrorDetails);
        } else {
            c0379kf.getClass();
            c0621to = null;
        }
        M6 m6 = new M6(new Tg(str2, c0621to), str);
        Qi qi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.f.fromModel(m6));
        PublicLogger publicLogger = this.c;
        Set set = Q9.f730a;
        Db db = Db.EVENT_TYPE_UNDEFINED;
        C0188d4 c0188d4 = new C0188d4(byteArray, str2, 5896, publicLogger);
        Zh zh = this.b;
        qi.getClass();
        qi.a(Qi.a(c0188d4, zh), zh, 1, (Map) null);
        this.c.info("Error with identifier: %s from plugin received: %s", str, WrapUtils.wrapToTag(str2));
    }
}
