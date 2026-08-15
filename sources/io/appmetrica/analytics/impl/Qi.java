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
/* loaded from: classes5.dex */
public final class Qi {

    /* renamed from: a  reason: collision with root package name */
    public final V4 f736a;
    public final C0673vo b;
    public final Si c;
    public final C0545r0 d;
    public InterfaceC0567rm e;
    public final Ak f;

    public Qi(C0545r0 c0545r0, C0673vo c0673vo, V4 v4, Ak ak) {
        this(c0545r0, c0673vo, v4, ak, new Si(c0545r0, ak));
    }

    public final void a(Ph ph) {
        Zh zh = ph.e;
        InterfaceC0567rm interfaceC0567rm = this.e;
        if (interfaceC0567rm != null) {
            zh.b.setUuid(((C0542qm) interfaceC0567rm).g());
        } else {
            zh.getClass();
        }
        this.c.a(ph);
    }

    public final void b(String str) {
        C0174cg c0174cg = this.f736a.f852a;
        synchronized (c0174cg) {
            c0174cg.f930a.put("PROCESS_CFG_INSTALL_REFERRER_SOURCE", str);
        }
    }

    public Qi(C0545r0 c0545r0, C0673vo c0673vo, V4 v4, Ak ak, Si si) {
        this.d = c0545r0;
        this.f736a = v4;
        this.b = c0673vo;
        this.f = ak;
        this.c = si;
    }

    public final void a(C0542qm c0542qm) {
        this.e = c0542qm;
        this.f736a.b.setUuid(c0542qm.g());
    }

    public final void a(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        if (Oo.a(bool)) {
            this.f736a.b.setLocationTracking(bool.booleanValue());
        }
        if (Oo.a(bool2)) {
            this.f736a.b.setDataSendingEnabled(bool2.booleanValue());
        }
        if (Oo.a(bool3)) {
            this.f736a.b.setAdvIdentifiersTracking(bool3.booleanValue(), bool4.booleanValue());
        }
        C0241f6 a2 = C0241f6.a();
        V4 v4 = this.f736a;
        a(a(a2, v4), v4, 1, (Map) null);
    }

    public final void a(C0241f6 c0241f6, Zh zh, int i, Map map) {
        String str;
        Db db = Db.EVENT_TYPE_UNDEFINED;
        this.d.b();
        if (!Oo.a(map)) {
            c0241f6.setValue(Ib.b(map));
            a(c0241f6, zh);
        }
        C0174cg c0174cg = new C0174cg(zh.f852a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(zh.b);
        W8 w8 = zh.c;
        synchronized (zh) {
            str = zh.f;
        }
        a(new Ph(c0241f6, false, i, null, new Zh(c0174cg, counterConfiguration, w8, str)));
    }

    public static C0241f6 a(C0241f6 c0241f6, Zh zh) {
        if (Q9.f730a.contains(Integer.valueOf(c0241f6.d))) {
            c0241f6.c = zh.d();
        }
        return c0241f6;
    }

    public final void a(List list) {
        C0174cg c0174cg = this.f736a.f852a;
        synchronized (c0174cg) {
            c0174cg.f930a.put("PROCESS_CFG_CUSTOM_HOSTS", Oo.a((Collection) list) ? null : new JSONArray((Collection) list).toString());
        }
    }

    public final void a(HashMap hashMap) {
        C0174cg c0174cg = this.f736a.f852a;
        synchronized (c0174cg) {
            c0174cg.f930a.put("PROCESS_CFG_CLIDS", Ib.b(hashMap));
        }
    }

    public final void a(String str) {
        C0174cg c0174cg = this.f736a.f852a;
        synchronized (c0174cg) {
            c0174cg.f930a.put("PROCESS_CFG_DISTRIBUTION_REFERRER", str);
        }
    }

    public final Ph a(C0621to c0621to, Zh zh) {
        String str;
        String str2;
        this.d.b();
        C0673vo c0673vo = this.b;
        c0673vo.getClass();
        C0362jo c0362jo = c0621to.f1223a;
        if (c0362jo == null) {
            str = "";
        } else {
            str = (String) WrapUtils.getOrDefault(c0362jo.f1058a, "");
        }
        byte[] fromModel = c0673vo.f1255a.fromModel(c0621to);
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(zh.b.getApiKey());
        Set set = Q9.f730a;
        Db db = Db.EVENT_TYPE_UNDEFINED;
        C0188d4 c0188d4 = new C0188d4(fromModel, str, 5891, orCreatePublicLogger);
        c0188d4.c = zh.d();
        HashMap hashMap = c0188d4.q;
        C0174cg c0174cg = new C0174cg(zh.f852a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(zh.b);
        W8 w8 = zh.c;
        synchronized (zh) {
            str2 = zh.f;
        }
        return new Ph(c0188d4, true, 1, hashMap, new Zh(c0174cg, counterConfiguration, w8, str2));
    }
}
