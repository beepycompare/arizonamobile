package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import android.provider.MediaStore;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* renamed from: io.appmetrica.analytics.screenshot.impl.t  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0787t implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0788u f1314a;

    public C0787t(C0788u c0788u) {
        this.f1314a = c0788u;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = AbstractC0786s.f1313a[activityEvent.ordinal()];
        try {
            if (i != 1) {
                if (i == 2) {
                    this.f1314a.f1315a.getContext().getContentResolver().unregisterContentObserver(this.f1314a.d);
                    return;
                }
            }
            C0778j c0778j = this.f1314a.c;
            if (c0778j == null || !c0778j.f1306a) {
                return;
            }
            this.f1314a.f1315a.getContext().getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.f1314a.d);
        } catch (Throwable unused) {
        }
    }
}
