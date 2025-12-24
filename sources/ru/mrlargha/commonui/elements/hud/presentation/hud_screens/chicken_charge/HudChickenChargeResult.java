package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_charge;

import kotlin.Metadata;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_charge/HudChickenChargeResult;", "", "chance", "", "isSuccessful", "", "<init>", "(IZ)V", "getChance", "()I", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudChickenChargeResult {
    private final int chance;
    private final boolean isSuccessful;

    public static /* synthetic */ HudChickenChargeResult copy$default(HudChickenChargeResult hudChickenChargeResult, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = hudChickenChargeResult.chance;
        }
        if ((i2 & 2) != 0) {
            z = hudChickenChargeResult.isSuccessful;
        }
        return hudChickenChargeResult.copy(i, z);
    }

    public final int component1() {
        return this.chance;
    }

    public final boolean component2() {
        return this.isSuccessful;
    }

    public final HudChickenChargeResult copy(int i, boolean z) {
        return new HudChickenChargeResult(i, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HudChickenChargeResult) {
            HudChickenChargeResult hudChickenChargeResult = (HudChickenChargeResult) obj;
            return this.chance == hudChickenChargeResult.chance && this.isSuccessful == hudChickenChargeResult.isSuccessful;
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.chance) * 31) + Boolean.hashCode(this.isSuccessful);
    }

    public String toString() {
        int i = this.chance;
        return "HudChickenChargeResult(chance=" + i + ", isSuccessful=" + this.isSuccessful + ")";
    }

    public HudChickenChargeResult(int i, boolean z) {
        this.chance = i;
        this.isSuccessful = z;
    }

    public final int getChance() {
        return this.chance;
    }

    public final boolean isSuccessful() {
        return this.isSuccessful;
    }
}
