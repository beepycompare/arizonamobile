package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import android.provider.MediaStore;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* renamed from: io.appmetrica.analytics.screenshot.impl.t  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0792t implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0793u f1310a;

    public C0792t(C0793u c0793u) {
        this.f1310a = c0793u;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = AbstractC0791s.f1309a[activityEvent.ordinal()];
        try {
            if (i != 1) {
                if (i == 2) {
                    this.f1310a.f1311a.getContext().getContentResolver().unregisterContentObserver(this.f1310a.d);
                    return;
                }
            }
            C0783j c0783j = this.f1310a.c;
            if (c0783j == null || !c0783j.f1302a) {
                return;
            }
            this.f1310a.f1311a.getContext().getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.f1310a.d);
        } catch (Throwable unused) {
        }
    }
}
