package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.w1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0664w1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1279a;

    public RunnableC0664w1(Context context) {
        this.f1279a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Qj qj = AbstractC0483oj.f1159a;
        Context context = this.f1279a;
        synchronized (qj) {
            if (qj.b == null) {
                qj.b = AbstractC0457ni.f1139a.a(context, "20799a27-fa80-4b36-b2db-0f8141f24180");
                Iterator it = qj.f754a.iterator();
                while (it.hasNext()) {
                    ((Qa) it.next()).a(qj.b);
                }
                qj.f754a.clear();
            }
        }
    }
}
