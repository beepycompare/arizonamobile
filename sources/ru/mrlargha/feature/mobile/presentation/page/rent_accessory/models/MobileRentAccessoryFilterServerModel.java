package ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: MobileRentAccessoryFilterModel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0018\u001a\u00020\u0019J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003JO\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001J\u0014\u0010\"\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020\bHÖ\u0081\u0004J\n\u0010%\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014¨\u0006&"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryFilterServerModel;", "", "text", "", "priseOrder", "", "ratingOrder", "onlySet", "", "enchant", "selectedCategory", "bizId", "<init>", "(Ljava/lang/String;ZZIIII)V", "getText", "()Ljava/lang/String;", "getPriseOrder", "()Z", "getRatingOrder", "getOnlySet", "()I", "getEnchant", "getSelectedCategory", "getBizId", "toItemModel", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryFilterModel;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MobileRentAccessoryFilterServerModel {
    private final int bizId;
    private final int enchant;
    private final int onlySet;
    private final boolean priseOrder;
    private final boolean ratingOrder;
    private final int selectedCategory;
    private final String text;

    public MobileRentAccessoryFilterServerModel() {
        this(null, false, false, 0, 0, 0, 0, 127, null);
    }

    public static /* synthetic */ MobileRentAccessoryFilterServerModel copy$default(MobileRentAccessoryFilterServerModel mobileRentAccessoryFilterServerModel, String str, boolean z, boolean z2, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = mobileRentAccessoryFilterServerModel.text;
        }
        if ((i5 & 2) != 0) {
            z = mobileRentAccessoryFilterServerModel.priseOrder;
        }
        if ((i5 & 4) != 0) {
            z2 = mobileRentAccessoryFilterServerModel.ratingOrder;
        }
        if ((i5 & 8) != 0) {
            i = mobileRentAccessoryFilterServerModel.onlySet;
        }
        if ((i5 & 16) != 0) {
            i2 = mobileRentAccessoryFilterServerModel.enchant;
        }
        if ((i5 & 32) != 0) {
            i3 = mobileRentAccessoryFilterServerModel.selectedCategory;
        }
        if ((i5 & 64) != 0) {
            i4 = mobileRentAccessoryFilterServerModel.bizId;
        }
        int i6 = i3;
        int i7 = i4;
        int i8 = i2;
        boolean z3 = z2;
        return mobileRentAccessoryFilterServerModel.copy(str, z, z3, i, i8, i6, i7);
    }

    public final String component1() {
        return this.text;
    }

    public final boolean component2() {
        return this.priseOrder;
    }

    public final boolean component3() {
        return this.ratingOrder;
    }

    public final int component4() {
        return this.onlySet;
    }

    public final int component5() {
        return this.enchant;
    }

    public final int component6() {
        return this.selectedCategory;
    }

    public final int component7() {
        return this.bizId;
    }

    public final MobileRentAccessoryFilterServerModel copy(String text, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new MobileRentAccessoryFilterServerModel(text, z, z2, i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MobileRentAccessoryFilterServerModel) {
            MobileRentAccessoryFilterServerModel mobileRentAccessoryFilterServerModel = (MobileRentAccessoryFilterServerModel) obj;
            return Intrinsics.areEqual(this.text, mobileRentAccessoryFilterServerModel.text) && this.priseOrder == mobileRentAccessoryFilterServerModel.priseOrder && this.ratingOrder == mobileRentAccessoryFilterServerModel.ratingOrder && this.onlySet == mobileRentAccessoryFilterServerModel.onlySet && this.enchant == mobileRentAccessoryFilterServerModel.enchant && this.selectedCategory == mobileRentAccessoryFilterServerModel.selectedCategory && this.bizId == mobileRentAccessoryFilterServerModel.bizId;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.text.hashCode() * 31) + Boolean.hashCode(this.priseOrder)) * 31) + Boolean.hashCode(this.ratingOrder)) * 31) + Integer.hashCode(this.onlySet)) * 31) + Integer.hashCode(this.enchant)) * 31) + Integer.hashCode(this.selectedCategory)) * 31) + Integer.hashCode(this.bizId);
    }

    public String toString() {
        String str = this.text;
        boolean z = this.priseOrder;
        boolean z2 = this.ratingOrder;
        int i = this.onlySet;
        int i2 = this.enchant;
        int i3 = this.selectedCategory;
        return "MobileRentAccessoryFilterServerModel(text=" + str + ", priseOrder=" + z + ", ratingOrder=" + z2 + ", onlySet=" + i + ", enchant=" + i2 + ", selectedCategory=" + i3 + ", bizId=" + this.bizId + ")";
    }

    public MobileRentAccessoryFilterServerModel(String text, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.priseOrder = z;
        this.ratingOrder = z2;
        this.onlySet = i;
        this.enchant = i2;
        this.selectedCategory = i3;
        this.bizId = i4;
    }

    public /* synthetic */ MobileRentAccessoryFilterServerModel(String str, boolean z, boolean z2, int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z3;
        boolean z4;
        MobileRentAccessoryFilterServerModel mobileRentAccessoryFilterServerModel;
        String str2;
        str = (i5 & 1) != 0 ? "" : str;
        z = (i5 & 2) != 0 ? true : z;
        z2 = (i5 & 4) != 0 ? true : z2;
        i = (i5 & 8) != 0 ? 1 : i;
        i2 = (i5 & 16) != 0 ? 1 : i2;
        i3 = (i5 & 32) != 0 ? -1 : i3;
        if ((i5 & 64) != 0) {
            i6 = -1;
            i9 = i2;
            i7 = i3;
            z4 = z2;
            i8 = i;
            str2 = str;
            z3 = z;
            mobileRentAccessoryFilterServerModel = this;
        } else {
            i6 = i4;
            i7 = i3;
            i8 = i;
            i9 = i2;
            z3 = z;
            z4 = z2;
            mobileRentAccessoryFilterServerModel = this;
            str2 = str;
        }
        new MobileRentAccessoryFilterServerModel(str2, z3, z4, i8, i9, i7, i6);
    }

    public final String getText() {
        return this.text;
    }

    public final boolean getPriseOrder() {
        return this.priseOrder;
    }

    public final boolean getRatingOrder() {
        return this.ratingOrder;
    }

    public final int getOnlySet() {
        return this.onlySet;
    }

    public final int getEnchant() {
        return this.enchant;
    }

    public final int getSelectedCategory() {
        return this.selectedCategory;
    }

    public final int getBizId() {
        return this.bizId;
    }

    public final MobileRentAccessoryFilterModel toItemModel() {
        boolean z;
        Integer intOrNull = StringsKt.toIntOrNull(this.text);
        String str = (intOrNull != null || this.text.length() <= 0) ? null : this.text;
        if (intOrNull == null || intOrNull.intValue() <= -1) {
            intOrNull = null;
        }
        boolean z2 = this.priseOrder;
        boolean z3 = this.ratingOrder;
        boolean z4 = true;
        if (this.onlySet == 0) {
            z = true;
        } else {
            z = true;
            z4 = false;
        }
        return new MobileRentAccessoryFilterModel(str, intOrNull, z2, z3, z4, this.enchant == 0 ? z : false, this.selectedCategory, this.bizId);
    }
}
