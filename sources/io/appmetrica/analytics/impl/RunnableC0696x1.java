package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.x1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0696x1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1278a;

    public RunnableC0696x1(Context context) {
        this.f1278a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0534qk c0534qk = Oj.f711a;
        Context context = this.f1278a;
        synchronized (c0534qk) {
            if (c0534qk.b == null) {
                c0534qk.b = Hi.f583a.a(context, "20799a27-fa80-4b36-b2db-0f8141f24180");
                Iterator it = c0534qk.f1173a.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0473ob) it.next()).a(c0534qk.b);
                }
                c0534qk.f1173a.clear();
            }
        }
    }
}
