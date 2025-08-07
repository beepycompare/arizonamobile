package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.ProductInfo;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.h3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0300h3 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProductInfo f875a;
    public final /* synthetic */ C0325i3 b;

    public C0300h3(C0325i3 c0325i3, ProductInfo productInfo) {
        this.b = c0325i3;
        this.f875a = productInfo;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0325i3 c0325i3 = this.b;
        InterfaceC0382kb interfaceC0382kb = c0325i3.f894a;
        ProductInfo productInfo = this.f875a;
        c0325i3.getClass();
        ((C0575s5) interfaceC0382kb).a(C0402l6.a(new Tf(productInfo)));
    }
}
