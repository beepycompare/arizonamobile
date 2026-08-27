package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.drift_counter;

import kotlin.Metadata;
/* compiled from: HudDriftCounterData.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020 HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006!"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/drift_counter/HudDriftCounterState;", "", "countdownSeconds", "", "points", "", "elapsedSeconds", "multiplier", "minimumSpeedKmh", "currentSpeedKmh", "<init>", "(IJIIII)V", "getCountdownSeconds", "()I", "getPoints", "()J", "getElapsedSeconds", "getMultiplier", "getMinimumSpeedKmh", "getCurrentSpeedKmh", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudDriftCounterState {
    private final int countdownSeconds;
    private final int currentSpeedKmh;
    private final int elapsedSeconds;
    private final int minimumSpeedKmh;
    private final int multiplier;
    private final long points;

    public static /* synthetic */ HudDriftCounterState copy$default(HudDriftCounterState hudDriftCounterState, int i, long j, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = hudDriftCounterState.countdownSeconds;
        }
        if ((i6 & 2) != 0) {
            j = hudDriftCounterState.points;
        }
        if ((i6 & 4) != 0) {
            i2 = hudDriftCounterState.elapsedSeconds;
        }
        if ((i6 & 8) != 0) {
            i3 = hudDriftCounterState.multiplier;
        }
        if ((i6 & 16) != 0) {
            i4 = hudDriftCounterState.minimumSpeedKmh;
        }
        if ((i6 & 32) != 0) {
            i5 = hudDriftCounterState.currentSpeedKmh;
        }
        return hudDriftCounterState.copy(i, j, i2, i3, i4, i5);
    }

    public final int component1() {
        return this.countdownSeconds;
    }

    public final long component2() {
        return this.points;
    }

    public final int component3() {
        return this.elapsedSeconds;
    }

    public final int component4() {
        return this.multiplier;
    }

    public final int component5() {
        return this.minimumSpeedKmh;
    }

    public final int component6() {
        return this.currentSpeedKmh;
    }

    public final HudDriftCounterState copy(int i, long j, int i2, int i3, int i4, int i5) {
        return new HudDriftCounterState(i, j, i2, i3, i4, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HudDriftCounterState) {
            HudDriftCounterState hudDriftCounterState = (HudDriftCounterState) obj;
            return this.countdownSeconds == hudDriftCounterState.countdownSeconds && this.points == hudDriftCounterState.points && this.elapsedSeconds == hudDriftCounterState.elapsedSeconds && this.multiplier == hudDriftCounterState.multiplier && this.minimumSpeedKmh == hudDriftCounterState.minimumSpeedKmh && this.currentSpeedKmh == hudDriftCounterState.currentSpeedKmh;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.countdownSeconds) * 31) + Long.hashCode(this.points)) * 31) + Integer.hashCode(this.elapsedSeconds)) * 31) + Integer.hashCode(this.multiplier)) * 31) + Integer.hashCode(this.minimumSpeedKmh)) * 31) + Integer.hashCode(this.currentSpeedKmh);
    }

    public String toString() {
        int i = this.countdownSeconds;
        long j = this.points;
        int i2 = this.elapsedSeconds;
        int i3 = this.multiplier;
        int i4 = this.minimumSpeedKmh;
        return "HudDriftCounterState(countdownSeconds=" + i + ", points=" + j + ", elapsedSeconds=" + i2 + ", multiplier=" + i3 + ", minimumSpeedKmh=" + i4 + ", currentSpeedKmh=" + this.currentSpeedKmh + ")";
    }

    public HudDriftCounterState(int i, long j, int i2, int i3, int i4, int i5) {
        this.countdownSeconds = i;
        this.points = j;
        this.elapsedSeconds = i2;
        this.multiplier = i3;
        this.minimumSpeedKmh = i4;
        this.currentSpeedKmh = i5;
    }

    public final int getCountdownSeconds() {
        return this.countdownSeconds;
    }

    public final long getPoints() {
        return this.points;
    }

    public final int getElapsedSeconds() {
        return this.elapsedSeconds;
    }

    public final int getMultiplier() {
        return this.multiplier;
    }

    public final int getMinimumSpeedKmh() {
        return this.minimumSpeedKmh;
    }

    public final int getCurrentSpeedKmh() {
        return this.currentSpeedKmh;
    }
}
