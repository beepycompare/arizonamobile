package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.ti  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0603ti {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1135a = new HashMap();
    public final C0685x0 b;

    public C0603ti(C0685x0 c0685x0) {
        this.b = c0685x0;
    }

    public static C0603ti a() {
        return AbstractC0578si.f1115a;
    }

    public final C0404li a(Context context, String str) {
        C0404li c0404li;
        C0404li c0404li2 = (C0404li) this.f1135a.get(str);
        if (c0404li2 == null) {
            synchronized (this.f1135a) {
                c0404li = (C0404li) this.f1135a.get(str);
                if (c0404li == null) {
                    IHandlerExecutor a2 = C0338j4.l().c.a();
                    this.b.getClass();
                    if (C0660w0.e == null) {
                        ((G9) a2).b.post(new RunnableC0553ri(this, context));
                    }
                    c0404li = new C0404li(context.getApplicationContext(), str, new C0685x0());
                    this.f1135a.put(str, c0404li);
                    c0404li.d(str);
                }
            }
            return c0404li;
        }
        return c0404li2;
    }
}
