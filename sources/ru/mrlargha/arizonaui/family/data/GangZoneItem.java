package ru.mrlargha.arizonaui.family.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MapData.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003Jc\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006)"}, d2 = {"Lru/mrlargha/arizonaui/family/data/GangZoneItem;", "", "id", "", "family_id", "family_moneta", "family_money", "family_db_id", "family_name", "", "family_color", "family_flag", "family_logo", "<init>", "(IIIIILjava/lang/String;III)V", "getId", "()I", "getFamily_id", "getFamily_moneta", "getFamily_money", "getFamily_db_id", "getFamily_name", "()Ljava/lang/String;", "getFamily_color", "getFamily_flag", "getFamily_logo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GangZoneItem {
    private final int family_color;
    private final int family_db_id;
    private final int family_flag;
    private final int family_id;
    private final int family_logo;
    private final int family_moneta;
    private final int family_money;
    private final String family_name;
    private final int id;

    public static /* synthetic */ GangZoneItem copy$default(GangZoneItem gangZoneItem, int i, int i2, int i3, int i4, int i5, String str, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i = gangZoneItem.id;
        }
        if ((i9 & 2) != 0) {
            i2 = gangZoneItem.family_id;
        }
        if ((i9 & 4) != 0) {
            i3 = gangZoneItem.family_moneta;
        }
        if ((i9 & 8) != 0) {
            i4 = gangZoneItem.family_money;
        }
        if ((i9 & 16) != 0) {
            i5 = gangZoneItem.family_db_id;
        }
        if ((i9 & 32) != 0) {
            str = gangZoneItem.family_name;
        }
        if ((i9 & 64) != 0) {
            i6 = gangZoneItem.family_color;
        }
        if ((i9 & 128) != 0) {
            i7 = gangZoneItem.family_flag;
        }
        if ((i9 & 256) != 0) {
            i8 = gangZoneItem.family_logo;
        }
        int i10 = i7;
        int i11 = i8;
        String str2 = str;
        int i12 = i6;
        int i13 = i5;
        int i14 = i3;
        return gangZoneItem.copy(i, i2, i14, i4, i13, str2, i12, i10, i11);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.family_id;
    }

    public final int component3() {
        return this.family_moneta;
    }

    public final int component4() {
        return this.family_money;
    }

    public final int component5() {
        return this.family_db_id;
    }

    public final String component6() {
        return this.family_name;
    }

    public final int component7() {
        return this.family_color;
    }

    public final int component8() {
        return this.family_flag;
    }

    public final int component9() {
        return this.family_logo;
    }

    public final GangZoneItem copy(int i, int i2, int i3, int i4, int i5, String family_name, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(family_name, "family_name");
        return new GangZoneItem(i, i2, i3, i4, i5, family_name, i6, i7, i8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GangZoneItem) {
            GangZoneItem gangZoneItem = (GangZoneItem) obj;
            return this.id == gangZoneItem.id && this.family_id == gangZoneItem.family_id && this.family_moneta == gangZoneItem.family_moneta && this.family_money == gangZoneItem.family_money && this.family_db_id == gangZoneItem.family_db_id && Intrinsics.areEqual(this.family_name, gangZoneItem.family_name) && this.family_color == gangZoneItem.family_color && this.family_flag == gangZoneItem.family_flag && this.family_logo == gangZoneItem.family_logo;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.family_id)) * 31) + Integer.hashCode(this.family_moneta)) * 31) + Integer.hashCode(this.family_money)) * 31) + Integer.hashCode(this.family_db_id)) * 31) + this.family_name.hashCode()) * 31) + Integer.hashCode(this.family_color)) * 31) + Integer.hashCode(this.family_flag)) * 31) + Integer.hashCode(this.family_logo);
    }

    public String toString() {
        int i = this.id;
        int i2 = this.family_id;
        int i3 = this.family_moneta;
        int i4 = this.family_money;
        int i5 = this.family_db_id;
        String str = this.family_name;
        int i6 = this.family_color;
        int i7 = this.family_flag;
        return "GangZoneItem(id=" + i + ", family_id=" + i2 + ", family_moneta=" + i3 + ", family_money=" + i4 + ", family_db_id=" + i5 + ", family_name=" + str + ", family_color=" + i6 + ", family_flag=" + i7 + ", family_logo=" + this.family_logo + ")";
    }

    public GangZoneItem(int i, int i2, int i3, int i4, int i5, String family_name, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(family_name, "family_name");
        this.id = i;
        this.family_id = i2;
        this.family_moneta = i3;
        this.family_money = i4;
        this.family_db_id = i5;
        this.family_name = family_name;
        this.family_color = i6;
        this.family_flag = i7;
        this.family_logo = i8;
    }

    public final int getId() {
        return this.id;
    }

    public final int getFamily_id() {
        return this.family_id;
    }

    public final int getFamily_moneta() {
        return this.family_moneta;
    }

    public final int getFamily_money() {
        return this.family_money;
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

    public final int getFamily_logo() {
        return this.family_logo;
    }
}
