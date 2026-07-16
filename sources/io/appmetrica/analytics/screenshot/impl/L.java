package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* loaded from: classes5.dex */
public final class L implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ M f1439a;

    public L(M m) {
        this.f1439a = m;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = K.f1438a[activityEvent.ordinal()];
        try {
            if (i != 1) {
                if (i == 2) {
                    this.f1439a.d = true;
                    return;
                }
            }
            C0790l c0790l = this.f1439a.e;
            if (c0790l == null || !c0790l.f1454a) {
                return;
            }
            this.f1439a.d = false;
            M m = this.f1439a;
            m.c.postDelayed(m.f, 0L);
        } catch (Throwable unused) {
        }
    }
}
