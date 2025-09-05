package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import android.provider.MediaStore;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* renamed from: io.appmetrica.analytics.screenshot.impl.t  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0788t implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0789u f1329a;

    public C0788t(C0789u c0789u) {
        this.f1329a = c0789u;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = AbstractC0787s.f1328a[activityEvent.ordinal()];
        try {
            if (i != 1) {
                if (i == 2) {
                    this.f1329a.f1330a.getContext().getContentResolver().unregisterContentObserver(this.f1329a.d);
                    return;
                }
            }
            C0779j c0779j = this.f1329a.c;
            if (c0779j == null || !c0779j.f1321a) {
                return;
            }
            this.f1329a.f1330a.getContext().getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.f1329a.d);
        } catch (Throwable unused) {
        }
    }
}
