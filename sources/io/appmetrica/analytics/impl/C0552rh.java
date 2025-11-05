package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.rh  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0552rh extends Wg {
    public final C0725yf b;
    public final zo c;
    public final SafePackageManager d;
    public final TimeProvider e;

    public C0552rh(C0210e5 c0210e5) {
        this(c0210e5, c0210e5.u(), C0620ua.k().t(), new SafePackageManager(), new SystemTimeProvider());
    }

    @Override // io.appmetrica.analytics.impl.Wg
    public final boolean a(W5 w5) {
        W5 a2;
        C0210e5 c0210e5 = this.f744a;
        if (this.c.d()) {
            return false;
        }
        if (((C0503ph) c0210e5.k.a()).e) {
            a2 = W5.a(w5, EnumC0320ib.EVENT_TYPE_APP_UPDATE);
        } else {
            a2 = W5.a(w5, EnumC0320ib.EVENT_TYPE_INIT);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appInstaller", (String) WrapUtils.getOrDefault(this.d.getInstallerPackageName(c0210e5.f857a, c0210e5.b.f752a), ""));
            C0725yf c0725yf = this.b;
            c0725yf.h.a(c0725yf.f730a);
            jSONObject.put("preloadInfo", ((C0650vf) c0725yf.c()).b());
        } catch (Throwable unused) {
        }
        a2.setValue(jSONObject.toString());
        C0544r9 c0544r9 = c0210e5.n;
        c0544r9.a(a2, Wk.a(c0544r9.c.b(a2), a2.i));
        zo zoVar = this.c;
        synchronized (zoVar) {
            Ao ao = zoVar.f1238a;
            ao.a(ao.a().put("init_event_done", true));
        }
        this.c.a(this.e.currentTimeMillis());
        return false;
    }

    public C0552rh(C0210e5 c0210e5, zo zoVar, C0725yf c0725yf, SafePackageManager safePackageManager, SystemTimeProvider systemTimeProvider) {
        super(c0210e5);
        this.c = zoVar;
        this.b = c0725yf;
        this.d = safePackageManager;
        this.e = systemTimeProvider;
    }
}
