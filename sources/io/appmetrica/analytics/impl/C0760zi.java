package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.zi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0760zi {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1169a = new HashMap();
    public final C0617u0 b;

    public C0760zi(C0617u0 c0617u0) {
        this.b = c0617u0;
    }

    public static C0760zi a() {
        return AbstractC0735yi.f1148a;
    }

    public final C0560ri a(Context context, String str) {
        C0560ri c0560ri;
        C0560ri c0560ri2 = (C0560ri) this.f1169a.get(str);
        if (c0560ri2 == null) {
            synchronized (this.f1169a) {
                c0560ri = (C0560ri) this.f1169a.get(str);
                if (c0560ri == null) {
                    IHandlerExecutor a2 = C0696x4.l().c.a();
                    this.b.getClass();
                    if (C0592t0.e == null) {
                        ((S9) a2).b.post(new RunnableC0710xi(this, context));
                    }
                    c0560ri = new C0560ri(context.getApplicationContext(), str, new C0617u0());
                    this.f1169a.put(str, c0560ri);
                    c0560ri.c(str);
                }
            }
            return c0560ri;
        }
        return c0560ri2;
    }
}
