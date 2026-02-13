package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.tc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0600tc implements F8 {

    /* renamed from: a  reason: collision with root package name */
    public final Qg f1235a;
    public final We b;
    public final String c = "activation_unlock_event_sending";
    public final AtomicBoolean d;

    public C0600tc(Qg qg, C0468o4 c0468o4, We we) {
        this.f1235a = qg;
        this.b = we;
        boolean z = false;
        this.d = new AtomicBoolean((we.a(false) || a(c0468o4)) ? true : true);
    }

    public final void a(String str) {
        try {
            Qj qj = AbstractC0483oj.f1158a;
            String str2 = this.c;
            JSONObject put = new JSONObject().put("source", str).put("framework", FrameworkDetector.framework());
            M9 i = C0449na.I.i();
            Bundle applicationMetaData = i.d.getApplicationMetaData(i.f690a);
            JSONObject put2 = put.put("appmetrica_plugin_id", applicationMetaData != null ? applicationMetaData.getString("io.appmetrica.analytics.plugin_id") : null);
            C0434mk c0434mk = C0449na.I.D;
            String jSONObject = put2.put("activation_offset", TimeUnit.SECONDS.convert(c0434mk.f1121a.currentTimeMillis() - c0434mk.b, TimeUnit.MILLISECONDS)).toString();
            qj.getClass();
            qj.a(new Oj(str2, jSONObject));
        } catch (Throwable unused) {
        }
    }

    @Override // io.appmetrica.analytics.impl.F8
    public final boolean b() {
        String str;
        if (!this.d.get() && (str = ((C0381kh) this.f1235a.a()).m) != null && !Intrinsics.areEqual(str, "629a824d-c717-4ba5-bc0f-3f3968554d01") && this.d.compareAndSet(false, true)) {
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

    public static boolean a(C0468o4 c0468o4) {
        String str = c0468o4.f1146a;
        return (str == null || Intrinsics.areEqual(str, "629a824d-c717-4ba5-bc0f-3f3968554d01")) ? false : true;
    }
}
