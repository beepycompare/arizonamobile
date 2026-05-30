package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Gh extends AbstractC0305hh {
    public final Tf b;
    public final ap c;
    public final SafePackageManager d;
    public final TimeProvider e;

    public Gh(C0448n5 c0448n5) {
        this(c0448n5, c0448n5.u(), Na.k().t(), new SafePackageManager(), new SystemTimeProvider());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0305hh
    public final boolean a(C0242f6 c0242f6) {
        C0242f6 a2;
        C0448n5 c0448n5 = this.f1017a;
        if (!this.c.d()) {
            if (((Eh) c0448n5.k.a()).e) {
                a2 = C0242f6.a(c0242f6, Db.EVENT_TYPE_APP_UPDATE);
            } else {
                a2 = C0242f6.a(c0242f6, Db.EVENT_TYPE_INIT);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appInstaller", (String) WrapUtils.getOrDefault(this.d.getInstallerPackageName(c0448n5.f1109a, c0448n5.b.f993a), ""));
                Tf tf = this.b;
                tf.h.a(tf.f1009a);
                jSONObject.put("preloadInfo", ((Qf) tf.c()).b());
            } catch (Throwable unused) {
            }
            a2.setValue(jSONObject.toString());
            E9 e9 = c0448n5.n;
            e9.a(a2, C0671vl.a(e9.c.b(a2), a2.i));
            ap apVar = this.c;
            synchronized (apVar) {
                JSONObject a3 = apVar.f894a.a();
                if (!a3.optBoolean("init_event_done", false)) {
                    apVar.f894a.a(a3.put("init_event_done", true));
                }
                bp bpVar = apVar.f894a;
                bp.a(bpVar.f914a);
                bp.a(bpVar.b);
            }
            this.c.a(this.e.currentTimeMillis());
        }
        return false;
    }

    public Gh(C0448n5 c0448n5, ap apVar, Tf tf, SafePackageManager safePackageManager, SystemTimeProvider systemTimeProvider) {
        super(c0448n5);
        this.c = apVar;
        this.b = tf;
        this.d = safePackageManager;
        this.e = systemTimeProvider;
    }
}
