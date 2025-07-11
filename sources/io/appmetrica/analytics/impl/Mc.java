package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class Mc implements V8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0159bh f535a;
    public final Cif b;
    public final String c = "activation_unlock_event_sending";
    public final AtomicBoolean d;

    public Mc(C0159bh c0159bh, J4 j4, Cif cif) {
        this.f535a = c0159bh;
        this.b = cif;
        boolean z = false;
        this.d = new AtomicBoolean((cif.a(false) || a(j4)) ? true : true);
    }

    public final void a(String str) {
        try {
            Zj zj = AbstractC0736yj.f1149a;
            String str2 = this.c;
            JSONObject put = new JSONObject().put("source", str).put("framework", FrameworkDetector.framework());
            C0254fa h = Ga.F.h();
            Bundle applicationMetaData = h.d.getApplicationMetaData(h.f835a);
            JSONObject put2 = put.put("appmetrica_plugin_id", applicationMetaData != null ? applicationMetaData.getString("io.appmetrica.analytics.plugin_id") : null);
            C0538qk c0538qk = Ga.F.D;
            String jSONObject = put2.put("activation_offset", TimeUnit.SECONDS.convert(c0538qk.f1009a.currentTimeMillis() - c0538qk.b, TimeUnit.MILLISECONDS)).toString();
            zj.getClass();
            zj.a(new Xj(str2, jSONObject));
        } catch (Throwable unused) {
        }
    }

    @Override // io.appmetrica.analytics.impl.V8
    public final boolean b() {
        String str;
        if (!this.d.get() && (str = ((C0659vh) this.f535a.a()).m) != null && !Intrinsics.areEqual(str, "629a824d-c717-4ba5-bc0f-3f3968554d01") && this.d.compareAndSet(false, true)) {
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
        String str = j4.f486a;
        return (str == null || Intrinsics.areEqual(str, "629a824d-c717-4ba5-bc0f-3f3968554d01")) ? false : true;
    }
}
