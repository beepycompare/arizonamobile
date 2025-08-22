package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public final class Oi {

    /* renamed from: a  reason: collision with root package name */
    public final C0114a5 f591a;
    public final Un b;
    public final Qi c;
    public final C0418m0 d;
    public Ul e;
    public final C0463nk f;

    public Oi(C0418m0 c0418m0, Un un, C0114a5 c0114a5, C0463nk c0463nk) {
        this(c0418m0, un, c0114a5, c0463nk, new Qi(c0418m0, c0463nk));
    }

    public final void a(Nh nh) {
        Xh xh = nh.e;
        Ul ul = this.e;
        if (ul != null) {
            xh.b.setUuid(((Tl) ul).g());
        } else {
            xh.getClass();
        }
        this.c.a(nh);
    }

    public final void b(String str) {
        Rf rf = this.f591a.f823a;
        synchronized (rf) {
            rf.f635a.put("PROCESS_CFG_INSTALL_REFERRER_SOURCE", str);
        }
    }

    public Oi(C0418m0 c0418m0, Un un, C0114a5 c0114a5, C0463nk c0463nk, Qi qi) {
        this.d = c0418m0;
        this.f591a = c0114a5;
        this.b = un;
        this.f = c0463nk;
        this.c = qi;
    }

    public final void a(Tl tl) {
        this.e = tl;
        this.f591a.b.setUuid(tl.g());
    }

    public final void a(Boolean bool, Boolean bool2, Boolean bool3) {
        if (no.a(bool)) {
            this.f591a.b.setLocationTracking(bool.booleanValue());
        }
        if (no.a(bool2)) {
            this.f591a.b.setDataSendingEnabled(bool2.booleanValue());
        }
        if (no.a(bool3)) {
            this.f591a.b.setAdvIdentifiersTracking(bool3.booleanValue());
        }
        C0399l6 a2 = C0399l6.a();
        C0114a5 c0114a5 = this.f591a;
        a(a(a2, c0114a5), c0114a5, 1, null);
    }

    public final void a(C0399l6 c0399l6, Xh xh, int i, Map map) {
        String str;
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        this.d.b();
        if (!no.a(map)) {
            c0399l6.setValue(Db.b(map));
            a(c0399l6, xh);
        }
        Rf rf = new Rf(xh.f823a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(xh.b);
        Y8 y8 = xh.c;
        synchronized (xh) {
            str = xh.f;
        }
        a(new Nh(c0399l6, false, i, null, new Xh(rf, counterConfiguration, y8, str)));
    }

    public static C0399l6 a(C0399l6 c0399l6, Xh xh) {
        if (T9.f659a.contains(Integer.valueOf(c0399l6.d))) {
            c0399l6.c = xh.d();
        }
        return c0399l6;
    }

    public final void a(List list) {
        Rf rf = this.f591a.f823a;
        synchronized (rf) {
            rf.f635a.put("PROCESS_CFG_CUSTOM_HOSTS", no.a((Collection) list) ? null : new JSONArray((Collection) list).toString());
        }
    }

    public final void a(HashMap hashMap) {
        Rf rf = this.f591a.f823a;
        synchronized (rf) {
            rf.f635a.put("PROCESS_CFG_CLIDS", Db.b(hashMap));
        }
    }

    public final void a(String str) {
        Rf rf = this.f591a.f823a;
        synchronized (rf) {
            rf.f635a.put("PROCESS_CFG_DISTRIBUTION_REFERRER", str);
        }
    }

    public final Nh a(Sn sn, Xh xh) {
        String str;
        String str2;
        this.d.b();
        Un un = this.b;
        un.getClass();
        In in = sn.f652a;
        if (in == null) {
            str = "";
        } else {
            str = (String) WrapUtils.getOrDefault(in.f503a, "");
        }
        byte[] fromModel = un.f684a.fromModel(sn);
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(xh.b.getApiKey());
        Set set = T9.f659a;
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        C0320i4 c0320i4 = new C0320i4(fromModel, str, 5891, orCreatePublicLogger);
        c0320i4.c = xh.d();
        HashMap hashMap = c0320i4.q;
        Rf rf = new Rf(xh.f823a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(xh.b);
        Y8 y8 = xh.c;
        synchronized (xh) {
            str2 = xh.f;
        }
        return new Nh(c0320i4, true, 1, hashMap, new Xh(rf, counterConfiguration, y8, str2));
    }
}
