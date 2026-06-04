package com.arizonagames.feature.arizona.family.data;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/arizonagames/feature/arizona/family/data/FamilyCreateData;", "", "money", "", FirebaseAnalytics.Param.PRICE, "<init>", "(JJ)V", "getMoney", "()J", "getPrice", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "family"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FamilyCreateData {
    private final long money;
    private final long price;

    public static /* synthetic */ FamilyCreateData copy$default(FamilyCreateData familyCreateData, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = familyCreateData.money;
        }
        if ((i & 2) != 0) {
            j2 = familyCreateData.price;
        }
        return familyCreateData.copy(j, j2);
    }

    public final long component1() {
        return this.money;
    }

    public final long component2() {
        return this.price;
    }

    public final FamilyCreateData copy(long j, long j2) {
        return new FamilyCreateData(j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FamilyCreateData) {
            FamilyCreateData familyCreateData = (FamilyCreateData) obj;
            return this.money == familyCreateData.money && this.price == familyCreateData.price;
        }
        return false;
    }

    public int hashCode() {
        return (Long.hashCode(this.money) * 31) + Long.hashCode(this.price);
    }

    public String toString() {
        long j = this.money;
        return "FamilyCreateData(money=" + j + ", price=" + this.price + ")";
    }

    public FamilyCreateData(long j, long j2) {
        this.money = j;
        this.price = j2;
    }

    public final long getMoney() {
        return this.money;
    }

    public final long getPrice() {
        return this.price;
    }
}
