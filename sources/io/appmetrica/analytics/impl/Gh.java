package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Gh extends AbstractC0304hh {
    public final Tf b;
    public final ap c;
    public final SafePackageManager d;
    public final TimeProvider e;

    public Gh(C0447n5 c0447n5) {
        this(c0447n5, c0447n5.u(), Na.k().t(), new SafePackageManager(), new SystemTimeProvider());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0304hh
    public final boolean a(C0241f6 c0241f6) {
        C0241f6 a2;
        C0447n5 c0447n5 = this.f1019a;
        if (!this.c.d()) {
            if (((Eh) c0447n5.k.a()).e) {
                a2 = C0241f6.a(c0241f6, Db.EVENT_TYPE_APP_UPDATE);
            } else {
                a2 = C0241f6.a(c0241f6, Db.EVENT_TYPE_INIT);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appInstaller", (String) WrapUtils.getOrDefault(this.d.getInstallerPackageName(c0447n5.f1111a, c0447n5.b.f995a), ""));
                Tf tf = this.b;
                tf.h.a(tf.f1011a);
                jSONObject.put("preloadInfo", ((Qf) tf.c()).b());
            } catch (Throwable unused) {
            }
            a2.setValue(jSONObject.toString());
            E9 e9 = c0447n5.n;
            e9.a(a2, C0670vl.a(e9.c.b(a2), a2.i));
            ap apVar = this.c;
            synchronized (apVar) {
                JSONObject a3 = apVar.f896a.a();
                if (!a3.optBoolean("init_event_done", false)) {
                    apVar.f896a.a(a3.put("init_event_done", true));
                }
                bp bpVar = apVar.f896a;
                bp.a(bpVar.f916a);
                bp.a(bpVar.b);
            }
            this.c.a(this.e.currentTimeMillis());
        }
        return false;
    }

    public Gh(C0447n5 c0447n5, ap apVar, Tf tf, SafePackageManager safePackageManager, SystemTimeProvider systemTimeProvider) {
        super(c0447n5);
        this.c = apVar;
        this.b = tf;
        this.d = safePackageManager;
        this.e = systemTimeProvider;
    }
}
