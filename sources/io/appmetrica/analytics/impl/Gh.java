package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Gh extends AbstractC0298hh {
    public final Tf b;
    public final ap c;
    public final SafePackageManager d;
    public final TimeProvider e;

    public Gh(C0441n5 c0441n5) {
        this(c0441n5, c0441n5.u(), Na.k().t(), new SafePackageManager(), new SystemTimeProvider());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0298hh
    public final boolean a(C0235f6 c0235f6) {
        C0235f6 a2;
        C0441n5 c0441n5 = this.f1022a;
        if (!this.c.d()) {
            if (((Eh) c0441n5.k.a()).e) {
                a2 = C0235f6.a(c0235f6, Db.EVENT_TYPE_APP_UPDATE);
            } else {
                a2 = C0235f6.a(c0235f6, Db.EVENT_TYPE_INIT);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appInstaller", (String) WrapUtils.getOrDefault(this.d.getInstallerPackageName(c0441n5.f1114a, c0441n5.b.f998a), ""));
                Tf tf = this.b;
                tf.h.a(tf.f1014a);
                jSONObject.put("preloadInfo", ((Qf) tf.c()).b());
            } catch (Throwable unused) {
            }
            a2.setValue(jSONObject.toString());
            E9 e9 = c0441n5.n;
            e9.a(a2, C0664vl.a(e9.c.b(a2), a2.i));
            ap apVar = this.c;
            synchronized (apVar) {
                JSONObject a3 = apVar.f899a.a();
                if (!a3.optBoolean("init_event_done", false)) {
                    apVar.f899a.a(a3.put("init_event_done", true));
                }
                bp bpVar = apVar.f899a;
                bp.a(bpVar.f919a);
                bp.a(bpVar.b);
            }
            this.c.a(this.e.currentTimeMillis());
        }
        return false;
    }

    public Gh(C0441n5 c0441n5, ap apVar, Tf tf, SafePackageManager safePackageManager, SystemTimeProvider systemTimeProvider) {
        super(c0441n5);
        this.c = apVar;
        this.b = tf;
        this.d = safePackageManager;
        this.e = systemTimeProvider;
    }
}
