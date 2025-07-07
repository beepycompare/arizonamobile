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
/* loaded from: classes4.dex */
public abstract class V2 implements Wa {
    public static final HashSet n = new HashSet(Arrays.asList(1, 13));
    public static final T2 o = new T2();

    /* renamed from: a  reason: collision with root package name */
    protected final Context f667a;
    protected final Qh b;
    protected final PublicLogger c;
    protected final Ln d;
    protected final Pg e;
    protected final N6 f;
    public final C0150b0 g;
    protected final Gi h;
    public Hb i;
    public final J6 j;
    public final C0262fa k;
    public final Ve l;
    public final C0173bn m;

    public V2(Context context, Gi gi, Qh qh, C0262fa c0262fa, J6 j6, Ln ln, Pg pg, N6 n6, C0150b0 c0150b0, Ve ve) {
        Context applicationContext = context.getApplicationContext();
        this.f667a = applicationContext;
        this.h = gi;
        this.b = qh;
        this.k = c0262fa;
        this.d = ln;
        this.e = pg;
        this.f = n6;
        this.g = c0150b0;
        this.l = ve;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(qh.b().getApiKey());
        this.c = orCreatePublicLogger;
        if (AbstractC0628u3.a(qh.b().isLogEnabled())) {
            orCreatePublicLogger.setEnabled(true);
        }
        this.j = j6;
        this.m = new C0173bn(applicationContext);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            this.c.warning("Invalid Error Environment (key,value) pair: (%s,%s).", str, str2);
            return;
        }
        this.c.info("Put error environment pair <%s, %s>", str, str2);
        Qh qh = this.b;
        synchronized (qh) {
            T8 t8 = qh.c;
            t8.b.b(t8.f637a, str, str2);
        }
    }

    public final void b(Map<String, String> map) {
        if (fo.a((Map) map)) {
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
        Hb hb = this.i;
        hb.f459a.removeCallbacks(hb.c, hb.b.b.b.getApiKey());
        this.b.e = true;
        Gi gi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = O9.f564a;
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        C0331i4 c0331i4 = new C0331i4("", str, 3, 0, publicLogger);
        Qh qh = this.b;
        gi.getClass();
        gi.a(Gi.a(c0331i4, qh), qh, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void clearAppEnvironment() {
        String str;
        this.c.info("Clear app environment", new Object[0]);
        Gi gi = this.h;
        Qh qh = this.b;
        gi.getClass();
        C0333i6 n2 = C0331i4.n();
        Nf nf = new Nf(qh.f796a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(qh.b);
        T8 t8 = qh.c;
        synchronized (qh) {
            str = qh.f;
        }
        gi.a(new Gh(n2, false, 1, null, new Qh(nf, counterConfiguration, t8, str)));
    }

    public final void d(String str) {
        this.h.d.b();
        Hb hb = this.i;
        Hb.a(hb.f459a, hb.b, hb.c);
        Gi gi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = O9.f564a;
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        C0331i4 c0331i4 = new C0331i4("", str, 6400, 0, publicLogger);
        Qh qh = this.b;
        gi.getClass();
        gi.a(Gi.a(c0331i4, qh), qh, 1, null);
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
        Cf cf;
        Gi gi = this.h;
        Qh qh = this.b;
        gi.getClass();
        Gf gf = qh.d;
        synchronized (qh) {
            str = qh.f;
        }
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(qh.b.getApiKey());
        Set set = O9.f564a;
        JSONObject jSONObject = new JSONObject();
        if (gf != null && (cf = gf.f444a) != null) {
            try {
                jSONObject.put("preloadInfo", cf.c());
            } catch (Throwable unused) {
            }
        }
        String jSONObject2 = jSONObject.toString();
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        C0331i4 c0331i4 = new C0331i4(jSONObject2, "", 6144, 0, orCreatePublicLogger);
        c0331i4.c(str);
        gi.a(Gi.a(c0331i4, qh), qh, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void pauseSession() {
        this.c.info("Pause session", new Object[0]);
        c(null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void putAppEnvironmentValue(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            this.c.warning("Invalid App Environment (key,value) pair: (%s,%s).", str, str2);
            return;
        }
        this.c.info("Put app environment: <%s, %s>", str, str2);
        Gi gi = this.h;
        Qh qh = this.b;
        gi.getClass();
        C0333i6 b = C0331i4.b(str, str2);
        Nf nf = new Nf(qh.f796a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(qh.b);
        T8 t8 = qh.c;
        synchronized (qh) {
            str3 = qh.f;
        }
        gi.a(new Gh(b, false, 1, null, new Qh(nf, counterConfiguration, t8, str3)));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAdRevenue(AdRevenue adRevenue) {
        reportAdRevenue(adRevenue, false);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAnr(Map<Thread, StackTraceElement[]> map) {
        StackTraceElement[] stackTraceElementArr;
        C0176c0 c0176c0 = new C0176c0(new C0202d0(this, map));
        Ea ea = new Ea();
        J6 j6 = C0704x4.l().f1116a;
        Thread a2 = c0176c0.a();
        Map map2 = null;
        try {
            stackTraceElementArr = c0176c0.b();
            if (stackTraceElementArr == null) {
                try {
                    stackTraceElementArr = a2.getStackTrace();
                } catch (SecurityException unused) {
                }
            }
        } catch (SecurityException unused2) {
            stackTraceElementArr = null;
        }
        C0549qn c0549qn = (C0549qn) ea.apply(a2, stackTraceElementArr);
        ArrayList arrayList = new ArrayList();
        TreeMap treeMap = new TreeMap(new C0673vn());
        try {
            map2 = c0176c0.c();
        } catch (SecurityException unused3) {
        }
        if (map2 != null) {
            treeMap.putAll(map2);
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            Thread thread = (Thread) entry.getKey();
            if (thread != a2 && thread != null) {
                arrayList.add((C0549qn) ea.apply(thread, (StackTraceElement[]) entry.getValue()));
            }
        }
        a(new U(c0549qn, arrayList, j6.b()));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportECommerce(ECommerceEvent eCommerceEvent) {
        String str;
        this.c.info("E-commerce event received: " + eCommerceEvent.getPublicDescription(), new Object[0]);
        Gi gi = this.h;
        Qh qh = this.b;
        gi.getClass();
        for (Ni ni : eCommerceEvent.toProto()) {
            C0331i4 c0331i4 = new C0331i4(LoggerStorage.getOrCreatePublicLogger(qh.b.getApiKey()));
            EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
            c0331i4.d = 41000;
            c0331i4.b = c0331i4.e(Base64Utils.compressBase64(MessageNano.toByteArray((MessageNano) ni.f556a)));
            c0331i4.g = ni.b.getBytesTruncated();
            Nf nf = new Nf(qh.f796a);
            CounterConfiguration counterConfiguration = new CounterConfiguration(qh.b);
            T8 t8 = qh.c;
            synchronized (qh) {
                str = qh.f;
            }
            gi.a(new Gh(c0331i4, false, 1, null, new Qh(nf, counterConfiguration, t8, str)));
        }
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, Throwable th) {
        Og og = new Og(str, a(th));
        Gi gi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.e.fromModel(og));
        PublicLogger publicLogger = this.c;
        Set set = O9.f564a;
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        C0331i4 c0331i4 = new C0331i4(byteArray, str, 5892, publicLogger);
        Qh qh = this.b;
        gi.getClass();
        gi.a(Gi.a(c0331i4, qh), qh, 1, null);
        this.c.info("Error received: %s", WrapUtils.wrapToTag(str));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str) {
        this.c.info("Event received: " + WrapUtils.wrapToTag(str), new Object[0]);
        Gi gi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = O9.f564a;
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        C0331i4 c0331i4 = new C0331i4("", str, 1, 0, publicLogger);
        Qh qh = this.b;
        gi.getClass();
        gi.a(Gi.a(c0331i4, qh), qh, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportRevenue(Revenue revenue) {
        String str;
        Xi xi = U2.f651a;
        xi.getClass();
        ko a2 = xi.a(revenue);
        if (a2.f912a) {
            Gi gi = this.h;
            Yi yi = new Yi(revenue, this.c);
            Qh qh = this.b;
            gi.getClass();
            C0331i4 a3 = C0331i4.a(LoggerStorage.getOrCreatePublicLogger(qh.b.getApiKey()), yi);
            Nf nf = new Nf(qh.f796a);
            CounterConfiguration counterConfiguration = new CounterConfiguration(qh.b);
            T8 t8 = qh.c;
            synchronized (qh) {
                str = qh.f;
            }
            gi.a(new Gh(a3, false, 1, null, new Qh(nf, counterConfiguration, t8, str)));
            this.c.info("Revenue received for productID: " + WrapUtils.wrapToTag(revenue.productID) + " of quantity: " + WrapUtils.wrapToTag(revenue.quantity) + " with price (in micros): " + revenue.priceMicros + " " + revenue.currency, new Object[0]);
            return;
        }
        this.c.warning("Passed revenue is not valid. Reason: " + a2.b, new Object[0]);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUnhandledException(Throwable th) {
        Kn a2 = Nn.a(th, new U(null, null, this.j.b()), null, (String) this.k.b.a(), (Boolean) this.k.c.a());
        Gi gi = this.h;
        gi.a(gi.a(a2, this.b));
        this.c.info("Unhandled exception received: " + a2, new Object[0]);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUserProfile(UserProfile userProfile) {
        ko a2;
        String str;
        Xn xn = new Xn(Xn.c);
        for (UserProfileUpdate<? extends Yn> userProfileUpdate : userProfile.getUserProfileUpdates()) {
            Yn userProfileUpdatePatcher = userProfileUpdate.getUserProfileUpdatePatcher();
            ((Nd) userProfileUpdatePatcher).e = this.c;
            userProfileUpdatePatcher.a(xn);
        }
        C0200co c0200co = new C0200co();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < xn.f711a.size(); i++) {
            SparseArray sparseArray = xn.f711a;
            for (Zn zn : ((HashMap) sparseArray.get(sparseArray.keyAt(i))).values()) {
                arrayList.add(zn);
            }
        }
        c0200co.f790a = (Zn[]) arrayList.toArray(new Zn[arrayList.size()]);
        if (o.a(c0200co).f912a) {
            Gi gi = this.h;
            Qh qh = this.b;
            gi.getClass();
            C0333i6 a3 = C0331i4.a(c0200co);
            Nf nf = new Nf(qh.f796a);
            CounterConfiguration counterConfiguration = new CounterConfiguration(qh.b);
            T8 t8 = qh.c;
            synchronized (qh) {
                str = qh.f;
            }
            gi.a(new Gh(a3, false, 1, null, new Qh(nf, counterConfiguration, t8, str)));
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
        Gi gi = this.h;
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        PublicLogger publicLogger = this.c;
        Set set = O9.f564a;
        C0331i4 c0331i4 = new C0331i4("", "", 256, 0, publicLogger);
        Qh qh = this.b;
        gi.getClass();
        gi.a(Gi.a(c0331i4, qh), qh, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setDataSendingEnabled(boolean z) {
        this.b.b.setDataSendingEnabled(z);
        this.c.info("Updated data sending enabled: %s", Boolean.valueOf(z));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void setSessionExtra(String str, byte[] bArr) {
        Gi gi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = O9.f564a;
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        C0331i4 c0331i4 = new C0331i4("", null, 8193, 0, publicLogger);
        if (bArr == null) {
            bArr = new byte[0];
        }
        c0331i4.p = Collections.singletonMap(str, bArr);
        Qh qh = this.b;
        gi.getClass();
        gi.a(Gi.a(c0331i4, qh), qh, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setUserProfileID(String str) {
        String str2;
        Gi gi = this.h;
        Qh qh = this.b;
        gi.getClass();
        C0331i4 c0331i4 = new C0331i4(LoggerStorage.getOrCreatePublicLogger(qh.b.getApiKey()));
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        c0331i4.d = 40962;
        c0331i4.c(str);
        c0331i4.b = c0331i4.e(str);
        Nf nf = new Nf(qh.f796a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(qh.b);
        T8 t8 = qh.c;
        synchronized (qh) {
            str2 = qh.f;
        }
        gi.a(new Gh(c0331i4, false, 1, null, new Qh(nf, counterConfiguration, t8, str2)));
        this.c.info("Set user profile ID: " + WrapUtils.wrapToTag(str), new Object[0]);
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportAdRevenue(AdRevenue adRevenue, boolean z) {
        String str;
        Gi gi = this.h;
        D d = new D(adRevenue, z, this.m, this.c);
        Qh qh = this.b;
        gi.getClass();
        C0331i4 a2 = C0331i4.a(LoggerStorage.getOrCreatePublicLogger(qh.b.getApiKey()), d);
        Nf nf = new Nf(qh.f796a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(qh.b);
        T8 t8 = qh.c;
        synchronized (qh) {
            str = qh.f;
        }
        gi.a(new Gh(a2, false, 1, null, new Qh(nf, counterConfiguration, t8, str)));
        this.c.info("AdRevenue Received: AdRevenue{adRevenue=" + adRevenue.adRevenue + ", currency='" + WrapUtils.wrapToTag(adRevenue.currency.getCurrencyCode()) + "', adType=" + WrapUtils.wrapToTag(adRevenue.adType) + ", adNetwork='" + WrapUtils.wrapToTag(adRevenue.adNetwork) + "', adUnitId='" + WrapUtils.wrapToTag(adRevenue.adUnitId) + "', adUnitName='" + WrapUtils.wrapToTag(adRevenue.adUnitName) + "', adPlacementId='" + WrapUtils.wrapToTag(adRevenue.adPlacementId) + "', adPlacementName='" + WrapUtils.wrapToTag(adRevenue.adPlacementName) + "', precision='" + WrapUtils.wrapToTag(adRevenue.precision) + "', payload=" + AbstractC0761zb.b(adRevenue.payload) + ", autoCollected=" + z + "}", new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.Wa
    public final void b(String str, String str2) {
        this.c.info("Event received: " + WrapUtils.wrapToTag(str) + ". With value: " + WrapUtils.wrapToTag(str2), new Object[0]);
        Gi gi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = O9.f564a;
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        C0331i4 c0331i4 = new C0331i4(str2, str, 1, 0, publicLogger);
        c0331i4.l = E9.JS;
        Qh qh = this.b;
        gi.getClass();
        gi.a(Gi.a(c0331i4, qh), qh, 1, null);
    }

    public final void a(Map<String, String> map) {
        if (fo.a((Map) map)) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            putAppEnvironmentValue(entry.getKey(), entry.getValue());
        }
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, String str2) {
        this.c.info("Event received: " + WrapUtils.wrapToTag(str) + ". With value: " + WrapUtils.wrapToTag(str2), new Object[0]);
        Gi gi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = O9.f564a;
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        C0331i4 c0331i4 = new C0331i4(str2, str, 1, 0, publicLogger);
        Qh qh = this.b;
        gi.getClass();
        gi.a(Gi.a(c0331i4, qh), qh, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2) {
        reportError(str, str2, (Throwable) null);
    }

    public final Kn a(Throwable th) {
        Throwable th2;
        StackTraceElement[] stackTraceElementArr;
        if (th == null) {
            stackTraceElementArr = null;
            th2 = null;
        } else if (th instanceof T1) {
            stackTraceElementArr = th.getStackTrace();
            th2 = null;
        } else {
            th2 = th;
            stackTraceElementArr = null;
        }
        return Nn.a(th2, new U(null, null, this.j.b()), stackTraceElementArr != null ? Arrays.asList(stackTraceElementArr) : null, (String) this.k.b.a(), (Boolean) this.k.c.a());
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2, Throwable th) {
        M6 m6 = new M6(new Og(str2, a(th)), str);
        Gi gi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.f.fromModel(m6));
        PublicLogger publicLogger = this.c;
        Set set = O9.f564a;
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        C0331i4 c0331i4 = new C0331i4(byteArray, str2, 5896, publicLogger);
        Qh qh = this.b;
        gi.getClass();
        gi.a(Gi.a(c0331i4, qh), qh, 1, null);
        this.c.info("Error received: id: %s, message: %s", WrapUtils.wrapToTag(str), WrapUtils.wrapToTag(str2));
    }

    @Override // io.appmetrica.analytics.impl.Wa
    public final boolean b() {
        return this.b.f();
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        Kn a2 = this.l.a(pluginErrorDetails);
        Gi gi = this.h;
        An an = a2.f509a;
        String str = an != null ? (String) WrapUtils.getOrDefault(an.f342a, "") : "";
        byte[] byteArray = MessageNano.toByteArray(this.d.fromModel(a2));
        PublicLogger publicLogger = this.c;
        Set set = O9.f564a;
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        C0331i4 c0331i4 = new C0331i4(byteArray, str, 5891, publicLogger);
        Qh qh = this.b;
        gi.getClass();
        gi.a(Gi.a(c0331i4, qh), qh, 1, null);
        this.c.info("Crash from plugin received: %s", WrapUtils.wrapToTag(pluginErrorDetails.getMessage()));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, Map<String, Object> map) {
        Gi gi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = O9.f564a;
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        gi.a(new C0331i4("", str, 1, 0, publicLogger), this.b, 1, map);
        this.c.info("Event received: " + WrapUtils.wrapToTag(str) + ". With value: " + WrapUtils.wrapToTag(map == null ? null : map.toString()), new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0387kb, io.appmetrica.analytics.impl.InterfaceC0462nb
    public final void a(Kn kn) {
        Gi gi = this.h;
        Gh a2 = gi.a(kn, this.b);
        Qh qh = a2.e;
        Ml ml = gi.e;
        if (ml != null) {
            qh.b.setUuid(((Ll) ml).g());
        } else {
            qh.getClass();
        }
        gi.c.b(a2);
        this.c.info("Unhandled exception received: " + kn, new Object[0]);
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        Kn kn;
        Ve ve = this.l;
        if (pluginErrorDetails != null) {
            kn = ve.a(pluginErrorDetails);
        } else {
            ve.getClass();
            kn = null;
        }
        Og og = new Og(str, kn);
        Gi gi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.e.fromModel(og));
        PublicLogger publicLogger = this.c;
        Set set = O9.f564a;
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        C0331i4 c0331i4 = new C0331i4(byteArray, str, 5896, publicLogger);
        Qh qh = this.b;
        gi.getClass();
        gi.a(Gi.a(c0331i4, qh), qh, 1, null);
        this.c.info("Error from plugin received: %s", WrapUtils.wrapToTag(str));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportEvent(ModuleEvent moduleEvent) {
        E9 e9;
        if (n.contains(Integer.valueOf(moduleEvent.getType()))) {
            return;
        }
        PublicLogger publicLogger = this.c;
        Set set = O9.f564a;
        String value = moduleEvent.getValue();
        String name = moduleEvent.getName();
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        C0331i4 c0331i4 = new C0331i4(value, name, 8192, moduleEvent.getType(), publicLogger);
        int i = U8.f655a[moduleEvent.getCategory().ordinal()];
        if (i == 1) {
            e9 = E9.NATIVE;
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            e9 = E9.SYSTEM;
        }
        c0331i4.l = e9;
        c0331i4.c = AbstractC0761zb.b(moduleEvent.getEnvironment());
        if (moduleEvent.getExtras() != null) {
            c0331i4.p = moduleEvent.getExtras();
        }
        this.h.a(c0331i4, this.b, moduleEvent.getServiceDataReporterType(), moduleEvent.getAttributes());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0387kb, io.appmetrica.analytics.impl.InterfaceC0227e0
    public final void a(U u) {
        C0124a0 c0124a0 = new C0124a0(u, (String) this.k.b.a(), (Boolean) this.k.c.a());
        Gi gi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.g.fromModel(c0124a0));
        PublicLogger publicLogger = this.c;
        Set set = O9.f564a;
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        C0331i4 c0331i4 = new C0331i4(byteArray, "", 5968, publicLogger);
        Qh qh = this.b;
        gi.getClass();
        gi.a(Gi.a(c0331i4, qh), qh, 1, null);
        PublicLogger publicLogger2 = this.c;
        StringBuilder sb = new StringBuilder("ANR was reported ");
        C0549qn c0549qn = u.f648a;
        publicLogger2.info(sb.append(c0549qn != null ? "Thread[name=" + c0549qn.f1011a + ",tid={" + c0549qn.c + ", priority=" + c0549qn.b + ", group=" + c0549qn.d + "}] at " + CollectionsKt.joinToString$default(c0549qn.f, "\n", null, null, 0, null, null, 62, null) : null).toString(), new Object[0]);
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        Kn kn;
        Ve ve = this.l;
        if (pluginErrorDetails != null) {
            kn = ve.a(pluginErrorDetails);
        } else {
            ve.getClass();
            kn = null;
        }
        M6 m6 = new M6(new Og(str2, kn), str);
        Gi gi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.f.fromModel(m6));
        PublicLogger publicLogger = this.c;
        Set set = O9.f564a;
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        C0331i4 c0331i4 = new C0331i4(byteArray, str2, 5896, publicLogger);
        Qh qh = this.b;
        gi.getClass();
        gi.a(Gi.a(c0331i4, qh), qh, 1, null);
        this.c.info("Error with identifier: %s from plugin received: %s", str, WrapUtils.wrapToTag(str2));
    }

    @Override // io.appmetrica.analytics.impl.Wa
    public final void a(String str) {
        Gi gi = this.h;
        C0333i6 a2 = C0333i6.a(str);
        Qh qh = this.b;
        gi.getClass();
        gi.a(Gi.a(a2, qh), qh, 1, null);
    }
}
