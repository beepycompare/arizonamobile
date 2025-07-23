package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.ProductInfo;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoSender;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.i3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0324i3 implements BillingInfoSender {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0381kb f894a;
    public final ICommonExecutor b;

    public C0324i3(InterfaceC0381kb interfaceC0381kb) {
        this(interfaceC0381kb, Ia.j().w().e());
    }

    @Override // io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoSender
    public final void sendInfo(List<ProductInfo> list) {
        for (ProductInfo productInfo : list) {
            this.b.execute(new C0299h3(this, productInfo));
        }
    }

    public C0324i3(InterfaceC0381kb interfaceC0381kb, ICommonExecutor iCommonExecutor) {
        this.f894a = interfaceC0381kb;
        this.b = iCommonExecutor;
    }
}
