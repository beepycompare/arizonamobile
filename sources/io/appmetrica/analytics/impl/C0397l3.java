package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.ProductInfo;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoSender;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.l3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0397l3 implements BillingInfoSender {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0509pb f964a;
    public final ICommonExecutor b;

    public C0397l3(InterfaceC0509pb interfaceC0509pb) {
        this(interfaceC0509pb, Na.j().w().e());
    }

    @Override // io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoSender
    public final void sendInfo(List<ProductInfo> list) {
        for (ProductInfo productInfo : list) {
            this.b.execute(new C0371k3(this, productInfo));
        }
    }

    public C0397l3(InterfaceC0509pb interfaceC0509pb, ICommonExecutor iCommonExecutor) {
        this.f964a = interfaceC0509pb;
        this.b = iCommonExecutor;
    }
}
