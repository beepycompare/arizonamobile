package io.appmetrica.analytics.billingv6.impl;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PurchaseHistoryRecord;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.google.android.billing.IabHelper;
import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.billinginterface.internal.ProductType;
import io.appmetrica.analytics.billinginterface.internal.library.UtilsProvider;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class g extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f230a;
    public final /* synthetic */ BillingResult b;
    public final /* synthetic */ List c;

    public g(i iVar, BillingResult billingResult, List list) {
        this.f230a = iVar;
        this.b = billingResult;
        this.c = list;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        ProductType productType;
        i iVar = this.f230a;
        BillingResult billingResult = this.b;
        List<PurchaseHistoryRecord> list = this.c;
        iVar.getClass();
        if (billingResult.getResponseCode() == 0 && list != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (PurchaseHistoryRecord purchaseHistoryRecord : list) {
                for (String str : purchaseHistoryRecord.getProducts()) {
                    String str2 = iVar.d;
                    if (Intrinsics.areEqual(str2, IabHelper.ITEM_TYPE_INAPP)) {
                        productType = ProductType.INAPP;
                    } else {
                        productType = Intrinsics.areEqual(str2, IabHelper.ITEM_TYPE_SUBS) ? ProductType.SUBS : ProductType.UNKNOWN;
                    }
                    BillingInfo billingInfo = new BillingInfo(productType, str, purchaseHistoryRecord.getPurchaseToken(), purchaseHistoryRecord.getPurchaseTime(), 0L);
                    linkedHashMap.put(billingInfo.productId, billingInfo);
                }
            }
            Map<String, BillingInfo> billingInfoToUpdate = iVar.c.getUpdatePolicy().getBillingInfoToUpdate(iVar.f232a, linkedHashMap, iVar.c.getBillingInfoManager());
            if (billingInfoToUpdate.isEmpty()) {
                m.a(linkedHashMap, billingInfoToUpdate, iVar.d, iVar.c.getBillingInfoManager());
                iVar.f.onUpdateFinished();
            } else {
                List<String> list2 = CollectionsKt.toList(billingInfoToUpdate.keySet());
                n nVar = iVar.f;
                h hVar = new h(linkedHashMap, billingInfoToUpdate, iVar);
                String str3 = iVar.d;
                BillingClient billingClient = iVar.b;
                UtilsProvider utilsProvider = iVar.c;
                d dVar = iVar.e;
                f fVar = new f(str3, billingClient, utilsProvider, hVar, list, dVar, nVar);
                dVar.b.add(fVar);
                if (iVar.b.isReady()) {
                    BillingClient billingClient2 = iVar.b;
                    QueryProductDetailsParams.Builder newBuilder = QueryProductDetailsParams.newBuilder();
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    for (String str4 : list2) {
                        arrayList.add(QueryProductDetailsParams.Product.newBuilder().setProductId(str4).setProductType(iVar.d).build());
                    }
                    billingClient2.queryProductDetailsAsync(newBuilder.setProductList(arrayList).build(), fVar);
                } else {
                    iVar.e.a(fVar);
                    nVar.onUpdateFinished();
                }
            }
        } else {
            iVar.f.onUpdateFinished();
        }
        i iVar2 = this.f230a;
        iVar2.e.a(iVar2);
    }
}
