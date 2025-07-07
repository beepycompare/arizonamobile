package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* loaded from: classes4.dex */
public final class c0 implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d0 f1292a;

    public c0(d0 d0Var) {
        this.f1292a = d0Var;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = b0.f1290a[activityEvent.ordinal()];
        try {
            if (i != 1) {
                if (i == 2) {
                    this.f1292a.d = true;
                    return;
                }
            }
            C0786m c0786m = this.f1292a.e;
            if (c0786m == null || !c0786m.f1305a) {
                return;
            }
            this.f1292a.d = false;
            d0 d0Var = this.f1292a;
            d0Var.c.postDelayed(d0Var.f, 0L);
        } catch (Throwable unused) {
        }
    }
}
