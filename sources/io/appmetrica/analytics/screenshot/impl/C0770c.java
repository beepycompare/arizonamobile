package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* renamed from: io.appmetrica.analytics.screenshot.impl.c  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0770c implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0771d f1295a;

    public C0770c(C0771d c0771d) {
        this.f1295a = c0771d;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = AbstractC0769b.f1293a[activityEvent.ordinal()];
        try {
            if (i != 1) {
                if (i == 2) {
                    activity.unregisterScreenCaptureCallback(C0771d.d(this.f1295a));
                    return;
                }
            }
            C0776i c0776i = this.f1295a.c;
            if (c0776i == null || !c0776i.f1304a) {
                return;
            }
            activity.registerScreenCaptureCallback(this.f1295a.f1297a.getContext().getMainExecutor(), C0771d.d(this.f1295a));
        } catch (Throwable unused) {
        }
    }
}
