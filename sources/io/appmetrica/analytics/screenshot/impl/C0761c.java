package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* renamed from: io.appmetrica.analytics.screenshot.impl.c  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0761c implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0762d f1356a;

    public C0761c(C0762d c0762d) {
        this.f1356a = c0762d;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = AbstractC0760b.f1355a[activityEvent.ordinal()];
        try {
            if (i != 1) {
                if (i == 2) {
                    activity.unregisterScreenCaptureCallback(C0762d.d(this.f1356a));
                    return;
                }
            }
            C0768j c0768j = this.f1356a.c;
            if (c0768j == null || !c0768j.f1365a) {
                return;
            }
            activity.registerScreenCaptureCallback(this.f1356a.f1357a.getContext().getMainExecutor(), C0762d.d(this.f1356a));
        } catch (Throwable unused) {
        }
    }
}
