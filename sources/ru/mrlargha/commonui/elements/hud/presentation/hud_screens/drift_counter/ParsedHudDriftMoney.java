package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.drift_counter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HudDriftCounterData.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/drift_counter/ParsedHudDriftMoney;", "", "data", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/drift_counter/HudDriftMoneyData;", "timerProvided", "", "<init>", "(Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/drift_counter/HudDriftMoneyData;Z)V", "getData", "()Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/drift_counter/HudDriftMoneyData;", "getTimerProvided", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ParsedHudDriftMoney {
    private final HudDriftMoneyData data;
    private final boolean timerProvided;

    public static /* synthetic */ ParsedHudDriftMoney copy$default(ParsedHudDriftMoney parsedHudDriftMoney, HudDriftMoneyData hudDriftMoneyData, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            hudDriftMoneyData = parsedHudDriftMoney.data;
        }
        if ((i & 2) != 0) {
            z = parsedHudDriftMoney.timerProvided;
        }
        return parsedHudDriftMoney.copy(hudDriftMoneyData, z);
    }

    public final HudDriftMoneyData component1() {
        return this.data;
    }

    public final boolean component2() {
        return this.timerProvided;
    }

    public final ParsedHudDriftMoney copy(HudDriftMoneyData data, boolean z) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new ParsedHudDriftMoney(data, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ParsedHudDriftMoney) {
            ParsedHudDriftMoney parsedHudDriftMoney = (ParsedHudDriftMoney) obj;
            return Intrinsics.areEqual(this.data, parsedHudDriftMoney.data) && this.timerProvided == parsedHudDriftMoney.timerProvided;
        }
        return false;
    }

    public int hashCode() {
        return (this.data.hashCode() * 31) + Boolean.hashCode(this.timerProvided);
    }

    public String toString() {
        HudDriftMoneyData hudDriftMoneyData = this.data;
        return "ParsedHudDriftMoney(data=" + hudDriftMoneyData + ", timerProvided=" + this.timerProvided + ")";
    }

    public ParsedHudDriftMoney(HudDriftMoneyData data, boolean z) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.timerProvided = z;
    }

    public final HudDriftMoneyData getData() {
        return this.data;
    }

    public final boolean getTimerProvided() {
        return this.timerProvided;
    }
}
