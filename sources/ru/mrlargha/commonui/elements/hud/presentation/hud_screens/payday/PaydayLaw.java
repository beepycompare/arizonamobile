package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.payday;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayLaw;", "", "currentValue", "", "maxValue", "income", "<init>", "(III)V", "getCurrentValue", "()I", "getMaxValue", "getIncome", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PaydayLaw {
    @SerializedName("currentValue")
    private final int currentValue;
    @SerializedName("income")
    private final int income;
    @SerializedName("maxValue")
    private final int maxValue;

    public PaydayLaw() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ PaydayLaw copy$default(PaydayLaw paydayLaw, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = paydayLaw.currentValue;
        }
        if ((i4 & 2) != 0) {
            i2 = paydayLaw.maxValue;
        }
        if ((i4 & 4) != 0) {
            i3 = paydayLaw.income;
        }
        return paydayLaw.copy(i, i2, i3);
    }

    public final int component1() {
        return this.currentValue;
    }

    public final int component2() {
        return this.maxValue;
    }

    public final int component3() {
        return this.income;
    }

    public final PaydayLaw copy(int i, int i2, int i3) {
        return new PaydayLaw(i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PaydayLaw) {
            PaydayLaw paydayLaw = (PaydayLaw) obj;
            return this.currentValue == paydayLaw.currentValue && this.maxValue == paydayLaw.maxValue && this.income == paydayLaw.income;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.currentValue) * 31) + Integer.hashCode(this.maxValue)) * 31) + Integer.hashCode(this.income);
    }

    public String toString() {
        int i = this.currentValue;
        int i2 = this.maxValue;
        return "PaydayLaw(currentValue=" + i + ", maxValue=" + i2 + ", income=" + this.income + ")";
    }

    public PaydayLaw(int i, int i2, int i3) {
        this.currentValue = i;
        this.maxValue = i2;
        this.income = i3;
    }

    public /* synthetic */ PaydayLaw(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
    }

    public final int getCurrentValue() {
        return this.currentValue;
    }

    public final int getMaxValue() {
        return this.maxValue;
    }

    public final int getIncome() {
        return this.income;
    }
}
