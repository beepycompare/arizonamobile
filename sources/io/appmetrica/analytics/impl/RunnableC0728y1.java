package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.y1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0728y1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1286a;

    public RunnableC0728y1(Context context) {
        this.f1286a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0540qk c0540qk = Oj.f708a;
        Context context = this.f1286a;
        synchronized (c0540qk) {
            if (c0540qk.b == null) {
                c0540qk.b = Hi.f580a.a(context, "20799a27-fa80-4b36-b2db-0f8141f24180");
                Iterator it = c0540qk.f1170a.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0479ob) it.next()).a(c0540qk.b);
                }
                c0540qk.f1170a.clear();
            }
        }
    }
}
