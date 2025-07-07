package io.appmetrica.analytics.billingv6.impl;

import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.billinginterface.internal.ProductType;
import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoManager;
import io.appmetrica.analytics.billinginterface.internal.update.UpdatePolicy;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes4.dex */
public final class o implements UpdatePolicy {

    /* renamed from: a  reason: collision with root package name */
    public final SystemTimeProvider f234a;

    public o() {
        this(null, 1, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0052, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r3.purchaseToken, r2.purchaseToken) != false) goto L13;
     */
    @Override // io.appmetrica.analytics.billinginterface.internal.update.UpdatePolicy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<String, BillingInfo> getBillingInfoToUpdate(BillingConfig billingConfig, Map<String, ? extends BillingInfo> map, BillingInfoManager billingInfoManager) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ? extends BillingInfo> entry : map.entrySet()) {
            BillingInfo value = entry.getValue();
            if (value.type == ProductType.INAPP && !billingInfoManager.isFirstInappCheckOccurred()) {
                if (this.f234a.currentTimeMillis() - value.purchaseTime <= TimeUnit.SECONDS.toMillis(billingConfig.firstCollectingInappMaxAgeSeconds)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            } else {
                BillingInfo billingInfo = billingInfoManager.get(value.productId);
                if (billingInfo != null) {
                }
                if (this.f234a.currentTimeMillis() - value.purchaseTime > TimeUnit.SECONDS.toMillis(billingConfig.firstCollectingInappMaxAgeSeconds)) {
                    if (value.type == ProductType.SUBS) {
                    }
                    if (billingInfo != null && value.type == ProductType.SUBS && this.f234a.currentTimeMillis() - billingInfo.sendTime >= TimeUnit.SECONDS.toMillis(billingConfig.sendFrequencySeconds)) {
                    }
                }
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public o(SystemTimeProvider systemTimeProvider) {
        this.f234a = systemTimeProvider;
    }

    public /* synthetic */ o(SystemTimeProvider systemTimeProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new SystemTimeProvider() : systemTimeProvider);
    }
}
