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
public final class C0703xi {

    /* renamed from: a  reason: collision with root package name */
    public final G4 f1201a;
    public final Tn b;
    public final C0753zi c;
    public final C0486p0 d;
    public Ql e;
    public final Zj f;

    public C0703xi(C0486p0 c0486p0, Tn tn, G4 g4, Zj zj) {
        this(c0486p0, tn, g4, zj, new C0753zi(c0486p0, zj));
    }

    public final void a(C0677wh c0677wh) {
        Gh gh = c0677wh.e;
        Ql ql = this.e;
        if (ql != null) {
            gh.b.setUuid(((Pl) ql).g());
        } else {
            gh.getClass();
        }
        this.c.a(c0677wh);
    }

    public final void b(String str) {
        Cf cf = this.f1201a.f518a;
        synchronized (cf) {
            cf.f432a.put("PROCESS_CFG_INSTALL_REFERRER_SOURCE", str);
        }
    }

    public C0703xi(C0486p0 c0486p0, Tn tn, G4 g4, Zj zj, C0753zi c0753zi) {
        this.d = c0486p0;
        this.f1201a = g4;
        this.b = tn;
        this.f = zj;
        this.c = c0753zi;
    }

    public final void a(Pl pl) {
        this.e = pl;
        this.f1201a.b.setUuid(pl.g());
    }

    public final void a(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        if (mo.a(bool)) {
            this.f1201a.b.setLocationTracking(bool.booleanValue());
        }
        if (mo.a(bool2)) {
            this.f1201a.b.setDataSendingEnabled(bool2.booleanValue());
        }
        if (mo.a(bool3)) {
            this.f1201a.b.setAdvIdentifiersTracking(bool3.booleanValue(), bool4.booleanValue());
        }
        Q5 a2 = Q5.a();
        G4 g4 = this.f1201a;
        a(a(a2, g4), g4, 1, (Map) null);
    }

    public final void a(Q5 q5, Gh gh, int i, Map map) {
        String str;
        EnumC0165cb enumC0165cb = EnumC0165cb.EVENT_TYPE_UNDEFINED;
        this.d.b();
        if (!mo.a(map)) {
            q5.setValue(AbstractC0294hb.b(map));
            a(q5, gh);
        }
        Cf cf = new Cf(gh.f518a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(gh.b);
        E8 e8 = gh.c;
        synchronized (gh) {
            str = gh.f;
        }
        a(new C0677wh(q5, false, i, null, new Gh(cf, counterConfiguration, e8, str)));
    }

    public static Q5 a(Q5 q5, Gh gh) {
        if (AbstractC0694x9.f1197a.contains(Integer.valueOf(q5.d))) {
            q5.c = gh.d();
        }
        return q5;
    }

    public final void a(List list) {
        Cf cf = this.f1201a.f518a;
        synchronized (cf) {
            cf.f432a.put("PROCESS_CFG_CUSTOM_HOSTS", mo.a((Collection) list) ? null : new JSONArray((Collection) list).toString());
        }
    }

    public final void a(HashMap hashMap) {
        Cf cf = this.f1201a.f518a;
        synchronized (cf) {
            cf.f432a.put("PROCESS_CFG_CLIDS", AbstractC0294hb.b(hashMap));
        }
    }

    public final void a(String str) {
        Cf cf = this.f1201a.f518a;
        synchronized (cf) {
            cf.f432a.put("PROCESS_CFG_DISTRIBUTION_REFERRER", str);
        }
    }

    public final C0677wh a(Rn rn, Gh gh) {
        String str;
        String str2;
        this.d.b();
        Tn tn = this.b;
        tn.getClass();
        Hn hn = rn.f666a;
        if (hn == null) {
            str = "";
        } else {
            str = (String) WrapUtils.getOrDefault(hn.f514a, "");
        }
        byte[] fromModel = tn.f699a.fromModel(rn);
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(gh.b.getApiKey());
        Set set = AbstractC0694x9.f1197a;
        EnumC0165cb enumC0165cb = EnumC0165cb.EVENT_TYPE_UNDEFINED;
        N3 n3 = new N3(fromModel, str, 5891, orCreatePublicLogger);
        n3.c = gh.d();
        HashMap hashMap = n3.q;
        Cf cf = new Cf(gh.f518a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(gh.b);
        E8 e8 = gh.c;
        synchronized (gh) {
            str2 = gh.f;
        }
        return new C0677wh(n3, true, 1, hashMap, new Gh(cf, counterConfiguration, e8, str2));
    }
}
