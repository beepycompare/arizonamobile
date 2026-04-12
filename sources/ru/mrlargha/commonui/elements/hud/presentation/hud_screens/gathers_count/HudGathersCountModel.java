package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.gathers_count;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HudGathersCountModel.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/gathers_count/HudGathersCountModel;", "", "time", "", "bonuses", "", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/gathers_count/HudGathersCountBonus;", "debuffs", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/gathers_count/HudGathersCountDebuff;", "<init>", "(ILjava/util/List;Ljava/util/List;)V", "getTime", "()I", "getBonuses", "()Ljava/util/List;", "getDebuffs", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudGathersCountModel {
    private final List<HudGathersCountBonus> bonuses;
    private final List<HudGathersCountDebuff> debuffs;
    private final int time;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HudGathersCountModel copy$default(HudGathersCountModel hudGathersCountModel, int i, List list, List list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = hudGathersCountModel.time;
        }
        if ((i2 & 2) != 0) {
            list = hudGathersCountModel.bonuses;
        }
        if ((i2 & 4) != 0) {
            list2 = hudGathersCountModel.debuffs;
        }
        return hudGathersCountModel.copy(i, list, list2);
    }

    public final int component1() {
        return this.time;
    }

    public final List<HudGathersCountBonus> component2() {
        return this.bonuses;
    }

    public final List<HudGathersCountDebuff> component3() {
        return this.debuffs;
    }

    public final HudGathersCountModel copy(int i, List<HudGathersCountBonus> bonuses, List<HudGathersCountDebuff> debuffs) {
        Intrinsics.checkNotNullParameter(bonuses, "bonuses");
        Intrinsics.checkNotNullParameter(debuffs, "debuffs");
        return new HudGathersCountModel(i, bonuses, debuffs);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HudGathersCountModel) {
            HudGathersCountModel hudGathersCountModel = (HudGathersCountModel) obj;
            return this.time == hudGathersCountModel.time && Intrinsics.areEqual(this.bonuses, hudGathersCountModel.bonuses) && Intrinsics.areEqual(this.debuffs, hudGathersCountModel.debuffs);
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.time) * 31) + this.bonuses.hashCode()) * 31) + this.debuffs.hashCode();
    }

    public String toString() {
        int i = this.time;
        List<HudGathersCountBonus> list = this.bonuses;
        return "HudGathersCountModel(time=" + i + ", bonuses=" + list + ", debuffs=" + this.debuffs + ")";
    }

    public HudGathersCountModel(int i, List<HudGathersCountBonus> bonuses, List<HudGathersCountDebuff> debuffs) {
        Intrinsics.checkNotNullParameter(bonuses, "bonuses");
        Intrinsics.checkNotNullParameter(debuffs, "debuffs");
        this.time = i;
        this.bonuses = bonuses;
        this.debuffs = debuffs;
    }

    public final int getTime() {
        return this.time;
    }

    public final List<HudGathersCountBonus> getBonuses() {
        return this.bonuses;
    }

    public final List<HudGathersCountDebuff> getDebuffs() {
        return this.debuffs;
    }
}
