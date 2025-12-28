package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* loaded from: classes5.dex */
public final class E5 implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ F5 f552a;

    public E5(F5 f5) {
        this.f552a = f5;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = D5.f539a[activityEvent.ordinal()];
        if (i == 1) {
            this.f552a.b.resumeSession();
        } else if (i != 2) {
        } else {
            this.f552a.b.pauseSession();
        }
    }
}
