package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Ki {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f542a = new HashMap();
    public final C0672w0 b;

    public Ki(C0672w0 c0672w0) {
        this.b = c0672w0;
    }

    public static Ki a() {
        return Ji.f521a;
    }

    public final Ci a(Context context, String str) {
        Ci ci;
        Ci ci2 = (Ci) this.f542a.get(str);
        if (ci2 == null) {
            synchronized (this.f542a) {
                ci = (Ci) this.f542a.get(str);
                if (ci == null) {
                    IHandlerExecutor a2 = A4.l().c.a();
                    this.b.getClass();
                    if (C0647v0.e == null) {
                        ((Z9) a2).b.post(new Ii(this, context));
                    }
                    ci = new Ci(context.getApplicationContext(), str, new C0672w0());
                    this.f542a.put(str, ci);
                    ci.d(str);
                }
            }
            return ci;
        }
        return ci2;
    }
}
