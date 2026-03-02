package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.oi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0481oi {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1157a = new HashMap();
    public final C0737z0 b;

    public C0481oi(C0737z0 c0737z0) {
        this.b = c0737z0;
    }

    public static C0481oi a() {
        return AbstractC0456ni.f1138a;
    }

    public final C0278gi a(Context context, String str) {
        C0278gi c0278gi;
        C0278gi c0278gi2 = (C0278gi) this.f1157a.get(str);
        if (c0278gi2 == null) {
            synchronized (this.f1157a) {
                c0278gi = (C0278gi) this.f1157a.get(str);
                if (c0278gi == null) {
                    IHandlerExecutor a2 = C0135b4.l().c.a();
                    this.b.getClass();
                    if (C0712y0.e == null) {
                        ((C0746z9) a2).b.post(new RunnableC0431mi(this, context));
                    }
                    c0278gi = new C0278gi(context.getApplicationContext(), str, new C0737z0());
                    this.f1157a.put(str, c0278gi);
                    c0278gi.c(str);
                }
            }
            return c0278gi;
        }
        return c0278gi2;
    }
}
