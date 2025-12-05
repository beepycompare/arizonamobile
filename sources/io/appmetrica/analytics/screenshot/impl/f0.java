package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* loaded from: classes5.dex */
public final class f0 implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g0 f1446a;

    public f0(g0 g0Var) {
        this.f1446a = g0Var;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = e0.f1445a[activityEvent.ordinal()];
        try {
            if (i != 1) {
                if (i == 2) {
                    this.f1446a.d = true;
                    return;
                }
            }
            C0771n c0771n = this.f1446a.e;
            if (c0771n == null || !c0771n.f1457a) {
                return;
            }
            this.f1446a.d = false;
            g0 g0Var = this.f1446a;
            g0Var.c.postDelayed(g0Var.f, 0L);
        } catch (Throwable unused) {
        }
    }
}
