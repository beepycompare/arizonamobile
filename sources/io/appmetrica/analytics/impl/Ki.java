package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Ki {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f541a = new HashMap();
    public final C0671w0 b;

    public Ki(C0671w0 c0671w0) {
        this.b = c0671w0;
    }

    public static Ki a() {
        return Ji.f520a;
    }

    public final Ci a(Context context, String str) {
        Ci ci;
        Ci ci2 = (Ci) this.f541a.get(str);
        if (ci2 == null) {
            synchronized (this.f541a) {
                ci = (Ci) this.f541a.get(str);
                if (ci == null) {
                    IHandlerExecutor a2 = A4.l().c.a();
                    this.b.getClass();
                    if (C0646v0.e == null) {
                        ((Z9) a2).b.post(new Ii(this, context));
                    }
                    ci = new Ci(context.getApplicationContext(), str, new C0671w0());
                    this.f541a.put(str, ci);
                    ci.d(str);
                }
            }
            return ci;
        }
        return ci2;
    }
}
