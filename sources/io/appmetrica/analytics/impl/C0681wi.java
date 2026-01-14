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
/* renamed from: io.appmetrica.analytics.impl.wi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0681wi {

    /* renamed from: a  reason: collision with root package name */
    public final F4 f1289a;
    public final Sn b;
    public final C0731yi c;
    public final C0489p0 d;
    public Pl e;
    public final Yj f;

    public C0681wi(C0489p0 c0489p0, Sn sn, F4 f4, Yj yj) {
        this(c0489p0, sn, f4, yj, new C0731yi(c0489p0, yj));
    }

    public final void a(C0655vh c0655vh) {
        Fh fh = c0655vh.e;
        Pl pl = this.e;
        if (pl != null) {
            fh.b.setUuid(((Ol) pl).g());
        } else {
            fh.getClass();
        }
        this.c.a(c0655vh);
    }

    public final void b(String str) {
        Bf bf = this.f1289a.f608a;
        synchronized (bf) {
            bf.f521a.put("PROCESS_CFG_INSTALL_REFERRER_SOURCE", str);
        }
    }

    public C0681wi(C0489p0 c0489p0, Sn sn, F4 f4, Yj yj, C0731yi c0731yi) {
        this.d = c0489p0;
        this.f1289a = f4;
        this.b = sn;
        this.f = yj;
        this.c = c0731yi;
    }

    public final void a(Ol ol) {
        this.e = ol;
        this.f1289a.b.setUuid(ol.g());
    }

    public final void a(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        if (lo.a(bool)) {
            this.f1289a.b.setLocationTracking(bool.booleanValue());
        }
        if (lo.a(bool2)) {
            this.f1289a.b.setDataSendingEnabled(bool2.booleanValue());
        }
        if (lo.a(bool3)) {
            this.f1289a.b.setAdvIdentifiersTracking(bool3.booleanValue(), bool4.booleanValue());
        }
        P5 a2 = P5.a();
        F4 f4 = this.f1289a;
        a(a(a2, f4), f4, 1, (Map) null);
    }

    public final void a(P5 p5, Fh fh, int i, Map map) {
        String str;
        EnumC0143bb enumC0143bb = EnumC0143bb.EVENT_TYPE_UNDEFINED;
        this.d.b();
        if (!lo.a(map)) {
            p5.setValue(AbstractC0272gb.b(map));
            a(p5, fh);
        }
        Bf bf = new Bf(fh.f608a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(fh.b);
        D8 d8 = fh.c;
        synchronized (fh) {
            str = fh.f;
        }
        a(new C0655vh(p5, false, i, null, new Fh(bf, counterConfiguration, d8, str)));
    }

    public static P5 a(P5 p5, Fh fh) {
        if (AbstractC0672w9.f1285a.contains(Integer.valueOf(p5.d))) {
            p5.c = fh.d();
        }
        return p5;
    }

    public final void a(List list) {
        Bf bf = this.f1289a.f608a;
        synchronized (bf) {
            bf.f521a.put("PROCESS_CFG_CUSTOM_HOSTS", lo.a((Collection) list) ? null : new JSONArray((Collection) list).toString());
        }
    }

    public final void a(HashMap hashMap) {
        Bf bf = this.f1289a.f608a;
        synchronized (bf) {
            bf.f521a.put("PROCESS_CFG_CLIDS", AbstractC0272gb.b(hashMap));
        }
    }

    public final void a(String str) {
        Bf bf = this.f1289a.f608a;
        synchronized (bf) {
            bf.f521a.put("PROCESS_CFG_DISTRIBUTION_REFERRER", str);
        }
    }

    public final C0655vh a(Qn qn, Fh fh) {
        String str;
        String str2;
        this.d.b();
        Sn sn = this.b;
        sn.getClass();
        Gn gn = qn.f756a;
        if (gn == null) {
            str = "";
        } else {
            str = (String) WrapUtils.getOrDefault(gn.f604a, "");
        }
        byte[] fromModel = sn.f788a.fromModel(qn);
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(fh.b.getApiKey());
        Set set = AbstractC0672w9.f1285a;
        EnumC0143bb enumC0143bb = EnumC0143bb.EVENT_TYPE_UNDEFINED;
        M3 m3 = new M3(fromModel, str, 5891, orCreatePublicLogger);
        m3.c = fh.d();
        HashMap hashMap = m3.q;
        Bf bf = new Bf(fh.f608a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(fh.b);
        D8 d8 = fh.c;
        synchronized (fh) {
            str2 = fh.f;
        }
        return new C0655vh(m3, true, 1, hashMap, new Fh(bf, counterConfiguration, d8, str2));
    }
}
