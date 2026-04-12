package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.payday;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayAz;", "", "current", "", "income", "<init>", "(JJ)V", "getCurrent", "()J", "getIncome", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PaydayAz {
    @SerializedName("current")
    private final long current;
    @SerializedName("income")
    private final long income;

    public PaydayAz() {
        this(0L, 0L, 3, null);
    }

    public static /* synthetic */ PaydayAz copy$default(PaydayAz paydayAz, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = paydayAz.current;
        }
        if ((i & 2) != 0) {
            j2 = paydayAz.income;
        }
        return paydayAz.copy(j, j2);
    }

    public final long component1() {
        return this.current;
    }

    public final long component2() {
        return this.income;
    }

    public final PaydayAz copy(long j, long j2) {
        return new PaydayAz(j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PaydayAz) {
            PaydayAz paydayAz = (PaydayAz) obj;
            return this.current == paydayAz.current && this.income == paydayAz.income;
        }
        return false;
    }

    public int hashCode() {
        return (Long.hashCode(this.current) * 31) + Long.hashCode(this.income);
    }

    public String toString() {
        long j = this.current;
        return "PaydayAz(current=" + j + ", income=" + this.income + ")";
    }

    public PaydayAz(long j, long j2) {
        this.current = j;
        this.income = j2;
    }

    public /* synthetic */ PaydayAz(long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2);
    }

    public final long getCurrent() {
        return this.current;
    }

    public final long getIncome() {
        return this.income;
    }
}
