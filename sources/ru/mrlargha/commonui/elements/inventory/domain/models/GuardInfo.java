package ru.mrlargha.commonui.elements.inventory.domain.models;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GuardInfo.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b-\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B¹\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00103\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010:\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010=\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015HÆ\u0003J\u000f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015HÆ\u0003Jâ\u0001\u0010@\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00152\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015HÆ\u0001¢\u0006\u0002\u0010AJ\u0013\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010E\u001a\u00020\u0003HÖ\u0001J\t\u0010F\u001a\u00020\bHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001aR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001d\u0010\u001aR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001e\u0010\u001aR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b!\u0010\u001aR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\"\u0010\u001aR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b#\u0010\u001aR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b$\u0010\u001aR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b%\u0010\u001aR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b&\u0010\u001aR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010 R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b(\u0010\u001aR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b)\u0010\u001aR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-¨\u0006G"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/domain/models/GuardInfo;", "", "slot", "", "id", "skin", "skinBackground", "name", "", "health", "damage", "defence", FirebaseAnalytics.Param.LEVEL, "exp", "maxExp", "quality", "spawned", "died", "weaponItem", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "accessoriesList", "", "inventoryList", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;Ljava/util/List;Ljava/util/List;)V", "getSlot", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "getSkin", "getSkinBackground", "getName", "()Ljava/lang/String;", "getHealth", "getDamage", "getDefence", "getLevel", "getExp", "getMaxExp", "getQuality", "getSpawned", "getDied", "getWeaponItem", "()Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "getAccessoriesList", "()Ljava/util/List;", "getInventoryList", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;Ljava/util/List;Ljava/util/List;)Lru/mrlargha/commonui/elements/inventory/domain/models/GuardInfo;", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GuardInfo {
    private final List<InventoryItem> accessoriesList;
    private final Integer damage;
    private final Integer defence;
    private final Integer died;
    private final Integer exp;
    private final Integer health;
    private final Integer id;
    private final List<InventoryItem> inventoryList;
    private final Integer level;
    @SerializedName("max_exp")
    private final Integer maxExp;
    private final String name;
    private final String quality;
    private final Integer skin;
    @SerializedName("skin_background")
    private final Integer skinBackground;
    private final Integer slot;
    private final Integer spawned;
    private final InventoryItem weaponItem;

    public static /* synthetic */ GuardInfo copy$default(GuardInfo guardInfo, Integer num, Integer num2, Integer num3, Integer num4, String str, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, String str2, Integer num11, Integer num12, InventoryItem inventoryItem, List list, List list2, int i, Object obj) {
        List<InventoryItem> list3;
        List list4;
        Integer num13;
        GuardInfo guardInfo2;
        InventoryItem inventoryItem2;
        Integer num14;
        Integer num15;
        Integer num16;
        String str3;
        Integer num17;
        Integer num18;
        Integer num19;
        Integer num20;
        Integer num21;
        Integer num22;
        String str4;
        Integer num23;
        Integer num24;
        Integer num25 = (i & 1) != 0 ? guardInfo.slot : num;
        Integer num26 = (i & 2) != 0 ? guardInfo.id : num2;
        Integer num27 = (i & 4) != 0 ? guardInfo.skin : num3;
        Integer num28 = (i & 8) != 0 ? guardInfo.skinBackground : num4;
        String str5 = (i & 16) != 0 ? guardInfo.name : str;
        Integer num29 = (i & 32) != 0 ? guardInfo.health : num5;
        Integer num30 = (i & 64) != 0 ? guardInfo.damage : num6;
        Integer num31 = (i & 128) != 0 ? guardInfo.defence : num7;
        Integer num32 = (i & 256) != 0 ? guardInfo.level : num8;
        Integer num33 = (i & 512) != 0 ? guardInfo.exp : num9;
        Integer num34 = (i & 1024) != 0 ? guardInfo.maxExp : num10;
        String str6 = (i & 2048) != 0 ? guardInfo.quality : str2;
        Integer num35 = (i & 4096) != 0 ? guardInfo.spawned : num11;
        Integer num36 = (i & 8192) != 0 ? guardInfo.died : num12;
        Integer num37 = num25;
        InventoryItem inventoryItem3 = (i & 16384) != 0 ? guardInfo.weaponItem : inventoryItem;
        List list5 = (i & 32768) != 0 ? guardInfo.accessoriesList : list;
        if ((i & 65536) != 0) {
            list4 = list5;
            list3 = guardInfo.inventoryList;
            inventoryItem2 = inventoryItem3;
            num14 = num26;
            num15 = num27;
            num16 = num28;
            str3 = str5;
            num17 = num29;
            num18 = num30;
            num19 = num31;
            num20 = num32;
            num21 = num33;
            num22 = num34;
            str4 = str6;
            num23 = num35;
            num24 = num36;
            num13 = num37;
            guardInfo2 = guardInfo;
        } else {
            list3 = list2;
            list4 = list5;
            num13 = num37;
            guardInfo2 = guardInfo;
            inventoryItem2 = inventoryItem3;
            num14 = num26;
            num15 = num27;
            num16 = num28;
            str3 = str5;
            num17 = num29;
            num18 = num30;
            num19 = num31;
            num20 = num32;
            num21 = num33;
            num22 = num34;
            str4 = str6;
            num23 = num35;
            num24 = num36;
        }
        return guardInfo2.copy(num13, num14, num15, num16, str3, num17, num18, num19, num20, num21, num22, str4, num23, num24, inventoryItem2, list4, list3);
    }

    public final Integer component1() {
        return this.slot;
    }

    public final Integer component10() {
        return this.exp;
    }

    public final Integer component11() {
        return this.maxExp;
    }

    public final String component12() {
        return this.quality;
    }

    public final Integer component13() {
        return this.spawned;
    }

    public final Integer component14() {
        return this.died;
    }

    public final InventoryItem component15() {
        return this.weaponItem;
    }

    public final List<InventoryItem> component16() {
        return this.accessoriesList;
    }

    public final List<InventoryItem> component17() {
        return this.inventoryList;
    }

    public final Integer component2() {
        return this.id;
    }

    public final Integer component3() {
        return this.skin;
    }

    public final Integer component4() {
        return this.skinBackground;
    }

    public final String component5() {
        return this.name;
    }

    public final Integer component6() {
        return this.health;
    }

    public final Integer component7() {
        return this.damage;
    }

    public final Integer component8() {
        return this.defence;
    }

    public final Integer component9() {
        return this.level;
    }

    public final GuardInfo copy(Integer num, Integer num2, Integer num3, Integer num4, String str, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, String str2, Integer num11, Integer num12, InventoryItem inventoryItem, List<InventoryItem> accessoriesList, List<InventoryItem> inventoryList) {
        Intrinsics.checkNotNullParameter(accessoriesList, "accessoriesList");
        Intrinsics.checkNotNullParameter(inventoryList, "inventoryList");
        return new GuardInfo(num, num2, num3, num4, str, num5, num6, num7, num8, num9, num10, str2, num11, num12, inventoryItem, accessoriesList, inventoryList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GuardInfo) {
            GuardInfo guardInfo = (GuardInfo) obj;
            return Intrinsics.areEqual(this.slot, guardInfo.slot) && Intrinsics.areEqual(this.id, guardInfo.id) && Intrinsics.areEqual(this.skin, guardInfo.skin) && Intrinsics.areEqual(this.skinBackground, guardInfo.skinBackground) && Intrinsics.areEqual(this.name, guardInfo.name) && Intrinsics.areEqual(this.health, guardInfo.health) && Intrinsics.areEqual(this.damage, guardInfo.damage) && Intrinsics.areEqual(this.defence, guardInfo.defence) && Intrinsics.areEqual(this.level, guardInfo.level) && Intrinsics.areEqual(this.exp, guardInfo.exp) && Intrinsics.areEqual(this.maxExp, guardInfo.maxExp) && Intrinsics.areEqual(this.quality, guardInfo.quality) && Intrinsics.areEqual(this.spawned, guardInfo.spawned) && Intrinsics.areEqual(this.died, guardInfo.died) && Intrinsics.areEqual(this.weaponItem, guardInfo.weaponItem) && Intrinsics.areEqual(this.accessoriesList, guardInfo.accessoriesList) && Intrinsics.areEqual(this.inventoryList, guardInfo.inventoryList);
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.slot;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.id;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.skin;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.skinBackground;
        int hashCode4 = (hashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str = this.name;
        int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num5 = this.health;
        int hashCode6 = (hashCode5 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.damage;
        int hashCode7 = (hashCode6 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.defence;
        int hashCode8 = (hashCode7 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Integer num8 = this.level;
        int hashCode9 = (hashCode8 + (num8 == null ? 0 : num8.hashCode())) * 31;
        Integer num9 = this.exp;
        int hashCode10 = (hashCode9 + (num9 == null ? 0 : num9.hashCode())) * 31;
        Integer num10 = this.maxExp;
        int hashCode11 = (hashCode10 + (num10 == null ? 0 : num10.hashCode())) * 31;
        String str2 = this.quality;
        int hashCode12 = (hashCode11 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num11 = this.spawned;
        int hashCode13 = (hashCode12 + (num11 == null ? 0 : num11.hashCode())) * 31;
        Integer num12 = this.died;
        int hashCode14 = (hashCode13 + (num12 == null ? 0 : num12.hashCode())) * 31;
        InventoryItem inventoryItem = this.weaponItem;
        return ((((hashCode14 + (inventoryItem != null ? inventoryItem.hashCode() : 0)) * 31) + this.accessoriesList.hashCode()) * 31) + this.inventoryList.hashCode();
    }

    public String toString() {
        Integer num = this.slot;
        Integer num2 = this.id;
        Integer num3 = this.skin;
        Integer num4 = this.skinBackground;
        String str = this.name;
        Integer num5 = this.health;
        Integer num6 = this.damage;
        Integer num7 = this.defence;
        Integer num8 = this.level;
        Integer num9 = this.exp;
        Integer num10 = this.maxExp;
        String str2 = this.quality;
        Integer num11 = this.spawned;
        Integer num12 = this.died;
        InventoryItem inventoryItem = this.weaponItem;
        List<InventoryItem> list = this.accessoriesList;
        return "GuardInfo(slot=" + num + ", id=" + num2 + ", skin=" + num3 + ", skinBackground=" + num4 + ", name=" + str + ", health=" + num5 + ", damage=" + num6 + ", defence=" + num7 + ", level=" + num8 + ", exp=" + num9 + ", maxExp=" + num10 + ", quality=" + str2 + ", spawned=" + num11 + ", died=" + num12 + ", weaponItem=" + inventoryItem + ", accessoriesList=" + list + ", inventoryList=" + this.inventoryList + ")";
    }

    public GuardInfo(Integer num, Integer num2, Integer num3, Integer num4, String str, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, String str2, Integer num11, Integer num12, InventoryItem inventoryItem, List<InventoryItem> accessoriesList, List<InventoryItem> inventoryList) {
        Intrinsics.checkNotNullParameter(accessoriesList, "accessoriesList");
        Intrinsics.checkNotNullParameter(inventoryList, "inventoryList");
        this.slot = num;
        this.id = num2;
        this.skin = num3;
        this.skinBackground = num4;
        this.name = str;
        this.health = num5;
        this.damage = num6;
        this.defence = num7;
        this.level = num8;
        this.exp = num9;
        this.maxExp = num10;
        this.quality = str2;
        this.spawned = num11;
        this.died = num12;
        this.weaponItem = inventoryItem;
        this.accessoriesList = accessoriesList;
        this.inventoryList = inventoryList;
    }

    public final Integer getSlot() {
        return this.slot;
    }

    public final Integer getId() {
        return this.id;
    }

    public final Integer getSkin() {
        return this.skin;
    }

    public final Integer getSkinBackground() {
        return this.skinBackground;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getHealth() {
        return this.health;
    }

    public final Integer getDamage() {
        return this.damage;
    }

    public final Integer getDefence() {
        return this.defence;
    }

    public final Integer getLevel() {
        return this.level;
    }

    public final Integer getExp() {
        return this.exp;
    }

    public final Integer getMaxExp() {
        return this.maxExp;
    }

    public final String getQuality() {
        return this.quality;
    }

    public final Integer getSpawned() {
        return this.spawned;
    }

    public final Integer getDied() {
        return this.died;
    }

    public final InventoryItem getWeaponItem() {
        return this.weaponItem;
    }

    public final List<InventoryItem> getAccessoriesList() {
        return this.accessoriesList;
    }

    public final List<InventoryItem> getInventoryList() {
        return this.inventoryList;
    }
}
