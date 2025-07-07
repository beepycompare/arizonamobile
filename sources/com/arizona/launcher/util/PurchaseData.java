package com.arizona.launcher.util;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/arizona/launcher/util/PurchaseData;", "", "amount", "", FirebaseAnalytics.Param.CURRENCY, "", "productId", "productName", "orderId", "<init>", "(DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()D", "getCurrency", "()Ljava/lang/String;", "getProductId", "getProductName", "getOrderId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PurchaseData {
    public static final int $stable = 0;
    private final double amount;
    private final String currency;
    private final String orderId;
    private final String productId;
    private final String productName;

    public static /* synthetic */ PurchaseData copy$default(PurchaseData purchaseData, double d, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            d = purchaseData.amount;
        }
        double d2 = d;
        if ((i & 2) != 0) {
            str = purchaseData.currency;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = purchaseData.productId;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = purchaseData.productName;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = purchaseData.orderId;
        }
        return purchaseData.copy(d2, str5, str6, str7, str4);
    }

    public final double component1() {
        return this.amount;
    }

    public final String component2() {
        return this.currency;
    }

    public final String component3() {
        return this.productId;
    }

    public final String component4() {
        return this.productName;
    }

    public final String component5() {
        return this.orderId;
    }

    public final PurchaseData copy(double d, String currency, String productId, String productName, String orderId) {
        Intrinsics.checkNotNullParameter(currency, "currency");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(productName, "productName");
        Intrinsics.checkNotNullParameter(orderId, "orderId");
        return new PurchaseData(d, currency, productId, productName, orderId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PurchaseData) {
            PurchaseData purchaseData = (PurchaseData) obj;
            return Double.compare(this.amount, purchaseData.amount) == 0 && Intrinsics.areEqual(this.currency, purchaseData.currency) && Intrinsics.areEqual(this.productId, purchaseData.productId) && Intrinsics.areEqual(this.productName, purchaseData.productName) && Intrinsics.areEqual(this.orderId, purchaseData.orderId);
        }
        return false;
    }

    public int hashCode() {
        return (((((((Double.hashCode(this.amount) * 31) + this.currency.hashCode()) * 31) + this.productId.hashCode()) * 31) + this.productName.hashCode()) * 31) + this.orderId.hashCode();
    }

    public String toString() {
        double d = this.amount;
        String str = this.currency;
        String str2 = this.productId;
        String str3 = this.productName;
        return "PurchaseData(amount=" + d + ", currency=" + str + ", productId=" + str2 + ", productName=" + str3 + ", orderId=" + this.orderId + ")";
    }

    public PurchaseData(double d, String currency, String productId, String productName, String orderId) {
        Intrinsics.checkNotNullParameter(currency, "currency");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(productName, "productName");
        Intrinsics.checkNotNullParameter(orderId, "orderId");
        this.amount = d;
        this.currency = currency;
        this.productId = productId;
        this.productName = productName;
        this.orderId = orderId;
    }

    public final double getAmount() {
        return this.amount;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getProductName() {
        return this.productName;
    }

    public final String getOrderId() {
        return this.orderId;
    }
}
