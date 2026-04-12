package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.payday;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020\bHÖ\u0081\u0004J\n\u0010!\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006\""}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayFraction;", "", RemoteConfigConstants.ResponseFieldKey.STATE, "", "name", "income", "", "percent", "", "multiplier", "debuffType", "<init>", "(Ljava/lang/String;Ljava/lang/String;JIILjava/lang/String;)V", "getState", "()Ljava/lang/String;", "getName", "getIncome", "()J", "getPercent", "()I", "getMultiplier", "getDebuffType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PaydayFraction {
    @SerializedName("g_debuff_strType")
    private final String debuffType;
    @SerializedName("income")
    private final long income;
    @SerializedName("multiplier")
    private final int multiplier;
    @SerializedName("name")
    private final String name;
    @SerializedName("percent")
    private final int percent;
    @SerializedName(RemoteConfigConstants.ResponseFieldKey.STATE)
    private final String state;

    public PaydayFraction() {
        this(null, null, 0L, 0, 0, null, 63, null);
    }

    public static /* synthetic */ PaydayFraction copy$default(PaydayFraction paydayFraction, String str, String str2, long j, int i, int i2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = paydayFraction.state;
        }
        if ((i3 & 2) != 0) {
            str2 = paydayFraction.name;
        }
        if ((i3 & 4) != 0) {
            j = paydayFraction.income;
        }
        if ((i3 & 8) != 0) {
            i = paydayFraction.percent;
        }
        if ((i3 & 16) != 0) {
            i2 = paydayFraction.multiplier;
        }
        if ((i3 & 32) != 0) {
            str3 = paydayFraction.debuffType;
        }
        String str4 = str3;
        int i4 = i;
        long j2 = j;
        return paydayFraction.copy(str, str2, j2, i4, i2, str4);
    }

    public final String component1() {
        return this.state;
    }

    public final String component2() {
        return this.name;
    }

    public final long component3() {
        return this.income;
    }

    public final int component4() {
        return this.percent;
    }

    public final int component5() {
        return this.multiplier;
    }

    public final String component6() {
        return this.debuffType;
    }

    public final PaydayFraction copy(String state, String name, long j, int i, int i2, String debuffType) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(debuffType, "debuffType");
        return new PaydayFraction(state, name, j, i, i2, debuffType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PaydayFraction) {
            PaydayFraction paydayFraction = (PaydayFraction) obj;
            return Intrinsics.areEqual(this.state, paydayFraction.state) && Intrinsics.areEqual(this.name, paydayFraction.name) && this.income == paydayFraction.income && this.percent == paydayFraction.percent && this.multiplier == paydayFraction.multiplier && Intrinsics.areEqual(this.debuffType, paydayFraction.debuffType);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.state.hashCode() * 31) + this.name.hashCode()) * 31) + Long.hashCode(this.income)) * 31) + Integer.hashCode(this.percent)) * 31) + Integer.hashCode(this.multiplier)) * 31) + this.debuffType.hashCode();
    }

    public String toString() {
        String str = this.state;
        String str2 = this.name;
        long j = this.income;
        int i = this.percent;
        int i2 = this.multiplier;
        return "PaydayFraction(state=" + str + ", name=" + str2 + ", income=" + j + ", percent=" + i + ", multiplier=" + i2 + ", debuffType=" + this.debuffType + ")";
    }

    public PaydayFraction(String state, String name, long j, int i, int i2, String debuffType) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(debuffType, "debuffType");
        this.state = state;
        this.name = name;
        this.income = j;
        this.percent = i;
        this.multiplier = i2;
        this.debuffType = debuffType;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ PaydayFraction(String str, String str2, long j, int i, int i2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j, r9, r10, r11);
        String str4;
        int i4;
        int i5;
        str = (i3 & 1) != 0 ? "noFraction" : str;
        str2 = (i3 & 2) != 0 ? "" : str2;
        j = (i3 & 4) != 0 ? 0L : j;
        i = (i3 & 8) != 0 ? 0 : i;
        i2 = (i3 & 16) != 0 ? 0 : i2;
        if ((i3 & 32) != 0) {
            str4 = "";
            i5 = i;
            i4 = i2;
        } else {
            str4 = str3;
            i4 = i2;
            i5 = i;
        }
    }

    public final String getState() {
        return this.state;
    }

    public final String getName() {
        return this.name;
    }

    public final long getIncome() {
        return this.income;
    }

    public final int getPercent() {
        return this.percent;
    }

    public final int getMultiplier() {
        return this.multiplier;
    }

    public final String getDebuffType() {
        return this.debuffType;
    }
}
