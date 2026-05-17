package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import android.provider.MediaStore;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* renamed from: io.appmetrica.analytics.screenshot.impl.u  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0780u implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0781v f1490a;

    public C0780u(C0781v c0781v) {
        this.f1490a = c0781v;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = AbstractC0779t.f1489a[activityEvent.ordinal()];
        try {
            if (i != 1) {
                if (i == 2) {
                    this.f1490a.f1491a.getContext().getContentResolver().unregisterContentObserver(this.f1490a.d);
                    return;
                }
            }
            C0771k c0771k = this.f1490a.c;
            if (c0771k == null || !c0771k.f1480a) {
                return;
            }
            this.f1490a.f1491a.getContext().getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.f1490a.d);
        } catch (Throwable unused) {
        }
    }
}
