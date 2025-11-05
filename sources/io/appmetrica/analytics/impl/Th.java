package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* loaded from: classes3.dex */
public final class Th implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f707a;
    public final /* synthetic */ C0404li b;

    public Th(C0404li c0404li, Revenue revenue) {
        this.b = c0404li;
        this.f707a = revenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0404li c0404li = this.b;
        C0404li.a(c0404li.f993a, c0404li.d, c0404li.e).reportRevenue(this.f707a);
    }
}
