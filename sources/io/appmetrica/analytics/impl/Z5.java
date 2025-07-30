package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* loaded from: classes4.dex */
public final class Z5 implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0122a6 f744a;

    public Z5(C0122a6 c0122a6) {
        this.f744a = c0122a6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = Y5.f730a[activityEvent.ordinal()];
        if (i == 1) {
            this.f744a.b.resumeSession();
        } else if (i != 2) {
        } else {
            this.f744a.b.pauseSession();
        }
    }
}
