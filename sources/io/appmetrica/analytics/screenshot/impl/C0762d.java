package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import kotlin.Lazy;
import kotlin.LazyKt;
/* renamed from: io.appmetrica.analytics.screenshot.impl.d  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0762d implements T {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1357a;
    public final U b;
    public volatile C0768j c;
    public final Lazy d = LazyKt.lazy(new C0759a(this));

    public C0762d(ClientContext clientContext, U u) {
        this.f1357a = clientContext;
        this.b = u;
    }

    public static final Activity.ScreenCaptureCallback d(C0762d c0762d) {
        return (Activity.ScreenCaptureCallback) c0762d.d.getValue();
    }

    @Override // io.appmetrica.analytics.screenshot.impl.T
    public final void a(C0771m c0771m) {
        this.c = c0771m != null ? c0771m.f1371a : null;
    }

    public final String b() {
        return "AndroidApiScreenshotCaptor";
    }

    @Override // io.appmetrica.analytics.screenshot.impl.T
    public final void a() {
        if (AndroidUtils.isApiAchieved(34)) {
            this.f1357a.getActivityLifecycleRegistry().registerListener(new C0761c(this), ActivityEvent.STARTED, ActivityEvent.STOPPED);
        }
    }
}
