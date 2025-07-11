package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import android.provider.MediaStore;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* renamed from: io.appmetrica.analytics.screenshot.impl.t  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0784t implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0785u f1311a;

    public C0784t(C0785u c0785u) {
        this.f1311a = c0785u;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = AbstractC0783s.f1310a[activityEvent.ordinal()];
        try {
            if (i != 1) {
                if (i == 2) {
                    this.f1311a.f1312a.getContext().getContentResolver().unregisterContentObserver(this.f1311a.d);
                    return;
                }
            }
            C0775j c0775j = this.f1311a.c;
            if (c0775j == null || !c0775j.f1303a) {
                return;
            }
            this.f1311a.f1312a.getContext().getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.f1311a.d);
        } catch (Throwable unused) {
        }
    }
}
