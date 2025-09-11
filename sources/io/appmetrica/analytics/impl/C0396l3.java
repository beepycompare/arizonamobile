package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.ProductInfo;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoSender;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.l3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0396l3 implements BillingInfoSender {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0508pb f963a;
    public final ICommonExecutor b;

    public C0396l3(InterfaceC0508pb interfaceC0508pb) {
        this(interfaceC0508pb, Na.j().w().e());
    }

    @Override // io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoSender
    public final void sendInfo(List<ProductInfo> list) {
        for (ProductInfo productInfo : list) {
            this.b.execute(new C0370k3(this, productInfo));
        }
    }

    public C0396l3(InterfaceC0508pb interfaceC0508pb, ICommonExecutor iCommonExecutor) {
        this.f963a = interfaceC0508pb;
        this.b = iCommonExecutor;
    }
}
