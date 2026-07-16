package ru.mrlargha.commonui.elements.dialogs;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DialogBankTaxPayment.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\f\b\u0001\u0010\u0002\u001a\u00020\u0003:\u0002\b\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J5\u0010\u0015\u001a\u00020\u00002\f\b\u0003\u0010\u0002\u001a\u00020\u0003:\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001b"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/TaxPaymentVisual;", "", "titleRes", "", "Landroidx/annotation/StringRes;", "badge", "", "mainColor", "secondColor", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitleRes", "()I", "getBadge", "()Ljava/lang/String;", "getMainColor", "getSecondColor", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
final class TaxPaymentVisual {
    private final String badge;
    private final String mainColor;
    private final String secondColor;
    private final int titleRes;

    public static /* synthetic */ TaxPaymentVisual copy$default(TaxPaymentVisual taxPaymentVisual, int i, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = taxPaymentVisual.titleRes;
        }
        if ((i2 & 2) != 0) {
            str = taxPaymentVisual.badge;
        }
        if ((i2 & 4) != 0) {
            str2 = taxPaymentVisual.mainColor;
        }
        if ((i2 & 8) != 0) {
            str3 = taxPaymentVisual.secondColor;
        }
        return taxPaymentVisual.copy(i, str, str2, str3);
    }

    public final int component1() {
        return this.titleRes;
    }

    public final String component2() {
        return this.badge;
    }

    public final String component3() {
        return this.mainColor;
    }

    public final String component4() {
        return this.secondColor;
    }

    public final TaxPaymentVisual copy(int i, String badge, String mainColor, String secondColor) {
        Intrinsics.checkNotNullParameter(badge, "badge");
        Intrinsics.checkNotNullParameter(mainColor, "mainColor");
        Intrinsics.checkNotNullParameter(secondColor, "secondColor");
        return new TaxPaymentVisual(i, badge, mainColor, secondColor);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TaxPaymentVisual) {
            TaxPaymentVisual taxPaymentVisual = (TaxPaymentVisual) obj;
            return this.titleRes == taxPaymentVisual.titleRes && Intrinsics.areEqual(this.badge, taxPaymentVisual.badge) && Intrinsics.areEqual(this.mainColor, taxPaymentVisual.mainColor) && Intrinsics.areEqual(this.secondColor, taxPaymentVisual.secondColor);
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.titleRes) * 31) + this.badge.hashCode()) * 31) + this.mainColor.hashCode()) * 31) + this.secondColor.hashCode();
    }

    public String toString() {
        int i = this.titleRes;
        String str = this.badge;
        String str2 = this.mainColor;
        return "TaxPaymentVisual(titleRes=" + i + ", badge=" + str + ", mainColor=" + str2 + ", secondColor=" + this.secondColor + ")";
    }

    public TaxPaymentVisual(int i, String badge, String mainColor, String secondColor) {
        Intrinsics.checkNotNullParameter(badge, "badge");
        Intrinsics.checkNotNullParameter(mainColor, "mainColor");
        Intrinsics.checkNotNullParameter(secondColor, "secondColor");
        this.titleRes = i;
        this.badge = badge;
        this.mainColor = mainColor;
        this.secondColor = secondColor;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    public final String getBadge() {
        return this.badge;
    }

    public final String getMainColor() {
        return this.mainColor;
    }

    public final String getSecondColor() {
        return this.secondColor;
    }
}
