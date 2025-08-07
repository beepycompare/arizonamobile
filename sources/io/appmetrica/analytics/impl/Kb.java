package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.lang.ref.WeakReference;
import java.util.Set;
/* loaded from: classes4.dex */
public final class Kb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f520a;
    public final WeakReference b;

    public Kb(Handler handler, V2 v2) {
        this.f520a = new WeakReference(handler);
        this.b = new WeakReference(v2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler = (Handler) this.f520a.get();
        V2 v2 = (V2) this.b.get();
        if (handler == null || v2 == null) {
            return;
        }
        boolean f = v2.b.f();
        if (!f) {
            PublicLogger publicLogger = v2.c;
            Set set = R9.f620a;
            EnumC0681wb enumC0681wb = EnumC0681wb.EVENT_TYPE_UNDEFINED;
            C0326i4 c0326i4 = new C0326i4("", "", 3, 0, publicLogger);
            Ji ji = v2.h;
            Sh sh = v2.b;
            ji.getClass();
            ji.a(Ji.a(c0326i4, sh), sh, 1, null);
        }
        if (f) {
            return;
        }
        Jb.a(handler, v2, this);
    }
}
