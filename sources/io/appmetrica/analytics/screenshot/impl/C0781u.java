package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import android.provider.MediaStore;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* renamed from: io.appmetrica.analytics.screenshot.impl.u  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0781u implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0782v f1485a;

    public C0781u(C0782v c0782v) {
        this.f1485a = c0782v;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = AbstractC0780t.f1484a[activityEvent.ordinal()];
        try {
            if (i != 1) {
                if (i == 2) {
                    this.f1485a.f1486a.getContext().getContentResolver().unregisterContentObserver(this.f1485a.d);
                    return;
                }
            }
            C0772k c0772k = this.f1485a.c;
            if (c0772k == null || !c0772k.f1475a) {
                return;
            }
            this.f1485a.f1486a.getContext().getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.f1485a.d);
        } catch (Throwable unused) {
        }
    }
}
