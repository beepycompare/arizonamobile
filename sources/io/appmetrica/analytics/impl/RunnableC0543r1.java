package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.r1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0543r1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1035a;

    public RunnableC0543r1(Context context) {
        this.f1035a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0310hk c0310hk = Gj.f460a;
        Context context = this.f1035a;
        synchronized (c0310hk) {
            if (c0310hk.b == null) {
                c0310hk.b = Fi.f437a.a(context, "20799a27-fa80-4b36-b2db-0f8141f24180");
                Iterator it = c0310hk.f892a.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0454nb) it.next()).a(c0310hk.b);
                }
                c0310hk.f892a.clear();
            }
        }
    }
}
