package ru.mrlargha.commonui.elements.inventory.domain.models;

import android.graphics.Bitmap;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.gson.annotations.SerializedName;
import io.appmetrica.analytics.impl.M2;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InventoryItem.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b9\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\"\u0010#J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\u0010\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010W\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010^\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\t\u0010b\u001a\u00020\u0003HÆ\u0003J\u0010\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010d\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\t\u0010e\u001a\u00020\u001aHÆ\u0003J\t\u0010f\u001a\u00020\u001aHÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010j\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010k\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0002\u0010MJ\u0010\u0010l\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'JÈ\u0002\u0010m\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010nJ\u0014\u0010o\u001a\u00020\u001a2\b\u0010p\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010q\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010r\u001a\u00020\u0007HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b,\u0010'R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b2\u0010'R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b3\u0010'R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b4\u0010'R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b5\u0010'R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b6\u0010'R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b7\u0010'R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00101\u001a\u0004\b8\u0010.R)\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b:\u0012\b\b;\u0012\u0004\b\b(<¢\u0006\n\n\u0002\u0010(\u001a\u0004\b9\u0010'R)\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b:\u0012\b\b;\u0012\u0004\b\b(=¢\u0006\n\n\u0002\u0010(\u001a\u0004\b\u0013\u0010'R)\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b:\u0012\b\b;\u0012\u0004\b\b(?¢\u0006\n\n\u0002\u0010(\u001a\u0004\b>\u0010'R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010%R7\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\u001a\b:\u0012\b\b;\u0012\u0004\b\b(B\u0012\f\bC\u0012\b\b\fJ\u0004\b\b(\u0016¢\u0006\n\n\u0002\u0010(\u001a\u0004\bA\u0010'R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010FR\u0011\u0010\u001b\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010FR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bG\u0010+R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\bH\u0010'R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\bI\u0010'R'\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b:\u0012\b\b;\u0012\u0004\b\b(K¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010+R7\u0010 \u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004\u0092\u0002\u001a\b:\u0012\b\b;\u0012\u0004\b\b( \u0012\f\bC\u0012\b\b\fJ\u0004\b\b(O¢\u0006\n\n\u0002\u0010N\u001a\u0004\bL\u0010MR)\u0010!\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b:\u0012\b\b;\u0012\u0004\b\b(Q¢\u0006\n\n\u0002\u0010(\u001a\u0004\bP\u0010'¨\u0006s"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "", "slot", "", "item", TtmlNode.ATTR_ID, "text", "", "item_type", "amount", "", M2.g, "color", "bits", "available", "enchant", "blackout", "time", "itemStrength", "isActive", "breaks", "inventoryType", "acsSlot", "photoBitmap", "Landroid/graphics/Bitmap;", "isColored", "", "isLocked", "effect", "effectType", "quality", "customIcon", "loading", "gunSlot", "<init>", "(ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/lang/Integer;Landroid/graphics/Bitmap;ZZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getSlot", "()I", "getItem", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "getText", "()Ljava/lang/String;", "getItem_type", "getAmount", "()Ljava/lang/Long;", "setAmount", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getBackground", "getColor", "getBits", "getAvailable", "getEnchant", "getBlackout", "getTime", "getItemStrength", "Lcom/google/gson/annotations/SerializedName;", "value", "strength", "is_use", "getBreaks", "break", "getInventoryType", "getAcsSlot", "acs_slot", "alternate", "getPhotoBitmap", "()Landroid/graphics/Bitmap;", "()Z", "getEffect", "getEffectType", "getQuality", "getCustomIcon", "custom_icon", "getLoading", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "bool", "getGunSlot", "gun_slot", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "copy", "(ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/lang/Integer;Landroid/graphics/Bitmap;ZZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;)Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "equals", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InventoryItem {
    @SerializedName(alternate = {"acsSlot"}, value = "acs_slot")
    private final Integer acsSlot;
    private Long amount;
    private final Integer available;
    private final Integer background;
    private final Integer bits;
    private final Integer blackout;
    @SerializedName("break")
    private final Integer breaks;
    private final Integer color;
    @SerializedName("custom_icon")
    private final String customIcon;
    private final String effect;
    private final Integer effectType;
    private final Integer enchant;
    @SerializedName("gun_slot")
    private final Integer gunSlot;
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
    @SerializedName(alternate = {"bool"}, value = "loading")
    private final Boolean loading;
    private final Bitmap photoBitmap;
    private final Integer quality;
    private final int slot;
    private final String text;
    private final Long time;

    public static /* synthetic */ InventoryItem copy$default(InventoryItem inventoryItem, int i, Integer num, int i2, String str, Integer num2, Long l, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Long l2, Integer num9, Integer num10, Integer num11, int i3, Integer num12, Bitmap bitmap, boolean z, boolean z2, String str2, Integer num13, Integer num14, String str3, Boolean bool, Integer num15, int i4, Object obj) {
        Integer num16;
        Boolean bool2;
        int i5 = (i4 & 1) != 0 ? inventoryItem.slot : i;
        Integer num17 = (i4 & 2) != 0 ? inventoryItem.item : num;
        int i6 = (i4 & 4) != 0 ? inventoryItem.id : i2;
        String str4 = (i4 & 8) != 0 ? inventoryItem.text : str;
        Integer num18 = (i4 & 16) != 0 ? inventoryItem.item_type : num2;
        Long l3 = (i4 & 32) != 0 ? inventoryItem.amount : l;
        Integer num19 = (i4 & 64) != 0 ? inventoryItem.background : num3;
        Integer num20 = (i4 & 128) != 0 ? inventoryItem.color : num4;
        Integer num21 = (i4 & 256) != 0 ? inventoryItem.bits : num5;
        Integer num22 = (i4 & 512) != 0 ? inventoryItem.available : num6;
        Integer num23 = (i4 & 1024) != 0 ? inventoryItem.enchant : num7;
        Integer num24 = (i4 & 2048) != 0 ? inventoryItem.blackout : num8;
        Long l4 = (i4 & 4096) != 0 ? inventoryItem.time : l2;
        Integer num25 = (i4 & 8192) != 0 ? inventoryItem.itemStrength : num9;
        int i7 = i5;
        Integer num26 = (i4 & 16384) != 0 ? inventoryItem.isActive : num10;
        Integer num27 = (i4 & 32768) != 0 ? inventoryItem.breaks : num11;
        int i8 = (i4 & 65536) != 0 ? inventoryItem.inventoryType : i3;
        Integer num28 = (i4 & 131072) != 0 ? inventoryItem.acsSlot : num12;
        Bitmap bitmap2 = (i4 & 262144) != 0 ? inventoryItem.photoBitmap : bitmap;
        boolean z3 = (i4 & 524288) != 0 ? inventoryItem.isColored : z;
        boolean z4 = (i4 & 1048576) != 0 ? inventoryItem.isLocked : z2;
        String str5 = (i4 & 2097152) != 0 ? inventoryItem.effect : str2;
        Integer num29 = (i4 & 4194304) != 0 ? inventoryItem.effectType : num13;
        Integer num30 = (i4 & 8388608) != 0 ? inventoryItem.quality : num14;
        String str6 = (i4 & 16777216) != 0 ? inventoryItem.customIcon : str3;
        Boolean bool3 = (i4 & GroupFlagsKt.HasAuxSlotFlag) != 0 ? inventoryItem.loading : bool;
        if ((i4 & 67108864) != 0) {
            bool2 = bool3;
            num16 = inventoryItem.gunSlot;
        } else {
            num16 = num15;
            bool2 = bool3;
        }
        return inventoryItem.copy(i7, num17, i6, str4, num18, l3, num19, num20, num21, num22, num23, num24, l4, num25, num26, num27, i8, num28, bitmap2, z3, z4, str5, num29, num30, str6, bool2, num16);
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

    public final String component22() {
        return this.effect;
    }

    public final Integer component23() {
        return this.effectType;
    }

    public final Integer component24() {
        return this.quality;
    }

    public final String component25() {
        return this.customIcon;
    }

    public final Boolean component26() {
        return this.loading;
    }

    public final Integer component27() {
        return this.gunSlot;
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

    public final InventoryItem copy(int i, Integer num, int i2, String str, Integer num2, Long l, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Long l2, Integer num9, Integer num10, Integer num11, int i3, Integer num12, Bitmap bitmap, boolean z, boolean z2, String str2, Integer num13, Integer num14, String str3, Boolean bool, Integer num15) {
        return new InventoryItem(i, num, i2, str, num2, l, num3, num4, num5, num6, num7, num8, l2, num9, num10, num11, i3, num12, bitmap, z, z2, str2, num13, num14, str3, bool, num15);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InventoryItem) {
            InventoryItem inventoryItem = (InventoryItem) obj;
            return this.slot == inventoryItem.slot && Intrinsics.areEqual(this.item, inventoryItem.item) && this.id == inventoryItem.id && Intrinsics.areEqual(this.text, inventoryItem.text) && Intrinsics.areEqual(this.item_type, inventoryItem.item_type) && Intrinsics.areEqual(this.amount, inventoryItem.amount) && Intrinsics.areEqual(this.background, inventoryItem.background) && Intrinsics.areEqual(this.color, inventoryItem.color) && Intrinsics.areEqual(this.bits, inventoryItem.bits) && Intrinsics.areEqual(this.available, inventoryItem.available) && Intrinsics.areEqual(this.enchant, inventoryItem.enchant) && Intrinsics.areEqual(this.blackout, inventoryItem.blackout) && Intrinsics.areEqual(this.time, inventoryItem.time) && Intrinsics.areEqual(this.itemStrength, inventoryItem.itemStrength) && Intrinsics.areEqual(this.isActive, inventoryItem.isActive) && Intrinsics.areEqual(this.breaks, inventoryItem.breaks) && this.inventoryType == inventoryItem.inventoryType && Intrinsics.areEqual(this.acsSlot, inventoryItem.acsSlot) && Intrinsics.areEqual(this.photoBitmap, inventoryItem.photoBitmap) && this.isColored == inventoryItem.isColored && this.isLocked == inventoryItem.isLocked && Intrinsics.areEqual(this.effect, inventoryItem.effect) && Intrinsics.areEqual(this.effectType, inventoryItem.effectType) && Intrinsics.areEqual(this.quality, inventoryItem.quality) && Intrinsics.areEqual(this.customIcon, inventoryItem.customIcon) && Intrinsics.areEqual(this.loading, inventoryItem.loading) && Intrinsics.areEqual(this.gunSlot, inventoryItem.gunSlot);
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
        Integer num8 = this.blackout;
        int hashCode11 = (hashCode10 + (num8 == null ? 0 : num8.hashCode())) * 31;
        Long l2 = this.time;
        int hashCode12 = (hashCode11 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Integer num9 = this.itemStrength;
        int hashCode13 = (hashCode12 + (num9 == null ? 0 : num9.hashCode())) * 31;
        Integer num10 = this.isActive;
        int hashCode14 = (hashCode13 + (num10 == null ? 0 : num10.hashCode())) * 31;
        Integer num11 = this.breaks;
        int hashCode15 = (((hashCode14 + (num11 == null ? 0 : num11.hashCode())) * 31) + Integer.hashCode(this.inventoryType)) * 31;
        Integer num12 = this.acsSlot;
        int hashCode16 = (hashCode15 + (num12 == null ? 0 : num12.hashCode())) * 31;
        Bitmap bitmap = this.photoBitmap;
        int hashCode17 = (((((hashCode16 + (bitmap == null ? 0 : bitmap.hashCode())) * 31) + Boolean.hashCode(this.isColored)) * 31) + Boolean.hashCode(this.isLocked)) * 31;
        String str2 = this.effect;
        int hashCode18 = (hashCode17 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num13 = this.effectType;
        int hashCode19 = (hashCode18 + (num13 == null ? 0 : num13.hashCode())) * 31;
        Integer num14 = this.quality;
        int hashCode20 = (hashCode19 + (num14 == null ? 0 : num14.hashCode())) * 31;
        String str3 = this.customIcon;
        int hashCode21 = (hashCode20 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.loading;
        int hashCode22 = (hashCode21 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num15 = this.gunSlot;
        return hashCode22 + (num15 != null ? num15.hashCode() : 0);
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
        Integer num8 = this.blackout;
        Long l2 = this.time;
        Integer num9 = this.itemStrength;
        Integer num10 = this.isActive;
        Integer num11 = this.breaks;
        int i3 = this.inventoryType;
        Integer num12 = this.acsSlot;
        Bitmap bitmap = this.photoBitmap;
        boolean z = this.isColored;
        boolean z2 = this.isLocked;
        String str2 = this.effect;
        Integer num13 = this.effectType;
        Integer num14 = this.quality;
        String str3 = this.customIcon;
        Boolean bool = this.loading;
        return "InventoryItem(slot=" + i + ", item=" + num + ", id=" + i2 + ", text=" + str + ", item_type=" + num2 + ", amount=" + l + ", background=" + num3 + ", color=" + num4 + ", bits=" + num5 + ", available=" + num6 + ", enchant=" + num7 + ", blackout=" + num8 + ", time=" + l2 + ", itemStrength=" + num9 + ", isActive=" + num10 + ", breaks=" + num11 + ", inventoryType=" + i3 + ", acsSlot=" + num12 + ", photoBitmap=" + bitmap + ", isColored=" + z + ", isLocked=" + z2 + ", effect=" + str2 + ", effectType=" + num13 + ", quality=" + num14 + ", customIcon=" + str3 + ", loading=" + bool + ", gunSlot=" + this.gunSlot + ")";
    }

    public InventoryItem(int i, Integer num, int i2, String str, Integer num2, Long l, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Long l2, Integer num9, Integer num10, Integer num11, int i3, Integer num12, Bitmap bitmap, boolean z, boolean z2, String str2, Integer num13, Integer num14, String str3, Boolean bool, Integer num15) {
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
        this.blackout = num8;
        this.time = l2;
        this.itemStrength = num9;
        this.isActive = num10;
        this.breaks = num11;
        this.inventoryType = i3;
        this.acsSlot = num12;
        this.photoBitmap = bitmap;
        this.isColored = z;
        this.isLocked = z2;
        this.effect = str2;
        this.effectType = num13;
        this.quality = num14;
        this.customIcon = str3;
        this.loading = bool;
        this.gunSlot = num15;
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

    public final void setAmount(Long l) {
        this.amount = l;
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

    public final String getEffect() {
        return this.effect;
    }

    public final Integer getEffectType() {
        return this.effectType;
    }

    public final Integer getQuality() {
        return this.quality;
    }

    public /* synthetic */ InventoryItem(int i, Integer num, int i2, String str, Integer num2, Long l, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Long l2, Integer num9, Integer num10, Integer num11, int i3, Integer num12, Bitmap bitmap, boolean z, boolean z2, String str2, Integer num13, Integer num14, String str3, Boolean bool, Integer num15, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, num, i2, str, num2, l, num3, num4, num5, num6, num7, num8, l2, num9, num10, num11, i3, num12, bitmap, z, z2, str2, num13, (i4 & 8388608) != 0 ? null : num14, (i4 & 16777216) != 0 ? "" : str3, (i4 & GroupFlagsKt.HasAuxSlotFlag) != 0 ? null : bool, (i4 & 67108864) != 0 ? null : num15);
    }

    public final String getCustomIcon() {
        return this.customIcon;
    }

    public final Boolean getLoading() {
        return this.loading;
    }

    public final Integer getGunSlot() {
        return this.gunSlot;
    }
}
