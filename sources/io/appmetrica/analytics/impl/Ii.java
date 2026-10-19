package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class Ii {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f602a = new HashMap();
    public final B0 b;

    public Ii(B0 b0) {
        this.b = b0;
    }

    public static Ii a() {
        return Hi.f583a;
    }

    public final Ai a(Context context, String str) {
        Ai ai;
        Ai ai2 = (Ai) this.f602a.get(str);
        if (ai2 == null) {
            synchronized (this.f602a) {
                ai = (Ai) this.f602a.get(str);
                if (ai == null) {
                    IHandlerExecutor a2 = C0569s4.l().c.a();
                    this.b.getClass();
                    if (A0.e == null) {
                        ((U9) a2).b.post(new Gi(this, context));
                    }
                    ai = new Ai(context.getApplicationContext(), str, new B0());
                    this.f602a.put(str, ai);
                    ai.c(str);
                }
            }
            return ai;
        }
        return ai2;
    }
}
