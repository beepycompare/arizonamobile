package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import kotlin.Lazy;
import kotlin.LazyKt;
/* renamed from: io.appmetrica.analytics.screenshot.impl.d  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0774d implements P {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1317a;
    public final Q b;
    public volatile C0779i c;
    public final Lazy d = LazyKt.lazy(new C0771a(this));

    public C0774d(ClientContext clientContext, Q q) {
        this.f1317a = clientContext;
        this.b = q;
    }

    public static final Activity.ScreenCaptureCallback d(C0774d c0774d) {
        return (Activity.ScreenCaptureCallback) c0774d.d.getValue();
    }

    @Override // io.appmetrica.analytics.screenshot.impl.P
    public final void a(C0782l c0782l) {
        this.c = c0782l != null ? c0782l.f1328a : null;
    }

    public final String b() {
        return "AndroidApiScreenshotCaptor";
    }

    @Override // io.appmetrica.analytics.screenshot.impl.P
    public final void a() {
        if (AndroidUtils.isApiAchieved(34)) {
            this.f1317a.getActivityLifecycleRegistry().registerListener(new C0773c(this), ActivityEvent.STARTED, ActivityEvent.STOPPED);
        }
    }
}
