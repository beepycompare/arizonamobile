package com.android.billingclient.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes3.dex */
public final class DeveloperProvidedBillingDetails {
    private final String zza;
    private final JSONObject zzb;
    private final List zzc;

    /* compiled from: com.android.billingclient:billing@@8.3.0 */
    /* loaded from: classes3.dex */
    public static class Product {
        private final String zza;
        private final String zzb;
        private final String zzc;

        /* synthetic */ Product(JSONObject jSONObject, zzdj zzdjVar) {
            this.zza = jSONObject.optString("productId");
            this.zzb = jSONObject.optString("productType");
            String optString = jSONObject.optString("offerToken");
            this.zzc = true == optString.isEmpty() ? null : optString;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Product) {
                Product product = (Product) obj;
                return this.zza.equals(product.getId()) && this.zzb.equals(product.getType()) && Objects.equals(this.zzc, product.getOfferToken());
            }
            return false;
        }

        public String getId() {
            return this.zza;
        }

        public String getOfferToken() {
            return this.zzc;
        }

        public String getType() {
            return this.zzb;
        }

        public int hashCode() {
            return Objects.hash(this.zza, this.zzb, this.zzc);
        }

        public String toString() {
            return String.format("{id: %s, type: %s, offer token: %s}", this.zza, this.zzb, this.zzc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeveloperProvidedBillingDetails(String str) throws JSONException {
        this.zza = str;
        JSONObject jSONObject = new JSONObject(str);
        this.zzb = jSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray("products");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(new Product(optJSONObject, null));
                }
            }
        }
        this.zzc = arrayList;
    }

    public String getLinkUri() {
        return this.zzb.optString("linkUri");
    }

    public String getOriginalExternalTransactionId() {
        String optString = this.zzb.optString("originalExternalTransactionId");
        if (optString.isEmpty()) {
            return null;
        }
        return optString;
    }

    public List<Product> getProducts() {
        return this.zzc;
    }
}
