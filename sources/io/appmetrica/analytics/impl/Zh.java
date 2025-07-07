package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* loaded from: classes4.dex */
public final class Zh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f738a;
    public final /* synthetic */ C0568ri b;

    public Zh(C0568ri c0568ri, Revenue revenue) {
        this.b = c0568ri;
        this.f738a = revenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0568ri c0568ri = this.b;
        C0568ri.a(c0568ri.f1028a, c0568ri.d, c0568ri.e).reportRevenue(this.f738a);
    }
}
