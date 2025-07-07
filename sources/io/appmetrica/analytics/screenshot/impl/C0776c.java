package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* renamed from: io.appmetrica.analytics.screenshot.impl.c  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0776c implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0777d f1291a;

    public C0776c(C0777d c0777d) {
        this.f1291a = c0777d;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = AbstractC0775b.f1289a[activityEvent.ordinal()];
        try {
            if (i != 1) {
                if (i == 2) {
                    activity.unregisterScreenCaptureCallback(C0777d.d(this.f1291a));
                    return;
                }
            }
            C0782i c0782i = this.f1291a.c;
            if (c0782i == null || !c0782i.f1300a) {
                return;
            }
            activity.registerScreenCaptureCallback(this.f1291a.f1293a.getContext().getMainExecutor(), C0777d.d(this.f1291a));
        } catch (Throwable unused) {
        }
    }
}
