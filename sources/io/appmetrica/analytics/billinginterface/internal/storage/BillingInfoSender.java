package io.appmetrica.analytics.billinginterface.internal.storage;

import io.appmetrica.analytics.billinginterface.internal.ProductInfo;
import java.util.List;
/* loaded from: classes4.dex */
public interface BillingInfoSender {
    void sendInfo(List<ProductInfo> list);
}
