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
    public final /* synthetic */ d0 f1289a;

    public a0(d0 d0Var) {
        this.f1289a = d0Var;
    }

    public static final Boolean a(d0 d0Var, a0 a0Var, C0778m c0778m, ActivityManager activityManager) {
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
            ((C0786v) d0Var.b).a("ServiceScreenshotCaptor");
        }
        return Boolean.valueOf(d0Var.c.postDelayed(a0Var, TimeUnit.SECONDS.toMillis(c0778m.b)));
    }

    @Override // java.lang.Runnable
    public final void run() {
        final C0778m c0778m = this.f1289a.e;
        if (this.f1289a.d || c0778m == null || !c0778m.f1306a) {
            return;
        }
        Context context = this.f1289a.f1295a.getContext();
        final d0 d0Var = this.f1289a;
        SystemServiceUtils.accessSystemServiceByNameSafely(context, "activity", "running service screenshot captor", "ActivityManager", new FunctionWithThrowable() { // from class: io.appmetrica.analytics.screenshot.impl.a0$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
            public final Object apply(Object obj) {
                return a0.a(d0.this, this, c0778m, (ActivityManager) obj);
            }
        });
    }
}
