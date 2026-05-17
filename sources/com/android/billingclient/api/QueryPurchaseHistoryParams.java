package com.android.billingclient.api;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes3.dex */
public final class QueryPurchaseHistoryParams {

    /* compiled from: com.android.billingclient:billing@@8.3.0 */
    /* loaded from: classes3.dex */
    public static class Builder {
        private String zza;

        private Builder() {
            throw null;
        }

        /* synthetic */ Builder(zzec zzecVar) {
        }

        public QueryPurchaseHistoryParams build() {
            if (this.zza != null) {
                return new QueryPurchaseHistoryParams(this, null);
            }
            throw new IllegalArgumentException("Product type must be set");
        }

        public Builder setProductType(String str) {
            this.zza = str;
            return this;
        }
    }

    /* synthetic */ QueryPurchaseHistoryParams(Builder builder, zzec zzecVar) {
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }
}
