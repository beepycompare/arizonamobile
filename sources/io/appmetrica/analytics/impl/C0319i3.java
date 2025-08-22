package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.ProductInfo;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoSender;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.i3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0319i3 implements BillingInfoSender {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0429mb f899a;
    public final ICommonExecutor b;

    public C0319i3(InterfaceC0429mb interfaceC0429mb) {
        this(interfaceC0429mb, Ka.j().w().e());
    }

    @Override // io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoSender
    public final void sendInfo(List<ProductInfo> list) {
        for (ProductInfo productInfo : list) {
            this.b.execute(new C0293h3(this, productInfo));
        }
    }

    public C0319i3(InterfaceC0429mb interfaceC0429mb, ICommonExecutor iCommonExecutor) {
        this.f899a = interfaceC0429mb;
        this.b = iCommonExecutor;
    }
}
