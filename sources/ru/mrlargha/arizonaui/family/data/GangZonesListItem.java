package ru.mrlargha.arizonaui.family.data;

import kotlin.Metadata;
/* compiled from: MapData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lru/mrlargha/arizonaui/family/data/GangZonesListItem;", "", "id", "", "family_moneta", "family_money", "<init>", "(III)V", "getId", "()I", "getFamily_moneta", "getFamily_money", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GangZonesListItem {
    private final int family_moneta;
    private final int family_money;
    private final int id;

    public static /* synthetic */ GangZonesListItem copy$default(GangZonesListItem gangZonesListItem, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = gangZonesListItem.id;
        }
        if ((i4 & 2) != 0) {
            i2 = gangZonesListItem.family_moneta;
        }
        if ((i4 & 4) != 0) {
            i3 = gangZonesListItem.family_money;
        }
        return gangZonesListItem.copy(i, i2, i3);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.family_moneta;
    }

    public final int component3() {
        return this.family_money;
    }

    public final GangZonesListItem copy(int i, int i2, int i3) {
        return new GangZonesListItem(i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GangZonesListItem) {
            GangZonesListItem gangZonesListItem = (GangZonesListItem) obj;
            return this.id == gangZonesListItem.id && this.family_moneta == gangZonesListItem.family_moneta && this.family_money == gangZonesListItem.family_money;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.family_moneta)) * 31) + Integer.hashCode(this.family_money);
    }

    public String toString() {
        int i = this.id;
        int i2 = this.family_moneta;
        return "GangZonesListItem(id=" + i + ", family_moneta=" + i2 + ", family_money=" + this.family_money + ")";
    }

    public GangZonesListItem(int i, int i2, int i3) {
        this.id = i;
        this.family_moneta = i2;
        this.family_money = i3;
    }

    public final int getId() {
        return this.id;
    }

    public final int getFamily_moneta() {
        return this.family_moneta;
    }

    public final int getFamily_money() {
        return this.family_money;
    }
}
