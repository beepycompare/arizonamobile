package com.arizonagames.feature.arizona.bank.pages;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankCurrencyCatalog.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BÅ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\b\u0001\u0010\u0004\u001a\u00020\u0003:\u0002\b\u0005\u0012\f\b\u0001\u0010\u0006\u001a\u00020\u0003:\u0002\b\u0007\u0012\u000e\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\u0002\b\t\u0012\f\b\u0001\u0010\n\u001a\u00020\u0003:\u0002\b\t\u0012\f\b\u0001\u0010\u000b\u001a\u00020\u0003:\u0002\b\t\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\f\b\u0001\u0010\r\u001a\u00020\u0003:\u0002\b\t\u0012\f\b\u0001\u0010\u000e\u001a\u00020\u0003:\u0002\b\t\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\f\b\u0001\u0010\u0010\u001a\u00020\u0003:\u0002\b\t\u0012\f\b\u0001\u0010\u0011\u001a\u00020\u0003:\u0002\b\t\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0013HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0013HÆ\u0003J\u000f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017HÆ\u0003JÚ\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\b\u0003\u0010\u0004\u001a\u00020\u0003:\u0002\b\u00052\f\b\u0003\u0010\u0006\u001a\u00020\u0003:\u0002\b\u00072\u000e\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\u0002\b\t2\f\b\u0003\u0010\n\u001a\u00020\u0003:\u0002\b\t2\f\b\u0003\u0010\u000b\u001a\u00020\u0003:\u0002\b\t2\b\b\u0002\u0010\f\u001a\u00020\u00032\f\b\u0003\u0010\r\u001a\u00020\u0003:\u0002\b\t2\f\b\u0003\u0010\u000e\u001a\u00020\u0003:\u0002\b\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\f\b\u0003\u0010\u0010\u001a\u00020\u0003:\u0002\b\t2\f\b\u0003\u0010\u0011\u001a\u00020\u0003:\u0002\b\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00132\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017HÆ\u0001¢\u0006\u0002\u0010@J\u0014\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010D\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010E\u001a\u00020FHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\u0002\b\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u001b\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\u0002\b\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u001f\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\u0002\b\t¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\u0002\b\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u001b\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\u0002\b\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u001b\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\u0002\b\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u001b\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\u0002\b\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u001b\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\u0002\b\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u001b\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\u0002\b\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001bR\u0011\u0010\u0015\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b,\u0010*R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u0006G"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/pages/BankCurrencySpec;", "", "id", "", "titleResId", "Landroidx/annotation/StringRes;", "iconResId", "Landroidx/annotation/DrawableRes;", "iconTintColor", "Landroidx/annotation/ColorInt;", "mainColor", "secondColor", "gradientAngle", "priceBadgeColor", "softPanelColor", "softPanelAlpha", "unselectedTabTextColor", "availableTextColor", "fallbackPrice", "", "fallbackPercent", "fallbackAvailableMoney", "fallbackHistory", "", "<init>", "(IIILjava/lang/Integer;IIIIIIIIJIJLjava/util/List;)V", "getId", "()I", "getTitleResId", "getIconResId", "getIconTintColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMainColor", "getSecondColor", "getGradientAngle", "getPriceBadgeColor", "getSoftPanelColor", "getSoftPanelAlpha", "getUnselectedTabTextColor", "getAvailableTextColor", "getFallbackPrice", "()J", "getFallbackPercent", "getFallbackAvailableMoney", "getFallbackHistory", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(IIILjava/lang/Integer;IIIIIIIIJIJLjava/util/List;)Lcom/arizonagames/feature/arizona/bank/pages/BankCurrencySpec;", "equals", "", "other", "hashCode", "toString", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankCurrencySpec {
    private final int availableTextColor;
    private final long fallbackAvailableMoney;
    private final List<Long> fallbackHistory;
    private final int fallbackPercent;
    private final long fallbackPrice;
    private final int gradientAngle;
    private final int iconResId;
    private final Integer iconTintColor;
    private final int id;
    private final int mainColor;
    private final int priceBadgeColor;
    private final int secondColor;
    private final int softPanelAlpha;
    private final int softPanelColor;
    private final int titleResId;
    private final int unselectedTabTextColor;

    public static /* synthetic */ BankCurrencySpec copy$default(BankCurrencySpec bankCurrencySpec, int i, int i2, int i3, Integer num, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, long j, int i12, long j2, List list, int i13, Object obj) {
        List<Long> list2;
        long j3;
        int i14 = (i13 & 1) != 0 ? bankCurrencySpec.id : i;
        int i15 = (i13 & 2) != 0 ? bankCurrencySpec.titleResId : i2;
        int i16 = (i13 & 4) != 0 ? bankCurrencySpec.iconResId : i3;
        Integer num2 = (i13 & 8) != 0 ? bankCurrencySpec.iconTintColor : num;
        int i17 = (i13 & 16) != 0 ? bankCurrencySpec.mainColor : i4;
        int i18 = (i13 & 32) != 0 ? bankCurrencySpec.secondColor : i5;
        int i19 = (i13 & 64) != 0 ? bankCurrencySpec.gradientAngle : i6;
        int i20 = (i13 & 128) != 0 ? bankCurrencySpec.priceBadgeColor : i7;
        int i21 = (i13 & 256) != 0 ? bankCurrencySpec.softPanelColor : i8;
        int i22 = (i13 & 512) != 0 ? bankCurrencySpec.softPanelAlpha : i9;
        int i23 = (i13 & 1024) != 0 ? bankCurrencySpec.unselectedTabTextColor : i10;
        int i24 = (i13 & 2048) != 0 ? bankCurrencySpec.availableTextColor : i11;
        long j4 = (i13 & 4096) != 0 ? bankCurrencySpec.fallbackPrice : j;
        int i25 = i14;
        int i26 = (i13 & 8192) != 0 ? bankCurrencySpec.fallbackPercent : i12;
        long j5 = (i13 & 16384) != 0 ? bankCurrencySpec.fallbackAvailableMoney : j2;
        if ((i13 & 32768) != 0) {
            j3 = j5;
            list2 = bankCurrencySpec.fallbackHistory;
        } else {
            list2 = list;
            j3 = j5;
        }
        return bankCurrencySpec.copy(i25, i15, i16, num2, i17, i18, i19, i20, i21, i22, i23, i24, j4, i26, j3, list2);
    }

    public final int component1() {
        return this.id;
    }

    public final int component10() {
        return this.softPanelAlpha;
    }

    public final int component11() {
        return this.unselectedTabTextColor;
    }

    public final int component12() {
        return this.availableTextColor;
    }

    public final long component13() {
        return this.fallbackPrice;
    }

    public final int component14() {
        return this.fallbackPercent;
    }

    public final long component15() {
        return this.fallbackAvailableMoney;
    }

    public final List<Long> component16() {
        return this.fallbackHistory;
    }

    public final int component2() {
        return this.titleResId;
    }

    public final int component3() {
        return this.iconResId;
    }

    public final Integer component4() {
        return this.iconTintColor;
    }

    public final int component5() {
        return this.mainColor;
    }

    public final int component6() {
        return this.secondColor;
    }

    public final int component7() {
        return this.gradientAngle;
    }

    public final int component8() {
        return this.priceBadgeColor;
    }

    public final int component9() {
        return this.softPanelColor;
    }

    public final BankCurrencySpec copy(int i, int i2, int i3, Integer num, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, long j, int i12, long j2, List<Long> fallbackHistory) {
        Intrinsics.checkNotNullParameter(fallbackHistory, "fallbackHistory");
        return new BankCurrencySpec(i, i2, i3, num, i4, i5, i6, i7, i8, i9, i10, i11, j, i12, j2, fallbackHistory);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankCurrencySpec) {
            BankCurrencySpec bankCurrencySpec = (BankCurrencySpec) obj;
            return this.id == bankCurrencySpec.id && this.titleResId == bankCurrencySpec.titleResId && this.iconResId == bankCurrencySpec.iconResId && Intrinsics.areEqual(this.iconTintColor, bankCurrencySpec.iconTintColor) && this.mainColor == bankCurrencySpec.mainColor && this.secondColor == bankCurrencySpec.secondColor && this.gradientAngle == bankCurrencySpec.gradientAngle && this.priceBadgeColor == bankCurrencySpec.priceBadgeColor && this.softPanelColor == bankCurrencySpec.softPanelColor && this.softPanelAlpha == bankCurrencySpec.softPanelAlpha && this.unselectedTabTextColor == bankCurrencySpec.unselectedTabTextColor && this.availableTextColor == bankCurrencySpec.availableTextColor && this.fallbackPrice == bankCurrencySpec.fallbackPrice && this.fallbackPercent == bankCurrencySpec.fallbackPercent && this.fallbackAvailableMoney == bankCurrencySpec.fallbackAvailableMoney && Intrinsics.areEqual(this.fallbackHistory, bankCurrencySpec.fallbackHistory);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.titleResId)) * 31) + Integer.hashCode(this.iconResId)) * 31;
        Integer num = this.iconTintColor;
        return ((((((((((((((((((((((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + Integer.hashCode(this.mainColor)) * 31) + Integer.hashCode(this.secondColor)) * 31) + Integer.hashCode(this.gradientAngle)) * 31) + Integer.hashCode(this.priceBadgeColor)) * 31) + Integer.hashCode(this.softPanelColor)) * 31) + Integer.hashCode(this.softPanelAlpha)) * 31) + Integer.hashCode(this.unselectedTabTextColor)) * 31) + Integer.hashCode(this.availableTextColor)) * 31) + Long.hashCode(this.fallbackPrice)) * 31) + Integer.hashCode(this.fallbackPercent)) * 31) + Long.hashCode(this.fallbackAvailableMoney)) * 31) + this.fallbackHistory.hashCode();
    }

    public String toString() {
        int i = this.id;
        int i2 = this.titleResId;
        int i3 = this.iconResId;
        Integer num = this.iconTintColor;
        int i4 = this.mainColor;
        int i5 = this.secondColor;
        int i6 = this.gradientAngle;
        int i7 = this.priceBadgeColor;
        int i8 = this.softPanelColor;
        int i9 = this.softPanelAlpha;
        int i10 = this.unselectedTabTextColor;
        int i11 = this.availableTextColor;
        long j = this.fallbackPrice;
        int i12 = this.fallbackPercent;
        long j2 = this.fallbackAvailableMoney;
        return "BankCurrencySpec(id=" + i + ", titleResId=" + i2 + ", iconResId=" + i3 + ", iconTintColor=" + num + ", mainColor=" + i4 + ", secondColor=" + i5 + ", gradientAngle=" + i6 + ", priceBadgeColor=" + i7 + ", softPanelColor=" + i8 + ", softPanelAlpha=" + i9 + ", unselectedTabTextColor=" + i10 + ", availableTextColor=" + i11 + ", fallbackPrice=" + j + ", fallbackPercent=" + i12 + ", fallbackAvailableMoney=" + j2 + ", fallbackHistory=" + this.fallbackHistory + ")";
    }

    public BankCurrencySpec(int i, int i2, int i3, Integer num, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, long j, int i12, long j2, List<Long> fallbackHistory) {
        Intrinsics.checkNotNullParameter(fallbackHistory, "fallbackHistory");
        this.id = i;
        this.titleResId = i2;
        this.iconResId = i3;
        this.iconTintColor = num;
        this.mainColor = i4;
        this.secondColor = i5;
        this.gradientAngle = i6;
        this.priceBadgeColor = i7;
        this.softPanelColor = i8;
        this.softPanelAlpha = i9;
        this.unselectedTabTextColor = i10;
        this.availableTextColor = i11;
        this.fallbackPrice = j;
        this.fallbackPercent = i12;
        this.fallbackAvailableMoney = j2;
        this.fallbackHistory = fallbackHistory;
    }

    public /* synthetic */ BankCurrencySpec(int i, int i2, int i3, Integer num, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, long j, int i12, long j2, List list, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, (i13 & 8) != 0 ? null : num, i4, i5, i6, i7, i8, i9, i10, i11, j, i12, j2, list);
    }

    public final int getId() {
        return this.id;
    }

    public final int getTitleResId() {
        return this.titleResId;
    }

    public final int getIconResId() {
        return this.iconResId;
    }

    public final Integer getIconTintColor() {
        return this.iconTintColor;
    }

    public final int getMainColor() {
        return this.mainColor;
    }

    public final int getSecondColor() {
        return this.secondColor;
    }

    public final int getGradientAngle() {
        return this.gradientAngle;
    }

    public final int getPriceBadgeColor() {
        return this.priceBadgeColor;
    }

    public final int getSoftPanelColor() {
        return this.softPanelColor;
    }

    public final int getSoftPanelAlpha() {
        return this.softPanelAlpha;
    }

    public final int getUnselectedTabTextColor() {
        return this.unselectedTabTextColor;
    }

    public final int getAvailableTextColor() {
        return this.availableTextColor;
    }

    public final long getFallbackPrice() {
        return this.fallbackPrice;
    }

    public final int getFallbackPercent() {
        return this.fallbackPercent;
    }

    public final long getFallbackAvailableMoney() {
        return this.fallbackAvailableMoney;
    }

    public final List<Long> getFallbackHistory() {
        return this.fallbackHistory;
    }
}
