package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.ProductInfo;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.h3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0305h3 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProductInfo f861a;
    public final /* synthetic */ C0330i3 b;

    public C0305h3(C0330i3 c0330i3, ProductInfo productInfo) {
        this.b = c0330i3;
        this.f861a = productInfo;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0330i3 c0330i3 = this.b;
        InterfaceC0338ib interfaceC0338ib = c0330i3.f872a;
        ProductInfo productInfo = this.f861a;
        c0330i3.getClass();
        ((C0580s5) interfaceC0338ib).a(C0333i6.a(new Rf(productInfo)));
    }
}
