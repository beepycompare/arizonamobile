package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import kotlin.Lazy;
import kotlin.LazyKt;
/* renamed from: io.appmetrica.analytics.screenshot.impl.d  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0769d implements P {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1294a;
    public final Q b;
    public volatile C0774i c;
    public final Lazy d = LazyKt.lazy(new C0766a(this));

    public C0769d(ClientContext clientContext, Q q) {
        this.f1294a = clientContext;
        this.b = q;
    }

    public static final Activity.ScreenCaptureCallback d(C0769d c0769d) {
        return (Activity.ScreenCaptureCallback) c0769d.d.getValue();
    }

    @Override // io.appmetrica.analytics.screenshot.impl.P
    public final void a(C0777l c0777l) {
        this.c = c0777l != null ? c0777l.f1305a : null;
    }

    public final String b() {
        return "AndroidApiScreenshotCaptor";
    }

    @Override // io.appmetrica.analytics.screenshot.impl.P
    public final void a() {
        if (AndroidUtils.isApiAchieved(34)) {
            this.f1294a.getActivityLifecycleRegistry().registerListener(new C0768c(this), ActivityEvent.STARTED, ActivityEvent.STOPPED);
        }
    }
}
