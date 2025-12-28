package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import android.provider.MediaStore;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* renamed from: io.appmetrica.analytics.screenshot.impl.u  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0777u implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0778v f1477a;

    public C0777u(C0778v c0778v) {
        this.f1477a = c0778v;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = AbstractC0776t.f1476a[activityEvent.ordinal()];
        try {
            if (i != 1) {
                if (i == 2) {
                    this.f1477a.f1478a.getContext().getContentResolver().unregisterContentObserver(this.f1477a.d);
                    return;
                }
            }
            C0768k c0768k = this.f1477a.c;
            if (c0768k == null || !c0768k.f1467a) {
                return;
            }
            this.f1477a.f1478a.getContext().getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.f1477a.d);
        } catch (Throwable unused) {
        }
    }
}
