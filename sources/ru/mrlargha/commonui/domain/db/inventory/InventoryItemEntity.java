package ru.mrlargha.commonui.domain.db.inventory;

import io.appmetrica.analytics.impl.M2;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InventoryItemEntity.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b=\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bý\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001f\u0010 J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010%J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010F\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010P\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010%J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0018HÆ\u0003J\t\u0010T\u001a\u00020\u0018HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010X\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010Y\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010?J°\u0002\u0010Z\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0018HÆ\u0001¢\u0006\u0002\u0010[J\u0014\u0010\\\u001a\u00020\u00182\b\u0010]\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010^\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010_\u001a\u00020\u0007HÖ\u0081\u0004R\u001b\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\u0002\b#¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010&\u001a\u0004\b*\u0010%R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010&\u001a\u0004\b.\u0010%R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010&\u001a\u0004\b/\u0010%R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010&\u001a\u0004\b0\u0010%R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010&\u001a\u0004\b1\u0010%R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010&\u001a\u0004\b2\u0010%R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010&\u001a\u0004\b3\u0010%R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010&\u001a\u0004\b\u0011\u0010%R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010&\u001a\u0004\b4\u0010%R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010&\u001a\u0004\b5\u0010%R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010-\u001a\u0004\b6\u0010,R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010&\u001a\u0004\b7\u0010%R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\"R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u00109R\u0011\u0010\u0019\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u00109R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b:\u0010)R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010&\u001a\u0004\b;\u0010%R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010&\u001a\u0004\b<\u0010%R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b=\u0010)R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010@\u001a\u0004\b>\u0010?Ê\u0001\u0002\ba¨\u0006`"}, d2 = {"Lru/mrlargha/commonui/domain/db/inventory/InventoryItemEntity;", "", "slot", "", "item", "id", "text", "", "item_type", "amount", "", M2.g, "color", "bits", "available", "enchant", "breaks", "isActive", "itemStrength", "blackout", "time", "acsSlot", "inventoryType", "isColored", "", "isLocked", "effect", "effectType", "quality", "custom_icon", "loading", "<init>", "(ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;IZZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)V", "getSlot", "()I", "Landroidx/room/PrimaryKey;", "getItem", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "getText", "()Ljava/lang/String;", "getItem_type", "getAmount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getBackground", "getColor", "getBits", "getAvailable", "getEnchant", "getBreaks", "getItemStrength", "getBlackout", "getTime", "getAcsSlot", "getInventoryType", "()Z", "getEffect", "getEffectType", "getQuality", "getCustom_icon", "getLoading", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "copy", "(ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;IZZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)Lru/mrlargha/commonui/domain/db/inventory/InventoryItemEntity;", "equals", "other", "hashCode", "toString", "CommonUI", "Landroidx/room/Entity;"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InventoryItemEntity {
    private final Integer acsSlot;
    private final Long amount;
    private final Integer available;
    private final Integer background;
    private final Integer bits;
    private final Integer blackout;
    private final Integer breaks;
    private final Integer color;
    private final String custom_icon;
    private final String effect;
    private final Integer effectType;
    private final Integer enchant;
    private final int id;
    private final int inventoryType;
    private final Integer isActive;
    private final boolean isColored;
    private final boolean isLocked;
    private final Integer item;
    private final Integer itemStrength;
    private final Integer item_type;
    private final Boolean loading;
    private final Integer quality;
    private final int slot;
    private final String text;
    private final Long time;

    public static /* synthetic */ InventoryItemEntity copy$default(InventoryItemEntity inventoryItemEntity, int i, Integer num, int i2, String str, Integer num2, Long l, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Long l2, Integer num12, int i3, boolean z, boolean z2, String str2, Integer num13, Integer num14, String str3, Boolean bool, int i4, Object obj) {
        Boolean bool2;
        String str4;
        int i5 = (i4 & 1) != 0 ? inventoryItemEntity.slot : i;
        Integer num15 = (i4 & 2) != 0 ? inventoryItemEntity.item : num;
        int i6 = (i4 & 4) != 0 ? inventoryItemEntity.id : i2;
        String str5 = (i4 & 8) != 0 ? inventoryItemEntity.text : str;
        Integer num16 = (i4 & 16) != 0 ? inventoryItemEntity.item_type : num2;
        Long l3 = (i4 & 32) != 0 ? inventoryItemEntity.amount : l;
        Integer num17 = (i4 & 64) != 0 ? inventoryItemEntity.background : num3;
        Integer num18 = (i4 & 128) != 0 ? inventoryItemEntity.color : num4;
        Integer num19 = (i4 & 256) != 0 ? inventoryItemEntity.bits : num5;
        Integer num20 = (i4 & 512) != 0 ? inventoryItemEntity.available : num6;
        Integer num21 = (i4 & 1024) != 0 ? inventoryItemEntity.enchant : num7;
        Integer num22 = (i4 & 2048) != 0 ? inventoryItemEntity.breaks : num8;
        Integer num23 = (i4 & 4096) != 0 ? inventoryItemEntity.isActive : num9;
        Integer num24 = (i4 & 8192) != 0 ? inventoryItemEntity.itemStrength : num10;
        int i7 = i5;
        Integer num25 = (i4 & 16384) != 0 ? inventoryItemEntity.blackout : num11;
        Long l4 = (i4 & 32768) != 0 ? inventoryItemEntity.time : l2;
        Integer num26 = (i4 & 65536) != 0 ? inventoryItemEntity.acsSlot : num12;
        int i8 = (i4 & 131072) != 0 ? inventoryItemEntity.inventoryType : i3;
        boolean z3 = (i4 & 262144) != 0 ? inventoryItemEntity.isColored : z;
        boolean z4 = (i4 & 524288) != 0 ? inventoryItemEntity.isLocked : z2;
        String str6 = (i4 & 1048576) != 0 ? inventoryItemEntity.effect : str2;
        Integer num27 = (i4 & 2097152) != 0 ? inventoryItemEntity.effectType : num13;
        Integer num28 = (i4 & 4194304) != 0 ? inventoryItemEntity.quality : num14;
        String str7 = (i4 & 8388608) != 0 ? inventoryItemEntity.custom_icon : str3;
        if ((i4 & 16777216) != 0) {
            str4 = str7;
            bool2 = inventoryItemEntity.loading;
        } else {
            bool2 = bool;
            str4 = str7;
        }
        return inventoryItemEntity.copy(i7, num15, i6, str5, num16, l3, num17, num18, num19, num20, num21, num22, num23, num24, num25, l4, num26, i8, z3, z4, str6, num27, num28, str4, bool2);
    }

    public final int component1() {
        return this.slot;
    }

    public final Integer component10() {
        return this.available;
    }

    public final Integer component11() {
        return this.enchant;
    }

    public final Integer component12() {
        return this.breaks;
    }

    public final Integer component13() {
        return this.isActive;
    }

    public final Integer component14() {
        return this.itemStrength;
    }

    public final Integer component15() {
        return this.blackout;
    }

    public final Long component16() {
        return this.time;
    }

    public final Integer component17() {
        return this.acsSlot;
    }

    public final int component18() {
        return this.inventoryType;
    }

    public final boolean component19() {
        return this.isColored;
    }

    public final Integer component2() {
        return this.item;
    }

    public final boolean component20() {
        return this.isLocked;
    }

    public final String component21() {
        return this.effect;
    }

    public final Integer component22() {
        return this.effectType;
    }

    public final Integer component23() {
        return this.quality;
    }

    public final String component24() {
        return this.custom_icon;
    }

    public final Boolean component25() {
        return this.loading;
    }

    public final int component3() {
        return this.id;
    }

    public final String component4() {
        return this.text;
    }

    public final Integer component5() {
        return this.item_type;
    }

    public final Long component6() {
        return this.amount;
    }

    public final Integer component7() {
        return this.background;
    }

    public final Integer component8() {
        return this.color;
    }

    public final Integer component9() {
        return this.bits;
    }

    public final InventoryItemEntity copy(int i, Integer num, int i2, String str, Integer num2, Long l, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Long l2, Integer num12, int i3, boolean z, boolean z2, String str2, Integer num13, Integer num14, String str3, Boolean bool) {
        return new InventoryItemEntity(i, num, i2, str, num2, l, num3, num4, num5, num6, num7, num8, num9, num10, num11, l2, num12, i3, z, z2, str2, num13, num14, str3, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InventoryItemEntity) {
            InventoryItemEntity inventoryItemEntity = (InventoryItemEntity) obj;
            return this.slot == inventoryItemEntity.slot && Intrinsics.areEqual(this.item, inventoryItemEntity.item) && this.id == inventoryItemEntity.id && Intrinsics.areEqual(this.text, inventoryItemEntity.text) && Intrinsics.areEqual(this.item_type, inventoryItemEntity.item_type) && Intrinsics.areEqual(this.amount, inventoryItemEntity.amount) && Intrinsics.areEqual(this.background, inventoryItemEntity.background) && Intrinsics.areEqual(this.color, inventoryItemEntity.color) && Intrinsics.areEqual(this.bits, inventoryItemEntity.bits) && Intrinsics.areEqual(this.available, inventoryItemEntity.available) && Intrinsics.areEqual(this.enchant, inventoryItemEntity.enchant) && Intrinsics.areEqual(this.breaks, inventoryItemEntity.breaks) && Intrinsics.areEqual(this.isActive, inventoryItemEntity.isActive) && Intrinsics.areEqual(this.itemStrength, inventoryItemEntity.itemStrength) && Intrinsics.areEqual(this.blackout, inventoryItemEntity.blackout) && Intrinsics.areEqual(this.time, inventoryItemEntity.time) && Intrinsics.areEqual(this.acsSlot, inventoryItemEntity.acsSlot) && this.inventoryType == inventoryItemEntity.inventoryType && this.isColored == inventoryItemEntity.isColored && this.isLocked == inventoryItemEntity.isLocked && Intrinsics.areEqual(this.effect, inventoryItemEntity.effect) && Intrinsics.areEqual(this.effectType, inventoryItemEntity.effectType) && Intrinsics.areEqual(this.quality, inventoryItemEntity.quality) && Intrinsics.areEqual(this.custom_icon, inventoryItemEntity.custom_icon) && Intrinsics.areEqual(this.loading, inventoryItemEntity.loading);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.slot) * 31;
        Integer num = this.item;
        int hashCode2 = (((hashCode + (num == null ? 0 : num.hashCode())) * 31) + Integer.hashCode(this.id)) * 31;
        String str = this.text;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.item_type;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l = this.amount;
        int hashCode5 = (hashCode4 + (l == null ? 0 : l.hashCode())) * 31;
        Integer num3 = this.background;
        int hashCode6 = (hashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.color;
        int hashCode7 = (hashCode6 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.bits;
        int hashCode8 = (hashCode7 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.available;
        int hashCode9 = (hashCode8 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.enchant;
        int hashCode10 = (hashCode9 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Integer num8 = this.breaks;
        int hashCode11 = (hashCode10 + (num8 == null ? 0 : num8.hashCode())) * 31;
        Integer num9 = this.isActive;
        int hashCode12 = (hashCode11 + (num9 == null ? 0 : num9.hashCode())) * 31;
        Integer num10 = this.itemStrength;
        int hashCode13 = (hashCode12 + (num10 == null ? 0 : num10.hashCode())) * 31;
        Integer num11 = this.blackout;
        int hashCode14 = (hashCode13 + (num11 == null ? 0 : num11.hashCode())) * 31;
        Long l2 = this.time;
        int hashCode15 = (hashCode14 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Integer num12 = this.acsSlot;
        int hashCode16 = (((((((hashCode15 + (num12 == null ? 0 : num12.hashCode())) * 31) + Integer.hashCode(this.inventoryType)) * 31) + Boolean.hashCode(this.isColored)) * 31) + Boolean.hashCode(this.isLocked)) * 31;
        String str2 = this.effect;
        int hashCode17 = (hashCode16 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num13 = this.effectType;
        int hashCode18 = (hashCode17 + (num13 == null ? 0 : num13.hashCode())) * 31;
        Integer num14 = this.quality;
        int hashCode19 = (hashCode18 + (num14 == null ? 0 : num14.hashCode())) * 31;
        String str3 = this.custom_icon;
        int hashCode20 = (hashCode19 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.loading;
        return hashCode20 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        int i = this.slot;
        Integer num = this.item;
        int i2 = this.id;
        String str = this.text;
        Integer num2 = this.item_type;
        Long l = this.amount;
        Integer num3 = this.background;
        Integer num4 = this.color;
        Integer num5 = this.bits;
        Integer num6 = this.available;
        Integer num7 = this.enchant;
        Integer num8 = this.breaks;
        Integer num9 = this.isActive;
        Integer num10 = this.itemStrength;
        Integer num11 = this.blackout;
        Long l2 = this.time;
        Integer num12 = this.acsSlot;
        int i3 = this.inventoryType;
        boolean z = this.isColored;
        boolean z2 = this.isLocked;
        String str2 = this.effect;
        Integer num13 = this.effectType;
        Integer num14 = this.quality;
        String str3 = this.custom_icon;
        return "InventoryItemEntity(slot=" + i + ", item=" + num + ", id=" + i2 + ", text=" + str + ", item_type=" + num2 + ", amount=" + l + ", background=" + num3 + ", color=" + num4 + ", bits=" + num5 + ", available=" + num6 + ", enchant=" + num7 + ", breaks=" + num8 + ", isActive=" + num9 + ", itemStrength=" + num10 + ", blackout=" + num11 + ", time=" + l2 + ", acsSlot=" + num12 + ", inventoryType=" + i3 + ", isColored=" + z + ", isLocked=" + z2 + ", effect=" + str2 + ", effectType=" + num13 + ", quality=" + num14 + ", custom_icon=" + str3 + ", loading=" + this.loading + ")";
    }

    public InventoryItemEntity(int i, Integer num, int i2, String str, Integer num2, Long l, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Long l2, Integer num12, int i3, boolean z, boolean z2, String str2, Integer num13, Integer num14, String str3, Boolean bool) {
        this.slot = i;
        this.item = num;
        this.id = i2;
        this.text = str;
        this.item_type = num2;
        this.amount = l;
        this.background = num3;
        this.color = num4;
        this.bits = num5;
        this.available = num6;
        this.enchant = num7;
        this.breaks = num8;
        this.isActive = num9;
        this.itemStrength = num10;
        this.blackout = num11;
        this.time = l2;
        this.acsSlot = num12;
        this.inventoryType = i3;
        this.isColored = z;
        this.isLocked = z2;
        this.effect = str2;
        this.effectType = num13;
        this.quality = num14;
        this.custom_icon = str3;
        this.loading = bool;
    }

    public final int getSlot() {
        return this.slot;
    }

    public final Integer getItem() {
        return this.item;
    }

    public final int getId() {
        return this.id;
    }

    public final String getText() {
        return this.text;
    }

    public final Integer getItem_type() {
        return this.item_type;
    }

    public final Long getAmount() {
        return this.amount;
    }

    public final Integer getBackground() {
        return this.background;
    }

    public final Integer getColor() {
        return this.color;
    }

    public final Integer getBits() {
        return this.bits;
    }

    public final Integer getAvailable() {
        return this.available;
    }

    public final Integer getEnchant() {
        return this.enchant;
    }

    public final Integer getBreaks() {
        return this.breaks;
    }

    public final Integer isActive() {
        return this.isActive;
    }

    public final Integer getItemStrength() {
        return this.itemStrength;
    }

    public final Integer getBlackout() {
        return this.blackout;
    }

    public final Long getTime() {
        return this.time;
    }

    public final Integer getAcsSlot() {
        return this.acsSlot;
    }

    public final int getInventoryType() {
        return this.inventoryType;
    }

    public final boolean isColored() {
        return this.isColored;
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    public final String getEffect() {
        return this.effect;
    }

    public final Integer getEffectType() {
        return this.effectType;
    }

    public final Integer getQuality() {
        return this.quality;
    }

    public /* synthetic */ InventoryItemEntity(int i, Integer num, int i2, String str, Integer num2, Long l, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Long l2, Integer num12, int i3, boolean z, boolean z2, String str2, Integer num13, Integer num14, String str3, Boolean bool, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, num, i2, str, num2, l, num3, num4, num5, num6, num7, num8, num9, num10, num11, l2, num12, i3, z, z2, str2, num13, (i4 & 4194304) != 0 ? null : num14, (i4 & 8388608) != 0 ? "" : str3, (i4 & 16777216) != 0 ? false : bool);
    }

    public final String getCustom_icon() {
        return this.custom_icon;
    }

    public final Boolean getLoading() {
        return this.loading;
    }
}
