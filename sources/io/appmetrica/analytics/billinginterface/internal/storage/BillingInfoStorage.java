package io.appmetrica.analytics.billinginterface.internal.storage;

import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import java.util.List;
/* loaded from: classes4.dex */
public interface BillingInfoStorage {
    List<BillingInfo> getBillingInfo();

    boolean isFirstInappCheckOccurred();

    void saveInfo(List<BillingInfo> list, boolean z);
}
