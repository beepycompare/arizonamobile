package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.x1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0685x1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1289a;

    public RunnableC0685x1(Context context) {
        this.f1289a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Rj rj = AbstractC0504pj.f1169a;
        Context context = this.f1289a;
        synchronized (rj) {
            if (rj.b == null) {
                rj.b = AbstractC0478oi.f1149a.a(context, "20799a27-fa80-4b36-b2db-0f8141f24180");
                Iterator it = rj.f762a.iterator();
                while (it.hasNext()) {
                    ((Ra) it.next()).a(rj.b);
                }
                rj.f762a.clear();
            }
        }
    }
}
