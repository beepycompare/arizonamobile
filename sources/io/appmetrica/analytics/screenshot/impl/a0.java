package io.appmetrica.analytics.screenshot.impl;

import android.app.ActivityManager;
import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class a0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d0 f1292a;

    public a0(d0 d0Var) {
        this.f1292a = d0Var;
    }

    public static final Boolean a(d0 d0Var, a0 a0Var, C0780m c0780m, ActivityManager activityManager) {
        Object obj;
        List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(200);
        if (runningServices == null) {
            runningServices = CollectionsKt.emptyList();
        }
        for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
        }
        Iterator<T> it = runningServices.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((ActivityManager.RunningServiceInfo) obj).process, "com.android.systemui:screenshot")) {
                break;
            }
        }
        if (((ActivityManager.RunningServiceInfo) obj) != null) {
            ((C0788v) d0Var.b).a("ServiceScreenshotCaptor");
        }
        return Boolean.valueOf(d0Var.c.postDelayed(a0Var, TimeUnit.SECONDS.toMillis(c0780m.b)));
    }

    @Override // java.lang.Runnable
    public final void run() {
        final C0780m c0780m = this.f1292a.e;
        if (this.f1292a.d || c0780m == null || !c0780m.f1309a) {
            return;
        }
        Context context = this.f1292a.f1298a.getContext();
        final d0 d0Var = this.f1292a;
        SystemServiceUtils.accessSystemServiceByNameSafely(context, "activity", "running service screenshot captor", "ActivityManager", new FunctionWithThrowable() { // from class: io.appmetrica.analytics.screenshot.impl.a0$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
            public final Object apply(Object obj) {
                return a0.a(d0.this, this, c0780m, (ActivityManager) obj);
            }
        });
    }
}
