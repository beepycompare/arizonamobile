package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.capt;

import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HudCaptModel.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u001c\u001a\u00020\u001dJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010\"\u001a\u00020\fHÆ\u0003J\t\u0010#\u001a\u00020\fHÆ\u0003JR\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\fHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001a¨\u0006*"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/capt/HudCaptModel;", "", "name", "", "time", "", "ordinalNumbers", "", "itemList", "", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/capt/HudCaptItemModel;", "scoreIcon", "", "territoryId", "<init>", "(Ljava/lang/String;JLjava/lang/Boolean;Ljava/util/List;II)V", "getName", "()Ljava/lang/String;", "getTime", "()J", "getOrdinalNumbers", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getItemList", "()Ljava/util/List;", "getScoreIcon", "()I", "getTerritoryId", "getScoreIconType", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/capt/HudCaptScoreIconType;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;JLjava/lang/Boolean;Ljava/util/List;II)Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/capt/HudCaptModel;", "equals", "other", "hashCode", "toString", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HudCaptModel {
    @SerializedName("groups")
    private final List<HudCaptItemModel> itemList;
    @SerializedName("name")
    private final String name;
    @SerializedName("ordinalNumbers")
    private final Boolean ordinalNumbers;
    @SerializedName("scoreIcon")
    private final int scoreIcon;
    @SerializedName("territory_id")
    private final int territoryId;
    @SerializedName("time")
    private final long time;

    public HudCaptModel() {
        this(null, 0L, null, null, 0, 0, 63, null);
    }

    public static /* synthetic */ HudCaptModel copy$default(HudCaptModel hudCaptModel, String str, long j, Boolean bool, List list, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = hudCaptModel.name;
        }
        if ((i3 & 2) != 0) {
            j = hudCaptModel.time;
        }
        if ((i3 & 4) != 0) {
            bool = hudCaptModel.ordinalNumbers;
        }
        List<HudCaptItemModel> list2 = list;
        if ((i3 & 8) != 0) {
            list2 = hudCaptModel.itemList;
        }
        if ((i3 & 16) != 0) {
            i = hudCaptModel.scoreIcon;
        }
        if ((i3 & 32) != 0) {
            i2 = hudCaptModel.territoryId;
        }
        return hudCaptModel.copy(str, j, bool, list2, i, i2);
    }

    public final String component1() {
        return this.name;
    }

    public final long component2() {
        return this.time;
    }

    public final Boolean component3() {
        return this.ordinalNumbers;
    }

    public final List<HudCaptItemModel> component4() {
        return this.itemList;
    }

    public final int component5() {
        return this.scoreIcon;
    }

    public final int component6() {
        return this.territoryId;
    }

    public final HudCaptModel copy(String name, long j, Boolean bool, List<HudCaptItemModel> itemList, int i, int i2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        return new HudCaptModel(name, j, bool, itemList, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HudCaptModel) {
            HudCaptModel hudCaptModel = (HudCaptModel) obj;
            return Intrinsics.areEqual(this.name, hudCaptModel.name) && this.time == hudCaptModel.time && Intrinsics.areEqual(this.ordinalNumbers, hudCaptModel.ordinalNumbers) && Intrinsics.areEqual(this.itemList, hudCaptModel.itemList) && this.scoreIcon == hudCaptModel.scoreIcon && this.territoryId == hudCaptModel.territoryId;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.name.hashCode() * 31) + Long.hashCode(this.time)) * 31;
        Boolean bool = this.ordinalNumbers;
        return ((((((hashCode + (bool == null ? 0 : bool.hashCode())) * 31) + this.itemList.hashCode()) * 31) + Integer.hashCode(this.scoreIcon)) * 31) + Integer.hashCode(this.territoryId);
    }

    public String toString() {
        String str = this.name;
        long j = this.time;
        Boolean bool = this.ordinalNumbers;
        List<HudCaptItemModel> list = this.itemList;
        int i = this.scoreIcon;
        return "HudCaptModel(name=" + str + ", time=" + j + ", ordinalNumbers=" + bool + ", itemList=" + list + ", scoreIcon=" + i + ", territoryId=" + this.territoryId + ")";
    }

    public HudCaptModel(String name, long j, Boolean bool, List<HudCaptItemModel> itemList, int i, int i2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        this.name = name;
        this.time = j;
        this.ordinalNumbers = bool;
        this.itemList = itemList;
        this.scoreIcon = i;
        this.territoryId = i2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ HudCaptModel(String str, long j, Boolean bool, List list, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, r7, r8, r9, r10);
        int i4;
        int i5;
        Boolean bool2;
        List list2;
        str = (i3 & 1) != 0 ? "" : str;
        j = (i3 & 2) != 0 ? 0L : j;
        bool = (i3 & 4) != 0 ? null : bool;
        list = (i3 & 8) != 0 ? CollectionsKt.emptyList() : list;
        i = (i3 & 16) != 0 ? -1 : i;
        if ((i3 & 32) != 0) {
            i4 = -1;
            list2 = list;
            i5 = i;
            bool2 = bool;
        } else {
            i4 = i2;
            i5 = i;
            bool2 = bool;
            list2 = list;
        }
    }

    public final String getName() {
        return this.name;
    }

    public final long getTime() {
        return this.time;
    }

    public final Boolean getOrdinalNumbers() {
        return this.ordinalNumbers;
    }

    public final List<HudCaptItemModel> getItemList() {
        return this.itemList;
    }

    public final int getScoreIcon() {
        return this.scoreIcon;
    }

    public final int getTerritoryId() {
        return this.territoryId;
    }

    public final HudCaptScoreIconType getScoreIconType() {
        Object obj;
        Iterator<E> it = HudCaptScoreIconType.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((HudCaptScoreIconType) obj).getType() == this.scoreIcon) {
                break;
            }
        }
        HudCaptScoreIconType hudCaptScoreIconType = (HudCaptScoreIconType) obj;
        return hudCaptScoreIconType == null ? HudCaptScoreIconType.SKULL : hudCaptScoreIconType;
    }
}
