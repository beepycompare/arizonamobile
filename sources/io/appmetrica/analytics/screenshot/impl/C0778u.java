package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import android.provider.MediaStore;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* renamed from: io.appmetrica.analytics.screenshot.impl.u  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0778u implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0779v f1379a;

    public C0778u(C0779v c0779v) {
        this.f1379a = c0779v;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = AbstractC0777t.f1378a[activityEvent.ordinal()];
        try {
            if (i != 1) {
                if (i == 2) {
                    this.f1379a.f1380a.getContext().getContentResolver().unregisterContentObserver(this.f1379a.d);
                    return;
                }
            }
            C0769k c0769k = this.f1379a.c;
            if (c0769k == null || !c0769k.f1369a) {
                return;
            }
            this.f1379a.f1380a.getContext().getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.f1379a.d);
        } catch (Throwable unused) {
        }
    }
}
