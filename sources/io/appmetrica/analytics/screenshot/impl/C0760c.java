package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* renamed from: io.appmetrica.analytics.screenshot.impl.c  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0760c implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0761d f1441a;

    public C0760c(C0761d c0761d) {
        this.f1441a = c0761d;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = AbstractC0759b.f1440a[activityEvent.ordinal()];
        try {
            if (i != 1) {
                if (i == 2) {
                    activity.unregisterScreenCaptureCallback(C0761d.d(this.f1441a));
                    return;
                }
            }
            C0767j c0767j = this.f1441a.c;
            if (c0767j == null || !c0767j.f1450a) {
                return;
            }
            activity.registerScreenCaptureCallback(this.f1441a.f1442a.getContext().getMainExecutor(), C0761d.d(this.f1441a));
        } catch (Throwable unused) {
        }
    }
}
