package ru.mrlargha.commonui.elements.battlepassWinter2025.utils;

import androidx.recyclerview.widget.DiffUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.elements.battlepassWinter2025.data.AwardItemData;
/* compiled from: LevelItemsAdapterDiffUtil.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B;\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u0003\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016R \u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/utils/LevelItemsAdapterDiffUtil;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lkotlin/Pair;", "Lru/mrlargha/commonui/elements/battlepassWinter2025/data/AwardItemData;", "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LevelItemsAdapterDiffUtil extends DiffUtil.Callback {
    private final List<Pair<AwardItemData, AwardItemData>> newList;
    private final List<Pair<AwardItemData, AwardItemData>> oldList;

    public LevelItemsAdapterDiffUtil(List<Pair<AwardItemData, AwardItemData>> oldList, List<Pair<AwardItemData, AwardItemData>> newList) {
        Intrinsics.checkNotNullParameter(oldList, "oldList");
        Intrinsics.checkNotNullParameter(newList, "newList");
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getOldListSize() {
        return this.oldList.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getNewListSize() {
        return this.newList.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int i, int i2) {
        return this.oldList.get(i).getFirst().getLevel() == this.newList.get(i2).getFirst().getLevel();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int i, int i2) {
        return Intrinsics.areEqual(this.oldList.get(i).getFirst(), this.newList.get(i2).getFirst()) && Intrinsics.areEqual(this.oldList.get(i).getSecond(), this.newList.get(i2).getSecond());
    }
}
