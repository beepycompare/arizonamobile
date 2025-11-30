package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.nh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0453nh extends Sg {
    public final C0625uf b;
    public final yo c;
    public final SafePackageManager d;
    public final TimeProvider e;

    public C0453nh(Y4 y4) {
        this(y4, y4.u(), C0471oa.k().t(), new SafePackageManager(), new SystemTimeProvider());
    }

    @Override // io.appmetrica.analytics.impl.Sg
    public final boolean a(Q5 q5) {
        Q5 a2;
        Y4 y4 = this.f679a;
        if (this.c.d()) {
            return false;
        }
        if (((C0403lh) y4.k.a()).e) {
            a2 = Q5.a(q5, EnumC0165cb.EVENT_TYPE_APP_UPDATE);
        } else {
            a2 = Q5.a(q5, EnumC0165cb.EVENT_TYPE_INIT);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appInstaller", (String) WrapUtils.getOrDefault(this.d.getInstallerPackageName(y4.f760a, y4.b.f659a), ""));
            C0625uf c0625uf = this.b;
            c0625uf.h.a(c0625uf.f649a);
            jSONObject.put("preloadInfo", ((C0550rf) c0625uf.c()).b());
        } catch (Throwable unused) {
        }
        a2.setValue(jSONObject.toString());
        C0395l9 c0395l9 = y4.n;
        c0395l9.a(a2, Sk.a(c0395l9.c.b(a2), a2.i));
        yo yoVar = this.c;
        synchronized (yoVar) {
            zo zoVar = yoVar.f1225a;
            zoVar.a(zoVar.a().put("init_event_done", true));
        }
        this.c.a(this.e.currentTimeMillis());
        return false;
    }

    public C0453nh(Y4 y4, yo yoVar, C0625uf c0625uf, SafePackageManager safePackageManager, SystemTimeProvider systemTimeProvider) {
        super(y4);
        this.c = yoVar;
        this.b = c0625uf;
        this.d = safePackageManager;
        this.e = systemTimeProvider;
    }
}
