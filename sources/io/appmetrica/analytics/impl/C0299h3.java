package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.ProductInfo;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.h3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0299h3 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProductInfo f876a;
    public final /* synthetic */ C0324i3 b;

    public C0299h3(C0324i3 c0324i3, ProductInfo productInfo) {
        this.b = c0324i3;
        this.f876a = productInfo;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0324i3 c0324i3 = this.b;
        InterfaceC0381kb interfaceC0381kb = c0324i3.f895a;
        ProductInfo productInfo = this.f876a;
        c0324i3.getClass();
        ((C0574s5) interfaceC0381kb).a(C0401l6.a(new Tf(productInfo)));
    }
}
