package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.ProductInfo;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.h3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0293h3 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProductInfo f879a;
    public final /* synthetic */ C0319i3 b;

    public C0293h3(C0319i3 c0319i3, ProductInfo productInfo) {
        this.b = c0319i3;
        this.f879a = productInfo;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0319i3 c0319i3 = this.b;
        InterfaceC0429mb interfaceC0429mb = c0319i3.f899a;
        ProductInfo productInfo = this.f879a;
        c0319i3.getClass();
        ((C0572s5) interfaceC0429mb).a(C0399l6.a(new Yf(productInfo)));
    }
}
