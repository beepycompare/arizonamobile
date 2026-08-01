package ru.mrlargha.commonui.elements.dialogs;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DialogPlaceholderModel.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\rHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u000fHÆ\u0003Js\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0014\u0010-\u001a\u00020\u00032\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010/\u001a\u000200HÖ\u0081\u0004J\n\u00101\u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 ¨\u00062"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogPlaceholderModel;", "", FirebaseAnalytics.Event.SEARCH, "", "autofocus", "placeholder", "", "limits", "Lru/mrlargha/commonui/elements/dialogs/DialogWithdrawLimitModel;", "moneyTitle", "findPlayerTitle", FirebaseAnalytics.Param.CURRENCY, "currencyRate", "", "headerInfo", "Lru/mrlargha/commonui/elements/dialogs/DialogInputHeaderInfo;", "balanceInfo", "<init>", "(ZZLjava/lang/String;Lru/mrlargha/commonui/elements/dialogs/DialogWithdrawLimitModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLru/mrlargha/commonui/elements/dialogs/DialogInputHeaderInfo;Lru/mrlargha/commonui/elements/dialogs/DialogInputHeaderInfo;)V", "getSearch", "()Z", "getAutofocus", "getPlaceholder", "()Ljava/lang/String;", "getLimits", "()Lru/mrlargha/commonui/elements/dialogs/DialogWithdrawLimitModel;", "getMoneyTitle", "getFindPlayerTitle", "getCurrency", "getCurrencyRate", "()J", "getHeaderInfo", "()Lru/mrlargha/commonui/elements/dialogs/DialogInputHeaderInfo;", "getBalanceInfo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogPlaceholderModel {
    private final boolean autofocus;
    private final DialogInputHeaderInfo balanceInfo;
    private final String currency;
    private final long currencyRate;
    private final String findPlayerTitle;
    private final DialogInputHeaderInfo headerInfo;
    private final DialogWithdrawLimitModel limits;
    private final String moneyTitle;
    private final String placeholder;
    private final boolean search;

    public DialogPlaceholderModel() {
        this(false, false, null, null, null, null, null, 0L, null, null, 1023, null);
    }

    public static /* synthetic */ DialogPlaceholderModel copy$default(DialogPlaceholderModel dialogPlaceholderModel, boolean z, boolean z2, String str, DialogWithdrawLimitModel dialogWithdrawLimitModel, String str2, String str3, String str4, long j, DialogInputHeaderInfo dialogInputHeaderInfo, DialogInputHeaderInfo dialogInputHeaderInfo2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = dialogPlaceholderModel.search;
        }
        if ((i & 2) != 0) {
            z2 = dialogPlaceholderModel.autofocus;
        }
        if ((i & 4) != 0) {
            str = dialogPlaceholderModel.placeholder;
        }
        if ((i & 8) != 0) {
            dialogWithdrawLimitModel = dialogPlaceholderModel.limits;
        }
        if ((i & 16) != 0) {
            str2 = dialogPlaceholderModel.moneyTitle;
        }
        if ((i & 32) != 0) {
            str3 = dialogPlaceholderModel.findPlayerTitle;
        }
        if ((i & 64) != 0) {
            str4 = dialogPlaceholderModel.currency;
        }
        if ((i & 128) != 0) {
            j = dialogPlaceholderModel.currencyRate;
        }
        if ((i & 256) != 0) {
            dialogInputHeaderInfo = dialogPlaceholderModel.headerInfo;
        }
        if ((i & 512) != 0) {
            dialogInputHeaderInfo2 = dialogPlaceholderModel.balanceInfo;
        }
        long j2 = j;
        String str5 = str3;
        String str6 = str4;
        DialogWithdrawLimitModel dialogWithdrawLimitModel2 = dialogWithdrawLimitModel;
        String str7 = str2;
        String str8 = str;
        return dialogPlaceholderModel.copy(z, z2, str8, dialogWithdrawLimitModel2, str7, str5, str6, j2, dialogInputHeaderInfo, dialogInputHeaderInfo2);
    }

    public final boolean component1() {
        return this.search;
    }

    public final DialogInputHeaderInfo component10() {
        return this.balanceInfo;
    }

    public final boolean component2() {
        return this.autofocus;
    }

    public final String component3() {
        return this.placeholder;
    }

    public final DialogWithdrawLimitModel component4() {
        return this.limits;
    }

    public final String component5() {
        return this.moneyTitle;
    }

    public final String component6() {
        return this.findPlayerTitle;
    }

    public final String component7() {
        return this.currency;
    }

    public final long component8() {
        return this.currencyRate;
    }

    public final DialogInputHeaderInfo component9() {
        return this.headerInfo;
    }

    public final DialogPlaceholderModel copy(boolean z, boolean z2, String placeholder, DialogWithdrawLimitModel dialogWithdrawLimitModel, String moneyTitle, String findPlayerTitle, String currency, long j, DialogInputHeaderInfo dialogInputHeaderInfo, DialogInputHeaderInfo dialogInputHeaderInfo2) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        Intrinsics.checkNotNullParameter(moneyTitle, "moneyTitle");
        Intrinsics.checkNotNullParameter(findPlayerTitle, "findPlayerTitle");
        Intrinsics.checkNotNullParameter(currency, "currency");
        return new DialogPlaceholderModel(z, z2, placeholder, dialogWithdrawLimitModel, moneyTitle, findPlayerTitle, currency, j, dialogInputHeaderInfo, dialogInputHeaderInfo2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DialogPlaceholderModel) {
            DialogPlaceholderModel dialogPlaceholderModel = (DialogPlaceholderModel) obj;
            return this.search == dialogPlaceholderModel.search && this.autofocus == dialogPlaceholderModel.autofocus && Intrinsics.areEqual(this.placeholder, dialogPlaceholderModel.placeholder) && Intrinsics.areEqual(this.limits, dialogPlaceholderModel.limits) && Intrinsics.areEqual(this.moneyTitle, dialogPlaceholderModel.moneyTitle) && Intrinsics.areEqual(this.findPlayerTitle, dialogPlaceholderModel.findPlayerTitle) && Intrinsics.areEqual(this.currency, dialogPlaceholderModel.currency) && this.currencyRate == dialogPlaceholderModel.currencyRate && Intrinsics.areEqual(this.headerInfo, dialogPlaceholderModel.headerInfo) && Intrinsics.areEqual(this.balanceInfo, dialogPlaceholderModel.balanceInfo);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((Boolean.hashCode(this.search) * 31) + Boolean.hashCode(this.autofocus)) * 31) + this.placeholder.hashCode()) * 31;
        DialogWithdrawLimitModel dialogWithdrawLimitModel = this.limits;
        int hashCode2 = (((((((((hashCode + (dialogWithdrawLimitModel == null ? 0 : dialogWithdrawLimitModel.hashCode())) * 31) + this.moneyTitle.hashCode()) * 31) + this.findPlayerTitle.hashCode()) * 31) + this.currency.hashCode()) * 31) + Long.hashCode(this.currencyRate)) * 31;
        DialogInputHeaderInfo dialogInputHeaderInfo = this.headerInfo;
        int hashCode3 = (hashCode2 + (dialogInputHeaderInfo == null ? 0 : dialogInputHeaderInfo.hashCode())) * 31;
        DialogInputHeaderInfo dialogInputHeaderInfo2 = this.balanceInfo;
        return hashCode3 + (dialogInputHeaderInfo2 != null ? dialogInputHeaderInfo2.hashCode() : 0);
    }

    public String toString() {
        boolean z = this.search;
        boolean z2 = this.autofocus;
        String str = this.placeholder;
        DialogWithdrawLimitModel dialogWithdrawLimitModel = this.limits;
        String str2 = this.moneyTitle;
        String str3 = this.findPlayerTitle;
        String str4 = this.currency;
        long j = this.currencyRate;
        DialogInputHeaderInfo dialogInputHeaderInfo = this.headerInfo;
        return "DialogPlaceholderModel(search=" + z + ", autofocus=" + z2 + ", placeholder=" + str + ", limits=" + dialogWithdrawLimitModel + ", moneyTitle=" + str2 + ", findPlayerTitle=" + str3 + ", currency=" + str4 + ", currencyRate=" + j + ", headerInfo=" + dialogInputHeaderInfo + ", balanceInfo=" + this.balanceInfo + ")";
    }

    public DialogPlaceholderModel(boolean z, boolean z2, String placeholder, DialogWithdrawLimitModel dialogWithdrawLimitModel, String moneyTitle, String findPlayerTitle, String currency, long j, DialogInputHeaderInfo dialogInputHeaderInfo, DialogInputHeaderInfo dialogInputHeaderInfo2) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        Intrinsics.checkNotNullParameter(moneyTitle, "moneyTitle");
        Intrinsics.checkNotNullParameter(findPlayerTitle, "findPlayerTitle");
        Intrinsics.checkNotNullParameter(currency, "currency");
        this.search = z;
        this.autofocus = z2;
        this.placeholder = placeholder;
        this.limits = dialogWithdrawLimitModel;
        this.moneyTitle = moneyTitle;
        this.findPlayerTitle = findPlayerTitle;
        this.currency = currency;
        this.currencyRate = j;
        this.headerInfo = dialogInputHeaderInfo;
        this.balanceInfo = dialogInputHeaderInfo2;
    }

    public /* synthetic */ DialogPlaceholderModel(boolean z, boolean z2, String str, DialogWithdrawLimitModel dialogWithdrawLimitModel, String str2, String str3, String str4, long j, DialogInputHeaderInfo dialogInputHeaderInfo, DialogInputHeaderInfo dialogInputHeaderInfo2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? null : dialogWithdrawLimitModel, (i & 16) != 0 ? "" : str2, (i & 32) != 0 ? "" : str3, (i & 64) != 0 ? "" : str4, (i & 128) != 0 ? 0L : j, (i & 256) != 0 ? null : dialogInputHeaderInfo, (i & 512) != 0 ? null : dialogInputHeaderInfo2);
    }

    public final boolean getSearch() {
        return this.search;
    }

    public final boolean getAutofocus() {
        return this.autofocus;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final DialogWithdrawLimitModel getLimits() {
        return this.limits;
    }

    public final String getMoneyTitle() {
        return this.moneyTitle;
    }

    public final String getFindPlayerTitle() {
        return this.findPlayerTitle;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final long getCurrencyRate() {
        return this.currencyRate;
    }

    public final DialogInputHeaderInfo getHeaderInfo() {
        return this.headerInfo;
    }

    public final DialogInputHeaderInfo getBalanceInfo() {
        return this.balanceInfo;
    }
}
