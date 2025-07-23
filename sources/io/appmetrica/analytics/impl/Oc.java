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
    public final C0211dh f577a;
    public final C0385kf b;
    public final String c = "activation_unlock_event_sending";
    public final AtomicBoolean d;

    public Oc(C0211dh c0211dh, J4 j4, C0385kf c0385kf) {
        this.f577a = c0211dh;
        this.b = c0385kf;
        boolean z = false;
        this.d = new AtomicBoolean((c0385kf.a(false) || a(j4)) ? true : true);
    }

    public final void a(String str) {
        try {
            C0188ck c0188ck = Bj.f361a;
            String str2 = this.c;
            JSONObject put = new JSONObject().put("source", str).put("framework", FrameworkDetector.framework());
            C0306ha h = Ia.F.h();
            Bundle applicationMetaData = h.d.getApplicationMetaData(h.f881a);
            JSONObject put2 = put.put("appmetrica_plugin_id", applicationMetaData != null ? applicationMetaData.getString("io.appmetrica.analytics.plugin_id") : null);
            C0614tk c0614tk = Ia.F.D;
            String jSONObject = put2.put("activation_offset", TimeUnit.SECONDS.convert(c0614tk.f1069a.currentTimeMillis() - c0614tk.b, TimeUnit.MILLISECONDS)).toString();
            c0188ck.getClass();
            c0188ck.a(new C0136ak(str2, jSONObject));
        } catch (Throwable unused) {
        }
    }

    @Override // io.appmetrica.analytics.impl.Y8
    public final boolean b() {
        String str;
        if (!this.d.get() && (str = ((C0711xh) this.f577a.a()).m) != null && !Intrinsics.areEqual(str, "629a824d-c717-4ba5-bc0f-3f3968554d01") && this.d.compareAndSet(false, true)) {
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
