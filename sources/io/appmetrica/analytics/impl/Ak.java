package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import io.appmetrica.analytics.coreapi.internal.model.ScreenInfo;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.internal.AppMetricaService;
/* loaded from: classes4.dex */
public abstract class Ak {

    /* renamed from: a  reason: collision with root package name */
    public static final SafePackageManager f343a = new SafePackageManager();

    public static Intent a(Context context) {
        Bundle bundle;
        C0489oj c0489oj;
        Intent addFlags = new Intent(context, AppMetricaService.class).setAction("io.appmetrica.analytics.IAppMetricaService").setData(new Uri.Builder().scheme("appmetrica").authority(context.getPackageName()).build()).addFlags(32);
        try {
            bundle = f343a.getApplicationInfo(context, context.getPackageName(), 128).metaData;
            if (bundle == null) {
                bundle = new Bundle();
            }
        } catch (Throwable unused) {
            bundle = new Bundle();
        }
        Intent putExtras = addFlags.putExtras(bundle);
        putExtras.setData(putExtras.getData().buildUpon().path("client").appendQueryParameter("pid", String.valueOf(Process.myPid())).appendQueryParameter("psid", Pf.c).build());
        C0698x4 l = C0698x4.l();
        synchronized (l) {
            if (l.o == null) {
                C0489oj c0489oj2 = new C0489oj();
                l.o = c0489oj2;
                l.h.a(c0489oj2);
            }
            c0489oj = l.o;
        }
        ScreenInfo a2 = c0489oj.a(context);
        putExtras.putExtra("screen_size", a2 == null ? null : Bb.a(a2));
        return putExtras.setPackage(context.getApplicationContext().getPackageName());
    }
}
