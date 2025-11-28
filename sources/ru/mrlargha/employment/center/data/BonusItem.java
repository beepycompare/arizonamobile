package ru.mrlargha.employment.center.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServerData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J[\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006%"}, d2 = {"Lru/mrlargha/employment/center/data/BonusItem;", "", "name", "", "value", "", "valueMax", "image", "imageType", "isShow", "desc", "valueString", "<init>", "(Ljava/lang/String;IIIIILjava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getValue", "()I", "getValueMax", "getImage", "getImageType", "getDesc", "getValueString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "employment-center_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BonusItem {
    private final String desc;
    private final int image;
    private final int imageType;
    private final int isShow;
    private final String name;
    private final int value;
    private final int valueMax;
    private final String valueString;

    public static /* synthetic */ BonusItem copy$default(BonusItem bonusItem, String str, int i, int i2, int i3, int i4, int i5, String str2, String str3, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = bonusItem.name;
        }
        if ((i6 & 2) != 0) {
            i = bonusItem.value;
        }
        if ((i6 & 4) != 0) {
            i2 = bonusItem.valueMax;
        }
        if ((i6 & 8) != 0) {
            i3 = bonusItem.image;
        }
        if ((i6 & 16) != 0) {
            i4 = bonusItem.imageType;
        }
        if ((i6 & 32) != 0) {
            i5 = bonusItem.isShow;
        }
        if ((i6 & 64) != 0) {
            str2 = bonusItem.desc;
        }
        if ((i6 & 128) != 0) {
            str3 = bonusItem.valueString;
        }
        String str4 = str2;
        String str5 = str3;
        int i7 = i4;
        int i8 = i5;
        return bonusItem.copy(str, i, i2, i3, i7, i8, str4, str5);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.value;
    }

    public final int component3() {
        return this.valueMax;
    }

    public final int component4() {
        return this.image;
    }

    public final int component5() {
        return this.imageType;
    }

    public final int component6() {
        return this.isShow;
    }

    public final String component7() {
        return this.desc;
    }

    public final String component8() {
        return this.valueString;
    }

    public final BonusItem copy(String name, int i, int i2, int i3, int i4, int i5, String desc, String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desc, "desc");
        return new BonusItem(name, i, i2, i3, i4, i5, desc, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BonusItem) {
            BonusItem bonusItem = (BonusItem) obj;
            return Intrinsics.areEqual(this.name, bonusItem.name) && this.value == bonusItem.value && this.valueMax == bonusItem.valueMax && this.image == bonusItem.image && this.imageType == bonusItem.imageType && this.isShow == bonusItem.isShow && Intrinsics.areEqual(this.desc, bonusItem.desc) && Intrinsics.areEqual(this.valueString, bonusItem.valueString);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.name.hashCode() * 31) + Integer.hashCode(this.value)) * 31) + Integer.hashCode(this.valueMax)) * 31) + Integer.hashCode(this.image)) * 31) + Integer.hashCode(this.imageType)) * 31) + Integer.hashCode(this.isShow)) * 31) + this.desc.hashCode()) * 31;
        String str = this.valueString;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.name;
        int i = this.value;
        int i2 = this.valueMax;
        int i3 = this.image;
        int i4 = this.imageType;
        int i5 = this.isShow;
        String str2 = this.desc;
        return "BonusItem(name=" + str + ", value=" + i + ", valueMax=" + i2 + ", image=" + i3 + ", imageType=" + i4 + ", isShow=" + i5 + ", desc=" + str2 + ", valueString=" + this.valueString + ")";
    }

    public BonusItem(String name, int i, int i2, int i3, int i4, int i5, String desc, String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.name = name;
        this.value = i;
        this.valueMax = i2;
        this.image = i3;
        this.imageType = i4;
        this.isShow = i5;
        this.desc = desc;
        this.valueString = str;
    }

    public final String getName() {
        return this.name;
    }

    public final int getValue() {
        return this.value;
    }

    public final int getValueMax() {
        return this.valueMax;
    }

    public final int getImage() {
        return this.image;
    }

    public final int getImageType() {
        return this.imageType;
    }

    public final int isShow() {
        return this.isShow;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getValueString() {
        return this.valueString;
    }
}
