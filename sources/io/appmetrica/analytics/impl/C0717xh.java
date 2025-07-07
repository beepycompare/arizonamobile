package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.xh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0717xh extends AbstractC0193ch {
    public final Ff b;
    public final ro c;
    public final SafePackageManager d;
    public final TimeProvider e;

    public C0717xh(C0580s5 c0580s5) {
        this(c0580s5, c0580s5.t(), Ga.j().s(), new SafePackageManager(), new SystemTimeProvider());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0193ch
    public final boolean a(C0333i6 c0333i6) {
        C0333i6 a2;
        C0580s5 c0580s5 = this.f785a;
        if (this.c.d()) {
            return false;
        }
        if (((C0667vh) c0580s5.k.a()).e) {
            a2 = C0333i6.a(c0333i6, EnumC0636ub.EVENT_TYPE_APP_UPDATE);
        } else {
            a2 = C0333i6.a(c0333i6, EnumC0636ub.EVENT_TYPE_INIT);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appInstaller", (String) WrapUtils.getOrDefault(this.d.getInstallerPackageName(c0580s5.f1037a, c0580s5.b.f917a), ""));
            Ff ff = this.b;
            ff.h.a(ff.f833a);
            jSONObject.put("preloadInfo", ((Cf) ff.c()).b());
        } catch (Throwable unused) {
        }
        a2.setValue(jSONObject.toString());
        C9 c9 = c0580s5.n;
        c9.a(a2, Pk.a(c9.c.b(a2), a2.i));
        ro roVar = this.c;
        synchronized (roVar) {
            so soVar = roVar.f1033a;
            soVar.a(soVar.a().put("init_event_done", true));
        }
        this.c.a(this.e.currentTimeMillis());
        return false;
    }

    public C0717xh(C0580s5 c0580s5, ro roVar, Ff ff, SafePackageManager safePackageManager, SystemTimeProvider systemTimeProvider) {
        super(c0580s5);
        this.c = roVar;
        this.b = ff;
        this.d = safePackageManager;
        this.e = systemTimeProvider;
    }
}
