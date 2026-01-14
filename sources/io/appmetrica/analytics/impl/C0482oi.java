package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.oi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0482oi {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1158a = new HashMap();
    public final C0738z0 b;

    public C0482oi(C0738z0 c0738z0) {
        this.b = c0738z0;
    }

    public static C0482oi a() {
        return AbstractC0457ni.f1139a;
    }

    public final C0279gi a(Context context, String str) {
        C0279gi c0279gi;
        C0279gi c0279gi2 = (C0279gi) this.f1158a.get(str);
        if (c0279gi2 == null) {
            synchronized (this.f1158a) {
                c0279gi = (C0279gi) this.f1158a.get(str);
                if (c0279gi == null) {
                    IHandlerExecutor a2 = C0136b4.l().c.a();
                    this.b.getClass();
                    if (C0713y0.e == null) {
                        ((C0747z9) a2).b.post(new RunnableC0432mi(this, context));
                    }
                    c0279gi = new C0279gi(context.getApplicationContext(), str, new C0738z0());
                    this.f1158a.put(str, c0279gi);
                    c0279gi.c(str);
                }
            }
            return c0279gi;
        }
        return c0279gi2;
    }
}
