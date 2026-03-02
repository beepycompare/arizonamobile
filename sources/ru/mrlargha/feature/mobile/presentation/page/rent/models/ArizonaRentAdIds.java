package ru.mrlargha.feature.mobile.presentation.page.rent.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
/* compiled from: ArizonaRentAdIds.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent/models/ArizonaRentAdIds;", "", "id", "", "listId", "houseId", "<init>", "(III)V", "getId", "()I", "getListId", "getHouseId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "mobile"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ArizonaRentAdIds {
    @SerializedName("houseID")
    private final int houseId;
    @SerializedName("listUID")
    private final int id;
    @SerializedName("listID")
    private final int listId;

    public static /* synthetic */ ArizonaRentAdIds copy$default(ArizonaRentAdIds arizonaRentAdIds, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = arizonaRentAdIds.id;
        }
        if ((i4 & 2) != 0) {
            i2 = arizonaRentAdIds.listId;
        }
        if ((i4 & 4) != 0) {
            i3 = arizonaRentAdIds.houseId;
        }
        return arizonaRentAdIds.copy(i, i2, i3);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.listId;
    }

    public final int component3() {
        return this.houseId;
    }

    public final ArizonaRentAdIds copy(int i, int i2, int i3) {
        return new ArizonaRentAdIds(i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArizonaRentAdIds) {
            ArizonaRentAdIds arizonaRentAdIds = (ArizonaRentAdIds) obj;
            return this.id == arizonaRentAdIds.id && this.listId == arizonaRentAdIds.listId && this.houseId == arizonaRentAdIds.houseId;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.listId)) * 31) + Integer.hashCode(this.houseId);
    }

    public String toString() {
        int i = this.id;
        int i2 = this.listId;
        return "ArizonaRentAdIds(id=" + i + ", listId=" + i2 + ", houseId=" + this.houseId + ")";
    }

    public ArizonaRentAdIds(int i, int i2, int i3) {
        this.id = i;
        this.listId = i2;
        this.houseId = i3;
    }

    public final int getId() {
        return this.id;
    }

    public final int getListId() {
        return this.listId;
    }

    public final int getHouseId() {
        return this.houseId;
    }
}
