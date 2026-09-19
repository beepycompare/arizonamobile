package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.drift_counter;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HudDriftCounterData.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ.\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\n¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/drift_counter/HudDriftPointsData;", "", "points", "", "pointMultiplier", "", "pointsSum", "<init>", "(JILjava/lang/Long;)V", "getPoints", "()J", "getPointMultiplier", "()I", "getPointsSum", "()Ljava/lang/Long;", "Ljava/lang/Long;", "displayedTotal", "getDisplayedTotal", "component1", "component2", "component3", "copy", "(JILjava/lang/Long;)Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/drift_counter/HudDriftPointsData;", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudDriftPointsData {
    private final int pointMultiplier;
    private final long points;
    private final Long pointsSum;

    public static /* synthetic */ HudDriftPointsData copy$default(HudDriftPointsData hudDriftPointsData, long j, int i, Long l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = hudDriftPointsData.points;
        }
        if ((i2 & 2) != 0) {
            i = hudDriftPointsData.pointMultiplier;
        }
        if ((i2 & 4) != 0) {
            l = hudDriftPointsData.pointsSum;
        }
        return hudDriftPointsData.copy(j, i, l);
    }

    public final long component1() {
        return this.points;
    }

    public final int component2() {
        return this.pointMultiplier;
    }

    public final Long component3() {
        return this.pointsSum;
    }

    public final HudDriftPointsData copy(long j, int i, Long l) {
        return new HudDriftPointsData(j, i, l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HudDriftPointsData) {
            HudDriftPointsData hudDriftPointsData = (HudDriftPointsData) obj;
            return this.points == hudDriftPointsData.points && this.pointMultiplier == hudDriftPointsData.pointMultiplier && Intrinsics.areEqual(this.pointsSum, hudDriftPointsData.pointsSum);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((Long.hashCode(this.points) * 31) + Integer.hashCode(this.pointMultiplier)) * 31;
        Long l = this.pointsSum;
        return hashCode + (l == null ? 0 : l.hashCode());
    }

    public String toString() {
        long j = this.points;
        int i = this.pointMultiplier;
        return "HudDriftPointsData(points=" + j + ", pointMultiplier=" + i + ", pointsSum=" + this.pointsSum + ")";
    }

    public HudDriftPointsData(long j, int i, Long l) {
        this.points = j;
        this.pointMultiplier = i;
        this.pointsSum = l;
    }

    public /* synthetic */ HudDriftPointsData(long j, int i, Long l, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, i, (i2 & 4) != 0 ? null : l);
    }

    public final long getPoints() {
        return this.points;
    }

    public final int getPointMultiplier() {
        return this.pointMultiplier;
    }

    public final Long getPointsSum() {
        return this.pointsSum;
    }

    public final long getDisplayedTotal() {
        Long l = this.pointsSum;
        return l != null ? l.longValue() : this.points;
    }
}
