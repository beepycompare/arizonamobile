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
    public final V4 f733a;
    public final C0674vo b;
    public final Si c;
    public final C0546r0 d;
    public InterfaceC0568rm e;
    public final Ak f;

    public Qi(C0546r0 c0546r0, C0674vo c0674vo, V4 v4, Ak ak) {
        this(c0546r0, c0674vo, v4, ak, new Si(c0546r0, ak));
    }

    public final void a(Ph ph) {
        Zh zh = ph.e;
        InterfaceC0568rm interfaceC0568rm = this.e;
        if (interfaceC0568rm != null) {
            zh.b.setUuid(((C0543qm) interfaceC0568rm).g());
        } else {
            zh.getClass();
        }
        this.c.a(ph);
    }

    public final void b(String str) {
        C0175cg c0175cg = this.f733a.f849a;
        synchronized (c0175cg) {
            c0175cg.f927a.put("PROCESS_CFG_INSTALL_REFERRER_SOURCE", str);
        }
    }

    public Qi(C0546r0 c0546r0, C0674vo c0674vo, V4 v4, Ak ak, Si si) {
        this.d = c0546r0;
        this.f733a = v4;
        this.b = c0674vo;
        this.f = ak;
        this.c = si;
    }

    public final void a(C0543qm c0543qm) {
        this.e = c0543qm;
        this.f733a.b.setUuid(c0543qm.g());
    }

    public final void a(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        if (Oo.a(bool)) {
            this.f733a.b.setLocationTracking(bool.booleanValue());
        }
        if (Oo.a(bool2)) {
            this.f733a.b.setDataSendingEnabled(bool2.booleanValue());
        }
        if (Oo.a(bool3)) {
            this.f733a.b.setAdvIdentifiersTracking(bool3.booleanValue(), bool4.booleanValue());
        }
        C0242f6 a2 = C0242f6.a();
        V4 v4 = this.f733a;
        a(a(a2, v4), v4, 1, (Map) null);
    }

    public final void a(C0242f6 c0242f6, Zh zh, int i, Map map) {
        String str;
        Db db = Db.EVENT_TYPE_UNDEFINED;
        this.d.b();
        if (!Oo.a(map)) {
            c0242f6.setValue(Ib.b(map));
            a(c0242f6, zh);
        }
        C0175cg c0175cg = new C0175cg(zh.f849a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(zh.b);
        W8 w8 = zh.c;
        synchronized (zh) {
            str = zh.f;
        }
        a(new Ph(c0242f6, false, i, null, new Zh(c0175cg, counterConfiguration, w8, str)));
    }

    public static C0242f6 a(C0242f6 c0242f6, Zh zh) {
        if (Q9.f727a.contains(Integer.valueOf(c0242f6.d))) {
            c0242f6.c = zh.d();
        }
        return c0242f6;
    }

    public final void a(List list) {
        C0175cg c0175cg = this.f733a.f849a;
        synchronized (c0175cg) {
            c0175cg.f927a.put("PROCESS_CFG_CUSTOM_HOSTS", Oo.a((Collection) list) ? null : new JSONArray((Collection) list).toString());
        }
    }

    public final void a(HashMap hashMap) {
        C0175cg c0175cg = this.f733a.f849a;
        synchronized (c0175cg) {
            c0175cg.f927a.put("PROCESS_CFG_CLIDS", Ib.b(hashMap));
        }
    }

    public final void a(String str) {
        C0175cg c0175cg = this.f733a.f849a;
        synchronized (c0175cg) {
            c0175cg.f927a.put("PROCESS_CFG_DISTRIBUTION_REFERRER", str);
        }
    }

    public final Ph a(C0622to c0622to, Zh zh) {
        String str;
        String str2;
        this.d.b();
        C0674vo c0674vo = this.b;
        c0674vo.getClass();
        C0363jo c0363jo = c0622to.f1220a;
        if (c0363jo == null) {
            str = "";
        } else {
            str = (String) WrapUtils.getOrDefault(c0363jo.f1055a, "");
        }
        byte[] fromModel = c0674vo.f1252a.fromModel(c0622to);
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(zh.b.getApiKey());
        Set set = Q9.f727a;
        Db db = Db.EVENT_TYPE_UNDEFINED;
        C0189d4 c0189d4 = new C0189d4(fromModel, str, 5891, orCreatePublicLogger);
        c0189d4.c = zh.d();
        HashMap hashMap = c0189d4.q;
        C0175cg c0175cg = new C0175cg(zh.f849a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(zh.b);
        W8 w8 = zh.c;
        synchronized (zh) {
            str2 = zh.f;
        }
        return new Ph(c0189d4, true, 1, hashMap, new Zh(c0175cg, counterConfiguration, w8, str2));
    }
}
