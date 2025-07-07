package io.appmetrica.analytics.billinginterface.internal;
/* loaded from: classes4.dex */
public class ProductInfo {
    public final boolean autoRenewing;
    public final int introductoryPriceCycles;
    public final long introductoryPriceMicros;
    public final Period introductoryPricePeriod;
    public final String priceCurrency;
    public final long priceMicros;
    public final String purchaseOriginalJson;
    public final long purchaseTime;
    public final String purchaseToken;
    public final int quantity;
    public final String signature;
    public final String sku;
    public final Period subscriptionPeriod;
    public final ProductType type;

    public ProductInfo(ProductType productType, String str, int i, long j, String str2, long j2, Period period, int i2, Period period2, String str3, String str4, long j3, boolean z, String str5) {
        this.type = productType;
        this.sku = str;
        this.quantity = i;
        this.priceMicros = j;
        this.priceCurrency = str2;
        this.introductoryPriceMicros = j2;
        this.introductoryPricePeriod = period;
        this.introductoryPriceCycles = i2;
        this.subscriptionPeriod = period2;
        this.signature = str3;
        this.purchaseToken = str4;
        this.purchaseTime = j3;
        this.autoRenewing = z;
        this.purchaseOriginalJson = str5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ProductInfo productInfo = (ProductInfo) obj;
        if (this.quantity == productInfo.quantity && this.priceMicros == productInfo.priceMicros && this.introductoryPriceMicros == productInfo.introductoryPriceMicros && this.introductoryPriceCycles == productInfo.introductoryPriceCycles && this.purchaseTime == productInfo.purchaseTime && this.autoRenewing == productInfo.autoRenewing && this.type == productInfo.type && this.sku.equals(productInfo.sku) && this.priceCurrency.equals(productInfo.priceCurrency)) {
            Period period = this.introductoryPricePeriod;
            if (period == null ? productInfo.introductoryPricePeriod == null : period.equals(productInfo.introductoryPricePeriod)) {
                Period period2 = this.subscriptionPeriod;
                if (period2 == null ? productInfo.subscriptionPeriod == null : period2.equals(productInfo.subscriptionPeriod)) {
                    if (this.signature.equals(productInfo.signature) && this.purchaseToken.equals(productInfo.purchaseToken)) {
                        return this.purchaseOriginalJson.equals(productInfo.purchaseOriginalJson);
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.sku.hashCode();
        long j = this.priceMicros;
        int hashCode2 = this.priceCurrency.hashCode();
        long j2 = this.introductoryPriceMicros;
        int hashCode3 = (((hashCode2 + ((((((hashCode + (this.type.hashCode() * 31)) * 31) + this.quantity) * 31) + ((int) (j ^ (j >>> 32)))) * 31)) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        Period period = this.introductoryPricePeriod;
        int hashCode4 = (((hashCode3 + (period != null ? period.hashCode() : 0)) * 31) + this.introductoryPriceCycles) * 31;
        Period period2 = this.subscriptionPeriod;
        int hashCode5 = period2 != null ? period2.hashCode() : 0;
        int hashCode6 = this.signature.hashCode();
        int hashCode7 = this.purchaseToken.hashCode();
        long j3 = this.purchaseTime;
        return this.purchaseOriginalJson.hashCode() + ((((((hashCode7 + ((hashCode6 + ((hashCode4 + hashCode5) * 31)) * 31)) * 31) + ((int) ((j3 >>> 32) ^ j3))) * 31) + (this.autoRenewing ? 1 : 0)) * 31);
    }

    public String toString() {
        return "ProductInfo{type=" + this.type + ", sku='" + this.sku + "', quantity=" + this.quantity + ", priceMicros=" + this.priceMicros + ", priceCurrency='" + this.priceCurrency + "', introductoryPriceMicros=" + this.introductoryPriceMicros + ", introductoryPricePeriod=" + this.introductoryPricePeriod + ", introductoryPriceCycles=" + this.introductoryPriceCycles + ", subscriptionPeriod=" + this.subscriptionPeriod + ", signature='" + this.signature + "', purchaseToken='" + this.purchaseToken + "', purchaseTime=" + this.purchaseTime + ", autoRenewing=" + this.autoRenewing + ", purchaseOriginalJson='" + this.purchaseOriginalJson + "'}";
    }
}
