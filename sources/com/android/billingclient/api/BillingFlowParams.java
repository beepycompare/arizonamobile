package com.android.billingclient.api;

import android.text.TextUtils;
import com.android.billingclient.api.ProductDetails;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes3.dex */
public class BillingFlowParams {
    private boolean zza;
    private String zzb;
    private String zzc;
    private SubscriptionUpdateParams zzd;
    private com.google.android.gms.internal.play_billing.zzbw zze;
    private ArrayList zzf;
    private boolean zzg;
    private DeveloperBillingOptionParams zzh;

    /* compiled from: com.android.billingclient:billing@@8.3.0 */
    /* loaded from: classes3.dex */
    public static class Builder {
        private String zza;
        private String zzb;
        private List zzc;
        private ArrayList zzd;
        private boolean zze;
        private SubscriptionUpdateParams.Builder zzf;
        private DeveloperBillingOptionParams zzg;

        private Builder() {
            SubscriptionUpdateParams.Builder newBuilder = SubscriptionUpdateParams.newBuilder();
            SubscriptionUpdateParams.Builder.zza(newBuilder);
            this.zzf = newBuilder;
        }

        public BillingFlowParams build() {
            com.google.android.gms.internal.play_billing.zzbw zzk;
            ArrayList arrayList = this.zzd;
            boolean z = true;
            boolean z2 = (arrayList == null || arrayList.isEmpty()) ? false : true;
            List list = this.zzc;
            boolean z3 = (list == null || list.isEmpty()) ? false : true;
            if (z2 || z3) {
                if (!z2 || !z3) {
                    if (z2) {
                        if (this.zzd.contains(null)) {
                            throw new IllegalArgumentException("SKU cannot be null.");
                        }
                        if (this.zzd.size() > 1) {
                            SkuDetails skuDetails = (SkuDetails) this.zzd.get(0);
                            String type = skuDetails.getType();
                            ArrayList arrayList2 = this.zzd;
                            int size = arrayList2.size();
                            for (int i = 0; i < size; i++) {
                                SkuDetails skuDetails2 = (SkuDetails) arrayList2.get(i);
                                if (!type.equals("play_pass_subs") && !skuDetails2.getType().equals("play_pass_subs") && !type.equals(skuDetails2.getType())) {
                                    throw new IllegalArgumentException("SKUs should have the same type.");
                                }
                            }
                            String zzd = skuDetails.zzd();
                            ArrayList arrayList3 = this.zzd;
                            int size2 = arrayList3.size();
                            for (int i2 = 0; i2 < size2; i2++) {
                                SkuDetails skuDetails3 = (SkuDetails) arrayList3.get(i2);
                                if (!type.equals("play_pass_subs") && !skuDetails3.getType().equals("play_pass_subs") && !zzd.equals(skuDetails3.zzd())) {
                                    throw new IllegalArgumentException("All SKUs must have the same package name.");
                                }
                            }
                        }
                    } else {
                        List<ProductDetailsParams> list2 = this.zzc;
                        if (list2 != null) {
                            for (ProductDetailsParams productDetailsParams : list2) {
                                if (productDetailsParams == null) {
                                    throw new IllegalArgumentException("ProductDetailsParams cannot be null.");
                                }
                            }
                        }
                    }
                    BillingFlowParams billingFlowParams = new BillingFlowParams(null);
                    if ((!z2 || ((SkuDetails) this.zzd.get(0)).zzd().isEmpty()) && (!z3 || ((ProductDetailsParams) this.zzc.get(0)).zza().zza().isEmpty())) {
                        z = false;
                    }
                    billingFlowParams.zza = z;
                    billingFlowParams.zzb = this.zza;
                    billingFlowParams.zzc = this.zzb;
                    billingFlowParams.zzd = this.zzf.build();
                    ArrayList arrayList4 = this.zzd;
                    billingFlowParams.zzf = arrayList4 != null ? new ArrayList(arrayList4) : new ArrayList();
                    billingFlowParams.zzg = this.zze;
                    List list3 = this.zzc;
                    if (list3 != null) {
                        zzk = com.google.android.gms.internal.play_billing.zzbw.zzj(list3);
                    } else {
                        zzk = com.google.android.gms.internal.play_billing.zzbw.zzk();
                    }
                    billingFlowParams.zze = zzk;
                    billingFlowParams.zzh = this.zzg;
                    return billingFlowParams;
                }
                throw new IllegalArgumentException("Set SkuDetails or ProductDetailsParams, not both.");
            }
            throw new IllegalArgumentException("Details of the products must be provided.");
        }

        public Builder enableDeveloperBillingOption(DeveloperBillingOptionParams developerBillingOptionParams) {
            this.zzg = developerBillingOptionParams;
            return this;
        }

        public Builder setIsOfferPersonalized(boolean z) {
            this.zze = z;
            return this;
        }

        public Builder setObfuscatedAccountId(String str) {
            this.zza = str;
            return this;
        }

        public Builder setObfuscatedProfileId(String str) {
            this.zzb = str;
            return this;
        }

        public Builder setProductDetailsParamsList(List<ProductDetailsParams> list) {
            this.zzc = new ArrayList(list);
            return this;
        }

        @Deprecated
        public Builder setSkuDetails(SkuDetails skuDetails) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(skuDetails);
            this.zzd = arrayList;
            return this;
        }

        public Builder setSubscriptionUpdateParams(SubscriptionUpdateParams subscriptionUpdateParams) {
            this.zzf = SubscriptionUpdateParams.zzb(subscriptionUpdateParams);
            return this;
        }

        /* synthetic */ Builder(zzcx zzcxVar) {
            SubscriptionUpdateParams.Builder newBuilder = SubscriptionUpdateParams.newBuilder();
            SubscriptionUpdateParams.Builder.zza(newBuilder);
            this.zzf = newBuilder;
        }
    }

    /* compiled from: com.android.billingclient:billing@@8.3.0 */
    /* loaded from: classes3.dex */
    public static final class ProductDetailsParams {
        private final SubscriptionProductReplacementParams mSubscriptionProductReplacementParams;
        private final ProductDetails zza;
        private final String zzb;

        /* compiled from: com.android.billingclient:billing@@8.3.0 */
        /* loaded from: classes3.dex */
        public static class Builder {
            private SubscriptionProductReplacementParams mSubscriptionProductReplacementParams;
            private ProductDetails zza;
            private String zzb;

            private Builder() {
                throw null;
            }

            /* synthetic */ Builder(zzcx zzcxVar) {
            }

            public ProductDetailsParams build() {
                com.google.android.gms.internal.play_billing.zzbj.zzc(this.zza, "ProductDetails is required for constructing ProductDetailsParams.");
                return new ProductDetailsParams(this, null);
            }

            public Builder setOfferToken(String str) {
                if (!TextUtils.isEmpty(str)) {
                    this.zzb = str;
                    return this;
                }
                throw new IllegalArgumentException("offerToken can not be empty");
            }

            public Builder setProductDetails(ProductDetails productDetails) {
                this.zza = productDetails;
                if (productDetails.getOneTimePurchaseOfferDetails() != null) {
                    productDetails.getOneTimePurchaseOfferDetails().getClass();
                    ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails = productDetails.getOneTimePurchaseOfferDetails();
                    if (oneTimePurchaseOfferDetails.getOfferToken() != null) {
                        this.zzb = oneTimePurchaseOfferDetails.getOfferToken();
                    }
                }
                return this;
            }

            public Builder setSubscriptionProductReplacementParams(SubscriptionProductReplacementParams subscriptionProductReplacementParams) {
                this.mSubscriptionProductReplacementParams = subscriptionProductReplacementParams;
                return this;
            }
        }

        /* compiled from: com.android.billingclient:billing@@8.3.0 */
        /* loaded from: classes3.dex */
        public static class SubscriptionProductReplacementParams {
            private String oldProductId;
            private int replacementMode;

            /* compiled from: com.android.billingclient:billing@@8.3.0 */
            /* loaded from: classes3.dex */
            public static class Builder {
                private String oldProductId;
                private int replacementMode;

                private Builder() {
                    this.replacementMode = 0;
                }

                public SubscriptionProductReplacementParams build() {
                    SubscriptionProductReplacementParams subscriptionProductReplacementParams = new SubscriptionProductReplacementParams();
                    subscriptionProductReplacementParams.oldProductId = this.oldProductId;
                    subscriptionProductReplacementParams.replacementMode = this.replacementMode;
                    return subscriptionProductReplacementParams;
                }

                public Builder setOldProductId(String str) {
                    this.oldProductId = str;
                    return this;
                }

                public Builder setReplacementMode(int i) {
                    this.replacementMode = i;
                    return this;
                }
            }

            /* compiled from: com.android.billingclient:billing@@8.3.0 */
            @Retention(RetentionPolicy.SOURCE)
            /* loaded from: classes3.dex */
            public @interface ReplacementMode {
                public static final int CHARGE_FULL_PRICE = 4;
                public static final int CHARGE_PRORATED_PRICE = 2;
                public static final int DEFERRED = 5;
                public static final int KEEP_EXISTING = 6;
                public static final int UNKNOWN_REPLACEMENT_MODE = 0;
                public static final int WITHOUT_PRORATION = 3;
                public static final int WITH_TIME_PRORATION = 1;
            }

            public static Builder newBuilder() {
                return new Builder();
            }

            public String getOldProductId() {
                return this.oldProductId;
            }

            public int getReplacementMode() {
                return this.replacementMode;
            }
        }

        /* synthetic */ ProductDetailsParams(Builder builder, zzcx zzcxVar) {
            this.zza = builder.zza;
            this.zzb = builder.zzb;
            this.mSubscriptionProductReplacementParams = builder.mSubscriptionProductReplacementParams;
        }

        public static Builder newBuilder() {
            return new Builder(null);
        }

        public SubscriptionProductReplacementParams getSubscriptionProductReplacementParams() {
            return this.mSubscriptionProductReplacementParams;
        }

        public final ProductDetails zza() {
            return this.zza;
        }

        public final String zzb() {
            return this.zzb;
        }
    }

    /* compiled from: com.android.billingclient:billing@@8.3.0 */
    /* loaded from: classes3.dex */
    public static class SubscriptionUpdateParams {
        private String zza;
        private String zzb;
        private int zzc = 0;

        /* compiled from: com.android.billingclient:billing@@8.3.0 */
        /* loaded from: classes3.dex */
        public static class Builder {
            private String zza;
            private String zzb;
            private boolean zzc;
            private int zzd = 0;

            private Builder() {
            }

            /* synthetic */ Builder(zzcx zzcxVar) {
            }

            static /* synthetic */ Builder zza(Builder builder) {
                builder.zzc = true;
                return builder;
            }

            public SubscriptionUpdateParams build() {
                boolean z = true;
                if (TextUtils.isEmpty(this.zza) && TextUtils.isEmpty(null)) {
                    z = false;
                }
                boolean isEmpty = TextUtils.isEmpty(this.zzb);
                if (!z || isEmpty) {
                    if (!this.zzc && !z && isEmpty) {
                        throw new IllegalArgumentException("Old SKU purchase information(token/id) or original external transaction id must be provided.");
                    }
                    SubscriptionUpdateParams subscriptionUpdateParams = new SubscriptionUpdateParams(null);
                    subscriptionUpdateParams.zza = this.zza;
                    subscriptionUpdateParams.zzc = this.zzd;
                    subscriptionUpdateParams.zzb = this.zzb;
                    return subscriptionUpdateParams;
                }
                throw new IllegalArgumentException("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
            }

            public Builder setOldPurchaseToken(String str) {
                this.zza = str;
                return this;
            }

            public Builder setOriginalExternalTransactionId(String str) {
                this.zzb = str;
                return this;
            }

            @Deprecated
            public Builder setSubscriptionReplacementMode(int i) {
                this.zzd = i;
                return this;
            }

            @Deprecated
            public final Builder zzb(String str) {
                this.zza = str;
                return this;
            }
        }

        /* compiled from: com.android.billingclient:billing@@8.3.0 */
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes3.dex */
        public @interface ReplacementMode {
            public static final int CHARGE_FULL_PRICE = 5;
            public static final int CHARGE_PRORATED_PRICE = 2;
            public static final int DEFERRED = 6;
            public static final int UNKNOWN_REPLACEMENT_MODE = 0;
            public static final int WITHOUT_PRORATION = 3;
            public static final int WITH_TIME_PRORATION = 1;
        }

        private SubscriptionUpdateParams() {
        }

        /* synthetic */ SubscriptionUpdateParams(zzcx zzcxVar) {
        }

        public static Builder newBuilder() {
            return new Builder(null);
        }

        static /* bridge */ /* synthetic */ Builder zzb(SubscriptionUpdateParams subscriptionUpdateParams) {
            Builder newBuilder = newBuilder();
            newBuilder.zzb(subscriptionUpdateParams.zza);
            newBuilder.setSubscriptionReplacementMode(subscriptionUpdateParams.zzc);
            newBuilder.setOriginalExternalTransactionId(subscriptionUpdateParams.zzb);
            return newBuilder;
        }

        final int zza() {
            return this.zzc;
        }

        final String zzc() {
            return this.zza;
        }

        final String zzd() {
            return this.zzb;
        }
    }

    private BillingFlowParams() {
        throw null;
    }

    /* synthetic */ BillingFlowParams(zzcx zzcxVar) {
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public DeveloperBillingOptionParams getDeveloperBillingOptionParams() {
        return this.zzh;
    }

    public int zza() {
        return 0;
    }

    public final int zzb() {
        return this.zzd.zza();
    }

    public long zzc() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final BillingResult zzd() {
        ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails;
        ProductDetailsParams.SubscriptionProductReplacementParams subscriptionProductReplacementParams;
        BillingResult billingResult;
        BillingResult billingResult2;
        if (this.zze.isEmpty()) {
            return zzdc.zzi;
        }
        ProductDetailsParams productDetailsParams = (ProductDetailsParams) this.zze.get(0);
        for (int i = 1; i < this.zze.size(); i++) {
            ProductDetailsParams productDetailsParams2 = (ProductDetailsParams) this.zze.get(i);
            if (!productDetailsParams2.zza().getProductType().equals(productDetailsParams.zza().getProductType()) && !productDetailsParams2.zza().getProductType().equals("play_pass_subs")) {
                return zzdc.zza(5, "All products should have same ProductType.");
            }
        }
        String zza = productDetailsParams.zza().zza();
        HashMap hashMap = new HashMap();
        HashSet hashSet = new HashSet();
        com.google.android.gms.internal.play_billing.zzbw zzbwVar = this.zze;
        int size = zzbwVar.size();
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            ProductDetailsParams productDetailsParams3 = (ProductDetailsParams) zzbwVar.get(i2);
            ProductDetailsParams.SubscriptionProductReplacementParams subscriptionProductReplacementParams2 = productDetailsParams3.getSubscriptionProductReplacementParams();
            if (subscriptionProductReplacementParams2 != null) {
                if (!productDetailsParams3.zza().getProductType().equals("subs")) {
                    billingResult2 = zzdc.zza(5, String.format("Non-subscription product cannot have SubscriptionProductReplacementParams. Invalid product id: %s", productDetailsParams3.zza().getProductId()));
                } else if (subscriptionProductReplacementParams2.getReplacementMode() <= 0) {
                    billingResult2 = zzdc.zza(5, String.format("replacementMode is required for constructing SubscriptionProductReplacementParams. Not correctly set for product id: %s", productDetailsParams3.zza().getProductId()));
                } else if (com.google.android.gms.internal.play_billing.zzbm.zzd(subscriptionProductReplacementParams2.oldProductId)) {
                    billingResult2 = zzdc.zza(5, String.format("oldProductId is required for constructing SubscriptionProductReplacementParams. Not correctly set for product id: %s", productDetailsParams3.zza().getProductId()));
                } else {
                    billingResult2 = zzdc.zzi;
                }
                if (billingResult2 != zzdc.zzi) {
                    return billingResult2;
                }
            }
            if (subscriptionProductReplacementParams2 != null && subscriptionProductReplacementParams2.getReplacementMode() == 6) {
                if (productDetailsParams3.zzb() != null) {
                    billingResult = zzdc.zza(5, String.format("When using KEEP_EXISTING mode, offerToken in ProductDetailsParams should not be set. Offer token is set for product id: %s", productDetailsParams3.zza().getProductId()));
                } else if (!subscriptionProductReplacementParams2.getOldProductId().equals(productDetailsParams3.zza().getProductId())) {
                    billingResult = zzdc.zza(5, String.format("When using KEEP_EXISTING mode, oldProductId in SubscriptionProductReplacementParams should be the same as the product id in ProductDetails. Value is invalid for product id: %s", productDetailsParams3.zza().getProductId()));
                } else {
                    billingResult = zzdc.zzi;
                }
                if (billingResult != zzdc.zzi) {
                    return billingResult;
                }
            }
            if (productDetailsParams3.zza().getSubscriptionOfferDetails() == null || productDetailsParams3.zzb() != null || (subscriptionProductReplacementParams2 != null && subscriptionProductReplacementParams2.getReplacementMode() == 6)) {
                if (!hashMap.containsKey(productDetailsParams3.zza().getProductId())) {
                    hashMap.put(productDetailsParams3.zza().getProductId(), productDetailsParams3);
                    if (subscriptionProductReplacementParams2 != null) {
                        if (!hashSet.contains(subscriptionProductReplacementParams2.getOldProductId())) {
                            hashSet.add(subscriptionProductReplacementParams2.getOldProductId());
                            z = true;
                        } else {
                            return zzdc.zza(5, String.format("OldProductId can not be duplicated. Invalid old product id: %s.", subscriptionProductReplacementParams2.getOldProductId()));
                        }
                    }
                    if (!productDetailsParams.zza().getProductType().equals("play_pass_subs") && !productDetailsParams3.zza().getProductType().equals("play_pass_subs") && !zza.equals(productDetailsParams3.zza().zza())) {
                        return zzdc.zza(5, "All products must have the same package name.");
                    }
                } else {
                    return zzdc.zza(5, String.format("ProductId can not be duplicated. Invalid product id: %s.", productDetailsParams3.zza().getProductId()));
                }
            } else {
                return zzdc.zza(5, String.format("offerToken is required for constructing ProductDetailsParams for subscriptions. Missing value for product id: %s", productDetailsParams3.zza().getProductId()));
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (hashMap.containsKey(str) && ((subscriptionProductReplacementParams = ((ProductDetailsParams) hashMap.get(str)).getSubscriptionProductReplacementParams()) == null || !subscriptionProductReplacementParams.getOldProductId().equals(str))) {
                return zzdc.zza(5, String.format("OldProductId must not be one of the products to be purchased. Invalid old product id: %s.", str));
            }
        }
        if (z && this.zzd.zza() != 0) {
            return zzdc.zza(5, "SubscriptionUpdateParams.setSubscriptionReplaceMode and  ProductDetailsParams.setSubscriptionProductReplacementParams cannot be called at the same time.");
        }
        List<ProductDetails.OneTimePurchaseOfferDetails> oneTimePurchaseOfferDetailsList = productDetailsParams.zza().getOneTimePurchaseOfferDetailsList();
        String zzb = productDetailsParams.zzb();
        if (zzb != null && oneTimePurchaseOfferDetailsList != null) {
            Iterator<ProductDetails.OneTimePurchaseOfferDetails> it2 = oneTimePurchaseOfferDetailsList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    oneTimePurchaseOfferDetails = null;
                    break;
                }
                oneTimePurchaseOfferDetails = it2.next();
                if (zzb.equals(oneTimePurchaseOfferDetails.getOfferToken())) {
                    break;
                }
            }
            if (oneTimePurchaseOfferDetails != null && oneTimePurchaseOfferDetails.zza() != null) {
                return zzdc.zza(5, "Both autoPayDetails and autoPayBalanceThreshold is required for constructing ProductDetailsParams for autopay.");
            }
        }
        return zzdc.zzi;
    }

    public final String zze() {
        return this.zzb;
    }

    public final String zzf() {
        return this.zzc;
    }

    public String zzg() {
        return null;
    }

    public final String zzh() {
        return this.zzd.zzc();
    }

    public final String zzi() {
        return this.zzd.zzd();
    }

    public final ArrayList zzj() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.zzf);
        return arrayList;
    }

    public final List zzk() {
        return this.zze;
    }

    public final boolean zzt() {
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzu() {
        if (this.zzb == null && this.zzc == null && this.zzd.zzd() == null && this.zzd.zza() == 0 && !this.zza && !this.zzg) {
            com.google.android.gms.internal.play_billing.zzbw zzbwVar = this.zze;
            if (zzbwVar != null) {
                int size = zzbwVar.size();
                int i = 0;
                while (i < size) {
                    ProductDetailsParams.SubscriptionProductReplacementParams subscriptionProductReplacementParams = ((ProductDetailsParams) zzbwVar.get(i)).getSubscriptionProductReplacementParams();
                    i++;
                    if (subscriptionProductReplacementParams != null) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
