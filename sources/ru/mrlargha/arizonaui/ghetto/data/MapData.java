package ru.mrlargha.arizonaui.ghetto.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014JX\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0012R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014¨\u0006%"}, d2 = {"Lru/mrlargha/arizonaui/ghetto/data/MapData;", "", "id", "", "fraction_id", "money", "respects", "isUniq", "", "balance", "drugs", "<init>", "(IIIIZLjava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()I", "getFraction_id", "getMoney", "getRespects", "()Z", "getBalance", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDrugs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(IIIIZLjava/lang/Integer;Ljava/lang/Integer;)Lru/mrlargha/arizonaui/ghetto/data/MapData;", "equals", "other", "hashCode", "toString", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MapData {
    private final Integer balance;
    private final Integer drugs;
    private final int fraction_id;
    private final int id;
    private final boolean isUniq;
    private final int money;
    private final int respects;

    public static /* synthetic */ MapData copy$default(MapData mapData, int i, int i2, int i3, int i4, boolean z, Integer num, Integer num2, int i5, Object obj) {
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
        Integer num3 = num;
        Integer num4 = num2;
        boolean z2 = z;
        int i6 = i3;
        return mapData.copy(i, i2, i6, i4, z2, num3, num4);
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

    public final MapData copy(int i, int i2, int i3, int i4, boolean z, Integer num, Integer num2) {
        return new MapData(i, i2, i3, i4, z, num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MapData) {
            MapData mapData = (MapData) obj;
            return this.id == mapData.id && this.fraction_id == mapData.fraction_id && this.money == mapData.money && this.respects == mapData.respects && this.isUniq == mapData.isUniq && Intrinsics.areEqual(this.balance, mapData.balance) && Intrinsics.areEqual(this.drugs, mapData.drugs);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.fraction_id)) * 31) + Integer.hashCode(this.money)) * 31) + Integer.hashCode(this.respects)) * 31) + Boolean.hashCode(this.isUniq)) * 31;
        Integer num = this.balance;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.drugs;
        return hashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        int i = this.id;
        int i2 = this.fraction_id;
        int i3 = this.money;
        int i4 = this.respects;
        boolean z = this.isUniq;
        Integer num = this.balance;
        return "MapData(id=" + i + ", fraction_id=" + i2 + ", money=" + i3 + ", respects=" + i4 + ", isUniq=" + z + ", balance=" + num + ", drugs=" + this.drugs + ")";
    }

    public MapData(int i, int i2, int i3, int i4, boolean z, Integer num, Integer num2) {
        this.id = i;
        this.fraction_id = i2;
        this.money = i3;
        this.respects = i4;
        this.isUniq = z;
        this.balance = num;
        this.drugs = num2;
    }

    public /* synthetic */ MapData(int i, int i2, int i3, int i4, boolean z, Integer num, Integer num2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, i4, (i5 & 16) != 0 ? false : z, num, num2);
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
}
