package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Gi {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f459a = new HashMap();
    public final C0617u0 b;

    public Gi(C0617u0 c0617u0) {
        this.b = c0617u0;
    }

    public static Gi a() {
        return Fi.f437a;
    }

    public final C0735yi a(Context context, String str) {
        C0735yi c0735yi;
        C0735yi c0735yi2 = (C0735yi) this.f459a.get(str);
        if (c0735yi2 == null) {
            synchronized (this.f459a) {
                c0735yi = (C0735yi) this.f459a.get(str);
                if (c0735yi == null) {
                    IHandlerExecutor a2 = C0696x4.l().c.a();
                    this.b.getClass();
                    if (C0592t0.e == null) {
                        ((W9) a2).b.post(new Ei(this, context));
                    }
                    c0735yi = new C0735yi(context.getApplicationContext(), str, new C0617u0());
                    this.f459a.put(str, c0735yi);
                    c0735yi.c(str);
                }
            }
            return c0735yi;
        }
        return c0735yi2;
    }
}
