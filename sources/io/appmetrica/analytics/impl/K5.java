package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* loaded from: classes5.dex */
public final class K5 implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ L5 f556a;

    public K5(L5 l5) {
        this.f556a = l5;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = J5.f542a[activityEvent.ordinal()];
        if (i == 1) {
            this.f556a.b.resumeSession();
        } else if (i != 2) {
        } else {
            this.f556a.b.pauseSession();
        }
    }
}
