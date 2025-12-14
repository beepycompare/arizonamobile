package io.appmetrica.analytics.impl;

import android.os.Handler;
import android.os.SystemClock;
import com.google.firebase.messaging.ServiceStarter;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.pb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0496pb {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f1162a;
    public final J2 b;
    public final RunnableC0521qb c;

    public C0496pb(Handler handler, J2 j2) {
        this.f1162a = handler;
        this.b = j2;
        this.c = new RunnableC0521qb(handler, j2);
    }

    public static void a(Handler handler, J2 j2, Runnable runnable) {
        handler.removeCallbacks(runnable, j2.b.b.getApiKey());
        handler.postAtTime(runnable, j2.b.b.getApiKey(), SystemClock.uptimeMillis() + (((Integer) WrapUtils.getOrDefault(j2.b.b.getSessionTimeout(), 10)).intValue() * ServiceStarter.ERROR_UNKNOWN));
    }
}
