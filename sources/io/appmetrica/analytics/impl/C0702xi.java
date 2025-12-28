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
/* renamed from: io.appmetrica.analytics.impl.xi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0702xi {

    /* renamed from: a  reason: collision with root package name */
    public final G4 f1299a;
    public final Tn b;
    public final C0752zi c;
    public final C0485p0 d;
    public Ql e;
    public final Zj f;

    public C0702xi(C0485p0 c0485p0, Tn tn, G4 g4, Zj zj) {
        this(c0485p0, tn, g4, zj, new C0752zi(c0485p0, zj));
    }

    public final void a(C0676wh c0676wh) {
        Gh gh = c0676wh.e;
        Ql ql = this.e;
        if (ql != null) {
            gh.b.setUuid(((Pl) ql).g());
        } else {
            gh.getClass();
        }
        this.c.a(c0676wh);
    }

    public final void b(String str) {
        Cf cf = this.f1299a.f616a;
        synchronized (cf) {
            cf.f530a.put("PROCESS_CFG_INSTALL_REFERRER_SOURCE", str);
        }
    }

    public C0702xi(C0485p0 c0485p0, Tn tn, G4 g4, Zj zj, C0752zi c0752zi) {
        this.d = c0485p0;
        this.f1299a = g4;
        this.b = tn;
        this.f = zj;
        this.c = c0752zi;
    }

    public final void a(Pl pl) {
        this.e = pl;
        this.f1299a.b.setUuid(pl.g());
    }

    public final void a(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        if (mo.a(bool)) {
            this.f1299a.b.setLocationTracking(bool.booleanValue());
        }
        if (mo.a(bool2)) {
            this.f1299a.b.setDataSendingEnabled(bool2.booleanValue());
        }
        if (mo.a(bool3)) {
            this.f1299a.b.setAdvIdentifiersTracking(bool3.booleanValue(), bool4.booleanValue());
        }
        Q5 a2 = Q5.a();
        G4 g4 = this.f1299a;
        a(a(a2, g4), g4, 1, (Map) null);
    }

    public final void a(Q5 q5, Gh gh, int i, Map map) {
        String str;
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        this.d.b();
        if (!mo.a(map)) {
            q5.setValue(AbstractC0293hb.b(map));
            a(q5, gh);
        }
        Cf cf = new Cf(gh.f616a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(gh.b);
        E8 e8 = gh.c;
        synchronized (gh) {
            str = gh.f;
        }
        a(new C0676wh(q5, false, i, null, new Gh(cf, counterConfiguration, e8, str)));
    }

    public static Q5 a(Q5 q5, Gh gh) {
        if (AbstractC0693x9.f1295a.contains(Integer.valueOf(q5.d))) {
            q5.c = gh.d();
        }
        return q5;
    }

    public final void a(List list) {
        Cf cf = this.f1299a.f616a;
        synchronized (cf) {
            cf.f530a.put("PROCESS_CFG_CUSTOM_HOSTS", mo.a((Collection) list) ? null : new JSONArray((Collection) list).toString());
        }
    }

    public final void a(HashMap hashMap) {
        Cf cf = this.f1299a.f616a;
        synchronized (cf) {
            cf.f530a.put("PROCESS_CFG_CLIDS", AbstractC0293hb.b(hashMap));
        }
    }

    public final void a(String str) {
        Cf cf = this.f1299a.f616a;
        synchronized (cf) {
            cf.f530a.put("PROCESS_CFG_DISTRIBUTION_REFERRER", str);
        }
    }

    public final C0676wh a(Rn rn, Gh gh) {
        String str;
        String str2;
        this.d.b();
        Tn tn = this.b;
        tn.getClass();
        Hn hn = rn.f764a;
        if (hn == null) {
            str = "";
        } else {
            str = (String) WrapUtils.getOrDefault(hn.f612a, "");
        }
        byte[] fromModel = tn.f797a.fromModel(rn);
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(gh.b.getApiKey());
        Set set = AbstractC0693x9.f1295a;
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        N3 n3 = new N3(fromModel, str, 5891, orCreatePublicLogger);
        n3.c = gh.d();
        HashMap hashMap = n3.q;
        Cf cf = new Cf(gh.f616a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(gh.b);
        E8 e8 = gh.c;
        synchronized (gh) {
            str2 = gh.f;
        }
        return new C0676wh(n3, true, 1, hashMap, new Gh(cf, counterConfiguration, e8, str2));
    }
}
