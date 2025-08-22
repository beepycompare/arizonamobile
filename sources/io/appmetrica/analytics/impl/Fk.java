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
public abstract class Fk {

    /* renamed from: a  reason: collision with root package name */
    public static final SafePackageManager f439a = new SafePackageManager();

    public static Intent a(Context context) {
        Bundle bundle;
        C0611tj c0611tj;
        Intent addFlags = new Intent(context, AppMetricaService.class).setAction("io.appmetrica.analytics.IAppMetricaService").setData(new Uri.Builder().scheme("appmetrica").authority(context.getPackageName()).build()).addFlags(32);
        try {
            bundle = f439a.getApplicationInfo(context, context.getPackageName(), 128).metaData;
            if (bundle == null) {
                bundle = new Bundle();
            }
        } catch (Throwable unused) {
            bundle = new Bundle();
        }
        Intent putExtras = addFlags.putExtras(bundle);
        putExtras.setData(putExtras.getData().buildUpon().path("client").appendQueryParameter("pid", String.valueOf(Process.myPid())).appendQueryParameter("psid", Rf.c).build());
        C0696x4 l = C0696x4.l();
        synchronized (l) {
            if (l.o == null) {
                C0611tj c0611tj2 = new C0611tj();
                l.o = c0611tj2;
                l.h.a(c0611tj2);
            }
            c0611tj = l.o;
        }
        ScreenInfo a2 = c0611tj.a(context);
        putExtras.putExtra("screen_size", a2 == null ? null : Db.a(a2));
        return putExtras.setPackage(context.getApplicationContext().getPackageName());
    }
}
