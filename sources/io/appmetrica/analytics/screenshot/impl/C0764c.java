package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* renamed from: io.appmetrica.analytics.screenshot.impl.c  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0764c implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0765d f1464a;

    public C0764c(C0765d c0765d) {
        this.f1464a = c0765d;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = AbstractC0763b.f1463a[activityEvent.ordinal()];
        try {
            if (i != 1) {
                if (i == 2) {
                    activity.unregisterScreenCaptureCallback(C0765d.d(this.f1464a));
                    return;
                }
            }
            C0771j c0771j = this.f1464a.c;
            if (c0771j == null || !c0771j.f1473a) {
                return;
            }
            activity.registerScreenCaptureCallback(this.f1464a.f1465a.getContext().getMainExecutor(), C0765d.d(this.f1464a));
        } catch (Throwable unused) {
        }
    }
}
