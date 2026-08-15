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
    public final C0278gh f792a;
    public final C0690wf b;
    public final String c = "activation_unlock_event_sending";
    public final AtomicBoolean d;

    public Uc(C0278gh c0278gh, F4 f4, C0690wf c0690wf) {
        this.f792a = c0278gh;
        this.b = c0690wf;
        boolean z = false;
        this.d = new AtomicBoolean((c0690wf.a(false) || a(f4)) ? true : true);
    }

    public final void a(String str) {
        try {
            C0540qk c0540qk = Oj.f708a;
            String str2 = this.c;
            JSONObject put = new JSONObject().put("source", str).put("framework", FrameworkDetector.framework());
            C0297ha i = Na.I.i();
            Bundle applicationMetaData = i.d.getApplicationMetaData(i.f1013a);
            JSONObject put2 = put.put("appmetrica_plugin_id", applicationMetaData != null ? applicationMetaData.getString("io.appmetrica.analytics.plugin_id") : null);
            Ok ok = Na.I.D;
            String jSONObject = put2.put("activation_offset", TimeUnit.SECONDS.convert(ok.f709a.currentTimeMillis() - ok.b, TimeUnit.MILLISECONDS)).toString();
            c0540qk.getClass();
            c0540qk.a(new C0488ok(str2, jSONObject));
        } catch (Throwable unused) {
        }
    }

    @Override // io.appmetrica.analytics.impl.Z8
    public final boolean b() {
        String str;
        if (!this.d.get() && (str = ((Eh) this.f792a.a()).m) != null && !Intrinsics.areEqual(str, "629a824d-c717-4ba5-bc0f-3f3968554d01") && this.d.compareAndSet(false, true)) {
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
        String str = f4.f540a;
        return (str == null || Intrinsics.areEqual(str, "629a824d-c717-4ba5-bc0f-3f3968554d01")) ? false : true;
    }
}
