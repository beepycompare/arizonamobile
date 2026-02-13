package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.mh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0431mh extends Rg {
    public final C0603tf b;
    public final xo c;
    public final SafePackageManager d;
    public final TimeProvider e;

    public C0431mh(X4 x4) {
        this(x4, x4.u(), C0449na.k().t(), new SafePackageManager(), new SystemTimeProvider());
    }

    @Override // io.appmetrica.analytics.impl.Rg
    public final boolean a(P5 p5) {
        P5 a2;
        X4 x4 = this.f767a;
        if (this.c.d()) {
            return false;
        }
        if (((C0381kh) x4.k.a()).e) {
            a2 = P5.a(p5, EnumC0143bb.EVENT_TYPE_APP_UPDATE);
        } else {
            a2 = P5.a(p5, EnumC0143bb.EVENT_TYPE_INIT);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appInstaller", (String) WrapUtils.getOrDefault(this.d.getInstallerPackageName(x4.f848a, x4.b.f748a), ""));
            C0603tf c0603tf = this.b;
            c0603tf.h.a(c0603tf.f737a);
            jSONObject.put("preloadInfo", ((C0529qf) c0603tf.c()).b());
        } catch (Throwable unused) {
        }
        a2.setValue(jSONObject.toString());
        C0373k9 c0373k9 = x4.n;
        c0373k9.a(a2, Rk.a(c0373k9.c.b(a2), a2.i));
        xo xoVar = this.c;
        synchronized (xoVar) {
            yo yoVar = xoVar.f1312a;
            yoVar.a(yoVar.a().put("init_event_done", true));
        }
        this.c.a(this.e.currentTimeMillis());
        return false;
    }

    public C0431mh(X4 x4, xo xoVar, C0603tf c0603tf, SafePackageManager safePackageManager, SystemTimeProvider systemTimeProvider) {
        super(x4);
        this.c = xoVar;
        this.b = c0603tf;
        this.d = safePackageManager;
        this.e = systemTimeProvider;
    }
}
