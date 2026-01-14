package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* loaded from: classes5.dex */
public final class D5 implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ E5 f544a;

    public D5(E5 e5) {
        this.f544a = e5;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = C5.f531a[activityEvent.ordinal()];
        if (i == 1) {
            this.f544a.b.resumeSession();
        } else if (i != 2) {
        } else {
            this.f544a.b.pauseSession();
        }
    }
}
