package ru.mrlargha.arizonaui.ghetto.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b&\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010)\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001fJp\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010+J\u0014\u0010,\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010.\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010/\u001a\u000200HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0016R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001d\u0010\u001bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001f¨\u00061"}, d2 = {"Lru/mrlargha/arizonaui/ghetto/data/MapData;", "", "id", "", "fraction_id", "money", "", "respects", "isUniq", "", "balance", "drugs", "respawn_fraction_id", "drugden", "<init>", "(IIJIZLjava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getId", "()I", "getFraction_id", "getMoney", "()J", "getRespects", "()Z", "getBalance", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDrugs", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRespawn_fraction_id", "getDrugden", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IIJIZLjava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)Lru/mrlargha/arizonaui/ghetto/data/MapData;", "equals", "other", "hashCode", "toString", "", "ArizonaUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MapData {
    private final Long balance;
    private final Boolean drugden;
    private final Integer drugs;
    private final int fraction_id;
    private final int id;
    private final boolean isUniq;
    private final long money;
    private final Integer respawn_fraction_id;
    private final int respects;

    public static /* synthetic */ MapData copy$default(MapData mapData, int i, int i2, long j, int i3, boolean z, Long l, Integer num, Integer num2, Boolean bool, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = mapData.id;
        }
        if ((i4 & 2) != 0) {
            i2 = mapData.fraction_id;
        }
        if ((i4 & 4) != 0) {
            j = mapData.money;
        }
        if ((i4 & 8) != 0) {
            i3 = mapData.respects;
        }
        if ((i4 & 16) != 0) {
            z = mapData.isUniq;
        }
        if ((i4 & 32) != 0) {
            l = mapData.balance;
        }
        if ((i4 & 64) != 0) {
            num = mapData.drugs;
        }
        if ((i4 & 128) != 0) {
            num2 = mapData.respawn_fraction_id;
        }
        if ((i4 & 256) != 0) {
            bool = mapData.drugden;
        }
        Integer num3 = num2;
        Boolean bool2 = bool;
        long j2 = j;
        return mapData.copy(i, i2, j2, i3, z, l, num, num3, bool2);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.fraction_id;
    }

    public final long component3() {
        return this.money;
    }

    public final int component4() {
        return this.respects;
    }

    public final boolean component5() {
        return this.isUniq;
    }

    public final Long component6() {
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

    public final MapData copy(int i, int i2, long j, int i3, boolean z, Long l, Integer num, Integer num2, Boolean bool) {
        return new MapData(i, i2, j, i3, z, l, num, num2, bool);
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
        int hashCode = ((((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.fraction_id)) * 31) + Long.hashCode(this.money)) * 31) + Integer.hashCode(this.respects)) * 31) + Boolean.hashCode(this.isUniq)) * 31;
        Long l = this.balance;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        Integer num = this.drugs;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.respawn_fraction_id;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.drugden;
        return hashCode4 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        int i = this.id;
        int i2 = this.fraction_id;
        long j = this.money;
        int i3 = this.respects;
        boolean z = this.isUniq;
        Long l = this.balance;
        Integer num = this.drugs;
        Integer num2 = this.respawn_fraction_id;
        return "MapData(id=" + i + ", fraction_id=" + i2 + ", money=" + j + ", respects=" + i3 + ", isUniq=" + z + ", balance=" + l + ", drugs=" + num + ", respawn_fraction_id=" + num2 + ", drugden=" + this.drugden + ")";
    }

    public MapData(int i, int i2, long j, int i3, boolean z, Long l, Integer num, Integer num2, Boolean bool) {
        this.id = i;
        this.fraction_id = i2;
        this.money = j;
        this.respects = i3;
        this.isUniq = z;
        this.balance = l;
        this.drugs = num;
        this.respawn_fraction_id = num2;
        this.drugden = bool;
    }

    public /* synthetic */ MapData(int i, int i2, long j, int i3, boolean z, Long l, Integer num, Integer num2, Boolean bool, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, j, i3, (i4 & 16) != 0 ? false : z, l, num, num2, bool);
    }

    public final int getId() {
        return this.id;
    }

    public final int getFraction_id() {
        return this.fraction_id;
    }

    public final long getMoney() {
        return this.money;
    }

    public final int getRespects() {
        return this.respects;
    }

    public final boolean isUniq() {
        return this.isUniq;
    }

    public final Long getBalance() {
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
