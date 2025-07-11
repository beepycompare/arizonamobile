package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.ProductInfo;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.h3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0297h3 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProductInfo f862a;
    public final /* synthetic */ C0322i3 b;

    public C0297h3(C0322i3 c0322i3, ProductInfo productInfo) {
        this.b = c0322i3;
        this.f862a = productInfo;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0322i3 c0322i3 = this.b;
        InterfaceC0330ib interfaceC0330ib = c0322i3.f873a;
        ProductInfo productInfo = this.f862a;
        c0322i3.getClass();
        ((C0572s5) interfaceC0330ib).a(C0325i6.a(new Rf(productInfo)));
    }
}
