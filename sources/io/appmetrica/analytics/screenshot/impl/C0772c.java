package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* renamed from: io.appmetrica.analytics.screenshot.impl.c  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0772c implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0773d f1310a;

    public C0772c(C0773d c0773d) {
        this.f1310a = c0773d;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = AbstractC0771b.f1308a[activityEvent.ordinal()];
        try {
            if (i != 1) {
                if (i == 2) {
                    activity.unregisterScreenCaptureCallback(C0773d.d(this.f1310a));
                    return;
                }
            }
            C0778i c0778i = this.f1310a.c;
            if (c0778i == null || !c0778i.f1319a) {
                return;
            }
            activity.registerScreenCaptureCallback(this.f1310a.f1312a.getContext().getMainExecutor(), C0773d.d(this.f1310a));
        } catch (Throwable unused) {
        }
    }
}
