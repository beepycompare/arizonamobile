package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.lang.ref.WeakReference;
import java.util.Set;
/* loaded from: classes4.dex */
public final class Mb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f559a;
    public final WeakReference b;

    public Mb(Handler handler, V2 v2) {
        this.f559a = new WeakReference(handler);
        this.b = new WeakReference(v2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler = (Handler) this.f559a.get();
        V2 v2 = (V2) this.b.get();
        if (handler == null || v2 == null) {
            return;
        }
        boolean f = v2.b.f();
        if (!f) {
            PublicLogger publicLogger = v2.c;
            Set set = T9.f659a;
            EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
            C0320i4 c0320i4 = new C0320i4("", "", 3, 0, publicLogger);
            Oi oi = v2.h;
            Xh xh = v2.b;
            oi.getClass();
            oi.a(Oi.a(c0320i4, xh), xh, 1, null);
        }
        if (f) {
            return;
        }
        Lb.a(handler, v2, this);
    }
}
