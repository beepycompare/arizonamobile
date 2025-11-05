package io.appmetrica.analytics.impl;

import android.os.Handler;
import android.os.SystemClock;
import com.google.firebase.messaging.ServiceStarter;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.vb  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0646vb {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f1168a;
    public final Q2 b;
    public final RunnableC0671wb c;

    public C0646vb(Handler handler, Q2 q2) {
        this.f1168a = handler;
        this.b = q2;
        this.c = new RunnableC0671wb(handler, q2);
    }

    public static void a(Handler handler, Q2 q2, Runnable runnable) {
        handler.removeCallbacks(runnable, q2.b.b.getApiKey());
        handler.postAtTime(runnable, q2.b.b.getApiKey(), SystemClock.uptimeMillis() + (((Integer) WrapUtils.getOrDefault(q2.b.b.getSessionTimeout(), 10)).intValue() * ServiceStarter.ERROR_UNKNOWN));
    }
}
