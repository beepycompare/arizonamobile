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
    public final V4 f739a;
    public final C0667vo b;
    public final Si c;
    public final C0539r0 d;
    public InterfaceC0561rm e;
    public final Ak f;

    public Qi(C0539r0 c0539r0, C0667vo c0667vo, V4 v4, Ak ak) {
        this(c0539r0, c0667vo, v4, ak, new Si(c0539r0, ak));
    }

    public final void a(Ph ph) {
        Zh zh = ph.e;
        InterfaceC0561rm interfaceC0561rm = this.e;
        if (interfaceC0561rm != null) {
            zh.b.setUuid(((C0536qm) interfaceC0561rm).g());
        } else {
            zh.getClass();
        }
        this.c.a(ph);
    }

    public final void b(String str) {
        C0168cg c0168cg = this.f739a.f855a;
        synchronized (c0168cg) {
            c0168cg.f933a.put("PROCESS_CFG_INSTALL_REFERRER_SOURCE", str);
        }
    }

    public Qi(C0539r0 c0539r0, C0667vo c0667vo, V4 v4, Ak ak, Si si) {
        this.d = c0539r0;
        this.f739a = v4;
        this.b = c0667vo;
        this.f = ak;
        this.c = si;
    }

    public final void a(C0536qm c0536qm) {
        this.e = c0536qm;
        this.f739a.b.setUuid(c0536qm.g());
    }

    public final void a(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        if (Oo.a(bool)) {
            this.f739a.b.setLocationTracking(bool.booleanValue());
        }
        if (Oo.a(bool2)) {
            this.f739a.b.setDataSendingEnabled(bool2.booleanValue());
        }
        if (Oo.a(bool3)) {
            this.f739a.b.setAdvIdentifiersTracking(bool3.booleanValue(), bool4.booleanValue());
        }
        C0235f6 a2 = C0235f6.a();
        V4 v4 = this.f739a;
        a(a(a2, v4), v4, 1, (Map) null);
    }

    public final void a(C0235f6 c0235f6, Zh zh, int i, Map map) {
        String str;
        Db db = Db.EVENT_TYPE_UNDEFINED;
        this.d.b();
        if (!Oo.a(map)) {
            c0235f6.setValue(Ib.b(map));
            a(c0235f6, zh);
        }
        C0168cg c0168cg = new C0168cg(zh.f855a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(zh.b);
        W8 w8 = zh.c;
        synchronized (zh) {
            str = zh.f;
        }
        a(new Ph(c0235f6, false, i, null, new Zh(c0168cg, counterConfiguration, w8, str)));
    }

    public static C0235f6 a(C0235f6 c0235f6, Zh zh) {
        if (Q9.f733a.contains(Integer.valueOf(c0235f6.d))) {
            c0235f6.c = zh.d();
        }
        return c0235f6;
    }

    public final void a(List list) {
        C0168cg c0168cg = this.f739a.f855a;
        synchronized (c0168cg) {
            c0168cg.f933a.put("PROCESS_CFG_CUSTOM_HOSTS", Oo.a((Collection) list) ? null : new JSONArray((Collection) list).toString());
        }
    }

    public final void a(HashMap hashMap) {
        C0168cg c0168cg = this.f739a.f855a;
        synchronized (c0168cg) {
            c0168cg.f933a.put("PROCESS_CFG_CLIDS", Ib.b(hashMap));
        }
    }

    public final void a(String str) {
        C0168cg c0168cg = this.f739a.f855a;
        synchronized (c0168cg) {
            c0168cg.f933a.put("PROCESS_CFG_DISTRIBUTION_REFERRER", str);
        }
    }

    public final Ph a(C0615to c0615to, Zh zh) {
        String str;
        String str2;
        this.d.b();
        C0667vo c0667vo = this.b;
        c0667vo.getClass();
        C0356jo c0356jo = c0615to.f1226a;
        if (c0356jo == null) {
            str = "";
        } else {
            str = (String) WrapUtils.getOrDefault(c0356jo.f1061a, "");
        }
        byte[] fromModel = c0667vo.f1258a.fromModel(c0615to);
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(zh.b.getApiKey());
        Set set = Q9.f733a;
        Db db = Db.EVENT_TYPE_UNDEFINED;
        C0182d4 c0182d4 = new C0182d4(fromModel, str, 5891, orCreatePublicLogger);
        c0182d4.c = zh.d();
        HashMap hashMap = c0182d4.q;
        C0168cg c0168cg = new C0168cg(zh.f855a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(zh.b);
        W8 w8 = zh.c;
        synchronized (zh) {
            str2 = zh.f;
        }
        return new Ph(c0182d4, true, 1, hashMap, new Zh(c0168cg, counterConfiguration, w8, str2));
    }
}
