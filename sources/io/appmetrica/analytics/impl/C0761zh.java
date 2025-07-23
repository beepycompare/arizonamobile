package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.zh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0761zh extends AbstractC0236eh {
    public final Hf b;
    public final uo c;
    public final SafePackageManager d;
    public final TimeProvider e;

    public C0761zh(C0574s5 c0574s5) {
        this(c0574s5, c0574s5.t(), Ia.j().s(), new SafePackageManager(), new SystemTimeProvider());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0236eh
    public final boolean a(C0401l6 c0401l6) {
        C0401l6 a2;
        C0574s5 c0574s5 = this.f831a;
        if (this.c.d()) {
            return false;
        }
        if (((C0711xh) c0574s5.k.a()).e) {
            a2 = C0401l6.a(c0401l6, EnumC0680wb.EVENT_TYPE_APP_UPDATE);
        } else {
            a2 = C0401l6.a(c0401l6, EnumC0680wb.EVENT_TYPE_INIT);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appInstaller", (String) WrapUtils.getOrDefault(this.d.getInstallerPackageName(c0574s5.f1048a, c0574s5.b.f934a), ""));
            Hf hf = this.b;
            hf.h.a(hf.f897a);
            jSONObject.put("preloadInfo", ((Ef) hf.c()).b());
        } catch (Throwable unused) {
        }
        a2.setValue(jSONObject.toString());
        F9 f9 = c0574s5.n;
        f9.a(a2, Sk.a(f9.c.b(a2), a2.i));
        uo uoVar = this.c;
        synchronized (uoVar) {
            vo voVar = uoVar.f1091a;
            voVar.a(voVar.a().put("init_event_done", true));
        }
        this.c.a(this.e.currentTimeMillis());
        return false;
    }

    public C0761zh(C0574s5 c0574s5, uo uoVar, Hf hf, SafePackageManager safePackageManager, SystemTimeProvider systemTimeProvider) {
        super(c0574s5);
        this.c = uoVar;
        this.b = hf;
        this.d = safePackageManager;
        this.e = systemTimeProvider;
    }
}
