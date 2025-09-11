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
    public final C0192d5 f672a;
    public final Yn b;
    public final Ui c;
    public final C0471o0 d;
    public Yl e;
    public final C0566rk f;

    public Si(C0471o0 c0471o0, Yn yn, C0192d5 c0192d5, C0566rk c0566rk) {
        this(c0471o0, yn, c0192d5, c0566rk, new Ui(c0471o0, c0566rk));
    }

    public final void a(Rh rh) {
        C0153bi c0153bi = rh.e;
        Yl yl = this.e;
        if (yl != null) {
            c0153bi.b.setUuid(((Xl) yl).g());
        } else {
            c0153bi.getClass();
        }
        this.c.a(rh);
    }

    public final void b(String str) {
        Vf vf = this.f672a.f888a;
        synchronized (vf) {
            vf.f712a.put("PROCESS_CFG_INSTALL_REFERRER_SOURCE", str);
        }
    }

    public Si(C0471o0 c0471o0, Yn yn, C0192d5 c0192d5, C0566rk c0566rk, Ui ui) {
        this.d = c0471o0;
        this.f672a = c0192d5;
        this.b = yn;
        this.f = c0566rk;
        this.c = ui;
    }

    public final void a(Xl xl) {
        this.e = xl;
        this.f672a.b.setUuid(xl.g());
    }

    public final void a(Boolean bool, Boolean bool2, Boolean bool3) {
        if (ro.a(bool)) {
            this.f672a.b.setLocationTracking(bool.booleanValue());
        }
        if (ro.a(bool2)) {
            this.f672a.b.setDataSendingEnabled(bool2.booleanValue());
        }
        if (ro.a(bool3)) {
            this.f672a.b.setAdvIdentifiersTracking(bool3.booleanValue());
        }
        C0477o6 a2 = C0477o6.a();
        C0192d5 c0192d5 = this.f672a;
        a(a(a2, c0192d5), c0192d5, 1, null);
    }

    public final void a(C0477o6 c0477o6, C0153bi c0153bi, int i, Map map) {
        String str;
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        this.d.b();
        if (!ro.a(map)) {
            c0477o6.setValue(Gb.b(map));
            a(c0477o6, c0153bi);
        }
        Vf vf = new Vf(c0153bi.f888a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(c0153bi.b);
        C0144b9 c0144b9 = c0153bi.c;
        synchronized (c0153bi) {
            str = c0153bi.f;
        }
        a(new Rh(c0477o6, false, i, null, new C0153bi(vf, counterConfiguration, c0144b9, str)));
    }

    public static C0477o6 a(C0477o6 c0477o6, C0153bi c0153bi) {
        if (W9.f725a.contains(Integer.valueOf(c0477o6.d))) {
            c0477o6.c = c0153bi.d();
        }
        return c0477o6;
    }

    public final void a(List list) {
        Vf vf = this.f672a.f888a;
        synchronized (vf) {
            vf.f712a.put("PROCESS_CFG_CUSTOM_HOSTS", ro.a((Collection) list) ? null : new JSONArray((Collection) list).toString());
        }
    }

    public final void a(HashMap hashMap) {
        Vf vf = this.f672a.f888a;
        synchronized (vf) {
            vf.f712a.put("PROCESS_CFG_CLIDS", Gb.b(hashMap));
        }
    }

    public final void a(String str) {
        Vf vf = this.f672a.f888a;
        synchronized (vf) {
            vf.f712a.put("PROCESS_CFG_DISTRIBUTION_REFERRER", str);
        }
    }

    public final Rh a(Wn wn, C0153bi c0153bi) {
        String str;
        String str2;
        this.d.b();
        Yn yn = this.b;
        yn.getClass();
        Mn mn = wn.f731a;
        if (mn == null) {
            str = "";
        } else {
            str = (String) WrapUtils.getOrDefault(mn.f583a, "");
        }
        byte[] fromModel = yn.f763a.fromModel(wn);
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(c0153bi.b.getApiKey());
        Set set = W9.f725a;
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        C0397l4 c0397l4 = new C0397l4(fromModel, str, 5891, orCreatePublicLogger);
        c0397l4.c = c0153bi.d();
        HashMap hashMap = c0397l4.q;
        Vf vf = new Vf(c0153bi.f888a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(c0153bi.b);
        C0144b9 c0144b9 = c0153bi.c;
        synchronized (c0153bi) {
            str2 = c0153bi.f;
        }
        return new Rh(c0397l4, true, 1, hashMap, new C0153bi(vf, counterConfiguration, c0144b9, str2));
    }
}
