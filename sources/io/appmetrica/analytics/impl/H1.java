package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import io.appmetrica.analytics.coreapi.internal.model.ScreenInfo;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.internal.AppMetricaService;
/* loaded from: classes5.dex */
public final class H1 {

    /* renamed from: a  reason: collision with root package name */
    public final SafePackageManager f500a = new SafePackageManager();

    public final Intent a(Context context) {
        Bundle bundle;
        C0173cj c0173cj;
        C0158c4.l().u.getClass();
        Intent data = new Intent(context, AppMetricaService.class).setAction("io.appmetrica.analytics.IAppMetricaService").setData(new Uri.Builder().scheme(H7.b).authority(context.getPackageName()).path("client").appendQueryParameter("pid", String.valueOf(Process.myPid())).appendQueryParameter("psid", Cf.c).build());
        ApplicationInfo applicationInfo = this.f500a.getApplicationInfo(context, context.getPackageName(), 128);
        if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
            bundle = new Bundle();
        }
        Intent putExtras = data.putExtras(bundle);
        C0158c4 l = C0158c4.l();
        synchronized (l) {
            if (l.o == null) {
                C0173cj c0173cj2 = new C0173cj();
                l.o = c0173cj2;
                l.h.a(c0173cj2);
            }
            c0173cj = l.o;
        }
        ScreenInfo b = c0173cj.b(context);
        return putExtras.putExtra("screen_size", b != null ? AbstractC0294hb.a(b) : null);
    }
}
