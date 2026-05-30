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
public final class J implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ M f1435a;

    public J(M m) {
        this.f1435a = m;
    }

    public static final Boolean a(M m, J j, C0790l c0790l, ActivityManager activityManager) {
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
            ((C0798u) m.b).a("ServiceScreenshotCaptor");
        }
        return Boolean.valueOf(m.c.postDelayed(j, TimeUnit.SECONDS.toMillis(c0790l.b)));
    }

    @Override // java.lang.Runnable
    public final void run() {
        final C0790l c0790l = this.f1435a.e;
        if (this.f1435a.d || c0790l == null || !c0790l.f1452a) {
            return;
        }
        Context context = this.f1435a.f1438a.getContext();
        final M m = this.f1435a;
        SystemServiceUtils.accessSystemServiceByNameSafely(context, "activity", "running service screenshot captor", "ActivityManager", new FunctionWithThrowable() { // from class: io.appmetrica.analytics.screenshot.impl.J$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
            public final Object apply(Object obj) {
                return J.a(M.this, this, c0790l, (ActivityManager) obj);
            }
        });
    }
}
