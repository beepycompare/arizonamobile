package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.nh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0452nh extends Sg {
    public final C0624uf b;
    public final yo c;
    public final SafePackageManager d;
    public final TimeProvider e;

    public C0452nh(Y4 y4) {
        this(y4, y4.u(), C0470oa.k().t(), new SafePackageManager(), new SystemTimeProvider());
    }

    @Override // io.appmetrica.analytics.impl.Sg
    public final boolean a(Q5 q5) {
        Q5 a2;
        Y4 y4 = this.f762a;
        if (this.c.d()) {
            return false;
        }
        if (((C0402lh) y4.k.a()).e) {
            a2 = Q5.a(q5, EnumC0164cb.EVENT_TYPE_APP_UPDATE);
        } else {
            a2 = Q5.a(q5, EnumC0164cb.EVENT_TYPE_INIT);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appInstaller", (String) WrapUtils.getOrDefault(this.d.getInstallerPackageName(y4.f843a, y4.b.f742a), ""));
            C0624uf c0624uf = this.b;
            c0624uf.h.a(c0624uf.f732a);
            jSONObject.put("preloadInfo", ((C0549rf) c0624uf.c()).b());
        } catch (Throwable unused) {
        }
        a2.setValue(jSONObject.toString());
        C0394l9 c0394l9 = y4.n;
        c0394l9.a(a2, Sk.a(c0394l9.c.b(a2), a2.i));
        yo yoVar = this.c;
        synchronized (yoVar) {
            zo zoVar = yoVar.f1308a;
            zoVar.a(zoVar.a().put("init_event_done", true));
        }
        this.c.a(this.e.currentTimeMillis());
        return false;
    }

    public C0452nh(Y4 y4, yo yoVar, C0624uf c0624uf, SafePackageManager safePackageManager, SystemTimeProvider systemTimeProvider) {
        super(y4);
        this.c = yoVar;
        this.b = c0624uf;
        this.d = safePackageManager;
        this.e = systemTimeProvider;
    }
}
