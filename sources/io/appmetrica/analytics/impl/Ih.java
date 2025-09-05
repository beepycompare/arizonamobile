package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class Ih extends AbstractC0462nh {
    public final Nf b;
    public final Do c;
    public final SafePackageManager d;
    public final TimeProvider e;

    public Ih(C0651v5 c0651v5) {
        this(c0651v5, c0651v5.u(), Na.j().s(), new SafePackageManager(), new SystemTimeProvider());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0462nh
    public final boolean a(C0477o6 c0477o6) {
        C0477o6 a2;
        C0651v5 c0651v5 = this.f1001a;
        if (this.c.d()) {
            return false;
        }
        if (((Gh) c0651v5.k.a()).e) {
            a2 = C0477o6.a(c0477o6, Bb.EVENT_TYPE_APP_UPDATE);
        } else {
            a2 = C0477o6.a(c0477o6, Bb.EVENT_TYPE_INIT);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appInstaller", (String) WrapUtils.getOrDefault(this.d.getInstallerPackageName(c0651v5.f1115a, c0651v5.b.f1012a), ""));
            Nf nf = this.b;
            nf.h.a(nf.f998a);
            jSONObject.put("preloadInfo", ((Kf) nf.c()).b());
        } catch (Throwable unused) {
        }
        a2.setValue(jSONObject.toString());
        K9 k9 = c0651v5.n;
        k9.a(a2, C0156bl.a(k9.c.b(a2), a2.i));
        Do r7 = this.c;
        synchronized (r7) {
            Eo eo = r7.f413a;
            eo.a(eo.a().put("init_event_done", true));
        }
        this.c.a(this.e.currentTimeMillis());
        return false;
    }

    public Ih(C0651v5 c0651v5, Do r2, Nf nf, SafePackageManager safePackageManager, SystemTimeProvider systemTimeProvider) {
        super(c0651v5);
        this.c = r2;
        this.b = nf;
        this.d = safePackageManager;
        this.e = systemTimeProvider;
    }
}
