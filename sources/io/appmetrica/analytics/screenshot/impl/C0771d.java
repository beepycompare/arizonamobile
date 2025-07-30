package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import kotlin.Lazy;
import kotlin.LazyKt;
/* renamed from: io.appmetrica.analytics.screenshot.impl.d  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0771d implements P {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1298a;
    public final Q b;
    public volatile C0776i c;
    public final Lazy d = LazyKt.lazy(new C0768a(this));

    public C0771d(ClientContext clientContext, Q q) {
        this.f1298a = clientContext;
        this.b = q;
    }

    public static final Activity.ScreenCaptureCallback d(C0771d c0771d) {
        return (Activity.ScreenCaptureCallback) c0771d.d.getValue();
    }

    @Override // io.appmetrica.analytics.screenshot.impl.P
    public final void a(C0779l c0779l) {
        this.c = c0779l != null ? c0779l.f1309a : null;
    }

    public final String b() {
        return "AndroidApiScreenshotCaptor";
    }

    @Override // io.appmetrica.analytics.screenshot.impl.P
    public final void a() {
        if (AndroidUtils.isApiAchieved(34)) {
            this.f1298a.getActivityLifecycleRegistry().registerListener(new C0770c(this), ActivityEvent.STARTED, ActivityEvent.STOPPED);
        }
    }
}
