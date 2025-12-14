package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.w1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0660w1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1275a;

    public RunnableC0660w1(Context context) {
        this.f1275a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Rj rj = AbstractC0504pj.f1168a;
        Context context = this.f1275a;
        synchronized (rj) {
            if (rj.b == null) {
                rj.b = AbstractC0478oi.f1148a.a(context, "20799a27-fa80-4b36-b2db-0f8141f24180");
                Iterator it = rj.f761a.iterator();
                while (it.hasNext()) {
                    ((Ra) it.next()).a(rj.b);
                }
                rj.f761a.clear();
            }
        }
    }
}
