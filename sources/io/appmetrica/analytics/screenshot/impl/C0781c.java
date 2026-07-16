package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* renamed from: io.appmetrica.analytics.screenshot.impl.c  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0781c implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0782d f1449a;

    public C0781c(C0782d c0782d) {
        this.f1449a = c0782d;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = AbstractC0780b.f1448a[activityEvent.ordinal()];
        try {
            if (i != 1) {
                if (i == 2) {
                    activity.unregisterScreenCaptureCallback(C0782d.d(this.f1449a));
                    return;
                }
            }
            C0787i c0787i = this.f1449a.c;
            if (c0787i == null || !c0787i.f1451a) {
                return;
            }
            activity.registerScreenCaptureCallback(this.f1449a.f1450a.getContext().getMainExecutor(), C0782d.d(this.f1449a));
        } catch (Throwable unused) {
        }
    }
}
