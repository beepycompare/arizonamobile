package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.ProductInfo;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.k3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0371k3 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProductInfo f947a;
    public final /* synthetic */ C0397l3 b;

    public C0371k3(C0397l3 c0397l3, ProductInfo productInfo) {
        this.b = c0397l3;
        this.f947a = productInfo;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0397l3 c0397l3 = this.b;
        InterfaceC0509pb interfaceC0509pb = c0397l3.f964a;
        ProductInfo productInfo = this.f947a;
        c0397l3.getClass();
        ((C0652v5) interfaceC0509pb).a(C0478o6.a(new C0178cg(productInfo)));
    }
}
