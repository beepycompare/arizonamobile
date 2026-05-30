package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class fp implements InterfaceC0718xg {

    /* renamed from: a  reason: collision with root package name */
    public final Zo f986a;
    public final String b = "vital";

    public fp(Zo zo) {
        this.f986a = zo;
    }

    public final String a() {
        return this.b;
    }

    public final Lg b() {
        Bg b = this.f986a.b();
        if (b != null) {
            return new Kg(b);
        }
        return null;
    }

    public final boolean c() {
        boolean optBoolean;
        Zo zo = this.f986a;
        synchronized (zo) {
            optBoolean = zo.f876a.a().optBoolean("referrer_checked", false);
        }
        return optBoolean;
    }

    public final void a(Lg lg) {
        this.f986a.a(lg.a());
        Zo zo = this.f986a;
        synchronized (zo) {
            JSONObject a2 = zo.f876a.a();
            if (!a2.optBoolean("referrer_checked", false)) {
                zo.f876a.a(a2.put("referrer_checked", true));
            }
            bp bpVar = zo.f876a;
            bp.a(bpVar.f914a);
            bp.a(bpVar.b);
        }
    }
}
