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
    public final C0121a5 f447a;
    public final Mn b;
    public final Ii c;
    public final C0418m0 d;
    public Ml e;
    public final C0264fk f;

    public Gi(C0418m0 c0418m0, Mn mn, C0121a5 c0121a5, C0264fk c0264fk) {
        this(c0418m0, mn, c0121a5, c0264fk, new Ii(c0418m0, c0264fk));
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
        Nf nf = this.f447a.f797a;
        synchronized (nf) {
            nf.f554a.put("PROCESS_CFG_INSTALL_REFERRER_SOURCE", str);
        }
    }

    public Gi(C0418m0 c0418m0, Mn mn, C0121a5 c0121a5, C0264fk c0264fk, Ii ii) {
        this.d = c0418m0;
        this.f447a = c0121a5;
        this.b = mn;
        this.f = c0264fk;
        this.c = ii;
    }

    public final void a(Ll ll) {
        this.e = ll;
        this.f447a.b.setUuid(ll.g());
    }

    public final void a(Boolean bool, Boolean bool2, Boolean bool3) {
        if (fo.a(bool)) {
            this.f447a.b.setLocationTracking(bool.booleanValue());
        }
        if (fo.a(bool2)) {
            this.f447a.b.setDataSendingEnabled(bool2.booleanValue());
        }
        if (fo.a(bool3)) {
            this.f447a.b.setAdvIdentifiersTracking(bool3.booleanValue());
        }
        C0325i6 a2 = C0325i6.a();
        C0121a5 c0121a5 = this.f447a;
        a(a(a2, c0121a5), c0121a5, 1, null);
    }

    public final void a(C0325i6 c0325i6, Qh qh, int i, Map map) {
        String str;
        EnumC0628ub enumC0628ub = EnumC0628ub.EVENT_TYPE_UNDEFINED;
        this.d.b();
        if (!fo.a(map)) {
            c0325i6.setValue(AbstractC0753zb.b(map));
            a(c0325i6, qh);
        }
        Nf nf = new Nf(qh.f797a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(qh.b);
        T8 t8 = qh.c;
        synchronized (qh) {
            str = qh.f;
        }
        a(new Gh(c0325i6, false, i, null, new Qh(nf, counterConfiguration, t8, str)));
    }

    public static C0325i6 a(C0325i6 c0325i6, Qh qh) {
        if (O9.f565a.contains(Integer.valueOf(c0325i6.d))) {
            c0325i6.c = qh.d();
        }
        return c0325i6;
    }

    public final void a(List list) {
        Nf nf = this.f447a.f797a;
        synchronized (nf) {
            nf.f554a.put("PROCESS_CFG_CUSTOM_HOSTS", fo.a((Collection) list) ? null : new JSONArray((Collection) list).toString());
        }
    }

    public final void a(HashMap hashMap) {
        Nf nf = this.f447a.f797a;
        synchronized (nf) {
            nf.f554a.put("PROCESS_CFG_CLIDS", AbstractC0753zb.b(hashMap));
        }
    }

    public final void a(String str) {
        Nf nf = this.f447a.f797a;
        synchronized (nf) {
            nf.f554a.put("PROCESS_CFG_DISTRIBUTION_REFERRER", str);
        }
    }

    public final Gh a(Kn kn, Qh qh) {
        String str;
        String str2;
        this.d.b();
        Mn mn = this.b;
        mn.getClass();
        An an = kn.f510a;
        if (an == null) {
            str = "";
        } else {
            str = (String) WrapUtils.getOrDefault(an.f343a, "");
        }
        byte[] fromModel = mn.f543a.fromModel(kn);
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(qh.b.getApiKey());
        Set set = O9.f565a;
        EnumC0628ub enumC0628ub = EnumC0628ub.EVENT_TYPE_UNDEFINED;
        C0323i4 c0323i4 = new C0323i4(fromModel, str, 5891, orCreatePublicLogger);
        c0323i4.c = qh.d();
        HashMap hashMap = c0323i4.q;
        Nf nf = new Nf(qh.f797a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(qh.b);
        T8 t8 = qh.c;
        synchronized (qh) {
            str2 = qh.f;
        }
        return new Gh(c0323i4, true, 1, hashMap, new Qh(nf, counterConfiguration, t8, str2));
    }
}
