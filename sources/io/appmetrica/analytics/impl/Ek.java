package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import io.appmetrica.analytics.coreapi.internal.model.ScreenInfo;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.internal.AppMetricaService;
/* loaded from: classes5.dex */
public abstract class Ek {

    /* renamed from: a  reason: collision with root package name */
    public static final SafePackageManager f463a = new SafePackageManager();

    public static Intent a(Context context) {
        Bundle bundle;
        C0276gj c0276gj;
        Intent addFlags = new Intent(context, AppMetricaService.class).setAction("io.appmetrica.analytics.IAppMetricaService").setData(new Uri.Builder().scheme("appmetrica").authority(context.getPackageName()).build()).addFlags(32);
        try {
            bundle = f463a.getApplicationInfo(context, context.getPackageName(), 128).metaData;
            if (bundle == null) {
                bundle = new Bundle();
            }
        } catch (Throwable unused) {
            bundle = new Bundle();
        }
        Intent putExtras = addFlags.putExtras(bundle);
        putExtras.setData(putExtras.getData().buildUpon().path("client").appendQueryParameter("pid", String.valueOf(Process.myPid())).appendQueryParameter("psid", Gf.c).build());
        C0338j4 l = C0338j4.l();
        synchronized (l) {
            if (l.o == null) {
                C0276gj c0276gj2 = new C0276gj();
                l.o = c0276gj2;
                l.h.a(c0276gj2);
            }
            c0276gj = l.o;
        }
        ScreenInfo a2 = c0276gj.a(context);
        putExtras.putExtra("screen_size", a2 == null ? null : AbstractC0447nb.a(a2));
        return putExtras.setPackage(context.getApplicationContext().getPackageName());
    }
}
