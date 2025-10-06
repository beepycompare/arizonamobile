package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import android.provider.MediaStore;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* renamed from: io.appmetrica.analytics.screenshot.impl.t  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0789t implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0790u f1334a;

    public C0789t(C0790u c0790u) {
        this.f1334a = c0790u;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = AbstractC0788s.f1333a[activityEvent.ordinal()];
        try {
            if (i != 1) {
                if (i == 2) {
                    this.f1334a.f1335a.getContext().getContentResolver().unregisterContentObserver(this.f1334a.d);
                    return;
                }
            }
            C0780j c0780j = this.f1334a.c;
            if (c0780j == null || !c0780j.f1326a) {
                return;
            }
            this.f1334a.f1335a.getContext().getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.f1334a.d);
        } catch (Throwable unused) {
        }
    }
}
