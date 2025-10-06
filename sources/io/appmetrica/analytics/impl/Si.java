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
public final class Si {

    /* renamed from: a  reason: collision with root package name */
    public final C0193d5 f673a;
    public final Yn b;
    public final Ui c;
    public final C0472o0 d;
    public Yl e;
    public final C0567rk f;

    public Si(C0472o0 c0472o0, Yn yn, C0193d5 c0193d5, C0567rk c0567rk) {
        this(c0472o0, yn, c0193d5, c0567rk, new Ui(c0472o0, c0567rk));
    }

    public final void a(Rh rh) {
        C0154bi c0154bi = rh.e;
        Yl yl = this.e;
        if (yl != null) {
            c0154bi.b.setUuid(((Xl) yl).g());
        } else {
            c0154bi.getClass();
        }
        this.c.a(rh);
    }

    public final void b(String str) {
        Vf vf = this.f673a.f889a;
        synchronized (vf) {
            vf.f713a.put("PROCESS_CFG_INSTALL_REFERRER_SOURCE", str);
        }
    }

    public Si(C0472o0 c0472o0, Yn yn, C0193d5 c0193d5, C0567rk c0567rk, Ui ui) {
        this.d = c0472o0;
        this.f673a = c0193d5;
        this.b = yn;
        this.f = c0567rk;
        this.c = ui;
    }

    public final void a(Xl xl) {
        this.e = xl;
        this.f673a.b.setUuid(xl.g());
    }

    public final void a(Boolean bool, Boolean bool2, Boolean bool3) {
        if (ro.a(bool)) {
            this.f673a.b.setLocationTracking(bool.booleanValue());
        }
        if (ro.a(bool2)) {
            this.f673a.b.setDataSendingEnabled(bool2.booleanValue());
        }
        if (ro.a(bool3)) {
            this.f673a.b.setAdvIdentifiersTracking(bool3.booleanValue());
        }
        C0478o6 a2 = C0478o6.a();
        C0193d5 c0193d5 = this.f673a;
        a(a(a2, c0193d5), c0193d5, 1, null);
    }

    public final void a(C0478o6 c0478o6, C0154bi c0154bi, int i, Map map) {
        String str;
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        this.d.b();
        if (!ro.a(map)) {
            c0478o6.setValue(Gb.b(map));
            a(c0478o6, c0154bi);
        }
        Vf vf = new Vf(c0154bi.f889a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(c0154bi.b);
        C0145b9 c0145b9 = c0154bi.c;
        synchronized (c0154bi) {
            str = c0154bi.f;
        }
        a(new Rh(c0478o6, false, i, null, new C0154bi(vf, counterConfiguration, c0145b9, str)));
    }

    public static C0478o6 a(C0478o6 c0478o6, C0154bi c0154bi) {
        if (W9.f726a.contains(Integer.valueOf(c0478o6.d))) {
            c0478o6.c = c0154bi.d();
        }
        return c0478o6;
    }

    public final void a(List list) {
        Vf vf = this.f673a.f889a;
        synchronized (vf) {
            vf.f713a.put("PROCESS_CFG_CUSTOM_HOSTS", ro.a((Collection) list) ? null : new JSONArray((Collection) list).toString());
        }
    }

    public final void a(HashMap hashMap) {
        Vf vf = this.f673a.f889a;
        synchronized (vf) {
            vf.f713a.put("PROCESS_CFG_CLIDS", Gb.b(hashMap));
        }
    }

    public final void a(String str) {
        Vf vf = this.f673a.f889a;
        synchronized (vf) {
            vf.f713a.put("PROCESS_CFG_DISTRIBUTION_REFERRER", str);
        }
    }

    public final Rh a(Wn wn, C0154bi c0154bi) {
        String str;
        String str2;
        this.d.b();
        Yn yn = this.b;
        yn.getClass();
        Mn mn = wn.f732a;
        if (mn == null) {
            str = "";
        } else {
            str = (String) WrapUtils.getOrDefault(mn.f584a, "");
        }
        byte[] fromModel = yn.f764a.fromModel(wn);
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(c0154bi.b.getApiKey());
        Set set = W9.f726a;
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        C0398l4 c0398l4 = new C0398l4(fromModel, str, 5891, orCreatePublicLogger);
        c0398l4.c = c0154bi.d();
        HashMap hashMap = c0398l4.q;
        Vf vf = new Vf(c0154bi.f889a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(c0154bi.b);
        C0145b9 c0145b9 = c0154bi.c;
        synchronized (c0154bi) {
            str2 = c0154bi.f;
        }
        return new Rh(c0398l4, true, 1, hashMap, new C0154bi(vf, counterConfiguration, c0145b9, str2));
    }
}
