package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* renamed from: io.appmetrica.analytics.impl.c6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0167c6 implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0193d6 f816a;

    public C0167c6(C0193d6 c0193d6) {
        this.f816a = c0193d6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = AbstractC0141b6.f801a[activityEvent.ordinal()];
        if (i == 1) {
            this.f816a.b.resumeSession();
        } else if (i != 2) {
        } else {
            this.f816a.b.pauseSession();
        }
    }
}
