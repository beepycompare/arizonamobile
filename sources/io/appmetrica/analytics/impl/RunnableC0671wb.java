package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.wb  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC0671wb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f1184a;
    public final WeakReference b;

    public RunnableC0671wb(Handler handler, Q2 q2) {
        this.f1184a = new WeakReference(handler);
        this.b = new WeakReference(q2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler = (Handler) this.f1184a.get();
        Q2 q2 = (Q2) this.b.get();
        if (handler == null || q2 == null) {
            return;
        }
        boolean f = q2.b.f();
        if (!f) {
            PublicLogger publicLogger = q2.c;
            Set set = D9.f438a;
            EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
            U3 u3 = new U3("", "", 3, 0, publicLogger);
            Bi bi = q2.h;
            Kh kh = q2.b;
            bi.getClass();
            bi.a(Bi.a(u3, kh), kh, 1, (Map) null);
        }
        if (f) {
            return;
        }
        C0646vb.a(handler, q2, this);
    }
}
