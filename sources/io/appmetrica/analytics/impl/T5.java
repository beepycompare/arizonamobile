package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* loaded from: classes5.dex */
public final class T5 implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ U5 f771a;

    public T5(U5 u5) {
        this.f771a = u5;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = S5.f759a[activityEvent.ordinal()];
        if (i == 1) {
            this.f771a.b.resumeSession();
        } else if (i != 2) {
        } else {
            this.f771a.b.pauseSession();
        }
    }
}
