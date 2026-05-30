package io.appmetrica.analytics.impl;

import android.os.Handler;
import android.os.SystemClock;
import com.google.firebase.messaging.ServiceStarter;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes5.dex */
public final class Qb {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f730a;
    public final V2 b;
    public final Rb c;

    public Qb(Handler handler, V2 v2) {
        this.f730a = handler;
        this.b = v2;
        this.c = new Rb(handler, v2);
    }

    public static void a(Handler handler, V2 v2, Runnable runnable) {
        handler.removeCallbacks(runnable, v2.b.b.getApiKey());
        handler.postAtTime(runnable, v2.b.b.getApiKey(), SystemClock.uptimeMillis() + (((Integer) WrapUtils.getOrDefault(v2.b.b.getSessionTimeout(), 10)).intValue() * ServiceStarter.ERROR_UNKNOWN));
    }
}
