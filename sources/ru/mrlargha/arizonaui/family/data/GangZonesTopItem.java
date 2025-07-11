package ru.mrlargha.arizonaui.family.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MapData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lru/mrlargha/arizonaui/family/data/GangZonesTopItem;", "", "family_db_id", "", "family_name", "", "family_color", "family_flag", "territory_count", "<init>", "(ILjava/lang/String;III)V", "getFamily_db_id", "()I", "getFamily_name", "()Ljava/lang/String;", "getFamily_color", "getFamily_flag", "getTerritory_count", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GangZonesTopItem {
    private final int family_color;
    private final int family_db_id;
    private final int family_flag;
    private final String family_name;
    private final int territory_count;

    public static /* synthetic */ GangZonesTopItem copy$default(GangZonesTopItem gangZonesTopItem, int i, String str, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = gangZonesTopItem.family_db_id;
        }
        if ((i5 & 2) != 0) {
            str = gangZonesTopItem.family_name;
        }
        if ((i5 & 4) != 0) {
            i2 = gangZonesTopItem.family_color;
        }
        if ((i5 & 8) != 0) {
            i3 = gangZonesTopItem.family_flag;
        }
        if ((i5 & 16) != 0) {
            i4 = gangZonesTopItem.territory_count;
        }
        int i6 = i4;
        int i7 = i2;
        return gangZonesTopItem.copy(i, str, i7, i3, i6);
    }

    public final int component1() {
        return this.family_db_id;
    }

    public final String component2() {
        return this.family_name;
    }

    public final int component3() {
        return this.family_color;
    }

    public final int component4() {
        return this.family_flag;
    }

    public final int component5() {
        return this.territory_count;
    }

    public final GangZonesTopItem copy(int i, String family_name, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(family_name, "family_name");
        return new GangZonesTopItem(i, family_name, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GangZonesTopItem) {
            GangZonesTopItem gangZonesTopItem = (GangZonesTopItem) obj;
            return this.family_db_id == gangZonesTopItem.family_db_id && Intrinsics.areEqual(this.family_name, gangZonesTopItem.family_name) && this.family_color == gangZonesTopItem.family_color && this.family_flag == gangZonesTopItem.family_flag && this.territory_count == gangZonesTopItem.territory_count;
        }
        return false;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.family_db_id) * 31) + this.family_name.hashCode()) * 31) + Integer.hashCode(this.family_color)) * 31) + Integer.hashCode(this.family_flag)) * 31) + Integer.hashCode(this.territory_count);
    }

    public String toString() {
        int i = this.family_db_id;
        String str = this.family_name;
        int i2 = this.family_color;
        int i3 = this.family_flag;
        return "GangZonesTopItem(family_db_id=" + i + ", family_name=" + str + ", family_color=" + i2 + ", family_flag=" + i3 + ", territory_count=" + this.territory_count + ")";
    }

    public GangZonesTopItem(int i, String family_name, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(family_name, "family_name");
        this.family_db_id = i;
        this.family_name = family_name;
        this.family_color = i2;
        this.family_flag = i3;
        this.territory_count = i4;
    }

    public final int getFamily_db_id() {
        return this.family_db_id;
    }

    public final String getFamily_name() {
        return this.family_name;
    }

    public final int getFamily_color() {
        return this.family_color;
    }

    public final int getFamily_flag() {
        return this.family_flag;
    }

    public final int getTerritory_count() {
        return this.territory_count;
    }
}
