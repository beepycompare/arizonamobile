package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.w1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0663w1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1283a;

    public RunnableC0663w1(Context context) {
        this.f1283a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Qj qj = AbstractC0482oj.f1163a;
        Context context = this.f1283a;
        synchronized (qj) {
            if (qj.b == null) {
                qj.b = AbstractC0456ni.f1143a.a(context, "20799a27-fa80-4b36-b2db-0f8141f24180");
                Iterator it = qj.f758a.iterator();
                while (it.hasNext()) {
                    ((Qa) it.next()).a(qj.b);
                }
                qj.f758a.clear();
            }
        }
    }
}
