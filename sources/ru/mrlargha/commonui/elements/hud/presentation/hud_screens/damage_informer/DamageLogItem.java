package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.damage_informer;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010/\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u00103\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010%J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¦\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00108J\u0014\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010<\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010=\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b#\u0010!R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0016R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0016R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0016¨\u0006>"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/damage_informer/DamageLogItem;", "", "type", "", "id", "", "name", "nameColor", "value", "", "totalValue", "valueColor", "imageId", "imageType", "showTime", "", "tag", "tagTextColor", "tagBackgroundColor", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getId", "()I", "getName", "getNameColor", "getValue", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getTotalValue", "getValueColor", "getImageId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImageType", "getShowTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTag", "getTagTextColor", "getTagBackgroundColor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/damage_informer/DamageLogItem;", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DamageLogItem {
    private final int id;
    private final Integer imageId;
    private final Integer imageType;
    private final String name;
    private final String nameColor;
    private final Long showTime;
    private final String tag;
    private final String tagBackgroundColor;
    private final String tagTextColor;
    private final Float totalValue;
    private final String type;
    private final Float value;
    private final String valueColor;

    public static /* synthetic */ DamageLogItem copy$default(DamageLogItem damageLogItem, String str, int i, String str2, String str3, Float f, Float f2, String str4, Integer num, Integer num2, Long l, String str5, String str6, String str7, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = damageLogItem.type;
        }
        return damageLogItem.copy(str, (i2 & 2) != 0 ? damageLogItem.id : i, (i2 & 4) != 0 ? damageLogItem.name : str2, (i2 & 8) != 0 ? damageLogItem.nameColor : str3, (i2 & 16) != 0 ? damageLogItem.value : f, (i2 & 32) != 0 ? damageLogItem.totalValue : f2, (i2 & 64) != 0 ? damageLogItem.valueColor : str4, (i2 & 128) != 0 ? damageLogItem.imageId : num, (i2 & 256) != 0 ? damageLogItem.imageType : num2, (i2 & 512) != 0 ? damageLogItem.showTime : l, (i2 & 1024) != 0 ? damageLogItem.tag : str5, (i2 & 2048) != 0 ? damageLogItem.tagTextColor : str6, (i2 & 4096) != 0 ? damageLogItem.tagBackgroundColor : str7);
    }

    public final String component1() {
        return this.type;
    }

    public final Long component10() {
        return this.showTime;
    }

    public final String component11() {
        return this.tag;
    }

    public final String component12() {
        return this.tagTextColor;
    }

    public final String component13() {
        return this.tagBackgroundColor;
    }

    public final int component2() {
        return this.id;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.nameColor;
    }

    public final Float component5() {
        return this.value;
    }

    public final Float component6() {
        return this.totalValue;
    }

    public final String component7() {
        return this.valueColor;
    }

    public final Integer component8() {
        return this.imageId;
    }

    public final Integer component9() {
        return this.imageType;
    }

    public final DamageLogItem copy(String type, int i, String str, String str2, Float f, Float f2, String str3, Integer num, Integer num2, Long l, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new DamageLogItem(type, i, str, str2, f, f2, str3, num, num2, l, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DamageLogItem) {
            DamageLogItem damageLogItem = (DamageLogItem) obj;
            return Intrinsics.areEqual(this.type, damageLogItem.type) && this.id == damageLogItem.id && Intrinsics.areEqual(this.name, damageLogItem.name) && Intrinsics.areEqual(this.nameColor, damageLogItem.nameColor) && Intrinsics.areEqual((Object) this.value, (Object) damageLogItem.value) && Intrinsics.areEqual((Object) this.totalValue, (Object) damageLogItem.totalValue) && Intrinsics.areEqual(this.valueColor, damageLogItem.valueColor) && Intrinsics.areEqual(this.imageId, damageLogItem.imageId) && Intrinsics.areEqual(this.imageType, damageLogItem.imageType) && Intrinsics.areEqual(this.showTime, damageLogItem.showTime) && Intrinsics.areEqual(this.tag, damageLogItem.tag) && Intrinsics.areEqual(this.tagTextColor, damageLogItem.tagTextColor) && Intrinsics.areEqual(this.tagBackgroundColor, damageLogItem.tagBackgroundColor);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.type.hashCode() * 31) + Integer.hashCode(this.id)) * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.nameColor;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Float f = this.value;
        int hashCode4 = (hashCode3 + (f == null ? 0 : f.hashCode())) * 31;
        Float f2 = this.totalValue;
        int hashCode5 = (hashCode4 + (f2 == null ? 0 : f2.hashCode())) * 31;
        String str3 = this.valueColor;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.imageId;
        int hashCode7 = (hashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.imageType;
        int hashCode8 = (hashCode7 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l = this.showTime;
        int hashCode9 = (hashCode8 + (l == null ? 0 : l.hashCode())) * 31;
        String str4 = this.tag;
        int hashCode10 = (hashCode9 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.tagTextColor;
        int hashCode11 = (hashCode10 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.tagBackgroundColor;
        return hashCode11 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        String str = this.type;
        int i = this.id;
        String str2 = this.name;
        String str3 = this.nameColor;
        Float f = this.value;
        Float f2 = this.totalValue;
        String str4 = this.valueColor;
        Integer num = this.imageId;
        Integer num2 = this.imageType;
        Long l = this.showTime;
        String str5 = this.tag;
        String str6 = this.tagTextColor;
        return "DamageLogItem(type=" + str + ", id=" + i + ", name=" + str2 + ", nameColor=" + str3 + ", value=" + f + ", totalValue=" + f2 + ", valueColor=" + str4 + ", imageId=" + num + ", imageType=" + num2 + ", showTime=" + l + ", tag=" + str5 + ", tagTextColor=" + str6 + ", tagBackgroundColor=" + this.tagBackgroundColor + ")";
    }

    public DamageLogItem(String type, int i, String str, String str2, Float f, Float f2, String str3, Integer num, Integer num2, Long l, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.id = i;
        this.name = str;
        this.nameColor = str2;
        this.value = f;
        this.totalValue = f2;
        this.valueColor = str3;
        this.imageId = num;
        this.imageType = num2;
        this.showTime = l;
        this.tag = str4;
        this.tagTextColor = str5;
        this.tagBackgroundColor = str6;
    }

    public /* synthetic */ DamageLogItem(String str, int i, String str2, String str3, Float f, Float f2, String str4, Integer num, Integer num2, Long l, String str5, String str6, String str7, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : f, (i2 & 32) != 0 ? null : f2, (i2 & 64) != 0 ? null : str4, (i2 & 128) != 0 ? null : num, (i2 & 256) != 0 ? null : num2, (i2 & 512) != 0 ? null : l, (i2 & 1024) != 0 ? null : str5, (i2 & 2048) != 0 ? null : str6, (i2 & 4096) != 0 ? null : str7);
    }

    public final String getType() {
        return this.type;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNameColor() {
        return this.nameColor;
    }

    public final Float getValue() {
        return this.value;
    }

    public final Float getTotalValue() {
        return this.totalValue;
    }

    public final String getValueColor() {
        return this.valueColor;
    }

    public final Integer getImageId() {
        return this.imageId;
    }

    public final Integer getImageType() {
        return this.imageType;
    }

    public final Long getShowTime() {
        return this.showTime;
    }

    public final String getTag() {
        return this.tag;
    }

    public final String getTagTextColor() {
        return this.tagTextColor;
    }

    public final String getTagBackgroundColor() {
        return this.tagBackgroundColor;
    }
}
