package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.drift_counter;

import kotlin.Metadata;
/* compiled from: HudDriftCounterData.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/drift_counter/HudDriftMoneyData;", "", "money", "", "moneyMultiplier", "", "timer", "speedLimit", "", "<init>", "(JIIZ)V", "getMoney", "()J", "getMoneyMultiplier", "()I", "getTimer", "getSpeedLimit", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudDriftMoneyData {
    private final long money;
    private final int moneyMultiplier;
    private final boolean speedLimit;
    private final int timer;

    public static /* synthetic */ HudDriftMoneyData copy$default(HudDriftMoneyData hudDriftMoneyData, long j, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j = hudDriftMoneyData.money;
        }
        long j2 = j;
        if ((i3 & 2) != 0) {
            i = hudDriftMoneyData.moneyMultiplier;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = hudDriftMoneyData.timer;
        }
        int i5 = i2;
        if ((i3 & 8) != 0) {
            z = hudDriftMoneyData.speedLimit;
        }
        return hudDriftMoneyData.copy(j2, i4, i5, z);
    }

    public final long component1() {
        return this.money;
    }

    public final int component2() {
        return this.moneyMultiplier;
    }

    public final int component3() {
        return this.timer;
    }

    public final boolean component4() {
        return this.speedLimit;
    }

    public final HudDriftMoneyData copy(long j, int i, int i2, boolean z) {
        return new HudDriftMoneyData(j, i, i2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HudDriftMoneyData) {
            HudDriftMoneyData hudDriftMoneyData = (HudDriftMoneyData) obj;
            return this.money == hudDriftMoneyData.money && this.moneyMultiplier == hudDriftMoneyData.moneyMultiplier && this.timer == hudDriftMoneyData.timer && this.speedLimit == hudDriftMoneyData.speedLimit;
        }
        return false;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.money) * 31) + Integer.hashCode(this.moneyMultiplier)) * 31) + Integer.hashCode(this.timer)) * 31) + Boolean.hashCode(this.speedLimit);
    }

    public String toString() {
        long j = this.money;
        int i = this.moneyMultiplier;
        int i2 = this.timer;
        return "HudDriftMoneyData(money=" + j + ", moneyMultiplier=" + i + ", timer=" + i2 + ", speedLimit=" + this.speedLimit + ")";
    }

    public HudDriftMoneyData(long j, int i, int i2, boolean z) {
        this.money = j;
        this.moneyMultiplier = i;
        this.timer = i2;
        this.speedLimit = z;
    }

    public final long getMoney() {
        return this.money;
    }

    public final int getMoneyMultiplier() {
        return this.moneyMultiplier;
    }

    public final int getTimer() {
        return this.timer;
    }

    public final boolean getSpeedLimit() {
        return this.speedLimit;
    }
}
