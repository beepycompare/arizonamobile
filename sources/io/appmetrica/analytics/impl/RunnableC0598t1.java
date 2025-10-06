package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.t1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0598t1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1089a;

    public RunnableC0598t1(Context context) {
        this.f1089a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0414lk c0414lk = Kj.f543a;
        Context context = this.f1089a;
        synchronized (c0414lk) {
            if (c0414lk.b == null) {
                c0414lk.b = Ji.f521a.a(context, "20799a27-fa80-4b36-b2db-0f8141f24180");
                Iterator it = c0414lk.f977a.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0534qb) it.next()).a(c0414lk.b);
                }
                c0414lk.f977a.clear();
            }
        }
    }
}
