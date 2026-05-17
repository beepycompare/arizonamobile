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
/* loaded from: classes5.dex */
public final class d0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g0 f1471a;

    public d0(g0 g0Var) {
        this.f1471a = g0Var;
    }

    public static final Boolean a(g0 g0Var, d0 d0Var, C0774n c0774n, ActivityManager activityManager) {
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
            ((C0783x) g0Var.b).a("ServiceScreenshotCaptor");
        }
        return Boolean.valueOf(g0Var.c.postDelayed(d0Var, TimeUnit.SECONDS.toMillis(c0774n.b)));
    }

    @Override // java.lang.Runnable
    public final void run() {
        final C0774n c0774n = this.f1471a.e;
        if (this.f1471a.d || c0774n == null || !c0774n.f1485a) {
            return;
        }
        Context context = this.f1471a.f1475a.getContext();
        final g0 g0Var = this.f1471a;
        SystemServiceUtils.accessSystemServiceByNameSafely(context, "activity", "running service screenshot captor", "ActivityManager", new FunctionWithThrowable() { // from class: io.appmetrica.analytics.screenshot.impl.d0$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
            public final Object apply(Object obj) {
                return d0.a(g0.this, this, c0774n, (ActivityManager) obj);
            }
        });
    }
}
