package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.lang.ref.WeakReference;
import java.util.Set;
/* loaded from: classes4.dex */
public final class Pb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f625a;
    public final WeakReference b;

    public Pb(Handler handler, Y2 y2) {
        this.f625a = new WeakReference(handler);
        this.b = new WeakReference(y2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler = (Handler) this.f625a.get();
        Y2 y2 = (Y2) this.b.get();
        if (handler == null || y2 == null) {
            return;
        }
        boolean f = y2.b.f();
        if (!f) {
            PublicLogger publicLogger = y2.c;
            Set set = W9.f726a;
            Bb bb = Bb.EVENT_TYPE_UNDEFINED;
            C0398l4 c0398l4 = new C0398l4("", "", 3, 0, publicLogger);
            Si si = y2.h;
            C0154bi c0154bi = y2.b;
            si.getClass();
            si.a(Si.a(c0398l4, c0154bi), c0154bi, 1, null);
        }
        if (f) {
            return;
        }
        Ob.a(handler, y2, this);
    }
}
