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
public abstract class V2 implements Ya {
    public static final HashSet n = new HashSet(Arrays.asList(1, 13));
    public static final T2 o = new T2();

    /* renamed from: a  reason: collision with root package name */
    protected final Context f680a;
    protected final Sh b;
    protected final PublicLogger c;
    protected final On d;
    protected final Rg e;
    protected final Q6 f;
    public final C0142b0 g;
    protected final Ji h;
    public Jb i;
    public final M6 j;
    public final C0306ha k;
    public final Xe l;
    public final C0242en m;

    public V2(Context context, Ji ji, Sh sh, C0306ha c0306ha, M6 m6, On on, Rg rg, Q6 q6, C0142b0 c0142b0, Xe xe) {
        Context applicationContext = context.getApplicationContext();
        this.f680a = applicationContext;
        this.h = ji;
        this.b = sh;
        this.k = c0306ha;
        this.d = on;
        this.e = rg;
        this.f = q6;
        this.g = c0142b0;
        this.l = xe;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(sh.b().getApiKey());
        this.c = orCreatePublicLogger;
        if (AbstractC0622u3.a(sh.b().isLogEnabled())) {
            orCreatePublicLogger.setEnabled(true);
        }
        this.j = m6;
        this.m = new C0242en(applicationContext);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            this.c.warning("Invalid Error Environment (key,value) pair: (%s,%s).", str, str2);
            return;
        }
        this.c.info("Put error environment pair <%s, %s>", str, str2);
        Sh sh = this.b;
        synchronized (sh) {
            W8 w8 = sh.c;
            w8.b.b(w8.f698a, str, str2);
        }
    }

    public final void b(Map<String, String> map) {
        if (io.a((Map) map)) {
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
        Jb jb = this.i;
        jb.f504a.removeCallbacks(jb.c, jb.b.b.b.getApiKey());
        this.b.e = true;
        Ji ji = this.h;
        PublicLogger publicLogger = this.c;
        Set set = R9.f620a;
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        C0325i4 c0325i4 = new C0325i4("", str, 3, 0, publicLogger);
        Sh sh = this.b;
        ji.getClass();
        ji.a(Ji.a(c0325i4, sh), sh, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void clearAppEnvironment() {
        String str;
        this.c.info("Clear app environment", new Object[0]);
        Ji ji = this.h;
        Sh sh = this.b;
        ji.getClass();
        C0401l6 n2 = C0325i4.n();
        Pf pf = new Pf(sh.f811a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(sh.b);
        W8 w8 = sh.c;
        synchronized (sh) {
            str = sh.f;
        }
        ji.a(new Ih(n2, false, 1, null, new Sh(pf, counterConfiguration, w8, str)));
    }

    public final void d(String str) {
        this.h.d.b();
        Jb jb = this.i;
        Jb.a(jb.f504a, jb.b, jb.c);
        Ji ji = this.h;
        PublicLogger publicLogger = this.c;
        Set set = R9.f620a;
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        C0325i4 c0325i4 = new C0325i4("", str, 6400, 0, publicLogger);
        Sh sh = this.b;
        ji.getClass();
        ji.a(Ji.a(c0325i4, sh), sh, 1, null);
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
        Ef ef;
        Ji ji = this.h;
        Sh sh = this.b;
        ji.getClass();
        If r2 = sh.d;
        synchronized (sh) {
            str = sh.f;
        }
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(sh.b.getApiKey());
        Set set = R9.f620a;
        JSONObject jSONObject = new JSONObject();
        if (r2 != null && (ef = r2.f490a) != null) {
            try {
                jSONObject.put("preloadInfo", ef.c());
            } catch (Throwable unused) {
            }
        }
        String jSONObject2 = jSONObject.toString();
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        C0325i4 c0325i4 = new C0325i4(jSONObject2, "", 6144, 0, orCreatePublicLogger);
        c0325i4.c(str);
        ji.a(Ji.a(c0325i4, sh), sh, 1, null);
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
        Ji ji = this.h;
        Sh sh = this.b;
        ji.getClass();
        C0401l6 b = C0325i4.b(str, str2);
        Pf pf = new Pf(sh.f811a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(sh.b);
        W8 w8 = sh.c;
        synchronized (sh) {
            str3 = sh.f;
        }
        ji.a(new Ih(b, false, 1, null, new Sh(pf, counterConfiguration, w8, str3)));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAdRevenue(AdRevenue adRevenue) {
        reportAdRevenue(adRevenue, false);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAnr(Map<Thread, StackTraceElement[]> map) {
        StackTraceElement[] stackTraceElementArr;
        C0168c0 c0168c0 = new C0168c0(new C0194d0(this, map));
        Ga ga = new Ga();
        M6 m6 = C0698x4.l().f1129a;
        Thread a2 = c0168c0.a();
        Map map2 = null;
        try {
            stackTraceElementArr = c0168c0.b();
            if (stackTraceElementArr == null) {
                try {
                    stackTraceElementArr = a2.getStackTrace();
                } catch (SecurityException unused) {
                }
            }
        } catch (SecurityException unused2) {
            stackTraceElementArr = null;
        }
        C0617tn c0617tn = (C0617tn) ga.apply(a2, stackTraceElementArr);
        ArrayList arrayList = new ArrayList();
        TreeMap treeMap = new TreeMap(new C0742yn());
        try {
            map2 = c0168c0.c();
        } catch (SecurityException unused3) {
        }
        if (map2 != null) {
            treeMap.putAll(map2);
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            Thread thread = (Thread) entry.getKey();
            if (thread != a2 && thread != null) {
                arrayList.add((C0617tn) ga.apply(thread, (StackTraceElement[]) entry.getValue()));
            }
        }
        a(new U(c0617tn, arrayList, m6.b()));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportECommerce(ECommerceEvent eCommerceEvent) {
        String str;
        this.c.info("E-commerce event received: " + eCommerceEvent.getPublicDescription(), new Object[0]);
        Ji ji = this.h;
        Sh sh = this.b;
        ji.getClass();
        for (Qi qi : eCommerceEvent.toProto()) {
            C0325i4 c0325i4 = new C0325i4(LoggerStorage.getOrCreatePublicLogger(sh.b.getApiKey()));
            EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
            c0325i4.d = 41000;
            c0325i4.b = c0325i4.e(Base64Utils.compressBase64(MessageNano.toByteArray((MessageNano) qi.f612a)));
            c0325i4.g = qi.b.getBytesTruncated();
            Pf pf = new Pf(sh.f811a);
            CounterConfiguration counterConfiguration = new CounterConfiguration(sh.b);
            W8 w8 = sh.c;
            synchronized (sh) {
                str = sh.f;
            }
            ji.a(new Ih(c0325i4, false, 1, null, new Sh(pf, counterConfiguration, w8, str)));
        }
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, Throwable th) {
        Qg qg = new Qg(str, a(th));
        Ji ji = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.e.fromModel(qg));
        PublicLogger publicLogger = this.c;
        Set set = R9.f620a;
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        C0325i4 c0325i4 = new C0325i4(byteArray, str, 5892, publicLogger);
        Sh sh = this.b;
        ji.getClass();
        ji.a(Ji.a(c0325i4, sh), sh, 1, null);
        this.c.info("Error received: %s", WrapUtils.wrapToTag(str));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str) {
        this.c.info("Event received: " + WrapUtils.wrapToTag(str), new Object[0]);
        Ji ji = this.h;
        PublicLogger publicLogger = this.c;
        Set set = R9.f620a;
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        C0325i4 c0325i4 = new C0325i4("", str, 1, 0, publicLogger);
        Sh sh = this.b;
        ji.getClass();
        ji.a(Ji.a(c0325i4, sh), sh, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportRevenue(Revenue revenue) {
        String str;
        C0135aj c0135aj = U2.f663a;
        c0135aj.getClass();
        no a2 = c0135aj.a(revenue);
        if (a2.f975a) {
            Ji ji = this.h;
            C0161bj c0161bj = new C0161bj(revenue, this.c);
            Sh sh = this.b;
            ji.getClass();
            C0325i4 a3 = C0325i4.a(LoggerStorage.getOrCreatePublicLogger(sh.b.getApiKey()), c0161bj);
            Pf pf = new Pf(sh.f811a);
            CounterConfiguration counterConfiguration = new CounterConfiguration(sh.b);
            W8 w8 = sh.c;
            synchronized (sh) {
                str = sh.f;
            }
            ji.a(new Ih(a3, false, 1, null, new Sh(pf, counterConfiguration, w8, str)));
            this.c.info("Revenue received for productID: " + WrapUtils.wrapToTag(revenue.productID) + " of quantity: " + WrapUtils.wrapToTag(revenue.quantity) + " with price (in micros): " + revenue.priceMicros + " " + revenue.currency, new Object[0]);
            return;
        }
        this.c.warning("Passed revenue is not valid. Reason: " + a2.b, new Object[0]);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUnhandledException(Throwable th) {
        Nn a2 = Qn.a(th, new U(null, null, this.j.b()), null, (String) this.k.b.a(), (Boolean) this.k.c.a());
        Ji ji = this.h;
        ji.a(ji.a(a2, this.b));
        this.c.info("Unhandled exception received: " + a2, new Object[0]);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUserProfile(UserProfile userProfile) {
        no a2;
        String str;
        C0140ao c0140ao = new C0140ao(C0140ao.c);
        for (UserProfileUpdate<? extends InterfaceC0166bo> userProfileUpdate : userProfile.getUserProfileUpdates()) {
            InterfaceC0166bo userProfileUpdatePatcher = userProfileUpdate.getUserProfileUpdatePatcher();
            ((Pd) userProfileUpdatePatcher).e = this.c;
            userProfileUpdatePatcher.a(c0140ao);
        }
        C0269fo c0269fo = new C0269fo();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c0140ao.f773a.size(); i++) {
            SparseArray sparseArray = c0140ao.f773a;
            for (C0192co c0192co : ((HashMap) sparseArray.get(sparseArray.keyAt(i))).values()) {
                arrayList.add(c0192co);
            }
        }
        c0269fo.f853a = (C0192co[]) arrayList.toArray(new C0192co[arrayList.size()]);
        if (o.a(c0269fo).f975a) {
            Ji ji = this.h;
            Sh sh = this.b;
            ji.getClass();
            C0401l6 a3 = C0325i4.a(c0269fo);
            Pf pf = new Pf(sh.f811a);
            CounterConfiguration counterConfiguration = new CounterConfiguration(sh.b);
            W8 w8 = sh.c;
            synchronized (sh) {
                str = sh.f;
            }
            ji.a(new Ih(a3, false, 1, null, new Sh(pf, counterConfiguration, w8, str)));
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
        Ji ji = this.h;
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        PublicLogger publicLogger = this.c;
        Set set = R9.f620a;
        C0325i4 c0325i4 = new C0325i4("", "", 256, 0, publicLogger);
        Sh sh = this.b;
        ji.getClass();
        ji.a(Ji.a(c0325i4, sh), sh, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setDataSendingEnabled(boolean z) {
        this.b.b.setDataSendingEnabled(z);
        this.c.info("Updated data sending enabled: %s", Boolean.valueOf(z));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void setSessionExtra(String str, byte[] bArr) {
        Ji ji = this.h;
        PublicLogger publicLogger = this.c;
        Set set = R9.f620a;
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        C0325i4 c0325i4 = new C0325i4("", null, 8193, 0, publicLogger);
        if (bArr == null) {
            bArr = new byte[0];
        }
        c0325i4.p = Collections.singletonMap(str, bArr);
        Sh sh = this.b;
        ji.getClass();
        ji.a(Ji.a(c0325i4, sh), sh, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setUserProfileID(String str) {
        String str2;
        Ji ji = this.h;
        Sh sh = this.b;
        ji.getClass();
        C0325i4 c0325i4 = new C0325i4(LoggerStorage.getOrCreatePublicLogger(sh.b.getApiKey()));
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        c0325i4.d = 40962;
        c0325i4.c(str);
        c0325i4.b = c0325i4.e(str);
        Pf pf = new Pf(sh.f811a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(sh.b);
        W8 w8 = sh.c;
        synchronized (sh) {
            str2 = sh.f;
        }
        ji.a(new Ih(c0325i4, false, 1, null, new Sh(pf, counterConfiguration, w8, str2)));
        this.c.info("Set user profile ID: " + WrapUtils.wrapToTag(str), new Object[0]);
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportAdRevenue(AdRevenue adRevenue, boolean z) {
        String str;
        Ji ji = this.h;
        D d = new D(adRevenue, z, this.m, this.c);
        Sh sh = this.b;
        ji.getClass();
        C0325i4 a2 = C0325i4.a(LoggerStorage.getOrCreatePublicLogger(sh.b.getApiKey()), d);
        Pf pf = new Pf(sh.f811a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(sh.b);
        W8 w8 = sh.c;
        synchronized (sh) {
            str = sh.f;
        }
        ji.a(new Ih(a2, false, 1, null, new Sh(pf, counterConfiguration, w8, str)));
        this.c.info("AdRevenue Received: AdRevenue{adRevenue=" + adRevenue.adRevenue + ", currency='" + WrapUtils.wrapToTag(adRevenue.currency.getCurrencyCode()) + "', adType=" + WrapUtils.wrapToTag(adRevenue.adType) + ", adNetwork='" + WrapUtils.wrapToTag(adRevenue.adNetwork) + "', adUnitId='" + WrapUtils.wrapToTag(adRevenue.adUnitId) + "', adUnitName='" + WrapUtils.wrapToTag(adRevenue.adUnitName) + "', adPlacementId='" + WrapUtils.wrapToTag(adRevenue.adPlacementId) + "', adPlacementName='" + WrapUtils.wrapToTag(adRevenue.adPlacementName) + "', precision='" + WrapUtils.wrapToTag(adRevenue.precision) + "', payload=" + Bb.b(adRevenue.payload) + ", autoCollected=" + z + "}", new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.Ya
    public final void b(String str, String str2) {
        this.c.info("Event received: " + WrapUtils.wrapToTag(str) + ". With value: " + WrapUtils.wrapToTag(str2), new Object[0]);
        Ji ji = this.h;
        PublicLogger publicLogger = this.c;
        Set set = R9.f620a;
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        C0325i4 c0325i4 = new C0325i4(str2, str, 1, 0, publicLogger);
        c0325i4.l = H9.JS;
        Sh sh = this.b;
        ji.getClass();
        ji.a(Ji.a(c0325i4, sh), sh, 1, null);
    }

    public final void a(Map<String, String> map) {
        if (io.a((Map) map)) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            putAppEnvironmentValue(entry.getKey(), entry.getValue());
        }
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, String str2) {
        this.c.info("Event received: " + WrapUtils.wrapToTag(str) + ". With value: " + WrapUtils.wrapToTag(str2), new Object[0]);
        Ji ji = this.h;
        PublicLogger publicLogger = this.c;
        Set set = R9.f620a;
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        C0325i4 c0325i4 = new C0325i4(str2, str, 1, 0, publicLogger);
        Sh sh = this.b;
        ji.getClass();
        ji.a(Ji.a(c0325i4, sh), sh, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2) {
        reportError(str, str2, (Throwable) null);
    }

    public final Nn a(Throwable th) {
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
        return Qn.a(th2, new U(null, null, this.j.b()), stackTraceElementArr != null ? Arrays.asList(stackTraceElementArr) : null, (String) this.k.b.a(), (Boolean) this.k.c.a());
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2, Throwable th) {
        P6 p6 = new P6(new Qg(str2, a(th)), str);
        Ji ji = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.f.fromModel(p6));
        PublicLogger publicLogger = this.c;
        Set set = R9.f620a;
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        C0325i4 c0325i4 = new C0325i4(byteArray, str2, 5896, publicLogger);
        Sh sh = this.b;
        ji.getClass();
        ji.a(Ji.a(c0325i4, sh), sh, 1, null);
        this.c.info("Error received: id: %s, message: %s", WrapUtils.wrapToTag(str), WrapUtils.wrapToTag(str2));
    }

    @Override // io.appmetrica.analytics.impl.Ya
    public final boolean b() {
        return this.b.f();
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        Nn a2 = this.l.a(pluginErrorDetails);
        Ji ji = this.h;
        Dn dn = a2.f568a;
        String str = dn != null ? (String) WrapUtils.getOrDefault(dn.f403a, "") : "";
        byte[] byteArray = MessageNano.toByteArray(this.d.fromModel(a2));
        PublicLogger publicLogger = this.c;
        Set set = R9.f620a;
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        C0325i4 c0325i4 = new C0325i4(byteArray, str, 5891, publicLogger);
        Sh sh = this.b;
        ji.getClass();
        ji.a(Ji.a(c0325i4, sh), sh, 1, null);
        this.c.info("Crash from plugin received: %s", WrapUtils.wrapToTag(pluginErrorDetails.getMessage()));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, Map<String, Object> map) {
        Ji ji = this.h;
        PublicLogger publicLogger = this.c;
        Set set = R9.f620a;
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        ji.a(new C0325i4("", str, 1, 0, publicLogger), this.b, 1, map);
        this.c.info("Event received: " + WrapUtils.wrapToTag(str) + ". With value: " + WrapUtils.wrapToTag(map == null ? null : map.toString()), new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0431mb, io.appmetrica.analytics.impl.InterfaceC0506pb
    public final void a(Nn nn) {
        Ji ji = this.h;
        Ih a2 = ji.a(nn, this.b);
        Sh sh = a2.e;
        Pl pl = ji.e;
        if (pl != null) {
            sh.b.setUuid(((Ol) pl).g());
        } else {
            sh.getClass();
        }
        ji.c.b(a2);
        this.c.info("Unhandled exception received: " + nn, new Object[0]);
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        Nn nn;
        Xe xe = this.l;
        if (pluginErrorDetails != null) {
            nn = xe.a(pluginErrorDetails);
        } else {
            xe.getClass();
            nn = null;
        }
        Qg qg = new Qg(str, nn);
        Ji ji = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.e.fromModel(qg));
        PublicLogger publicLogger = this.c;
        Set set = R9.f620a;
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        C0325i4 c0325i4 = new C0325i4(byteArray, str, 5896, publicLogger);
        Sh sh = this.b;
        ji.getClass();
        ji.a(Ji.a(c0325i4, sh), sh, 1, null);
        this.c.info("Error from plugin received: %s", WrapUtils.wrapToTag(str));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportEvent(ModuleEvent moduleEvent) {
        H9 h9;
        if (n.contains(Integer.valueOf(moduleEvent.getType()))) {
            return;
        }
        PublicLogger publicLogger = this.c;
        Set set = R9.f620a;
        String value = moduleEvent.getValue();
        String name = moduleEvent.getName();
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        C0325i4 c0325i4 = new C0325i4(value, name, 8192, moduleEvent.getType(), publicLogger);
        int i = X8.f715a[moduleEvent.getCategory().ordinal()];
        if (i == 1) {
            h9 = H9.NATIVE;
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            h9 = H9.SYSTEM;
        }
        c0325i4.l = h9;
        c0325i4.c = Bb.b(moduleEvent.getEnvironment());
        if (moduleEvent.getExtras() != null) {
            c0325i4.p = moduleEvent.getExtras();
        }
        this.h.a(c0325i4, this.b, moduleEvent.getServiceDataReporterType(), moduleEvent.getAttributes());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0431mb, io.appmetrica.analytics.impl.InterfaceC0219e0
    public final void a(U u) {
        C0116a0 c0116a0 = new C0116a0(u, (String) this.k.b.a(), (Boolean) this.k.c.a());
        Ji ji = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.g.fromModel(c0116a0));
        PublicLogger publicLogger = this.c;
        Set set = R9.f620a;
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        C0325i4 c0325i4 = new C0325i4(byteArray, "", 5968, publicLogger);
        Sh sh = this.b;
        ji.getClass();
        ji.a(Ji.a(c0325i4, sh), sh, 1, null);
        PublicLogger publicLogger2 = this.c;
        StringBuilder sb = new StringBuilder("ANR was reported ");
        C0617tn c0617tn = u.f660a;
        publicLogger2.info(sb.append(c0617tn != null ? "Thread[name=" + c0617tn.f1072a + ",tid={" + c0617tn.c + ", priority=" + c0617tn.b + ", group=" + c0617tn.d + "}] at " + CollectionsKt.joinToString$default(c0617tn.f, "\n", null, null, 0, null, null, 62, null) : null).toString(), new Object[0]);
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        Nn nn;
        Xe xe = this.l;
        if (pluginErrorDetails != null) {
            nn = xe.a(pluginErrorDetails);
        } else {
            xe.getClass();
            nn = null;
        }
        P6 p6 = new P6(new Qg(str2, nn), str);
        Ji ji = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.f.fromModel(p6));
        PublicLogger publicLogger = this.c;
        Set set = R9.f620a;
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        C0325i4 c0325i4 = new C0325i4(byteArray, str2, 5896, publicLogger);
        Sh sh = this.b;
        ji.getClass();
        ji.a(Ji.a(c0325i4, sh), sh, 1, null);
        this.c.info("Error with identifier: %s from plugin received: %s", str, WrapUtils.wrapToTag(str2));
    }

    @Override // io.appmetrica.analytics.impl.Ya
    public final void a(String str) {
        Ji ji = this.h;
        C0401l6 a2 = C0401l6.a(str);
        Sh sh = this.b;
        ji.getClass();
        ji.a(Ji.a(a2, sh), sh, 1, null);
    }
}
