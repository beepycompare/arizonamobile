package ru.mrlargha.commonui.elements.dialogs;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DialogPlaceholderModel.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003JS\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0014\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020%HÖ\u0081\u0004J\n\u0010&\u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogPlaceholderModel;", "", FirebaseAnalytics.Event.SEARCH, "", "autofocus", "placeholder", "", "limits", "Lru/mrlargha/commonui/elements/dialogs/DialogWithdrawLimitModel;", "moneyTitle", "findPlayerTitle", "headerInfo", "Lru/mrlargha/commonui/elements/dialogs/DialogInputHeaderInfo;", "<init>", "(ZZLjava/lang/String;Lru/mrlargha/commonui/elements/dialogs/DialogWithdrawLimitModel;Ljava/lang/String;Ljava/lang/String;Lru/mrlargha/commonui/elements/dialogs/DialogInputHeaderInfo;)V", "getSearch", "()Z", "getAutofocus", "getPlaceholder", "()Ljava/lang/String;", "getLimits", "()Lru/mrlargha/commonui/elements/dialogs/DialogWithdrawLimitModel;", "getMoneyTitle", "getFindPlayerTitle", "getHeaderInfo", "()Lru/mrlargha/commonui/elements/dialogs/DialogInputHeaderInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogPlaceholderModel {
    private final boolean autofocus;
    private final String findPlayerTitle;
    private final DialogInputHeaderInfo headerInfo;
    private final DialogWithdrawLimitModel limits;
    private final String moneyTitle;
    private final String placeholder;
    private final boolean search;

    public DialogPlaceholderModel() {
        this(false, false, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ DialogPlaceholderModel copy$default(DialogPlaceholderModel dialogPlaceholderModel, boolean z, boolean z2, String str, DialogWithdrawLimitModel dialogWithdrawLimitModel, String str2, String str3, DialogInputHeaderInfo dialogInputHeaderInfo, int i, Object obj) {
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
            dialogInputHeaderInfo = dialogPlaceholderModel.headerInfo;
        }
        String str4 = str3;
        DialogInputHeaderInfo dialogInputHeaderInfo2 = dialogInputHeaderInfo;
        String str5 = str2;
        String str6 = str;
        return dialogPlaceholderModel.copy(z, z2, str6, dialogWithdrawLimitModel, str5, str4, dialogInputHeaderInfo2);
    }

    public final boolean component1() {
        return this.search;
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

    public final DialogInputHeaderInfo component7() {
        return this.headerInfo;
    }

    public final DialogPlaceholderModel copy(boolean z, boolean z2, String placeholder, DialogWithdrawLimitModel dialogWithdrawLimitModel, String moneyTitle, String findPlayerTitle, DialogInputHeaderInfo dialogInputHeaderInfo) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        Intrinsics.checkNotNullParameter(moneyTitle, "moneyTitle");
        Intrinsics.checkNotNullParameter(findPlayerTitle, "findPlayerTitle");
        return new DialogPlaceholderModel(z, z2, placeholder, dialogWithdrawLimitModel, moneyTitle, findPlayerTitle, dialogInputHeaderInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DialogPlaceholderModel) {
            DialogPlaceholderModel dialogPlaceholderModel = (DialogPlaceholderModel) obj;
            return this.search == dialogPlaceholderModel.search && this.autofocus == dialogPlaceholderModel.autofocus && Intrinsics.areEqual(this.placeholder, dialogPlaceholderModel.placeholder) && Intrinsics.areEqual(this.limits, dialogPlaceholderModel.limits) && Intrinsics.areEqual(this.moneyTitle, dialogPlaceholderModel.moneyTitle) && Intrinsics.areEqual(this.findPlayerTitle, dialogPlaceholderModel.findPlayerTitle) && Intrinsics.areEqual(this.headerInfo, dialogPlaceholderModel.headerInfo);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((Boolean.hashCode(this.search) * 31) + Boolean.hashCode(this.autofocus)) * 31) + this.placeholder.hashCode()) * 31;
        DialogWithdrawLimitModel dialogWithdrawLimitModel = this.limits;
        int hashCode2 = (((((hashCode + (dialogWithdrawLimitModel == null ? 0 : dialogWithdrawLimitModel.hashCode())) * 31) + this.moneyTitle.hashCode()) * 31) + this.findPlayerTitle.hashCode()) * 31;
        DialogInputHeaderInfo dialogInputHeaderInfo = this.headerInfo;
        return hashCode2 + (dialogInputHeaderInfo != null ? dialogInputHeaderInfo.hashCode() : 0);
    }

    public String toString() {
        boolean z = this.search;
        boolean z2 = this.autofocus;
        String str = this.placeholder;
        DialogWithdrawLimitModel dialogWithdrawLimitModel = this.limits;
        String str2 = this.moneyTitle;
        String str3 = this.findPlayerTitle;
        return "DialogPlaceholderModel(search=" + z + ", autofocus=" + z2 + ", placeholder=" + str + ", limits=" + dialogWithdrawLimitModel + ", moneyTitle=" + str2 + ", findPlayerTitle=" + str3 + ", headerInfo=" + this.headerInfo + ")";
    }

    public DialogPlaceholderModel(boolean z, boolean z2, String placeholder, DialogWithdrawLimitModel dialogWithdrawLimitModel, String moneyTitle, String findPlayerTitle, DialogInputHeaderInfo dialogInputHeaderInfo) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        Intrinsics.checkNotNullParameter(moneyTitle, "moneyTitle");
        Intrinsics.checkNotNullParameter(findPlayerTitle, "findPlayerTitle");
        this.search = z;
        this.autofocus = z2;
        this.placeholder = placeholder;
        this.limits = dialogWithdrawLimitModel;
        this.moneyTitle = moneyTitle;
        this.findPlayerTitle = findPlayerTitle;
        this.headerInfo = dialogInputHeaderInfo;
    }

    public /* synthetic */ DialogPlaceholderModel(boolean z, boolean z2, String str, DialogWithdrawLimitModel dialogWithdrawLimitModel, String str2, String str3, DialogInputHeaderInfo dialogInputHeaderInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? null : dialogWithdrawLimitModel, (i & 16) != 0 ? "" : str2, (i & 32) != 0 ? "" : str3, (i & 64) != 0 ? null : dialogInputHeaderInfo);
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

    public final DialogInputHeaderInfo getHeaderInfo() {
        return this.headerInfo;
    }
}
