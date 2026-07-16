package ru.mrlargha.feature.battlepassWinter2025;

import kotlin.Metadata;
/* compiled from: BattlePassUi.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B1\u0012\f\b\u0001\u0010\u0002\u001a\u00020\u0003:\u0002\b\u0004\u0012\f\b\u0001\u0010\u0005\u001a\u00020\u0003:\u0002\b\u0004\u0012\f\b\u0001\u0010\u0006\u001a\u00020\u0003:\u0002\b\u0004¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J3\u0010\u0010\u001a\u00020\u00002\f\b\u0003\u0010\u0002\u001a\u00020\u0003:\u0002\b\u00042\f\b\u0003\u0010\u0005\u001a\u00020\u0003:\u0002\b\u00042\f\b\u0003\u0010\u0006\u001a\u00020\u0003:\u0002\b\u0004HÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u001b\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\u0002\b\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\u0002\b\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001b\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\u0002\b\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/BattlePassItemLayouts;", "", "levelItem", "", "Landroidx/annotation/LayoutRes;", "commonTaskItem", "taskRewardItem", "<init>", "(III)V", "getLevelItem", "()I", "getCommonTaskItem", "getTaskRewardItem", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BattlePassItemLayouts {
    private final int commonTaskItem;
    private final int levelItem;
    private final int taskRewardItem;

    public static /* synthetic */ BattlePassItemLayouts copy$default(BattlePassItemLayouts battlePassItemLayouts, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = battlePassItemLayouts.levelItem;
        }
        if ((i4 & 2) != 0) {
            i2 = battlePassItemLayouts.commonTaskItem;
        }
        if ((i4 & 4) != 0) {
            i3 = battlePassItemLayouts.taskRewardItem;
        }
        return battlePassItemLayouts.copy(i, i2, i3);
    }

    public final int component1() {
        return this.levelItem;
    }

    public final int component2() {
        return this.commonTaskItem;
    }

    public final int component3() {
        return this.taskRewardItem;
    }

    public final BattlePassItemLayouts copy(int i, int i2, int i3) {
        return new BattlePassItemLayouts(i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BattlePassItemLayouts) {
            BattlePassItemLayouts battlePassItemLayouts = (BattlePassItemLayouts) obj;
            return this.levelItem == battlePassItemLayouts.levelItem && this.commonTaskItem == battlePassItemLayouts.commonTaskItem && this.taskRewardItem == battlePassItemLayouts.taskRewardItem;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.levelItem) * 31) + Integer.hashCode(this.commonTaskItem)) * 31) + Integer.hashCode(this.taskRewardItem);
    }

    public String toString() {
        int i = this.levelItem;
        int i2 = this.commonTaskItem;
        return "BattlePassItemLayouts(levelItem=" + i + ", commonTaskItem=" + i2 + ", taskRewardItem=" + this.taskRewardItem + ")";
    }

    public BattlePassItemLayouts(int i, int i2, int i3) {
        this.levelItem = i;
        this.commonTaskItem = i2;
        this.taskRewardItem = i3;
    }

    public final int getLevelItem() {
        return this.levelItem;
    }

    public final int getCommonTaskItem() {
        return this.commonTaskItem;
    }

    public final int getTaskRewardItem() {
        return this.taskRewardItem;
    }
}
