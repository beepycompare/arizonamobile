package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.payday;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003JV\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010&J\u0014\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010*\u001a\u00020\bHÖ\u0081\u0004J\n\u0010+\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0011\u0010\u001b\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006,"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayFraction;", "", RemoteConfigConstants.ResponseFieldKey.STATE, "", "name", "income", "", "percent", "", "percentFloat", "", "multiplier", "debuffType", "<init>", "(Ljava/lang/String;Ljava/lang/String;JILjava/lang/Float;ILjava/lang/String;)V", "getState", "()Ljava/lang/String;", "getName", "getIncome", "()J", "getPercent", "()I", "getPercentFloat", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getMultiplier", "getDebuffType", "actualPercent", "getActualPercent", "()F", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;JILjava/lang/Float;ILjava/lang/String;)Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayFraction;", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
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
    @SerializedName("percentFloat")
    private final Float percentFloat;
    @SerializedName(RemoteConfigConstants.ResponseFieldKey.STATE)
    private final String state;

    public PaydayFraction() {
        this(null, null, 0L, 0, null, 0, null, 127, null);
    }

    public static /* synthetic */ PaydayFraction copy$default(PaydayFraction paydayFraction, String str, String str2, long j, int i, Float f, int i2, String str3, int i3, Object obj) {
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
            f = paydayFraction.percentFloat;
        }
        if ((i3 & 32) != 0) {
            i2 = paydayFraction.multiplier;
        }
        if ((i3 & 64) != 0) {
            str3 = paydayFraction.debuffType;
        }
        long j2 = j;
        return paydayFraction.copy(str, str2, j2, i, f, i2, str3);
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

    public final Float component5() {
        return this.percentFloat;
    }

    public final int component6() {
        return this.multiplier;
    }

    public final String component7() {
        return this.debuffType;
    }

    public final PaydayFraction copy(String state, String name, long j, int i, Float f, int i2, String debuffType) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(debuffType, "debuffType");
        return new PaydayFraction(state, name, j, i, f, i2, debuffType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PaydayFraction) {
            PaydayFraction paydayFraction = (PaydayFraction) obj;
            return Intrinsics.areEqual(this.state, paydayFraction.state) && Intrinsics.areEqual(this.name, paydayFraction.name) && this.income == paydayFraction.income && this.percent == paydayFraction.percent && Intrinsics.areEqual((Object) this.percentFloat, (Object) paydayFraction.percentFloat) && this.multiplier == paydayFraction.multiplier && Intrinsics.areEqual(this.debuffType, paydayFraction.debuffType);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((this.state.hashCode() * 31) + this.name.hashCode()) * 31) + Long.hashCode(this.income)) * 31) + Integer.hashCode(this.percent)) * 31;
        Float f = this.percentFloat;
        return ((((hashCode + (f == null ? 0 : f.hashCode())) * 31) + Integer.hashCode(this.multiplier)) * 31) + this.debuffType.hashCode();
    }

    public String toString() {
        String str = this.state;
        String str2 = this.name;
        long j = this.income;
        int i = this.percent;
        Float f = this.percentFloat;
        int i2 = this.multiplier;
        return "PaydayFraction(state=" + str + ", name=" + str2 + ", income=" + j + ", percent=" + i + ", percentFloat=" + f + ", multiplier=" + i2 + ", debuffType=" + this.debuffType + ")";
    }

    public PaydayFraction(String state, String name, long j, int i, Float f, int i2, String debuffType) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(debuffType, "debuffType");
        this.state = state;
        this.name = name;
        this.income = j;
        this.percent = i;
        this.percentFloat = f;
        this.multiplier = i2;
        this.debuffType = debuffType;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ PaydayFraction(String str, String str2, long j, int i, Float f, int i2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j, r9, r10, r11, r12);
        String str4;
        int i4;
        int i5;
        Float f2;
        str = (i3 & 1) != 0 ? "noFraction" : str;
        str2 = (i3 & 2) != 0 ? "" : str2;
        j = (i3 & 4) != 0 ? 0L : j;
        i = (i3 & 8) != 0 ? 0 : i;
        f = (i3 & 16) != 0 ? null : f;
        i2 = (i3 & 32) != 0 ? 0 : i2;
        if ((i3 & 64) != 0) {
            str4 = "";
            f2 = f;
            i4 = i2;
            i5 = i;
        } else {
            str4 = str3;
            i4 = i2;
            i5 = i;
            f2 = f;
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

    public final Float getPercentFloat() {
        return this.percentFloat;
    }

    public final int getMultiplier() {
        return this.multiplier;
    }

    public final String getDebuffType() {
        return this.debuffType;
    }

    public final float getActualPercent() {
        Float f = this.percentFloat;
        return f != null ? f.floatValue() : this.percent;
    }
}
