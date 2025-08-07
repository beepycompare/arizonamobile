package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class Oc implements Y8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0212dh f577a;
    public final C0386kf b;
    public final String c = "activation_unlock_event_sending";
    public final AtomicBoolean d;

    public Oc(C0212dh c0212dh, J4 j4, C0386kf c0386kf) {
        this.f577a = c0212dh;
        this.b = c0386kf;
        boolean z = false;
        this.d = new AtomicBoolean((c0386kf.a(false) || a(j4)) ? true : true);
    }

    public final void a(String str) {
        try {
            C0189ck c0189ck = Bj.f361a;
            String str2 = this.c;
            JSONObject put = new JSONObject().put("source", str).put("framework", FrameworkDetector.framework());
            C0307ha h = Ia.F.h();
            Bundle applicationMetaData = h.d.getApplicationMetaData(h.f881a);
            JSONObject put2 = put.put("appmetrica_plugin_id", applicationMetaData != null ? applicationMetaData.getString("io.appmetrica.analytics.plugin_id") : null);
            C0615tk c0615tk = Ia.F.D;
            String jSONObject = put2.put("activation_offset", TimeUnit.SECONDS.convert(c0615tk.f1069a.currentTimeMillis() - c0615tk.b, TimeUnit.MILLISECONDS)).toString();
            c0189ck.getClass();
            c0189ck.a(new C0137ak(str2, jSONObject));
        } catch (Throwable unused) {
        }
    }

    @Override // io.appmetrica.analytics.impl.Y8
    public final boolean b() {
        String str;
        if (!this.d.get() && (str = ((C0712xh) this.f577a.a()).m) != null && !Intrinsics.areEqual(str, "629a824d-c717-4ba5-bc0f-3f3968554d01") && this.d.compareAndSet(false, true)) {
            this.b.b(true);
            a("activation");
        }
        return this.d.get();
    }

    public final void a() {
        if (this.d.compareAndSet(false, true)) {
            this.b.b(true);
            a("timer");
        }
    }

    public static boolean a(J4 j4) {
        String str = j4.f497a;
        return (str == null || Intrinsics.areEqual(str, "629a824d-c717-4ba5-bc0f-3f3968554d01")) ? false : true;
    }
}
