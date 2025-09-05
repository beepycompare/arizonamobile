package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import kotlin.Lazy;
import kotlin.LazyKt;
/* renamed from: io.appmetrica.analytics.screenshot.impl.d  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0773d implements P {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1312a;
    public final Q b;
    public volatile C0778i c;
    public final Lazy d = LazyKt.lazy(new C0770a(this));

    public C0773d(ClientContext clientContext, Q q) {
        this.f1312a = clientContext;
        this.b = q;
    }

    public static final Activity.ScreenCaptureCallback d(C0773d c0773d) {
        return (Activity.ScreenCaptureCallback) c0773d.d.getValue();
    }

    @Override // io.appmetrica.analytics.screenshot.impl.P
    public final void a(C0781l c0781l) {
        this.c = c0781l != null ? c0781l.f1323a : null;
    }

    public final String b() {
        return "AndroidApiScreenshotCaptor";
    }

    @Override // io.appmetrica.analytics.screenshot.impl.P
    public final void a() {
        if (AndroidUtils.isApiAchieved(34)) {
            this.f1312a.getActivityLifecycleRegistry().registerListener(new C0772c(this), ActivityEvent.STARTED, ActivityEvent.STOPPED);
        }
    }
}
