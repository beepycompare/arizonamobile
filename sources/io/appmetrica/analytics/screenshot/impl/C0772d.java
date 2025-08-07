package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import kotlin.Lazy;
import kotlin.LazyKt;
/* renamed from: io.appmetrica.analytics.screenshot.impl.d  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0772d implements P {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1297a;
    public final Q b;
    public volatile C0777i c;
    public final Lazy d = LazyKt.lazy(new C0769a(this));

    public C0772d(ClientContext clientContext, Q q) {
        this.f1297a = clientContext;
        this.b = q;
    }

    public static final Activity.ScreenCaptureCallback d(C0772d c0772d) {
        return (Activity.ScreenCaptureCallback) c0772d.d.getValue();
    }

    @Override // io.appmetrica.analytics.screenshot.impl.P
    public final void a(C0780l c0780l) {
        this.c = c0780l != null ? c0780l.f1308a : null;
    }

    public final String b() {
        return "AndroidApiScreenshotCaptor";
    }

    @Override // io.appmetrica.analytics.screenshot.impl.P
    public final void a() {
        if (AndroidUtils.isApiAchieved(34)) {
            this.f1297a.getActivityLifecycleRegistry().registerListener(new C0771c(this), ActivityEvent.STARTED, ActivityEvent.STOPPED);
        }
    }
}
