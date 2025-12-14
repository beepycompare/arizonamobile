package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.pi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0503pi {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1167a = new HashMap();
    public final C0734z0 b;

    public C0503pi(C0734z0 c0734z0) {
        this.b = c0734z0;
    }

    public static C0503pi a() {
        return AbstractC0478oi.f1148a;
    }

    public final C0300hi a(Context context, String str) {
        C0300hi c0300hi;
        C0300hi c0300hi2 = (C0300hi) this.f1167a.get(str);
        if (c0300hi2 == null) {
            synchronized (this.f1167a) {
                c0300hi = (C0300hi) this.f1167a.get(str);
                if (c0300hi == null) {
                    IHandlerExecutor a2 = C0157c4.l().c.a();
                    this.b.getClass();
                    if (C0709y0.e == null) {
                        ((A9) a2).b.post(new RunnableC0453ni(this, context));
                    }
                    c0300hi = new C0300hi(context.getApplicationContext(), str, new C0734z0());
                    this.f1167a.put(str, c0300hi);
                    c0300hi.d(str);
                }
            }
            return c0300hi;
        }
        return c0300hi2;
    }
}
