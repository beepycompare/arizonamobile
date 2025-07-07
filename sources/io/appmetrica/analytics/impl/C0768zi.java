package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.zi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0768zi {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1168a = new HashMap();
    public final C0625u0 b;

    public C0768zi(C0625u0 c0625u0) {
        this.b = c0625u0;
    }

    public static C0768zi a() {
        return AbstractC0743yi.f1147a;
    }

    public final C0568ri a(Context context, String str) {
        C0568ri c0568ri;
        C0568ri c0568ri2 = (C0568ri) this.f1168a.get(str);
        if (c0568ri2 == null) {
            synchronized (this.f1168a) {
                c0568ri = (C0568ri) this.f1168a.get(str);
                if (c0568ri == null) {
                    IHandlerExecutor a2 = C0704x4.l().c.a();
                    this.b.getClass();
                    if (C0600t0.e == null) {
                        ((S9) a2).b.post(new RunnableC0718xi(this, context));
                    }
                    c0568ri = new C0568ri(context.getApplicationContext(), str, new C0625u0());
                    this.f1168a.put(str, c0568ri);
                    c0568ri.c(str);
                }
            }
            return c0568ri;
        }
        return c0568ri2;
    }
}
