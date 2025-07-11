package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.s1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0568s1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1036a;

    public RunnableC0568s1(Context context) {
        this.f1036a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Zj zj = AbstractC0736yj.f1149a;
        Context context = this.f1036a;
        synchronized (zj) {
            if (zj.b == null) {
                zj.b = AbstractC0735yi.f1148a.a(context, "20799a27-fa80-4b36-b2db-0f8141f24180");
                Iterator it = zj.f741a.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0354jb) it.next()).a(zj.b);
                }
                zj.f741a.clear();
            }
        }
    }
}
