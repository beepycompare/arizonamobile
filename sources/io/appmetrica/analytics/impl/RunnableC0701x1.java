package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.x1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0701x1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1275a;

    public RunnableC0701x1(Context context) {
        this.f1275a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0539qk c0539qk = Oj.f708a;
        Context context = this.f1275a;
        synchronized (c0539qk) {
            if (c0539qk.b == null) {
                c0539qk.b = Hi.f580a.a(context, "20799a27-fa80-4b36-b2db-0f8141f24180");
                Iterator it = c0539qk.f1170a.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0478ob) it.next()).a(c0539qk.b);
                }
                c0539qk.f1170a.clear();
            }
        }
    }
}
