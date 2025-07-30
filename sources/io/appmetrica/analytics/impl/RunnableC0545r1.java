package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.r1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0545r1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1028a;

    public RunnableC0545r1(Context context) {
        this.f1028a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0188ck c0188ck = Bj.f362a;
        Context context = this.f1028a;
        synchronized (c0188ck) {
            if (c0188ck.b == null) {
                c0188ck.b = Ai.f341a.a(context, "20799a27-fa80-4b36-b2db-0f8141f24180");
                Iterator it = c0188ck.f802a.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0406lb) it.next()).a(c0188ck.b);
                }
                c0188ck.f802a.clear();
            }
        }
    }
}
