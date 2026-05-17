package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import kotlin.Lazy;
import kotlin.LazyKt;
/* renamed from: io.appmetrica.analytics.screenshot.impl.d  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0764d implements T {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1470a;
    public final U b;
    public volatile C0770j c;
    public final Lazy d = LazyKt.lazy(new C0761a(this));

    public C0764d(ClientContext clientContext, U u) {
        this.f1470a = clientContext;
        this.b = u;
    }

    public static final Activity.ScreenCaptureCallback d(C0764d c0764d) {
        return (Activity.ScreenCaptureCallback) c0764d.d.getValue();
    }

    @Override // io.appmetrica.analytics.screenshot.impl.T
    public final void a(C0773m c0773m) {
        this.c = c0773m != null ? c0773m.f1484a : null;
    }

    public final String b() {
        return "AndroidApiScreenshotCaptor";
    }

    @Override // io.appmetrica.analytics.screenshot.impl.T
    public final void a() {
        if (AndroidUtils.isApiAchieved(34)) {
            this.f1470a.getActivityLifecycleRegistry().registerListener(new C0763c(this), ActivityEvent.STARTED, ActivityEvent.STOPPED);
        }
    }
}
