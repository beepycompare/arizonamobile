package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import kotlin.Lazy;
import kotlin.LazyKt;
/* renamed from: io.appmetrica.analytics.screenshot.impl.d  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0782d implements B {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1450a;
    public final C b;
    public volatile C0787i c;
    public final Lazy d = LazyKt.lazy(new C0779a(this));

    public C0782d(ClientContext clientContext, C c) {
        this.f1450a = clientContext;
        this.b = c;
    }

    public static final Activity.ScreenCaptureCallback d(C0782d c0782d) {
        return (Activity.ScreenCaptureCallback) c0782d.d.getValue();
    }

    @Override // io.appmetrica.analytics.screenshot.impl.B
    public final void a(C0789k c0789k) {
        this.c = c0789k != null ? c0789k.b : null;
    }

    public final String b() {
        return "AndroidApiScreenshotCaptor";
    }

    @Override // io.appmetrica.analytics.screenshot.impl.B
    public final void a() {
        if (AndroidUtils.isApiAchieved(34)) {
            this.f1450a.getActivityLifecycleRegistry().registerListener(new C0781c(this), ActivityEvent.STARTED, ActivityEvent.STOPPED);
        }
    }
}
