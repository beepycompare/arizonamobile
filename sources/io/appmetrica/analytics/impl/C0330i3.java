package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.ProductInfo;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoSender;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.i3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0330i3 implements BillingInfoSender {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0338ib f872a;
    public final ICommonExecutor b;

    public C0330i3(InterfaceC0338ib interfaceC0338ib) {
        this(interfaceC0338ib, Ga.j().w().e());
    }

    @Override // io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoSender
    public final void sendInfo(List<ProductInfo> list) {
        for (ProductInfo productInfo : list) {
            this.b.execute(new C0305h3(this, productInfo));
        }
    }

    public C0330i3(InterfaceC0338ib interfaceC0338ib, ICommonExecutor iCommonExecutor) {
        this.f872a = interfaceC0338ib;
        this.b = iCommonExecutor;
    }
}
