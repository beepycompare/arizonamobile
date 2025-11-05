package com.arizonagames.feature.arizona.cars;

import androidx.core.app.NotificationCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u008a\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020\u0003HÖ\u0001J\t\u0010?\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0016\"\u0004\b\u001f\u0010\u0018R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b)\u0010'R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b*\u0010'\"\u0004\b+\u0010,R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b-\u0010'¨\u0006@"}, d2 = {"Lcom/arizonagames/feature/arizona/cars/CarInfoListItem;", "", "id", "", "title", "", "sysName", "statusButton", "nameButton", NotificationCompat.CATEGORY_STATUS, "labels", "", "Lcom/arizonagames/feature/arizona/cars/LabelInfo;", "rarity", "rarityLevel", "favorite", "ratingPosition", "<init>", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getSysName", "setSysName", "getStatusButton", "setStatusButton", "(I)V", "getNameButton", "setNameButton", "getStatus", "setStatus", "getLabels", "()Ljava/util/List;", "setLabels", "(Ljava/util/List;)V", "getRarity", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRarityLevel", "getFavorite", "setFavorite", "(Ljava/lang/Integer;)V", "getRatingPosition", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/arizonagames/feature/arizona/cars/CarInfoListItem;", "equals", "", "other", "hashCode", "toString", "cars_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CarInfoListItem {
    private Integer favorite;
    private final int id;
    private List<LabelInfo> labels;
    private String nameButton;
    private final Integer rarity;
    private final Integer rarityLevel;
    private final Integer ratingPosition;
    private String status;
    private int statusButton;
    private String sysName;
    private String title;

    public static /* synthetic */ CarInfoListItem copy$default(CarInfoListItem carInfoListItem, int i, String str, String str2, int i2, String str3, String str4, List list, Integer num, Integer num2, Integer num3, Integer num4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = carInfoListItem.id;
        }
        if ((i3 & 2) != 0) {
            str = carInfoListItem.title;
        }
        if ((i3 & 4) != 0) {
            str2 = carInfoListItem.sysName;
        }
        if ((i3 & 8) != 0) {
            i2 = carInfoListItem.statusButton;
        }
        if ((i3 & 16) != 0) {
            str3 = carInfoListItem.nameButton;
        }
        if ((i3 & 32) != 0) {
            str4 = carInfoListItem.status;
        }
        List<LabelInfo> list2 = list;
        if ((i3 & 64) != 0) {
            list2 = carInfoListItem.labels;
        }
        if ((i3 & 128) != 0) {
            num = carInfoListItem.rarity;
        }
        if ((i3 & 256) != 0) {
            num2 = carInfoListItem.rarityLevel;
        }
        if ((i3 & 512) != 0) {
            num3 = carInfoListItem.favorite;
        }
        if ((i3 & 1024) != 0) {
            num4 = carInfoListItem.ratingPosition;
        }
        Integer num5 = num3;
        Integer num6 = num4;
        Integer num7 = num;
        Integer num8 = num2;
        String str5 = str4;
        List list3 = list2;
        String str6 = str3;
        String str7 = str2;
        return carInfoListItem.copy(i, str, str7, i2, str6, str5, list3, num7, num8, num5, num6);
    }

    public final int component1() {
        return this.id;
    }

    public final Integer component10() {
        return this.favorite;
    }

    public final Integer component11() {
        return this.ratingPosition;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.sysName;
    }

    public final int component4() {
        return this.statusButton;
    }

    public final String component5() {
        return this.nameButton;
    }

    public final String component6() {
        return this.status;
    }

    public final List<LabelInfo> component7() {
        return this.labels;
    }

    public final Integer component8() {
        return this.rarity;
    }

    public final Integer component9() {
        return this.rarityLevel;
    }

    public final CarInfoListItem copy(int i, String title, String sysName, int i2, String nameButton, String status, List<LabelInfo> labels, Integer num, Integer num2, Integer num3, Integer num4) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(sysName, "sysName");
        Intrinsics.checkNotNullParameter(nameButton, "nameButton");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(labels, "labels");
        return new CarInfoListItem(i, title, sysName, i2, nameButton, status, labels, num, num2, num3, num4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CarInfoListItem) {
            CarInfoListItem carInfoListItem = (CarInfoListItem) obj;
            return this.id == carInfoListItem.id && Intrinsics.areEqual(this.title, carInfoListItem.title) && Intrinsics.areEqual(this.sysName, carInfoListItem.sysName) && this.statusButton == carInfoListItem.statusButton && Intrinsics.areEqual(this.nameButton, carInfoListItem.nameButton) && Intrinsics.areEqual(this.status, carInfoListItem.status) && Intrinsics.areEqual(this.labels, carInfoListItem.labels) && Intrinsics.areEqual(this.rarity, carInfoListItem.rarity) && Intrinsics.areEqual(this.rarityLevel, carInfoListItem.rarityLevel) && Intrinsics.areEqual(this.favorite, carInfoListItem.favorite) && Intrinsics.areEqual(this.ratingPosition, carInfoListItem.ratingPosition);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.sysName.hashCode()) * 31) + Integer.hashCode(this.statusButton)) * 31) + this.nameButton.hashCode()) * 31) + this.status.hashCode()) * 31) + this.labels.hashCode()) * 31;
        Integer num = this.rarity;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.rarityLevel;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.favorite;
        int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.ratingPosition;
        return hashCode4 + (num4 != null ? num4.hashCode() : 0);
    }

    public String toString() {
        int i = this.id;
        String str = this.title;
        String str2 = this.sysName;
        int i2 = this.statusButton;
        String str3 = this.nameButton;
        String str4 = this.status;
        List<LabelInfo> list = this.labels;
        Integer num = this.rarity;
        Integer num2 = this.rarityLevel;
        Integer num3 = this.favorite;
        return "CarInfoListItem(id=" + i + ", title=" + str + ", sysName=" + str2 + ", statusButton=" + i2 + ", nameButton=" + str3 + ", status=" + str4 + ", labels=" + list + ", rarity=" + num + ", rarityLevel=" + num2 + ", favorite=" + num3 + ", ratingPosition=" + this.ratingPosition + ")";
    }

    public CarInfoListItem(int i, String title, String sysName, int i2, String nameButton, String status, List<LabelInfo> labels, Integer num, Integer num2, Integer num3, Integer num4) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(sysName, "sysName");
        Intrinsics.checkNotNullParameter(nameButton, "nameButton");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(labels, "labels");
        this.id = i;
        this.title = title;
        this.sysName = sysName;
        this.statusButton = i2;
        this.nameButton = nameButton;
        this.status = status;
        this.labels = labels;
        this.rarity = num;
        this.rarityLevel = num2;
        this.favorite = num3;
        this.ratingPosition = num4;
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getSysName() {
        return this.sysName;
    }

    public final void setSysName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sysName = str;
    }

    public final int getStatusButton() {
        return this.statusButton;
    }

    public final void setStatusButton(int i) {
        this.statusButton = i;
    }

    public final String getNameButton() {
        return this.nameButton;
    }

    public final void setNameButton(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nameButton = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.status = str;
    }

    public final List<LabelInfo> getLabels() {
        return this.labels;
    }

    public final void setLabels(List<LabelInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.labels = list;
    }

    public final Integer getRarity() {
        return this.rarity;
    }

    public final Integer getRarityLevel() {
        return this.rarityLevel;
    }

    public final Integer getFavorite() {
        return this.favorite;
    }

    public final void setFavorite(Integer num) {
        this.favorite = num;
    }

    public final Integer getRatingPosition() {
        return this.ratingPosition;
    }
}
