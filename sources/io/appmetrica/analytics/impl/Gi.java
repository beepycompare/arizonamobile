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
public final class Gi {

    /* renamed from: a  reason: collision with root package name */
    public final C0129a5 f446a;
    public final Mn b;
    public final Ii c;
    public final C0426m0 d;
    public Ml e;
    public final C0272fk f;

    public Gi(C0426m0 c0426m0, Mn mn, C0129a5 c0129a5, C0272fk c0272fk) {
        this(c0426m0, mn, c0129a5, c0272fk, new Ii(c0426m0, c0272fk));
    }

    public final void a(Gh gh) {
        Qh qh = gh.e;
        Ml ml = this.e;
        if (ml != null) {
            qh.b.setUuid(((Ll) ml).g());
        } else {
            qh.getClass();
        }
        this.c.a(gh);
    }

    public final void b(String str) {
        Nf nf = this.f446a.f796a;
        synchronized (nf) {
            nf.f553a.put("PROCESS_CFG_INSTALL_REFERRER_SOURCE", str);
        }
    }

    public Gi(C0426m0 c0426m0, Mn mn, C0129a5 c0129a5, C0272fk c0272fk, Ii ii) {
        this.d = c0426m0;
        this.f446a = c0129a5;
        this.b = mn;
        this.f = c0272fk;
        this.c = ii;
    }

    public final void a(Ll ll) {
        this.e = ll;
        this.f446a.b.setUuid(ll.g());
    }

    public final void a(Boolean bool, Boolean bool2, Boolean bool3) {
        if (fo.a(bool)) {
            this.f446a.b.setLocationTracking(bool.booleanValue());
        }
        if (fo.a(bool2)) {
            this.f446a.b.setDataSendingEnabled(bool2.booleanValue());
        }
        if (fo.a(bool3)) {
            this.f446a.b.setAdvIdentifiersTracking(bool3.booleanValue());
        }
        C0333i6 a2 = C0333i6.a();
        C0129a5 c0129a5 = this.f446a;
        a(a(a2, c0129a5), c0129a5, 1, null);
    }

    public final void a(C0333i6 c0333i6, Qh qh, int i, Map map) {
        String str;
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        this.d.b();
        if (!fo.a(map)) {
            c0333i6.setValue(AbstractC0761zb.b(map));
            a(c0333i6, qh);
        }
        Nf nf = new Nf(qh.f796a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(qh.b);
        T8 t8 = qh.c;
        synchronized (qh) {
            str = qh.f;
        }
        a(new Gh(c0333i6, false, i, null, new Qh(nf, counterConfiguration, t8, str)));
    }

    public static C0333i6 a(C0333i6 c0333i6, Qh qh) {
        if (O9.f564a.contains(Integer.valueOf(c0333i6.d))) {
            c0333i6.c = qh.d();
        }
        return c0333i6;
    }

    public final void a(List list) {
        Nf nf = this.f446a.f796a;
        synchronized (nf) {
            nf.f553a.put("PROCESS_CFG_CUSTOM_HOSTS", fo.a((Collection) list) ? null : new JSONArray((Collection) list).toString());
        }
    }

    public final void a(HashMap hashMap) {
        Nf nf = this.f446a.f796a;
        synchronized (nf) {
            nf.f553a.put("PROCESS_CFG_CLIDS", AbstractC0761zb.b(hashMap));
        }
    }

    public final void a(String str) {
        Nf nf = this.f446a.f796a;
        synchronized (nf) {
            nf.f553a.put("PROCESS_CFG_DISTRIBUTION_REFERRER", str);
        }
    }

    public final Gh a(Kn kn, Qh qh) {
        String str;
        String str2;
        this.d.b();
        Mn mn = this.b;
        mn.getClass();
        An an = kn.f509a;
        if (an == null) {
            str = "";
        } else {
            str = (String) WrapUtils.getOrDefault(an.f342a, "");
        }
        byte[] fromModel = mn.f542a.fromModel(kn);
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(qh.b.getApiKey());
        Set set = O9.f564a;
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        C0331i4 c0331i4 = new C0331i4(fromModel, str, 5891, orCreatePublicLogger);
        c0331i4.c = qh.d();
        HashMap hashMap = c0331i4.q;
        Nf nf = new Nf(qh.f796a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(qh.b);
        T8 t8 = qh.c;
        synchronized (qh) {
            str2 = qh.f;
        }
        return new Gh(c0331i4, true, 1, hashMap, new Qh(nf, counterConfiguration, t8, str2));
    }
}
