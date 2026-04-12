package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.payday;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayOtherIncome;", "", "income", "", "<init>", "(J)V", "getIncome", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PaydayOtherIncome {
    @SerializedName("income")
    private final long income;

    public PaydayOtherIncome() {
        this(0L, 1, null);
    }

    public static /* synthetic */ PaydayOtherIncome copy$default(PaydayOtherIncome paydayOtherIncome, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = paydayOtherIncome.income;
        }
        return paydayOtherIncome.copy(j);
    }

    public final long component1() {
        return this.income;
    }

    public final PaydayOtherIncome copy(long j) {
        return new PaydayOtherIncome(j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PaydayOtherIncome) && this.income == ((PaydayOtherIncome) obj).income;
    }

    public int hashCode() {
        return Long.hashCode(this.income);
    }

    public String toString() {
        return "PaydayOtherIncome(income=" + this.income + ")";
    }

    public PaydayOtherIncome(long j) {
        this.income = j;
    }

    public /* synthetic */ PaydayOtherIncome(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j);
    }

    public final long getIncome() {
        return this.income;
    }
}
