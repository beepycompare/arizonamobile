package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class fp implements InterfaceC0711xg {

    /* renamed from: a  reason: collision with root package name */
    public final Zo f991a;
    public final String b = "vital";

    public fp(Zo zo) {
        this.f991a = zo;
    }

    public final String a() {
        return this.b;
    }

    public final Lg b() {
        Bg b = this.f991a.b();
        if (b != null) {
            return new Kg(b);
        }
        return null;
    }

    public final boolean c() {
        boolean optBoolean;
        Zo zo = this.f991a;
        synchronized (zo) {
            optBoolean = zo.f881a.a().optBoolean("referrer_checked", false);
        }
        return optBoolean;
    }

    public final void a(Lg lg) {
        this.f991a.a(lg.a());
        Zo zo = this.f991a;
        synchronized (zo) {
            JSONObject a2 = zo.f881a.a();
            if (!a2.optBoolean("referrer_checked", false)) {
                zo.f881a.a(a2.put("referrer_checked", true));
            }
            bp bpVar = zo.f881a;
            bp.a(bpVar.f919a);
            bp.a(bpVar.b);
        }
    }
}
