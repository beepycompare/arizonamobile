package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import android.provider.MediaStore;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* loaded from: classes5.dex */
public final class r implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0796s f1458a;

    public r(C0796s c0796s) {
        this.f1458a = c0796s;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = AbstractC0795q.f1457a[activityEvent.ordinal()];
        try {
            if (i != 1) {
                if (i == 2) {
                    this.f1458a.f1459a.getContext().getContentResolver().unregisterContentObserver(this.f1458a.d);
                    return;
                }
            }
            C0788j c0788j = this.f1458a.c;
            if (c0788j == null || !c0788j.f1452a) {
                return;
            }
            this.f1458a.f1459a.getContext().getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.f1458a.d);
        } catch (Throwable unused) {
        }
    }
}
