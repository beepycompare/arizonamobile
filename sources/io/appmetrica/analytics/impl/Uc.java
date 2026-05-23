package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Uc implements Z8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0279gh f789a;
    public final C0691wf b;
    public final String c = "activation_unlock_event_sending";
    public final AtomicBoolean d;

    public Uc(C0279gh c0279gh, F4 f4, C0691wf c0691wf) {
        this.f789a = c0279gh;
        this.b = c0691wf;
        boolean z = false;
        this.d = new AtomicBoolean((c0691wf.a(false) || a(f4)) ? true : true);
    }

    public final void a(String str) {
        try {
            C0541qk c0541qk = Oj.f705a;
            String str2 = this.c;
            JSONObject put = new JSONObject().put("source", str).put("framework", FrameworkDetector.framework());
            C0298ha i = Na.I.i();
            Bundle applicationMetaData = i.d.getApplicationMetaData(i.f1010a);
            JSONObject put2 = put.put("appmetrica_plugin_id", applicationMetaData != null ? applicationMetaData.getString("io.appmetrica.analytics.plugin_id") : null);
            Ok ok = Na.I.D;
            String jSONObject = put2.put("activation_offset", TimeUnit.SECONDS.convert(ok.f706a.currentTimeMillis() - ok.b, TimeUnit.MILLISECONDS)).toString();
            c0541qk.getClass();
            c0541qk.a(new C0489ok(str2, jSONObject));
        } catch (Throwable unused) {
        }
    }

    @Override // io.appmetrica.analytics.impl.Z8
    public final boolean b() {
        String str;
        if (!this.d.get() && (str = ((Eh) this.f789a.a()).m) != null && !Intrinsics.areEqual(str, "629a824d-c717-4ba5-bc0f-3f3968554d01") && this.d.compareAndSet(false, true)) {
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

    public static boolean a(F4 f4) {
        String str = f4.f537a;
        return (str == null || Intrinsics.areEqual(str, "629a824d-c717-4ba5-bc0f-3f3968554d01")) ? false : true;
    }
}
