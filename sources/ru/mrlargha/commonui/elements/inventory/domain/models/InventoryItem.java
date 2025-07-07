package ru.mrlargha.commonui.elements.inventory.domain.models;

import android.graphics.Bitmap;
import com.google.gson.annotations.SerializedName;
import io.appmetrica.analytics.impl.L2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InventoryItem.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b;\b\u0086\b\u0018\u00002\u00020\u0001BÏ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010:\u001a\u00020\u0003HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010F\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\u0010\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010L\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\t\u0010M\u001a\u00020\u001aHÆ\u0003J\t\u0010N\u001a\u00020\u001aHÆ\u0003J\u0080\u0002\u0010O\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001aHÆ\u0001¢\u0006\u0002\u0010PJ\u0013\u0010Q\u001a\u00020\u001a2\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010S\u001a\u00020\u0003HÖ\u0001J\t\u0010T\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b&\u0010!R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b'\u0010!\"\u0004\b(\u0010)R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b*\u0010!R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b+\u0010!R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b,\u0010!R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b-\u0010!R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b.\u0010!R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b/\u0010!R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b3\u0010!R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b\u0013\u0010!R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b4\u0010!R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001fR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b6\u0010!R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u00109R\u0011\u0010\u001b\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u00109¨\u0006U"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "", "slot", "", "item", "id", "text", "", "item_type", "amount", L2.g, "color", "bits", "available", "enchant", "blackout", "time", "", "itemStrength", "isActive", "breaks", "inventoryType", "acsSlot", "photoBitmap", "Landroid/graphics/Bitmap;", "isColored", "", "isLocked", "<init>", "(ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/lang/Integer;Landroid/graphics/Bitmap;ZZ)V", "getSlot", "()I", "getItem", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "getText", "()Ljava/lang/String;", "getItem_type", "getAmount", "setAmount", "(Ljava/lang/Integer;)V", "getBackground", "getColor", "getBits", "getAvailable", "getEnchant", "getBlackout", "getTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getItemStrength", "getBreaks", "getInventoryType", "getAcsSlot", "getPhotoBitmap", "()Landroid/graphics/Bitmap;", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "(ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/lang/Integer;Landroid/graphics/Bitmap;ZZ)Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "equals", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InventoryItem {
    private final Integer acsSlot;
    private Integer amount;
    private final Integer available;
    private final Integer background;
    private final Integer bits;
    private final Integer blackout;
    @SerializedName("break")
    private final Integer breaks;
    private final Integer color;
    private final Integer enchant;
    private final int id;
    private final int inventoryType;
    @SerializedName("is_use")
    private final Integer isActive;
    private final boolean isColored;
    private final boolean isLocked;
    private final Integer item;
    @SerializedName("strength")
    private final Integer itemStrength;
    private final Integer item_type;
    private final Bitmap photoBitmap;
    private final int slot;
    private final String text;
    private final Long time;

    public static /* synthetic */ InventoryItem copy$default(InventoryItem inventoryItem, int i, Integer num, int i2, String str, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Long l, Integer num10, Integer num11, Integer num12, int i3, Integer num13, Bitmap bitmap, boolean z, boolean z2, int i4, Object obj) {
        boolean z3;
        boolean z4;
        int i5 = (i4 & 1) != 0 ? inventoryItem.slot : i;
        Integer num14 = (i4 & 2) != 0 ? inventoryItem.item : num;
        int i6 = (i4 & 4) != 0 ? inventoryItem.id : i2;
        String str2 = (i4 & 8) != 0 ? inventoryItem.text : str;
        Integer num15 = (i4 & 16) != 0 ? inventoryItem.item_type : num2;
        Integer num16 = (i4 & 32) != 0 ? inventoryItem.amount : num3;
        Integer num17 = (i4 & 64) != 0 ? inventoryItem.background : num4;
        Integer num18 = (i4 & 128) != 0 ? inventoryItem.color : num5;
        Integer num19 = (i4 & 256) != 0 ? inventoryItem.bits : num6;
        Integer num20 = (i4 & 512) != 0 ? inventoryItem.available : num7;
        Integer num21 = (i4 & 1024) != 0 ? inventoryItem.enchant : num8;
        Integer num22 = (i4 & 2048) != 0 ? inventoryItem.blackout : num9;
        Long l2 = (i4 & 4096) != 0 ? inventoryItem.time : l;
        Integer num23 = (i4 & 8192) != 0 ? inventoryItem.itemStrength : num10;
        int i7 = i5;
        Integer num24 = (i4 & 16384) != 0 ? inventoryItem.isActive : num11;
        Integer num25 = (i4 & 32768) != 0 ? inventoryItem.breaks : num12;
        int i8 = (i4 & 65536) != 0 ? inventoryItem.inventoryType : i3;
        Integer num26 = (i4 & 131072) != 0 ? inventoryItem.acsSlot : num13;
        Bitmap bitmap2 = (i4 & 262144) != 0 ? inventoryItem.photoBitmap : bitmap;
        boolean z5 = (i4 & 524288) != 0 ? inventoryItem.isColored : z;
        if ((i4 & 1048576) != 0) {
            z4 = z5;
            z3 = inventoryItem.isLocked;
        } else {
            z3 = z2;
            z4 = z5;
        }
        return inventoryItem.copy(i7, num14, i6, str2, num15, num16, num17, num18, num19, num20, num21, num22, l2, num23, num24, num25, i8, num26, bitmap2, z4, z3);
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
        return this.blackout;
    }

    public final Long component13() {
        return this.time;
    }

    public final Integer component14() {
        return this.itemStrength;
    }

    public final Integer component15() {
        return this.isActive;
    }

    public final Integer component16() {
        return this.breaks;
    }

    public final int component17() {
        return this.inventoryType;
    }

    public final Integer component18() {
        return this.acsSlot;
    }

    public final Bitmap component19() {
        return this.photoBitmap;
    }

    public final Integer component2() {
        return this.item;
    }

    public final boolean component20() {
        return this.isColored;
    }

    public final boolean component21() {
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

    public final InventoryItem copy(int i, Integer num, int i2, String str, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Long l, Integer num10, Integer num11, Integer num12, int i3, Integer num13, Bitmap bitmap, boolean z, boolean z2) {
        return new InventoryItem(i, num, i2, str, num2, num3, num4, num5, num6, num7, num8, num9, l, num10, num11, num12, i3, num13, bitmap, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InventoryItem) {
            InventoryItem inventoryItem = (InventoryItem) obj;
            return this.slot == inventoryItem.slot && Intrinsics.areEqual(this.item, inventoryItem.item) && this.id == inventoryItem.id && Intrinsics.areEqual(this.text, inventoryItem.text) && Intrinsics.areEqual(this.item_type, inventoryItem.item_type) && Intrinsics.areEqual(this.amount, inventoryItem.amount) && Intrinsics.areEqual(this.background, inventoryItem.background) && Intrinsics.areEqual(this.color, inventoryItem.color) && Intrinsics.areEqual(this.bits, inventoryItem.bits) && Intrinsics.areEqual(this.available, inventoryItem.available) && Intrinsics.areEqual(this.enchant, inventoryItem.enchant) && Intrinsics.areEqual(this.blackout, inventoryItem.blackout) && Intrinsics.areEqual(this.time, inventoryItem.time) && Intrinsics.areEqual(this.itemStrength, inventoryItem.itemStrength) && Intrinsics.areEqual(this.isActive, inventoryItem.isActive) && Intrinsics.areEqual(this.breaks, inventoryItem.breaks) && this.inventoryType == inventoryItem.inventoryType && Intrinsics.areEqual(this.acsSlot, inventoryItem.acsSlot) && Intrinsics.areEqual(this.photoBitmap, inventoryItem.photoBitmap) && this.isColored == inventoryItem.isColored && this.isLocked == inventoryItem.isLocked;
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
        Integer num9 = this.blackout;
        int hashCode11 = (hashCode10 + (num9 == null ? 0 : num9.hashCode())) * 31;
        Long l = this.time;
        int hashCode12 = (hashCode11 + (l == null ? 0 : l.hashCode())) * 31;
        Integer num10 = this.itemStrength;
        int hashCode13 = (hashCode12 + (num10 == null ? 0 : num10.hashCode())) * 31;
        Integer num11 = this.isActive;
        int hashCode14 = (hashCode13 + (num11 == null ? 0 : num11.hashCode())) * 31;
        Integer num12 = this.breaks;
        int hashCode15 = (((hashCode14 + (num12 == null ? 0 : num12.hashCode())) * 31) + Integer.hashCode(this.inventoryType)) * 31;
        Integer num13 = this.acsSlot;
        int hashCode16 = (hashCode15 + (num13 == null ? 0 : num13.hashCode())) * 31;
        Bitmap bitmap = this.photoBitmap;
        return ((((hashCode16 + (bitmap != null ? bitmap.hashCode() : 0)) * 31) + Boolean.hashCode(this.isColored)) * 31) + Boolean.hashCode(this.isLocked);
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
        Integer num9 = this.blackout;
        Long l = this.time;
        Integer num10 = this.itemStrength;
        Integer num11 = this.isActive;
        Integer num12 = this.breaks;
        int i3 = this.inventoryType;
        Integer num13 = this.acsSlot;
        Bitmap bitmap = this.photoBitmap;
        boolean z = this.isColored;
        return "InventoryItem(slot=" + i + ", item=" + num + ", id=" + i2 + ", text=" + str + ", item_type=" + num2 + ", amount=" + num3 + ", background=" + num4 + ", color=" + num5 + ", bits=" + num6 + ", available=" + num7 + ", enchant=" + num8 + ", blackout=" + num9 + ", time=" + l + ", itemStrength=" + num10 + ", isActive=" + num11 + ", breaks=" + num12 + ", inventoryType=" + i3 + ", acsSlot=" + num13 + ", photoBitmap=" + bitmap + ", isColored=" + z + ", isLocked=" + this.isLocked + ")";
    }

    public InventoryItem(int i, Integer num, int i2, String str, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Long l, Integer num10, Integer num11, Integer num12, int i3, Integer num13, Bitmap bitmap, boolean z, boolean z2) {
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
        this.blackout = num9;
        this.time = l;
        this.itemStrength = num10;
        this.isActive = num11;
        this.breaks = num12;
        this.inventoryType = i3;
        this.acsSlot = num13;
        this.photoBitmap = bitmap;
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

    public final void setAmount(Integer num) {
        this.amount = num;
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

    public final Integer getBlackout() {
        return this.blackout;
    }

    public final Long getTime() {
        return this.time;
    }

    public final Integer getItemStrength() {
        return this.itemStrength;
    }

    public final Integer isActive() {
        return this.isActive;
    }

    public final Integer getBreaks() {
        return this.breaks;
    }

    public final int getInventoryType() {
        return this.inventoryType;
    }

    public final Integer getAcsSlot() {
        return this.acsSlot;
    }

    public final Bitmap getPhotoBitmap() {
        return this.photoBitmap;
    }

    public final boolean isColored() {
        return this.isColored;
    }

    public final boolean isLocked() {
        return this.isLocked;
    }
}
