package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.payday;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayMultiplier;", "", "value", "", "timer", "", "<init>", "(IJ)V", "getValue", "()I", "getTimer", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PaydayMultiplier {
    @SerializedName("timer")
    private final long timer;
    @SerializedName("value")
    private final int value;

    public PaydayMultiplier() {
        this(0, 0L, 3, null);
    }

    public static /* synthetic */ PaydayMultiplier copy$default(PaydayMultiplier paydayMultiplier, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = paydayMultiplier.value;
        }
        if ((i2 & 2) != 0) {
            j = paydayMultiplier.timer;
        }
        return paydayMultiplier.copy(i, j);
    }

    public final int component1() {
        return this.value;
    }

    public final long component2() {
        return this.timer;
    }

    public final PaydayMultiplier copy(int i, long j) {
        return new PaydayMultiplier(i, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PaydayMultiplier) {
            PaydayMultiplier paydayMultiplier = (PaydayMultiplier) obj;
            return this.value == paydayMultiplier.value && this.timer == paydayMultiplier.timer;
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.value) * 31) + Long.hashCode(this.timer);
    }

    public String toString() {
        int i = this.value;
        return "PaydayMultiplier(value=" + i + ", timer=" + this.timer + ")";
    }

    public PaydayMultiplier(int i, long j) {
        this.value = i;
        this.timer = j;
    }

    public /* synthetic */ PaydayMultiplier(int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1 : i, (i2 & 2) != 0 ? 0L : j);
    }

    public final int getValue() {
        return this.value;
    }

    public final long getTimer() {
        return this.timer;
    }
}
