package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.payday;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0007HÆ\u0003J\t\u00102\u001a\u00020\tHÆ\u0003J\t\u00103\u001a\u00020\u000bHÆ\u0003J\t\u00104\u001a\u00020\rHÆ\u0003J\t\u00105\u001a\u00020\u000fHÆ\u0003J\t\u00106\u001a\u00020\u0011HÆ\u0003J\t\u00107\u001a\u00020\u0013HÆ\u0003J\t\u00108\u001a\u00020\u0015HÆ\u0003Jw\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015HÆ\u0001J\u0014\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010=\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010>\u001a\u00020?HÖ\u0081\u0004R%\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R%\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R%\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R%\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR%\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u0092\u0002\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R%\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u0092\u0002\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R%\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004\u0092\u0002\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R%\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004\u0092\u0002\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R%\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004\u0092\u0002\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0010¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R%\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004\u0092\u0002\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0012¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R%\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004\u0092\u0002\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0014¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006@"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayData;", "", "playedToday", "", "playedHour", "incomeMoney", "houseMultiplier", "", "paydayMultiplier", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayMultiplier;", FirebaseAnalytics.Param.LEVEL, "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayLevel;", "deposit", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayDeposit;", "fraction", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayFraction;", "az", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayAz;", "law", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayLaw;", "otherIncome", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayOtherIncome;", "<init>", "(JJJILru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayMultiplier;Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayLevel;Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayDeposit;Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayFraction;Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayAz;Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayLaw;Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayOtherIncome;)V", "getPlayedToday", "()J", "Lcom/google/gson/annotations/SerializedName;", "value", "getPlayedHour", "getIncomeMoney", "getHouseMultiplier", "()I", "getPaydayMultiplier", "()Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayMultiplier;", "getLevel", "()Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayLevel;", "getDeposit", "()Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayDeposit;", "getFraction", "()Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayFraction;", "getAz", "()Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayAz;", "getLaw", "()Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayLaw;", "getOtherIncome", "()Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayOtherIncome;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PaydayData {
    @SerializedName("az")
    private final PaydayAz az;
    @SerializedName("deposit")
    private final PaydayDeposit deposit;
    @SerializedName("fraction")
    private final PaydayFraction fraction;
    @SerializedName("houseMultiplier")
    private final int houseMultiplier;
    @SerializedName("incomeMoney")
    private final long incomeMoney;
    @SerializedName("law")
    private final PaydayLaw law;
    @SerializedName(FirebaseAnalytics.Param.LEVEL)
    private final PaydayLevel level;
    @SerializedName("otherIncome")
    private final PaydayOtherIncome otherIncome;
    @SerializedName("paydayMultiplier")
    private final PaydayMultiplier paydayMultiplier;
    @SerializedName("playedHour")
    private final long playedHour;
    @SerializedName("playedToday")
    private final long playedToday;

    public PaydayData() {
        this(0L, 0L, 0L, 0, null, null, null, null, null, null, null, 2047, null);
    }

    public final long component1() {
        return this.playedToday;
    }

    public final PaydayLaw component10() {
        return this.law;
    }

    public final PaydayOtherIncome component11() {
        return this.otherIncome;
    }

    public final long component2() {
        return this.playedHour;
    }

    public final long component3() {
        return this.incomeMoney;
    }

    public final int component4() {
        return this.houseMultiplier;
    }

    public final PaydayMultiplier component5() {
        return this.paydayMultiplier;
    }

    public final PaydayLevel component6() {
        return this.level;
    }

    public final PaydayDeposit component7() {
        return this.deposit;
    }

    public final PaydayFraction component8() {
        return this.fraction;
    }

    public final PaydayAz component9() {
        return this.az;
    }

    public final PaydayData copy(long j, long j2, long j3, int i, PaydayMultiplier paydayMultiplier, PaydayLevel level, PaydayDeposit deposit, PaydayFraction fraction, PaydayAz az, PaydayLaw law, PaydayOtherIncome otherIncome) {
        Intrinsics.checkNotNullParameter(paydayMultiplier, "paydayMultiplier");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(deposit, "deposit");
        Intrinsics.checkNotNullParameter(fraction, "fraction");
        Intrinsics.checkNotNullParameter(az, "az");
        Intrinsics.checkNotNullParameter(law, "law");
        Intrinsics.checkNotNullParameter(otherIncome, "otherIncome");
        return new PaydayData(j, j2, j3, i, paydayMultiplier, level, deposit, fraction, az, law, otherIncome);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PaydayData) {
            PaydayData paydayData = (PaydayData) obj;
            return this.playedToday == paydayData.playedToday && this.playedHour == paydayData.playedHour && this.incomeMoney == paydayData.incomeMoney && this.houseMultiplier == paydayData.houseMultiplier && Intrinsics.areEqual(this.paydayMultiplier, paydayData.paydayMultiplier) && Intrinsics.areEqual(this.level, paydayData.level) && Intrinsics.areEqual(this.deposit, paydayData.deposit) && Intrinsics.areEqual(this.fraction, paydayData.fraction) && Intrinsics.areEqual(this.az, paydayData.az) && Intrinsics.areEqual(this.law, paydayData.law) && Intrinsics.areEqual(this.otherIncome, paydayData.otherIncome);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((Long.hashCode(this.playedToday) * 31) + Long.hashCode(this.playedHour)) * 31) + Long.hashCode(this.incomeMoney)) * 31) + Integer.hashCode(this.houseMultiplier)) * 31) + this.paydayMultiplier.hashCode()) * 31) + this.level.hashCode()) * 31) + this.deposit.hashCode()) * 31) + this.fraction.hashCode()) * 31) + this.az.hashCode()) * 31) + this.law.hashCode()) * 31) + this.otherIncome.hashCode();
    }

    public String toString() {
        long j = this.playedToday;
        long j2 = this.playedHour;
        long j3 = this.incomeMoney;
        int i = this.houseMultiplier;
        PaydayMultiplier paydayMultiplier = this.paydayMultiplier;
        PaydayLevel paydayLevel = this.level;
        PaydayDeposit paydayDeposit = this.deposit;
        PaydayFraction paydayFraction = this.fraction;
        PaydayAz paydayAz = this.az;
        PaydayLaw paydayLaw = this.law;
        return "PaydayData(playedToday=" + j + ", playedHour=" + j2 + ", incomeMoney=" + j3 + ", houseMultiplier=" + i + ", paydayMultiplier=" + paydayMultiplier + ", level=" + paydayLevel + ", deposit=" + paydayDeposit + ", fraction=" + paydayFraction + ", az=" + paydayAz + ", law=" + paydayLaw + ", otherIncome=" + this.otherIncome + ")";
    }

    public PaydayData(long j, long j2, long j3, int i, PaydayMultiplier paydayMultiplier, PaydayLevel level, PaydayDeposit deposit, PaydayFraction fraction, PaydayAz az, PaydayLaw law, PaydayOtherIncome otherIncome) {
        Intrinsics.checkNotNullParameter(paydayMultiplier, "paydayMultiplier");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(deposit, "deposit");
        Intrinsics.checkNotNullParameter(fraction, "fraction");
        Intrinsics.checkNotNullParameter(az, "az");
        Intrinsics.checkNotNullParameter(law, "law");
        Intrinsics.checkNotNullParameter(otherIncome, "otherIncome");
        this.playedToday = j;
        this.playedHour = j2;
        this.incomeMoney = j3;
        this.houseMultiplier = i;
        this.paydayMultiplier = paydayMultiplier;
        this.level = level;
        this.deposit = deposit;
        this.fraction = fraction;
        this.az = az;
        this.law = law;
        this.otherIncome = otherIncome;
    }

    public final long getPlayedToday() {
        return this.playedToday;
    }

    public final long getPlayedHour() {
        return this.playedHour;
    }

    public final long getIncomeMoney() {
        return this.incomeMoney;
    }

    public final int getHouseMultiplier() {
        return this.houseMultiplier;
    }

    public /* synthetic */ PaydayData(long j, long j2, long j3, int i, PaydayMultiplier paydayMultiplier, PaydayLevel paydayLevel, PaydayDeposit paydayDeposit, PaydayFraction paydayFraction, PaydayAz paydayAz, PaydayLaw paydayLaw, PaydayOtherIncome paydayOtherIncome, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        PaydayOtherIncome paydayOtherIncome2;
        int i3;
        PaydayLaw paydayLaw2;
        PaydayData paydayData;
        long j4;
        long j5;
        long j6;
        PaydayMultiplier paydayMultiplier2;
        PaydayLevel paydayLevel2;
        PaydayDeposit paydayDeposit2;
        PaydayFraction paydayFraction2;
        PaydayAz paydayAz2;
        long j7 = (i2 & 1) != 0 ? 0L : j;
        long j8 = (i2 & 2) != 0 ? 0L : j2;
        long j9 = (i2 & 4) != 0 ? 0L : j3;
        int i4 = (i2 & 8) != 0 ? 1 : i;
        PaydayMultiplier paydayMultiplier3 = (i2 & 16) != 0 ? new PaydayMultiplier(0, 0L, 3, null) : paydayMultiplier;
        PaydayLevel paydayLevel3 = (i2 & 32) != 0 ? new PaydayLevel(0, 0, 0, null, 15, null) : paydayLevel;
        PaydayDeposit paydayDeposit3 = (i2 & 64) != 0 ? new PaydayDeposit(null, 0L, 0, null, false, null, 63, null) : paydayDeposit;
        PaydayFraction paydayFraction3 = (i2 & 128) != 0 ? new PaydayFraction(null, null, 0L, 0, null, 0, null, 127, null) : paydayFraction;
        PaydayAz paydayAz3 = (i2 & 256) != 0 ? new PaydayAz(0L, 0L, 3, null) : paydayAz;
        PaydayLaw paydayLaw3 = (i2 & 512) != 0 ? new PaydayLaw(0, 0, 0, 7, null) : paydayLaw;
        if ((i2 & 1024) != 0) {
            i3 = i4;
            paydayLaw2 = paydayLaw3;
            paydayOtherIncome2 = new PaydayOtherIncome(0L, 1, null);
            j4 = j7;
            j5 = j8;
            j6 = j9;
            paydayMultiplier2 = paydayMultiplier3;
            paydayLevel2 = paydayLevel3;
            paydayDeposit2 = paydayDeposit3;
            paydayFraction2 = paydayFraction3;
            paydayAz2 = paydayAz3;
            paydayData = this;
        } else {
            paydayOtherIncome2 = paydayOtherIncome;
            i3 = i4;
            paydayLaw2 = paydayLaw3;
            paydayData = this;
            j4 = j7;
            j5 = j8;
            j6 = j9;
            paydayMultiplier2 = paydayMultiplier3;
            paydayLevel2 = paydayLevel3;
            paydayDeposit2 = paydayDeposit3;
            paydayFraction2 = paydayFraction3;
            paydayAz2 = paydayAz3;
        }
        new PaydayData(j4, j5, j6, i3, paydayMultiplier2, paydayLevel2, paydayDeposit2, paydayFraction2, paydayAz2, paydayLaw2, paydayOtherIncome2);
    }

    public final PaydayMultiplier getPaydayMultiplier() {
        return this.paydayMultiplier;
    }

    public final PaydayLevel getLevel() {
        return this.level;
    }

    public final PaydayDeposit getDeposit() {
        return this.deposit;
    }

    public final PaydayFraction getFraction() {
        return this.fraction;
    }

    public final PaydayAz getAz() {
        return this.az;
    }

    public final PaydayLaw getLaw() {
        return this.law;
    }

    public final PaydayOtherIncome getOtherIncome() {
        return this.otherIncome;
    }
}
