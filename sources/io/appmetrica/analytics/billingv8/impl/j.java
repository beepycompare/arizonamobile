package io.appmetrica.analytics.billingv8.impl;

import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.Purchase;
import com.google.android.billing.IabHelper;
import io.appmetrica.analytics.billinginterface.internal.ProductInfo;
import io.appmetrica.analytics.billinginterface.internal.ProductType;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class j extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k f247a;
    public final /* synthetic */ BillingResult b;
    public final /* synthetic */ List c;

    public j(k kVar, BillingResult billingResult, List list) {
        this.f247a = kVar;
        this.b = billingResult;
        this.c = list;
    }

    /* JADX WARN: Removed duplicated region for block: B:93:0x0198 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x007f A[SYNTHETIC] */
    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void runSafety() {
        ProductInfo productInfo;
        ProductInfo productInfo2;
        ProductType productType;
        String originalJson;
        ProductType productType2;
        String originalJson2;
        k kVar = this.f247a;
        BillingResult billingResult = this.b;
        List<Purchase> list = this.c;
        kVar.getClass();
        if (billingResult.getResponseCode() != 0) {
            kVar.f.onUpdateFinished();
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Purchase purchase : list) {
                for (String str : purchase.getProducts()) {
                    linkedHashMap.put(str, purchase);
                }
            }
            List<Purchase> list2 = kVar.c;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Purchase purchase2 : list2) {
                for (String str2 : purchase2.getProducts()) {
                    linkedHashMap2.put(str2, purchase2);
                }
            }
            List<ProductDetails> list3 = kVar.d;
            ArrayList arrayList = new ArrayList();
            for (ProductDetails productDetails : list3) {
                Purchase purchase3 = (Purchase) linkedHashMap2.get(productDetails.getProductId());
                if (purchase3 != null) {
                    Purchase purchase4 = (Purchase) linkedHashMap.get(productDetails.getProductId());
                    String productType3 = productDetails.getProductType();
                    int hashCode = productType3.hashCode();
                    if (hashCode != 3541555) {
                        if (hashCode == 100343516 && productType3.equals(IabHelper.ITEM_TYPE_INAPP)) {
                            String productType4 = productDetails.getProductType();
                            if (Intrinsics.areEqual(productType4, IabHelper.ITEM_TYPE_INAPP)) {
                                productType2 = ProductType.INAPP;
                            } else {
                                productType2 = Intrinsics.areEqual(productType4, IabHelper.ITEM_TYPE_SUBS) ? ProductType.SUBS : ProductType.UNKNOWN;
                            }
                            ProductType productType5 = productType2;
                            String productId = productDetails.getProductId();
                            int quantity = purchase3.getQuantity();
                            ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails = productDetails.getOneTimePurchaseOfferDetails();
                            long priceAmountMicros = oneTimePurchaseOfferDetails != null ? oneTimePurchaseOfferDetails.getPriceAmountMicros() : 0L;
                            ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails2 = productDetails.getOneTimePurchaseOfferDetails();
                            productInfo = new ProductInfo(productType5, productId, quantity, priceAmountMicros, (oneTimePurchaseOfferDetails2 == null || (r6 = oneTimePurchaseOfferDetails2.getPriceCurrencyCode()) == null) ? "" : "", 0L, null, 1, null, purchase3.getSignature(), purchase3.getPurchaseToken(), purchase3.getPurchaseTime(), purchase4 != null ? purchase4.isAutoRenewing() : false, (purchase4 == null || (originalJson2 = purchase4.getOriginalJson()) == null) ? "{}" : originalJson2);
                        }
                    } else if (productType3.equals(IabHelper.ITEM_TYPE_SUBS)) {
                        String productType6 = productDetails.getProductType();
                        if (Intrinsics.areEqual(productType6, IabHelper.ITEM_TYPE_INAPP)) {
                            productType = ProductType.INAPP;
                        } else {
                            productType = Intrinsics.areEqual(productType6, IabHelper.ITEM_TYPE_SUBS) ? ProductType.SUBS : ProductType.UNKNOWN;
                        }
                        productInfo = new ProductInfo(productType, productDetails.getProductId(), purchase3.getQuantity(), 0L, "", 0L, null, 1, null, purchase3.getSignature(), purchase3.getPurchaseToken(), purchase3.getPurchaseTime(), purchase4 != null ? purchase4.isAutoRenewing() : false, (purchase4 == null || (originalJson = purchase4.getOriginalJson()) == null) ? "{}" : originalJson);
                    }
                    productInfo2 = productInfo;
                    if (productInfo2 == null) {
                        arrayList.add(productInfo2);
                    }
                }
                productInfo = null;
                productInfo2 = productInfo;
                if (productInfo2 == null) {
                }
            }
            kVar.f248a.getBillingInfoSender().sendInfo(arrayList);
            kVar.b.invoke();
            kVar.f.onUpdateFinished();
        }
        k kVar2 = this.f247a;
        kVar2.e.a(kVar2);
    }
}
