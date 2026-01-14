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
public final class G1 {

    /* renamed from: a  reason: collision with root package name */
    public final SafePackageManager f590a = new SafePackageManager();

    public final Intent a(Context context) {
        Bundle bundle;
        C0151bj c0151bj;
        C0136b4.l().u.getClass();
        Intent data = new Intent(context, AppMetricaService.class).setAction("io.appmetrica.analytics.IAppMetricaService").setData(new Uri.Builder().scheme(G7.b).authority(context.getPackageName()).path("client").appendQueryParameter("pid", String.valueOf(Process.myPid())).appendQueryParameter("psid", Bf.c).build());
        ApplicationInfo applicationInfo = this.f590a.getApplicationInfo(context, context.getPackageName(), 128);
        if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
            bundle = new Bundle();
        }
        Intent putExtras = data.putExtras(bundle);
        C0136b4 l = C0136b4.l();
        synchronized (l) {
            if (l.o == null) {
                C0151bj c0151bj2 = new C0151bj();
                l.o = c0151bj2;
                l.h.a(c0151bj2);
            }
            c0151bj = l.o;
        }
        ScreenInfo b = c0151bj.b(context);
        return putExtras.putExtra("screen_size", b != null ? AbstractC0272gb.a(b) : null);
    }
}
