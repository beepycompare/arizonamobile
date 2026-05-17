package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.pb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0499pb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f1178a;
    public final WeakReference b;

    public RunnableC0499pb(Handler handler, I2 i2) {
        this.f1178a = new WeakReference(handler);
        this.b = new WeakReference(i2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler = (Handler) this.f1178a.get();
        I2 i2 = (I2) this.b.get();
        if (handler == null || i2 == null) {
            return;
        }
        boolean f = i2.b.f();
        if (!f) {
            PublicLogger publicLogger = i2.c;
            Set set = AbstractC0671w9.f1289a;
            EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
            M3 m3 = new M3("", "", 3, 0, publicLogger);
            C0680wi c0680wi = i2.h;
            Fh fh = i2.b;
            c0680wi.getClass();
            c0680wi.a(C0680wi.a(m3, fh), fh, 1, (Map) null);
        }
        if (f) {
            return;
        }
        C0474ob.a(handler, i2, this);
    }
}
