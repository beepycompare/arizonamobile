package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public final class Rb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f746a;
    public final WeakReference b;

    public Rb(Handler handler, V2 v2) {
        this.f746a = new WeakReference(handler);
        this.b = new WeakReference(v2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler = (Handler) this.f746a.get();
        V2 v2 = (V2) this.b.get();
        if (handler == null || v2 == null) {
            return;
        }
        boolean f = v2.b.f();
        if (!f) {
            PublicLogger publicLogger = v2.c;
            Set set = Q9.f730a;
            Db db = Db.EVENT_TYPE_UNDEFINED;
            C0189d4 c0189d4 = new C0189d4("", "", 3, 0, publicLogger);
            Qi qi = v2.h;
            Zh zh = v2.b;
            qi.getClass();
            qi.a(Qi.a(c0189d4, zh), zh, 1, (Map) null);
        }
        if (f) {
            return;
        }
        Qb.a(handler, v2, this);
    }
}
