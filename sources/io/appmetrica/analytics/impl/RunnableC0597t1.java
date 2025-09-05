package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.t1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0597t1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1084a;

    public RunnableC0597t1(Context context) {
        this.f1084a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0413lk c0413lk = Kj.f538a;
        Context context = this.f1084a;
        synchronized (c0413lk) {
            if (c0413lk.b == null) {
                c0413lk.b = Ji.f516a.a(context, "20799a27-fa80-4b36-b2db-0f8141f24180");
                Iterator it = c0413lk.f972a.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0533qb) it.next()).a(c0413lk.b);
                }
                c0413lk.f972a.clear();
            }
        }
    }
}
