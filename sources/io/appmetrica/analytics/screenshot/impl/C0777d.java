package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import kotlin.Lazy;
import kotlin.LazyKt;
/* renamed from: io.appmetrica.analytics.screenshot.impl.d  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0777d implements P {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1293a;
    public final Q b;
    public volatile C0782i c;
    public final Lazy d = LazyKt.lazy(new C0774a(this));

    public C0777d(ClientContext clientContext, Q q) {
        this.f1293a = clientContext;
        this.b = q;
    }

    public static final Activity.ScreenCaptureCallback d(C0777d c0777d) {
        return (Activity.ScreenCaptureCallback) c0777d.d.getValue();
    }

    @Override // io.appmetrica.analytics.screenshot.impl.P
    public final void a(C0785l c0785l) {
        this.c = c0785l != null ? c0785l.f1304a : null;
    }

    public final String b() {
        return "AndroidApiScreenshotCaptor";
    }

    @Override // io.appmetrica.analytics.screenshot.impl.P
    public final void a() {
        if (AndroidUtils.isApiAchieved(34)) {
            this.f1293a.getActivityLifecycleRegistry().registerListener(new C0776c(this), ActivityEvent.STARTED, ActivityEvent.STOPPED);
        }
    }
}
