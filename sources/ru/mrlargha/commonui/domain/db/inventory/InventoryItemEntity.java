package ru.mrlargha.commonui.domain.db.inventory;

import io.appmetrica.analytics.impl.L2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InventoryItemEntity.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b6\b\u0087\b\u0018\u00002\u00020\u0001BÅ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u00104\u001a\u00020\u0003HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\t\u00106\u001a\u00020\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010C\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010/J\u0010\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0018HÆ\u0003J\t\u0010G\u001a\u00020\u0018HÆ\u0003Jô\u0001\u0010H\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0018HÆ\u0001¢\u0006\u0002\u0010IJ\u0013\u0010J\u001a\u00020\u00182\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010L\u001a\u00020\u0003HÖ\u0001J\t\u0010M\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b$\u0010\u001fR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b%\u0010\u001fR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b&\u0010\u001fR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b'\u0010\u001fR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b(\u0010\u001fR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b)\u0010\u001fR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b*\u0010\u001fR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b+\u0010\u001fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u0010\u0010\u001fR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b,\u0010\u001fR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b-\u0010\u001fR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b1\u0010\u001fR\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001dR\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u00103R\u0011\u0010\u0019\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u00103¨\u0006N"}, d2 = {"Lru/mrlargha/commonui/domain/db/inventory/InventoryItemEntity;", "", "slot", "", "item", "id", "text", "", "item_type", "amount", L2.g, "color", "bits", "available", "enchant", "breaks", "isActive", "itemStrength", "blackout", "time", "", "acsSlot", "inventoryType", "isColored", "", "isLocked", "<init>", "(ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;IZZ)V", "getSlot", "()I", "getItem", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "getText", "()Ljava/lang/String;", "getItem_type", "getAmount", "getBackground", "getColor", "getBits", "getAvailable", "getEnchant", "getBreaks", "getItemStrength", "getBlackout", "getTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAcsSlot", "getInventoryType", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;IZZ)Lru/mrlargha/commonui/domain/db/inventory/InventoryItemEntity;", "equals", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InventoryItemEntity {
    private final Integer acsSlot;
    private final Integer amount;
    private final Integer available;
    private final Integer background;
    private final Integer bits;
    private final Integer blackout;
    private final Integer breaks;
    private final Integer color;
    private final Integer enchant;
    private final int id;
    private final int inventoryType;
    private final Integer isActive;
    private final boolean isColored;
    private final boolean isLocked;
    private final Integer item;
    private final Integer itemStrength;
    private final Integer item_type;
    private final int slot;
    private final String text;
    private final Long time;

    public static /* synthetic */ InventoryItemEntity copy$default(InventoryItemEntity inventoryItemEntity, int i, Integer num, int i2, String str, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Long l, Integer num13, int i3, boolean z, boolean z2, int i4, Object obj) {
        boolean z3;
        boolean z4;
        int i5 = (i4 & 1) != 0 ? inventoryItemEntity.slot : i;
        Integer num14 = (i4 & 2) != 0 ? inventoryItemEntity.item : num;
        int i6 = (i4 & 4) != 0 ? inventoryItemEntity.id : i2;
        String str2 = (i4 & 8) != 0 ? inventoryItemEntity.text : str;
        Integer num15 = (i4 & 16) != 0 ? inventoryItemEntity.item_type : num2;
        Integer num16 = (i4 & 32) != 0 ? inventoryItemEntity.amount : num3;
        Integer num17 = (i4 & 64) != 0 ? inventoryItemEntity.background : num4;
        Integer num18 = (i4 & 128) != 0 ? inventoryItemEntity.color : num5;
        Integer num19 = (i4 & 256) != 0 ? inventoryItemEntity.bits : num6;
        Integer num20 = (i4 & 512) != 0 ? inventoryItemEntity.available : num7;
        Integer num21 = (i4 & 1024) != 0 ? inventoryItemEntity.enchant : num8;
        Integer num22 = (i4 & 2048) != 0 ? inventoryItemEntity.breaks : num9;
        Integer num23 = (i4 & 4096) != 0 ? inventoryItemEntity.isActive : num10;
        Integer num24 = (i4 & 8192) != 0 ? inventoryItemEntity.itemStrength : num11;
        int i7 = i5;
        Integer num25 = (i4 & 16384) != 0 ? inventoryItemEntity.blackout : num12;
        Long l2 = (i4 & 32768) != 0 ? inventoryItemEntity.time : l;
        Integer num26 = (i4 & 65536) != 0 ? inventoryItemEntity.acsSlot : num13;
        int i8 = (i4 & 131072) != 0 ? inventoryItemEntity.inventoryType : i3;
        boolean z5 = (i4 & 262144) != 0 ? inventoryItemEntity.isColored : z;
        if ((i4 & 524288) != 0) {
            z4 = z5;
            z3 = inventoryItemEntity.isLocked;
        } else {
            z3 = z2;
            z4 = z5;
        }
        return inventoryItemEntity.copy(i7, num14, i6, str2, num15, num16, num17, num18, num19, num20, num21, num22, num23, num24, num25, l2, num26, i8, z4, z3);
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

    public final int component3() {
        return this.id;
    }

    public final String component4() {
        return this.text;
    }

    public final Integer component5() {
        return this.item_type;
    }

    public final Integer component6() {
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

    public final InventoryItemEntity copy(int i, Integer num, int i2, String str, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Long l, Integer num13, int i3, boolean z, boolean z2) {
        return new InventoryItemEntity(i, num, i2, str, num2, num3, num4, num5, num6, num7, num8, num9, num10, num11, num12, l, num13, i3, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InventoryItemEntity) {
            InventoryItemEntity inventoryItemEntity = (InventoryItemEntity) obj;
            return this.slot == inventoryItemEntity.slot && Intrinsics.areEqual(this.item, inventoryItemEntity.item) && this.id == inventoryItemEntity.id && Intrinsics.areEqual(this.text, inventoryItemEntity.text) && Intrinsics.areEqual(this.item_type, inventoryItemEntity.item_type) && Intrinsics.areEqual(this.amount, inventoryItemEntity.amount) && Intrinsics.areEqual(this.background, inventoryItemEntity.background) && Intrinsics.areEqual(this.color, inventoryItemEntity.color) && Intrinsics.areEqual(this.bits, inventoryItemEntity.bits) && Intrinsics.areEqual(this.available, inventoryItemEntity.available) && Intrinsics.areEqual(this.enchant, inventoryItemEntity.enchant) && Intrinsics.areEqual(this.breaks, inventoryItemEntity.breaks) && Intrinsics.areEqual(this.isActive, inventoryItemEntity.isActive) && Intrinsics.areEqual(this.itemStrength, inventoryItemEntity.itemStrength) && Intrinsics.areEqual(this.blackout, inventoryItemEntity.blackout) && Intrinsics.areEqual(this.time, inventoryItemEntity.time) && Intrinsics.areEqual(this.acsSlot, inventoryItemEntity.acsSlot) && this.inventoryType == inventoryItemEntity.inventoryType && this.isColored == inventoryItemEntity.isColored && this.isLocked == inventoryItemEntity.isLocked;
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
        Integer num3 = this.amount;
        int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.background;
        int hashCode6 = (hashCode5 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.color;
        int hashCode7 = (hashCode6 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.bits;
        int hashCode8 = (hashCode7 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.available;
        int hashCode9 = (hashCode8 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Integer num8 = this.enchant;
        int hashCode10 = (hashCode9 + (num8 == null ? 0 : num8.hashCode())) * 31;
        Integer num9 = this.breaks;
        int hashCode11 = (hashCode10 + (num9 == null ? 0 : num9.hashCode())) * 31;
        Integer num10 = this.isActive;
        int hashCode12 = (hashCode11 + (num10 == null ? 0 : num10.hashCode())) * 31;
        Integer num11 = this.itemStrength;
        int hashCode13 = (hashCode12 + (num11 == null ? 0 : num11.hashCode())) * 31;
        Integer num12 = this.blackout;
        int hashCode14 = (hashCode13 + (num12 == null ? 0 : num12.hashCode())) * 31;
        Long l = this.time;
        int hashCode15 = (hashCode14 + (l == null ? 0 : l.hashCode())) * 31;
        Integer num13 = this.acsSlot;
        return ((((((hashCode15 + (num13 != null ? num13.hashCode() : 0)) * 31) + Integer.hashCode(this.inventoryType)) * 31) + Boolean.hashCode(this.isColored)) * 31) + Boolean.hashCode(this.isLocked);
    }

    public String toString() {
        int i = this.slot;
        Integer num = this.item;
        int i2 = this.id;
        String str = this.text;
        Integer num2 = this.item_type;
        Integer num3 = this.amount;
        Integer num4 = this.background;
        Integer num5 = this.color;
        Integer num6 = this.bits;
        Integer num7 = this.available;
        Integer num8 = this.enchant;
        Integer num9 = this.breaks;
        Integer num10 = this.isActive;
        Integer num11 = this.itemStrength;
        Integer num12 = this.blackout;
        Long l = this.time;
        Integer num13 = this.acsSlot;
        int i3 = this.inventoryType;
        boolean z = this.isColored;
        return "InventoryItemEntity(slot=" + i + ", item=" + num + ", id=" + i2 + ", text=" + str + ", item_type=" + num2 + ", amount=" + num3 + ", background=" + num4 + ", color=" + num5 + ", bits=" + num6 + ", available=" + num7 + ", enchant=" + num8 + ", breaks=" + num9 + ", isActive=" + num10 + ", itemStrength=" + num11 + ", blackout=" + num12 + ", time=" + l + ", acsSlot=" + num13 + ", inventoryType=" + i3 + ", isColored=" + z + ", isLocked=" + this.isLocked + ")";
    }

    public InventoryItemEntity(int i, Integer num, int i2, String str, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Long l, Integer num13, int i3, boolean z, boolean z2) {
        this.slot = i;
        this.item = num;
        this.id = i2;
        this.text = str;
        this.item_type = num2;
        this.amount = num3;
        this.background = num4;
        this.color = num5;
        this.bits = num6;
        this.available = num7;
        this.enchant = num8;
        this.breaks = num9;
        this.isActive = num10;
        this.itemStrength = num11;
        this.blackout = num12;
        this.time = l;
        this.acsSlot = num13;
        this.inventoryType = i3;
        this.isColored = z;
        this.isLocked = z2;
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

    public final Integer getAmount() {
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
}
