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
/* loaded from: classes3.dex */
public abstract class Q2 implements Ka {
    public static final HashSet n = new HashSet(Arrays.asList(1, 13));
    public static final O2 o = new O2();

    /* renamed from: a  reason: collision with root package name */
    protected final Context f645a;
    protected final Kh b;
    protected final PublicLogger c;
    protected final Tn d;
    protected final Jg e;
    protected final C6 f;
    public final C0180d0 g;
    protected final Bi h;
    public C0646vb i;
    public final Hf j;
    public final T9 k;
    public final Oe l;
    public final C0331in m;

    public Q2(Context context, Bi bi, Kh kh, T9 t9, C0716y6 c0716y6, Tn tn, Jg jg, C6 c6, C0180d0 c0180d0, Oe oe) {
        Context applicationContext = context.getApplicationContext();
        this.f645a = applicationContext;
        this.h = bi;
        this.b = kh;
        this.k = t9;
        this.d = tn;
        this.e = jg;
        this.f = c6;
        this.g = c0180d0;
        this.l = oe;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(kh.b().getApiKey());
        this.c = orCreatePublicLogger;
        if (AbstractC0260g3.a(kh.b().isLogEnabled())) {
            orCreatePublicLogger.setEnabled(true);
        }
        this.j = c0716y6;
        this.m = new C0331in(applicationContext);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            this.c.warning("Invalid Error Environment (key,value) pair: (%s,%s).", str, str2);
            return;
        }
        this.c.info("Put error environment pair <%s, %s>", str, str2);
        Kh kh = this.b;
        synchronized (kh) {
            I8 i8 = kh.c;
            i8.b.b(i8.f523a, str, str2);
        }
    }

    public final void b(Map<String, String> map) {
        if (no.a((Map) map)) {
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
        Bi bi = this.h;
        Kh kh = this.b;
        bi.getClass();
        W5 n2 = U3.n();
        Gf gf = new Gf(kh.f629a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(kh.b);
        I8 i8 = kh.c;
        synchronized (kh) {
            str = kh.f;
        }
        bi.a(new Ah(n2, false, 1, null, new Kh(gf, counterConfiguration, i8, str)));
    }

    public final void d(String str) {
        if (this.b.f()) {
            return;
        }
        this.h.d.c();
        C0646vb c0646vb = this.i;
        c0646vb.f1168a.removeCallbacks(c0646vb.c, c0646vb.b.b.b.getApiKey());
        this.b.e = true;
        Bi bi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = D9.f438a;
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        U3 u3 = new U3("", str, 3, 0, publicLogger);
        Kh kh = this.b;
        bi.getClass();
        bi.a(Bi.a(u3, kh), kh, 1, (Map) null);
    }

    public final void e(String str) {
        this.h.d.b();
        C0646vb c0646vb = this.i;
        C0646vb.a(c0646vb.f1168a, c0646vb.b, c0646vb.c);
        Bi bi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = D9.f438a;
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        U3 u3 = new U3("", str, 6400, 0, publicLogger);
        Kh kh = this.b;
        bi.getClass();
        bi.a(Bi.a(u3, kh), kh, 1, (Map) null);
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
        C0650vf c0650vf;
        Bi bi = this.h;
        Kh kh = this.b;
        bi.getClass();
        C0750zf c0750zf = kh.d;
        synchronized (kh) {
            str = kh.f;
        }
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(kh.b.getApiKey());
        Set set = D9.f438a;
        JSONObject jSONObject = new JSONObject();
        if (c0750zf != null && (c0650vf = c0750zf.f1231a) != null) {
            try {
                jSONObject.put("preloadInfo", c0650vf.c());
            } catch (Throwable unused) {
            }
        }
        String jSONObject2 = jSONObject.toString();
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        U3 u3 = new U3(jSONObject2, "", 6144, 0, orCreatePublicLogger);
        u3.c(str);
        bi.a(Bi.a(u3, kh), kh, 1, (Map) null);
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
        Bi bi = this.h;
        Kh kh = this.b;
        bi.getClass();
        W5 b = U3.b(str, str2);
        Gf gf = new Gf(kh.f629a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(kh.b);
        I8 i8 = kh.c;
        synchronized (kh) {
            str3 = kh.f;
        }
        bi.a(new Ah(b, false, 1, null, new Kh(gf, counterConfiguration, i8, str3)));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAdRevenue(AdRevenue adRevenue) {
        reportAdRevenue(adRevenue, false);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAnr(Map<Thread, StackTraceElement[]> map) {
        StackTraceElement[] stackTraceElementArr;
        C0205e0 c0205e0 = new C0205e0(new C0231f0(this, map));
        C0570sa c0570sa = new C0570sa();
        C0716y6 c0716y6 = C0338j4.l().f945a;
        Thread a2 = c0205e0.a();
        Map map2 = null;
        try {
            stackTraceElementArr = c0205e0.b();
            if (stackTraceElementArr == null) {
                try {
                    stackTraceElementArr = a2.getStackTrace();
                } catch (SecurityException unused) {
                }
            }
        } catch (SecurityException unused2) {
            stackTraceElementArr = null;
        }
        C0733yn c0733yn = (C0733yn) c0570sa.apply(a2, stackTraceElementArr);
        ArrayList arrayList = new ArrayList();
        TreeMap treeMap = new TreeMap(new Dn());
        try {
            map2 = c0205e0.c();
        } catch (SecurityException unused3) {
        }
        if (map2 != null) {
            treeMap.putAll(map2);
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            Thread thread = (Thread) entry.getKey();
            if (thread != a2 && thread != null) {
                arrayList.add((C0733yn) c0570sa.apply(thread, (StackTraceElement[]) entry.getValue()));
            }
        }
        a(new V(c0733yn, arrayList, c0716y6.a()));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportECommerce(ECommerceEvent eCommerceEvent) {
        String str;
        this.c.info("E-commerce event received: " + eCommerceEvent.getPublicDescription(), new Object[0]);
        Bi bi = this.h;
        Kh kh = this.b;
        bi.getClass();
        for (Ii ii : eCommerceEvent.toProto()) {
            U3 u3 = new U3(LoggerStorage.getOrCreatePublicLogger(kh.b.getApiKey()));
            EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
            u3.d = 41000;
            u3.b = u3.e(Base64Utils.compressBase64(MessageNano.toByteArray((MessageNano) ii.f530a)));
            u3.g = ii.b.getBytesTruncated();
            Gf gf = new Gf(kh.f629a);
            CounterConfiguration counterConfiguration = new CounterConfiguration(kh.b);
            I8 i8 = kh.c;
            synchronized (kh) {
                str = kh.f;
            }
            bi.a(new Ah(u3, false, 1, null, new Kh(gf, counterConfiguration, i8, str)));
        }
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, Throwable th) {
        Ig ig = new Ig(str, a(th));
        Bi bi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.e.fromModel(ig));
        PublicLogger publicLogger = this.c;
        Set set = D9.f438a;
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        U3 u3 = new U3(byteArray, str, 5892, publicLogger);
        Kh kh = this.b;
        bi.getClass();
        bi.a(Bi.a(u3, kh), kh, 1, (Map) null);
        this.c.info("Error received: %s", WrapUtils.wrapToTag(str));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str) {
        this.c.info("Event received: " + WrapUtils.wrapToTag(str), new Object[0]);
        Bi bi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = D9.f438a;
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        U3 u3 = new U3("", str, 1, 0, publicLogger);
        Kh kh = this.b;
        bi.getClass();
        bi.a(Bi.a(u3, kh), kh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportRevenue(Revenue revenue) {
        String str;
        Si si = P2.f628a;
        si.getClass();
        so a2 = si.a(revenue);
        if (a2.f1120a) {
            Bi bi = this.h;
            Ti ti = new Ti(revenue, this.c);
            Kh kh = this.b;
            bi.getClass();
            U3 a3 = U3.a(LoggerStorage.getOrCreatePublicLogger(kh.b.getApiKey()), ti);
            Gf gf = new Gf(kh.f629a);
            CounterConfiguration counterConfiguration = new CounterConfiguration(kh.b);
            I8 i8 = kh.c;
            synchronized (kh) {
                str = kh.f;
            }
            bi.a(new Ah(a3, false, 1, null, new Kh(gf, counterConfiguration, i8, str)));
            this.c.info("Revenue received for productID: " + WrapUtils.wrapToTag(revenue.productID) + " of quantity: " + WrapUtils.wrapToTag(revenue.quantity) + " with price (in micros): " + revenue.priceMicros + " " + revenue.currency, new Object[0]);
            return;
        }
        this.c.warning("Passed revenue is not valid. Reason: " + a2.b, new Object[0]);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUnhandledException(Throwable th) {
        Sn a2 = Vn.a(th, new V(null, null, this.j.a()), null, (String) this.k.b.a(), (Boolean) this.k.c.a());
        Bi bi = this.h;
        bi.a(bi.a(a2, this.b));
        this.c.info("Unhandled exception received: " + a2, new Object[0]);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUserProfile(UserProfile userProfile) {
        so a2;
        String str;
        C0255fo c0255fo = new C0255fo(C0255fo.c);
        for (UserProfileUpdate<? extends InterfaceC0281go> userProfileUpdate : userProfile.getUserProfileUpdates()) {
            InterfaceC0281go userProfileUpdatePatcher = userProfileUpdate.getUserProfileUpdatePatcher();
            ((Hd) userProfileUpdatePatcher).e = this.c;
            userProfileUpdatePatcher.a(c0255fo);
        }
        C0384ko c0384ko = new C0384ko();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c0255fo.f882a.size(); i++) {
            SparseArray sparseArray = c0255fo.f882a;
            for (C0307ho c0307ho : ((HashMap) sparseArray.get(sparseArray.keyAt(i))).values()) {
                arrayList.add(c0307ho);
            }
        }
        c0384ko.f979a = (C0307ho[]) arrayList.toArray(new C0307ho[arrayList.size()]);
        if (o.a(c0384ko).f1120a) {
            Bi bi = this.h;
            Kh kh = this.b;
            bi.getClass();
            W5 a3 = U3.a(c0384ko);
            Gf gf = new Gf(kh.f629a);
            CounterConfiguration counterConfiguration = new CounterConfiguration(kh.b);
            I8 i8 = kh.c;
            synchronized (kh) {
                str = kh.f;
            }
            bi.a(new Ah(a3, false, 1, null, new Kh(gf, counterConfiguration, i8, str)));
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
        Bi bi = this.h;
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        PublicLogger publicLogger = this.c;
        Set set = D9.f438a;
        U3 u3 = new U3("", "", 256, 0, publicLogger);
        Kh kh = this.b;
        bi.getClass();
        bi.a(Bi.a(u3, kh), kh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setDataSendingEnabled(boolean z) {
        this.b.b.setDataSendingEnabled(z);
        this.c.info("Updated data sending enabled: %s", Boolean.valueOf(z));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void setSessionExtra(String str, byte[] bArr) {
        Bi bi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = D9.f438a;
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        U3 u3 = new U3("", null, 8193, 0, publicLogger);
        if (bArr == null) {
            bArr = new byte[0];
        }
        u3.p = Collections.singletonMap(str, bArr);
        Kh kh = this.b;
        bi.getClass();
        bi.a(Bi.a(u3, kh), kh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setUserProfileID(String str) {
        String str2;
        Bi bi = this.h;
        Kh kh = this.b;
        bi.getClass();
        U3 u3 = new U3(LoggerStorage.getOrCreatePublicLogger(kh.b.getApiKey()));
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        u3.d = 40962;
        u3.c(str);
        u3.b = u3.e(str);
        Gf gf = new Gf(kh.f629a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(kh.b);
        I8 i8 = kh.c;
        synchronized (kh) {
            str2 = kh.f;
        }
        bi.a(new Ah(u3, false, 1, null, new Kh(gf, counterConfiguration, i8, str2)));
        this.c.info("Set user profile ID: " + WrapUtils.wrapToTag(str), new Object[0]);
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportAdRevenue(AdRevenue adRevenue, boolean z) {
        String str;
        Bi bi = this.h;
        E e = new E(adRevenue, z, this.m, this.c);
        Kh kh = this.b;
        bi.getClass();
        U3 a2 = U3.a(LoggerStorage.getOrCreatePublicLogger(kh.b.getApiKey()), e);
        Gf gf = new Gf(kh.f629a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(kh.b);
        I8 i8 = kh.c;
        synchronized (kh) {
            str = kh.f;
        }
        bi.a(new Ah(a2, false, 1, null, new Kh(gf, counterConfiguration, i8, str)));
        this.c.info("AdRevenue Received: AdRevenue{adRevenue=" + adRevenue.adRevenue + ", currency='" + WrapUtils.wrapToTag(adRevenue.currency.getCurrencyCode()) + "', adType=" + WrapUtils.wrapToTag(adRevenue.adType) + ", adNetwork='" + WrapUtils.wrapToTag(adRevenue.adNetwork) + "', adUnitId='" + WrapUtils.wrapToTag(adRevenue.adUnitId) + "', adUnitName='" + WrapUtils.wrapToTag(adRevenue.adUnitName) + "', adPlacementId='" + WrapUtils.wrapToTag(adRevenue.adPlacementId) + "', adPlacementName='" + WrapUtils.wrapToTag(adRevenue.adPlacementName) + "', precision='" + WrapUtils.wrapToTag(adRevenue.precision) + "', payload=" + AbstractC0447nb.b(adRevenue.payload) + ", autoCollected=" + z + "}", new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.Ka
    public final void b(String str, String str2) {
        this.c.info("Event received: " + WrapUtils.wrapToTag(str) + ". With value: " + WrapUtils.wrapToTag(str2), new Object[0]);
        Bi bi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = D9.f438a;
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        U3 u3 = new U3(str2, str, 1, 0, publicLogger);
        u3.l = EnumC0594t9.JS;
        Kh kh = this.b;
        bi.getClass();
        bi.a(Bi.a(u3, kh), kh, 1, (Map) null);
    }

    public final void a(Map<String, String> map) {
        if (no.a((Map) map)) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            putAppEnvironmentValue(entry.getKey(), entry.getValue());
        }
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, String str2) {
        this.c.info("Event received: " + WrapUtils.wrapToTag(str) + ". With value: " + WrapUtils.wrapToTag(str2), new Object[0]);
        Bi bi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = D9.f438a;
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        U3 u3 = new U3(str2, str, 1, 0, publicLogger);
        Kh kh = this.b;
        bi.getClass();
        bi.a(Bi.a(u3, kh), kh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2) {
        reportError(str, str2, (Throwable) null);
    }

    public final Sn a(Throwable th) {
        Throwable th2;
        StackTraceElement[] stackTraceElementArr;
        if (th == null) {
            stackTraceElementArr = null;
            th2 = null;
        } else if (th instanceof W1) {
            stackTraceElementArr = th.getStackTrace();
            th2 = null;
        } else {
            th2 = th;
            stackTraceElementArr = null;
        }
        return Vn.a(th2, new V(null, null, this.j.a()), stackTraceElementArr != null ? Arrays.asList(stackTraceElementArr) : null, (String) this.k.b.a(), (Boolean) this.k.c.a());
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2, Throwable th) {
        B6 b6 = new B6(new Ig(str2, a(th)), str);
        Bi bi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.f.fromModel(b6));
        PublicLogger publicLogger = this.c;
        Set set = D9.f438a;
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        U3 u3 = new U3(byteArray, str2, 5896, publicLogger);
        Kh kh = this.b;
        bi.getClass();
        bi.a(Bi.a(u3, kh), kh, 1, (Map) null);
        this.c.info("Error received: id: %s, message: %s", WrapUtils.wrapToTag(str), WrapUtils.wrapToTag(str2));
    }

    @Override // io.appmetrica.analytics.impl.Ka
    public final void b(String str) {
        Bi bi = this.h;
        W5 a2 = W5.a(str);
        Kh kh = this.b;
        bi.getClass();
        bi.a(Bi.a(a2, kh), kh, 1, (Map) null);
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        Sn a2 = this.l.a(pluginErrorDetails);
        Bi bi = this.h;
        In in = a2.f691a;
        String str = in != null ? (String) WrapUtils.getOrDefault(in.f534a, "") : "";
        byte[] byteArray = MessageNano.toByteArray(this.d.fromModel(a2));
        PublicLogger publicLogger = this.c;
        Set set = D9.f438a;
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        U3 u3 = new U3(byteArray, str, 5891, publicLogger);
        Kh kh = this.b;
        bi.getClass();
        bi.a(Bi.a(u3, kh), kh, 1, (Map) null);
        this.c.info("Crash from plugin received: %s", WrapUtils.wrapToTag(pluginErrorDetails.getMessage()));
    }

    @Override // io.appmetrica.analytics.impl.Ka
    public final boolean b() {
        return this.b.f();
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, Map<String, Object> map) {
        Bi bi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = D9.f438a;
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        bi.a(new U3("", str, 1, 0, publicLogger), this.b, 1, map);
        this.c.info("Event received: " + WrapUtils.wrapToTag(str) + ". With value: " + WrapUtils.wrapToTag(map == null ? null : map.toString()), new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.Ya, io.appmetrica.analytics.impl.InterfaceC0139bb
    public final void a(Sn sn) {
        Bi bi = this.h;
        Ah a2 = bi.a(sn, this.b);
        Kh kh = a2.e;
        Tl tl = bi.e;
        if (tl != null) {
            kh.b.setUuid(((Sl) tl).g());
        } else {
            kh.getClass();
        }
        bi.c.b(a2);
        this.c.info("Unhandled exception received: " + sn, new Object[0]);
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        Sn sn;
        Oe oe = this.l;
        if (pluginErrorDetails != null) {
            sn = oe.a(pluginErrorDetails);
        } else {
            oe.getClass();
            sn = null;
        }
        Ig ig = new Ig(str, sn);
        Bi bi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.e.fromModel(ig));
        PublicLogger publicLogger = this.c;
        Set set = D9.f438a;
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        U3 u3 = new U3(byteArray, str, 5896, publicLogger);
        Kh kh = this.b;
        bi.getClass();
        bi.a(Bi.a(u3, kh), kh, 1, (Map) null);
        this.c.info("Error from plugin received: %s", WrapUtils.wrapToTag(str));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportEvent(ModuleEvent moduleEvent) {
        EnumC0594t9 enumC0594t9;
        if (n.contains(Integer.valueOf(moduleEvent.getType()))) {
            return;
        }
        PublicLogger publicLogger = this.c;
        Set set = D9.f438a;
        String value = moduleEvent.getValue();
        String name = moduleEvent.getName();
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        U3 u3 = new U3(value, name, 8192, moduleEvent.getType(), publicLogger);
        int i = J8.f544a[moduleEvent.getCategory().ordinal()];
        if (i == 1) {
            enumC0594t9 = EnumC0594t9.NATIVE;
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            enumC0594t9 = EnumC0594t9.SYSTEM;
        }
        u3.l = enumC0594t9;
        u3.c = AbstractC0447nb.b(moduleEvent.getEnvironment());
        if (moduleEvent.getExtras() != null) {
            u3.p = moduleEvent.getExtras();
        }
        this.h.a(u3, this.b, moduleEvent.getServiceDataReporterType(), moduleEvent.getAttributes());
    }

    @Override // io.appmetrica.analytics.impl.Ya, io.appmetrica.analytics.impl.InterfaceC0257g0
    public final void a(V v) {
        C0154c0 c0154c0 = new C0154c0(v, (String) this.k.b.a(), (Boolean) this.k.c.a());
        Bi bi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.g.fromModel(c0154c0));
        PublicLogger publicLogger = this.c;
        Set set = D9.f438a;
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        U3 u3 = new U3(byteArray, "", 5968, publicLogger);
        Kh kh = this.b;
        bi.getClass();
        bi.a(Bi.a(u3, kh), kh, 1, (Map) null);
        PublicLogger publicLogger2 = this.c;
        StringBuilder sb = new StringBuilder("ANR was reported ");
        C0733yn c0733yn = v.f725a;
        publicLogger2.info(sb.append(c0733yn != null ? "Thread[name=" + c0733yn.f1219a + ",tid={" + c0733yn.c + ", priority=" + c0733yn.b + ", group=" + c0733yn.d + "}] at " + CollectionsKt.joinToString$default(c0733yn.f, "\n", null, null, 0, null, null, 62, null) : null).toString(), new Object[0]);
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        Sn sn;
        Oe oe = this.l;
        if (pluginErrorDetails != null) {
            sn = oe.a(pluginErrorDetails);
        } else {
            oe.getClass();
            sn = null;
        }
        B6 b6 = new B6(new Ig(str2, sn), str);
        Bi bi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.f.fromModel(b6));
        PublicLogger publicLogger = this.c;
        Set set = D9.f438a;
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        U3 u3 = new U3(byteArray, str2, 5896, publicLogger);
        Kh kh = this.b;
        bi.getClass();
        bi.a(Bi.a(u3, kh), kh, 1, (Map) null);
        this.c.info("Error with identifier: %s from plugin received: %s", str, WrapUtils.wrapToTag(str2));
    }
}
