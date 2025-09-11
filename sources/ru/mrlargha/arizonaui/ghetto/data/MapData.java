package ru.mrlargha.arizonaui.ghetto.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJp\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0014R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0016R\u0015\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001b¨\u0006-"}, d2 = {"Lru/mrlargha/arizonaui/ghetto/data/MapData;", "", "id", "", "fraction_id", "money", "respects", "isUniq", "", "balance", "drugs", "respawn_fraction_id", "drugden", "<init>", "(IIIIZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getId", "()I", "getFraction_id", "getMoney", "getRespects", "()Z", "getBalance", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDrugs", "getRespawn_fraction_id", "getDrugden", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IIIIZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)Lru/mrlargha/arizonaui/ghetto/data/MapData;", "equals", "other", "hashCode", "toString", "", "ArizonaUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MapData {
    private final Integer balance;
    private final Boolean drugden;
    private final Integer drugs;
    private final int fraction_id;
    private final int id;
    private final boolean isUniq;
    private final int money;
    private final Integer respawn_fraction_id;
    private final int respects;

    public static /* synthetic */ MapData copy$default(MapData mapData, int i, int i2, int i3, int i4, boolean z, Integer num, Integer num2, Integer num3, Boolean bool, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = mapData.id;
        }
        if ((i5 & 2) != 0) {
            i2 = mapData.fraction_id;
        }
        if ((i5 & 4) != 0) {
            i3 = mapData.money;
        }
        if ((i5 & 8) != 0) {
            i4 = mapData.respects;
        }
        if ((i5 & 16) != 0) {
            z = mapData.isUniq;
        }
        if ((i5 & 32) != 0) {
            num = mapData.balance;
        }
        if ((i5 & 64) != 0) {
            num2 = mapData.drugs;
        }
        if ((i5 & 128) != 0) {
            num3 = mapData.respawn_fraction_id;
        }
        if ((i5 & 256) != 0) {
            bool = mapData.drugden;
        }
        Integer num4 = num3;
        Boolean bool2 = bool;
        Integer num5 = num;
        Integer num6 = num2;
        boolean z2 = z;
        int i6 = i3;
        return mapData.copy(i, i2, i6, i4, z2, num5, num6, num4, bool2);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.fraction_id;
    }

    public final int component3() {
        return this.money;
    }

    public final int component4() {
        return this.respects;
    }

    public final boolean component5() {
        return this.isUniq;
    }

    public final Integer component6() {
        return this.balance;
    }

    public final Integer component7() {
        return this.drugs;
    }

    public final Integer component8() {
        return this.respawn_fraction_id;
    }

    public final Boolean component9() {
        return this.drugden;
    }

    public final MapData copy(int i, int i2, int i3, int i4, boolean z, Integer num, Integer num2, Integer num3, Boolean bool) {
        return new MapData(i, i2, i3, i4, z, num, num2, num3, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MapData) {
            MapData mapData = (MapData) obj;
            return this.id == mapData.id && this.fraction_id == mapData.fraction_id && this.money == mapData.money && this.respects == mapData.respects && this.isUniq == mapData.isUniq && Intrinsics.areEqual(this.balance, mapData.balance) && Intrinsics.areEqual(this.drugs, mapData.drugs) && Intrinsics.areEqual(this.respawn_fraction_id, mapData.respawn_fraction_id) && Intrinsics.areEqual(this.drugden, mapData.drugden);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.fraction_id)) * 31) + Integer.hashCode(this.money)) * 31) + Integer.hashCode(this.respects)) * 31) + Boolean.hashCode(this.isUniq)) * 31;
        Integer num = this.balance;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.drugs;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.respawn_fraction_id;
        int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Boolean bool = this.drugden;
        return hashCode4 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        int i = this.id;
        int i2 = this.fraction_id;
        int i3 = this.money;
        int i4 = this.respects;
        boolean z = this.isUniq;
        Integer num = this.balance;
        Integer num2 = this.drugs;
        Integer num3 = this.respawn_fraction_id;
        return "MapData(id=" + i + ", fraction_id=" + i2 + ", money=" + i3 + ", respects=" + i4 + ", isUniq=" + z + ", balance=" + num + ", drugs=" + num2 + ", respawn_fraction_id=" + num3 + ", drugden=" + this.drugden + ")";
    }

    public MapData(int i, int i2, int i3, int i4, boolean z, Integer num, Integer num2, Integer num3, Boolean bool) {
        this.id = i;
        this.fraction_id = i2;
        this.money = i3;
        this.respects = i4;
        this.isUniq = z;
        this.balance = num;
        this.drugs = num2;
        this.respawn_fraction_id = num3;
        this.drugden = bool;
    }

    public /* synthetic */ MapData(int i, int i2, int i3, int i4, boolean z, Integer num, Integer num2, Integer num3, Boolean bool, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, i4, (i5 & 16) != 0 ? false : z, num, num2, num3, bool);
    }

    public final int getId() {
        return this.id;
    }

    public final int getFraction_id() {
        return this.fraction_id;
    }

    public final int getMoney() {
        return this.money;
    }

    public final int getRespects() {
        return this.respects;
    }

    public final boolean isUniq() {
        return this.isUniq;
    }

    public final Integer getBalance() {
        return this.balance;
    }

    public final Integer getDrugs() {
        return this.drugs;
    }

    public final Integer getRespawn_fraction_id() {
        return this.respawn_fraction_id;
    }

    public final Boolean getDrugden() {
        return this.drugden;
    }
}
