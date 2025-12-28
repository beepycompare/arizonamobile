package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import kotlin.Lazy;
import kotlin.LazyKt;
/* renamed from: io.appmetrica.analytics.screenshot.impl.d  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0761d implements T {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1457a;
    public final U b;
    public volatile C0767j c;
    public final Lazy d = LazyKt.lazy(new C0758a(this));

    public C0761d(ClientContext clientContext, U u) {
        this.f1457a = clientContext;
        this.b = u;
    }

    public static final Activity.ScreenCaptureCallback d(C0761d c0761d) {
        return (Activity.ScreenCaptureCallback) c0761d.d.getValue();
    }

    @Override // io.appmetrica.analytics.screenshot.impl.T
    public final void a(C0770m c0770m) {
        this.c = c0770m != null ? c0770m.f1471a : null;
    }

    public final String b() {
        return "AndroidApiScreenshotCaptor";
    }

    @Override // io.appmetrica.analytics.screenshot.impl.T
    public final void a() {
        if (AndroidUtils.isApiAchieved(34)) {
            this.f1457a.getActivityLifecycleRegistry().registerListener(new C0760c(this), ActivityEvent.STARTED, ActivityEvent.STOPPED);
        }
    }
}
