package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* loaded from: classes4.dex */
public final class Z5 implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0115a6 f753a;

    public Z5(C0115a6 c0115a6) {
        this.f753a = c0115a6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = Y5.f736a[activityEvent.ordinal()];
        if (i == 1) {
            this.f753a.b.resumeSession();
        } else if (i != 2) {
        } else {
            this.f753a.b.pauseSession();
        }
    }
}
