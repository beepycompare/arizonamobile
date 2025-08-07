package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.s1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0571s1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1046a;

    public RunnableC0571s1(Context context) {
        this.f1046a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0189ck c0189ck = Bj.f361a;
        Context context = this.f1046a;
        synchronized (c0189ck) {
            if (c0189ck.b == null) {
                c0189ck.b = Ai.f340a.a(context, "20799a27-fa80-4b36-b2db-0f8141f24180");
                Iterator it = c0189ck.f801a.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0407lb) it.next()).a(c0189ck.b);
                }
                c0189ck.f801a.clear();
            }
        }
    }
}
