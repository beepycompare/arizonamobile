package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.qb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0521qb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f1184a;
    public final WeakReference b;

    public RunnableC0521qb(Handler handler, J2 j2) {
        this.f1184a = new WeakReference(handler);
        this.b = new WeakReference(j2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler = (Handler) this.f1184a.get();
        J2 j2 = (J2) this.b.get();
        if (handler == null || j2 == null) {
            return;
        }
        boolean f = j2.b.f();
        if (!f) {
            PublicLogger publicLogger = j2.c;
            Set set = AbstractC0693x9.f1295a;
            EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
            N3 n3 = new N3("", "", 3, 0, publicLogger);
            C0702xi c0702xi = j2.h;
            Gh gh = j2.b;
            c0702xi.getClass();
            c0702xi.a(C0702xi.a(n3, gh), gh, 1, (Map) null);
        }
        if (f) {
            return;
        }
        C0496pb.a(handler, j2, this);
    }
}
