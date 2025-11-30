package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.w1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0661w1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1178a;

    public RunnableC0661w1(Context context) {
        this.f1178a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Rj rj = AbstractC0505pj.f1071a;
        Context context = this.f1178a;
        synchronized (rj) {
            if (rj.b == null) {
                rj.b = AbstractC0479oi.f1051a.a(context, "20799a27-fa80-4b36-b2db-0f8141f24180");
                Iterator it = rj.f664a.iterator();
                while (it.hasNext()) {
                    ((Ra) it.next()).a(rj.b);
                }
                rj.f664a.clear();
            }
        }
    }
}
