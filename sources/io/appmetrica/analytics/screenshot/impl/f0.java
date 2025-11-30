package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* loaded from: classes5.dex */
public final class f0 implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g0 f1363a;

    public f0(g0 g0Var) {
        this.f1363a = g0Var;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = e0.f1362a[activityEvent.ordinal()];
        try {
            if (i != 1) {
                if (i == 2) {
                    this.f1363a.d = true;
                    return;
                }
            }
            C0772n c0772n = this.f1363a.e;
            if (c0772n == null || !c0772n.f1374a) {
                return;
            }
            this.f1363a.d = false;
            g0 g0Var = this.f1363a;
            g0Var.c.postDelayed(g0Var.f, 0L);
        } catch (Throwable unused) {
        }
    }
}
