package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.lang.ref.WeakReference;
import java.util.Set;
/* loaded from: classes4.dex */
public final class Ib implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f475a;
    public final WeakReference b;

    public Ib(Handler handler, V2 v2) {
        this.f475a = new WeakReference(handler);
        this.b = new WeakReference(v2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler = (Handler) this.f475a.get();
        V2 v2 = (V2) this.b.get();
        if (handler == null || v2 == null) {
            return;
        }
        boolean f = v2.b.f();
        if (!f) {
            PublicLogger publicLogger = v2.c;
            Set set = O9.f565a;
            EnumC0628ub enumC0628ub = EnumC0628ub.EVENT_TYPE_UNDEFINED;
            C0323i4 c0323i4 = new C0323i4("", "", 3, 0, publicLogger);
            Gi gi = v2.h;
            Qh qh = v2.b;
            gi.getClass();
            gi.a(Gi.a(c0323i4, qh), qh, 1, null);
        }
        if (f) {
            return;
        }
        Hb.a(handler, v2, this);
    }
}
