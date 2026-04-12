package com.arizonagames.feature.arizona.family.data;

import kotlin.Metadata;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/arizonagames/feature/arizona/family/data/FamilySettingsData;", "", "verificationPrice", "", "brandPrice", "hasAliance", "", "<init>", "(JJI)V", "getVerificationPrice", "()J", "getBrandPrice", "getHasAliance", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "family"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FamilySettingsData {
    private final long brandPrice;
    private final int hasAliance;
    private final long verificationPrice;

    public static /* synthetic */ FamilySettingsData copy$default(FamilySettingsData familySettingsData, long j, long j2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = familySettingsData.verificationPrice;
        }
        long j3 = j;
        if ((i2 & 2) != 0) {
            j2 = familySettingsData.brandPrice;
        }
        long j4 = j2;
        if ((i2 & 4) != 0) {
            i = familySettingsData.hasAliance;
        }
        return familySettingsData.copy(j3, j4, i);
    }

    public final long component1() {
        return this.verificationPrice;
    }

    public final long component2() {
        return this.brandPrice;
    }

    public final int component3() {
        return this.hasAliance;
    }

    public final FamilySettingsData copy(long j, long j2, int i) {
        return new FamilySettingsData(j, j2, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FamilySettingsData) {
            FamilySettingsData familySettingsData = (FamilySettingsData) obj;
            return this.verificationPrice == familySettingsData.verificationPrice && this.brandPrice == familySettingsData.brandPrice && this.hasAliance == familySettingsData.hasAliance;
        }
        return false;
    }

    public int hashCode() {
        return (((Long.hashCode(this.verificationPrice) * 31) + Long.hashCode(this.brandPrice)) * 31) + Integer.hashCode(this.hasAliance);
    }

    public String toString() {
        long j = this.verificationPrice;
        long j2 = this.brandPrice;
        return "FamilySettingsData(verificationPrice=" + j + ", brandPrice=" + j2 + ", hasAliance=" + this.hasAliance + ")";
    }

    public FamilySettingsData(long j, long j2, int i) {
        this.verificationPrice = j;
        this.brandPrice = j2;
        this.hasAliance = i;
    }

    public final long getVerificationPrice() {
        return this.verificationPrice;
    }

    public final long getBrandPrice() {
        return this.brandPrice;
    }

    public final int getHasAliance() {
        return this.hasAliance;
    }
}
