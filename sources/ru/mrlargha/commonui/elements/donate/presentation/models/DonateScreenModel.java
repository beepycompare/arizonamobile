package ru.mrlargha.commonui.elements.donate.presentation.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DonateScreenModel.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006!"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/models/DonateScreenModel;", "", "buttonEventName", "", "buttonEventStatus", "", "buttonEventImage", "countMoney", "countAzCoins", "getBoostPayment", "<init>", "(Ljava/lang/String;IIIII)V", "getButtonEventName", "()Ljava/lang/String;", "getButtonEventStatus", "()I", "getButtonEventImage", "getCountMoney", "getCountAzCoins", "getGetBoostPayment", "isShowButtonEventStatus", "", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateScreenModel {
    private final int buttonEventImage;
    private final String buttonEventName;
    private final int buttonEventStatus;
    @SerializedName("countDonate")
    private final int countAzCoins;
    private final int countMoney;
    private final int getBoostPayment;

    public static /* synthetic */ DonateScreenModel copy$default(DonateScreenModel donateScreenModel, String str, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = donateScreenModel.buttonEventName;
        }
        if ((i6 & 2) != 0) {
            i = donateScreenModel.buttonEventStatus;
        }
        if ((i6 & 4) != 0) {
            i2 = donateScreenModel.buttonEventImage;
        }
        if ((i6 & 8) != 0) {
            i3 = donateScreenModel.countMoney;
        }
        if ((i6 & 16) != 0) {
            i4 = donateScreenModel.countAzCoins;
        }
        if ((i6 & 32) != 0) {
            i5 = donateScreenModel.getBoostPayment;
        }
        int i7 = i4;
        int i8 = i5;
        return donateScreenModel.copy(str, i, i2, i3, i7, i8);
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

    public final int component4() {
        return this.countMoney;
    }

    public final int component5() {
        return this.countAzCoins;
    }

    public final int component6() {
        return this.getBoostPayment;
    }

    public final DonateScreenModel copy(String buttonEventName, int i, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(buttonEventName, "buttonEventName");
        return new DonateScreenModel(buttonEventName, i, i2, i3, i4, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonateScreenModel) {
            DonateScreenModel donateScreenModel = (DonateScreenModel) obj;
            return Intrinsics.areEqual(this.buttonEventName, donateScreenModel.buttonEventName) && this.buttonEventStatus == donateScreenModel.buttonEventStatus && this.buttonEventImage == donateScreenModel.buttonEventImage && this.countMoney == donateScreenModel.countMoney && this.countAzCoins == donateScreenModel.countAzCoins && this.getBoostPayment == donateScreenModel.getBoostPayment;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.buttonEventName.hashCode() * 31) + Integer.hashCode(this.buttonEventStatus)) * 31) + Integer.hashCode(this.buttonEventImage)) * 31) + Integer.hashCode(this.countMoney)) * 31) + Integer.hashCode(this.countAzCoins)) * 31) + Integer.hashCode(this.getBoostPayment);
    }

    public String toString() {
        String str = this.buttonEventName;
        int i = this.buttonEventStatus;
        int i2 = this.buttonEventImage;
        int i3 = this.countMoney;
        int i4 = this.countAzCoins;
        return "DonateScreenModel(buttonEventName=" + str + ", buttonEventStatus=" + i + ", buttonEventImage=" + i2 + ", countMoney=" + i3 + ", countAzCoins=" + i4 + ", getBoostPayment=" + this.getBoostPayment + ")";
    }

    public DonateScreenModel(String buttonEventName, int i, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(buttonEventName, "buttonEventName");
        this.buttonEventName = buttonEventName;
        this.buttonEventStatus = i;
        this.buttonEventImage = i2;
        this.countMoney = i3;
        this.countAzCoins = i4;
        this.getBoostPayment = i5;
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

    public final int getCountMoney() {
        return this.countMoney;
    }

    public final int getCountAzCoins() {
        return this.countAzCoins;
    }

    public final int getGetBoostPayment() {
        return this.getBoostPayment;
    }

    public final boolean isShowButtonEventStatus() {
        return this.buttonEventStatus == 1;
    }
}
