package ru.mrlargha.arizonaui.family.data;

import kotlin.Metadata;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lru/mrlargha/arizonaui/family/data/FamilySettingsData;", "", "verificationPrice", "", "brandPrice", "hasAliance", "<init>", "(III)V", "getVerificationPrice", "()I", "getBrandPrice", "getHasAliance", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilySettingsData {
    private final int brandPrice;
    private final int hasAliance;
    private final int verificationPrice;

    public static /* synthetic */ FamilySettingsData copy$default(FamilySettingsData familySettingsData, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = familySettingsData.verificationPrice;
        }
        if ((i4 & 2) != 0) {
            i2 = familySettingsData.brandPrice;
        }
        if ((i4 & 4) != 0) {
            i3 = familySettingsData.hasAliance;
        }
        return familySettingsData.copy(i, i2, i3);
    }

    public final int component1() {
        return this.verificationPrice;
    }

    public final int component2() {
        return this.brandPrice;
    }

    public final int component3() {
        return this.hasAliance;
    }

    public final FamilySettingsData copy(int i, int i2, int i3) {
        return new FamilySettingsData(i, i2, i3);
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
        return (((Integer.hashCode(this.verificationPrice) * 31) + Integer.hashCode(this.brandPrice)) * 31) + Integer.hashCode(this.hasAliance);
    }

    public String toString() {
        int i = this.verificationPrice;
        int i2 = this.brandPrice;
        return "FamilySettingsData(verificationPrice=" + i + ", brandPrice=" + i2 + ", hasAliance=" + this.hasAliance + ")";
    }

    public FamilySettingsData(int i, int i2, int i3) {
        this.verificationPrice = i;
        this.brandPrice = i2;
        this.hasAliance = i3;
    }

    public final int getVerificationPrice() {
        return this.verificationPrice;
    }

    public final int getBrandPrice() {
        return this.brandPrice;
    }

    public final int getHasAliance() {
        return this.hasAliance;
    }
}
