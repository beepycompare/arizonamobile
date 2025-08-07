package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Bi {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f360a = new HashMap();
    public final C0620u0 b;

    public Bi(C0620u0 c0620u0) {
        this.b = c0620u0;
    }

    public static Bi a() {
        return Ai.f340a;
    }

    public final C0613ti a(Context context, String str) {
        C0613ti c0613ti;
        C0613ti c0613ti2 = (C0613ti) this.f360a.get(str);
        if (c0613ti2 == null) {
            synchronized (this.f360a) {
                c0613ti = (C0613ti) this.f360a.get(str);
                if (c0613ti == null) {
                    IHandlerExecutor a2 = C0699x4.l().c.a();
                    this.b.getClass();
                    if (C0595t0.e == null) {
                        ((U9) a2).b.post(new RunnableC0763zi(this, context));
                    }
                    c0613ti = new C0613ti(context.getApplicationContext(), str, new C0620u0());
                    this.f360a.put(str, c0613ti);
                    c0613ti.c(str);
                }
            }
            return c0613ti;
        }
        return c0613ti2;
    }
}
