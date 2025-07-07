package ru.mrlargha.arizonaui.family.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lru/mrlargha/arizonaui/family/data/FamilyWarData;", "", "disabledItems", "", "", "rank", "territories", "<init>", "(Ljava/util/List;II)V", "getDisabledItems", "()Ljava/util/List;", "getRank", "()I", "getTerritories", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyWarData {
    private final List<Integer> disabledItems;
    private final int rank;
    private final int territories;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FamilyWarData copy$default(FamilyWarData familyWarData, List list, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = familyWarData.disabledItems;
        }
        if ((i3 & 2) != 0) {
            i = familyWarData.rank;
        }
        if ((i3 & 4) != 0) {
            i2 = familyWarData.territories;
        }
        return familyWarData.copy(list, i, i2);
    }

    public final List<Integer> component1() {
        return this.disabledItems;
    }

    public final int component2() {
        return this.rank;
    }

    public final int component3() {
        return this.territories;
    }

    public final FamilyWarData copy(List<Integer> disabledItems, int i, int i2) {
        Intrinsics.checkNotNullParameter(disabledItems, "disabledItems");
        return new FamilyWarData(disabledItems, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FamilyWarData) {
            FamilyWarData familyWarData = (FamilyWarData) obj;
            return Intrinsics.areEqual(this.disabledItems, familyWarData.disabledItems) && this.rank == familyWarData.rank && this.territories == familyWarData.territories;
        }
        return false;
    }

    public int hashCode() {
        return (((this.disabledItems.hashCode() * 31) + Integer.hashCode(this.rank)) * 31) + Integer.hashCode(this.territories);
    }

    public String toString() {
        List<Integer> list = this.disabledItems;
        int i = this.rank;
        return "FamilyWarData(disabledItems=" + list + ", rank=" + i + ", territories=" + this.territories + ")";
    }

    public FamilyWarData(List<Integer> disabledItems, int i, int i2) {
        Intrinsics.checkNotNullParameter(disabledItems, "disabledItems");
        this.disabledItems = disabledItems;
        this.rank = i;
        this.territories = i2;
    }

    public final List<Integer> getDisabledItems() {
        return this.disabledItems;
    }

    public final int getRank() {
        return this.rank;
    }

    public final int getTerritories() {
        return this.territories;
    }
}
