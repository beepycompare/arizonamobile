package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.capt;

import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HudCaptModel.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u001a\u001a\u00020\u001bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010 \u001a\u00020\fHÆ\u0003JH\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\fHÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/capt/HudCaptModel;", "", "name", "", "time", "", "ordinalNumbers", "", "itemList", "", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/capt/HudCaptItemModel;", "scoreIcon", "", "<init>", "(Ljava/lang/String;JLjava/lang/Boolean;Ljava/util/List;I)V", "getName", "()Ljava/lang/String;", "getTime", "()J", "getOrdinalNumbers", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getItemList", "()Ljava/util/List;", "getScoreIcon", "()I", "getScoreIconType", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/capt/HudCaptScoreIconType;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;JLjava/lang/Boolean;Ljava/util/List;I)Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/capt/HudCaptModel;", "equals", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HudCaptModel {
    @SerializedName("groups")
    private final List<HudCaptItemModel> itemList;
    private final String name;
    private final Boolean ordinalNumbers;
    private final int scoreIcon;
    private final long time;

    public HudCaptModel() {
        this(null, 0L, null, null, 0, 31, null);
    }

    public static /* synthetic */ HudCaptModel copy$default(HudCaptModel hudCaptModel, String str, long j, Boolean bool, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = hudCaptModel.name;
        }
        if ((i2 & 2) != 0) {
            j = hudCaptModel.time;
        }
        if ((i2 & 4) != 0) {
            bool = hudCaptModel.ordinalNumbers;
        }
        List<HudCaptItemModel> list2 = list;
        if ((i2 & 8) != 0) {
            list2 = hudCaptModel.itemList;
        }
        if ((i2 & 16) != 0) {
            i = hudCaptModel.scoreIcon;
        }
        int i3 = i;
        Boolean bool2 = bool;
        return hudCaptModel.copy(str, j, bool2, list2, i3);
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

    public final HudCaptModel copy(String name, long j, Boolean bool, List<HudCaptItemModel> itemList, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        return new HudCaptModel(name, j, bool, itemList, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HudCaptModel) {
            HudCaptModel hudCaptModel = (HudCaptModel) obj;
            return Intrinsics.areEqual(this.name, hudCaptModel.name) && this.time == hudCaptModel.time && Intrinsics.areEqual(this.ordinalNumbers, hudCaptModel.ordinalNumbers) && Intrinsics.areEqual(this.itemList, hudCaptModel.itemList) && this.scoreIcon == hudCaptModel.scoreIcon;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.name.hashCode() * 31) + Long.hashCode(this.time)) * 31;
        Boolean bool = this.ordinalNumbers;
        return ((((hashCode + (bool == null ? 0 : bool.hashCode())) * 31) + this.itemList.hashCode()) * 31) + Integer.hashCode(this.scoreIcon);
    }

    public String toString() {
        String str = this.name;
        long j = this.time;
        Boolean bool = this.ordinalNumbers;
        List<HudCaptItemModel> list = this.itemList;
        return "HudCaptModel(name=" + str + ", time=" + j + ", ordinalNumbers=" + bool + ", itemList=" + list + ", scoreIcon=" + this.scoreIcon + ")";
    }

    public HudCaptModel(String name, long j, Boolean bool, List<HudCaptItemModel> itemList, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        this.name = name;
        this.time = j;
        this.ordinalNumbers = bool;
        this.itemList = itemList;
        this.scoreIcon = i;
    }

    public /* synthetic */ HudCaptModel(String str, long j, Boolean bool, List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0L : j, (i2 & 4) != 0 ? null : bool, (i2 & 8) != 0 ? CollectionsKt.emptyList() : list, (i2 & 16) != 0 ? -1 : i);
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
