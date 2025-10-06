package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class Ih extends AbstractC0463nh {
    public final Nf b;
    public final Do c;
    public final SafePackageManager d;
    public final TimeProvider e;

    public Ih(C0652v5 c0652v5) {
        this(c0652v5, c0652v5.u(), Na.j().s(), new SafePackageManager(), new SystemTimeProvider());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0463nh
    public final boolean a(C0478o6 c0478o6) {
        C0478o6 a2;
        C0652v5 c0652v5 = this.f1006a;
        if (this.c.d()) {
            return false;
        }
        if (((Gh) c0652v5.k.a()).e) {
            a2 = C0478o6.a(c0478o6, Bb.EVENT_TYPE_APP_UPDATE);
        } else {
            a2 = C0478o6.a(c0478o6, Bb.EVENT_TYPE_INIT);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appInstaller", (String) WrapUtils.getOrDefault(this.d.getInstallerPackageName(c0652v5.f1120a, c0652v5.b.f1017a), ""));
            Nf nf = this.b;
            nf.h.a(nf.f1003a);
            jSONObject.put("preloadInfo", ((Kf) nf.c()).b());
        } catch (Throwable unused) {
        }
        a2.setValue(jSONObject.toString());
        K9 k9 = c0652v5.n;
        k9.a(a2, C0157bl.a(k9.c.b(a2), a2.i));
        Do r7 = this.c;
        synchronized (r7) {
            Eo eo = r7.f418a;
            eo.a(eo.a().put("init_event_done", true));
        }
        this.c.a(this.e.currentTimeMillis());
        return false;
    }

    public Ih(C0652v5 c0652v5, Do r2, Nf nf, SafePackageManager safePackageManager, SystemTimeProvider systemTimeProvider) {
        super(c0652v5);
        this.c = r2;
        this.b = nf;
        this.d = safePackageManager;
        this.e = systemTimeProvider;
    }
}
