package ru.mrlargha.arizona.rating;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0011HÆ\u0003J}\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0014\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00102\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00103\u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00064"}, d2 = {"Lru/mrlargha/arizona/rating/RatingItem;", "", "id", "", "modelid", "name", "", "subName", "rating", "qualityType", "qualityValue", "bonuses", "", "Lru/mrlargha/arizona/rating/ItemBonus;", "imageType", "imageIndex", "objectViewer", "Lru/mrlargha/arizona/rating/ObjectViewer;", "<init>", "(IILjava/lang/String;Ljava/lang/String;IIILjava/util/List;IILru/mrlargha/arizona/rating/ObjectViewer;)V", "getId", "()I", "getModelid", "getName", "()Ljava/lang/String;", "getSubName", "getRating", "getQualityType", "getQualityValue", "getBonuses", "()Ljava/util/List;", "getImageType", "getImageIndex", "getObjectViewer", "()Lru/mrlargha/arizona/rating/ObjectViewer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "toString", "item-rating"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RatingItem {
    private final List<ItemBonus> bonuses;
    private final int id;
    private final int imageIndex;
    private final int imageType;
    private final int modelid;
    private final String name;
    private final ObjectViewer objectViewer;
    private final int qualityType;
    private final int qualityValue;
    private final int rating;
    private final String subName;

    public static /* synthetic */ RatingItem copy$default(RatingItem ratingItem, int i, int i2, String str, String str2, int i3, int i4, int i5, List list, int i6, int i7, ObjectViewer objectViewer, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i = ratingItem.id;
        }
        if ((i8 & 2) != 0) {
            i2 = ratingItem.modelid;
        }
        if ((i8 & 4) != 0) {
            str = ratingItem.name;
        }
        if ((i8 & 8) != 0) {
            str2 = ratingItem.subName;
        }
        if ((i8 & 16) != 0) {
            i3 = ratingItem.rating;
        }
        if ((i8 & 32) != 0) {
            i4 = ratingItem.qualityType;
        }
        if ((i8 & 64) != 0) {
            i5 = ratingItem.qualityValue;
        }
        List<ItemBonus> list2 = list;
        if ((i8 & 128) != 0) {
            list2 = ratingItem.bonuses;
        }
        if ((i8 & 256) != 0) {
            i6 = ratingItem.imageType;
        }
        if ((i8 & 512) != 0) {
            i7 = ratingItem.imageIndex;
        }
        if ((i8 & 1024) != 0) {
            objectViewer = ratingItem.objectViewer;
        }
        int i9 = i7;
        ObjectViewer objectViewer2 = objectViewer;
        List list3 = list2;
        int i10 = i6;
        int i11 = i4;
        int i12 = i5;
        int i13 = i3;
        String str3 = str;
        return ratingItem.copy(i, i2, str3, str2, i13, i11, i12, list3, i10, i9, objectViewer2);
    }

    public final int component1() {
        return this.id;
    }

    public final int component10() {
        return this.imageIndex;
    }

    public final ObjectViewer component11() {
        return this.objectViewer;
    }

    public final int component2() {
        return this.modelid;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.subName;
    }

    public final int component5() {
        return this.rating;
    }

    public final int component6() {
        return this.qualityType;
    }

    public final int component7() {
        return this.qualityValue;
    }

    public final List<ItemBonus> component8() {
        return this.bonuses;
    }

    public final int component9() {
        return this.imageType;
    }

    public final RatingItem copy(int i, int i2, String name, String subName, int i3, int i4, int i5, List<ItemBonus> bonuses, int i6, int i7, ObjectViewer objectViewer) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(subName, "subName");
        Intrinsics.checkNotNullParameter(bonuses, "bonuses");
        Intrinsics.checkNotNullParameter(objectViewer, "objectViewer");
        return new RatingItem(i, i2, name, subName, i3, i4, i5, bonuses, i6, i7, objectViewer);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RatingItem) {
            RatingItem ratingItem = (RatingItem) obj;
            return this.id == ratingItem.id && this.modelid == ratingItem.modelid && Intrinsics.areEqual(this.name, ratingItem.name) && Intrinsics.areEqual(this.subName, ratingItem.subName) && this.rating == ratingItem.rating && this.qualityType == ratingItem.qualityType && this.qualityValue == ratingItem.qualityValue && Intrinsics.areEqual(this.bonuses, ratingItem.bonuses) && this.imageType == ratingItem.imageType && this.imageIndex == ratingItem.imageIndex && Intrinsics.areEqual(this.objectViewer, ratingItem.objectViewer);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.modelid)) * 31) + this.name.hashCode()) * 31) + this.subName.hashCode()) * 31) + Integer.hashCode(this.rating)) * 31) + Integer.hashCode(this.qualityType)) * 31) + Integer.hashCode(this.qualityValue)) * 31) + this.bonuses.hashCode()) * 31) + Integer.hashCode(this.imageType)) * 31) + Integer.hashCode(this.imageIndex)) * 31) + this.objectViewer.hashCode();
    }

    public String toString() {
        int i = this.id;
        int i2 = this.modelid;
        String str = this.name;
        String str2 = this.subName;
        int i3 = this.rating;
        int i4 = this.qualityType;
        int i5 = this.qualityValue;
        List<ItemBonus> list = this.bonuses;
        int i6 = this.imageType;
        int i7 = this.imageIndex;
        return "RatingItem(id=" + i + ", modelid=" + i2 + ", name=" + str + ", subName=" + str2 + ", rating=" + i3 + ", qualityType=" + i4 + ", qualityValue=" + i5 + ", bonuses=" + list + ", imageType=" + i6 + ", imageIndex=" + i7 + ", objectViewer=" + this.objectViewer + ")";
    }

    public RatingItem(int i, int i2, String name, String subName, int i3, int i4, int i5, List<ItemBonus> bonuses, int i6, int i7, ObjectViewer objectViewer) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(subName, "subName");
        Intrinsics.checkNotNullParameter(bonuses, "bonuses");
        Intrinsics.checkNotNullParameter(objectViewer, "objectViewer");
        this.id = i;
        this.modelid = i2;
        this.name = name;
        this.subName = subName;
        this.rating = i3;
        this.qualityType = i4;
        this.qualityValue = i5;
        this.bonuses = bonuses;
        this.imageType = i6;
        this.imageIndex = i7;
        this.objectViewer = objectViewer;
    }

    public final int getId() {
        return this.id;
    }

    public final int getModelid() {
        return this.modelid;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSubName() {
        return this.subName;
    }

    public final int getRating() {
        return this.rating;
    }

    public final int getQualityType() {
        return this.qualityType;
    }

    public final int getQualityValue() {
        return this.qualityValue;
    }

    public final List<ItemBonus> getBonuses() {
        return this.bonuses;
    }

    public final int getImageType() {
        return this.imageType;
    }

    public final int getImageIndex() {
        return this.imageIndex;
    }

    public final ObjectViewer getObjectViewer() {
        return this.objectViewer;
    }
}
