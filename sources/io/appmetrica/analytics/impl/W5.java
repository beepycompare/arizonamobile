package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* loaded from: classes4.dex */
public final class W5 implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ X5 f681a;

    public W5(X5 x5) {
        this.f681a = x5;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = V5.f669a[activityEvent.ordinal()];
        if (i == 1) {
            this.f681a.b.resumeSession();
        } else if (i != 2) {
        } else {
            this.f681a.b.pauseSession();
        }
    }
}
