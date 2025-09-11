package io.appmetrica.analytics.impl;

import android.os.Handler;
import android.os.SystemClock;
import com.google.firebase.messaging.ServiceStarter;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes4.dex */
public final class Ob {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f608a;
    public final Y2 b;
    public final Pb c;

    public Ob(Handler handler, Y2 y2) {
        this.f608a = handler;
        this.b = y2;
        this.c = new Pb(handler, y2);
    }

    public static void a(Handler handler, Y2 y2, Runnable runnable) {
        handler.removeCallbacks(runnable, y2.b.b.getApiKey());
        handler.postAtTime(runnable, y2.b.b.getApiKey(), SystemClock.uptimeMillis() + (((Integer) WrapUtils.getOrDefault(y2.b.b.getSessionTimeout(), 10)).intValue() * ServiceStarter.ERROR_UNKNOWN));
    }
}
