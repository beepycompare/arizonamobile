package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.u1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0611u1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1141a;

    public RunnableC0611u1(Context context) {
        this.f1141a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Vj vj = AbstractC0604tj.f1136a;
        Context context = this.f1141a;
        synchronized (vj) {
            if (vj.b == null) {
                vj.b = AbstractC0578si.f1115a.a(context, "20799a27-fa80-4b36-b2db-0f8141f24180");
                Iterator it = vj.f735a.iterator();
                while (it.hasNext()) {
                    ((Xa) it.next()).a(vj.b);
                }
                vj.f735a.clear();
            }
        }
    }
}
