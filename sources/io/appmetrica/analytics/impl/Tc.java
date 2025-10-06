package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class Tc implements InterfaceC0197d9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0437mh f685a;
    public final C0538qf b;
    public final String c = "activation_unlock_event_sending";
    public final AtomicBoolean d;

    public Tc(C0437mh c0437mh, M4 m4, C0538qf c0538qf) {
        this.f685a = c0437mh;
        this.b = c0538qf;
        boolean z = false;
        this.d = new AtomicBoolean((c0538qf.a(false) || a(m4)) ? true : true);
    }

    public final void a(String str) {
        try {
            C0414lk c0414lk = Kj.f543a;
            String str2 = this.c;
            JSONObject put = new JSONObject().put("source", str).put("framework", FrameworkDetector.framework());
            C0430ma h = Na.F.h();
            Bundle applicationMetaData = h.d.getApplicationMetaData(h.f991a);
            JSONObject put2 = put.put("appmetrica_plugin_id", applicationMetaData != null ? applicationMetaData.getString("io.appmetrica.analytics.plugin_id") : null);
            Ck ck = Na.F.D;
            String jSONObject = put2.put("activation_offset", TimeUnit.SECONDS.convert(ck.f394a.currentTimeMillis() - ck.b, TimeUnit.MILLISECONDS)).toString();
            c0414lk.getClass();
            c0414lk.a(new C0362jk(str2, jSONObject));
        } catch (Throwable unused) {
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0197d9
    public final boolean b() {
        String str;
        if (!this.d.get() && (str = ((Gh) this.f685a.a()).m) != null && !Intrinsics.areEqual(str, "629a824d-c717-4ba5-bc0f-3f3968554d01") && this.d.compareAndSet(false, true)) {
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

    public static boolean a(M4 m4) {
        String str = m4.f571a;
        return (str == null || Intrinsics.areEqual(str, "629a824d-c717-4ba5-bc0f-3f3968554d01")) ? false : true;
    }
}
