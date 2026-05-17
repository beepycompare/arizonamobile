package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.payday;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003JL\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010%J\u0014\u0010&\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010(\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010)\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0011\u0010\u001b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006*"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayDeposit;", "", RemoteConfigConstants.ResponseFieldKey.STATE, "", "income", "", "percent", "", "percentFloat", "", "hasAgenda", "", "taxWarningProperty", "<init>", "(Ljava/lang/String;JILjava/lang/Float;ZLjava/lang/String;)V", "getState", "()Ljava/lang/String;", "getIncome", "()J", "getPercent", "()I", "getPercentFloat", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getHasAgenda", "()Z", "getTaxWarningProperty", "actualPercent", "getActualPercent", "()F", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;JILjava/lang/Float;ZLjava/lang/String;)Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayDeposit;", "equals", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PaydayDeposit {
    @SerializedName("hasAgenda")
    private final boolean hasAgenda;
    @SerializedName("income")
    private final long income;
    @SerializedName("percent")
    private final int percent;
    @SerializedName("percentFloat")
    private final Float percentFloat;
    @SerializedName(RemoteConfigConstants.ResponseFieldKey.STATE)
    private final String state;
    @SerializedName("taxWarningProperty")
    private final String taxWarningProperty;

    public PaydayDeposit() {
        this(null, 0L, 0, null, false, null, 63, null);
    }

    public static /* synthetic */ PaydayDeposit copy$default(PaydayDeposit paydayDeposit, String str, long j, int i, Float f, boolean z, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = paydayDeposit.state;
        }
        if ((i2 & 2) != 0) {
            j = paydayDeposit.income;
        }
        if ((i2 & 4) != 0) {
            i = paydayDeposit.percent;
        }
        if ((i2 & 8) != 0) {
            f = paydayDeposit.percentFloat;
        }
        if ((i2 & 16) != 0) {
            z = paydayDeposit.hasAgenda;
        }
        if ((i2 & 32) != 0) {
            str2 = paydayDeposit.taxWarningProperty;
        }
        return paydayDeposit.copy(str, j, i, f, z, str2);
    }

    public final String component1() {
        return this.state;
    }

    public final long component2() {
        return this.income;
    }

    public final int component3() {
        return this.percent;
    }

    public final Float component4() {
        return this.percentFloat;
    }

    public final boolean component5() {
        return this.hasAgenda;
    }

    public final String component6() {
        return this.taxWarningProperty;
    }

    public final PaydayDeposit copy(String state, long j, int i, Float f, boolean z, String taxWarningProperty) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(taxWarningProperty, "taxWarningProperty");
        return new PaydayDeposit(state, j, i, f, z, taxWarningProperty);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PaydayDeposit) {
            PaydayDeposit paydayDeposit = (PaydayDeposit) obj;
            return Intrinsics.areEqual(this.state, paydayDeposit.state) && this.income == paydayDeposit.income && this.percent == paydayDeposit.percent && Intrinsics.areEqual((Object) this.percentFloat, (Object) paydayDeposit.percentFloat) && this.hasAgenda == paydayDeposit.hasAgenda && Intrinsics.areEqual(this.taxWarningProperty, paydayDeposit.taxWarningProperty);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.state.hashCode() * 31) + Long.hashCode(this.income)) * 31) + Integer.hashCode(this.percent)) * 31;
        Float f = this.percentFloat;
        return ((((hashCode + (f == null ? 0 : f.hashCode())) * 31) + Boolean.hashCode(this.hasAgenda)) * 31) + this.taxWarningProperty.hashCode();
    }

    public String toString() {
        String str = this.state;
        long j = this.income;
        int i = this.percent;
        Float f = this.percentFloat;
        boolean z = this.hasAgenda;
        return "PaydayDeposit(state=" + str + ", income=" + j + ", percent=" + i + ", percentFloat=" + f + ", hasAgenda=" + z + ", taxWarningProperty=" + this.taxWarningProperty + ")";
    }

    public PaydayDeposit(String state, long j, int i, Float f, boolean z, String taxWarningProperty) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(taxWarningProperty, "taxWarningProperty");
        this.state = state;
        this.income = j;
        this.percent = i;
        this.percentFloat = f;
        this.hasAgenda = z;
        this.taxWarningProperty = taxWarningProperty;
    }

    public /* synthetic */ PaydayDeposit(String str, long j, int i, Float f, boolean z, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "inactive" : str, (i2 & 2) != 0 ? 0L : j, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? null : f, (i2 & 16) != 0 ? false : z, (i2 & 32) != 0 ? "" : str2);
    }

    public final String getState() {
        return this.state;
    }

    public final long getIncome() {
        return this.income;
    }

    public final int getPercent() {
        return this.percent;
    }

    public final Float getPercentFloat() {
        return this.percentFloat;
    }

    public final boolean getHasAgenda() {
        return this.hasAgenda;
    }

    public final String getTaxWarningProperty() {
        return this.taxWarningProperty;
    }

    public final float getActualPercent() {
        Float f = this.percentFloat;
        return f != null ? f.floatValue() : this.percent;
    }
}
