package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.pb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0500pb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f1174a;
    public final WeakReference b;

    public RunnableC0500pb(Handler handler, I2 i2) {
        this.f1174a = new WeakReference(handler);
        this.b = new WeakReference(i2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler = (Handler) this.f1174a.get();
        I2 i2 = (I2) this.b.get();
        if (handler == null || i2 == null) {
            return;
        }
        boolean f = i2.b.f();
        if (!f) {
            PublicLogger publicLogger = i2.c;
            Set set = AbstractC0672w9.f1285a;
            EnumC0143bb enumC0143bb = EnumC0143bb.EVENT_TYPE_UNDEFINED;
            M3 m3 = new M3("", "", 3, 0, publicLogger);
            C0681wi c0681wi = i2.h;
            Fh fh = i2.b;
            c0681wi.getClass();
            c0681wi.a(C0681wi.a(m3, fh), fh, 1, (Map) null);
        }
        if (f) {
            return;
        }
        C0475ob.a(handler, i2, this);
    }
}
