package ru.mrlargha.commonui.utils;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jn\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010&J\u0014\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010*\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010+\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012¨\u0006,"}, d2 = {"Lru/mrlargha/commonui/utils/ItemsInfo;", "", "id", "", "name", "", "icon", "type", "acs_slot", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "effect", "effectType", "customIcon", "<init>", "(ILjava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getIcon", "getType", "getAcs_slot", "getActive", "getEffect", "getEffectType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCustomIcon", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lru/mrlargha/commonui/utils/ItemsInfo;", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ItemsInfo {
    private final int acs_slot;
    private final int active;
    private final String customIcon;
    private final String effect;
    private final Integer effectType;
    private final String icon;
    private final int id;
    private final String name;
    private final int type;

    public static /* synthetic */ ItemsInfo copy$default(ItemsInfo itemsInfo, int i, String str, String str2, int i2, int i3, int i4, String str3, Integer num, String str4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = itemsInfo.id;
        }
        if ((i5 & 2) != 0) {
            str = itemsInfo.name;
        }
        if ((i5 & 4) != 0) {
            str2 = itemsInfo.icon;
        }
        if ((i5 & 8) != 0) {
            i2 = itemsInfo.type;
        }
        if ((i5 & 16) != 0) {
            i3 = itemsInfo.acs_slot;
        }
        if ((i5 & 32) != 0) {
            i4 = itemsInfo.active;
        }
        if ((i5 & 64) != 0) {
            str3 = itemsInfo.effect;
        }
        if ((i5 & 128) != 0) {
            num = itemsInfo.effectType;
        }
        if ((i5 & 256) != 0) {
            str4 = itemsInfo.customIcon;
        }
        Integer num2 = num;
        String str5 = str4;
        int i6 = i4;
        String str6 = str3;
        int i7 = i3;
        String str7 = str2;
        return itemsInfo.copy(i, str, str7, i2, i7, i6, str6, num2, str5);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.icon;
    }

    public final int component4() {
        return this.type;
    }

    public final int component5() {
        return this.acs_slot;
    }

    public final int component6() {
        return this.active;
    }

    public final String component7() {
        return this.effect;
    }

    public final Integer component8() {
        return this.effectType;
    }

    public final String component9() {
        return this.customIcon;
    }

    public final ItemsInfo copy(int i, String name, String icon, int i2, int i3, int i4, String str, Integer num, String str2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, "icon");
        return new ItemsInfo(i, name, icon, i2, i3, i4, str, num, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ItemsInfo) {
            ItemsInfo itemsInfo = (ItemsInfo) obj;
            return this.id == itemsInfo.id && Intrinsics.areEqual(this.name, itemsInfo.name) && Intrinsics.areEqual(this.icon, itemsInfo.icon) && this.type == itemsInfo.type && this.acs_slot == itemsInfo.acs_slot && this.active == itemsInfo.active && Intrinsics.areEqual(this.effect, itemsInfo.effect) && Intrinsics.areEqual(this.effectType, itemsInfo.effectType) && Intrinsics.areEqual(this.customIcon, itemsInfo.customIcon);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + this.icon.hashCode()) * 31) + Integer.hashCode(this.type)) * 31) + Integer.hashCode(this.acs_slot)) * 31) + Integer.hashCode(this.active)) * 31;
        String str = this.effect;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.effectType;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.customIcon;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        int i = this.id;
        String str = this.name;
        String str2 = this.icon;
        int i2 = this.type;
        int i3 = this.acs_slot;
        int i4 = this.active;
        String str3 = this.effect;
        Integer num = this.effectType;
        return "ItemsInfo(id=" + i + ", name=" + str + ", icon=" + str2 + ", type=" + i2 + ", acs_slot=" + i3 + ", active=" + i4 + ", effect=" + str3 + ", effectType=" + num + ", customIcon=" + this.customIcon + ")";
    }

    public ItemsInfo(int i, String name, String icon, int i2, int i3, int i4, String str, Integer num, String str2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.id = i;
        this.name = name;
        this.icon = icon;
        this.type = i2;
        this.acs_slot = i3;
        this.active = i4;
        this.effect = str;
        this.effectType = num;
        this.customIcon = str2;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getType() {
        return this.type;
    }

    public final int getAcs_slot() {
        return this.acs_slot;
    }

    public final int getActive() {
        return this.active;
    }

    public final String getEffect() {
        return this.effect;
    }

    public final Integer getEffectType() {
        return this.effectType;
    }

    public final String getCustomIcon() {
        return this.customIcon;
    }
}
