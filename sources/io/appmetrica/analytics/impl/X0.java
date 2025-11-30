package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* loaded from: classes5.dex */
public final class X0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f743a;
    public final /* synthetic */ C0611u1 b;

    public X0(C0611u1 c0611u1, Revenue revenue) {
        this.b = c0611u1;
        this.f743a = revenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0611u1.a(this.b).reportRevenue(this.f743a);
    }
}
