package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.r1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0551r1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1015a;

    public RunnableC0551r1(Context context) {
        this.f1015a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Zj zj = AbstractC0744yj.f1148a;
        Context context = this.f1015a;
        synchronized (zj) {
            if (zj.b == null) {
                zj.b = AbstractC0743yi.f1147a.a(context, "20799a27-fa80-4b36-b2db-0f8141f24180");
                Iterator it = zj.f740a.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0362jb) it.next()).a(zj.b);
                }
                zj.f740a.clear();
            }
        }
    }
}
