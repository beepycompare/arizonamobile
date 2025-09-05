package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.ProductInfo;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.k3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0370k3 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProductInfo f942a;
    public final /* synthetic */ C0396l3 b;

    public C0370k3(C0396l3 c0396l3, ProductInfo productInfo) {
        this.b = c0396l3;
        this.f942a = productInfo;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0396l3 c0396l3 = this.b;
        InterfaceC0508pb interfaceC0508pb = c0396l3.f959a;
        ProductInfo productInfo = this.f942a;
        c0396l3.getClass();
        ((C0651v5) interfaceC0508pb).a(C0477o6.a(new C0177cg(productInfo)));
    }
}
