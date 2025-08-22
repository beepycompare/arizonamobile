package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class Eh extends AbstractC0358jh {
    public final Jf b;
    public final zo c;
    public final SafePackageManager d;
    public final TimeProvider e;

    public Eh(C0572s5 c0572s5) {
        this(c0572s5, c0572s5.t(), Ka.j().s(), new SafePackageManager(), new SystemTimeProvider());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0358jh
    public final boolean a(C0399l6 c0399l6) {
        C0399l6 a2;
        C0572s5 c0572s5 = this.f925a;
        if (this.c.d()) {
            return false;
        }
        if (((Ch) c0572s5.k.a()).e) {
            a2 = C0399l6.a(c0399l6, EnumC0728yb.EVENT_TYPE_APP_UPDATE);
        } else {
            a2 = C0399l6.a(c0399l6, EnumC0728yb.EVENT_TYPE_INIT);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appInstaller", (String) WrapUtils.getOrDefault(this.d.getInstallerPackageName(c0572s5.f1054a, c0572s5.b.f949a), ""));
            Jf jf = this.b;
            jf.h.a(jf.f935a);
            jSONObject.put("preloadInfo", ((Gf) jf.c()).b());
        } catch (Throwable unused) {
        }
        a2.setValue(jSONObject.toString());
        H9 h9 = c0572s5.n;
        h9.a(a2, Xk.a(h9.c.b(a2), a2.i));
        zo zoVar = this.c;
        synchronized (zoVar) {
            Ao ao = zoVar.f1187a;
            ao.a(ao.a().put("init_event_done", true));
        }
        this.c.a(this.e.currentTimeMillis());
        return false;
    }

    public Eh(C0572s5 c0572s5, zo zoVar, Jf jf, SafePackageManager safePackageManager, SystemTimeProvider systemTimeProvider) {
        super(c0572s5);
        this.c = zoVar;
        this.b = jf;
        this.d = safePackageManager;
        this.e = systemTimeProvider;
    }
}
