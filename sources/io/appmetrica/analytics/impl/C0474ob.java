package io.appmetrica.analytics.impl;

import android.os.Handler;
import android.os.SystemClock;
import com.google.firebase.messaging.ServiceStarter;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.ob  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0474ob {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f1152a;
    public final I2 b;
    public final RunnableC0499pb c;

    public C0474ob(Handler handler, I2 i2) {
        this.f1152a = handler;
        this.b = i2;
        this.c = new RunnableC0499pb(handler, i2);
    }

    public static void a(Handler handler, I2 i2, Runnable runnable) {
        handler.removeCallbacks(runnable, i2.b.b.getApiKey());
        handler.postAtTime(runnable, i2.b.b.getApiKey(), SystemClock.uptimeMillis() + (((Integer) WrapUtils.getOrDefault(i2.b.b.getSessionTimeout(), 10)).intValue() * ServiceStarter.ERROR_UNKNOWN));
    }
}
