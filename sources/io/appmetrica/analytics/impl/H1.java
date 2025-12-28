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
    public final SafePackageManager f598a = new SafePackageManager();

    public final Intent a(Context context) {
        Bundle bundle;
        C0172cj c0172cj;
        C0157c4.l().u.getClass();
        Intent data = new Intent(context, AppMetricaService.class).setAction("io.appmetrica.analytics.IAppMetricaService").setData(new Uri.Builder().scheme(H7.b).authority(context.getPackageName()).path("client").appendQueryParameter("pid", String.valueOf(Process.myPid())).appendQueryParameter("psid", Cf.c).build());
        ApplicationInfo applicationInfo = this.f598a.getApplicationInfo(context, context.getPackageName(), 128);
        if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
            bundle = new Bundle();
        }
        Intent putExtras = data.putExtras(bundle);
        C0157c4 l = C0157c4.l();
        synchronized (l) {
            if (l.o == null) {
                C0172cj c0172cj2 = new C0172cj();
                l.o = c0172cj2;
                l.h.a(c0172cj2);
            }
            c0172cj = l.o;
        }
        ScreenInfo b = c0172cj.b(context);
        return putExtras.putExtra("screen_size", b != null ? AbstractC0293hb.a(b) : null);
    }
}
