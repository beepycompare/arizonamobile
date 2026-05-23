package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.Objects;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
final class zabl {
    private final ApiKey zaa;
    private final Feature zab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zabl(ApiKey apiKey, Feature feature, byte[] bArr) {
        this.zaa = apiKey;
        this.zab = feature;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zabl) {
            zabl zablVar = (zabl) obj;
            if (Objects.equal(this.zaa, zablVar.zaa) && Objects.equal(this.zab, zablVar.zab)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zaa, this.zab);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("key", this.zaa).add("feature", this.zab).toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ApiKey zaa() {
        return this.zaa;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Feature zab() {
        return this.zab;
    }
}
