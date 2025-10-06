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
public abstract class Y2 implements InterfaceC0199db {
    public static final HashSet n = new HashSet(Arrays.asList(1, 13));
    public static final W2 o = new W2();

    /* renamed from: a  reason: collision with root package name */
    protected final Context f752a;
    protected final C0154bi b;
    protected final PublicLogger c;
    protected final Xn d;
    protected final C0127ah e;
    protected final U6 f;
    public final C0162c0 g;
    protected final Si h;
    public Ob i;
    public final Wf j;
    public final C0430ma k;
    public final C0203df l;
    public final C0469nn m;

    public Y2(Context context, Si si, C0154bi c0154bi, C0430ma c0430ma, Q6 q6, Xn xn, C0127ah c0127ah, U6 u6, C0162c0 c0162c0, C0203df c0203df) {
        Context applicationContext = context.getApplicationContext();
        this.f752a = applicationContext;
        this.h = si;
        this.b = c0154bi;
        this.k = c0430ma;
        this.d = xn;
        this.e = c0127ah;
        this.f = u6;
        this.g = c0162c0;
        this.l = c0203df;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(c0154bi.b().getApiKey());
        this.c = orCreatePublicLogger;
        if (AbstractC0700x3.a(c0154bi.b().isLogEnabled())) {
            orCreatePublicLogger.setEnabled(true);
        }
        this.j = q6;
        this.m = new C0469nn(applicationContext);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            this.c.warning("Invalid Error Environment (key,value) pair: (%s,%s).", str, str2);
            return;
        }
        this.c.info("Put error environment pair <%s, %s>", str, str2);
        C0154bi c0154bi = this.b;
        synchronized (c0154bi) {
            C0145b9 c0145b9 = c0154bi.c;
            c0145b9.b.b(c0145b9.f808a, str, str2);
        }
    }

    public final void b(Map<String, String> map) {
        if (ro.a((Map) map)) {
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
        Si si = this.h;
        C0154bi c0154bi = this.b;
        si.getClass();
        C0478o6 n2 = C0398l4.n();
        Vf vf = new Vf(c0154bi.f889a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(c0154bi.b);
        C0145b9 c0145b9 = c0154bi.c;
        synchronized (c0154bi) {
            str = c0154bi.f;
        }
        si.a(new Rh(n2, false, 1, null, new C0154bi(vf, counterConfiguration, c0145b9, str)));
    }

    public final void d(String str) {
        if (this.b.f()) {
            return;
        }
        this.h.d.c();
        Ob ob = this.i;
        ob.f609a.removeCallbacks(ob.c, ob.b.b.b.getApiKey());
        this.b.e = true;
        Si si = this.h;
        PublicLogger publicLogger = this.c;
        Set set = W9.f726a;
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        C0398l4 c0398l4 = new C0398l4("", str, 3, 0, publicLogger);
        C0154bi c0154bi = this.b;
        si.getClass();
        si.a(Si.a(c0398l4, c0154bi), c0154bi, 1, null);
    }

    public final void e(String str) {
        this.h.d.b();
        Ob ob = this.i;
        Ob.a(ob.f609a, ob.b, ob.c);
        Si si = this.h;
        PublicLogger publicLogger = this.c;
        Set set = W9.f726a;
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        C0398l4 c0398l4 = new C0398l4("", str, 6400, 0, publicLogger);
        C0154bi c0154bi = this.b;
        si.getClass();
        si.a(Si.a(c0398l4, c0154bi), c0154bi, 1, null);
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
        Kf kf;
        Si si = this.h;
        C0154bi c0154bi = this.b;
        si.getClass();
        Of of = c0154bi.d;
        synchronized (c0154bi) {
            str = c0154bi.f;
        }
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(c0154bi.b.getApiKey());
        Set set = W9.f726a;
        JSONObject jSONObject = new JSONObject();
        if (of != null && (kf = of.f611a) != null) {
            try {
                jSONObject.put("preloadInfo", kf.c());
            } catch (Throwable unused) {
            }
        }
        String jSONObject2 = jSONObject.toString();
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        C0398l4 c0398l4 = new C0398l4(jSONObject2, "", 6144, 0, orCreatePublicLogger);
        c0398l4.c(str);
        si.a(Si.a(c0398l4, c0154bi), c0154bi, 1, null);
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
        Si si = this.h;
        C0154bi c0154bi = this.b;
        si.getClass();
        C0478o6 b = C0398l4.b(str, str2);
        Vf vf = new Vf(c0154bi.f889a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(c0154bi.b);
        C0145b9 c0145b9 = c0154bi.c;
        synchronized (c0154bi) {
            str3 = c0154bi.f;
        }
        si.a(new Rh(b, false, 1, null, new C0154bi(vf, counterConfiguration, c0145b9, str3)));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAdRevenue(AdRevenue adRevenue) {
        reportAdRevenue(adRevenue, false);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAnr(Map<Thread, StackTraceElement[]> map) {
        StackTraceElement[] stackTraceElementArr;
        C0188d0 c0188d0 = new C0188d0(new C0213e0(this, map));
        La la = new La();
        Q6 q6 = A4.l().f344a;
        Thread a2 = c0188d0.a();
        Map map2 = null;
        try {
            stackTraceElementArr = c0188d0.b();
            if (stackTraceElementArr == null) {
                try {
                    stackTraceElementArr = a2.getStackTrace();
                } catch (SecurityException unused) {
                }
            }
        } catch (SecurityException unused2) {
            stackTraceElementArr = null;
        }
        Cn cn = (Cn) la.apply(a2, stackTraceElementArr);
        ArrayList arrayList = new ArrayList();
        TreeMap treeMap = new TreeMap(new Hn());
        try {
            map2 = c0188d0.c();
        } catch (SecurityException unused3) {
        }
        if (map2 != null) {
            treeMap.putAll(map2);
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            Thread thread = (Thread) entry.getKey();
            if (thread != a2 && thread != null) {
                arrayList.add((Cn) la.apply(thread, (StackTraceElement[]) entry.getValue()));
            }
        }
        a(new U(cn, arrayList, q6.a()));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportECommerce(ECommerceEvent eCommerceEvent) {
        String str;
        this.c.info("E-commerce event received: " + eCommerceEvent.getPublicDescription(), new Object[0]);
        Si si = this.h;
        C0154bi c0154bi = this.b;
        si.getClass();
        for (Zi zi : eCommerceEvent.toProto()) {
            C0398l4 c0398l4 = new C0398l4(LoggerStorage.getOrCreatePublicLogger(c0154bi.b.getApiKey()));
            Bb bb = Bb.EVENT_TYPE_UNDEFINED;
            c0398l4.d = 41000;
            c0398l4.b = c0398l4.e(Base64Utils.compressBase64(MessageNano.toByteArray((MessageNano) zi.f777a)));
            c0398l4.g = zi.b.getBytesTruncated();
            Vf vf = new Vf(c0154bi.f889a);
            CounterConfiguration counterConfiguration = new CounterConfiguration(c0154bi.b);
            C0145b9 c0145b9 = c0154bi.c;
            synchronized (c0154bi) {
                str = c0154bi.f;
            }
            si.a(new Rh(c0398l4, false, 1, null, new C0154bi(vf, counterConfiguration, c0145b9, str)));
        }
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, Throwable th) {
        Zg zg = new Zg(str, a(th));
        Si si = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.e.fromModel(zg));
        PublicLogger publicLogger = this.c;
        Set set = W9.f726a;
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        C0398l4 c0398l4 = new C0398l4(byteArray, str, 5892, publicLogger);
        C0154bi c0154bi = this.b;
        si.getClass();
        si.a(Si.a(c0398l4, c0154bi), c0154bi, 1, null);
        this.c.info("Error received: %s", WrapUtils.wrapToTag(str));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str) {
        this.c.info("Event received: " + WrapUtils.wrapToTag(str), new Object[0]);
        Si si = this.h;
        PublicLogger publicLogger = this.c;
        Set set = W9.f726a;
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        C0398l4 c0398l4 = new C0398l4("", str, 1, 0, publicLogger);
        C0154bi c0154bi = this.b;
        si.getClass();
        si.a(Si.a(c0398l4, c0154bi), c0154bi, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportRevenue(Revenue revenue) {
        String str;
        C0361jj c0361jj = X2.f736a;
        c0361jj.getClass();
        wo a2 = c0361jj.a(revenue);
        if (a2.f1146a) {
            Si si = this.h;
            C0387kj c0387kj = new C0387kj(revenue, this.c);
            C0154bi c0154bi = this.b;
            si.getClass();
            C0398l4 a3 = C0398l4.a(LoggerStorage.getOrCreatePublicLogger(c0154bi.b.getApiKey()), c0387kj);
            Vf vf = new Vf(c0154bi.f889a);
            CounterConfiguration counterConfiguration = new CounterConfiguration(c0154bi.b);
            C0145b9 c0145b9 = c0154bi.c;
            synchronized (c0154bi) {
                str = c0154bi.f;
            }
            si.a(new Rh(a3, false, 1, null, new C0154bi(vf, counterConfiguration, c0145b9, str)));
            this.c.info("Revenue received for productID: " + WrapUtils.wrapToTag(revenue.productID) + " of quantity: " + WrapUtils.wrapToTag(revenue.quantity) + " with price (in micros): " + revenue.priceMicros + " " + revenue.currency, new Object[0]);
            return;
        }
        this.c.warning("Passed revenue is not valid. Reason: " + a2.b, new Object[0]);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUnhandledException(Throwable th) {
        Wn a2 = Zn.a(th, new U(null, null, this.j.a()), null, (String) this.k.b.a(), (Boolean) this.k.c.a());
        Si si = this.h;
        si.a(si.a(a2, this.b));
        this.c.info("Unhandled exception received: " + a2, new Object[0]);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUserProfile(UserProfile userProfile) {
        wo a2;
        String str;
        C0366jo c0366jo = new C0366jo(C0366jo.c);
        for (UserProfileUpdate<? extends InterfaceC0392ko> userProfileUpdate : userProfile.getUserProfileUpdates()) {
            InterfaceC0392ko userProfileUpdatePatcher = userProfileUpdate.getUserProfileUpdatePatcher();
            ((Vd) userProfileUpdatePatcher).e = this.c;
            userProfileUpdatePatcher.a(c0366jo);
        }
        C0496oo c0496oo = new C0496oo();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c0366jo.f944a.size(); i++) {
            SparseArray sparseArray = c0366jo.f944a;
            for (C0418lo c0418lo : ((HashMap) sparseArray.get(sparseArray.keyAt(i))).values()) {
                arrayList.add(c0418lo);
            }
        }
        c0496oo.f1027a = (C0418lo[]) arrayList.toArray(new C0418lo[arrayList.size()]);
        if (o.a(c0496oo).f1146a) {
            Si si = this.h;
            C0154bi c0154bi = this.b;
            si.getClass();
            C0478o6 a3 = C0398l4.a(c0496oo);
            Vf vf = new Vf(c0154bi.f889a);
            CounterConfiguration counterConfiguration = new CounterConfiguration(c0154bi.b);
            C0145b9 c0145b9 = c0154bi.c;
            synchronized (c0154bi) {
                str = c0154bi.f;
            }
            si.a(new Rh(a3, false, 1, null, new C0154bi(vf, counterConfiguration, c0145b9, str)));
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
        Si si = this.h;
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        PublicLogger publicLogger = this.c;
        Set set = W9.f726a;
        C0398l4 c0398l4 = new C0398l4("", "", 256, 0, publicLogger);
        C0154bi c0154bi = this.b;
        si.getClass();
        si.a(Si.a(c0398l4, c0154bi), c0154bi, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setDataSendingEnabled(boolean z) {
        this.b.b.setDataSendingEnabled(z);
        this.c.info("Updated data sending enabled: %s", Boolean.valueOf(z));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void setSessionExtra(String str, byte[] bArr) {
        Si si = this.h;
        PublicLogger publicLogger = this.c;
        Set set = W9.f726a;
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        C0398l4 c0398l4 = new C0398l4("", null, 8193, 0, publicLogger);
        if (bArr == null) {
            bArr = new byte[0];
        }
        c0398l4.p = Collections.singletonMap(str, bArr);
        C0154bi c0154bi = this.b;
        si.getClass();
        si.a(Si.a(c0398l4, c0154bi), c0154bi, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setUserProfileID(String str) {
        String str2;
        Si si = this.h;
        C0154bi c0154bi = this.b;
        si.getClass();
        C0398l4 c0398l4 = new C0398l4(LoggerStorage.getOrCreatePublicLogger(c0154bi.b.getApiKey()));
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        c0398l4.d = 40962;
        c0398l4.c(str);
        c0398l4.b = c0398l4.e(str);
        Vf vf = new Vf(c0154bi.f889a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(c0154bi.b);
        C0145b9 c0145b9 = c0154bi.c;
        synchronized (c0154bi) {
            str2 = c0154bi.f;
        }
        si.a(new Rh(c0398l4, false, 1, null, new C0154bi(vf, counterConfiguration, c0145b9, str2)));
        this.c.info("Set user profile ID: " + WrapUtils.wrapToTag(str), new Object[0]);
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportAdRevenue(AdRevenue adRevenue, boolean z) {
        String str;
        Si si = this.h;
        D d = new D(adRevenue, z, this.m, this.c);
        C0154bi c0154bi = this.b;
        si.getClass();
        C0398l4 a2 = C0398l4.a(LoggerStorage.getOrCreatePublicLogger(c0154bi.b.getApiKey()), d);
        Vf vf = new Vf(c0154bi.f889a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(c0154bi.b);
        C0145b9 c0145b9 = c0154bi.c;
        synchronized (c0154bi) {
            str = c0154bi.f;
        }
        si.a(new Rh(a2, false, 1, null, new C0154bi(vf, counterConfiguration, c0145b9, str)));
        this.c.info("AdRevenue Received: AdRevenue{adRevenue=" + adRevenue.adRevenue + ", currency='" + WrapUtils.wrapToTag(adRevenue.currency.getCurrencyCode()) + "', adType=" + WrapUtils.wrapToTag(adRevenue.adType) + ", adNetwork='" + WrapUtils.wrapToTag(adRevenue.adNetwork) + "', adUnitId='" + WrapUtils.wrapToTag(adRevenue.adUnitId) + "', adUnitName='" + WrapUtils.wrapToTag(adRevenue.adUnitName) + "', adPlacementId='" + WrapUtils.wrapToTag(adRevenue.adPlacementId) + "', adPlacementName='" + WrapUtils.wrapToTag(adRevenue.adPlacementName) + "', precision='" + WrapUtils.wrapToTag(adRevenue.precision) + "', payload=" + Gb.b(adRevenue.payload) + ", autoCollected=" + z + "}", new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0199db
    public final void b(String str, String str2) {
        this.c.info("Event received: " + WrapUtils.wrapToTag(str) + ". With value: " + WrapUtils.wrapToTag(str2), new Object[0]);
        Si si = this.h;
        PublicLogger publicLogger = this.c;
        Set set = W9.f726a;
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        C0398l4 c0398l4 = new C0398l4(str2, str, 1, 0, publicLogger);
        c0398l4.l = M9.JS;
        C0154bi c0154bi = this.b;
        si.getClass();
        si.a(Si.a(c0398l4, c0154bi), c0154bi, 1, null);
    }

    public final void a(Map<String, String> map) {
        if (ro.a((Map) map)) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            putAppEnvironmentValue(entry.getKey(), entry.getValue());
        }
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, String str2) {
        this.c.info("Event received: " + WrapUtils.wrapToTag(str) + ". With value: " + WrapUtils.wrapToTag(str2), new Object[0]);
        Si si = this.h;
        PublicLogger publicLogger = this.c;
        Set set = W9.f726a;
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        C0398l4 c0398l4 = new C0398l4(str2, str, 1, 0, publicLogger);
        C0154bi c0154bi = this.b;
        si.getClass();
        si.a(Si.a(c0398l4, c0154bi), c0154bi, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2) {
        reportError(str, str2, (Throwable) null);
    }

    public final Wn a(Throwable th) {
        Throwable th2;
        StackTraceElement[] stackTraceElementArr;
        if (th == null) {
            stackTraceElementArr = null;
            th2 = null;
        } else if (th instanceof V1) {
            stackTraceElementArr = th.getStackTrace();
            th2 = null;
        } else {
            th2 = th;
            stackTraceElementArr = null;
        }
        return Zn.a(th2, new U(null, null, this.j.a()), stackTraceElementArr != null ? Arrays.asList(stackTraceElementArr) : null, (String) this.k.b.a(), (Boolean) this.k.c.a());
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2, Throwable th) {
        T6 t6 = new T6(new Zg(str2, a(th)), str);
        Si si = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.f.fromModel(t6));
        PublicLogger publicLogger = this.c;
        Set set = W9.f726a;
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        C0398l4 c0398l4 = new C0398l4(byteArray, str2, 5896, publicLogger);
        C0154bi c0154bi = this.b;
        si.getClass();
        si.a(Si.a(c0398l4, c0154bi), c0154bi, 1, null);
        this.c.info("Error received: id: %s, message: %s", WrapUtils.wrapToTag(str), WrapUtils.wrapToTag(str2));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0199db
    public final void b(String str) {
        Si si = this.h;
        C0478o6 a2 = C0478o6.a(str);
        C0154bi c0154bi = this.b;
        si.getClass();
        si.a(Si.a(a2, c0154bi), c0154bi, 1, null);
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        Wn a2 = this.l.a(pluginErrorDetails);
        Si si = this.h;
        Mn mn = a2.f732a;
        String str = mn != null ? (String) WrapUtils.getOrDefault(mn.f584a, "") : "";
        byte[] byteArray = MessageNano.toByteArray(this.d.fromModel(a2));
        PublicLogger publicLogger = this.c;
        Set set = W9.f726a;
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        C0398l4 c0398l4 = new C0398l4(byteArray, str, 5891, publicLogger);
        C0154bi c0154bi = this.b;
        si.getClass();
        si.a(Si.a(c0398l4, c0154bi), c0154bi, 1, null);
        this.c.info("Crash from plugin received: %s", WrapUtils.wrapToTag(pluginErrorDetails.getMessage()));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0199db
    public final boolean b() {
        return this.b.f();
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, Map<String, Object> map) {
        Si si = this.h;
        PublicLogger publicLogger = this.c;
        Set set = W9.f726a;
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        si.a(new C0398l4("", str, 1, 0, publicLogger), this.b, 1, map);
        this.c.info("Event received: " + WrapUtils.wrapToTag(str) + ". With value: " + WrapUtils.wrapToTag(map == null ? null : map.toString()), new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0558rb, io.appmetrica.analytics.impl.InterfaceC0633ub
    public final void a(Wn wn) {
        Si si = this.h;
        Rh a2 = si.a(wn, this.b);
        C0154bi c0154bi = a2.e;
        Yl yl = si.e;
        if (yl != null) {
            c0154bi.b.setUuid(((Xl) yl).g());
        } else {
            c0154bi.getClass();
        }
        si.c.b(a2);
        this.c.info("Unhandled exception received: " + wn, new Object[0]);
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        Wn wn;
        C0203df c0203df = this.l;
        if (pluginErrorDetails != null) {
            wn = c0203df.a(pluginErrorDetails);
        } else {
            c0203df.getClass();
            wn = null;
        }
        Zg zg = new Zg(str, wn);
        Si si = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.e.fromModel(zg));
        PublicLogger publicLogger = this.c;
        Set set = W9.f726a;
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        C0398l4 c0398l4 = new C0398l4(byteArray, str, 5896, publicLogger);
        C0154bi c0154bi = this.b;
        si.getClass();
        si.a(Si.a(c0398l4, c0154bi), c0154bi, 1, null);
        this.c.info("Error from plugin received: %s", WrapUtils.wrapToTag(str));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportEvent(ModuleEvent moduleEvent) {
        M9 m9;
        if (n.contains(Integer.valueOf(moduleEvent.getType()))) {
            return;
        }
        PublicLogger publicLogger = this.c;
        Set set = W9.f726a;
        String value = moduleEvent.getValue();
        String name = moduleEvent.getName();
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        C0398l4 c0398l4 = new C0398l4(value, name, 8192, moduleEvent.getType(), publicLogger);
        int i = AbstractC0171c9.f823a[moduleEvent.getCategory().ordinal()];
        if (i == 1) {
            m9 = M9.NATIVE;
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            m9 = M9.SYSTEM;
        }
        c0398l4.l = m9;
        c0398l4.c = Gb.b(moduleEvent.getEnvironment());
        if (moduleEvent.getExtras() != null) {
            c0398l4.p = moduleEvent.getExtras();
        }
        this.h.a(c0398l4, this.b, moduleEvent.getServiceDataReporterType(), moduleEvent.getAttributes());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0558rb, io.appmetrica.analytics.impl.InterfaceC0239f0
    public final void a(U u) {
        C0136b0 c0136b0 = new C0136b0(u, (String) this.k.b.a(), (Boolean) this.k.c.a());
        Si si = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.g.fromModel(c0136b0));
        PublicLogger publicLogger = this.c;
        Set set = W9.f726a;
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        C0398l4 c0398l4 = new C0398l4(byteArray, "", 5968, publicLogger);
        C0154bi c0154bi = this.b;
        si.getClass();
        si.a(Si.a(c0398l4, c0154bi), c0154bi, 1, null);
        PublicLogger publicLogger2 = this.c;
        StringBuilder sb = new StringBuilder("ANR was reported ");
        Cn cn = u.f691a;
        publicLogger2.info(sb.append(cn != null ? "Thread[name=" + cn.f397a + ",tid={" + cn.c + ", priority=" + cn.b + ", group=" + cn.d + "}] at " + CollectionsKt.joinToString$default(cn.f, "\n", null, null, 0, null, null, 62, null) : null).toString(), new Object[0]);
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        Wn wn;
        C0203df c0203df = this.l;
        if (pluginErrorDetails != null) {
            wn = c0203df.a(pluginErrorDetails);
        } else {
            c0203df.getClass();
            wn = null;
        }
        T6 t6 = new T6(new Zg(str2, wn), str);
        Si si = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.f.fromModel(t6));
        PublicLogger publicLogger = this.c;
        Set set = W9.f726a;
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        C0398l4 c0398l4 = new C0398l4(byteArray, str2, 5896, publicLogger);
        C0154bi c0154bi = this.b;
        si.getClass();
        si.a(Si.a(c0398l4, c0154bi), c0154bi, 1, null);
        this.c.info("Error with identifier: %s from plugin received: %s", str, WrapUtils.wrapToTag(str2));
    }
}
