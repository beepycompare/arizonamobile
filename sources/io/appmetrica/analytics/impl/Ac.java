package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Ac implements K8 {

    /* renamed from: a  reason: collision with root package name */
    public final Vg f395a;
    public final C0143bf b;
    public final String c = "activation_unlock_event_sending";
    public final AtomicBoolean d;

    public Ac(Vg vg, C0639v4 c0639v4, C0143bf c0143bf) {
        this.f395a = vg;
        this.b = c0143bf;
        boolean z = false;
        this.d = new AtomicBoolean((c0143bf.a(false) || a(c0639v4)) ? true : true);
    }

    public final void a(String str) {
        try {
            Vj vj = AbstractC0604tj.f1136a;
            String str2 = this.c;
            JSONObject put = new JSONObject().put("source", str).put("framework", FrameworkDetector.framework());
            T9 i = C0620ua.H.i();
            Bundle applicationMetaData = i.d.getApplicationMetaData(i.f702a);
            JSONObject put2 = put.put("appmetrica_plugin_id", applicationMetaData != null ? applicationMetaData.getString("io.appmetrica.analytics.plugin_id") : null);
            C0531qk c0531qk = C0620ua.H.D;
            String jSONObject = put2.put("activation_offset", TimeUnit.SECONDS.convert(c0531qk.f1078a.currentTimeMillis() - c0531qk.b, TimeUnit.MILLISECONDS)).toString();
            vj.getClass();
            vj.a(new Tj(str2, jSONObject));
        } catch (Throwable unused) {
        }
    }

    @Override // io.appmetrica.analytics.impl.K8
    public final boolean b() {
        String str;
        if (!this.d.get() && (str = ((C0503ph) this.f395a.a()).m) != null && !Intrinsics.areEqual(str, "629a824d-c717-4ba5-bc0f-3f3968554d01") && this.d.compareAndSet(false, true)) {
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

    public static boolean a(C0639v4 c0639v4) {
        String str = c0639v4.f1162a;
        return (str == null || Intrinsics.areEqual(str, "629a824d-c717-4ba5-bc0f-3f3968554d01")) ? false : true;
    }
}
