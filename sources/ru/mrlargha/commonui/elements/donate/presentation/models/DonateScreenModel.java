package ru.mrlargha.commonui.elements.donate.presentation.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DonateScreenModel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u001a\u001a\u00020\u001bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018JV\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010$J\u0014\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010'\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010(\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018¨\u0006)"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/models/DonateScreenModel;", "", "buttonEventName", "", "buttonEventStatus", "", "buttonEventImage", "countMoney", "", "countAzCoins", "getBoostPayment", "freeSpinAvailable", "<init>", "(Ljava/lang/String;IIJIJLjava/lang/Integer;)V", "getButtonEventName", "()Ljava/lang/String;", "getButtonEventStatus", "()I", "getButtonEventImage", "getCountMoney", "()J", "getCountAzCoins", "getGetBoostPayment", "getFreeSpinAvailable", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "isShowButtonEventStatus", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;IIJIJLjava/lang/Integer;)Lru/mrlargha/commonui/elements/donate/presentation/models/DonateScreenModel;", "equals", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DonateScreenModel {
    private final int buttonEventImage;
    private final String buttonEventName;
    private final int buttonEventStatus;
    @SerializedName("countDonate")
    private final int countAzCoins;
    private final long countMoney;
    private final Integer freeSpinAvailable;
    private final long getBoostPayment;

    public static /* synthetic */ DonateScreenModel copy$default(DonateScreenModel donateScreenModel, String str, int i, int i2, long j, int i3, long j2, Integer num, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = donateScreenModel.buttonEventName;
        }
        if ((i4 & 2) != 0) {
            i = donateScreenModel.buttonEventStatus;
        }
        if ((i4 & 4) != 0) {
            i2 = donateScreenModel.buttonEventImage;
        }
        if ((i4 & 8) != 0) {
            j = donateScreenModel.countMoney;
        }
        if ((i4 & 16) != 0) {
            i3 = donateScreenModel.countAzCoins;
        }
        if ((i4 & 32) != 0) {
            j2 = donateScreenModel.getBoostPayment;
        }
        if ((i4 & 64) != 0) {
            num = donateScreenModel.freeSpinAvailable;
        }
        int i5 = i3;
        long j3 = j;
        int i6 = i2;
        return donateScreenModel.copy(str, i, i6, j3, i5, j2, num);
    }

    public final String component1() {
        return this.buttonEventName;
    }

    public final int component2() {
        return this.buttonEventStatus;
    }

    public final int component3() {
        return this.buttonEventImage;
    }

    public final long component4() {
        return this.countMoney;
    }

    public final int component5() {
        return this.countAzCoins;
    }

    public final long component6() {
        return this.getBoostPayment;
    }

    public final Integer component7() {
        return this.freeSpinAvailable;
    }

    public final DonateScreenModel copy(String buttonEventName, int i, int i2, long j, int i3, long j2, Integer num) {
        Intrinsics.checkNotNullParameter(buttonEventName, "buttonEventName");
        return new DonateScreenModel(buttonEventName, i, i2, j, i3, j2, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonateScreenModel) {
            DonateScreenModel donateScreenModel = (DonateScreenModel) obj;
            return Intrinsics.areEqual(this.buttonEventName, donateScreenModel.buttonEventName) && this.buttonEventStatus == donateScreenModel.buttonEventStatus && this.buttonEventImage == donateScreenModel.buttonEventImage && this.countMoney == donateScreenModel.countMoney && this.countAzCoins == donateScreenModel.countAzCoins && this.getBoostPayment == donateScreenModel.getBoostPayment && Intrinsics.areEqual(this.freeSpinAvailable, donateScreenModel.freeSpinAvailable);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.buttonEventName.hashCode() * 31) + Integer.hashCode(this.buttonEventStatus)) * 31) + Integer.hashCode(this.buttonEventImage)) * 31) + Long.hashCode(this.countMoney)) * 31) + Integer.hashCode(this.countAzCoins)) * 31) + Long.hashCode(this.getBoostPayment)) * 31;
        Integer num = this.freeSpinAvailable;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        String str = this.buttonEventName;
        int i = this.buttonEventStatus;
        int i2 = this.buttonEventImage;
        long j = this.countMoney;
        int i3 = this.countAzCoins;
        long j2 = this.getBoostPayment;
        return "DonateScreenModel(buttonEventName=" + str + ", buttonEventStatus=" + i + ", buttonEventImage=" + i2 + ", countMoney=" + j + ", countAzCoins=" + i3 + ", getBoostPayment=" + j2 + ", freeSpinAvailable=" + this.freeSpinAvailable + ")";
    }

    public DonateScreenModel(String buttonEventName, int i, int i2, long j, int i3, long j2, Integer num) {
        Intrinsics.checkNotNullParameter(buttonEventName, "buttonEventName");
        this.buttonEventName = buttonEventName;
        this.buttonEventStatus = i;
        this.buttonEventImage = i2;
        this.countMoney = j;
        this.countAzCoins = i3;
        this.getBoostPayment = j2;
        this.freeSpinAvailable = num;
    }

    public final String getButtonEventName() {
        return this.buttonEventName;
    }

    public final int getButtonEventStatus() {
        return this.buttonEventStatus;
    }

    public final int getButtonEventImage() {
        return this.buttonEventImage;
    }

    public final long getCountMoney() {
        return this.countMoney;
    }

    public final int getCountAzCoins() {
        return this.countAzCoins;
    }

    public final long getGetBoostPayment() {
        return this.getBoostPayment;
    }

    public final Integer getFreeSpinAvailable() {
        return this.freeSpinAvailable;
    }

    public final boolean isShowButtonEventStatus() {
        return this.buttonEventStatus == 1;
    }
}
