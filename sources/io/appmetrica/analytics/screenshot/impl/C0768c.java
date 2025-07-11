package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* renamed from: io.appmetrica.analytics.screenshot.impl.c  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0768c implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0769d f1292a;

    public C0768c(C0769d c0769d) {
        this.f1292a = c0769d;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = AbstractC0767b.f1290a[activityEvent.ordinal()];
        try {
            if (i != 1) {
                if (i == 2) {
                    activity.unregisterScreenCaptureCallback(C0769d.d(this.f1292a));
                    return;
                }
            }
            C0774i c0774i = this.f1292a.c;
            if (c0774i == null || !c0774i.f1301a) {
                return;
            }
            activity.registerScreenCaptureCallback(this.f1292a.f1294a.getContext().getMainExecutor(), C0769d.d(this.f1292a));
        } catch (Throwable unused) {
        }
    }
}
