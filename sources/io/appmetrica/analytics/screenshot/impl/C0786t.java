package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import android.provider.MediaStore;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* renamed from: io.appmetrica.analytics.screenshot.impl.t  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0786t implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0787u f1315a;

    public C0786t(C0787u c0787u) {
        this.f1315a = c0787u;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = AbstractC0785s.f1314a[activityEvent.ordinal()];
        try {
            if (i != 1) {
                if (i == 2) {
                    this.f1315a.f1316a.getContext().getContentResolver().unregisterContentObserver(this.f1315a.d);
                    return;
                }
            }
            C0777j c0777j = this.f1315a.c;
            if (c0777j == null || !c0777j.f1307a) {
                return;
            }
            this.f1315a.f1316a.getContext().getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.f1315a.d);
        } catch (Throwable unused) {
        }
    }
}
