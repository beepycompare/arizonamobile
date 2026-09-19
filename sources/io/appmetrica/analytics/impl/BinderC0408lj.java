package io.appmetrica.analytics.impl;

import kotlin.text.StringsKt;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.lj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class BinderC0408lj extends Ka {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0460nj f1085a;
    public final /* synthetic */ ServiceConnectionC0434mj b;

    public BinderC0408lj(C0460nj c0460nj, ServiceConnectionC0434mj serviceConnectionC0434mj) {
        this.f1085a = c0460nj;
        this.b = serviceConnectionC0434mj;
    }

    @Override // io.appmetrica.analytics.impl.Ka
    public final void a(String str) {
        Lg jg;
        C0460nj.a(this.f1085a, this.b);
        Dg dg = this.b.f1101a;
        this.f1085a.getClass();
        if (str != null && !StringsKt.isBlank(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("REFERRER_ID_KEY");
                if (StringsKt.isBlank(string)) {
                    jg = new Jg("RuStore referrer id is empty", null, 2, null);
                } else {
                    jg = new Kg(new Bg(string, jSONObject.optLong("RECEIVED_TIMESTAMP_KEY") / 1000, jSONObject.optLong("INSTALL_APP_TIMESTAMP_KEY") / 1000, 4));
                }
            } catch (Throwable th) {
                jg = new Jg("Failed to parse RuStore referrer payload", th);
            }
        } else {
            jg = new Jg("RuStore referrer payload is empty", null, 2, null);
        }
        dg.a(jg);
    }

    @Override // io.appmetrica.analytics.impl.Ka
    public final void a(int i, String str) {
        C0460nj.a(this.f1085a, this.b);
        this.b.f1101a.a(new Jg("RuStore referrer error " + i + ": " + str, null, 2, null));
    }
}
