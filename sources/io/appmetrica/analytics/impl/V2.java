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
public abstract class V2 implements InterfaceC0120ab {
    public static final HashSet n = new HashSet(Arrays.asList(1, 13));
    public static final T2 o = new T2();

    /* renamed from: a  reason: collision with root package name */
    protected final Context f688a;
    protected final Xh b;
    protected final PublicLogger c;
    protected final Tn d;
    protected final Wg e;
    protected final R6 f;
    public final C0135b0 g;
    protected final Oi h;
    public Lb i;
    public final Sf j;
    public final C0351ja k;
    public final Ze l;
    public final C0364jn m;

    public V2(Context context, Oi oi, Xh xh, C0351ja c0351ja, N6 n6, Tn tn, Wg wg, R6 r6, C0135b0 c0135b0, Ze ze) {
        Context applicationContext = context.getApplicationContext();
        this.f688a = applicationContext;
        this.h = oi;
        this.b = xh;
        this.k = c0351ja;
        this.d = tn;
        this.e = wg;
        this.f = r6;
        this.g = c0135b0;
        this.l = ze;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(xh.b().getApiKey());
        this.c = orCreatePublicLogger;
        if (AbstractC0620u3.a(xh.b().isLogEnabled())) {
            orCreatePublicLogger.setEnabled(true);
        }
        this.j = n6;
        this.m = new C0364jn(applicationContext);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            this.c.warning("Invalid Error Environment (key,value) pair: (%s,%s).", str, str2);
            return;
        }
        this.c.info("Put error environment pair <%s, %s>", str, str2);
        Xh xh = this.b;
        synchronized (xh) {
            Y8 y8 = xh.c;
            y8.b.b(y8.f738a, str, str2);
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

    public final void c(String str) {
        if (this.b.f()) {
            return;
        }
        this.h.d.c();
        Lb lb = this.i;
        lb.f542a.removeCallbacks(lb.c, lb.b.b.b.getApiKey());
        this.b.e = true;
        Oi oi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = T9.f659a;
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        C0320i4 c0320i4 = new C0320i4("", str, 3, 0, publicLogger);
        Xh xh = this.b;
        oi.getClass();
        oi.a(Oi.a(c0320i4, xh), xh, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void clearAppEnvironment() {
        String str;
        this.c.info("Clear app environment", new Object[0]);
        Oi oi = this.h;
        Xh xh = this.b;
        oi.getClass();
        C0399l6 n2 = C0320i4.n();
        Rf rf = new Rf(xh.f823a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(xh.b);
        Y8 y8 = xh.c;
        synchronized (xh) {
            str = xh.f;
        }
        oi.a(new Nh(n2, false, 1, null, new Xh(rf, counterConfiguration, y8, str)));
    }

    public final void d(String str) {
        this.h.d.b();
        Lb lb = this.i;
        Lb.a(lb.f542a, lb.b, lb.c);
        Oi oi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = T9.f659a;
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        C0320i4 c0320i4 = new C0320i4("", str, 6400, 0, publicLogger);
        Xh xh = this.b;
        oi.getClass();
        oi.a(Oi.a(c0320i4, xh), xh, 1, null);
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
        Gf gf;
        Oi oi = this.h;
        Xh xh = this.b;
        oi.getClass();
        Kf kf = xh.d;
        synchronized (xh) {
            str = xh.f;
        }
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(xh.b.getApiKey());
        Set set = T9.f659a;
        JSONObject jSONObject = new JSONObject();
        if (kf != null && (gf = kf.f530a) != null) {
            try {
                jSONObject.put("preloadInfo", gf.c());
            } catch (Throwable unused) {
            }
        }
        String jSONObject2 = jSONObject.toString();
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        C0320i4 c0320i4 = new C0320i4(jSONObject2, "", 6144, 0, orCreatePublicLogger);
        c0320i4.c(str);
        oi.a(Oi.a(c0320i4, xh), xh, 1, null);
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
        Oi oi = this.h;
        Xh xh = this.b;
        oi.getClass();
        C0399l6 b = C0320i4.b(str, str2);
        Rf rf = new Rf(xh.f823a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(xh.b);
        Y8 y8 = xh.c;
        synchronized (xh) {
            str3 = xh.f;
        }
        oi.a(new Nh(b, false, 1, null, new Xh(rf, counterConfiguration, y8, str3)));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAdRevenue(AdRevenue adRevenue) {
        reportAdRevenue(adRevenue, false);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAnr(Map<Thread, StackTraceElement[]> map) {
        StackTraceElement[] stackTraceElementArr;
        C0161c0 c0161c0 = new C0161c0(new C0187d0(this, map));
        Ia ia = new Ia();
        N6 n6 = C0696x4.l().f1134a;
        Thread a2 = c0161c0.a();
        Map map2 = null;
        try {
            stackTraceElementArr = c0161c0.b();
            if (stackTraceElementArr == null) {
                try {
                    stackTraceElementArr = a2.getStackTrace();
                } catch (SecurityException unused) {
                }
            }
        } catch (SecurityException unused2) {
            stackTraceElementArr = null;
        }
        C0740yn c0740yn = (C0740yn) ia.apply(a2, stackTraceElementArr);
        ArrayList arrayList = new ArrayList();
        TreeMap treeMap = new TreeMap(new Dn());
        try {
            map2 = c0161c0.c();
        } catch (SecurityException unused3) {
        }
        if (map2 != null) {
            treeMap.putAll(map2);
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            Thread thread = (Thread) entry.getKey();
            if (thread != a2 && thread != null) {
                arrayList.add((C0740yn) ia.apply(thread, (StackTraceElement[]) entry.getValue()));
            }
        }
        a(new U(c0740yn, arrayList, n6.a()));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportECommerce(ECommerceEvent eCommerceEvent) {
        String str;
        this.c.info("E-commerce event received: " + eCommerceEvent.getPublicDescription(), new Object[0]);
        Oi oi = this.h;
        Xh xh = this.b;
        oi.getClass();
        for (Vi vi : eCommerceEvent.toProto()) {
            C0320i4 c0320i4 = new C0320i4(LoggerStorage.getOrCreatePublicLogger(xh.b.getApiKey()));
            EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
            c0320i4.d = 41000;
            c0320i4.b = c0320i4.e(Base64Utils.compressBase64(MessageNano.toByteArray((MessageNano) vi.f697a)));
            c0320i4.g = vi.b.getBytesTruncated();
            Rf rf = new Rf(xh.f823a);
            CounterConfiguration counterConfiguration = new CounterConfiguration(xh.b);
            Y8 y8 = xh.c;
            synchronized (xh) {
                str = xh.f;
            }
            oi.a(new Nh(c0320i4, false, 1, null, new Xh(rf, counterConfiguration, y8, str)));
        }
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, Throwable th) {
        Vg vg = new Vg(str, a(th));
        Oi oi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.e.fromModel(vg));
        PublicLogger publicLogger = this.c;
        Set set = T9.f659a;
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        C0320i4 c0320i4 = new C0320i4(byteArray, str, 5892, publicLogger);
        Xh xh = this.b;
        oi.getClass();
        oi.a(Oi.a(c0320i4, xh), xh, 1, null);
        this.c.info("Error received: %s", WrapUtils.wrapToTag(str));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str) {
        this.c.info("Event received: " + WrapUtils.wrapToTag(str), new Object[0]);
        Oi oi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = T9.f659a;
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        C0320i4 c0320i4 = new C0320i4("", str, 1, 0, publicLogger);
        Xh xh = this.b;
        oi.getClass();
        oi.a(Oi.a(c0320i4, xh), xh, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportRevenue(Revenue revenue) {
        String str;
        C0257fj c0257fj = U2.f671a;
        c0257fj.getClass();
        so a2 = c0257fj.a(revenue);
        if (a2.f1067a) {
            Oi oi = this.h;
            C0283gj c0283gj = new C0283gj(revenue, this.c);
            Xh xh = this.b;
            oi.getClass();
            C0320i4 a3 = C0320i4.a(LoggerStorage.getOrCreatePublicLogger(xh.b.getApiKey()), c0283gj);
            Rf rf = new Rf(xh.f823a);
            CounterConfiguration counterConfiguration = new CounterConfiguration(xh.b);
            Y8 y8 = xh.c;
            synchronized (xh) {
                str = xh.f;
            }
            oi.a(new Nh(a3, false, 1, null, new Xh(rf, counterConfiguration, y8, str)));
            this.c.info("Revenue received for productID: " + WrapUtils.wrapToTag(revenue.productID) + " of quantity: " + WrapUtils.wrapToTag(revenue.quantity) + " with price (in micros): " + revenue.priceMicros + " " + revenue.currency, new Object[0]);
            return;
        }
        this.c.warning("Passed revenue is not valid. Reason: " + a2.b, new Object[0]);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUnhandledException(Throwable th) {
        Sn a2 = Vn.a(th, new U(null, null, this.j.a()), null, (String) this.k.b.a(), (Boolean) this.k.c.a());
        Oi oi = this.h;
        oi.a(oi.a(a2, this.b));
        this.c.info("Unhandled exception received: " + a2, new Object[0]);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUserProfile(UserProfile userProfile) {
        so a2;
        String str;
        C0262fo c0262fo = new C0262fo(C0262fo.c);
        for (UserProfileUpdate<? extends InterfaceC0288go> userProfileUpdate : userProfile.getUserProfileUpdates()) {
            InterfaceC0288go userProfileUpdatePatcher = userProfileUpdate.getUserProfileUpdatePatcher();
            ((Rd) userProfileUpdatePatcher).e = this.c;
            userProfileUpdatePatcher.a(c0262fo);
        }
        C0391ko c0391ko = new C0391ko();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c0262fo.f860a.size(); i++) {
            SparseArray sparseArray = c0262fo.f860a;
            for (C0314ho c0314ho : ((HashMap) sparseArray.get(sparseArray.keyAt(i))).values()) {
                arrayList.add(c0314ho);
            }
        }
        c0391ko.f944a = (C0314ho[]) arrayList.toArray(new C0314ho[arrayList.size()]);
        if (o.a(c0391ko).f1067a) {
            Oi oi = this.h;
            Xh xh = this.b;
            oi.getClass();
            C0399l6 a3 = C0320i4.a(c0391ko);
            Rf rf = new Rf(xh.f823a);
            CounterConfiguration counterConfiguration = new CounterConfiguration(xh.b);
            Y8 y8 = xh.c;
            synchronized (xh) {
                str = xh.f;
            }
            oi.a(new Nh(a3, false, 1, null, new Xh(rf, counterConfiguration, y8, str)));
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
        Oi oi = this.h;
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        PublicLogger publicLogger = this.c;
        Set set = T9.f659a;
        C0320i4 c0320i4 = new C0320i4("", "", 256, 0, publicLogger);
        Xh xh = this.b;
        oi.getClass();
        oi.a(Oi.a(c0320i4, xh), xh, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setDataSendingEnabled(boolean z) {
        this.b.b.setDataSendingEnabled(z);
        this.c.info("Updated data sending enabled: %s", Boolean.valueOf(z));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void setSessionExtra(String str, byte[] bArr) {
        Oi oi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = T9.f659a;
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        C0320i4 c0320i4 = new C0320i4("", null, 8193, 0, publicLogger);
        if (bArr == null) {
            bArr = new byte[0];
        }
        c0320i4.p = Collections.singletonMap(str, bArr);
        Xh xh = this.b;
        oi.getClass();
        oi.a(Oi.a(c0320i4, xh), xh, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setUserProfileID(String str) {
        String str2;
        Oi oi = this.h;
        Xh xh = this.b;
        oi.getClass();
        C0320i4 c0320i4 = new C0320i4(LoggerStorage.getOrCreatePublicLogger(xh.b.getApiKey()));
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        c0320i4.d = 40962;
        c0320i4.c(str);
        c0320i4.b = c0320i4.e(str);
        Rf rf = new Rf(xh.f823a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(xh.b);
        Y8 y8 = xh.c;
        synchronized (xh) {
            str2 = xh.f;
        }
        oi.a(new Nh(c0320i4, false, 1, null, new Xh(rf, counterConfiguration, y8, str2)));
        this.c.info("Set user profile ID: " + WrapUtils.wrapToTag(str), new Object[0]);
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportAdRevenue(AdRevenue adRevenue, boolean z) {
        String str;
        Oi oi = this.h;
        D d = new D(adRevenue, z, this.m, this.c);
        Xh xh = this.b;
        oi.getClass();
        C0320i4 a2 = C0320i4.a(LoggerStorage.getOrCreatePublicLogger(xh.b.getApiKey()), d);
        Rf rf = new Rf(xh.f823a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(xh.b);
        Y8 y8 = xh.c;
        synchronized (xh) {
            str = xh.f;
        }
        oi.a(new Nh(a2, false, 1, null, new Xh(rf, counterConfiguration, y8, str)));
        this.c.info("AdRevenue Received: AdRevenue{adRevenue=" + adRevenue.adRevenue + ", currency='" + WrapUtils.wrapToTag(adRevenue.currency.getCurrencyCode()) + "', adType=" + WrapUtils.wrapToTag(adRevenue.adType) + ", adNetwork='" + WrapUtils.wrapToTag(adRevenue.adNetwork) + "', adUnitId='" + WrapUtils.wrapToTag(adRevenue.adUnitId) + "', adUnitName='" + WrapUtils.wrapToTag(adRevenue.adUnitName) + "', adPlacementId='" + WrapUtils.wrapToTag(adRevenue.adPlacementId) + "', adPlacementName='" + WrapUtils.wrapToTag(adRevenue.adPlacementName) + "', precision='" + WrapUtils.wrapToTag(adRevenue.precision) + "', payload=" + Db.b(adRevenue.payload) + ", autoCollected=" + z + "}", new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0120ab
    public final void b(String str, String str2) {
        this.c.info("Event received: " + WrapUtils.wrapToTag(str) + ". With value: " + WrapUtils.wrapToTag(str2), new Object[0]);
        Oi oi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = T9.f659a;
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        C0320i4 c0320i4 = new C0320i4(str2, str, 1, 0, publicLogger);
        c0320i4.l = J9.JS;
        Xh xh = this.b;
        oi.getClass();
        oi.a(Oi.a(c0320i4, xh), xh, 1, null);
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
        Oi oi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = T9.f659a;
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        C0320i4 c0320i4 = new C0320i4(str2, str, 1, 0, publicLogger);
        Xh xh = this.b;
        oi.getClass();
        oi.a(Oi.a(c0320i4, xh), xh, 1, null);
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
        } else if (th instanceof T1) {
            stackTraceElementArr = th.getStackTrace();
            th2 = null;
        } else {
            th2 = th;
            stackTraceElementArr = null;
        }
        return Vn.a(th2, new U(null, null, this.j.a()), stackTraceElementArr != null ? Arrays.asList(stackTraceElementArr) : null, (String) this.k.b.a(), (Boolean) this.k.c.a());
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2, Throwable th) {
        Q6 q6 = new Q6(new Vg(str2, a(th)), str);
        Oi oi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.f.fromModel(q6));
        PublicLogger publicLogger = this.c;
        Set set = T9.f659a;
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        C0320i4 c0320i4 = new C0320i4(byteArray, str2, 5896, publicLogger);
        Xh xh = this.b;
        oi.getClass();
        oi.a(Oi.a(c0320i4, xh), xh, 1, null);
        this.c.info("Error received: id: %s, message: %s", WrapUtils.wrapToTag(str), WrapUtils.wrapToTag(str2));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0120ab
    public final boolean b() {
        return this.b.f();
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        Sn a2 = this.l.a(pluginErrorDetails);
        Oi oi = this.h;
        In in = a2.f652a;
        String str = in != null ? (String) WrapUtils.getOrDefault(in.f503a, "") : "";
        byte[] byteArray = MessageNano.toByteArray(this.d.fromModel(a2));
        PublicLogger publicLogger = this.c;
        Set set = T9.f659a;
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        C0320i4 c0320i4 = new C0320i4(byteArray, str, 5891, publicLogger);
        Xh xh = this.b;
        oi.getClass();
        oi.a(Oi.a(c0320i4, xh), xh, 1, null);
        this.c.info("Crash from plugin received: %s", WrapUtils.wrapToTag(pluginErrorDetails.getMessage()));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, Map<String, Object> map) {
        Oi oi = this.h;
        PublicLogger publicLogger = this.c;
        Set set = T9.f659a;
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        oi.a(new C0320i4("", str, 1, 0, publicLogger), this.b, 1, map);
        this.c.info("Event received: " + WrapUtils.wrapToTag(str) + ". With value: " + WrapUtils.wrapToTag(map == null ? null : map.toString()), new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0479ob, io.appmetrica.analytics.impl.InterfaceC0553rb
    public final void a(Sn sn) {
        Oi oi = this.h;
        Nh a2 = oi.a(sn, this.b);
        Xh xh = a2.e;
        Ul ul = oi.e;
        if (ul != null) {
            xh.b.setUuid(((Tl) ul).g());
        } else {
            xh.getClass();
        }
        oi.c.b(a2);
        this.c.info("Unhandled exception received: " + sn, new Object[0]);
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        Sn sn;
        Ze ze = this.l;
        if (pluginErrorDetails != null) {
            sn = ze.a(pluginErrorDetails);
        } else {
            ze.getClass();
            sn = null;
        }
        Vg vg = new Vg(str, sn);
        Oi oi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.e.fromModel(vg));
        PublicLogger publicLogger = this.c;
        Set set = T9.f659a;
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        C0320i4 c0320i4 = new C0320i4(byteArray, str, 5896, publicLogger);
        Xh xh = this.b;
        oi.getClass();
        oi.a(Oi.a(c0320i4, xh), xh, 1, null);
        this.c.info("Error from plugin received: %s", WrapUtils.wrapToTag(str));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportEvent(ModuleEvent moduleEvent) {
        J9 j9;
        if (n.contains(Integer.valueOf(moduleEvent.getType()))) {
            return;
        }
        PublicLogger publicLogger = this.c;
        Set set = T9.f659a;
        String value = moduleEvent.getValue();
        String name = moduleEvent.getName();
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        C0320i4 c0320i4 = new C0320i4(value, name, 8192, moduleEvent.getType(), publicLogger);
        int i = Z8.f755a[moduleEvent.getCategory().ordinal()];
        if (i == 1) {
            j9 = J9.NATIVE;
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            j9 = J9.SYSTEM;
        }
        c0320i4.l = j9;
        c0320i4.c = Db.b(moduleEvent.getEnvironment());
        if (moduleEvent.getExtras() != null) {
            c0320i4.p = moduleEvent.getExtras();
        }
        this.h.a(c0320i4, this.b, moduleEvent.getServiceDataReporterType(), moduleEvent.getAttributes());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0479ob, io.appmetrica.analytics.impl.InterfaceC0212e0
    public final void a(U u) {
        C0109a0 c0109a0 = new C0109a0(u, (String) this.k.b.a(), (Boolean) this.k.c.a());
        Oi oi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.g.fromModel(c0109a0));
        PublicLogger publicLogger = this.c;
        Set set = T9.f659a;
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        C0320i4 c0320i4 = new C0320i4(byteArray, "", 5968, publicLogger);
        Xh xh = this.b;
        oi.getClass();
        oi.a(Oi.a(c0320i4, xh), xh, 1, null);
        PublicLogger publicLogger2 = this.c;
        StringBuilder sb = new StringBuilder("ANR was reported ");
        C0740yn c0740yn = u.f668a;
        publicLogger2.info(sb.append(c0740yn != null ? "Thread[name=" + c0740yn.f1166a + ",tid={" + c0740yn.c + ", priority=" + c0740yn.b + ", group=" + c0740yn.d + "}] at " + CollectionsKt.joinToString$default(c0740yn.f, "\n", null, null, 0, null, null, 62, null) : null).toString(), new Object[0]);
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        Sn sn;
        Ze ze = this.l;
        if (pluginErrorDetails != null) {
            sn = ze.a(pluginErrorDetails);
        } else {
            ze.getClass();
            sn = null;
        }
        Q6 q6 = new Q6(new Vg(str2, sn), str);
        Oi oi = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.f.fromModel(q6));
        PublicLogger publicLogger = this.c;
        Set set = T9.f659a;
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        C0320i4 c0320i4 = new C0320i4(byteArray, str2, 5896, publicLogger);
        Xh xh = this.b;
        oi.getClass();
        oi.a(Oi.a(c0320i4, xh), xh, 1, null);
        this.c.info("Error with identifier: %s from plugin received: %s", str, WrapUtils.wrapToTag(str2));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0120ab
    public final void a(String str) {
        Oi oi = this.h;
        C0399l6 a2 = C0399l6.a(str);
        Xh xh = this.b;
        oi.getClass();
        oi.a(Oi.a(a2, xh), xh, 1, null);
    }
}
