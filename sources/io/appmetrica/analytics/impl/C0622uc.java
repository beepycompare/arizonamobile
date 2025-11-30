package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.uc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0622uc implements G8 {

    /* renamed from: a  reason: collision with root package name */
    public final Rg f1148a;
    public final Xe b;
    public final String c = "activation_unlock_event_sending";
    public final AtomicBoolean d;

    public C0622uc(Rg rg, C0490p4 c0490p4, Xe xe) {
        this.f1148a = rg;
        this.b = xe;
        boolean z = false;
        this.d = new AtomicBoolean((xe.a(false) || a(c0490p4)) ? true : true);
    }

    public final void a(String str) {
        try {
            Rj rj = AbstractC0505pj.f1071a;
            String str2 = this.c;
            JSONObject put = new JSONObject().put("source", str).put("framework", FrameworkDetector.framework());
            N9 i = C0471oa.I.i();
            Bundle applicationMetaData = i.d.getApplicationMetaData(i.f602a);
            JSONObject put2 = put.put("appmetrica_plugin_id", applicationMetaData != null ? applicationMetaData.getString("io.appmetrica.analytics.plugin_id") : null);
            C0456nk c0456nk = C0471oa.I.D;
            String jSONObject = put2.put("activation_offset", TimeUnit.SECONDS.convert(c0456nk.f1034a.currentTimeMillis() - c0456nk.b, TimeUnit.MILLISECONDS)).toString();
            rj.getClass();
            rj.a(new Pj(str2, jSONObject));
        } catch (Throwable unused) {
        }
    }

    @Override // io.appmetrica.analytics.impl.G8
    public final boolean b() {
        String str;
        if (!this.d.get() && (str = ((C0403lh) this.f1148a.a()).m) != null && !Intrinsics.areEqual(str, "629a824d-c717-4ba5-bc0f-3f3968554d01") && this.d.compareAndSet(false, true)) {
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

    public static boolean a(C0490p4 c0490p4) {
        String str = c0490p4.f1059a;
        return (str == null || Intrinsics.areEqual(str, "629a824d-c717-4ba5-bc0f-3f3968554d01")) ? false : true;
    }
}
