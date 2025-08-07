package io.appmetrica.analytics.impl;

import android.os.Handler;
import android.os.SystemClock;
import com.google.firebase.messaging.ServiceStarter;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes4.dex */
public final class Jb {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f504a;
    public final V2 b;
    public final Kb c;

    public Jb(Handler handler, V2 v2) {
        this.f504a = handler;
        this.b = v2;
        this.c = new Kb(handler, v2);
    }

    public static void a(Handler handler, V2 v2, Runnable runnable) {
        handler.removeCallbacks(runnable, v2.b.b.getApiKey());
        handler.postAtTime(runnable, v2.b.b.getApiKey(), SystemClock.uptimeMillis() + (((Integer) WrapUtils.getOrDefault(v2.b.b.getSessionTimeout(), 10)).intValue() * ServiceStarter.ERROR_UNKNOWN));
    }
}
