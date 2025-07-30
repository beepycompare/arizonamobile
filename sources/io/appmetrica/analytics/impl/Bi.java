package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Bi {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f361a = new HashMap();
    public final C0619u0 b;

    public Bi(C0619u0 c0619u0) {
        this.b = c0619u0;
    }

    public static Bi a() {
        return Ai.f341a;
    }

    public final C0612ti a(Context context, String str) {
        C0612ti c0612ti;
        C0612ti c0612ti2 = (C0612ti) this.f361a.get(str);
        if (c0612ti2 == null) {
            synchronized (this.f361a) {
                c0612ti = (C0612ti) this.f361a.get(str);
                if (c0612ti == null) {
                    IHandlerExecutor a2 = C0698x4.l().c.a();
                    this.b.getClass();
                    if (C0594t0.e == null) {
                        ((U9) a2).b.post(new RunnableC0762zi(this, context));
                    }
                    c0612ti = new C0612ti(context.getApplicationContext(), str, new C0619u0());
                    this.f361a.put(str, c0612ti);
                    c0612ti.c(str);
                }
            }
            return c0612ti;
        }
        return c0612ti2;
    }
}
