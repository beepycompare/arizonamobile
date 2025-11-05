package io.appmetrica.analytics.billinginterface.internal.update;

import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoManager;
import java.util.Map;
/* loaded from: classes2.dex */
public interface UpdatePolicy {
    Map<String, BillingInfo> getBillingInfoToUpdate(BillingConfig billingConfig, Map<String, BillingInfo> map, BillingInfoManager billingInfoManager);
}
