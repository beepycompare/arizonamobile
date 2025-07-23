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
public final class Ji {

    /* renamed from: a  reason: collision with root package name */
    public final C0121a5 f508a;
    public final Pn b;
    public final Li c;
    public final C0420m0 d;
    public Pl e;
    public final C0340ik f;

    public Ji(C0420m0 c0420m0, Pn pn, C0121a5 c0121a5, C0340ik c0340ik) {
        this(c0420m0, pn, c0121a5, c0340ik, new Li(c0420m0, c0340ik));
    }

    public final void a(Ih ih) {
        Sh sh = ih.e;
        Pl pl = this.e;
        if (pl != null) {
            sh.b.setUuid(((Ol) pl).g());
        } else {
            sh.getClass();
        }
        this.c.a(ih);
    }

    public final void b(String str) {
        Pf pf = this.f508a.f811a;
        synchronized (pf) {
            pf.f595a.put("PROCESS_CFG_INSTALL_REFERRER_SOURCE", str);
        }
    }

    public Ji(C0420m0 c0420m0, Pn pn, C0121a5 c0121a5, C0340ik c0340ik, Li li) {
        this.d = c0420m0;
        this.f508a = c0121a5;
        this.b = pn;
        this.f = c0340ik;
        this.c = li;
    }

    public final void a(Ol ol) {
        this.e = ol;
        this.f508a.b.setUuid(ol.g());
    }

    public final void a(Boolean bool, Boolean bool2, Boolean bool3) {
        if (io.a(bool)) {
            this.f508a.b.setLocationTracking(bool.booleanValue());
        }
        if (io.a(bool2)) {
            this.f508a.b.setDataSendingEnabled(bool2.booleanValue());
        }
        if (io.a(bool3)) {
            this.f508a.b.setAdvIdentifiersTracking(bool3.booleanValue());
        }
        C0401l6 a2 = C0401l6.a();
        C0121a5 c0121a5 = this.f508a;
        a(a(a2, c0121a5), c0121a5, 1, null);
    }

    public final void a(C0401l6 c0401l6, Sh sh, int i, Map map) {
        String str;
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        this.d.b();
        if (!io.a(map)) {
            c0401l6.setValue(Bb.b(map));
            a(c0401l6, sh);
        }
        Pf pf = new Pf(sh.f811a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(sh.b);
        W8 w8 = sh.c;
        synchronized (sh) {
            str = sh.f;
        }
        a(new Ih(c0401l6, false, i, null, new Sh(pf, counterConfiguration, w8, str)));
    }

    public static C0401l6 a(C0401l6 c0401l6, Sh sh) {
        if (R9.f620a.contains(Integer.valueOf(c0401l6.d))) {
            c0401l6.c = sh.d();
        }
        return c0401l6;
    }

    public final void a(List list) {
        Pf pf = this.f508a.f811a;
        synchronized (pf) {
            pf.f595a.put("PROCESS_CFG_CUSTOM_HOSTS", io.a((Collection) list) ? null : new JSONArray((Collection) list).toString());
        }
    }

    public final void a(HashMap hashMap) {
        Pf pf = this.f508a.f811a;
        synchronized (pf) {
            pf.f595a.put("PROCESS_CFG_CLIDS", Bb.b(hashMap));
        }
    }

    public final void a(String str) {
        Pf pf = this.f508a.f811a;
        synchronized (pf) {
            pf.f595a.put("PROCESS_CFG_DISTRIBUTION_REFERRER", str);
        }
    }

    public final Ih a(Nn nn, Sh sh) {
        String str;
        String str2;
        this.d.b();
        Pn pn = this.b;
        pn.getClass();
        Dn dn = nn.f568a;
        if (dn == null) {
            str = "";
        } else {
            str = (String) WrapUtils.getOrDefault(dn.f403a, "");
        }
        byte[] fromModel = pn.f602a.fromModel(nn);
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(sh.b.getApiKey());
        Set set = R9.f620a;
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        C0325i4 c0325i4 = new C0325i4(fromModel, str, 5891, orCreatePublicLogger);
        c0325i4.c = sh.d();
        HashMap hashMap = c0325i4.q;
        Pf pf = new Pf(sh.f811a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(sh.b);
        W8 w8 = sh.c;
        synchronized (sh) {
            str2 = sh.f;
        }
        return new Ih(c0325i4, true, 1, hashMap, new Sh(pf, counterConfiguration, w8, str2));
    }
}
