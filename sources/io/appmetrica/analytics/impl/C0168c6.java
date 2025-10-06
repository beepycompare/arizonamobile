package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* renamed from: io.appmetrica.analytics.impl.c6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0168c6 implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0194d6 f821a;

    public C0168c6(C0194d6 c0194d6) {
        this.f821a = c0194d6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        int i = AbstractC0142b6.f806a[activityEvent.ordinal()];
        if (i == 1) {
            this.f821a.b.resumeSession();
        } else if (i != 2) {
        } else {
            this.f821a.b.pauseSession();
        }
    }
}
