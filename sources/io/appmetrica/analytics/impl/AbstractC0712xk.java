package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import io.appmetrica.analytics.coreapi.internal.model.ScreenInfo;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.internal.AppMetricaService;
/* renamed from: io.appmetrica.analytics.impl.xk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0712xk {

    /* renamed from: a  reason: collision with root package name */
    public static final SafePackageManager f1130a = new SafePackageManager();

    public static Intent a(Context context) {
        Bundle bundle;
        C0412lj c0412lj;
        Intent addFlags = new Intent(context, AppMetricaService.class).setAction("io.appmetrica.analytics.IAppMetricaService").setData(new Uri.Builder().scheme("appmetrica").authority(context.getPackageName()).build()).addFlags(32);
        try {
            bundle = f1130a.getApplicationInfo(context, context.getPackageName(), 128).metaData;
            if (bundle == null) {
                bundle = new Bundle();
            }
        } catch (Throwable unused) {
            bundle = new Bundle();
        }
        Intent putExtras = addFlags.putExtras(bundle);
        putExtras.setData(putExtras.getData().buildUpon().path("client").appendQueryParameter("pid", String.valueOf(Process.myPid())).appendQueryParameter("psid", Nf.c).build());
        C0696x4 l = C0696x4.l();
        synchronized (l) {
            if (l.o == null) {
                C0412lj c0412lj2 = new C0412lj();
                l.o = c0412lj2;
                l.h.a(c0412lj2);
            }
            c0412lj = l.o;
        }
        ScreenInfo a2 = c0412lj.a(context);
        putExtras.putExtra("screen_size", a2 == null ? null : AbstractC0753zb.a(a2));
        return putExtras.setPackage(context.getApplicationContext().getPackageName());
    }
}
