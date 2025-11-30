package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.pi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0504pi {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1070a = new HashMap();
    public final C0735z0 b;

    public C0504pi(C0735z0 c0735z0) {
        this.b = c0735z0;
    }

    public static C0504pi a() {
        return AbstractC0479oi.f1051a;
    }

    public final C0301hi a(Context context, String str) {
        C0301hi c0301hi;
        C0301hi c0301hi2 = (C0301hi) this.f1070a.get(str);
        if (c0301hi2 == null) {
            synchronized (this.f1070a) {
                c0301hi = (C0301hi) this.f1070a.get(str);
                if (c0301hi == null) {
                    IHandlerExecutor a2 = C0158c4.l().c.a();
                    this.b.getClass();
                    if (C0710y0.e == null) {
                        ((A9) a2).b.post(new RunnableC0454ni(this, context));
                    }
                    c0301hi = new C0301hi(context.getApplicationContext(), str, new C0735z0());
                    this.f1070a.put(str, c0301hi);
                    c0301hi.d(str);
                }
            }
            return c0301hi;
        }
        return c0301hi2;
    }
}
