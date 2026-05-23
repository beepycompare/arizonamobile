package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Process;
import io.appmetrica.analytics.coreapi.internal.model.ScreenInfo;
import io.appmetrica.analytics.internal.AppMetricaService;
/* loaded from: classes5.dex */
public final class T1 {
    public static Intent a(Context context) {
        Cj cj;
        C0576s4.l().v.getClass();
        Intent data = new Intent(context, AppMetricaService.class).setAction("io.appmetrica.analytics.IAppMetricaService").setData(new Uri.Builder().scheme(Y7.b).authority(context.getPackageName()).path("client").appendQueryParameter("pid", String.valueOf(Process.myPid())).appendQueryParameter("psid", C0175cg.c).build());
        C0576s4 l = C0576s4.l();
        synchronized (l) {
            if (l.p == null) {
                Cj cj2 = new Cj();
                l.p = cj2;
                l.h.a(cj2);
            }
            cj = l.p;
        }
        ScreenInfo a2 = cj.a(context);
        return data.putExtra("screen_size", a2 != null ? Ib.a(a2) : null);
    }
}
