package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import kotlin.Lazy;
import kotlin.LazyKt;
/* renamed from: io.appmetrica.analytics.screenshot.impl.d  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0765d implements T {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1466a;
    public final U b;
    public volatile C0771j c;
    public final Lazy d = LazyKt.lazy(new C0762a(this));

    public C0765d(ClientContext clientContext, U u) {
        this.f1466a = clientContext;
        this.b = u;
    }

    public static final Activity.ScreenCaptureCallback d(C0765d c0765d) {
        return (Activity.ScreenCaptureCallback) c0765d.d.getValue();
    }

    @Override // io.appmetrica.analytics.screenshot.impl.T
    public final void a(C0774m c0774m) {
        this.c = c0774m != null ? c0774m.f1480a : null;
    }

    public final String b() {
        return "AndroidApiScreenshotCaptor";
    }

    @Override // io.appmetrica.analytics.screenshot.impl.T
    public final void a() {
        if (AndroidUtils.isApiAchieved(34)) {
            this.f1466a.getActivityLifecycleRegistry().registerListener(new C0764c(this), ActivityEvent.STARTED, ActivityEvent.STOPPED);
        }
    }
}
