package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* renamed from: io.appmetrica.analytics.screenshot.impl.c  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0763c implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0764d f1469a;

    public C0763c(C0764d c0764d) {
        this.f1469a = c0764d;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = AbstractC0762b.f1468a[activityEvent.ordinal()];
        try {
            if (i != 1) {
                if (i == 2) {
                    activity.unregisterScreenCaptureCallback(C0764d.d(this.f1469a));
                    return;
                }
            }
            C0770j c0770j = this.f1469a.c;
            if (c0770j == null || !c0770j.f1478a) {
                return;
            }
            activity.registerScreenCaptureCallback(this.f1469a.f1470a.getContext().getMainExecutor(), C0764d.d(this.f1469a));
        } catch (Throwable unused) {
        }
    }
}
